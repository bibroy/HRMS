/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;

/**
 *
 * @author Sumit Kumar
 */
public class KeyPosition implements Serializable{

    private Integer id;
    private String positionTitle;
    private String incumbentName;
    private String retirementStatus;
    private String criticality;
    private Integer staffReady;
    private Integer staffReadyNext;
    private String skills;

    public KeyPosition() {
    }

    public KeyPosition(Integer id, String positionTitle, String incumbentName, String retirementStatus, String criticality, Integer staffReady, Integer staffReadyNext, String skills) {
        this.id = id;
        this.positionTitle = positionTitle;
        this.incumbentName = incumbentName;
        this.retirementStatus = retirementStatus;
        this.criticality = criticality;
        this.staffReady = staffReady;
        this.staffReadyNext = staffReadyNext;
        this.skills = skills;
    }



    public String getCriticality() {
        return criticality;
    }

    public void setCriticality(String criticality) {
        this.criticality = criticality;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIncumbentName() {
        return incumbentName;
    }

    public void setIncumbentName(String incumbentName) {
        this.incumbentName = incumbentName;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getRetirementStatus() {
        return retirementStatus;
    }

    public void setRetirementStatus(String retirementStatus) {
        this.retirementStatus = retirementStatus;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public Integer getStaffReady() {
        return staffReady;
    }

    public void setStaffReady(Integer staffReady) {
        this.staffReady = staffReady;
    }

    public Integer getStaffReadyNext() {
        return staffReadyNext;
    }

    public void setStaffReadyNext(Integer staffReadyNext) {
        this.staffReadyNext = staffReadyNext;
    }

}
