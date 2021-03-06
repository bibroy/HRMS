package com.pojo;
// Generated Nov 11, 2010 2:05:44 PM by Hibernate Tools 3.2.1.GA

import java.math.BigDecimal;
import java.util.Date;

import com.util.ImageUtil;
import java.sql.Blob;
import org.hibernate.Hibernate;

/**
 * EmployeeMaster generated by hbm2java
 */
public class EmployeeMaster implements java.io.Serializable {

    private BigDecimal id;
    private String employeeId;
    private String firstName;
    private String middleName;
    private String lastName;
    private String presentAddress;
    private BigDecimal presentCountry;
    private BigDecimal presentState;
    private BigDecimal presentCity;
    private String permanentAddress;
    private BigDecimal permanentCountry;
    private BigDecimal permanentState;
    private BigDecimal permanentCity;
    private String emailAddress;
    private String phNoResidencial;
    private String phNoOffice;
    private String mobileNo;
    private String emergencyContactPerson;
    private String emergencyContactNoPrimary;
    private String emergencyContactAddress;
    private String bloodGroup;
    private Date dateOfBirth;
    private String gender;
    private String image;
    private String origin;
    private String religion;
    private BigDecimal permanentAddressPin;
    private BigDecimal presentAddressPin;
    private String emergencyContactRelationship;
    private String emergencyContactNoSecondary;
    private String entryBy;
    private Date entryDate;
    private String modifiedBy;
    private Date modifiedDate;
    private String employeeStatus;
    private String nationality;
    private String hobby;
    private String languageKnown;
    private String languageProficiency;
    private String identificationMark;
    private Integer designationId;
    private String status;
    private BigDecimal departmentId;
    private BigDecimal branchId;
    private BigDecimal domainId;
    private Date dateOfJoin;
    private BigDecimal typeId;
    private String supervisorId;
    private Department department;
    private GradeMaster grade;
    private byte[] canImage;

    public byte[] getCanImage() {
        return canImage;
    }

    public void setCanImage(byte[] canImage) {
        this.canImage = canImage;
    }


    public GradeMaster getGrade() {
        return grade;
    }

