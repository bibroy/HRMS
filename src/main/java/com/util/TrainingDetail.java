/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

/**
 *
 * @author ranjans
 */
public class TrainingDetail {

    private  String trainingName;

    private  String trainer;
    private  String consultancy;
    private  String status;
    private String department;

    private  int skillId;
    private  int trainingId;
    private int departmentId;   
    private String skillName;
    private String trainingMode;

    // --
    private String conSultencyName;
    private int typeId;
    
    
    
    public String getConSultencyName() {
        return conSultencyName;
    }

    public void setConSultencyName(String conSultencyName) {
        this.conSultencyName = conSultencyName;
    }
    public String getTrainingMode() {
        return trainingMode;
    }

    public void setTrainingMode(String trainingMode) {
        this.trainingMode = trainingMode;
    }



    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }
    
    public String getConsultancy() {
        return consultancy;
    }

    public void setConsultancy(String consultancy) {
        this.consultancy = consultancy;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    
}