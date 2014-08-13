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
public class TimesheetMappingForm extends org.apache.struts.action.ActionForm {

   private Integer headerid;
    private String method;
      private String empid;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public Integer getHeaderid() {
        return headerid;
    }

    public void setHeaderid(Integer headerid) {
        this.headerid = headerid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


}



