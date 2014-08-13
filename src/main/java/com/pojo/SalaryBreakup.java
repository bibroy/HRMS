/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;
import java.math.BigDecimal;
/**
 *
 * @author Sumit Kumar
 */

public class SalaryBreakup implements java.io.Serializable{
    private BigDecimal id;
    private String employeeid;
    private String headergpid;
    private Double amount;
    private Double netpayable;

    public String getHeadergpid() {
        return headergpid;
    }

    public void setHeadergpid(String headergpid) {
        this.headergpid = headergpid;
    }

    public Double getNetpayable() {
        return netpayable;
    }

    public void setNetpayable(Double netpayable) {
        this.netpayable = netpayable;
    }

    
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getHeaderid() {
        return headergpid;
    }

    public void setHeaderid(String headerid) {
        this.headergpid = headerid;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }


}
