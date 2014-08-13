/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;


import org.apache.struts.upload.FormFile;

/**
 *
 * @author sujatas
 */
public class ReimbursmentForm extends org.apache.struts.action.ActionForm {
    
   private String empId;
    private Integer designation; 
    private Integer department;
    private Integer projectName;
    private String reason;
    private String reciept;
    private String travelDate;
    private String travelFrom;
    private String travelTo;
    private String travelBy;
    private String travelCost;
    private String businessRelationship;
    private String mealCost;
    private String entertainmentCost;
    private String totalAmount;
    private String method;
     //private  FormFile  recieptCopy;
    private  FormFile  recieptCopy;
     private Integer hiddenId;
      private String whyReject;


    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the designation
     */
    public Integer getDesignation() {
        return designation;
    }

    /**
     * @param designation the designation to set
     */
    public void setDesignation(Integer designation) {
        this.designation = designation;
    }

    /**
     * @return the department
     */
    public Integer getDepartment() {
        return department;
    }

    /**
     * @param department the department to set
     */
    public void setDepartment(Integer department) {
        this.department = department;
    }

    /**
     * @return the projectName
     */
    public Integer getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(Integer projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the reciept
     */
    public String getReciept() {
        return reciept;
    }

    /**
     * @param reciept the reciept to set
     */
    public void setReciept(String reciept) {
        this.reciept = reciept;
    }

    /**
     * @return the travelDate
     */
    public String getTravelDate() {
        return travelDate;
    }

    /**
     * @param travelDate the travelDate to set
     */
    public void setTravelDate(String travelDate) {
        this.travelDate = travelDate;
    }

    /**
     * @return the travelFrom
     */
    public String getTravelFrom() {
        return travelFrom;
    }

    /**
     * @param travelFrom the travelFrom to set
     */
    public void setTravelFrom(String travelFrom) {
        this.travelFrom = travelFrom;
    }

    /**
     * @return the travelTo
     */
    public String getTravelTo() {
        return travelTo;
    }

    /**
     * @param travelTo the travelTo to set
     */
    public void setTravelTo(String travelTo) {
        this.travelTo = travelTo;
    }

    /**
     * @return the travelBy
     */
    public String getTravelBy() {
        return travelBy;
    }

    /**
     * @param travelBy the travelBy to set
     */
    public void setTravelBy(String travelBy) {
        this.travelBy = travelBy;
    }

    /**
     * @return the travelCost
     */


    /**
     * @return the businessRelationship
     */
    public String getBusinessRelationship() {
        return businessRelationship;
    }

    /**
     * @param businessRelationship the businessRelationship to set
     */
    public void setBusinessRelationship(String businessRelationship) {
        this.businessRelationship = businessRelationship;
    }

    /**
     * @return the travelCost
     */
    public String getTravelCost() {
        return travelCost;
    }

    /**
     * @param travelCost the travelCost to set
     */
    public void setTravelCost(String travelCost) {
        this.travelCost = travelCost;
    }

    /**
     * @return the mealCost
     */
    public String getMealCost() {
        return mealCost;
    }

    /**
     * @param mealCost the mealCost to set
     */
    public void setMealCost(String mealCost) {
        this.mealCost = mealCost;
    }

    /**
     * @return the entertainmentCost
     */
    public String getEntertainmentCost() {
        return entertainmentCost;
    }

    /**
     * @param entertainmentCost the entertainmentCost to set
     */
    public void setEntertainmentCost(String entertainmentCost) {
        this.entertainmentCost = entertainmentCost;
    }

    /**
     * @return the totalAmount
     */
    public String getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(String method) { 
        this.method = method;
    }

    /**
     * @return the recieptCopy
     */
    public FormFile getRecieptCopy() {
        return recieptCopy;
    }

    /**
     * @param recieptCopy the recieptCopy to set
     */
    public void setRecieptCopy(FormFile recieptCopy) {
        this.recieptCopy = recieptCopy;
    }

    /**
     * @return the hiddenId
     */
    public Integer getHiddenId() {
        return hiddenId;
    }

    /**
     * @param hiddenId the hiddenId to set
     */
    public void setHiddenId(Integer hiddenId) {
        this.hiddenId = hiddenId;
    }

    /**
     * @return the whyReject
     */
    public String getWhyReject() {
        return whyReject;
    }

    /**
     * @param whyReject the whyReject to set
     */
    public void setWhyReject(String whyReject) {
        this.whyReject = whyReject;
    }




}
