package com.ss_reservation.ss_reservation_core.common.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtility {
    public static Date addHour(Date date, int hours) {
        
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);

        return calendar.getTime();
    }
}
