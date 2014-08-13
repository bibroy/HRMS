/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;
import java.util.Date;
/**
 *
 * @author computer1
 */
public class CompensationPerformancesheet {
     private String empid;
    private Integer totalmeasure;
    private Integer obtainmeasure;
    private Integer indicatorid;
    private Integer id;
    private Date performancedate;

    public Date getPerformancedate() {
        return performancedate;
    }

    public void setPerformancedate(Date performancedate) {
        this.performancedate = performancedate;
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

    public Integer getIndicatorid() {
        return indicatorid;
    }

    public void setIndicatorid(Integer indicatorid) {
        this.indicatorid = indicatorid;
    }

    public Integer getObtainmeasure() {
        return obtainmeasure;
    }

    public void setObtainmeasure(Integer obtainmeasure) {
        this.obtainmeasure = obtainmeasure;
    }

    public Integer getTotalmeasure() {
        return totalmeasure;
    }

    public void setTotalmeasure(Integer totalmeasure) {
        this.totalmeasure = totalmeasure;
    }

    public CompensationPerformancesheet() {
    }

    public CompensationPerformancesheet(String empid, Integer totalmeasure, Integer obtainmeasure) {
        this.empid = empid;
        this.totalmeasure = totalmeasure;
        this.obtainmeasure = obtainmeasure;
    }



}
