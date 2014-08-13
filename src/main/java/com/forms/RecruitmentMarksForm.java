/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Sumit Kumar
 */
public class RecruitmentMarksForm extends org.apache.struts.action.ActionForm {

    private Integer id;
    private Integer candidateId;
    private String[] examName;
    private Integer[] maxMarks;
    private Integer[] marksObt;
    private String[] examDate;


    public RecruitmentMarksForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Integer getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Integer candidateId) {
        this.candidateId = candidateId;
    }

    public String[] getExamDate() {
        return examDate;
    }

    public void setExamDate(String[] examDate) {
        this.examDate = examDate;
    }

    public String[] getExamName() {
        return examName;
    }

    public void setExamName(String[] examName) {
        this.examName = examName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer[] getMarksObt() {
        return marksObt;
    }

    public void setMarksObt(Integer[] marksObt) {
        this.marksObt = marksObt;
    }

    public Integer[] getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(Integer[] maxMarks) {
        this.maxMarks = maxMarks;
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
