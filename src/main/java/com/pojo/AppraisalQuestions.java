/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.util.Date;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalQuestions {

    public int category_code;
    public String category_name;
    public int question_code;
    public String question;
    private Date creation_date;
    private Date modification_date;
    private String created_by;
    private String modified_by;
    private String status;
    public AppraisalCategory category_id;

    public int getCategory_code() {
        return category_code;
    }

    public void setCategory_code(int category_code) {
        this.category_code = category_code;
    }

    public AppraisalCategory getCategory_id() {
        return category_id;
    }

    public void setCategory_id(AppraisalCategory category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getModification_date() {
        return modification_date;
    }

    public void setModification_date(Date modification_date) {
        this.modification_date = modification_date;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestion_code() {
        return question_code;
    }

    public void setQuestion_code(int question_code) {
        this.question_code = question_code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   
}
