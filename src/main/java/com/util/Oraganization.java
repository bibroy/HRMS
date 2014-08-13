/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;
import java.io.Serializable;

/**
 *
 * @author pradipto
 */
public class Oraganization implements Serializable {

    private String employeeId;
    private String firstName;
    private String lastName;
    private String supervisorId;
    private String supervisorname;

    public String getSupervisorname() {
        return supervisorname;
    }

    public void setSupervisorname(String supervisorname) {
        this.supervisorname = supervisorname;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }




}
