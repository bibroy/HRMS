/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;
import java.util.Date;

/**
 *
 * @author computer1
 */
public class Timesheetutil implements java.io.Serializable {
private Integer timesheetdetailid;
     private Integer timesheetheaderid;
     private Integer projectid;
     private String timeslot;
     private String description;
     private String empid;
     private Date timesheetdate;
     private String overtimestatus;
     private String approvestatus;

    public Timesheetutil(Integer timesheetdetailid, Integer timesheetheaderid, Integer projectid, String timeslot, String description, String empid, Date timesheetdate, String overtimestatus) {
        this.timesheetdetailid = timesheetdetailid;
        this.timesheetheaderid = timesheetheaderid;
        this.projectid = projectid;
        this.timeslot = timeslot;
        this.description = description;
        this.empid = empid;
        this.timesheetdate = timesheetdate;
        this.overtimestatus = overtimestatus;
    }

    public Timesheetutil() {
    }

    public String getApprovestatus() {
        return approvestatus;
    }

    public void setApprovestatus(String approvestatus) {
        this.approvestatus = approvestatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public String getOvertimestatus() {
        return overtimestatus;
    }

    public void setOvertimestatus(String overtimestatus) {
        this.overtimestatus = overtimestatus;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public Date getTimesheetdate() {
        return timesheetdate;
    }

    public void setTimesheetdate(Date timesheetdate) {
        this.timesheetdate = timesheetdate;
    }

    public Integer getTimesheetdetailid() {
        return timesheetdetailid;
    }

    public void setTimesheetdetailid(Integer timesheetdetailid) {
        this.timesheetdetailid = timesheetdetailid;
    }

    public Integer getTimesheetheaderid() {
        return timesheetheaderid;
    }

    public void setTimesheetheaderid(Integer timesheetheaderid) {
        this.timesheetheaderid = timesheetheaderid;
    }

    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }
     
}
