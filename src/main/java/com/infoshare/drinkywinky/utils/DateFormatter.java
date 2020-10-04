package com.infoshare.drinkywinky.utils;

import com.infoshare.drinkywinky.properties.AppConfig;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateFormatter {
    private static String DATE_FORMATTER;
    public static DateTimeFormatter formatter;
    private String dateTime;

    public DateFormatter() {
        this.dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern(DATE_FORMATTER));
    }

    public static String getDateFormatter() {
        return DATE_FORMATTER;
    }

    public static void setDateFormatter(String dateFormatter) {
        DATE_FORMATTER = dateFormatter;
    }

    public static DateTimeFormatter getFormatter() {
        return formatter;
    }

    public static void setFormatter(DateTimeFormatter formatter) {
        DateFormatter.formatter = formatter;
    }

    public String getDateTime(String dateModified) {
        return this.dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    static {
        DATE_FORMATTER = AppConfig.dateFormat;
        formatter = DateTimeFormatter.ofPattern(DATE_FORMATTER);
    }
}
