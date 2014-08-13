/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import com.pojo.VisaPassortDetails;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Sumit Kumar
 */
public class VisaPassportForm extends org.apache.struts.action.ActionForm {

    private BigDecimal id;
     private String employeeId;
     private String passportNo;
     private String passportIssueDate;
     private String passportIssuedBy;
     private String passportValidUpto;
     private String visaNo;
     private String visaType;
     private String visaIssuedBy;
     private String visaIssueDate;
     private String visaValidUpto;
     private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
     
     private List<VisaPassortDetails> visalist;

    public List<VisaPassortDetails> getVisalist() {
        return visalist;
    }

    public void setVisalist(List<VisaPassortDetails> visalist) {
        this.visalist = visalist;
    }
     
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

   
    public String getPassportIssuedBy() {
        return passportIssuedBy;
    }

    public void setPassportIssuedBy(String passportIssuedBy) {
        this.passportIssuedBy = passportIssuedBy;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

   

    public String getVisaIssuedBy() {
        return visaIssuedBy;
    }

    public void setVisaIssuedBy(String visaIssuedBy) {
        this.visaIssuedBy = visaIssuedBy;
    }

    public String getVisaNo() {
        return visaNo;
    }

    public void setVisaNo(String visaNo) {
        this.visaNo = visaNo;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(String passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public String getPassportValidUpto() {
        return passportValidUpto;
    }

    public void setPassportValidUpto(String passportValidUpto) {
        this.passportValidUpto = passportValidUpto;
    }

    public String getVisaIssueDate() {
        return visaIssueDate;
    }

    public void setVisaIssueDate(String visaIssueDate) {
        this.visaIssueDate = visaIssueDate;
    }

    public String getVisaValidUpto() {
        return visaValidUpto;
    }

    public void setVisaValidUpto(String visaValidUpto) {
        this.visaValidUpto = visaValidUpto;
    }




    public VisaPassportForm() {
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
