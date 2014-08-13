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
public class DocDump implements Serializable {

        private int dumpId;
        private int trainingId;
        private String pathName;
        private String expLavel;
        private String fileType;
        private String status;

    public int getDumpId() {
        return dumpId;
    }

    public void setDumpId(int dumpId) {
        this.dumpId = dumpId;
    }

    public String getExpLavel() {
        return expLavel;
    }

    public void setExpLavel(String expLavel) {
        this.expLavel = expLavel;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
