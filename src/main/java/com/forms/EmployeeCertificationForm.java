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
 * @author Sumit Kumar
 */
public class EmployeeCertificationForm extends org.apache.struts.action.ActionForm {

    private Integer id;
    private String employeeId;
    private String certificationName;
    private String orgatizationName;
    private String subject;
    private String certifiedOnDate;
    private String renewedDate;
    private String renewedOnDate;
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    

    public String getCertificationName() {
        return certificationName;
    }

    public void setCertificationName(String certificationName) {
        this.certificationName = certificationName;
    }

    public String getCertifiedOnDate() {
        return certifiedOnDate;
    }

    public void setCertifiedOnDate(String certifiedOnDate) {
        this.certifiedOnDate = certifiedOnDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrgatizationName() {
        return orgatizationName;
    }

    public void setOrgatizationName(String orgatizationName) {
        this.orgatizationName = orgatizationName;
    }

    public String getRenewedDate() {
        return renewedDate;
    }

    public void setRenewedDate(String renewedDate) {
        this.renewedDate = renewedDate;
    }

    public String getRenewedOnDate() {
        return renewedOnDate;
    }

    public void setRenewedOnDate(String renewedOnDate) {
        this.renewedOnDate = renewedOnDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }


    public EmployeeCertificationForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
    }
}
