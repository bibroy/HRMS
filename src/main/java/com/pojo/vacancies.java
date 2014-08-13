/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.util.Date;

/**
 *
 * @author Sumit Kumar
 */
public class vacancies implements java.io.Serializable{
    private Integer id;
    private String department;
    private String post;
    private String skillreq;
    private String quali;
    private String experience;
    private int noofvac;
    private String status;
    private Date lastDate;

    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    
    public vacancies() {
    }

    public vacancies(Integer id, String department, String post, String skillreq, String quali, String experience, int noofvac) {
        this.id = id;
        this.department = department;
        this.post = post;
        this.skillreq = skillreq;
        this.quali = quali;
        this.experience = experience;
        this.noofvac = noofvac;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSkillreq() {
        return skillreq;
    }

    public void setSkillreq(String skillreq) {
        this.skillreq = skillreq;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getNoofvac() {
        return noofvac;
    }

    public void setNoofvac(int noofvac) {
        this.noofvac = noofvac;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getQuali() {
        return quali;
    }

    public void setQuali(String quali) {
        this.quali = quali;
    }
    
}
