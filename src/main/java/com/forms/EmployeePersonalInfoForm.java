/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forms;

import com.pojo.EmployeeMaster;
import java.util.Date;

import com.util.UtilityClass;
import java.util.List;
import org.apache.struts.upload.FormFile;


/**
 *
 * @author sudipb
 */
public class EmployeePersonalInfoForm extends org.apache.struts.action.ActionForm {

    UtilityClass utilityClass = new UtilityClass();
    private Integer empMasterid;
    private Integer visaPassportId;
    private String passportNo;
    private String passportIssueDate;
    private String passportIssuedBy;
    private String passportValidUpto;
    private String visaNo;
    private String visaType;
    private String visaIssuedBy;
    private String visaIssueDate;
    private String visaValidUpto;
//----------------------------------------------
    private String referenceName;
    private String referralOrganizationName;
    private String refContactNo;
    private String refEmailAddress;
    private String refDesignation;
    private String refRelaltion;
//---------------------------------
    private Integer empPreEmployerId[];
    private String employerName[];
    private String jobDescription[];
    private String joiningDate[];
    private String releaseDate[];
//------------------------------------
    private Integer empSkillId[]; //EMPLOYEE_SKILL.pk
    private String skillName[];
    private Integer skillNameId[];
    private String proficiencyLevel[];
    private String lastUsed[];
//----------------------------------------
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
    private Integer entryBy;
    private Date entryDate;
    private Integer modifiedBy;
    private Date modifiedDate;
    private String employeeStatus;
    private String nationality;
    private String hobby;
    private String languageKnown;
    private String languageProficiency;
    private String identificationMark;
//-------------------------------------------
    private Integer empFamId[];
    private String familyMemberName[];
    private String relation[];
    private String dobOfMember[];
//--------------------------
    private Integer empEduDetailsId[];
    private String examinationName[];
    private String yearOfStart[];
    private String yearOfEnd[];
    private Integer percentage[];
    private String boardName[];
    private String institutionName[];
    private String specialisation[];
    //-----------------------------------------
    private Integer empCertificationId[];
    private String certificationName[];
    private String orgatizationName[];
    private String subject[];
    private String certifiedOnDate[];
    private String renewedDate[];
    private String renewedOnDate[];
//-------------------------------------
    private String bankName;
    private Integer accountNo;
    private String accountType;
    private String branchAddress;
    private String bankContactNo;
    private String employeeId;
    private Integer grCompanyId;
    private Integer companyId;
    private Integer brId;
    private Integer deptId;
    private Integer designation_id;
    private Integer domainId;
    private String dateOfJoin;
    private String dateOfEffective;
    private String confDueDate;
    private String reEmpStatus;
    private String oldemployeeId;
    private String position;
//----------------------------------------
    private Integer jobtypeId;
    private String method;
    private String editDelete;
    private String grade;
    private String supervisorId;
    private String roleID;
    private String status;

    private String button;

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }


    public String getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(String supervisorId) {
        this.supervisorId = supervisorId;
    }
    //-------------------------
    private byte[] canImage;
   private FormFile imageFile;

    public byte[] getCanImage() {
        return canImage;
    }

    public void setCanImage(byte[] canImage) {
        this.canImage = canImage;
    }

    public FormFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(FormFile imageFile) {
        this.imageFile = imageFile;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }


    private List<EmployeeMaster> emplist;


    public List<EmployeeMaster> getEmplist() {
        return emplist;
    }

    public void setEmplist(List<EmployeeMaster> emplist) {
        this.emplist = emplist;
    }

    public UtilityClass getUtilityClass() {
        return utilityClass;
    }

    public void setUtilityClass(UtilityClass utilityClass) {
        this.utilityClass = utilityClass;
    }


    //date convert
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPassportIssueDate() {
        return passportIssueDate;
    }

    public void setPassportIssueDate(String passportIssueDate) {
        this.passportIssueDate = passportIssueDate;
    }

    public String getPassportValidUpto() {
        return passportValidUpto;
    }

    public void setPassportValidUpto(String passportValidUpto) {
        this.passportValidUpto = passportValidUpto;
    }

    public String getVisaIssueDate() {
        return visaIssueDate;
    }

    public void setVisaIssueDate(String visaIssueDate) {
        this.visaIssueDate = visaIssueDate;
    }

    public String getVisaValidUpto() {
        return visaValidUpto;
    }

    public void setVisaValidUpto(String visaValidUpto) {
        this.visaValidUpto = visaValidUpto;
    }

