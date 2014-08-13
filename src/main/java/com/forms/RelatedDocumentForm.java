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
public class RelatedDocumentForm extends org.apache.struts.action.ActionForm {

    private Integer requestcode;
    private String employeeid;
    private String documentsname;
    private String reason;
    private String status;
    private String tomail;
    private String approvalauthoriyEmployeeid;
    private String requestdate;
    private String approvaldate;
    private String method;
    private String whyReject;
    private String hiddenId;

    public String getHiddenId() {
        return hiddenId;
    }

    public void setHiddenId(String hiddenId) {
        this.hiddenId = hiddenId;
    }

    public String getWhyReject() {
        return whyReject;
    }

    public void setWhyReject(String whyReject) {
        this.whyReject = whyReject;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

    public String getDocumentsname() {
        return documentsname;
    }

    public void setDocumentsname(String documentsname) {
        this.documentsname = documentsname;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getRequestcode() {
        return requestcode;
    }

    public void setRequestcode(Integer requestcode) {
        this.requestcode = requestcode;
    }

    public String getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(String requestdate) {
        this.requestdate = requestdate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTomail() {
        return tomail;
    }

    public void setTomail(String tomail) {
        this.tomail = tomail;
    }

    public RelatedDocumentForm() {
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
