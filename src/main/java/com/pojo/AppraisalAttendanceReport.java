/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

/**
 *
 * @author swarnendum
 */
public class AppraisalAttendanceReport {

    private int id;
    private String employee_id;
    private String employee_name;
    private int total_working_day;
    private int absent;
    private String month;
    private String year;

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

   

    public int getTotal_working_day() {
        return total_working_day;
    }

    public void setTotal_working_day(int total_working_day) {
        this.total_working_day = total_working_day;
    }

   
}
