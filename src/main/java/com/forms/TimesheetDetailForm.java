/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forms;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author computer1
 */
public class TimesheetDetailForm extends org.apache.struts.action.ActionForm {

    private Integer projectId;
    private String[] slot;
    private String employeeId;
    private String[] desc;
    private String method;
    private String approvestatus;
    private String timesheetdate;
    private Integer[] checked;
    private String[] reason;
    private Integer timesheetdetailid;
    private Integer[] hiddenid;

    public Integer[] getHiddenid() {
        return hiddenid;
    }

    public void setHiddenid(Integer[] hiddenid) {
        this.hiddenid = hiddenid;
    }

    public Integer getTimesheetdetailid() {
        return timesheetdetailid;
    }

    public void setTimesheetdetailid(Integer timesheetdetailid) {
        this.timesheetdetailid = timesheetdetailid;
    }

    public String[] getReason() {
        return reason;
    }

    public void setReason(String[] reason) {
        this.reason = reason;
    }

    public Integer[] getChecked() {
        return checked;
    }

    public void setChecked(Integer[] checked) {
        this.checked = checked;
    }

    public String getTimesheetdate() {
        return timesheetdate;
    }

    public void setTimesheetdate(String timesheetdate) {
        this.timesheetdate = timesheetdate;
    }

    public String getApprovestatus() {
        return approvestatus;
    }

    public void setApprovestatus(String approvestatus) {
        this.approvestatus = approvestatus;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String[] getDesc() {
        return desc;
    }

    public void setDesc(String[] desc) {
        this.desc = desc;
    }

    public String[] getSlot() {
        return slot;
    }

    public void setSlot(String[] slot) {
        this.slot = slot;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
        int length = 0;
        List<Integer> l = null;
        int le = 0;
        Character z = null;
        String c=null;

         if (getProjectId() != null) {

            c = getProjectId().toString();

            le = c.toCharArray().length;

              for (int i = 0; i < le; i++) {
            z=c.charAt(i);


            if(!Character.isDigit(z)){
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.integer.required"));

            }
        }
        }
        
      

        if (getDesc() != null) {
            length = getDesc().length;
        }

        for (int i = 0; i < length; i++) {
            if (getDesc()[i] == null || getDesc()[i].length() < 1) {
                l = new ArrayList<Integer>();
                l.add(i + 1);


            }
        }
        if (l != null) {
            StringBuilder sb = new StringBuilder();
            for (Integer u : l) {
                sb.append(u);
                sb.append(",");
            }
            sb.deleteCharAt(sb.length() - 1);
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.categoryname.required", sb.toString()));
        }
        return errors;
    }
}
