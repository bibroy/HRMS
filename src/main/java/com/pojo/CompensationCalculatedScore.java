/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author computer1
 */
public class CompensationCalculatedScore implements Serializable {
   private Integer id;
   private String empid;
   private Integer score;
   private Date scorecalculationdate;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Date getScorecalculationdate() {
        return scorecalculationdate;
    }

    public void setScorecalculationdate(Date scorecalculationdate) {
        this.scorecalculationdate = scorecalculationdate;
    }

    public CompensationCalculatedScore() {
    }

    public CompensationCalculatedScore(Integer id, String empid, Integer score) {
        this.id = id;
        this.empid = empid;
        this.score = score;
    }



}
