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
public class TransportForm extends org.apache.struts.action.ActionForm {

    private Integer requestId;
    private String employeeid;
    private String transportname;
    private String transportFrom;
    private String transportTo;
    private String transportDate;
    private String departuretimehour;
    private String departuretimemin;
    private String departureampm;
    private String reason;
    private String requeststatus;
    private String tomail;
    private String approvalauthoriyEmployeeid;
    private String requestdate;
    private String approvaldate;
    private String method;
    private String whyReject;
    private String hiddenId;
    private String button;

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

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

    public String getDepartureampm() {
        return departureampm;
    }

    public void setDepartureampm(String departureampm) {
        this.departureampm = departureampm;
    }

    public String getDeparturetimehour() {
        return departuretimehour;
    }

    public void setDeparturetimehour(String departuretimehour) {
        this.departuretimehour = departuretimehour;
    }

    public String getDeparturetimemin() {
        return departuretimemin;
    }

    public void setDeparturetimemin(String departuretimemin) {
        this.departuretimemin = departuretimemin;
    }

  

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    public String getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(String requestdate) {
        this.requestdate = requestdate;
    }

    public String getRequeststatus() {
        return requeststatus;
    }

    public void setRequeststatus(String requeststatus) {
        this.requeststatus = requeststatus;
    }

    public String getTomail() {
        return tomail;
    }

    public void setTomail(String tomail) {
        this.tomail = tomail;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public void setTransportDate(String transportDate) {
        this.transportDate = transportDate;
    }

    public String getTransportFrom() {
        return transportFrom;
    }

    public void setTransportFrom(String transportFrom) {
        this.transportFrom = transportFrom;
    }

    public String getTransportTo() {
        return transportTo;
    }

    public void setTransportTo(String transportTo) {
        this.transportTo = transportTo;
    }

    public String getTransportname() {
        return transportname;
    }

    public void setTransportname(String transportname) {
        this.transportname = transportname;
    }


    public TransportForm() {
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
