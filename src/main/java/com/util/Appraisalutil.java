/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;


/**
 *
 * @author computer1
 */
public class Appraisalutil {
  Integer score;
    String appraisal_date;

    public String getAppraisal_date() {
        return appraisal_date;
    }

    public void setAppraisal_date(String appraisal_date) {
        this.appraisal_date = appraisal_date;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    public Appraisalutil(Integer score, String appraisal_date) {
        this.score = score;
        this.appraisal_date = appraisal_date;
    }


  

    public Appraisalutil() {
    }

    public Appraisalutil(int score) {
        this.score = score;
    }


}
