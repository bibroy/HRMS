/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalSelf {

    private int id;
    private int category_code;
    private int question_code;
    private String answer;
    private String employee_code;

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCategory_code() {
        return category_code;
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
    

}
