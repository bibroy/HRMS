/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;

/**
 *
 * @author Sumit Kumar
 */
public class DailyAttendance implements Serializable{

    private Integer id;
    private String attdate;
    private String userid;
    private String empname;
    private String department;
    private String shiftname;
    private String deviceId;
    private String timein;
    private String latein;
    private String breakout;
    private String breakin;
    private String timeout;
    private String earlyout;
    private String totalwork;
    private String overtime;

    public DailyAttendance() {
    }

    public DailyAttendance(Integer id, String attdate, String userid, String empname, String department, String shiftname, String deviceId, String timein, String latein, String breakout, String breakin, String timeout, String earlyout, String totalwork, String overtime) {
        this.id = id;
        this.attdate = attdate;
        this.userid = userid;
        this.empname = empname;
        this.department = department;
        this.shiftname = shiftname;
        this.deviceId = deviceId;
        this.timein = timein;
        this.latein = latein;
        this.breakout = breakout;
        this.breakin = breakin;
        this.timeout = timeout;
        this.earlyout = earlyout;
        this.totalwork = totalwork;
        this.overtime = overtime;
    }


    public String getAttdate() {
        return attdate;
    }

    public void setAttdate(String attdate) {
        this.attdate = attdate;
    }

    public String getBreakin() {
        return breakin;
    }

    public void setBreakin(String breakin) {
        this.breakin = breakin;
    }

    public String getBreakout() {
        return breakout;
    }

    public void setBreakout(String breakout) {
        this.breakout = breakout;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getEarlyout() {
        return earlyout;
    }

    public void setEarlyout(String earlyout) {
        this.earlyout = earlyout;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatein() {
        return latein;
    }

    public void setLatein(String latein) {
        this.latein = latein;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public String getShiftname() {
        return shiftname;
    }

    public void setShiftname(String shiftname) {
        this.shiftname = shiftname;
    }

    public String getTimein() {
        return timein;
    }

    public void setTimein(String timein) {
        this.timein = timein;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getTotalwork() {
        return totalwork;
    }

    public void setTotalwork(String totalwork) {
        this.totalwork = totalwork;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }


}
