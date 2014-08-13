/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMapping;
/**
 *
 * @author 
 */
public class CompanyForm extends org.apache.struts.action.ActionForm {

    private String companyName;
    private String contactNo;
    private String regaddress;
    private String corptaddress;
  //  private String location;
    private String method;
    private String status;

    private Integer companyTypeId;
    private String businessNature;
    private String holidayweeklyoff;
    private String day;
    private String leaveweeklyoff;
    private String lcalculation;
    private int id = 0;
    private String fromDate;
    private String toDate;
    private Integer grcompanyId;
    private String corparateAddr_pincode;
    private String registerAddr_pincode;
    private Integer countryOriginId;
    private Integer stateId;
    private Integer cityId;
    private String finstartyear;
    private String finendyear;
    private Double ptaxrate;
    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHolidayweeklyoff() {
        return holidayweeklyoff;
    }

    public void setHolidayweeklyoff(String holidayweeklyoff) {
        this.holidayweeklyoff = holidayweeklyoff;
    }

    public String getLcalculation() {
        return lcalculation;
    }

    public void setLcalculation(String lcalculation) {
        this.lcalculation = lcalculation;
    }

    public String getLeaveweeklyoff() {
        return leaveweeklyoff;
    }

    public void setLeaveweeklyoff(String leaveweeklyoff) {
        this.leaveweeklyoff = leaveweeklyoff;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBusinessNature() {
        return businessNature;
    }

    public void setBusinessNature(String businessNature) {
        this.businessNature = businessNature;
    }

    public Integer getCompanyTypeId() {
        return companyTypeId;
    }

    public void setCompanyTypeId(Integer companyTypeId) {
        this.companyTypeId = companyTypeId;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    
    public String getCorptaddress() {
        return corptaddress;
    }

    public void setCorptaddress(String corptaddress) {
        this.corptaddress = corptaddress;
    }

   /* public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }*/

    public String getRegaddress() {
        return regaddress;
    }

    public void setRegaddress(String regaddress) {
        this.regaddress = regaddress;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        /* if (getName() == null || getName().length() < 1) {
        errors.add("name", new ActionMessage("error.name.required"));
        // TODO: add 'error.name.required' key to your resources
        }*/
        return errors;
    }

    /**
     * @return the fromDate
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * @return the toDate
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Integer getGrcompanyId() {
        return grcompanyId;
    }

    public void setGrcompanyId(Integer grcompanyId) {
        this.grcompanyId = grcompanyId;
    }

    public String getCorparateAddr_pincode() {
        return corparateAddr_pincode;
    }

    public void setCorparateAddr_pincode(String corparateAddr_pincode) {
        this.corparateAddr_pincode = corparateAddr_pincode;
    }

    public String getRegisterAddr_pincode() {
        return registerAddr_pincode;
    }

    public void setRegisterAddr_pincode(String registerAddr_pincode) {
        this.registerAddr_pincode = registerAddr_pincode;
    }





    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCountryOriginId() {
        return countryOriginId;
    }

    public void setCountryOriginId(Integer countryOriginId) {
        this.countryOriginId = countryOriginId;
    }

    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    public String getFinendyear() {
        return finendyear;
    }

    public void setFinendyear(String finendyear) {
        this.finendyear = finendyear;
    }

    public String getFinstartyear() {
        return finstartyear;
    }

    public void setFinstartyear(String finstartyear) {
        this.finstartyear = finstartyear;
    }

    public Double getPtaxrate() {
        return ptaxrate;
    }

    public void setPtaxrate(Double ptaxrate) {
        this.ptaxrate = ptaxrate;
    }



    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request){

    companyName=null;
    contactNo=null;
    regaddress=null;
    corptaddress=null;
    //location=null;
    method=null;
    status = null;
    companyTypeId=null;
    businessNature=null;
    holidayweeklyoff=null;
    day=null;
    leaveweeklyoff=null;
    lcalculation=null;
    id = 0;
    fromDate=null;
    toDate=null;
    grcompanyId=null;
    corparateAddr_pincode=null;
    registerAddr_pincode=null;
    countryOriginId=null;
    stateId=null;
    cityId=null;
    finstartyear=null;
    finendyear=null;
    ptaxrate=null;
    }

}
