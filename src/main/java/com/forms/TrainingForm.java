/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import java.util.Map;
import org.apache.struts.action.ActionForm;
import org.apache.struts.upload.FormFile;

/**
 * This form Bean is use for Trainingmaster page
 * @author ranjans
 */
public class TrainingForm extends ActionForm{

    private  String trainingName;
    //String skilsName;
    private  String ddlSkillsName;
    private  String ddlTrainingMode;
    private  String ddlConsultancy;
    private  String ddlStatus;
    private  String fromDate;
    private  String toDate;
    //Map trainingMode;
    private  String trainerName;
    private  String department;
    //Map consultancy;
    //Map status;
    private  String save="Save";
    private  String cancel;
    private  String method;
    private  int trainingId;
    private  String designation;
    private String jobType;
    private int departmentId;

    // --- add for training material
    private  FormFile trainingMaterial;
    private FormFile feedbackMaterial;
    private String expLavel;
    private  String ddlTrainingName;
    private  String ddlExpLavel;
    private String[] ddlsessionType;
    private  String[] ddlPosition;

    public String getCancel() {
        return cancel;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

   

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getSave() {
        return save;
    }

    public void setSave(String save) {
        this.save = save;
    }

   

   
    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }
    

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }



    public String getDdlConsultancy() {
        return ddlConsultancy;
    }

    public void setDdlConsultancy(String ddlConsultancy) {
        this.ddlConsultancy = ddlConsultancy;
    }

    public String getDdlSkillsName() {
        return ddlSkillsName;
    }

    public void setDdlSkillsName(String ddlSkillsName) {
        this.ddlSkillsName = ddlSkillsName;
    }

    public String getDdlStatus() {
        return ddlStatus;
    }

    public void setDdlStatus(String ddlStatus) {
        this.ddlStatus = ddlStatus;
    }

    public String getDdlTrainingMode() {
        return ddlTrainingMode;
    }

    public void setDdlTrainingMode(String ddlTrainingMode) {
        this.ddlTrainingMode = ddlTrainingMode;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getExpLavel() {
        return expLavel;
    }

    public void setExpLavel(String expLavel) {
        this.expLavel = expLavel;
    }

    public FormFile getTrainingMaterial() {
        return trainingMaterial;
    }

    public void setTrainingMaterial(FormFile trainingMaterial) {
        this.trainingMaterial = trainingMaterial;
    }

    public FormFile getFeedbackMaterial() {
        return feedbackMaterial;
    }

    public void setFeedbackMaterial(FormFile feedbackMaterial) {
        this.feedbackMaterial = feedbackMaterial;
    }

    public String getDdlTrainingName() {
        return ddlTrainingName;
    }

    public void setDdlTrainingName(String ddlTrainingName) {
        this.ddlTrainingName = ddlTrainingName;
    }

    public String getDdlExpLavel() {
        return ddlExpLavel;
    }

    public void setDdlExpLavel(String ddlExpLavel) {
        this.ddlExpLavel = ddlExpLavel;
    }

    public String[] getDdlsessionType() {
        return ddlsessionType;
    }

    public void setDdlsessionType(String[] ddlsessionType) {
        this.ddlsessionType = ddlsessionType;
    }

    public String[] getDdlPosition() {
        return ddlPosition;
    }

    public void setDdlPosition(String[] ddlPosition) {
        this.ddlPosition = ddlPosition;
    }    
}