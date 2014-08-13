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
public class GoalSetting implements Serializable{
    private Integer goalId;
    private String goalTitle;
    private String goalDesc;
    private Integer priority;
    private Date goalSetDate;
    private Date probableCompletionDate;
    private Date actualCompletionDate;
    private String currentStatus;
    private String relatedOrgObjective;
    private String newSkillsAcquired;
    private String employeeId;

    public Date getActualCompletionDate() {
        return actualCompletionDate;
    }

    public void setActualCompletionDate(Date actualCompletionDate) {
        this.actualCompletionDate = actualCompletionDate;
    }

    public String getCurrentStatus() {
        return currentStatus;
    }

    public void setCurrentStatus(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getGoalDesc() {
        return goalDesc;
    }

    public void setGoalDesc(String goalDesc) {
        this.goalDesc = goalDesc;
    }

    public Integer getGoalId() {
        return goalId;
    }

    public void setGoalId(Integer goalId) {
        this.goalId = goalId;
    }

    public Date getGoalSetDate() {
        return goalSetDate;
    }

    public void setGoalSetDate(Date goalSetDate) {
        this.goalSetDate = goalSetDate;
    }

    public String getGoalTitle() {
        return goalTitle;
    }

    public void setGoalTitle(String goalTitle) {
        this.goalTitle = goalTitle;
    }

    public String getNewSkillsAcquired() {
        return newSkillsAcquired;
    }

    public void setNewSkillsAcquired(String newSkillsAcquired) {
        this.newSkillsAcquired = newSkillsAcquired;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getProbableCompletionDate() {
        return probableCompletionDate;
    }

    public void setProbableCompletionDate(Date probableCompletionDate) {
        this.probableCompletionDate = probableCompletionDate;
    }

    public String getRelatedOrgObjective() {
        return relatedOrgObjective;
    }

    public void setRelatedOrgObjective(String relatedOrgObjective) {
        this.relatedOrgObjective = relatedOrgObjective;
    }

    public GoalSetting() {
    }

    public GoalSetting(Integer goalId, String goalTitle, String goalDesc, Integer priority, Date goalSetDate, Date probableCompletionDate, Date actualCompletionDate, String currentStatus, String relatedOrgObjective, String newSkillsAcquired, String employeeId) {
        this.goalId = goalId;
        this.goalTitle = goalTitle;
        this.goalDesc = goalDesc;
        this.priority = priority;
        this.goalSetDate = goalSetDate;
        this.probableCompletionDate = probableCompletionDate;
        this.actualCompletionDate = actualCompletionDate;
        this.currentStatus = currentStatus;
        this.relatedOrgObjective = relatedOrgObjective;
        this.newSkillsAcquired = newSkillsAcquired;
        this.employeeId = employeeId;
    }

    
}
