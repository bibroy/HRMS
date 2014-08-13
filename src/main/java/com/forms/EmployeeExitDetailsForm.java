/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import java.math.BigDecimal;
/**
 *
 * @author pradipto
 */
public class EmployeeExitDetailsForm extends org.apache.struts.action.ActionForm {
    
  
private Integer id;
     private String employeeId;
     private String firstName;
     private String middleName;
     private String lastName;
     private String presentAddress;
     private Integer presentCountry;
     private Integer presentState;
     private Integer presentCity;
     private String permanentAddress;
     private Integer permanentCountry;
     private Integer permanentState;
     private Integer permanentCity;
     private String emailAddress;
     private String phNoResidencial;
     private String phNoOffice;
     private String mobileNo;
     private String emergencyContactPerson;
     private String emergencyContactNoPrimary;
     private String emergencyContactAddress;
     private String bloodGroup;
     private String dateOfBirth;
     private String gender;
     private String image;
     private String origin;
     private String religion;
     private Integer permanentAddressPin;
     private Integer presentAddressPin;
     private String emergencyContactRelationship;
     private String emergencyContactNoSecondary;
     private String entryBy;
     private String entryDate;
     private String modifiedBy;
     private String modifiedDate;
     private String employeeStatus;
     private String nationality;
     private String hobby;
     private String languageKnown;
     private String languageProficiency;
     private String identificationMark;
     private Integer designationId;
     private String status;
     private Integer departmentId;
     private Integer branchId;
     private Integer domainId;
     private String dateOfJoin;
     private Integer typeId;
     private String supervisorId;
     private String method;
     private String reasonOfLeaving;
     private String runaway;

    public String getRunaway() {
        return runaway;
    }

    public void setRunaway(String runaway) {
        this.runaway = runaway;
    }


     
     public String getReasonOfLeaving() {
        return reasonOfLeaving;
    }

    public void setReasonOfLeaving(String reasonOfLeaving) {
        this.reasonOfLeaving = reasonOfLeaving;
    }

   

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    /**
     * @return
     */



  

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(String dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Integer designationId) {
        this.designationId = designationId;
    }

    public Integer getDomainId() {
        return domainId;
    }

    public void setDomainId(Integer domainId) {
        this.domainId = domainId;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getEmergencyContactAddress() {
        return emergencyContactAddress;
    }

    public void setEmergencyContactAddress(String emergencyContactAddress) {
        this.emergencyContactAddress = emergencyContactAddress;
    }

    public String getEmergencyContactNoPrimary() {
        return emergencyContactNoPrimary;
    }

    public void setEmergencyContactNoPrimary(String emergencyContactNoPrimary) {
        this.emergencyContactNoPrimary = emergencyContactNoPrimary;
    }

    public String getEmergencyContactNoSecondary() {
        return emergencyContactNoSecondary;
    }

    public void setEmergencyContactNoSecondary(String emergencyContactNoSecondary) {
        this.emergencyContactNoSecondary = emergencyContactNoSecondary;
    }

    public String getEmergencyContactPerson() {
        return emergencyContactPerson;
    }

    public void setEmergencyContactPerson(String emergencyContactPerson) {
        this.emergencyContactPerson = emergencyContactPerson;
    }

    public String getEmergencyContactRelationship() {
        return emergencyContactRelationship;
    }

    public void setEmergencyContactRelationship(String emergencyContactRelationship) {
        this.emergencyContactRelationship = emergencyContactRelationship;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getEntryBy() {
        return entryBy;
    }

    public void setEntryBy(String entryBy) {
        this.entryBy = entryBy;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIdentificationMark() {
        return identificationMark;
    }

    public void setIdentificationMark(String identificationMark) {
        this.identificationMark = identificationMark;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLanguageKnown() {
        return languageKnown;
    }

    public void setLanguageKnown(String languageKnown) {
        this.languageKnown = languageKnown;
    }

    public String getLanguageProficiency() {
        return languageProficiency;
    }

    public void setLanguageProficiency(String languageProficiency) {
        this.languageProficiency = languageProficiency;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPermanentAddress() {
        return permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public Integer getPermanentAddressPin() {
        return permanentAddressPin;
    }

    public void setPermanentAddressPin(Integer permanentAddressPin) {
        this.permanentAddressPin = permanentAddressPin;
    }

    public Integer getPermanentCity() {
        return permanentCity;
    }

    public void setPermanentCity(Integer permanentCity) {
        this.permanentCity = permanentCity;
    }

    public Integer getPermanentCountry() {
        return permanentCountry;
    }

    public void setPermanentCountry(Integer permanentCountry) {
        this.permanentCountry = permanentCountry;
    }

    public Integer getPermanentState() {
        return permanentState;
    }

    public void setPermanentState(Integer permanentState) {
        this.permanentState = permanentState;
    }

    public String getPhNoOffice() {
        return phNoOffice;
    }

    public void setPhNoOffice(String phNoOffice) {
        this.phNoOffice = phNoOffice;
    }

    public String getPhNoResidencial() {
        return phNoResidencial;
    }

    public void setPhNoResidencial(String phNoResidencial) {
        this.phNoResidencial = phNoResidencial;
    }

    public String getPresentAddress() {
        return presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public Integer getPresentAddressPin() {
        return presentAddressPin;
    }

    public void setPresentAddressPin(Integer presentAddressPin) {
        this.presentAddressPin = presentAddressPin;
    }

    public Integer getPresentCity() {
        return presentCity;
    }

    public void setPresentCity(Integer presentCity) {
        this.presentCity = presentCity;
    }

    public Integer getPresentCountry() {
        return presentCountry;
    }

    public void setPresentCountry(Integer presentCountry) {
        this.presentCountry = presentCountry;
    }

    public Integer getPresentState() {
        return presentState;
    }

    public void setPresentState(Integer presentState) {
        this.presentState = presentState;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    /**
     * @param string
     */
   
    /**
     *
     */
    public EmployeeExitDetailsForm() {
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
