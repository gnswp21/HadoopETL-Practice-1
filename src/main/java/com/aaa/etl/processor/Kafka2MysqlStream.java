package com.aaa.etl.processor;

import com.aaa.etl.pojo.StoredColumnPojo;
import com.aaa.etl.util.PropertyFileReader;
import com.mongodb.spark.MongoSpark;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;
import org.apache.spark.sql.SparkSession;
import scala.Predef;
import scala.collection.JavaConverters;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeoutException;

import static org.apache.spark.sql.functions.*;

public class Kafka2MysqlStream {
    private Properties systemProp;
    private SparkSession spark;

    public Kafka2MysqlStream() throws Exception {
        systemProp = PropertyFileReader.readPropertyFile("SystemConfig.properties");

        String appName = (String)systemProp.get("spark.stream.name");
        spark = SparkSession.builder().master("local[*]").appName(appName).getOrCreate();
    }

    private static <A, B> scala.collection.immutable.Map<A, B> toScalaMap(Map<A, B> m){
        return JavaConverters.mapAsScalaMapConverter(m).asScala().toMap(Predef.$conforms());
    }

    public SparkSession getSparkSession(){
        if(spark != null){
            return spark;
        }
        return null;
    }

    public Dataset<Row> getDataFrame(String kafkaTopic){
        Map<String, String> kafkaParams = new HashMap<>();
        kafkaParams.put("kafka.bootstrap.servers", systemProp.getProperty("kafka.brokerlist"));
        kafkaParams.put("subscribe", kafkaTopic);
        kafkaParams.put("startingOffsets", systemProp.getProperty("kafka.resetType"));

        Dataset<Row> df = spark.readStream().format("kafka")
                .options(kafkaParams)
                .load()
                .selectExpr("CAST(value AS STRING) as column")
                .filter(not(col("column").startsWith("date"))); // date로 시작하지 않는 행만 남는다. -> 헤더 제거

        return df;
    }

    public void saveDataFrame2MySQL(Dataset<Row> df, String table) throws TimeoutException {
        Map<String, String> options = new HashMap<>();

        Dataset<Row> dfs = df.select(from_csv(col("column"), StoredColumnPojo.getStructType()
                        , toScalaMap(options)).as("entityStoredPojo"))
                .selectExpr("entityStoredPojo.date", "entityStoredPojo.value",
                        "entityStoredPojo.id", "entityStoredPojo.title", "entityStoredPojo.state",
                        "entityStoredPojo.frequency_short", "entityStoredPojo.units_short", "entityStoredPojo.seasonal_adjustment_short").toDF();

        dfs.printSchema();


        Properties jdbcProps = new Properties();
        jdbcProps.put("user", systemProp.getProperty("mysql.username"));
        jdbcProps.put("password", systemProp.getProperty("mysql.password"));

        dfs.writeStream().foreachBatch((each_df, batchId) -> {
            each_df.write().mode("append").jdbc((String) systemProp.get("mysql.output.uri"), table, jdbcProps);
        }) ;

    }
}
