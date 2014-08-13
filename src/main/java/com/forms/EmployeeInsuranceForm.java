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
public class EmployeeInsuranceForm extends org.apache.struts.action.ActionForm {

    private Integer id;
    private String employeeId;
    private String insuranceNo;
    private String insuranceProvider;
    private Integer premiumAmount;
    private String premiumDate;
    private Integer insuredAmount;
    private String maturityDate;
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    
    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInsuranceNo() {
        return insuranceNo;
    }

    public void setInsuranceNo(String insuranceNo) {
        this.insuranceNo = insuranceNo;
    }

    public String getInsuranceProvider() {
        return insuranceProvider;
    }

    public void setInsuranceProvider(String insuranceProvider) {
        this.insuranceProvider = insuranceProvider;
    }

    public Integer getInsuredAmount() {
        return insuredAmount;
    }

    public void setInsuredAmount(Integer insuredAmount) {
        this.insuredAmount = insuredAmount;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    public Integer getPremiumAmount() {
        return premiumAmount;
    }

    public void setPremiumAmount(Integer premiumAmount) {
        this.premiumAmount = premiumAmount;
    }

    public String getPremiumDate() {
        return premiumDate;
    }

    public void setPremiumDate(String premiumDate) {
        this.premiumDate = premiumDate;
    }

   
    public EmployeeInsuranceForm() {
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
