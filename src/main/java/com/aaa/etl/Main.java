package com.aaa.etl;

import com.aaa.etl.util.PropertyFileReader;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello world!");
        ex4.go();
        PropertyFileReader.readPropertyFile("/resources/log4j.properties");

    }
}