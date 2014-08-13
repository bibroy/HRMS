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
 * @author pradipto
 */
public class SuccessorForm extends org.apache.struts.action.ActionForm {

    private String id;
    private String positionID;
    private String succesorID;
    private String type;
    private String entryDate;
     private String[] employee;
     private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
     

    public String[] getEmployee() {
        return employee;
    }

    public void setEmployee(String[] employee) {
        this.employee = employee;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }

    public String getSuccesorID() {
        return succesorID;
    }

    public void setSuccesorID(String succesorID) {
        this.succesorID = succesorID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }





   
}
