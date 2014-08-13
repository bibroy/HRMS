/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 * 
 * @author shrayanti
 */
public class ProjectForm extends org.apache.struts.action.ActionForm {
    private String projectCode;
    private String projectName;
    private int clientId;
    private int managerId;
    private String desc;
    private String startDate;
    private String actualEndDate;
    private String actaulStartDate;
    private String dueDate;
    private String endDate;
    private Integer month;
    private String projectStatus;
    private String status;
    private String method;
    private String button;
    private String manager_id;
    private String project_technology;
    private String project_description;
    private String maximum_resource;
    private int id;
    private int department_id;
    private int company_code;
    private int branch_code;
    private int clId;
    private String task_name;
    private String task_description;

    public String getTask_description() {
        return task_description;
    }

    public void setTask_description(String task_description) {
        this.task_description = task_description;
    }
    
    public String getTask_name() {
        return task_name;
    }

    public void setTask_name(String task_name) {
        this.task_name = task_name;
    }
    
    public int getClId() {
        return clId;
    }

    public void setClId(int clId) {
        this.clId = clId;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    public int getBranch_code() {
        return branch_code;
    }

    public void setBranch_code(int branch_code) {
        this.branch_code = branch_code;
    }

    public int getCompany_code() {
        return company_code;
    }

    public void setCompany_code(int company_code) {
        this.company_code = company_code;
    }

   
   
    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

   

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

  

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

  

    public String getProjectCode() {
        return projectCode;
    }

    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(String projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public ProjectForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getManager_id() {
        return manager_id;
    }

    public void setManager_id(String manager_id) {
        this.manager_id = manager_id;
    }

  

    public String getMaximum_resource() {
        return maximum_resource;
    }

    public void setMaximum_resource(String maximum_resource) {
        this.maximum_resource = maximum_resource;
    }

    public String getProject_technology() {
        return project_technology;
    }

    public void setProject_technology(String project_technology) {
        this.project_technology = project_technology;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getProject_description() {
        return project_description;
    }

    public void setProject_description(String project_description) {
        this.project_description = project_description;
    }

    public String getActaulStartDate() {
        return actaulStartDate;
    }

    public void setActaulStartDate(String actaulStartDate) {
        this.actaulStartDate = actaulStartDate;
    }

    public String getActualEndDate() {
        return actualEndDate;
    }

    public void setActualEndDate(String actualEndDate) {
        this.actualEndDate = actualEndDate;
    }

  
    
}
