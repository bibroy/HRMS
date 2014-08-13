/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forms;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;




/**
 *
 * @author sudipb
 */
public class GradeForm extends org.apache.struts.action.ActionForm {

    private Integer id;
    private String gradeName;
    private Integer gradeMin;
    private Integer gradeMax;
    private Date entryDate;
    private Date modifyDate;
    private Integer createdBy;
    private Integer modifiedBy;
    private String status;
    private String method;

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public Integer getGradeMax() {
        return gradeMax;
    }

    public void setGradeMax(Integer gradeMax) {
        this.gradeMax = gradeMax;
    }

    public Integer getGradeMin() {
        return gradeMin;
    }

    public void setGradeMin(Integer gradeMin) {
        this.gradeMin = gradeMin;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Integer getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Integer modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

public void clear(){


      gradeName=null;
      gradeMin=null;
      gradeMax=null;

}
    
}
