/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author computer1
 */
public class Attendanceutil implements java.io.Serializable{
     private int id;
     private String empCode;
     private int regularHrs;
     private int overtimeHrs;
     private int totalHrs;
     private String empName;
     private Date attendanceDate;
     private String month;
   private int absent;
   private int totalregularhrs;

    public int getTotalregularhrs() {
        return totalregularhrs;
    }

    public void setTotalregularhrs(int totalregularhrs) {
        this.totalregularhrs = totalregularhrs;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOvertimeHrs() {
        return overtimeHrs;
    }

    public void setOvertimeHrs(int overtimeHrs) {
        this.overtimeHrs = overtimeHrs;
    }

    public int getRegularHrs() {
        return regularHrs;
    }

    public void setRegularHrs(int regularHrs) {
        this.regularHrs = regularHrs;
    }

    public int getTotalHrs() {
        return totalHrs;
    }

    public void setTotalHrs(int totalHrs) {
        this.totalHrs = totalHrs;
    }

    public int getAbsent() {
        return absent;
    }

    public void setAbsent(int absent) {
        this.absent = absent;
    }






    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }


    public Date getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(Date attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public Attendanceutil() {
    }

    public Attendanceutil(int id, String empCode, int regularHrs, int overtimeHrs, int totalHrs, String empName, Date attendanceDate, String month, int absent) {
        this.id = id;
        this.empCode = empCode;
        this.regularHrs = regularHrs;
        this.overtimeHrs = overtimeHrs;
        this.totalHrs = totalHrs;
        this.empName = empName;
        this.attendanceDate = attendanceDate;
        this.month = month;
        this.absent = absent;
    }

   





    
    public String getEmpCode() {
        return this.empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }


    
    public String getEmpName() {
        return this.empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }




}




