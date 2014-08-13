package com.pojo;
// Generated Nov 11, 2010 2:05:44 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * TrainingRequestEmployee generated by hbm2java
 */
public class TrainingRequestEmployee  implements java.io.Serializable {


     private BigDecimal trainingRequestId;
     private BigDecimal requestId;
     private BigDecimal employeeId;
     private String flag;
     private BigDecimal count;

    public TrainingRequestEmployee() {
    }

	
    public TrainingRequestEmployee(BigDecimal trainingRequestId, BigDecimal requestId, BigDecimal employeeId) {
        this.trainingRequestId = trainingRequestId;
        this.requestId = requestId;
        this.employeeId = employeeId;
    }
    public TrainingRequestEmployee(BigDecimal trainingRequestId, BigDecimal requestId, BigDecimal employeeId, String flag, BigDecimal count) {
       this.trainingRequestId = trainingRequestId;
       this.requestId = requestId;
       this.employeeId = employeeId;
       this.flag = flag;
       this.count = count;
    }
   
    public BigDecimal getTrainingRequestId() {
        return this.trainingRequestId;
    }
    
    public void setTrainingRequestId(BigDecimal trainingRequestId) {
        this.trainingRequestId = trainingRequestId;
    }
    public BigDecimal getRequestId() {
        return this.requestId;
    }
    
    public void setRequestId(BigDecimal requestId) {
        this.requestId = requestId;
    }
    public BigDecimal getEmployeeId() {
        return this.employeeId;
    }
    
    public void setEmployeeId(BigDecimal employeeId) {
        this.employeeId = employeeId;
    }
    public String getFlag() {
        return this.flag;
    }
    
    public void setFlag(String flag) {
        this.flag = flag;
    }
    public BigDecimal getCount() {
        return this.count;
    }
    
    public void setCount(BigDecimal count) {
        this.count = count;
    }




}


