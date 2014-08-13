/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import com.util.ImageUtil;
import org.hibernate.Hibernate;
/**
 *
 * @author Sumit Kumar
 */

public class Recruitment implements Serializable{

   private int id;
   private String firstName;
   private String middleName;
   private String lastName;
   private Date dob;
   private String bloodGroup;
   private String nationality;
   private String gender;
   private String status;
   private String phoneNo;
   private String emailId;
   private String postApplied;
   private byte[] canImage;
   private String skills;
   private String exp;
   private String expdesc;
   private String quali;

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

   

    public byte[] getCanImage() {
        return canImage;
    }

    public void setCanImage(byte[] canImage) {
        this.canImage = canImage;
    }

    public void setImageBlob(Blob image){
     ImageUtil iu=new ImageUtil();
     this.canImage=iu.toByteArray(image);
    }

    public Blob getImageBlob(){
        return Hibernate.createBlob(this.canImage);
    }

   public Recruitment(){

   }

    public Recruitment(int id, String firstName, String middleName, String lastName, Date dob, String bloodGroup, String nationality, String gender, String status, String phoneNo, String emailId) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.dob = dob;
        this.bloodGroup = bloodGroup;
        this.nationality = nationality;
        this.gender = gender;
        this.status = status;
        this.phoneNo = phoneNo;
        this.emailId = emailId;
    }

    public String getPostApplied() {
        return postApplied;
    }

    public void setPostApplied(String postApplied) {
        this.postApplied = postApplied;
    }

    

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
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

}
