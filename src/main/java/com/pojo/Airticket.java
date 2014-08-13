package com.pojo;
// Generated Nov 16, 2010 4:50:45 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;
import java.util.Date;

/**
 * Airticket generated by hbm2java
 */
public class Airticket  implements java.io.Serializable {


     private BigDecimal requestid;
     private String employeeCode;
     private String airlineName;
     private String destination;
     private String purposeOdTrip;
     private Date departureDate;
     private String approvalstatus;
     private Date returndate;
     private String approvalauthoriyEmployeeid;
     private Date requestdate;
     private Date approvaldate;
     private String travelFrom;
     private String departureTime;
     private String returnTime;
     private String includeHotel;
     private String includeCar;
     private String nonSmokingRoom;
     private String tripClass;
     private String carClass;
     private String seatLocation;

    public Airticket() {
    }

	
    public Airticket(BigDecimal requestid) {
        this.requestid = requestid;
    }
    public Airticket(BigDecimal requestid, String employeeCode, String airlineName, String destination, String purposeOdTrip, Date departureDate, String approvalstatus, Date returndate, String approvalauthoriyEmployeeid, Date requestdate, Date approvaldate, String travelFrom, String departureTime, String returnTime, String includeHotel, String includeCar, String nonSmokingRoom, String tripClass, String carClass, String seatLocation) {
       this.requestid = requestid;
       this.employeeCode = employeeCode;
       this.airlineName = airlineName;
       this.destination = destination;
       this.purposeOdTrip = purposeOdTrip;
       this.departureDate = departureDate;
       this.approvalstatus = approvalstatus;
       this.returndate = returndate;
       this.approvalauthoriyEmployeeid = approvalauthoriyEmployeeid;
       this.requestdate = requestdate;
       this.approvaldate = approvaldate;
       this.travelFrom = travelFrom;
       this.departureTime = departureTime;
       this.returnTime = returnTime;
       this.includeHotel = includeHotel;
       this.includeCar = includeCar;
       this.nonSmokingRoom = nonSmokingRoom;
       this.tripClass = tripClass;
       this.carClass = carClass;
       this.seatLocation = seatLocation;
    }
   
    public BigDecimal getRequestid() {
        return this.requestid;
    }
    
    public void setRequestid(BigDecimal requestid) {
        this.requestid = requestid;
    }
    public String getEmployeeCode() {
        return this.employeeCode;
    }
    
    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
    public String getAirlineName() {
        return this.airlineName;
    }
    
    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }
    public String getDestination() {
        return this.destination;
    }
    
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getPurposeOdTrip() {
        return this.purposeOdTrip;
    }
    
    public void setPurposeOdTrip(String purposeOdTrip) {
        this.purposeOdTrip = purposeOdTrip;
    }
    public Date getDepartureDate() {
        return this.departureDate;
    }
    
    public void setDepartureDate(Date departureDate) {
        this.departureDate = departureDate;
    }
    public String getApprovalstatus() {
        return this.approvalstatus;
    }
    
    public void setApprovalstatus(String approvalstatus) {
        this.approvalstatus = approvalstatus;
    }
    public Date getReturndate() {
        return this.returndate;
    }
    
    public void setReturndate(Date returndate) {
        this.returndate = returndate;
    }
    public String getApprovalauthoriyEmployeeid() {
        return this.approvalauthoriyEmployeeid;
    }
    
    public void setApprovalauthoriyEmployeeid(String approvalauthoriyEmployeeid) {
        this.approvalauthoriyEmployeeid = approvalauthoriyEmployeeid;
    }
    public Date getRequestdate() {
        return this.requestdate;
    }
    
    public void setRequestdate(Date requestdate) {
        this.requestdate = requestdate;
    }
    public Date getApprovaldate() {
        return this.approvaldate;
    }
    
    public void setApprovaldate(Date approvaldate) {
        this.approvaldate = approvaldate;
    }
    public String getTravelFrom() {
        return this.travelFrom;
    }
    
    public void setTravelFrom(String travelFrom) {
        this.travelFrom = travelFrom;
    }
    public String getDepartureTime() {
        return this.departureTime;
    }
    
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public String getReturnTime() {
        return this.returnTime;
    }
    
    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }
    public String getIncludeHotel() {
        return this.includeHotel;
    }
    
    public void setIncludeHotel(String includeHotel) {
        this.includeHotel = includeHotel;
    }
    public String getIncludeCar() {
        return this.includeCar;
    }
    
    public void setIncludeCar(String includeCar) {
        this.includeCar = includeCar;
    }
    public String getNonSmokingRoom() {
        return this.nonSmokingRoom;
    }
    
    public void setNonSmokingRoom(String nonSmokingRoom) {
        this.nonSmokingRoom = nonSmokingRoom;
    }
    public String getTripClass() {
        return this.tripClass;
    }
    
    public void setTripClass(String tripClass) {
        this.tripClass = tripClass;
    }
    public String getCarClass() {
        return this.carClass;
    }
    
    public void setCarClass(String carClass) {
        this.carClass = carClass;
    }
    public String getSeatLocation() {
        return this.seatLocation;
    }
    
    public void setSeatLocation(String seatLocation) {
        this.seatLocation = seatLocation;
    }




}


