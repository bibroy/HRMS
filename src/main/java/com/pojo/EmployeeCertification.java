package com.pojo;
// Generated Nov 11, 2010 2:05:44 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * EmployeeCertification generated by hbm2java
 */
public class EmployeeCertification  implements java.io.Serializable {


     private BigDecimal id;
     private String employeeId;
     private String certificationName;
     private String orgatizationName;
     private String subject;
     private Date certifiedOnDate;
     private Date renewedDate;
     private Date renewedOnDate;

    public EmployeeCertification() {
    }

	
    public EmployeeCertification(BigDecimal id) {
        this.id = id;
    }
    public EmployeeCertification(BigDecimal id, String employeeId, String certificationName, String orgatizationName, String subject, Date certifiedOnDate, Date renewedDate, Date renewedOnDate) {
       this.id = id;
       this.employeeId = employeeId;
       this.certificationName = certificationName;
       this.orgatizationName = orgatizationName;
       this.subject = subject;
       this.certifiedOnDate = certifiedOnDate;
       this.renewedDate = renewedDate;
       this.renewedOnDate = renewedOnDate;
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
    public String getCertificationName() {
        return this.certificationName;
    }
    
    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName;
    }
    public String getOrgatizationName() {
        return this.orgatizationName;
    }
    
    public void setOrgatizationName(String orgatizationName) {
        this.orgatizationName = orgatizationName;
    }
    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }
    public Date getCertifiedOnDate() {
        return this.certifiedOnDate;
    }
    
    public void setCertifiedOnDate(Date certifiedOnDate) {
        this.certifiedOnDate = certifiedOnDate;
    }
    public Date getRenewedDate() {
        return this.renewedDate;
    }
    
    public void setRenewedDate(Date renewedDate) {
        this.renewedDate = renewedDate;
    }
    public Date getRenewedOnDate() {
        return this.renewedOnDate;
    }
    
    public void setRenewedOnDate(Date renewedOnDate) {
        this.renewedOnDate = renewedOnDate;
    }




}


