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
 * @author shrayanti
 */
public class ClientGroupForm extends org.apache.struts.action.ActionForm {

    private Integer gr_master_id;
    private String gr_code;
    private String gr_description;
    private String gr_name;
    private String gr_status;
    private String method;
    private int managerId;

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }


    public Integer getGr_master_id() {
        return gr_master_id;
    }

    public void setGr_master_id(Integer gr_master_id) {
        this.gr_master_id = gr_master_id;
    }

 
    public String getGr_code() {
        return gr_code;
    }

    public void setGr_code(String gr_code) {
        this.gr_code = gr_code;
    }

    public String getGr_description() {
        return gr_description;
    }

    public void setGr_description(String gr_description) {
        this.gr_description = gr_description;
    }

    public String getGr_name() {
        return gr_name;
    }

    public void setGr_name(String gr_name) {
        this.gr_name = gr_name;
    }

    public String getGr_status() {
        return gr_status;
    }

    public void setGr_status(String gr_status) {
        this.gr_status = gr_status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

}
