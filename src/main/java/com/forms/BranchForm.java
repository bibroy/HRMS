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
public class BranchForm extends org.apache.struts.action.ActionForm {
    private Integer branchId;
     private String branchName;
     private String branchCode;
     private String branchAddress;
     private Integer branchStateid;
     private Integer branchCityid;
     private String branchPincode;
     private String branchCreationdate;
     private Integer branchCreatorid;
     private String branchType;
     private Integer companyId;
     private String currency;
     private Integer modifierId;
     private String modifiedDate;
     private String branchfax;
     private String branchemail;
     private String contactNumber;
     private Integer branchCountryid;
     private String status;
     private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

     
    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public Integer getBranchCityid() {
        return branchCityid;
    }

    public void setBranchCityid(Integer branchCityid) {
        this.branchCityid = branchCityid;
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public Integer getBranchCountryid() {
        return branchCountryid;
    }

    public void setBranchCountryid(Integer branchCountryid) {
        this.branchCountryid = branchCountryid;
    }

    public String getBranchCreationdate() {
        return branchCreationdate;
    }

    public void setBranchCreationdate(String branchCreationdate) {
        this.branchCreationdate = branchCreationdate;
    }

    public Integer getBranchCreatorid() {
        return branchCreatorid;
    }

    public void setBranchCreatorid(Integer branchCreatorid) {
        this.branchCreatorid = branchCreatorid;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getBranchPincode() {
        return branchPincode;
    }

    public void setBranchPincode(String branchPincode) {
        this.branchPincode = branchPincode;
    }

    public Integer getBranchStateid() {
        return branchStateid;
    }

    public void setBranchStateid(Integer branchStateid) {
        this.branchStateid = branchStateid;
    }

    public String getBranchType() {
        return branchType;
    }

    public void setBranchType(String branchType) {
        this.branchType = branchType;
    }

    public String getBranchemail() {
        return branchemail;
    }

    public void setBranchemail(String branchemail) {
        this.branchemail = branchemail;
    }

    public String getBranchfax() {
        return branchfax;
    }

    public void setBranchfax(String branchfax) {
        this.branchfax = branchfax;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public Integer getModifierId() {
        return modifierId;
    }

    public void setModifierId(Integer modifierId) {
        this.modifierId = modifierId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



    public BranchForm() {
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
        if (getBranchName() == null || getBranchName().length() < 1) {
            errors.add("name", new ActionMessage("error.name.required","Branch"));
            // TODO: add 'error.name.required' key to your resources
        }
        return errors;
    }
}
