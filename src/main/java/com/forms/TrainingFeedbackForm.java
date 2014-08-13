/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;


import java.util.Date;

/**
 *
 * @author pradipto
 */
public class TrainingFeedbackForm extends org.apache.struts.action.ActionForm {
    
   
    private String id;
    private String[] employeename;
    private String trainingid;
    private String trainingtype;
    private String[] score;
    private String[] startdate;
    private String[] endDate;
    private String[] employeeID;
    private String maxmarks;
    private String method;

    public String[] getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String[] employeeID) {
        this.employeeID = employeeID;
    }

    public String[] getEmployeename() {
        return employeename;
    }

    public void setEmployeename(String[] employeename) {
        this.employeename = employeename;
    }

    public String[] getEndDate() {
        return endDate;
    }

    public void setEndDate(String[] endDate) {
        this.endDate = endDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

   

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String[] getScore() {
        return score;
    }

    public void setScore(String[] score) {
        this.score = score;
    }

    public String[] getStartdate() {
        return startdate;
    }

    public void setStartdate(String[] startdate) {
        this.startdate = startdate;
    }

    public String getMaxmarks() {
        return maxmarks;
    }

    public void setMaxmarks(String maxmarks) {
        this.maxmarks = maxmarks;
    }

    public String getTrainingid() {
        return trainingid;
    }

    public void setTrainingid(String trainingid) {
        this.trainingid = trainingid;
    }

    public String getTrainingtype() {
        return trainingtype;
    }

    public void setTrainingtype(String trainingtype) {
        this.trainingtype = trainingtype;
    }

}
