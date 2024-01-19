package com.etl.aaa;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.setProperty("HADOOP_CON_DIR", "C:/hadoop-3.3.6/etc/hadoop");

        String HADOOP_CONF_DIR = System.getenv("HADOOP_CONF_DIR");

        Configuration configuration = new Configuration();

        configuration.addResource(new Path("file:///" + HADOOP_CONF_DIR + "/core-site.xml"));
        configuration.addResource(new Path("file:///" + HADOOP_CONF_DIR + "/hdfs-site.xml"));

        Configuration configuration = new Configuration();
    }
}