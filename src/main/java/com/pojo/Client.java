/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author  Shrayanti
 */
public class Client implements Serializable {

   
    private Integer clientGrpid;
    private String clientName;
    private String clientCode;

    private String status;
    private String contactPerson;
    private String address;
    private String phone;
    private String mobile;
    private String fax;
    private String email;
    private Integer clId ;

    private ClientGroup clientgroup;
   

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

   

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public Integer getClientGrpid() {
        return clientGrpid;
    }

    public void setClientGrpid(Integer clientGrpid) {
        this.clientGrpid = clientGrpid;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

   

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

   

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ClientGroup getClientgroup() {
        return clientgroup;
    }

    public void setClientgroup(ClientGroup clientgroup) {
        this.clientgroup = clientgroup;
    }

    
    
}
