/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Sumit Kumar
 */
public class TimesheetMaster implements Serializable {

    private Integer id;
    private String projectId;
    private String phase;
    private Date startTime;
    private Date endTime;
    private String timeDuration;
    private Integer task;
    private String remarks;
    private String workStatus;
    private String assignedTo;
    

    public TimesheetMaster() {
    }

    public TimesheetMaster(Integer id, String projectId, String phase, Date startTime, Date endTime, String timeDuration, Integer task, String remarks, String workStatus, String assignedTo) {
        this.id = id;
        this.projectId = projectId;
        this.phase = phase;
        this.startTime = startTime;
        this.endTime = endTime;
        this.timeDuration = timeDuration;
        this.task = task;
        this.remarks = remarks;
        this.workStatus = workStatus;
        this.assignedTo = assignedTo;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhase() {
        return phase;
    }

    public void setPhase(String phase) {
        this.phase = phase;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getTask() {
        return task;
    }

    public void setTask(Integer task) {
        this.task = task;
    }

    public String getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(String timeDuration) {
        this.timeDuration = timeDuration;
    }

    public String getWorkStatus() {
        return workStatus;
    }

    public void setWorkStatus(String workStatus) {
        this.workStatus = workStatus;
    }


    
}
