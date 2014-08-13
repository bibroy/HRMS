/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ranjans
 */
public class TrainingTransation implements Serializable{

    private  int requestId;
    private  int trainingId;
    private  String employeeApplyId;
    private  int employeeApproveId;
    private  String traineer;
    //-- String fromDate;
    // --String toDate;
    private  Date fromDate;
    private  Date toDate;
    String status;
   
    // --  add new for joining for pickup
    // -- training name
    Training training;
    EmployeeMaster employee;
    private List<TrainingRequestEmployee> trainingRequestEmployee;

    // -- Generate geter and setter method

    public String getEmployeeApplyId() {
        return employeeApplyId;
    }

    public void setEmployeeApplyId(String employeeApplyId) {
        this.employeeApplyId = employeeApplyId;
    }


    public EmployeeMaster getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeMaster employee) {
        this.employee = employee;
    }
    
    public Training getTraining() {
        return training;
    }

    public void setTraining(Training training) {
        this.training = training;
    }    

    public int getEmployeeApproveId() {
        return employeeApproveId;
    }

    public void setEmployeeApproveId(int employeeApproveId) {
        this.employeeApproveId = employeeApproveId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public int getRequestId() {
        return requestId;
    }

    public void setRequestId(int requestId) {
        this.requestId = requestId;
    }

   

    public String getTraineer() {
        return traineer;
    }

    public void setTraineer(String traineer) {
        this.traineer = traineer;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TrainingRequestEmployee> getTrainingRequestEmployee() {
        return trainingRequestEmployee;
    }

    public void setTrainingRequestEmployee(List<TrainingRequestEmployee> trainingRequestEmployee) {
        this.trainingRequestEmployee = trainingRequestEmployee;
    }
}
