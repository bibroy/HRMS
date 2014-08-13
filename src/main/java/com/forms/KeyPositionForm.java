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
public class KeyPositionForm extends org.apache.struts.action.ActionForm {
    
    
    private Integer id;
    private String positionTitle;
    private String incumbentName;
    private String retirementStatus;
    private String criticality;
    private Integer staffReady;
    private Integer staffReadyNext;
    private String skills;
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public String getCriticality() {
        return criticality;
    }

    public void setCriticality(String criticality) {
        this.criticality = criticality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIncumbentName() {
        return incumbentName;
    }

    public void setIncumbentName(String incumbentName) {
        this.incumbentName = incumbentName;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getRetirementStatus() {
        return retirementStatus;
    }

    public void setRetirementStatus(String retirementStatus) {
        this.retirementStatus = retirementStatus;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Integer getStaffReady() {
        return staffReady;
    }

    public void setStaffReady(Integer staffReady) {
        this.staffReady = staffReady;
    }

    public Integer getStaffReadyNext() {
        return staffReadyNext;
    }

    public void setStaffReadyNext(Integer staffReadyNext) {
        this.staffReadyNext = staffReadyNext;
    }

    
    public KeyPositionForm() {
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
