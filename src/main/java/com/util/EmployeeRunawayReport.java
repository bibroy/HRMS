/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;
import java.io.Serializable;
/**
 *
 * @author pradipto roy
 * Date of created: 2/2/2011
 */
public class EmployeeRunawayReport implements Serializable     {


     private  String employeeId;
    private String  name;

     private String nationality;
   private String designationName;
   private String departmentName;

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDesignationName() {
        return designationName;
    }

    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

   



}
