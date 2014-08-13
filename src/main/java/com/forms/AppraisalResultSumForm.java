/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import com.pojo.AppraisalResultSum;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

/**
 *
 * @author Sumit Kumar
 */
public class AppraisalResultSumForm extends org.apache.struts.action.ActionForm {

    private int id;
    private int category_code;
    private String category_name;
    private int score;
    private int month_of_appraisal;
    private int year_of_appraisal;
    private String employee_code;
    private String employee_name;
    private String gender;
    private String company;
    private String department;
    private String designation;
    private String employment_status;
    private String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    private List<AppraisalResultSum> appsumList;

    
    public List<AppraisalResultSum> getAppsumList() {
        return appsumList;
    }

    public void setAppsumList(List<AppraisalResultSum> appsumList) {
        this.appsumList = appsumList;
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

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getYear_of_appraisal() {
        return year_of_appraisal;
    }

    public void setYear_of_appraisal(int year_of_appraisal) {
        this.year_of_appraisal = year_of_appraisal;
    }

    public AppraisalResultSumForm() {
        super();
        // TODO Auto-generated constructor stub
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
