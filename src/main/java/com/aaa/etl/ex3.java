package com.aaa.etl;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ex3 {
    public static void go() throws URISyntaxException, IOException {
        System.setProperty("HADOOP_CON_DIR", "C:/hadoop-3.3.6/etc/hadoop");

        String HADOOP_CONF_DIR = System.getenv("HADOOP_CONF_DIR");

        Configuration configuration = new Configuration();

        configuration.addResource(new Path("file:///" + HADOOP_CONF_DIR + "/core-site.xml"));
        configuration.addResource(new Path("file:///" + HADOOP_CONF_DIR + "/hdfs-site.xml"));

        String namenode = "hdfs://localhost:9000"; // 하둡의 namenode 주소값

        // hdfs 객체 생성
        FileSystem hadoopFs = FileSystem.get(new URI(namenode), configuration);



    }

}
