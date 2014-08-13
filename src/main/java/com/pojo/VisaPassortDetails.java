package com.pojo;
// Generated Nov 11, 2010 2:05:44 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * VisaPassortDetails generated by hbm2java
 */
public class VisaPassortDetails  implements java.io.Serializable {


     private BigDecimal id;
     private String employeeId;
     private String passportNo;
     private Date passportIssueDate;
     private String passportIssuedBy;
     private Date passportValidUpto;
     private String visaNo;
     private String visaType;
     private String visaIssuedBy;
     private Date visaIssueDate;
     private Date visaValidUpto;

    public VisaPassortDetails() {
    }

	
    public VisaPassortDetails(BigDecimal id) {
        this.id = id;
    }
    public VisaPassortDetails(BigDecimal id, String employeeId, String passportNo, Date passportIssueDate, String passportIssuedBy, Date passportValidUpto, String visaNo, String visaType, String visaIssuedBy, Date visaIssueDate, Date visaValidUpto) {
       this.id = id;
       this.employeeId = employeeId;
       this.passportNo = passportNo;
       this.passportIssueDate = passportIssueDate;
       this.passportIssuedBy = passportIssuedBy;
       this.passportValidUpto = passportValidUpto;
       this.visaNo = visaNo;
       this.visaType = visaType;
       this.visaIssuedBy = visaIssuedBy;
       this.visaIssueDate = visaIssueDate;
       this.visaValidUpto = visaValidUpto;
    }
   
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getPassportNo() {
        return this.passportNo;
    }
    
    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }
    public Date getPassportIssueDate() {
        return this.passportIssueDate;
    }
    
    public void setPassportIssueDate(Date passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }
    public String getPassportIssuedBy() {
        return this.passportIssuedBy;
    }
    
    public void setPassportIssuedBy(String passportIssuedBy) {
        this.passportIssuedBy = passportIssuedBy;
    }
    public Date getPassportValidUpto() {
        return this.passportValidUpto;
    }
    
    public void setPassportValidUpto(Date passportValidUpto) {
        this.passportValidUpto = passportValidUpto;
    }
    public String getVisaNo() {
        return this.visaNo;
    }
    
    public void setVisaNo(String visaNo) {
        this.visaNo = visaNo;
    }
    public String getVisaType() {
        return this.visaType;
    }
    
    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }
    public String getVisaIssuedBy() {
        return this.visaIssuedBy;
    }
    
    public void setVisaIssuedBy(String visaIssuedBy) {
        this.visaIssuedBy = visaIssuedBy;
    }
    public Date getVisaIssueDate() {
        return this.visaIssueDate;
    }
    
    public void setVisaIssueDate(Date visaIssueDate) {
        this.visaIssueDate = visaIssueDate;
    }
    public Date getVisaValidUpto() {
        return this.visaValidUpto;
    }
    
    public void setVisaValidUpto(Date visaValidUpto) {
        this.visaValidUpto = visaValidUpto;
    }




}


