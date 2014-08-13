/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

import java.util.Date;

/**
 *
 * @author sujatas
 */
public class AirTicketRequestUtil {

    private String empId;
  /*  private String fname;
    private String lname;
    private String phone;
    private String email;
    private String designation;
    private String department;
    private int supervisor;
    private String projectName;*/
    private String airlineName;
    private String destination;
    private String purOfTrip;
    private Date depDate;
     private Date retDate;
    private Integer requestId;
     private Date requestDate;

    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the fname
     */
   /* public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
   

    /**
     * @return the airlineName
     */
    public String getAirlineName() {
        return airlineName;
    }

    /**
     * @param airlineName the airlineName to set
     */
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    /**
     * @return the destination
     */
    public String getDestination() {
        return destination;
    }

    /**
     * @param destination the destination to set
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * @return the purOfTrip
     */
    public String getPurOfTrip() {
        return purOfTrip;
    }

    /**
     * @param purOfTrip the purOfTrip to set
     */
    public void setPurOfTrip(String purOfTrip) {
        this.purOfTrip = purOfTrip;
    }

    /**
     * @return the depDate
     */
    public Date getDepDate() {
        return depDate;
    }

    /**
     * @param depDate the depDate to set
     */
    public void setDepDate(Date depDate) {
        this.depDate = depDate;
    }

    /**
     * @return the retDate
     */
    public Date getRetDate() {
        return retDate;
    }

    /**
     * @param retDate the retDate to set
     */
    public void setRetDate(Date retDate) {
        this.retDate = retDate;
    }

    /**
     * @return the requestId
     */
    public Integer getRequestId() {
        return requestId;
    }

    /**
     * @param requestId the requestId to set
     */
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    /**
     * @return the requestDate
     */
    public Date getRequestDate() {
        return requestDate;
    }

    /**
     * @param requestDate the requestDate to set
     */
    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

}
