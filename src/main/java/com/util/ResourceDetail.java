/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

/**
 * 
 * @author shrayanti
 */
public class ResourceDetail {

    private  String resourceName;
    private  String skill;

    private  String profiency;
    private  String lastUsed;
    
    private  String allocatedProject;

    public String getAllocatedProject() {
        return allocatedProject;
    }

    public void setAllocatedProject(String allocatedProject) {
        this.allocatedProject = allocatedProject;
    }

    public String getLastUsed() {
        return lastUsed;
    }

    public void setLastUsed(String lastUsed) {
        this.lastUsed = lastUsed;
    }

    public String getProfiency() {
        return profiency;
    }

    public void setProfiency(String profiency) {
        this.profiency = profiency;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }
    

}