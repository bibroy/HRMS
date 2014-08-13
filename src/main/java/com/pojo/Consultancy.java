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
public class Consultancy implements Serializable{

    int consultancyId;
    String consultancyName;
    String skillId; // -- It is typically skillId provided by SkillMaster
    String status;

    public int getConsultancyId() {
        return consultancyId;
    }

    public void setConsultancyId(int consultancyId) {
        this.consultancyId = consultancyId;
    }

    public String getConsultancyName() {
        return consultancyName;
    }

    public void setConsultancyName(String consultancyName) {
        this.consultancyName = consultancyName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSkillId() {
        return skillId;
    }

    public void setSkillId(String skillId) {
        this.skillId = skillId;
    }
}
