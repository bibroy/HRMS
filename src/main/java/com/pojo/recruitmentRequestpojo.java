/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author computer1
 */
public class recruitmentRequestpojo implements java.io.Serializable {
     private Integer id;
    private  Integer nov;
    private String quali;
    private Date lastdate;
    private String exp;
     private String post;
    private String method;
    private String department;
    private String skill;

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }


    public recruitmentRequestpojo() {

    }

    public recruitmentRequestpojo(Integer id, Integer nov) {
        this.id = id;
        this.nov = nov;
    }


    public recruitmentRequestpojo(Integer id, Integer nov, String quali, Date lastdate, String exp, String post, String method, String department, String skill) {
        this.id = id;
        this.nov = nov;
        this.quali = quali;
        this.lastdate = lastdate;
        this.exp = exp;
        this.post = post;
        this.method = method;
        this.department = department;
        this.skill = skill;
    }
    

  

 

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNov() {
        return nov;
    }

    public void setNov(Integer nov) {
        this.nov = nov;
    }

    public Date getLastdate() {
        return lastdate;
    }

    public void setLastdate(Date lastdate) {
        this.lastdate = lastdate;
    }


   

  
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

   

 

    public String getQuali() {
        return quali;
    }

    public void setQuali(String quali) {
        this.quali = quali;
    }


}
