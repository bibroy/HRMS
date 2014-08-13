/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

/**
 *
 * @author computer1
 */
public class appraisalresultutil implements java.io.Serializable {
    Integer categorycode;
   String categoryname;
   Double percentage;

    public Integer getCategorycode() {
        return categorycode;
    }

    public void setCategorycode(Integer categorycode) {
        this.categorycode = categorycode;
    }

    public String getCategoryname() {
        return categoryname;
    }

    public void setCategoryname(String categoryname) {
        this.categoryname = categoryname;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public appraisalresultutil(Integer categorycode, String categoryname, Double percentage) {
        this.categorycode = categorycode;
        this.categoryname = categoryname;
        this.percentage = percentage;
    }

    public appraisalresultutil() {
    }

   


}
