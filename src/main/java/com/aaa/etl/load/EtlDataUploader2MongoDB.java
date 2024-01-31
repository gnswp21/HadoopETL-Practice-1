package com.aaa.etl.load;

import com.aaa.etl.processor.Kafka2MongoStream;
import com.aaa.etl.processor.Kafka2MysqlBatch;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class EtlDataUploader2MongoDB {
    public static void main(String[] args) throws Exception{
        Kafka2MongoStream stream2Mongo = new Kafka2MongoStream();

        Dataset<Row> df_unempl_month = stream2Mongo.getDataFrame("topic_unemlp_mon");
        stream2Mongo.saveDataFrame2MongoDB(df_unempl_month, "coll_unempl_mon");

        Dataset<Row> df_earn_Construction_month = stream2Mongo.getDataFrame("topic_earn_Construction_mon");
        stream2Mongo.saveDataFrame2MongoDB(df_earn_Construction_month, "coll_earn_Construction_mon");

        Dataset<Row> df_financial_Activities_month = stream2Mongo.getDataFrame("topic_earn_Financial_Activites_mon");
        stream2Mongo.saveDataFrame2MongoDB(df_financial_Activities_month, "coll_earn_Financial_Activites_mon");

        Dataset<Row> df_Goods_Producing_month = stream2Mongo.getDataFrame("topic_earn_Goods_Producing_mon");
        stream2Mongo.saveDataFrame2MongoDB(df_Goods_Producing_month, "coll_earn_Goods_Producing_mon");

        Dataset<Row> df_leisure_and_Hospitality_month = stream2Mongo.getDataFrame("topic_earn_Leisure_and_Hospitality_mon");
        stream2Mongo.saveDataFrame2MongoDB(df_leisure_and_Hospitality_month, "coll_earn_Leisure_and_Hospitality_mon");

        Dataset<Row> df_manufacturing_month = stream2Mongo.getDataFrame("topic_earn_Manufacturing_mon");
        stream2Mongo.saveDataFrame2MongoDB(df_manufacturing_month, "coll_earn_Manufacturing_mon");

        Dataset<Row> df_private_Service_month = stream2Mongo.getDataFrame("topic_earn_Private_Service_mon");
        stream2Mongo.saveDataFrame2MongoDB(df_private_Service_month, "coll_earn_Private_Service_mon");

        Dataset<Row> df_professional_and_Business_Services_month = stream2Mongo.getDataFrame("topic_earn_Professional_and_Business_Services_mon");
        stream2Mongo.saveDataFrame2MongoDB(df_professional_and_Business_Services_month, "coll_earn_Professional_and_Business_Services_mon");

        Dataset<Row> df_transportation_and_Utilities_month = stream2Mongo.getDataFrame("topic_earn_Transportation_and_Utilities_mon");
        stream2Mongo.saveDataFrame2MongoDB(df_transportation_and_Utilities_month, "coll_earn_Transportation_and_Utilities_mon");

        stream2Mongo.getSparkSession().streams().awaitAnyTermination();

    }
}
