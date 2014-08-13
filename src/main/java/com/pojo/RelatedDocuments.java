package com.pojo;
// Generated Nov 11, 2010 2:05:44 PM by Hibernate Tools 3.2.1.GA


import java.util.Date;

/**
 * RelatedDocuments generated by hbm2java
 */
public class RelatedDocuments  implements java.io.Serializable {


     private long requestcode;
     private String employeeid;
     private String documentsname;
     private String reason;
     private String status;
     private String tomail;
     private String approvalauthoriyEmployeeid;
     private Date requestdate;
     private Date approvaldate;

    public RelatedDocuments() {
    }

    public RelatedDocuments(long requestcode) {
        this.requestcode = requestcode;
    }
    public RelatedDocuments(long requestcode, String employeeid, String documentsname, String reason, String status, String tomail, String approvalauthoriyEmployeeid, Date requestdate, Date approvaldate) {
       this.requestcode = requestcode;
       this.employeeid = employeeid;
       this.documentsname = documentsname;
       this.reason = reason;
       this.status = status;
       this.tomail = tomail;
       this.approvalauthoriyEmployeeid = approvalauthoriyEmployeeid;
       this.requestdate = requestdate;
       this.approvaldate = approvaldate;
    }
   
    public long getRequestcode() {
        return this.requestcode;
    }
    
    public void setRequestcode(long requestcode) {
        this.requestcode = requestcode;
    }
    public String getEmployeeid() {
        return this.employeeid;
    }
    
    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }
    public String getDocumentsname() {
        return this.documentsname;
    }
    
    public void setDocumentsname(String documentsname) {
        this.documentsname = documentsname;
    }
    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public String getTomail() {
        return this.tomail;
    }
    
    public void setTomail(String tomail) {
        this.tomail = tomail;
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

