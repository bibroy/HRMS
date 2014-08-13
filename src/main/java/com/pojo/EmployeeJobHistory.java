/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author pradipto roy
 * Date of created: 27/1/2011;
 */
public class EmployeeJobHistory implements Serializable{

    private BigDecimal id;
    private  String employeeId;
    private String  name;
    private String designationID;
    private String BranchID;
    private Date DateOfJoin;
    private String departmentID;
    private String nationality;
    private String Status;
    private String ReasonOfLeavingJob;
    private String runaway;

    public String getBranchID() {
        return BranchID;
    }

    public void setBranchID(String BranchID) {
        this.BranchID = BranchID;
    }

    public Date getDateOfJoin() {
        return DateOfJoin;
    }

    public void setDateOfJoin(Date DateOfJoin) {
        this.DateOfJoin = DateOfJoin;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }



   

    public String getDesignationID() {
        return designationID;
    }

    public void setDesignationID(String designationID) {
        this.designationID = designationID;
    }

   

   

    public String getReasonOfLeavingJob() {
        return ReasonOfLeavingJob;
    }

    public void setReasonOfLeavingJob(String ReasonOfLeavingJob) {
        this.ReasonOfLeavingJob = ReasonOfLeavingJob;
    }

    public String getRunaway() {
        return runaway;
    }

    public void setRunaway(String runaway) {
        this.runaway = runaway;
    }


    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    

}
