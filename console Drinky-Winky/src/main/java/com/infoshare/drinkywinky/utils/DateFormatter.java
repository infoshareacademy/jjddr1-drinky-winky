package com.infoshare.drinkywinky.utils;

import com.infoshare.drinkywinky.properties.AppConfig;
import com.infoshare.drinkywinky.properties.ConfigLoader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {

    private final String dateTime;

    public DateFormatter() {
        ConfigLoader config = new ConfigLoader();
        config.loadAppConfig();
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(AppConfig.DATA_FORMAT));
    }

    public String getDateTime() {
        return dateTime;
    }
}
