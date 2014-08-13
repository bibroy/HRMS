/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.util.Date;

/**
 *
 * @author pradipto Roy
 */
public class TraingCalender implements java.io.Serializable {
    
   private Integer id;
    private Date fromDate;
    private Date toDate;
    private String trainingName;
    private String capacityStrenth;
    private String createdBy;
    private Date creationDate;

    public String getCapacityStrenth() {
        return capacityStrenth;
    }

    public void setCapacityStrenth(String capacityStrenth) {
        this.capacityStrenth = capacityStrenth;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }



}
