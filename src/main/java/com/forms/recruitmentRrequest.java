/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import java.util.Date;


/**
 *
 * @author computer1
 */
public class recruitmentRrequest extends org.apache.struts.action.ActionForm {
     private Integer id;
    private Integer nov;
    private String quali;
    private String lastdate;
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

    public void setDepartment(String Department) {
        this.department = Department;
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

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

   

   

  

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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
