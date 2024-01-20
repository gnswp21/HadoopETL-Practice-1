package com.aaa.etl.load;

import com.aaa.etl.processor.Hdfs2Kafka;

import java.util.Arrays;
import java.util.List;

public class EtlDataUploader2Kafka {
    public static void main(String[] args) throws Exception{

        Hdfs2Kafka hdfs2Kafka = new Hdfs2Kafka();


        List<String> filenames = Arrays.asList(
                "unemployee_annual.csv",
                "unemployee_annual.csv",
                "household_income.csv",
                "tax_exemption.csv",
                "civilian_force.csv",
                "poverty.csv",
                "real_gdp.csv",
                "unemployee_monthly.csv",
                "earings_Construction.csv",
                "earings_Education_and_Health_Services.csv",
                "earings_Financial_Activities.csv",
                "earings_Goods_Producing.csv",
                "earings_Leisure and Hospitality.csv".replace(" ", "_").replace(",", ""),
                "earings_Manufacturing.csv".replace(" ", "_").replace(",", ""),
                "earings_Private Service Providing.csv".replace(" ", "_").replace(",", ""),
                "earings_Professional and Business Services.csv".replace(" ", "_").replace(",", ""),
                "earings_Trade, Transportation, and Utilities.csv".replace(" ", "_").replace(",", "")
        );

        List<String> topicnames = Arrays.asList(
            "topic_unempl_ann",
            "topic_house_income_ann",
            "topic_tax_ememp_ann",
            "topic_civil_force_ann",
            "topic_gdp_ann",
            "topic_unempl_mon",
            "topic_earn_Construction_mon",
            "topic_earn_Education_and_Health_Services_mon",
            "topic_earn_Financial_Activities_mon",
            "topic_earn_Goods_Producing_mon",
            "topic_earn_Leisure and Hospitality_mon".replace(" ", "_").replace(",", ""),
            "topic_earn_Manufacturing_mon".replace(" ", "_").replace(",", ""),
            "topic_earn_Private Service Providing_mon".replace(" ", "_").replace(",", ""),
            "topic_Professional and Business Services_mon".replace(" ", "_").replace(",", ""),
            "topic_Trade, Transportation, and Utilities_mon".replace(" ", "_").replace(",", "")
        );

        for (int i = 0; i < filenames.size(); i++){
            int j = i;
            hdfs2Kafka.readHdFile(filenames.get(i)).forEach(str ->
                    hdfs2Kafka.sendLines2Kafka(topicnames.get(j), str));
            hdfs2Kafka.getHdFilesInfo(filenames.get(i));
        }



    }
}
