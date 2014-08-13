/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sujatas
 */

public class LeaveStatusPeremployee implements Serializable {
   
  private Integer id;
    private String empid;
   
    private Integer leaveid;
   
    private Double totalleave;
   
    private Double leavetaken;
   // private LeaveDetails ld;
    //private EmployeeMaster employee;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public Integer getLeaveid() {
        return leaveid;
    }

    public void setLeaveid(Integer leaveid) {
        this.leaveid = leaveid;
    }

    public Double getTotalleave() {
        return totalleave;
    }

    public void setTotalleave(Double totalleave) {
        this.totalleave = totalleave;
    }

    public Double getLeavetaken() {
        return leavetaken;
    }

    public void setLeavetaken(Double leavetaken) {
        this.leavetaken = leavetaken;
    }


    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the ld
     */

}
