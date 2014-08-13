/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

/**
 *
 * @author computer1
 */
public class CompensationIndicatorMaster implements java.io.Serializable {
    private Integer id;
    private String indicator;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIndicator() {
        return indicator;
    }

    public void setIndicator(String indicator) {
        this.indicator = indicator;
    }

    public CompensationIndicatorMaster() {
    }

    public CompensationIndicatorMaster(Integer id) {
        this.id = id;
    }

    public CompensationIndicatorMaster(Integer id, String indicator) {
        this.id = id;
        this.indicator = indicator;
    }



}
