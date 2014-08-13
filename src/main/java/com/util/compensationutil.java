/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

/**
 *
 * @author computer1
 */
public class compensationutil implements java.io.Serializable {
      private String empid;
    private Integer totalmeasure;
    private Integer obtainmeasure;
    private Integer indicatorid;
    private String indicatorname;

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public Integer getIndicatorid() {
        return indicatorid;
    }

    public void setIndicatorid(Integer indicatorid) {
        this.indicatorid = indicatorid;
    }

    public String getIndicatorname() {
        return indicatorname;
    }

    public void setIndicatorname(String indicatorname) {
        this.indicatorname = indicatorname;
    }

    public Integer getObtainmeasure() {
        return obtainmeasure;
    }

    public void setObtainmeasure(Integer obtainmeasure) {
        this.obtainmeasure = obtainmeasure;
    }

    public Integer getTotalmeasure() {
        return totalmeasure;
    }

    public void setTotalmeasure(Integer totalmeasure) {
        this.totalmeasure = totalmeasure;
    }

    public compensationutil() {
    }

    public compensationutil(String empid, Integer totalmeasure, Integer obtainmeasure, Integer indicatorid, String indicatorname) {
        this.empid = empid;
        this.totalmeasure = totalmeasure;
        this.obtainmeasure = obtainmeasure;
        this.indicatorid = indicatorid;
        this.indicatorname = indicatorname;
    }


}
