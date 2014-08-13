/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.forms;

import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalSetupForm extends org.apache.struts.action.ActionForm {
    
    public int id[];
    public int[] category_id;
    public String appraiser;
    public String response_type;
    public String duration;
    public int department;
    public int external_contributer;
    public Date last_date;
    public String feedback_status;
    public String message;
    public String status;

public String method;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int[] getId() {
        return id;
    }

    public void setId(int[] id) {
        this.id = id;
    }

    public String getAppraiser() {
        return appraiser;
    }

    public void setAppraiser(String appraiser) {
        this.appraiser = appraiser;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
    
    public int[] getCategory_id() {
        return category_id;
    }
    public void setCategory_id(int[] category_id) {
        this.category_id = category_id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getExternal_contributer() {
        return external_contributer;
    }

    public int getDepartment() {
        return department;
    }

    public void setDepartment(int department) {
        this.department = department;
    }
    public void setExternal_contributer(int external_contributer) {
        this.external_contributer = external_contributer;
    }

    public Date getLast_date() {
        return last_date;
    }

    public void setLast_date(Date last_date) {
        this.last_date = last_date;
    }
    
    public String getResponse_type() {
        return response_type;
    }

    public void setResponse_type(String response_type) {
        this.response_type = response_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFeedback_status() {
        return feedback_status;
    }

    public void setFeedback_status(String feedback_status) {
        this.feedback_status = feedback_status;
    }

    @Override
    public void reset(ActionMapping mapping,HttpServletRequest request)
    {
    id=null;
    category_id=null;
    appraiser=null;
    String response_type=null;
    department=0;
    external_contributer=0;
        String status=null;
    }

}
