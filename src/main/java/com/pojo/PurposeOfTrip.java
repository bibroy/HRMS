package com.pojo;
// Generated Nov 16, 2010 5:37:00 PM by Hibernate Tools 3.2.1.GA


import java.math.BigDecimal;

/**
 * PurposeOftripMaster generated by hbm2java
 */
public class PurposeOfTrip  implements java.io.Serializable {


     private BigDecimal puposeoftripid;
     private String purposeoftrip;
     private String status;

    public PurposeOfTrip() {
    }

	
    public PurposeOfTrip(BigDecimal puposeoftripid, String purposeoftrip) {
        this.puposeoftripid = puposeoftripid;
        this.purposeoftrip = purposeoftrip;
    }
    public PurposeOfTrip(BigDecimal puposeoftripid, String purposeoftrip, String status) {
       this.puposeoftripid = puposeoftripid;
       this.purposeoftrip = purposeoftrip;
       this.status = status;
    }
   
    public BigDecimal getPuposeoftripid() {
        return this.puposeoftripid;
    }
    
    public void setPuposeoftripid(BigDecimal puposeoftripid) {
        this.puposeoftripid = puposeoftripid;
    }
    public String getPurposeoftrip() {
        return this.purposeoftrip;
    }
    
    public void setPurposeoftrip(String purposeoftrip) {
        this.purposeoftrip = purposeoftrip;
    }
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }




}


