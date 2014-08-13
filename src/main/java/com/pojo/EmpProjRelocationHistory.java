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
public class EmpProjRelocationHistory implements Serializable{

    private BigDecimal id;
    private String empId;
    private Project fromProj;
    private Project toProj;
    private ProjectJobs fromJob;
    private ProjectJobs toJob;
    private Date relocationDate;

    public EmpProjRelocationHistory() {
    }

    public EmpProjRelocationHistory(BigDecimal id, String empId, Project fromProj, Project toProj, ProjectJobs fromJob, ProjectJobs toJob, Date relocationDate) {
        this.id = id;
        this.empId = empId;
        this.fromProj = fromProj;
        this.toProj = toProj;
        this.fromJob = fromJob;
        this.toJob = toJob;
        this.relocationDate = relocationDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public ProjectJobs getFromJob() {
        return fromJob;
    }

    public void setFromJob(ProjectJobs fromJob) {
        this.fromJob = fromJob;
    }

    public Project getFromProj() {
        return fromProj;
    }

    public void setFromProj(Project fromProj) {
        this.fromProj = fromProj;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public Date getRelocationDate() {
        return relocationDate;
    }

    public void setRelocationDate(Date relocationDate) {
        this.relocationDate = relocationDate;
    }

    public ProjectJobs getToJob() {
        return toJob;
    }

    public void setToJob(ProjectJobs toJob) {
        this.toJob = toJob;
    }

    public Project getToProj() {
        return toProj;
    }

    public void setToProj(Project toProj) {
        this.toProj = toProj;
    }

}
