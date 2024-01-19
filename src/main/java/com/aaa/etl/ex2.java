package com.aaa.etl;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

public class ex2 {
    public static void go() {
        System.setProperty("HADOOP_CON_DIR", "C:/hadoop-3.3.6/etc/hadoop");

        String HADOOP_CONF_DIR = System.getenv("HADOOP_CONF_DIR");

        Configuration configuration = new Configuration();

        configuration.addResource(new Path("file:///" + HADOOP_CONF_DIR + "/core-site.xml"));
        configuration.addResource(new Path("file:///" + HADOOP_CONF_DIR + "/hdfs-site.xml"));


        configuration.set("fs.defaultFS", "hdfs://localhost:9000");
        configuration.set("fs.hdfs.impl", org.apache.hadoop.hdfs.DistributedFileSystem.class.getName());
        configuration.set("fs.file.impl", org.apache.hadoop.fs.LocalFileSystem.class.getName());

        configuration.clear();
    }

}
