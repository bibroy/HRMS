/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;

/**
 *
 * @author ranjans
 */
public class TrainingEmpInfo implements Serializable{

    private int empId;
    private String empName;
    private String empCode;
    private Integer daysOfExp;
    private Integer pastExp;    
    private String exp;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getDaysOfExp() {
        return daysOfExp;
    }

    public void setDaysOfExp(Integer daysOfExp) {
        this.daysOfExp = daysOfExp;
    }

    public String getEmpCode() {
        return empCode;
    }

    public void setEmpCode(String empCode) {
        this.empCode = empCode;
    }

    public Integer getPastExp() {
        return pastExp;
    }

    public void setPastExp(Integer pastExp) {
        this.pastExp = pastExp;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }
}