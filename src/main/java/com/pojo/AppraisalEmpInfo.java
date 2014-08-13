/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.io.Serializable;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalEmpInfo implements Serializable{

    private int id;
    private String employee_id;
    private String employee_name;
    private String gender;
    private Integer company_code;
    private String company;
    private int department_id;
    private String department;
    private int designation_id;
    private String designation;
    private String employment_status;
    private Integer days_of_experience;
    private Integer total_present;
    private Integer total_absent;
    private Integer total_working_day;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
    
    public Integer getCompany_code() {
        return company_code;
    }

    public void setCompany_code(Integer company_code) {
        this.company_code = company_code;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getDesignation_id() {
        return designation_id;
    }

    public void setDesignation_id(int designation_id) {
        this.designation_id = designation_id;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
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

    public Integer getDays_of_experience() {
        return days_of_experience;
    }

    public void setDays_of_experience(Integer days_of_experience) {
        this.days_of_experience = days_of_experience;
    }

    public Integer getTotal_absent() {
        return total_absent;
    }

    public void setTotal_absent(Integer total_absent) {
        this.total_absent = total_absent;
    }


    public Integer getTotal_working_day() {
        return total_working_day;
    }

    public void setTotal_working_day(Integer total_working_day) {
        this.total_working_day = total_working_day;
    }
    
    
}

