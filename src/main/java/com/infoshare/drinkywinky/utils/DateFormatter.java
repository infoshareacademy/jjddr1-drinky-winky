package com.infoshare.drinkywinky.utils;

import com.infoshare.drinkywinky.properties.AppConfig;
import com.infoshare.drinkywinky.properties.ConfigLoader;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    public static DateTimeFormatter formatter;
    private String dateTime;

    public DateFormatter(String dateFormatKey) {
        ConfigLoader config = new ConfigLoader();
        config.loadAppConfig();
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(AppConfig.dateFormat));
    }
    public String getDateTime(String dateModified) {
    return this.dateTime;
    }
}
