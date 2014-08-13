/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;




/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalCategoryForm extends org.apache.struts.action.ActionForm {

    public int[] category_code;
    public String[] category_name;
    public String[] category_description;
    public int created_by;
    public int modified_by;
    public Date creation_date;
    public Date modification_date;
    public String status;

    public int[] getCategory_code() {
        return category_code;
    }

    public void setCategory_code(int[] category_code) {
        this.category_code = category_code;
    }

    

    public String[] getCategory_description() {
        return category_description;
    }

    public void setCategory_description(String[] category_description) {
        this.category_description = category_description;
    }

    public String[] getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String[] category_name) {
        this.category_name = category_name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCreated_by() {
        return created_by;
    }

    public void setCreated_by(int created_by) {
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

    public int getModified_by() {
        return modified_by;
    }

    public void setModified_by(int modified_by) {
        this.modified_by = modified_by;
    }


    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        int length = 0;
        List<Integer> l= null;
        if (getCategory_name() != null) {
            length = getCategory_name().length;
        }
        for (int i = 0; i < length; i++) {
            if (getCategory_name()[i] == null || getCategory_name()[i].length() < 1) {
                
                l=new ArrayList<Integer>();
                l.add(i+1);
}
 }
        if(l != null){
                StringBuilder sb= new StringBuilder();
                for(Integer u:l){
                     sb.append(u);
                     sb.append(",");
                }
                sb.deleteCharAt(sb.length()-1);
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.categoryname.required",sb.toString()));
            }


       return errors;
    }



}