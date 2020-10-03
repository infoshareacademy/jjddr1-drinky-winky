package com.infoshare.drinkywinky.utils;

import com.infoshare.drinkywinky.properties.AppConfig;
import com.infoshare.drinkywinky.properties.ConfigLoader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormater {
    ConfigLoader configLoader = new ConfigLoader().loadAppConfig();
    LocalDateTime localDateTime = LocalDateTime.now();
    String DATE_FORMATTER = AppConfig.dateFormat;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);

    public void setFormatter(DateTimeFormatter formatter) {
        this.formatter = formatter;
    }

    public DateTimeFormatter getFormatter() {
        return formatter;
    }

}
