/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Sumit Kumar
 */
public class GoalSettingForm extends org.apache.struts.action.ActionForm {
    
    private Integer goalId;
    private String[] goalTitle;
    private String[] goalDesc;
    private Integer[] priority;
    private String goalSetDate;
    private String[] probableCompletionDate;
    private String[] actualCompletionDate;
    private String currentStatus;
    private String[] relatedOrgObjective;
    private String newSkillsAcquired;
    private String employeeId;
    private String method;
    private Integer[] goals;

    public Integer[] getGoals() {
        return goals;
    }

    public void setGoals(Integer[] goals) {
        this.goals = goals;
    }


    
    public String[] getActualCompletionDate() {
        return actualCompletionDate;
    }

    public void setActualCompletionDate(String[] actualCompletionDate) {
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

    public String[] getGoalDesc() {
        return goalDesc;
    }

    public void setGoalDesc(String[] goalDesc) {
        this.goalDesc = goalDesc;
    }

    public Integer getGoalId() {
        return goalId;
    }

    public void setGoalId(Integer goalId) {
        this.goalId = goalId;
    }

    public String getGoalSetDate() {
        return goalSetDate;
    }

    public void setGoalSetDate(String goalSetDate) {
        this.goalSetDate = goalSetDate;
    }

    public String[] getGoalTitle() {
        return goalTitle;
    }

    public void setGoalTitle(String[] goalTitle) {
        this.goalTitle = goalTitle;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNewSkillsAcquired() {
        return newSkillsAcquired;
    }

    public void setNewSkillsAcquired(String newSkillsAcquired) {
        this.newSkillsAcquired = newSkillsAcquired;
    }

    public Integer[] getPriority() {
        return priority;
    }

    public void setPriority(Integer[] priority) {
        this.priority = priority;
    }

    public String[] getProbableCompletionDate() {
        return probableCompletionDate;
    }

    public void setProbableCompletionDate(String[] probableCompletionDate) {
        this.probableCompletionDate = probableCompletionDate;
    }

    public String[] getRelatedOrgObjective() {
        return relatedOrgObjective;
    }

    public void setRelatedOrgObjective(String[] relatedOrgObjective) {
        this.relatedOrgObjective = relatedOrgObjective;
    }

   
    
    public GoalSettingForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
    }
}
