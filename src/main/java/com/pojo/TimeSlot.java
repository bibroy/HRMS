/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author computer1
 */
public class TimeSlot implements java.io.Serializable{
    private Integer slotid;
    private String slot;
    private Integer duration;

    public TimeSlot() {
    }


    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

   

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public Integer getSlotid() {
        return slotid;
    }

    public void setSlotid(Integer slotid) {
        this.slotid = slotid;
    }

    public TimeSlot(Integer slotid, String slot, Integer duration) {
        this.slotid = slotid;
        this.slot = slot;
        this.duration = duration;
    }

   

}
