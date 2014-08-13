/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pojo;

import java.util.Date;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalCategory {

    private int category_code;
    private String category_name;
    private Date creation_date;
    private Date modification_date;
    private String created_by;
    private String modified_by;
    private String status;
    private String category_description;
    private String setup_status;

    public int getCategory_code() {
        return category_code;
    }

    public void setCategory_code(int category_code) {
        this.category_code = category_code;
    }

    public String getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String category_description) {
        this.category_description = category_description;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Date getModification_date() {
        return modification_date;
    }

    public void setModification_date(Date modification_date) {
        this.modification_date = modification_date;
    }

    public String getModified_by() {
        return modified_by;
    }

    public void setModified_by(String modified_by) {
        this.modified_by = modified_by;
    }

    public String getSetup_status() {
        return setup_status;
    }

    public void setSetup_status(String setup_status) {
        this.setup_status = setup_status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
   

}
