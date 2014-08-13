/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;
import java.util.Date;
/**
 *
 * @author pradipto
 */
public class WorkShift {

    private String employeeID;
    private Integer shiftID;
    private String allocatedBY;
    private Date workStartDate;
    private Date dateOfAllocation;

    public Date getDateOfAllocation() {
        return dateOfAllocation;
    }

    public void setDateOfAllocation(Date dateOfAllocation) {
        this.dateOfAllocation = dateOfAllocation;
    }

    public Date getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(Date workStartDate) {
        this.workStartDate = workStartDate;
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

    public Integer getShiftID() {
        return shiftID;
    }

    public void setShiftID(Integer shiftID) {
        this.shiftID = shiftID;
    }

    

    



}
