/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import com.dao.BaseDAO;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

/**
 *
 * @author Sumit Kumar
 */
public class RecruitmentForm extends org.apache.struts.action.ActionForm {
    
   private int id;
   private String firstName;
   private String middleName;
   private String lastName;
   private String dob;
   private String bloodGroup;
   private String nationality;
   private String gender;
   private String status;
   private String phoneNo;
   private String emailId;
   private String method;
   private String button;
   private String postApplied;
    private byte[] canImage;
   private FormFile imageFile;
   private String skills;
   private String exp;
   private String expdesc;
   private String quali;
    private String[] email;
    private String[] name;
    private int[] candidateId;

    public int[] getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(int[] candidateId) {
        this.candidateId = candidateId;
    }

    public String[] getEmail() {
        return email;
    }

    public void setEmail(String[] email) {
        this.email = email;
    }

    public String[] getName() {
        return name;
    }

    public void setName(String[] name) {
        this.name = name;
    }



    public RecruitmentForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getExpdesc() {
        return expdesc;
    }

    public void setExpdesc(String expdesc) {
        this.expdesc = expdesc;
    }

    public String getQuali() {
        return quali;
    }

    public void setQuali(String quali) {
        this.quali = quali;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
    

    public FormFile getImageFile() {
        return imageFile;
    }

    public void setImageFile(FormFile imageFile) {
        this.imageFile = imageFile;
    }


    public byte[] getCanImage() {
        return canImage;
    }

    public void setCanImage(byte[] canImage) {
        this.canImage = canImage;
    }


    public String getPostApplied() {
        return postApplied;
    }

    public void setPostApplied(String postApplied) {
        this.postApplied = postApplied;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }



    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    @Override
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
    }
}
