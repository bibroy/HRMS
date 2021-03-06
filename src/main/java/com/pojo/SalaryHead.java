package com.pojo;
// Generated Nov 11, 2010 2:05:44 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * SalaryHead generated by hbm2java
 */
public class SalaryHead  implements java.io.Serializable {


     private BigDecimal id;
     private String companyname;
     private String salaryheadname;
     private String status;
     private String headertype;
     private String headerid;
     private Double amount;
     private String groupid;

    public SalaryHead() {
    }

    public SalaryHead(BigDecimal id, String companyname, String salaryheadname, String status, String headertype, String headerid, Double amount, String groupid) {
        this.id = id;
        this.companyname = companyname;
        this.salaryheadname = salaryheadname;
        this.status = status;
        this.headertype = headertype;
        this.headerid = headerid;
        this.amount = amount;
        this.groupid = groupid;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getCompanyname() {
        return companyname;
    }

    public void setCompanyname(String companyname) {
        this.companyname = companyname;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getHeaderid() {
        return headerid;
    }

    public void setHeaderid(String headerid) {
        this.headerid = headerid;
    }

    public String getHeadertype() {
        return headertype;
    }

    public void setHeadertype(String headertype) {
        this.headertype = headertype;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getSalaryheadname() {
        return salaryheadname;
    }

    public void setSalaryheadname(String salaryheadname) {
        this.salaryheadname = salaryheadname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}


