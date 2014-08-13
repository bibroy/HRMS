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
public class ConferenceRoomBookingForm extends org.apache.struts.action.ActionForm {

    private Integer conferenceroombookingcode;
     private String employeeid;

     private String roomno;
     private String bookingdate;
     private Integer fromhour;
     private Integer frommin;
     private Integer tohour;
     private Integer tomin;
     
     private String reason;
     private String status;
     private String approvalauthorityEmployeeid;
     private String requestdate;
     private String approvaldate;
     private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getApprovalauthorityEmployeeid() {
        return approvalauthorityEmployeeid;
    }

    public void setApprovalauthorityEmployeeid(String approvalauthorityEmployeeid) {
        this.approvalauthorityEmployeeid = approvalauthorityEmployeeid;
    }

    public String getApprovaldate() {
        return approvaldate;
    }

    public void setApprovaldate(String approvaldate) {
        this.approvaldate = approvaldate;
    }

    public String getBookingdate() {
        return bookingdate;
    }

    public void setBookingdate(String bookingdate) {
        this.bookingdate = bookingdate;
    }

    public Integer getConferenceroombookingcode() {
        return conferenceroombookingcode;
    }

    public void setConferenceroombookingcode(Integer conferenceroombookingcode) {
        this.conferenceroombookingcode = conferenceroombookingcode;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public Integer getFromhour() {
        return fromhour;
    }

    public void setFromhour(Integer fromhour) {
        this.fromhour = fromhour;
    }

    public Integer getFrommin() {
        return frommin;
    }

    public void setFrommin(Integer frommin) {
        this.frommin = frommin;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRequestdate() {
        return requestdate;
    }

    public void setRequestdate(String requestdate) {
        this.requestdate = requestdate;
    }

    public String getRoomno() {
        return roomno;
    }

    public void setRoomno(String roomno) {
        this.roomno = roomno;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getTohour() {
        return tohour;
    }

    public void setTohour(Integer tohour) {
        this.tohour = tohour;
    }

    public Integer getTomin() {
        return tomin;
    }

    public void setTomin(Integer tomin) {
        this.tomin = tomin;
    }



    public ConferenceRoomBookingForm() {
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
