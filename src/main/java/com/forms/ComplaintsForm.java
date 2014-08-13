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
public class ComplaintsForm extends org.apache.struts.action.ActionForm {

    private Integer complainid;
    private String complaintext;
    private String suggestion;
    private String viewstatus;
    private String employeeid;
    private String approvalauthoriyEmployeeid;
    private String requestdate;
    private String approvaldate;
    private String subject;
    private String remarks;
    private String method;
    private String button;
    private Integer compno;
    private Integer totalcomp;

    public Integer getTotalcomp() {
        return totalcomp;
    }

    public void setTotalcomp(Integer totalcomp) {
        this.totalcomp = totalcomp;
    }
    
    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public Integer getCompno() {
        return compno;
    }

    public void setCompno(Integer compno) {
        this.compno = compno;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    
    public ComplaintsForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getApprovalauthoriyEmployeeid() {
        return approvalauthoriyEmployeeid;
    }

    public void setApprovalauthoriyEmployeeid(String approvalauthoriyEmployeeid) {
        this.approvalauthoriyEmployeeid = approvalauthoriyEmployeeid;
    }

    public String getApprovaldate() {
        return approvaldate;
    }

    public void setApprovaldate(String approvaldate) {
        this.approvaldate = approvaldate;
    }

    public Integer getComplainid() {
        return complainid;
    }

    public void setComplainid(Integer complainid) {
        this.complainid = complainid;
    }

    public String getComplaintext() {
        return complaintext;
    }

    public void setComplaintext(String complaintext) {
        this.complaintext = complaintext;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(String requestdate) {
        this.requestdate = requestdate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public String getViewstatus() {
        return viewstatus;
    }

    public void setViewstatus(String viewstatus) {
        this.viewstatus = viewstatus;
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
