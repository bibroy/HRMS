/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalGradeForm extends org.apache.struts.action.ActionForm {

    private int[] grade_code;
    private String[] grade_name;

    public int[] getGrade_code() {
        return grade_code;
    }

    public void setGrade_code(int[] grade_code) {
        this.grade_code = grade_code;
    }

    public String[] getGrade_name() {
        return grade_name;
    }

    public void setGrade_name(String[] grade_name) {
        this.grade_name = grade_name;
    } 
}
