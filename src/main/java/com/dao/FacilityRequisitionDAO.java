/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.FacilityRequisition;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Sumit Kumar
 */
public interface FacilityRequisitionDAO {

    public boolean sendRequest(FacilityRequisition document) throws DAOException;

    public FacilityRequisition viewRequestData(Integer requestCode) throws DAOException;

    public List<FacilityRequisition> getAllEmployees() throws DAOException;

    public boolean approve(FacilityRequisition airTcktReq) throws DAOException;

    public boolean reject(FacilityRequisition airTcktReq) throws DAOException;

    public List getSingleEmployeeDetails(String employeeId) throws DAOException;

    public BigDecimal getLastRequestId()throws DAOException;
}
