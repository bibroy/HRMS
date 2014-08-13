/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;


/**
 *
 * @author swarnendum
 */
public class AppraisalQuestionForm extends org.apache.struts.action.ActionForm {

    public int[] category_code;
    public String[] question;

    public int[] getCategory_code() {
        return category_code;
    }

    public void setCategory_code(int[] category_code) {
        this.category_code = category_code;
    }
    public String[] getQuestion() {
        return question;
    }

    public void setQuestion(String[] question) {
        this.question = question;
    }
   
}
