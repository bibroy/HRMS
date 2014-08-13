/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.forms;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;


/**
 *
 * @author Sumit Kumar
 */
public class AirTicketRequestForm extends org.apache.struts.action.ActionForm {

    private String empId;
    private String airlineName;
    private String destination;
    private String purOfTrip;
    private String depDate;
    private String returnDate;
    private String address;
    private String[] memberDOB;
    private String flightClass;
    private String[] memberRelation;
    private String[] memberName;
    private Integer[] memberId;
    private String from;
    private String departureTime;
    private String returnTime;
    private String includeHotel;
    private String includeCar;
    private String nonSmokingRoom;
    private String tripClass;
    private String carClass;
    private String seatLocation;
    private String button;
    private String method;
    private Integer hiddenId;
    private String status;
    private String whyReject;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    public String getCarClass() {
        return carClass;
    }

    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }

    public String getDepDate() {
        return depDate;
    }

    public void setDepDate(String depDate) {
        this.depDate = depDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFlightClass() {
        return flightClass;
    }

    public void setFlightClass(String flightClass) {
        this.flightClass = flightClass;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getHiddenId() {
        return hiddenId;
    }

    public void setHiddenId(Integer hiddenId) {
        this.hiddenId = hiddenId;
    }

    public String getIncludeCar() {
        return includeCar;
    }

    public void setIncludeCar(String includeCar) {
        this.includeCar = includeCar;
    }

    public String getIncludeHotel() {
        return includeHotel;
    }

    public void setIncludeHotel(String includeHotel) {
        this.includeHotel = includeHotel;
    }

    public String[] getMemberDOB() {
        return memberDOB;
    }

    public void setMemberDOB(String[] memberDOB) {
        this.memberDOB = memberDOB;
    }

    public Integer[] getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer[] memberId) {
        this.memberId = memberId;
    }

    public String[] getMemberName() {
        return memberName;
    }

    public void setMemberName(String[] memberName) {
        this.memberName = memberName;
    }

    public String[] getMemberRelation() {
        return memberRelation;
    }

    public void setMemberRelation(String[] memberRelation) {
        this.memberRelation = memberRelation;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNonSmokingRoom() {
        return nonSmokingRoom;
    }

    public void setNonSmokingRoom(String nonSmokingRoom) {
        this.nonSmokingRoom = nonSmokingRoom;
    }

    public String getPurOfTrip() {
        return purOfTrip;
    }

    public void setPurOfTrip(String purOfTrip) {
        this.purOfTrip = purOfTrip;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

    public String getSeatLocation() {
        return seatLocation;
    }

    public void setSeatLocation(String seatLocation) {
        this.seatLocation = seatLocation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTripClass() {
        return tripClass;
    }

    public void setTripClass(String tripClass) {
        this.tripClass = tripClass;
    }

    public String getWhyReject() {
        return whyReject;
    }

    public void setWhyReject(String whyReject) {
        this.whyReject = whyReject;
    }

    

    public AirTicketRequestForm() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param request The HTTP Request we are processing.
     * @return
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
        ActionErrors errors = new ActionErrors();
//        if (getName() == null || getName().length() < 1) {
//            errors.add("name", new ActionMessage("error.name.required"));
//            // TODO: add 'error.name.required' key to your resources
//        }
        return errors;
    }
}
