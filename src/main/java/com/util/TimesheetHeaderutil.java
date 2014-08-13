/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

/**
 *
 * @author computer1
 */
public class TimesheetHeaderutil implements java.io.Serializable {
    private String workingdate;
    private Integer normalduration;
    private Integer overtimeduration;
    private String company;
    private String department;
    private Integer creatorid;
    private String overtimelot;
    private String overtimedesc;
    private String method;
    private Integer headerid;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getCreatorid() {
        return creatorid;
    }

    public void setCreatorid(Integer creatorid) {
        this.creatorid = creatorid;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getHeaderid() {
        return headerid;
    }

    public void setHeaderid(Integer headerid) {
        this.headerid = headerid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getNormalduration() {
        return normalduration;
    }

    public void setNormalduration(Integer normalduration) {
        this.normalduration = normalduration;
    }

    public String getOvertimedesc() {
        return overtimedesc;
    }

    public void setOvertimedesc(String overtimedesc) {
        this.overtimedesc = overtimedesc;
    }

    public Integer getOvertimeduration() {
        return overtimeduration;
    }

    public void setOvertimeduration(Integer overtimeduration) {
        this.overtimeduration = overtimeduration;
    }

    public String getOvertimelot() {
        return overtimelot;
    }

    public void setOvertimelot(String overtimelot) {
        this.overtimelot = overtimelot;
    }

    public String getWorkingdate() {
        return workingdate;
    }

    public void setWorkingdate(String workingdate) {
        this.workingdate = workingdate;
    }


}
