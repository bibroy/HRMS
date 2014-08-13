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

public class AttendanceForm extends org.apache.struts.action.ActionForm {

    private Integer id;
    private String attdate;
    private String userid;
    private String empname;
    private String department;
    private String shiftname;
    private String deviceId;
    private String timein;
    private String latein;
    private String breakout;
    private String breakin;
    private String timeout;
    private String earlyout;
    private String totalwork;
    private String overtime;
    private String method;


    public String getAttdate() {
        return attdate;
    }

    public void setAttdate(String attdate) {
        this.attdate = attdate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getBreakin() {
        return breakin;
    }

    public void setBreakin(String breakin) {
        this.breakin = breakin;
    }

    public String getBreakout() {
        return breakout;
    }

    public void setBreakout(String breakout) {
        this.breakout = breakout;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getEarlyout() {
        return earlyout;
    }

    public void setEarlyout(String earlyout) {
        this.earlyout = earlyout;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLatein() {
        return latein;
    }

    public void setLatein(String latein) {
        this.latein = latein;
    }

    public String getOvertime() {
        return overtime;
    }

    public void setOvertime(String overtime) {
        this.overtime = overtime;
    }

    public String getShiftname() {
        return shiftname;
    }

    public void setShiftname(String shiftname) {
        this.shiftname = shiftname;
    }

    public String getTimein() {
        return timein;
    }

    public void setTimein(String timein) {
        this.timein = timein;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getTotalwork() {
        return totalwork;
    }

    public void setTotalwork(String totalwork) {
        this.totalwork = totalwork;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    
    public AttendanceForm() {
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
