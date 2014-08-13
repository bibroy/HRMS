/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.pojo;

import java.io.Serializable;

/**
 *
 * @author ranjans
 */
public class Skills  implements Serializable{
    /***
     * Variable decaration
     */
    private int skillId;
    private String skillName;
    private int departmentId;
    private String status;
    private int typeId;

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    /***
     * Method declaration
     */

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

}