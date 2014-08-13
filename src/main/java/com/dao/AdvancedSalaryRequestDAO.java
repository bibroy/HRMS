/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.AdvancedSalaryRequest;
import java.util.List;
import java.math.BigDecimal;

/**
 *
 * @author sujatas
 */
public interface AdvancedSalaryRequestDAO {

    public boolean sendRequest(AdvancedSalaryRequest advancedSalaryReq) throws DAOException;

    public AdvancedSalaryRequest viewAdvancedSalaryRequestData(Integer hiddenId) throws DAOException;

    public List<AdvancedSalaryRequest> getAllEmployees() throws DAOException;

    public boolean approve(AdvancedSalaryRequest advancedSalaryReq) throws DAOException;

    public boolean reject(AdvancedSalaryRequest advancedSalaryReq) throws DAOException;

    public List getTotalSalary(Integer empId) throws DAOException;

    public List getSingleEmployeeDetails(String employeeId) throws DAOException;

    public BigDecimal getLastRequestId() throws DAOException;

    public List<AdvancedSalaryRequest> getAllRequest(String empid)throws DAOException;
}
