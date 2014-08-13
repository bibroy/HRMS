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
public class EmpSkills implements Serializable{

       private Integer id;
       private String employeid;
       private String skills;
       private String proficiency;

    public EmpSkills() {
    }

    public String getEmployeid() {
        return employeid;
    }

    public void setEmployeid(String employeid) {
        this.employeid = employeid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProficiency() {
        return proficiency;
    }

    public void setProficiency(String proficiency) {
        this.proficiency = proficiency;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

}
