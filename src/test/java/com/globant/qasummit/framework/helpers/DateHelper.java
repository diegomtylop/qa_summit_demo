package com.globant.qasummit.framework.helpers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateHelper {

    public static String getCurrentDateFormatted(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH_mm_ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }
}
