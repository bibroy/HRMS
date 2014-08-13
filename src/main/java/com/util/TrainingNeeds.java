/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

/**
 *
 * @author Pradipto roy
 */
public class TrainingNeeds implements java.io.Serializable{


    private String employeeId;
    private String firstName;
    private String category_name;
    private int category_code;
    private int score;

    public int getCategory_code() {
        return category_code;
    }

    public void setCategory_code(int category_code) {
        this.category_code = category_code;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }









}