//------------------------------------------------------------
    public String[] getDobOfMember() {
        return dobOfMember;
    }

    public void setDobOfMember(String[] dobOfMember) {
        this.dobOfMember = dobOfMember;
    }

    public Integer getEmpMasterid() {
        return empMasterid;
    }

    public void setEmpMasterid(Integer empMasterid) {
        this.empMasterid = empMasterid;
    }

    public Integer[] getEmpFamId() {
        return empFamId;
    }

    public void setEmpFamId(Integer[] empFamId) {
        this.empFamId = empFamId;
    }

    public Integer getVisaPassportId() {
        return visaPassportId;
    }

    public void setVisaPassportId(Integer visaPassportId) {
        this.visaPassportId = visaPassportId;
    }

    public Integer getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Integer accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getBankContactNo() {
        return bankContactNo;
    }

    public void setBankContactNo(String bankContactNo) {
        this.bankContactNo = bankContactNo;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Integer getBrId() {
        return brId;
    }

    public void setBrId(Integer brId) {
        this.brId = brId;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getConfDueDate() {
        return confDueDate;
    }

    public void setConfDueDate(String confDueDate) {
        this.confDueDate = confDueDate;
    }

    public String getDateOfEffective() {
        return dateOfEffective;
    }

    public void setDateOfEffective(String dateOfEffective) {
        this.dateOfEffective = dateOfEffective;
    }

    public String getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(String dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getDesignation_id() {
        return designation_id;
    }

    public void setDesignation_id(Integer designation_id) {
        this.designation_id = designation_id;
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

    public Integer getEntryBy() {
        return entryBy;
    }

    public void setEntryBy(Integer entryBy) {
        this.entryBy = entryBy;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String[] getFamilyMemberName() {
        return familyMemberName;
    }

    public void setFamilyMemberName(String[] familyMemberName) {
        this.familyMemberName = familyMemberName;
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

    public Integer getGrCompanyId() {
        return grCompanyId;
    }

    public void setGrCompanyId(Integer grCompanyId) {
        this.grCompanyId = grCompanyId;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
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

    public Integer getJobtypeId() {
        return jobtypeId;
    }

    public void setJobtypeId(Integer jobtypeId) {
        this.jobtypeId = jobtypeId;
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

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
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

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getOldemployeeId() {
        return oldemployeeId;
    }

    public void setOldemployeeId(String oldemployeeId) {
        this.oldemployeeId = oldemployeeId;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPassportIssuedBy() {
        return passportIssuedBy;
    }

    public void setPassportIssuedBy(String passportIssuedBy) {
        this.passportIssuedBy = passportIssuedBy;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public String getReEmpStatus() {
        return reEmpStatus;
    }

    public void setReEmpStatus(String reEmpStatus) {
        this.reEmpStatus = reEmpStatus;
    }

    public String getRefContactNo() {
        return refContactNo;
    }

    public void setRefContactNo(String refContactNo) {
        this.refContactNo = refContactNo;
    }

    public String getRefDesignation() {
        return refDesignation;
    }

    public void setRefDesignation(String refDesignation) {
        this.refDesignation = refDesignation;
    }

    public String getRefEmailAddress() {
        return refEmailAddress;
    }

    public void setRefEmailAddress(String refEmailAddress) {
        this.refEmailAddress = refEmailAddress;
    }

    public String getRefRelaltion() {
        return refRelaltion;
    }

    public void setRefRelaltion(String refRelaltion) {
        this.refRelaltion = refRelaltion;
    }

    public String getReferenceName() {
        return referenceName;
    }

    public void setReferenceName(String referenceName) {
        this.referenceName = referenceName;
    }

    public String getReferralOrganizationName() {
        return referralOrganizationName;
    }

    public void setReferralOrganizationName(String referralOrganizationName) {
        this.referralOrganizationName = referralOrganizationName;
    }

    public String[] getRelation() {
        return relation;
    }

    public void setRelation(String[] relation) {
        this.relation = relation;
    }

    public Integer[] getEmpPreEmployerId() {
        return empPreEmployerId;
    }

    public void setEmpPreEmployerId(Integer[] empPreEmployerId) {
        this.empPreEmployerId = empPreEmployerId;
    }

    public String[] getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String[] employerName) {
        this.employerName = employerName;
    }

    public String[] getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String[] jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String[] getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(String[] joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String[] getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String[] releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Integer[] getEmpSkillId() {
        return empSkillId;
    }

    public void setEmpSkillId(Integer[] empSkillId) {
        this.empSkillId = empSkillId;
    }

    public String[] getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(String[] lastUsed) {
        this.lastUsed = lastUsed;
    }

    public String[] getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String[] proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public String[] getSkillName() {
        return skillName;
    }

    public void setSkillName(String[] skillName) {
        this.skillName = skillName;
    }

    public Integer[] getSkillNameId() {
        return skillNameId;
    }

    public void setSkillNameId(Integer[] skillNameId) {
        this.skillNameId = skillNameId;
    }

    public String[] getCertificationName() {
        return certificationName;
    }

    public void setCertificationName(String[] certificationName) {
        this.certificationName = certificationName;
    }

    public String[] getCertifiedOnDate() {
        return certifiedOnDate;
    }

    public void setCertifiedOnDate(String[] certifiedOnDate) {
        this.certifiedOnDate = certifiedOnDate;
    }

    public String[] getOrgatizationName() {
        return orgatizationName;
    }

    public void setOrgatizationName(String[] orgatizationName) {
        this.orgatizationName = orgatizationName;
    }

    public String[] getRenewedDate() {
        return renewedDate;
    }

    public void setRenewedDate(String[] renewedDate) {
        this.renewedDate = renewedDate;
    }

    public String[] getRenewedOnDate() {
        return renewedOnDate;
    }

    public void setRenewedOnDate(String[] renewedOnDate) {
        this.renewedOnDate = renewedOnDate;
    }

    public String[] getSubject() {
        return subject;
    }

    public void setSubject(String[] subject) {
        this.subject = subject;
    }

    public String getVisaIssuedBy() {
        return visaIssuedBy;
    }

    public void setVisaIssuedBy(String visaIssuedBy) {
        this.visaIssuedBy = visaIssuedBy;
    }

    public String getVisaNo() {
        return visaNo;
    }

    public void setVisaNo(String visaNo) {
        this.visaNo = visaNo;
    }

    public String getVisaType() {
        return visaType;
    }

    public void setVisaType(String visaType) {
        this.visaType = visaType;
    }

    public String getEditDelete() {
        return editDelete;
    }

    public void setEditDelete(String editDelete) {
        this.editDelete = editDelete;
    }

    public String[] getBoardName() {
        return boardName;
    }

    public void setBoardName(String[] boardName) {
        this.boardName = boardName;
    }

    public String[] getExaminationName() {
        return examinationName;
    }

    public void setExaminationName(String[] examinationName) {
        this.examinationName = examinationName;
    }

    public String[] getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String[] institutionName) {
        this.institutionName = institutionName;
    }

    public Integer[] getPercentage() {
        return percentage;
    }

    public void setPercentage(Integer[] percentage) {
        this.percentage = percentage;
    }

    public String[] getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(String[] specialisation) {
        this.specialisation = specialisation;
    }

    public String[] getYearOfEnd() {
        return yearOfEnd;
    }

    public void setYearOfEnd(String[] yearOfEnd) {
        this.yearOfEnd = yearOfEnd;
    }

    public String[] getYearOfStart() {
        return yearOfStart;
    }

    public void setYearOfStart(String[] yearOfStart) {
        this.yearOfStart = yearOfStart;
    }

    public Integer[] getEmpEduDetailsId() {
        return empEduDetailsId;
    }

    public void setEmpEduDetailsId(Integer[] empEduDetailsId) {
        this.empEduDetailsId = empEduDetailsId;
    }

    public Integer[] getEmpCertificationId() {
        return empCertificationId;
    }

    public void setEmpCertificationId(Integer[] empCertificationId) {
        this.empCertificationId = empCertificationId;
    }

    public void clear() {

        empFamId = null;
        familyMemberName = null;
        relation = null;
        dobOfMember = null;
        examinationName = null;
        yearOfStart = null;
        yearOfEnd = null;
        percentage = null;
        boardName = null;
        institutionName = null;
        specialisation = null;

//-----------------------------
        empCertificationId = null;
        certificationName = null;
        orgatizationName = null;
        subject = null;
        certifiedOnDate = null;
        renewedDate = null;
        renewedOnDate = null;
//---------------------

        empSkillId = null;
        skillName = null;
        skillNameId = null;
        proficiencyLevel = null;
        lastUsed = null;
//--------------------------
        empPreEmployerId = null;
        employerName = null;
        jobDescription = null;
        joiningDate = null;
        releaseDate = null;

    }
}
