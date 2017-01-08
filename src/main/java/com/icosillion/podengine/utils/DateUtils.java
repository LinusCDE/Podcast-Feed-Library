package com.icosillion.podengine.utils;

import com.icosillion.podengine.exceptions.DateFormatException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    private static SimpleDateFormat[] dateFormats = {
            new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z"),
            new SimpleDateFormat("dd MMM yyyy HH:mm:ss Z"),
            new SimpleDateFormat("EEE, dd MMM yyyy HH:mm Z"),
            new SimpleDateFormat("dd MMM yyyy HH:mm Z")
    };

    public static Date stringToDate(String dt) throws DateFormatException {

        Date date = null;

        for (SimpleDateFormat dateFormat : DateUtils.dateFormats) {
            try {
                date = dateFormat.parse(dt);
                break;
            } catch (ParseException e) {
                //This format didn't work, keep going
            }
        }

        return date;
    }
}
