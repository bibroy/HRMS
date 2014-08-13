/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;
import java.util.Date;


/**
 *
 * @author computer1
 */
public class selfAppraisalResult {
    private int id;
    private int category_code;
    private int question_code;
    private String answer;
    private String employee_code;
    private String employee_name;
    private String gender;
    private String company;
    private String department;
    private String designation;
    private String employment_status;
    private String puntuality;
    private String current_project;
    //private String experience;
    private int score;
    private String grade_name;
    private String question;
    private Date appraisedate;

    public int getCategory_code() {
        return category_code;
    }

    public Date getAppraisedate() {
        return appraisedate;
    }

    public void setAppraisedate(Date appraisedate) {
        this.appraisedate = appraisedate;
    }

    public void setCategory_code(int category_code) {
        this.category_code = category_code;
    }

    public String getEmployee_code() {
        return employee_code;
    }

    public void setEmployee_code(String employee_code) {
        this.employee_code = employee_code;
    }
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestion_code() {
        return question_code;
    }

    public void setQuestion_code(int question_code) {
        this.question_code = question_code;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getEmployment_status() {
        return employment_status;
    }

    public void setEmployment_status(String employment_status) {
        this.employment_status = employment_status;
    }

    public String getCurrent_project() {
        return current_project;
    }

    public void setCurrent_project(String current_project) {
        this.current_project = current_project;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

   /* public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    } */

    public String getPuntuality() {
        return puntuality;
    }

    public void setPuntuality(String puntuality) {
        this.puntuality = puntuality;
    }

    public String getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String grade_name) {
        this.grade_name = grade_name;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

}



