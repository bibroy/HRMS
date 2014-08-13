/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Leave;
import java.util.List;
import java.math.BigDecimal;

/**
 *
 * @author sujatas
 */
public interface LeaveRequestDAO {

    public boolean sendRequest(Leave leave) throws DAOException;

    public Leave viewLeaveRequestData(Integer id) throws DAOException;

    public List<Leave> getAllEmployees() throws DAOException;

    public boolean approve(Leave leave) throws DAOException;

    public boolean reject(Leave leave) throws DAOException;
    //public List getLoginDetails(Integer empId)throws DAOException;

    //public Double getNoOfAvailableLeave(String empId,Integer leaveId)throws DAOException;
    public List getAllLeaveReport(String employeeId) throws DAOException;

    public List getSingleEmployeeDetails(String employeeId) throws DAOException;

    public BigDecimal getLastRequestId() throws DAOException;

    public List<Leave> getAllRequest(String empid)throws DAOException;
}
