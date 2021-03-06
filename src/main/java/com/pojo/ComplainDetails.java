package com.pojo;
// Generated Nov 11, 2010 2:05:44 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * ComplainDetails generated by hbm2java
 */
public class ComplainDetails  implements java.io.Serializable {


     private BigDecimal complainid;
     private String complaintext;
     private String suggestion;
     private String viewstatus;
     private String employeeid;
     private String approvalauthoriyEmployeeid;
     private Date requestdate;
     private Date approvaldate;
     private String subject;
     private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
     
    public ComplainDetails() {
    }

	
    public ComplainDetails(BigDecimal complainid) {
        this.complainid = complainid;
    }
    public ComplainDetails(BigDecimal complainid, String complaintext, String suggestion, String viewstatus, String employeeid, String approvalauthoriyEmployeeid, Date requestdate, Date approvaldate) {
       this.complainid = complainid;
       this.complaintext = complaintext;
       this.suggestion = suggestion;
       this.viewstatus = viewstatus;
       this.employeeid = employeeid;
       this.approvalauthoriyEmployeeid = approvalauthoriyEmployeeid;
       this.requestdate = requestdate;
       this.approvaldate = approvaldate;
    }
   
    public BigDecimal getComplainid() {
        return this.complainid;
    }
    
    public void setComplainid(BigDecimal complainid) {
        this.complainid = complainid;
    }
    public String getComplaintext() {
        return this.complaintext;
    }
    
    public void setComplaintext(String complaintext) {
        this.complaintext = complaintext;
    }
    public String getSuggestion() {
        return this.suggestion;
    }
    
    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }
    public String getViewstatus() {
        return this.viewstatus;
    }
    
    public void setViewstatus(String viewstatus) {
        this.viewstatus = viewstatus;
    }
    public String getEmployeeid() {
        return this.employeeid;
    }
    
    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }
    public String getApprovalauthoriyEmployeeid() {
        return this.approvalauthoriyEmployeeid;
    }
    
    public void setApprovalauthoriyEmployeeid(String approvalauthoriyEmployeeid) {
        this.approvalauthoriyEmployeeid = approvalauthoriyEmployeeid;
    }
    public Date getRequestdate() {
        return this.requestdate;
    }
    
    public void setRequestdate(Date requestdate) {
        this.requestdate = requestdate;
    }
    public Date getApprovaldate() {
        return this.approvaldate;
    }
    
    public void setApprovaldate(Date approvaldate) {
        this.approvaldate = approvaldate;
    }




}


