/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;
import java.util.Date;
 
public class IndicatorBandUtil implements java.io.Serializable {
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
 private String companyname;
    private String departmentname;
    private String designationname;

    public Integer getCompany() {
        return company;
    }

    public void setCompany(Integer company) {
        this.company = company;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public Integer getDepartment() {
        return department;
    }

    public void setDepartment(Integer department) {
        this.department = department;
    }

    public String getDepartmentname() {
        return departmentname;
    }

    public void setDepartmentname(String departmentname) {
        this.departmentname = departmentname;
    }

    public Integer getDesignation() {
        return designation;
    }

    public void setDesignation(Integer designation) {
        this.designation = designation;
    }

    public String getDesignationname() {
        return designationname;
    }

    public void setDesignationname(String designationname) {
        this.designationname = designationname;
    }

    public Integer getFrom() {
        return from;
    }

    public void setFrom(Integer from) {
        this.from = from;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTo() {
        return to;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public IndicatorBandUtil() {
    }

    public IndicatorBandUtil(Integer id, Integer increment, Integer from, Integer to, Date incrementdateto, String status, String companyname, String departmentname, String designationname) {
        this.id = id;
        this.increment = increment;
        this.from = from;
        this.to = to;
        this.incrementdateto = incrementdateto;
        this.status = status;
        this.companyname = companyname;
        this.departmentname = departmentname;
        this.designationname = designationname;
    }


}
