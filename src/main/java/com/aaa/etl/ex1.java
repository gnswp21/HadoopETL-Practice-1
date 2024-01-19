package com.aaa.etl;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;

public class ex1 {
    public static void go() {
        System.setProperty("HADOOP_CON_DIR", "C:/hadoop-3.3.6/etc/hadoop");

        String HADOOP_CONF_DIR = System.getenv("HADOOP_CONF_DIR");

        Configuration configuration = new Configuration();

        configuration.addResource(new Path("file:///" + HADOOP_CONF_DIR + "/core-site.xml"));
        configuration.addResource(new Path("file:///" + HADOOP_CONF_DIR + "/hdfs-site.xml"));
    }

}
