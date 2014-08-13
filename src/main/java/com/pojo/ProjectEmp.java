/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Sumit Kumar
 */
public class ProjectEmp implements Serializable {
    private BigDecimal id;
    private Project project;
    private String empId;
    private ProjectJobs job;
    private Date allocationDate;
    private String status;

    public ProjectEmp() {
    }

    public ProjectEmp(BigDecimal id, Project project, String empId, ProjectJobs job, Date allocationDate) {
        this.id = id;
        this.project = project;
        this.empId = empId;
        this.job = job;
        this.allocationDate = allocationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
    public Date getAllocationDate() {
        return allocationDate;
    }

    public void setAllocationDate(Date allocationDate) {
        this.allocationDate = allocationDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public ProjectJobs getJob() {
        return job;
    }

    public void setJob(ProjectJobs job) {
        this.job = job;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

}
