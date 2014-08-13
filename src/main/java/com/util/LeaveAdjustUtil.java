/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

/**
 *
 * @author sujatas
 */
public class LeaveAdjustUtil {
    private String leaveType;
    private Integer leaveId;
    private Double totalLeave;
    private Double leaveTaken;

    /**
     * @return the leaveType
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * @param leaveType the leaveType to set
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
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
     * @return the totalLeave
     */
    public Double getTotalLeave() {
        return totalLeave;
    }

    /**
     * @param totalLeave the totalLeave to set
     */
    public void setTotalLeave(Double totalLeave) {
        this.totalLeave = totalLeave;
    }

    /**
     * @return the leaveTaken
     */
    public Double getLeaveTaken() {
        return leaveTaken;
    }

    /**
     * @param leaveTaken the leaveTaken to set
     */
    public void setLeaveTaken(Double leaveTaken) {
        this.leaveTaken = leaveTaken;
    }

}
