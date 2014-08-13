/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author swarnendum
 */
public class AppraisalResultSum implements Serializable{


    private int id;
    private int category_code;
    private String category_name;
    private Double score;
    private int month_of_appraisal;
    private int year_of_appraisal;
    private String employee_code;
    private String employee_name;
    private String gender;
    private String company;
    private String department;
    private String designation;
    private String employment_status;
    private Date appraisal_date;

    public Date getAppraisal_date() {
        return appraisal_date;
    }

    public void setAppraisal_date(Date appraisal_date) {
        this.appraisal_date = appraisal_date;
    }


    public int getCategory_code() {
        return category_code;
    }

    public void setCategory_code(int category_code) {
        this.category_code = category_code;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
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

    public String getEmployee_code() {
        return employee_code;
    }

    public void setEmployee_code(String employee_code) {
        this.employee_code = employee_code;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public String getEmployment_status() {
        return employment_status;
    }

    public void setEmployment_status(String employment_status) {
        this.employment_status = employment_status;
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

    public int getMonth_of_appraisal() {
        return month_of_appraisal;
    }

    public void setMonth_of_appraisal(int month_of_appraisal) {
        this.month_of_appraisal = month_of_appraisal;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

   

    public int getYear_of_appraisal() {
        return year_of_appraisal;
    }

    public void setYear_of_appraisal(int year_of_appraisal) {
        this.year_of_appraisal = year_of_appraisal;
    }


}
