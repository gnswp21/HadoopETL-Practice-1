package com.aaa.etl;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ex4 {
    public static void go() throws URISyntaxException, IOException {

        Configuration configuration = new Configuration();
        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        FileSystem fs = FileSystem.get(configuration);
//        fs.copyFromLocalFile(false,new Path("src/data/car.csv"),
//                new Path("/user/brio/car.csv"));
        fs.moveFromLocalFile(new Path("src/data/car.csv"),
                new Path("/user/brrrrio/car.csv"));


    }

}
