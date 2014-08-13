/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.util.Date;

/**
 *
 * @author computer1
 */
public class AssessmentEvent {
     private Integer id;
   private String type;
    private Date eventdate;
    private String time;
     private String invigilator;
    private String center;

    public AssessmentEvent(Integer id, String type, Date eventdate) {
        this.id = id;
        this.type = type;
        this.eventdate = eventdate;
    }


    public AssessmentEvent(Integer id, String type, Date eventdate, String time, String invigilator, String center) {
        this.id = id;
        this.type = type;
        this.eventdate = eventdate;
        this.time = time;
        this.invigilator = invigilator;
        this.center = center;
    }

    public Date getEventdate() {
        return eventdate;
    }

    public void setEventdate(Date eventdate) {
        this.eventdate = eventdate;
    }

    public AssessmentEvent() {
    }

    public AssessmentEvent(Integer id) {
        this.id = id;
    }

   

    public String getCenter() {
        return center;
    }

    public void setCenter(String center) {
        this.center = center;
    }

    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvigilator() {
        return invigilator;
    }

    public void setInvigilator(String invigilator) {
        this.invigilator = invigilator;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
