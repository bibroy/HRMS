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
public class CompensationIncrementBand implements java.io.Serializable {
    private Integer id;
    private Integer company;
    private Integer department;
    private Integer designation;
    private Integer increment;
    private Integer from;
    private Integer to;
    private Date incrementdatefrom;
    private Date incrementdateto;
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public Date getIncrementdatefrom() {
        return incrementdatefrom;
    }

    public void setIncrementdatefrom(Date incrementdatefrom) {
        this.incrementdatefrom = incrementdatefrom;
    }

    public Date getIncrementdateto() {
        return incrementdateto;
    }

    public void setIncrementdateto(Date incrementdateto) {
        this.incrementdateto = incrementdateto;
    }

    
    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }


   

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
    }



   
    public CompensationIncrementBand() {
    }

    public CompensationIncrementBand(Integer id, Integer company, Integer department, Integer designation) {
        this.id = id;
        this.company = company;
        this.department = department;
        this.designation = designation;
    }



}
