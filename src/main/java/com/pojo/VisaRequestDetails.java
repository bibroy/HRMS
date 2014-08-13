/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Sumit Kumar
 */
public class VisaRequestDetails implements Serializable{

    private Integer id;
    private String employeeId;
    private String employeeName;
    private String emailId;
    private String nationality;
    private String contactNo;
    private String visa;
    private Integer noOfVisa;
    private String accomodations;
    private String cityOfVisit;
    private Date dateOfArrival;
    private Integer daysOfStay;
    private String remarks;
    private String status;

    public VisaRequestDetails() {
    }

    public VisaRequestDetails(Integer id, String employeeId, String employeeName, String emailId, String nationality, String contactNo, String visa, Integer noOfVisa, String accomodations, String cityOfVisit, Date dateOfArrival, Integer daysOfStay, String remarks, String status) {
        this.id = id;
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.emailId = emailId;
        this.nationality = nationality;
        this.contactNo = contactNo;
        this.visa = visa;
        this.noOfVisa = noOfVisa;
        this.accomodations = accomodations;
        this.cityOfVisit = cityOfVisit;
        this.dateOfArrival = dateOfArrival;
        this.daysOfStay = daysOfStay;
        this.remarks = remarks;
        this.status = status;
    }

    

    public String getAccomodations() {
        return accomodations;
    }

    public void setAccomodations(String accomodations) {
        this.accomodations = accomodations;
    }

    public String getCityOfVisit() {
        return cityOfVisit;
    }

    public void setCityOfVisit(String cityOfVisit) {
        this.cityOfVisit = cityOfVisit;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public Date getDateOfArrival() {
        return dateOfArrival;
    }

    public void setDateOfArrival(Date dateOfArrival) {
        this.dateOfArrival = dateOfArrival;
    }

    public Integer getDaysOfStay() {
        return daysOfStay;
    }

    public void setDaysOfStay(Integer daysOfStay) {
        this.daysOfStay = daysOfStay;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public Integer getNoOfVisa() {
        return noOfVisa;
    }

    public void setNoOfVisa(Integer noOfVisa) {
        this.noOfVisa = noOfVisa;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVisa() {
        return visa;
    }

    public void setVisa(String visa) {
        this.visa = visa;
    }


    
}
