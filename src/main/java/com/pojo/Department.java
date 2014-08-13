package com.pojo;
// Generated Nov 11, 2010 2:05:44 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * DepartmentMaster generated by hbm2java
 */
public class Department  implements java.io.Serializable {


     private BigDecimal departmentId;
     private String departmentName;
     private String departmentDescription;
     private Date entrydate;
     private Date modifydate;
     private BigDecimal createdby;
     private BigDecimal modifiedby;
     private String departmentCode;
     private String status;
     private BigDecimal companyCode;

    public Department() {
    }

	
    public Department(BigDecimal departmentId) {
        this.departmentId = departmentId;
    }
    public Department(BigDecimal departmentId, String departmentName, String departmentDescription, Date entrydate, Date modifydate, BigDecimal createdby, BigDecimal modifiedby, String departmentCode, String status, BigDecimal companyCode) {
       this.departmentId = departmentId;
       this.departmentName = departmentName;
       this.departmentDescription = departmentDescription;
       this.entrydate = entrydate;
       this.modifydate = modifydate;
       this.createdby = createdby;
       this.modifiedby = modifiedby;
       this.departmentCode = departmentCode;
       this.status = status;
       this.companyCode = companyCode;
    }
   
    public BigDecimal getDepartmentId() {
        return this.departmentId;
    }
    
    public void setDepartmentId(BigDecimal departmentId) {
        this.departmentId = departmentId;
    }
    public String getDepartmentName() {
        return this.departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDepartmentDescription() {
        return this.departmentDescription;
    }
    
    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }
    public Date getEntrydate() {
        return this.entrydate;
    }
    
    public void setEntrydate(Date entrydate) {
        this.entrydate = entrydate;
    }
    public Date getModifydate() {
        return this.modifydate;
    }
    
    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }
    public BigDecimal getCreatedby() {
        return this.createdby;
    }
    
    public void setCreatedby(BigDecimal createdby) {
        this.createdby = createdby;
    }
    public BigDecimal getModifiedby() {
        return this.modifiedby;
    }
    
    public void setModifiedby(BigDecimal modifiedby) {
        this.modifiedby = modifiedby;
    }
    public String getDepartmentCode() {
        return this.departmentCode;
    }
    
    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    public BigDecimal getCompanyCode() {
        return this.companyCode;
    }
    
    public void setCompanyCode(BigDecimal companyCode) {
        this.companyCode = companyCode;
    }




}