    public void setGrade(GradeMaster grade) {
        this.grade = grade;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmployeeMaster() {
    }

    public EmployeeMaster(BigDecimal id) {
        this.id = id;
    }

    public EmployeeMaster(BigDecimal id, String employeeId, String firstName, String middleName, String lastName, String presentAddress, BigDecimal presentCountry, BigDecimal presentState, BigDecimal presentCity, String permanentAddress, BigDecimal permanentCountry, BigDecimal permanentState, BigDecimal permanentCity, String emailAddress, String phNoResidencial, String phNoOffice, String mobileNo, String emergencyContactPerson, String emergencyContactNoPrimary, String emergencyContactAddress, String bloodGroup, Date dateOfBirth, String gender, String image, String origin, String religion, BigDecimal permanentAddressPin, BigDecimal presentAddressPin, String emergencyContactRelationship, String emergencyContactNoSecondary, String entryBy, Date entryDate, String modifiedBy, Date modifiedDate, String employeeStatus, String nationality, String hobby, String languageKnown, String languageProficiency, String identificationMark, Integer designationId, String status, BigDecimal departmentId, BigDecimal branchId, BigDecimal domainId, Date dateOfJoin, BigDecimal typeId, String supervisorId) {
        this.id = id;
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.presentAddress = presentAddress;
        this.presentCountry = presentCountry;
        this.presentState = presentState;
        this.presentCity = presentCity;
        this.permanentAddress = permanentAddress;
        this.permanentCountry = permanentCountry;
        this.permanentState = permanentState;
        this.permanentCity = permanentCity;
        this.emailAddress = emailAddress;
        this.phNoResidencial = phNoResidencial;
        this.phNoOffice = phNoOffice;
        this.mobileNo = mobileNo;
        this.emergencyContactPerson = emergencyContactPerson;
        this.emergencyContactNoPrimary = emergencyContactNoPrimary;
        this.emergencyContactAddress = emergencyContactAddress;
        this.bloodGroup = bloodGroup;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.image = image;
        this.origin = origin;
        this.religion = religion;
        this.permanentAddressPin = permanentAddressPin;
        this.presentAddressPin = presentAddressPin;
        this.emergencyContactRelationship = emergencyContactRelationship;
        this.emergencyContactNoSecondary = emergencyContactNoSecondary;
        this.entryBy = entryBy;
        this.entryDate = entryDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
        this.employeeStatus = employeeStatus;
        this.nationality = nationality;
        this.hobby = hobby;
        this.languageKnown = languageKnown;
        this.languageProficiency = languageProficiency;
        this.identificationMark = identificationMark;
        this.designationId = designationId;
        this.status = status;
        this.departmentId = departmentId;
        this.branchId = branchId;
        this.domainId = domainId;
        this.dateOfJoin = dateOfJoin;
        this.typeId = typeId;
        this.supervisorId = supervisorId;

    }

    public BigDecimal getId() {
        return this.id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return this.employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPresentAddress() {
        return this.presentAddress;
    }

    public void setPresentAddress(String presentAddress) {
        this.presentAddress = presentAddress;
    }

    public BigDecimal getPresentCountry() {
        return this.presentCountry;
    }

    public void setPresentCountry(BigDecimal presentCountry) {
        this.presentCountry = presentCountry;
    }

    public BigDecimal getPresentState() {
        return this.presentState;
    }

    public void setPresentState(BigDecimal presentState) {
        this.presentState = presentState;
    }


     public void setImageBlob(Blob image){
     ImageUtil iu=new ImageUtil();
    
     this.canImage=iu.toByteArray(image);
      
    }

    public Blob getImageBlob(){
        return Hibernate.createBlob(this.canImage);
    }




    public BigDecimal getPresentCity() {
        return this.presentCity;
    }

    public void setPresentCity(BigDecimal presentCity) {
        this.presentCity = presentCity;
    }

    public String getPermanentAddress() {
        return this.permanentAddress;
    }

    public void setPermanentAddress(String permanentAddress) {
        this.permanentAddress = permanentAddress;
    }

    public BigDecimal getPermanentCountry() {
        return this.permanentCountry;
    }

    public void setPermanentCountry(BigDecimal permanentCountry) {
        this.permanentCountry = permanentCountry;
    }

    public BigDecimal getPermanentState() {
        return this.permanentState;
    }

    public void setPermanentState(BigDecimal permanentState) {
        this.permanentState = permanentState;
    }

    public BigDecimal getPermanentCity() {
        return this.permanentCity;
    }

    public void setPermanentCity(BigDecimal permanentCity) {
        this.permanentCity = permanentCity;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhNoResidencial() {
        return this.phNoResidencial;
    }

    public void setPhNoResidencial(String phNoResidencial) {
        this.phNoResidencial = phNoResidencial;
    }

    public String getPhNoOffice() {
        return this.phNoOffice;
    }

    public void setPhNoOffice(String phNoOffice) {
        this.phNoOffice = phNoOffice;
    }

    public String getMobileNo() {
        return this.mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmergencyContactPerson() {
        return this.emergencyContactPerson;
    }

    public void setEmergencyContactPerson(String emergencyContactPerson) {
        this.emergencyContactPerson = emergencyContactPerson;
    }

    public String getEmergencyContactNoPrimary() {
        return this.emergencyContactNoPrimary;
    }

    public void setEmergencyContactNoPrimary(String emergencyContactNoPrimary) {
        this.emergencyContactNoPrimary = emergencyContactNoPrimary;
    }

    public String getEmergencyContactAddress() {
        return this.emergencyContactAddress;
    }

    public void setEmergencyContactAddress(String emergencyContactAddress) {
        this.emergencyContactAddress = emergencyContactAddress;
    }

    public String getBloodGroup() {
        return this.bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Date getDateOfBirth() {
        return this.dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getImage() {
        return this.image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOrigin() {
        return this.origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getReligion() {
        return this.religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public BigDecimal getPermanentAddressPin() {
        return this.permanentAddressPin;
    }

    public void setPermanentAddressPin(BigDecimal permanentAddressPin) {
        this.permanentAddressPin = permanentAddressPin;
    }

    public BigDecimal getPresentAddressPin() {
        return this.presentAddressPin;
    }

    public void setPresentAddressPin(BigDecimal presentAddressPin) {
        this.presentAddressPin = presentAddressPin;
    }

    public String getEmergencyContactRelationship() {
        return this.emergencyContactRelationship;
    }

    public void setEmergencyContactRelationship(String emergencyContactRelationship) {
        this.emergencyContactRelationship = emergencyContactRelationship;
    }

    public String getEmergencyContactNoSecondary() {
        return this.emergencyContactNoSecondary;
    }

    public void setEmergencyContactNoSecondary(String emergencyContactNoSecondary) {
        this.emergencyContactNoSecondary = emergencyContactNoSecondary;
    }

    public String getEntryBy() {
        return this.entryBy;
    }

    public void setEntryBy(String entryBy) {
        this.entryBy = entryBy;
    }

    public Date getEntryDate() {
        return this.entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getModifiedBy() {
        return this.modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return this.modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getEmployeeStatus() {
        return this.employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getHobby() {
        return this.hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getLanguageKnown() {
        return this.languageKnown;
    }

    public void setLanguageKnown(String languageKnown) {
        this.languageKnown = languageKnown;
    }

    public String getLanguageProficiency() {
        return this.languageProficiency;
    }

    public void setLanguageProficiency(String languageProficiency) {
        this.languageProficiency = languageProficiency;
    }

    public String getIdentificationMark() {
        return this.identificationMark;
    }

    public void setIdentificationMark(String identificationMark) {
        this.identificationMark = identificationMark;
    }

    public Integer getDesignationId() {
        return designationId;
    }

    public void setDesignationId(Integer designationId) {
        this.designationId = designationId;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getDepartmentId() {
        return this.departmentId;
    }

    public void setDepartmentId(BigDecimal departmentId) {
        this.departmentId = departmentId;
    }

    public BigDecimal getBranchId() {
        return this.branchId;
    }

    public void setBranchId(BigDecimal branchId) {
        this.branchId = branchId;
    }

    public BigDecimal getDomainId() {
        return this.domainId;
    }

    public void setDomainId(BigDecimal domainId) {
        this.domainId = domainId;
    }

    public Date getDateOfJoin() {
        return this.dateOfJoin;
    }

    public void setDateOfJoin(Date dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public BigDecimal getTypeId() {
        return this.typeId;
    }

    public void setTypeId(BigDecimal typeId) {
        this.typeId = typeId;
    }

    public String getSupervisorId() {
        return this.supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }
}
