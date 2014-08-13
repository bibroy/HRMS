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
public class AddcompensationIndicatorMasterForm extends org.apache.struts.action.ActionForm {
    
    private Integer id;
    private String[] indicator;
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public String[] getIndicator() {
        return indicator;
    }

    public void setIndicator(String[] indicator) {
        this.indicator = indicator;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

  
}
