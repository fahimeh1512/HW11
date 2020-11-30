package com.example.hw11.utils;

import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtils {
    public static final int YEAR_START = 2000;
    public static final int YEAR_END = 2020;
    public static final int HOUR_START = 0;
    public static final int HOUR_END = 23;
    public static final int MINUTE_START = 0;
    public static final int MINUTE_END = 59;

    public static Date randomDate() {
        GregorianCalendar gc = new GregorianCalendar();
        int year = randomBetween(YEAR_START, YEAR_END);
        gc.set(gc.YEAR, year);
        int dayOfYear = randomBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));
        gc.set(gc.DAY_OF_YEAR, dayOfYear);
        int hour = randomBetween(HOUR_START, HOUR_END);
        gc.set(gc.HOUR, hour);
        int minute = randomBetween(MINUTE_START, MINUTE_END);
        gc.set(gc.MINUTE, minute);

        return gc.getTime();
    }

    private static int randomBetween(int start, int end) {
        return start + (int)Math.round(Math.random() * (end - start));
    }
}
