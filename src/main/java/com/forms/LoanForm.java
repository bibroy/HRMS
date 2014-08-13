/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

/**
 *
 * @author sujatas
 */
public class LoanForm extends org.apache.struts.action.ActionForm {
    
    private String empId;
   
    private double totalSal;
    private double reqAmt;
    private int installment;

    private String deductstartmonth;
    private String button;
    private String reason;
    private String method;
     private Integer hiddenId;
     private String firstName;
             private String middleName;
             private String lastName;
              private String whyReject;
    


    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getDeductstartmonth() {
        return deductstartmonth;
    }

    public void setDeductstartmonth(String deductstartmonth) {
        this.deductstartmonth = deductstartmonth;
    }

    
    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public Integer getHiddenId() {
        return hiddenId;
    }

    public void setHiddenId(Integer hiddenId) {
        this.hiddenId = hiddenId;
    }

    public int getInstallment() {
        return installment;
    }

    public void setInstallment(int installment) {
        this.installment = installment;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

   
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public double getReqAmt() {
        return reqAmt;
    }

    public void setReqAmt(double reqAmt) {
        this.reqAmt = reqAmt;
    }

    public double getTotalSal() {
        return totalSal;
    }

    public void setTotalSal(double totalSal) {
        this.totalSal = totalSal;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the middleName
     */
    public String getMiddleName() {
        return middleName;
    }

    /**
     * @param middleName the middleName to set
     */
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
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
