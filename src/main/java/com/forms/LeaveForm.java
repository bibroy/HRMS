/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forms;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Sumit Kumar
 */
public class LeaveForm extends org.apache.struts.action.ActionForm {

    private String empId;
    private String fromDt;
    private String toDt;
    private String reason;
    private String leaveAddress;
    private Integer leavetype;
    private Double day;
    private String email;
    private String leaveContactNo;
    private String method;
    private String button;
    private int leaveid;
    private Integer hiddenId;
    private Double noOfDays;
    private String whyReject;

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }




    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFromDt() {
        return fromDt;
    }

    public void setFromDt(String fromDt) {
        this.fromDt = fromDt;
    }

    public Integer getHiddenId() {
        return hiddenId;
    }

    public void setHiddenId(Integer hiddenId) {
        this.hiddenId = hiddenId;
    }

    public String getLeaveAddress() {
        return leaveAddress;
    }

    public void setLeaveAddress(String leaveAddress) {
        this.leaveAddress = leaveAddress;
    }

    public String getLeaveContactNo() {
        return leaveContactNo;
    }

    public void setLeaveContactNo(String leaveContactNo) {
        this.leaveContactNo = leaveContactNo;
    }

    public int getLeaveid() {
        return leaveid;
    }

    public void setLeaveid(int leaveid) {
        this.leaveid = leaveid;
    }

    public Integer getLeavetype() {
        return leavetype;
    }

    public void setLeavetype(Integer leavetype) {
        this.leavetype = leavetype;
    }



    

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Double getDay() {
        return day;
    }

    public void setDay(Double day) {
        this.day = day;
    }

    public Double getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(Double noOfDays) {
        this.noOfDays = noOfDays;
    }




    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getToDt() {
        return toDt;
    }

    public void setToDt(String toDt) {
        this.toDt = toDt;
    }

    public String getWhyReject() {
        return whyReject;
    }

    public void setWhyReject(String whyReject) {
        this.whyReject = whyReject;
    }



    public LeaveForm() {
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
