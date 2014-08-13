/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


/**
 *
 * @author Administrator
 */
public class EmployeeFamilyDetailspojo implements Serializable {
    private BigDecimal id;
    private String employee_id;
    private String family_member_name;
    private String relation;
    private Date dob_of_member;

    public Date getDob_of_member() {
        return dob_of_member;
    }

    public void setDob_of_member(Date dob_of_member) {
        this.dob_of_member = dob_of_member;
    }

  

    public String getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public String getFamily_member_name() {
        return family_member_name;
    }

    public void setFamily_member_name(String family_member_name) {
        this.family_member_name = family_member_name;
    }

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

 

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }



}
