/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author pradipto
 *
 *
 */
public class Successor implements Serializable {

    private Integer id;
    private String positionID;
    private String succesorID;
    private String type;
    private Date entryDate;

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }


    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPositionID() {
        return positionID;
    }

    public void setPositionID(String positionID) {
        this.positionID = positionID;
    }

    public String getSuccesorID() {
        return succesorID;
    }

    public void setSuccesorID(String succesorID) {
        this.succesorID = succesorID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
