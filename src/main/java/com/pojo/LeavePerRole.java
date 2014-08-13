/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;

/**
 *
 * @author Sumit Kumar
 */
public class LeavePerRole implements Serializable {
  private Integer id;
  private Integer leaveId;
  private Integer roleId;
  private Double maxDays;
  private String employeeConfirmationStatus;
  private String leaveApplicableFrom;
  private LeaveDetails leave;
  private RoleMaster role;

    public LeaveDetails getLeave() {
        return leave;
    }

    public void setLeave(LeaveDetails leave) {
        this.leave = leave;
    }

    public RoleMaster getRole() {
        return role;
    }

    public void setRole(RoleMaster role) {
        this.role = role;
    }

    public String getLeaveApplicableFrom() {
        return leaveApplicableFrom;
    }

    public void setLeaveApplicableFrom(String leaveApplicableFrom) {
        this.leaveApplicableFrom = leaveApplicableFrom;
    }
  private String flag;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the leaveId
     */
    public Integer getLeaveId() {
        return leaveId;
    }

    /**
     * @param leaveId the leaveId to set
     */
    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    /**
     * @return the roleId
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * @param roleId the roleId to set
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * @return the maxDays
     */
    public Double getMaxDays() {
        return maxDays;
    }

    /**
     * @param maxDays the maxDays to set
     */
    public void setMaxDays(Double maxDays) {
        this.maxDays = maxDays;
    }

    /**
     * @return the employeeConfirmationStatus
     */
    public String getEmployeeConfirmationStatus() {
        return employeeConfirmationStatus;
    }

    /**
     * @param employeeConfirmationStatus the employeeConfirmationStatus to set
     */
    public void setEmployeeConfirmationStatus(String employeeConfirmationStatus) {
        this.employeeConfirmationStatus = employeeConfirmationStatus;
    }

    /**
     * @return the flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }



}
