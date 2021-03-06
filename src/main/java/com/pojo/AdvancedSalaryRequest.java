package com.pojo;
// Generated Nov 11, 2010 2:05:44 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * AdvancedSalaryRequest generated by hbm2java
 */
public class AdvancedSalaryRequest  implements java.io.Serializable {


     private BigDecimal requestid;
     private String employeeId;
     private Date deductionstartmonth;
     private BigDecimal noofinstallment;
     private String reason;
     private Double appliedamount;
     private BigDecimal totalsalary;
     private String approvalstatus;
     private String approvalauthoriyEmployeeid;
     private Date requestdate;
     private Date approvaldate;

    public AdvancedSalaryRequest() {
    }

	
    public AdvancedSalaryRequest(BigDecimal requestid) {
        this.requestid = requestid;
    }
    public AdvancedSalaryRequest(BigDecimal requestid, String employeeId, Date deductionstartmonth, BigDecimal noofinstallment, String reason, Double appliedamount, BigDecimal totalsalary, String approvalstatus, String approvalauthoriyEmployeeid, Date requestdate, Date approvaldate) {
       this.requestid = requestid;
       this.employeeId = employeeId;
       this.deductionstartmonth = deductionstartmonth;
       this.noofinstallment = noofinstallment;
       this.reason = reason;
       this.appliedamount = appliedamount;
       this.totalsalary = totalsalary;
       this.approvalstatus = approvalstatus;
       this.approvalauthoriyEmployeeid = approvalauthoriyEmployeeid;
       this.requestdate = requestdate;
       this.approvaldate = approvaldate;
    }
   
    public BigDecimal getRequestid() {
        return this.requestid;
    }
    
    public void setRequestid(BigDecimal requestid) {
        this.requestid = requestid;
    }
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public Date getDeductionstartmonth() {
        return this.deductionstartmonth;
    }
    
    public void setDeductionstartmonth(Date deductionstartmonth) {
        this.deductionstartmonth = deductionstartmonth;
    }
    public BigDecimal getNoofinstallment() {
        return this.noofinstallment;
    }
    
    public void setNoofinstallment(BigDecimal noofinstallment) {
        this.noofinstallment = noofinstallment;
    }
    public String getReason() {
        return this.reason;
    }
    
    public void setReason(String reason) {
        this.reason = reason;
    }
    public Double getAppliedamount() {
        return this.appliedamount;
    }
    
    public void setAppliedamount(Double appliedamount) {
        this.appliedamount = appliedamount;
    }
    public BigDecimal getTotalsalary() {
        return this.totalsalary;
    }
    
    public void setTotalsalary(BigDecimal totalsalary) {
        this.totalsalary = totalsalary;
    }
    public String getApprovalstatus() {
        return this.approvalstatus;
    }
    
    public void setApprovalstatus(String approvalstatus) {
        this.approvalstatus = approvalstatus;
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


