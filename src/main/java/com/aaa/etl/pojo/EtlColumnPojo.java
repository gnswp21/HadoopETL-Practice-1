package com.aaa.etl.pojo;

import com.aaa.etl.util.CustomFloatDeserializer;
import com.aaa.etl.util.DefaultLocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonPropertyOrder({ "realtime_start", "realtime_end", "date", "value", "id", "title", "state", "frequency_short",  "units_short",
        "seasonal_adjustment_short"})
public class EtlColumnPojo {


    @JsonProperty("realtime_start")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate realtime_start;

    @JsonProperty("realtime_end")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private LocalDate realtime_end;

    @JsonProperty("date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = LocalDateDeserializer.class)
    private String date;

    @JsonDeserialize(using = CustomFloatDeserializer.class) // "." 값 처리
    @JsonProperty("value")
    private Float value;

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("state")
    private String state;


    @JsonProperty("frequency_short")
    private String frequency_short;

    @JsonProperty("units_short")
    private String units_short;

    @JsonProperty("seasonal_adjustment_short")
    private String seasonal_adjustment_short;

    @Override
    public String toString(){
        return "EtlColumnPojo [realtime_start=" + realtime_start
                + ", realtime_end=" + realtime_end + ", title=" + title
                + ", date=" + date + ", value=" + value + ", id=" + id
                + ", frequency_short=" + frequency_short
                + ", units_short=" + units_short
                + ", seasonal_adjustment_short=" + seasonal_adjustment_short + "]";

    }

    @JsonIgnore
    public String getValues(){
        String values = realtime_start + "," + realtime_end + "," + date  + ","
                + value + "," + id  + "," + title  + "," + state  + "," + frequency_short
                + "," + units_short  + "," + seasonal_adjustment_short;
        return values;

    }

    @JsonIgnore
    public String getColumns(){
        String columns = "realtime_start" + "," + "realtime_end" + "," + "date"  + ","
                + "value" + "," + "id"  + "," + "title"  + "," + "state"  + "," + "frequency_short"
                + "," + "units_short"  + "," + "seasonal_adjustment_short";
        return columns;

    }

}
