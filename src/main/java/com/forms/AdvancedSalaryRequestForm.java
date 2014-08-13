/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forms;



/**
 *
 * @author sujatas
 */
public class AdvancedSalaryRequestForm extends org.apache.struts.action.ActionForm {

    private String empId;
   
    private double totalSal;
    private double reqAmt;
    private int installment;
    private String deductmonth;
    private String deductstartmonth;
    private String button;
    private String reason;
    private String method;
    private Integer hiddenId;
     private String whyReject;


    public String getDeductstartmonth() {
        return deductstartmonth;
    }

    public void setDeductstartmonth(String deductstartmonth) {
        this.deductstartmonth = deductstartmonth;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

   
   
    public String getEmpId() {
        return empId;
    }

    public String getDeductmonth() {
        return deductmonth;
    }

    public void setDeductmonth(String deductmonth) {
        this.deductmonth = deductmonth;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    

    public int getInstallment() {
        return installment;
    }

    public void setInstallment(int installment) {
        this.installment = installment;
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
     *
     */
    public AdvancedSalaryRequestForm() {
        super();
        // TODO Auto-generated constructor stub
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

    /**
     * @return the method
     */

}
