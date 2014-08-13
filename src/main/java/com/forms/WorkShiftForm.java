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
 * @author Pradipto Roy
 */
public class WorkShiftForm extends org.apache.struts.action.ActionForm {
    private String employeeID;
    private String shiftID;
    private String allocatedBY;
    private String workStartDate;
    private String dateOfAllocation;

    private String timesheetdate;

    private String method;

    public String getTimesheetdate() {
        return timesheetdate;
    }

    public void setTimesheetdate(String timesheetdate) {
        this.timesheetdate = timesheetdate;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    

    public String getDateOfAllocation() {
        return dateOfAllocation;
    }

    public void setDateOfAllocation(String DateOfAllocation) {
        this.dateOfAllocation = DateOfAllocation;
    }

    public String getAllocatedBY() {
        return allocatedBY;
    }

    public void setAllocatedBY(String allocatedBY) {
        this.allocatedBY = allocatedBY;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getShiftID() {
        return shiftID;
    }

    public void setShiftID(String shiftID) {
        this.shiftID = shiftID;
    }

    public String getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(String workStartDate) {
        this.workStartDate = workStartDate;
    }


    /**
     *
     */
    public WorkShiftForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
   
}
