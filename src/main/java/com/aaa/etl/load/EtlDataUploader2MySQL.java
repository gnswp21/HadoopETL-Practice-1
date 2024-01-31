package com.aaa.etl.load;

import com.aaa.etl.processor.Kafka2MysqlBatch;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public class EtlDataUploader2MySQL {
    public static void main(String[] args) throws Exception{
        Kafka2MysqlBatch batch_unempl_ann = new Kafka2MysqlBatch();
        Dataset<Row> df_unempl_ann = batch_unempl_ann.getDataframe("topic_unempl_ann");
        batch_unempl_ann.saveDataFrame2MySQLDB(df_unempl_ann, "table_unempl_ann");

        Kafka2MysqlBatch batch_house_income_ann = new Kafka2MysqlBatch();
        Dataset<Row> df_house_income_ann = batch_house_income_ann.getDataframe("topic_house_income_ann");
        batch_house_income_ann.saveDataFrame2MySQLDB(df_house_income_ann, "table_house_income_ann");

        Kafka2MysqlBatch batch_tax_exemp_ann = new Kafka2MysqlBatch();
        Dataset<Row> df_tax_exemp_ann = batch_tax_exemp_ann.getDataframe("topic_tax_exemp_ann");
        batch_tax_exemp_ann.saveDataFrame2MySQLDB(df_tax_exemp_ann, "table_tax_exemp_ann");

        Kafka2MysqlBatch batch_civil_force_ann = new Kafka2MysqlBatch();
        Dataset<Row> df_civil_force_ann = batch_civil_force_ann.getDataframe("topic_civil_force_ann");
        batch_civil_force_ann.saveDataFrame2MySQLDB(df_civil_force_ann, "table_civil_force_ann");

        Kafka2MysqlBatch batch_poverty_ann = new Kafka2MysqlBatch();
        Dataset<Row> df_poverty_ann = batch_poverty_ann.getDataframe("topic_poverty_ann");
        batch_poverty_ann.saveDataFrame2MySQLDB(df_poverty_ann, "table_poverty_ann");

    }
}
