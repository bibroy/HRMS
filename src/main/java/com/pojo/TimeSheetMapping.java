/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

/**
 *
 * @author computer1
 */
public class TimeSheetMapping implements java.io.Serializable {
  
    private String empid;
    private  TimesheetHeader headerid;

    public TimeSheetMapping() {
    }


    public TimeSheetMapping(String empid, TimesheetHeader headerid) {
        this.empid = empid;
        this.headerid = headerid;
    }

    
    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public TimesheetHeader getHeaderid() {
        return headerid;
    }

    public void setHeaderid(TimesheetHeader headerid) {
        this.headerid = headerid;
    }

  

   


}
