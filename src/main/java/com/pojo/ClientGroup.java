/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author shrayanti
 */
public class ClientGroup implements Serializable{

    private Integer grId;

    private String grCode;
    private String grName;

    private String grDescription;
    private String grStatus;

    public String getGrCode() {
        return grCode;
    }

    public void setGrCode(String grCode) {
        this.grCode = grCode;
    }

    public String getGrDescription() {
        return grDescription;
    }

    public void setGrDescription(String grDescription) {
        this.grDescription = grDescription;
    }

    public Integer getGrId() {
        return grId;
    }

    public void setGrId(Integer grId) {
        this.grId = grId;
    }

    public String getGrName() {
        return grName;
    }

    public void setGrName(String grName) {
        this.grName = grName;
    }

    public String getGrStatus() {
        return grStatus;
    }

    public void setGrStatus(String grStatus) {
        this.grStatus = grStatus;
    }

}
