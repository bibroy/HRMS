/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author computer1
 */
public class compensationForm extends org.apache.struts.action.ActionForm {
    
  private String company;
    private String department;
    private String designation;
    private String increment;
    private String method;
    private String from;
    private String to;
    private String incrementdatefrom;
    private String incrementdateto;
    private Integer[] checked;

    public Integer[] getChecked() {
        return checked;
    }

    public void setChecked(Integer[] checked) {
        this.checked = checked;
    }


    public String getIncrementdatefrom() {
        return incrementdatefrom;
    }

    public void setIncrementdatefrom(String incrementdatefrom) {
        this.incrementdatefrom = incrementdatefrom;
    }

    public String getIncrementdateto() {
        return incrementdateto;
    }

    public void setIncrementdateto(String incrementdateto) {
        this.incrementdateto = incrementdateto;
    }


    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }




    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getIncrement() {
        return increment;
    }

    public void setIncrement(String increment) {
        this.increment = increment;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
}
