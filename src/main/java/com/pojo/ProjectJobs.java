/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 *
 * @author Sumit Kumar
 */
public class ProjectJobs implements Serializable{
    private BigDecimal id;
    private Project project;
    private String jobName;
    private String jobDesc;
    private String skillsReq;
    private Integer manpowerReq;
    private Integer allocatedManpower;
    private String status;

    public ProjectJobs() {
    }

    public ProjectJobs(BigDecimal id, Project project, String jobName, String jobDesc, String skillsReq, Integer manpowerReq, Integer allocatedManpower, String status) {
        this.id = id;
        this.project = project;
        this.jobName = jobName;
        this.jobDesc = jobDesc;
        this.skillsReq = skillsReq;
        this.manpowerReq = manpowerReq;
        this.allocatedManpower = allocatedManpower;
        this.status = status;
    }

    public Integer getAllocatedManpower() {
        return allocatedManpower;
    }

    public void setAllocatedManpower(Integer allocatedManpower) {
        this.allocatedManpower = allocatedManpower;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
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

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public String getSkillsReq() {
        return skillsReq;
    }

    public void setSkillsReq(String skillsReq) {
        this.skillsReq = skillsReq;
    }

   

}
