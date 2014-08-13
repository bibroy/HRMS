/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author pradipto
 */
public class WorkingTimeReportOFEmployees implements Serializable {

    private Integer workingHour;
    private String  employeeId;
    private String  firstName;
    private String  projectName;
    private BigDecimal projectid;
    private Date timesheetdate;

    public Date getTimesheetdate() {
        return timesheetdate;
    }

    public void setTimesheetdate(Date timesheetdate) {
        this.timesheetdate = timesheetdate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public BigDecimal getProjectid() {
        return projectid;
    }

    public void setProjectid(BigDecimal projectid) {
        this.projectid = projectid;
    }

    public Integer getWorkingHour() {
        return workingHour;
    }

    public void setWorkingHour(Integer workingHour) {
        this.workingHour = workingHour;
    }

}
