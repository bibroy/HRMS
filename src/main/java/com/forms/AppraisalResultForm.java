/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;



/**
 *
 * @author swarnendum
 */
public class AppraisalResultForm extends org.apache.struts.action.ActionForm {
    

    public int[] category_code;
    public int[] question_code;
    public String[] answer;
    public int employee_code;
    public String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }
    

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String[] answer) {
        this.answer = answer;
    }

    public int[] getCategory_code() {
        return category_code;
    }

    public void setCategory_code(int[] category_code) {
        this.category_code = category_code;
    }

    public int getEmployee_code() {
        return employee_code;
    }

    public void setEmployee_code(int employee_code) {
        this.employee_code = employee_code;
    }

    public int[] getQuestion_code() {
        return question_code;
    }

    public void setQuestion_code(int[] question_code) {
        this.question_code = question_code;
    }
   

}
