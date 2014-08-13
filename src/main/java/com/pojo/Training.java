/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author ranjans
 */
public class Training implements Serializable{

    private  int trainingId;
    private  String trainingType;
    private  String trainingName;
    private  String trainer;
    private  int consultancyId;
    private  String status;
    private  int id;
    private  int skillId;
    private Integer typeId;
    private Department dept ;
    private Skills skill;    
    private Consultancy consultancy;
    private JobType jobType;
    private int trainingTypeId;
    private List<String> sessionType;

    private List<TrainingPosition>trainingPosition;

    public Consultancy getConsultancy() {
        return consultancy;
    }

    public void setConsultancy(Consultancy consultancy) {
        this.consultancy = consultancy;
    }

    public int getTrainingTypeId() {
        return trainingTypeId;
    }

    public void setTrainingTypeId(int trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
    }

    
    public Skills getSkill() {
        return skill;
    }

    public void setSkill(Skills skill) {
        this.skill = skill;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public int getConsultancyId() {
        return consultancyId;
    }

    public void setConsultancyId(int consultancyId) {
        this.consultancyId = consultancyId;
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

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }    

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }
    

    public JobType getJobType() {
        return jobType;
    }

    public void setJobType(JobType jobType) {
        this.jobType = jobType;
    }

    public List<String> getSessionType() {
        return sessionType;
    }

    public void setSessionType(List<String> sessionType) {
        this.sessionType = sessionType;
    }

    public List<TrainingPosition> getTrainingPosition() {
        return trainingPosition;
    }

    public void setTrainingPosition(List<TrainingPosition> trainingPosition) {
        this.trainingPosition = trainingPosition;
    }

}