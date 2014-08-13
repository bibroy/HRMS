/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import javax.servlet.http.HttpServletRequest;
import com.pojo.SalaryHead;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Sumit Kumar
 */
public class SalaryForm extends org.apache.struts.action.ActionForm {
    
    private String empId;
    private String month;
    private String year;
    private String progDate;
    private Double basic;
    private Integer payDays;
    private Double hra;
    private Double da;
    private Double ca;
    private Double aa;

    private Double ins;
    private Double pc;
    private Double pt;
    
//    private SalaryHead[] salhead;
    private Double advSal;
    private Double leaveDed;
    private Double netPayable;

    private String button;
    private String hiddenId;
    private String method;

    public String getHiddenId() {
        return hiddenId;
    }

    public void setHiddenId(String hiddenId) {
        this.hiddenId = hiddenId;
    }

    public Double getAdvSal() {
        return advSal;
    }

    public void setAdvSal(Double advSal) {
        this.advSal = advSal;
    }

    public Double getLeaveDed() {
        return leaveDed;
    }

    public void setLeaveDed(Double leaveDed) {
        this.leaveDed = leaveDed;
    }

    

    public Double getNetPayable() {
        return netPayable;
    }

    public void setNetPayable(Double netPayable) {
        this.netPayable = netPayable;
    }

    public Double getAa() {
        return aa;
    }

    public void setAa(Double aa) {
        this.aa = aa;
    }

    public Double getCa() {
        return ca;
    }

    public void setCa(Double ca) {
        this.ca = ca;
    }

    public Double getDa() {
        return da;
    }

    public void setDa(Double da) {
        this.da = da;
    }

    public Double getHra() {
        return hra;
    }

    public void setHra(Double hra) {
        this.hra = hra;
    }

    public Double getIns() {
        return ins;
    }

    public void setIns(Double ins) {
        this.ins = ins;
    }

    public Double getPc() {
        return pc;
    }

    public void setPc(Double pc) {
        this.pc = pc;
    }

    public Double getPt() {
        return pt;
    }

    public void setPt(Double pt) {
        this.pt = pt;
    }


    public String getProgDate() {
        return progDate;
    }

    public void setProgDate(String progDate) {
        this.progDate = progDate;
    }

    
    public Double getBasic() {
        return basic;
    }

    public void setBasic(Double basic) {
        this.basic = basic;
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

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Integer getPayDays() {
        return payDays;
    }

    public void setPayDays(Integer payDays) {
        this.payDays = payDays;
    }

//    public SalaryHead[] getSalhead() {
//        return salhead;
//    }
//
//    public void setSalhead(SalaryHead[] salhead) {
//        this.salhead = salhead;
//    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    
    public SalaryForm() {
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
