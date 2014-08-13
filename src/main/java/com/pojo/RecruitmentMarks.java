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
public class RecruitmentMarks implements Serializable{

    private Integer id;
    private Integer candidateId;
    private String examName;
    private Integer maxMarks;
    private Integer marksObt;
    private Date examDate;

    public RecruitmentMarks() {
    }

    public RecruitmentMarks(Integer id, Integer candidateId, String examName, Integer maxMarks, Integer marksObt, Date examDate) {
        this.id = id;
        this.candidateId = candidateId;
        this.examName = examName;
        this.maxMarks = maxMarks;
        this.marksObt = marksObt;
        this.examDate = examDate;
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public Date getExamDate() {
        return examDate;
    }

    public void setExamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMarksObt() {
        return marksObt;
    }

    public void setMarksObt(Integer marksObt) {
        this.marksObt = marksObt;
    }

    public Integer getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(Integer maxMarks) {
        this.maxMarks = maxMarks;
    }

    public String getExamName() {
        return examName;
    }

    public void setExamName(String examName) {
        this.examName = examName;
    }

    
    
}
