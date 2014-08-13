/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.util;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Sumit Kumar
 *
 * contains functions for handling Timestamp values.
 *
 */
public class TimeStampUtil {

    /**
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @param millisecond
     * @return Timestamp
     */
    public Timestamp makeTimestamp(Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second, Integer millisecond) {
        Calendar cal = new GregorianCalendar();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month-1);
        cal.set(Calendar.DATE, day);
        cal.set(Calendar.HOUR_OF_DAY, hour);
        cal.set(Calendar.MINUTE, minute);
        cal.set(Calendar.SECOND, second);
        cal.set(Calendar.MILLISECOND, millisecond);
        return new Timestamp(cal.getTimeInMillis());
    }

    /**
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @param second
     * @return timestamp
     */
    public Timestamp makeTimestamp(Integer year, Integer month, Integer day, Integer hour, Integer minute, Integer second) {
        Calendar cal = new GregorianCalendar();
        cal.set(year, month-1, day, hour, minute, second);
        return new Timestamp(cal.getTimeInMillis());
    }

    /**
     *
     * @param year
     * @param month
     * @param day
     * @param hour
     * @param minute
     * @return
     */
    public Timestamp makeTimestamp(Integer year, Integer month, Integer day, Integer hour, Integer minute) {
        Calendar cal = new GregorianCalendar();
        cal.set(year, month-1, day, hour, minute);
        return new Timestamp(cal.getTimeInMillis());
    }
}
