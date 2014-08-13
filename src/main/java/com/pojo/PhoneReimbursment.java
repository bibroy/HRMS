package com.pojo;
// Generated Nov 11, 2010 2:05:44 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * PhoneReimbursment generated by hbm2java
 */
public class PhoneReimbursment  implements java.io.Serializable {


     private BigDecimal requestid;
     private String employeeid;
     private BigDecimal phoneno;
     private Double totalamount;
     private Date requestdate;
     private String approvalstatus;
     private Date approvaldate;
     private BigDecimal phonebillid;
     private String approvedBy;

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }
      
    public PhoneReimbursment() {
    }

	
    public PhoneReimbursment(BigDecimal requestid) {
        this.requestid = requestid;
    }
    public PhoneReimbursment(BigDecimal requestid, String employeeid, BigDecimal phoneno, Double totalamount, Date requestdate, String approvalstatus, Date approvaldate, BigDecimal phonebillid) {
       this.requestid = requestid;
       this.employeeid = employeeid;
       this.phoneno = phoneno;
       this.totalamount = totalamount;
       this.requestdate = requestdate;
       this.approvalstatus = approvalstatus;
       this.approvaldate = approvaldate;
       this.phonebillid = phonebillid;
    }
   
    public BigDecimal getRequestid() {
        return this.requestid;
    }
    
    public void setRequestid(BigDecimal requestid) {
        this.requestid = requestid;
    }
    public String getEmployeeid() {
        return this.employeeid;
    }
    
    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }
    public BigDecimal getPhoneno() {
        return this.phoneno;
    }
    
    public void setPhoneno(BigDecimal phoneno) {
        this.phoneno = phoneno;
    }
    public Double getTotalamount() {
        return this.totalamount;
    }
    
    public void setTotalamount(Double totalamount) {
        this.totalamount = totalamount;
    }
    public Date getRequestdate() {
        return this.requestdate;
    }
    
    public void setRequestdate(Date requestdate) {
        this.requestdate = requestdate;
    }
    public String getApprovalstatus() {
        return this.approvalstatus;
    }
    
    public void setApprovalstatus(String approvalstatus) {
        this.approvalstatus = approvalstatus;
    }
    public Date getApprovaldate() {
        return this.approvaldate;
    }
    
    public void setApprovaldate(Date approvaldate) {
        this.approvaldate = approvaldate;
    }
    public BigDecimal getPhonebillid() {
        return this.phonebillid;
    }
    
    public void setPhonebillid(BigDecimal phonebillid) {
        this.phonebillid = phonebillid;
    }




}


