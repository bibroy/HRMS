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
public class ProjectJobsForm extends org.apache.struts.action.ActionForm {

    private Integer id;
    private String project;
    private String jobName;
    private String jobDesc;
    private String skillsReq;
    private Integer manpowerReq;
    private Integer allocatedManpower;
    private String status;
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
    public Integer getAllocatedManpower() {
        return allocatedManpower;
    }

    public void setAllocatedManpower(Integer allocatedManpower) {
        this.allocatedManpower = allocatedManpower;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public Integer getManpowerReq() {
        return manpowerReq;
    }

    public void setManpowerReq(Integer manpowerReq) {
        this.manpowerReq = manpowerReq;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getSkillsReq() {
        return skillsReq;
    }

    public void setSkillsReq(String skillsReq) {
        this.skillsReq = skillsReq;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ProjectJobsForm() {
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
