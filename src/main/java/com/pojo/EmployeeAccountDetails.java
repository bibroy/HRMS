package com.pojo;
// Generated Nov 11, 2010 2:05:44 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * EmployeeAccountDetails generated by hbm2java
 */
public class EmployeeAccountDetails  implements java.io.Serializable {


     private BigDecimal id;
     private String bankName;
     private BigDecimal accountNo;
     private String accountType;
     private String branchAddress;
     private String contactNo;
     private String employeeId;
     

    


    public EmployeeAccountDetails() {
    }

	
    public EmployeeAccountDetails(BigDecimal id) {
        this.id = id;
    }
    public EmployeeAccountDetails(BigDecimal id, String bankName, BigDecimal accountNo, String accountType, String branchAddress, String contactNo, String employeeId) {
       this.id = id;
       this.bankName = bankName;
       this.accountNo = accountNo;
       this.accountType = accountType;
       this.branchAddress = branchAddress;
       this.contactNo = contactNo;
       this.employeeId = employeeId;
    }
   
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }
    public String getBankName() {
        return this.bankName;
    }
    
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }
    public BigDecimal getAccountNo() {
        return this.accountNo;
    }
    
    public void setAccountNo(BigDecimal accountNo) {
        this.accountNo = accountNo;
    }
    public String getAccountType() {
        return this.accountType;
    }
    
    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    public String getBranchAddress() {
        return this.branchAddress;
    }
    
    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }
    public String getContactNo() {
        return this.contactNo;
    }
    
    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }
    public String getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }




}

