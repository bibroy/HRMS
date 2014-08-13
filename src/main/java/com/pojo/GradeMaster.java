/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;
import java.io.Serializable;


/**
 *
 * @author pradipto
 * created on 2/2/2011
 */
public class GradeMaster implements Serializable
{
private String grade;
private String maxSalary;
private String minSalary;
private String status;

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getMaxSalary() {
        return maxSalary;
    }

    public void setMaxSalary(String maxSalary) {
        this.maxSalary = maxSalary;
    }

    public String getMinSalary() {
        return minSalary;
    }

    public void setMinSalary(String minSalary) {
        this.minSalary = minSalary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }






}
