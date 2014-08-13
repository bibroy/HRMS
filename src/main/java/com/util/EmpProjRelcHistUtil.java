/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import java.io.Serializable;

/**
 *
 * @author Sumit Kumar
 */
public class EmpProjRelcHistUtil implements Serializable{
    private Integer id;
    private String empId;
    private String fromProj;
    private String toProj;
    private String fromJob;
    private String toJob;
    private String relocationDate;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFromJob() {
        return fromJob;
    }

    public void setFromJob(String fromJob) {
        this.fromJob = fromJob;
    }

    public String getFromProj() {
        return fromProj;
    }

    public void setFromProj(String fromProj) {
        this.fromProj = fromProj;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRelocationDate() {
        return relocationDate;
    }

    public void setRelocationDate(String relocationDate) {
        this.relocationDate = relocationDate;
    }

    public String getToJob() {
        return toJob;
    }

    public void setToJob(String toJob) {
        this.toJob = toJob;
    }

    public String getToProj() {
        return toProj;
    }

    public void setToProj(String toProj) {
        this.toProj = toProj;
    }

    public EmpProjRelcHistUtil() {
    }

    
}
