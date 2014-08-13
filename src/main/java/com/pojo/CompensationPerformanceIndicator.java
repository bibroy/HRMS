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
public class CompensationPerformanceIndicator {
     private Integer id;
    private Integer company;
    private Integer department;
    private Integer designation;
    private Integer indicator;
    private Integer measure;
    private Date indicatordate;

    public Date getIndicatordate() {
        return indicatordate;
    }

    public void setIndicatordate(Date indicatordate) {
        this.indicatordate = indicatordate;
    }


    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public Integer getDesignation() {
        return designation;
    }

    public void setDesignation(Integer designation) {
        this.designation = designation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndicator() {
        return indicator;
    }

    public void setIndicator(Integer indicator) {
        this.indicator = indicator;
    }

    public Integer getMeasure() {
        return measure;
    }

    public void setMeasure(Integer measure) {
        this.measure = measure;
    }

    public CompensationPerformanceIndicator(Integer id, Integer company, Integer department, Integer designation, Integer indicator, Integer measure) {
        this.id = id;
        this.company = company;
        this.department = department;
        this.designation = designation;
        this.indicator = indicator;
        this.measure = measure;
    }

    public CompensationPerformanceIndicator(Integer id, Integer company) {
        this.id = id;
        this.company = company;
    }

    public CompensationPerformanceIndicator(Integer id, Integer company, Integer department) {
        this.id = id;
        this.company = company;
        this.department = department;
    }

    public CompensationPerformanceIndicator() {
    }
    


}
