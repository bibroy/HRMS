package com.pojo;
// Generated Nov 11, 2010 2:05:44 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * DesignationMaster generated by hbm2java
 */
public class DesignationMaster  implements java.io.Serializable {


     private BigDecimal designationId;
     private RoleMaster roleMaster;
     private String designationName;
     private String designationDescription;
     private Date entryDate;
     private BigDecimal branchCode;
     private BigDecimal companyCode;
     private Date modifyDate;
     private String createdBy;
     private String modifiedBy;
     private String status;

    public DesignationMaster() {
    }

	
    public DesignationMaster(BigDecimal designationId) {
        this.designationId = designationId;
    }
    public DesignationMaster(BigDecimal designationId, RoleMaster roleMaster, String designationName, String designationDescription, Date entryDate, BigDecimal branchCode, BigDecimal companyCode, Date modifyDate, String createdBy, String modifiedBy, String status) {
       this.designationId = designationId;
       this.roleMaster = roleMaster;
       this.designationName = designationName;
       this.designationDescription = designationDescription;
       this.entryDate = entryDate;
       this.branchCode = branchCode;
       this.companyCode = companyCode;
       this.modifyDate = modifyDate;
       this.createdBy = createdBy;
       this.modifiedBy = modifiedBy;
       this.status = status;
    }
   
    public BigDecimal getDesignationId() {
        return this.designationId;
    }
    
    public void setDesignationId(BigDecimal designationId) {
        this.designationId = designationId;
    }
    public RoleMaster getRoleMaster() {
        return this.roleMaster;
    }
    
    public void setRoleMaster(RoleMaster roleMaster) {
        this.roleMaster = roleMaster;
    }
    public String getDesignationName() {
        return this.designationName;
    }
    
    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }
    public String getDesignationDescription() {
        return this.designationDescription;
    }
    
    public void setDesignationDescription(String designationDescription) {
        this.designationDescription = designationDescription;
    }
    public Date getEntryDate() {
        return this.entryDate;
    }
    
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }
    public BigDecimal getBranchCode() {
        return this.branchCode;
    }
    
    public void setBranchCode(BigDecimal branchCode) {
        this.branchCode = branchCode;
    }
    public BigDecimal getCompanyCode() {
        return this.companyCode;
    }
    
    public void setCompanyCode(BigDecimal companyCode) {
        this.companyCode = companyCode;
    }
    public Date getModifyDate() {
        return this.modifyDate;
    }
    
    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
    public String getCreatedBy() {
        return this.createdBy;
    }
    
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public String getModifiedBy() {
        return this.modifiedBy;
    }
    
    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


