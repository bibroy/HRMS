/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

/**
 *
 * @author pradipto roy
 */
public class ClientStatusReport {

  private String  clientName;
  private Integer clId ;
  private String  address;
  private String  phone;
  private String  fax;
  private String  email;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getClId() {
        return clId;
    }

    public void setClId(Integer clId) {
        this.clId = clId;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
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



}
