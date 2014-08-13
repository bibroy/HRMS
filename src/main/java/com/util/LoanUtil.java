/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author sujatas
 */
public class LoanUtil implements Serializable{

    private String empId;
    private String empFname;
     private String empMname;
    private String empLname;
    private String designation;
    private String phone;
    private String department;
    private String email;
    private String projectName;

    private String totalSal;
    private String reqAmt;
    private String installment;

    private Date deductstartmonth;

    private String reason;
    private Integer requestId;
    private Date requestDate;


    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the empFname
     */
    public String getEmpFname() {
        return empFname;
    }

    /**
     * @param empFname the empFname to set
     */
    public void setEmpFname(String empFname) {
        this.empFname = empFname;
    }

    /**
     * @return the empMname
     */
    public String getEmpMname() {
        return empMname;
    }

    /**
     * @param empMname the empMname to set
     */
    public void setEmpMname(String empMname) {
        this.empMname = empMname;
    }

    /**
     * @return the empLname
     */
    public String getEmpLname() {
        return empLname;
    }

    /**
     * @param empLname the empLname to set
     */
    public void setEmpLname(String empLname) {
        this.empLname = empLname;
    }

    /**
     * @return the designation
     */
    public String getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(String designation) {
        this.designation = designation;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the totalSal
     */
    public String getTotalSal() {
        return totalSal;
    }

    /**
     * @param totalSal the totalSal to set
     */
    public void setTotalSal(String totalSal) {
        this.totalSal = totalSal;
    }

    /**
     * @return the reqAmt
     */
    public String getReqAmt() {
        return reqAmt;
    }

    /**
     * @param reqAmt the reqAmt to set
     */
    public void setReqAmt(String reqAmt) {
        this.reqAmt = reqAmt;
    }

    /**
     * @return the installment
     */
    public String getInstallment() {
        return installment;
    }

    /**
     * @param installment the installment to set
     */
    public void setInstallment(String installment) {
        this.installment = installment;
    }

    /**
     * @return the deductstartmonth
     */
    public Date getDeductstartmonth() {
        return deductstartmonth;
    }

    /**
     * @param deductstartmonth the deductstartmonth to set
     */
    public void setDeductstartmonth(Date deductstartmonth) {
        this.deductstartmonth = deductstartmonth;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the requestId
     */
    public Integer getRequestId() {
        return requestId;
    }

    /**
     * @param requestId the requestId to set
     */
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    /**
     * @return the requestDate
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * @param requestDate the requestDate to set
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

}
