/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import java.util.Date;

/**
 *
 * @author sujatas
 */
public class LeaveRequestUtil {

    private String empId;
    private String empFname;
    private String empLname;

    private String designation;
    private int supervisor;
    private Date fromDt;
    private Date toDt;
    private String reason;
    private String projectName;
    private String location;
    private String leaveAddress;
    //private String department;

    private float day;
    private String email;
    private String leaveContactNo;
    private String method;
    private String button;
    private String deptCode ;
    private String leavetype;
    private Integer hiddenId;
    private Integer requestId;
    private Date requestDate;


    private Double noOfDays;

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
     * @return the supervisor
     */
    public int getSupervisor() {
        return supervisor;
    }

    /**
     * @param supervisor the supervisor to set
     */
    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    /**
     * @return the fromDt
     */
    public Date getFromDt() {
        return fromDt;
    }

    /**
     * @param fromDt the fromDt to set
     */
    public void setFromDt(Date fromDt) {
        this.fromDt = fromDt;
    }

    /**
     * @return the toDt
     */
    public Date getToDt() {
        return toDt;
    }

    /**
     * @param toDt the toDt to set
     */
    public void setToDt(Date toDt) {
        this.toDt = toDt;
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
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * @return the leaveAddress
     */
    public String getLeaveAddress() {
        return leaveAddress;
    }

    /**
     * @param leaveAddress the leaveAddress to set
     */
    public void setLeaveAddress(String leaveAddress) {
        this.leaveAddress = leaveAddress;
    }

    /**
     * @return the day
     */
    public float getDay() {
        return day;
    }

    /**
     * @param day the day to set
     */
    public void setDay(float day) {
        this.day = day;
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
     * @return the leaveContactNo
     */
    public String getLeaveContactNo() {
        return leaveContactNo;
    }

    /**
     * @param leaveContactNo the leaveContactNo to set
     */
    public void setLeaveContactNo(String leaveContactNo) {
        this.leaveContactNo = leaveContactNo;
    }

    /**
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * @return the button
     */
    public String getButton() {
        return button;
    }

    /**
     * @param button the button to set
     */
    public void setButton(String button) {
        this.button = button;
    }

    /**
     * @return the deptname
     */
    public String getDeptCode() {
        return deptCode;
    }

    /**
     * @param deptname the deptname to set
     */
    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    /**
     * @return the leavetype
     */
    public String getLeavetype() {
        return leavetype;
    }

    /**
     * @param leavetype the leavetype to set
     */
    public void setLeavetype(String leavetype) {
        this.leavetype = leavetype;
    }

    /**
     * @return the hiddenId
     */
    public Integer getHiddenId() {
        return hiddenId;
    }

    /**
     * @param hiddenId the hiddenId to set
     */
    public void setHiddenId(Integer hiddenId) {
        this.hiddenId = hiddenId;
    }

    /**
     * @return the noOfDays
     */
    public Double getNoOfDays() {
        return noOfDays;
    }

    /**
     * @param noOfDays the noOfDays to set
     */
    public void setNoOfDays(Double noOfDays) {
        this.noOfDays = noOfDays;
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

    /**
     * @return the empId
     *
     */


  /*  public static void leaveAdjustment(String empId,Integer leaveId,double appliedDays)
    {

         leaveStatusPeremployee=leavePerRoleDAOImpl.getLeaveStatusFromDB(empId, leaveId);
                Double tl = leaveStatusPeremployee.getTotalleave();

                Double lt = (Double) leaveStatusPeremployee.getLeavetaken();
                System.out.println("From leaveStatusPeremployee====>"+tl+"======>"+lt);

                totalLeave = tl.doubleValue();
                leaveTaken = lt.doubleValue();
                availableLeave = totalLeave - leaveTaken;

                System.out.println("Available Leave======>"+availableLeave+"Appliead Leave======>"+appliedLeave+"=====Toaqtal Leave=====>"+totalLeave);
                if (appliedLeave <= availableLeave) {
                    System.out.println("Inside If block");
                    leaveStatusPeremployee.setLeavetaken(appliedLeave + leaveTaken);
                    leaveStatusPeremployee.setEmpid(empId);
                    leaveStatusPeremployee.setLeaveid(leaveId);
                    leaveStatusPeremployee.setTotalleave(tl);
                }

                System.out.println("b4 Saving");

                leavePerRoleDAOImpl.assignLeave(leaveStatusPeremployee);



    }*/


    

  




}
