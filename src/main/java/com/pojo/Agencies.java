/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

/**
 *
 * @author computer1
 */
public class Agencies  implements java.io.Serializable {
    private Integer id;
    private String name;
     private String address;
    private String phnno;
    private String email;
     private Integer amount;

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = Address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhnno() {
        return phnno;
    }

    public void setPhnno(String phnno) {
        this.phnno = phnno;
    }

    public Agencies(Integer id, String name, String Address, String phnno, String email) {
        this.id = id;
        this.name = name;
        this.address = Address;
        this.phnno = phnno;
        this.email = email;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Agencies() {
    }


    public Agencies(Integer id) {
        this.id = id;
    }

    public Agencies(Integer id, String name) {
        this.id = id;
        this.name = name;
    }




}
