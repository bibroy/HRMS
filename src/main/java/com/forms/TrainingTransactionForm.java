/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import java.util.List;
import org.apache.struts.action.ActionForm;

/**
 *
 * @author ranjans
 */
public class TrainingTransactionForm extends ActionForm{

    private  int requestId;
    private  String employeeId;
    private  int approvedBy; // -- It is approved or disapproved employee Id
    private  String employeeName;
    private  String ddlDepartmentName;
    private  String ddlSkillsName;
    private  String ddlTrainingName;
    private  String availableFrom;
    private  String availableTo;
    private  String method;
    private  String ddlEmployeeName;
    private  String departmentName; // -- Add for HR
    private  String skillName; // -- Add for HR
    private  String trainingName; // -- Add for HR
    private  String status; // -- It is use for define the status of request
    private  String[] ddlEmployees;
    private String jobType;
    private String jobName;
    private String trainingEmployeeId;
    private String msg;
    private int count;
    private String flg;
    private String department;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String[] getDdlEmployees() {
        return ddlEmployees;
    }

    public void setDdlEmployees(String[] ddlEmployees) {
        this.ddlEmployees = ddlEmployees;
    }  
   


    public String getAvailableFrom() {
        return availableFrom;
    }

    public void setAvailableFrom(String availableFrom) {
        this.availableFrom = availableFrom;
    }

    public String getAvailableTo() {
        return availableTo;
    }

    public void setAvailableTo(String availableTo) {
        this.availableTo = availableTo;
    }

    public String getDdlDepartmentName() {
        return ddlDepartmentName;
    }

    public void setDdlDepartmentName(String ddlDepartmentName) {
        this.ddlDepartmentName = ddlDepartmentName;
    }

    public String getDdlSkillsName() {
        return ddlSkillsName;
    }

    public void setDdlSkillsName(String ddlSkillsName) {
        this.ddlSkillsName = ddlSkillsName;
    }

    
    public String getDdlTrainingName() {
        return ddlTrainingName;
    }

    public void setDdlTrainingName(String ddlTrainingName) {
        this.ddlTrainingName = ddlTrainingName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getDdlEmployeeName() {
        return ddlEmployeeName;
    }

    public void setDdlEmployeeName(String ddlEmployeeName) {
        this.ddlEmployeeName = ddlEmployeeName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(int approvedBy) {
        this.approvedBy = approvedBy;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getTrainingEmployeeId() {
        return trainingEmployeeId;
    }

    public void setTrainingEmployeeId(String trainingEmployeeId) {
        this.trainingEmployeeId = trainingEmployeeId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getFlg() {
        return flg;
    }

    public void setFlg(String flg) {
        this.flg = flg;
    }
}