/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author pradipto
 */
public class EmployeeDesignation implements Serializable {

     private String designationName;
     private String designationDescription;
     private String mobileNo;
     private String presentAddress;
     private BigDecimal presentCountry;
     private BigDecimal presentState;
     private BigDecimal presentCity;
     private String nationality;
     private String dateOfBirth;
     private String emailAddress;
     private String employeeId;
     private String firstName;
     private String countryName;
     private String stateName;
     private String cityName;
     private String branchName;
     private String departmentName;
     private Date dateOfJoin;

    public Date getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }


    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }




    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

 

    public String getDesignationDescription() {
        return designationDescription;
    }

    public void setDesignationDescription(String designationDescription) {
        this.designationDescription = designationDescription;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public BigDecimal getPresentCity() {
        return presentCity;
    }

    public void setPresentCity(BigDecimal presentCity) {
        this.presentCity = presentCity;
    }

    public BigDecimal getPresentCountry() {
        return presentCountry;
    }

    public void setPresentCountry(BigDecimal presentCountry) {
        this.presentCountry = presentCountry;
    }

    public BigDecimal getPresentState() {
        return presentState;
    }

    public void setPresentState(BigDecimal presentState) {
        this.presentState = presentState;
    }





}
