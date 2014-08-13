/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author computer1
 */
public class CompensationPerformanceSheetForm extends org.apache.struts.action.ActionForm {

    private String empid;
    private Integer[] totalmeasure;
    private Integer[] obtainmeasure;
    private Integer[] indicatorid;
    private Integer id;
    private String timesheetdate;
    private String method;
    private Double score;

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
    
    public String getTimesheetdate() {
        return timesheetdate;
    }

    public void setTimesheetdate(String timesheetdate) {
        this.timesheetdate = timesheetdate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public Integer[] getIndicatorid() {
        return indicatorid;
    }

    public void setIndicatorid(Integer[] indicatorid) {
        this.indicatorid = indicatorid;
    }

    public Integer[] getObtainmeasure() {
        return obtainmeasure;
    }

    public void setObtainmeasure(Integer[] obtainmeasure) {
        this.obtainmeasure = obtainmeasure;
    }

    public Integer[] getTotalmeasure() {
        return totalmeasure;
    }

    public void setTotalmeasure(Integer[] totalmeasure) {
        this.totalmeasure = totalmeasure;
    }
}
