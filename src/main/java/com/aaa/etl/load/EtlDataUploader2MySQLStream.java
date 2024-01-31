package com.aaa.etl.load;

import com.aaa.etl.processor.Kafka2MongoStream;
import com.aaa.etl.processor.Kafka2MysqlStream;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class EtlDataUploader2MySQLStream {
    public static void main(String[] args) throws Exception{
        Kafka2MysqlStream stream2Mysql = new Kafka2MysqlStream();

        Dataset<Row> df_unempl_month = stream2Mysql.getDataFrame("topic_unemlp_mon");
        stream2Mysql.saveDataFrame2MySQL(df_unempl_month, "coll_unempl_mon");

//        Dataset<Row> df_earn_Construction_month = stream2Mysql.getDataFrame("topic_earn_Construction_mon");
//        stream2Mysql.saveDataFrame2MySQL(df_earn_Construction_month, "coll_earn_Construction_mon");
//
//        Dataset<Row> df_financial_Activities_month = stream2Mysql.getDataFrame("topic_earn_Financial_Activites_mon");
//        stream2Mysql.saveDataFrame2MySQL(df_financial_Activities_month, "coll_earn_Financial_Activites_mon");


        stream2Mysql.getSparkSession().streams().awaitAnyTermination();

    }
}
