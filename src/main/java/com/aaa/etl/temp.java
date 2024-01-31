package com.aaa.etl;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;
import org.apache.spark.sql.types.StructType;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class temp {
    public static void main(String[] args) {
        List<Row> rows = Arrays.asList(
                RowFactory.create("father", 35),
                RowFactory.create("mother", 30),
                RowFactory.create("son", 5)
        );

        StructType schema = DataTypes.createStructType(
                new StructField[]{
                        DataTypes.createStructField("name", DataTypes.StringType, false),
                        DataTypes.createStructField("age", DataTypes.IntegerType, false)
                }
        );

        SparkSession spark = SparkSession.builder().appName("Spark SQL Test JAVA").master("local[*]").getOrCreate();
        Dataset<Row> df= spark.createDataFrame(rows, schema);

        df.printSchema();
        df.show();


    }
}
