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
 * @author Pradipto
 */
public class EmpSkillForm extends org.apache.struts.action.ActionForm {

       private Integer id;
       private String employeid;
       private String skills;
       private String proficiency;
       private String lastUsedt;
       private String method;

    public String getLastUsedt() {
        return lastUsedt;
    }

    public void setLastUsedt(String lastUsedt) {
        this.lastUsedt = lastUsedt;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getEmployeid() {
        return employeid;
    }

    public void setEmployeid(String employeid) {
        this.employeid = employeid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

       
    public EmpSkillForm() {
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
