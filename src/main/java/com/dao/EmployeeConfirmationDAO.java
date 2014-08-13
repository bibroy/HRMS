/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.EmployeeConfirmation;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface EmployeeConfirmationDAO {

    public boolean save(EmployeeConfirmation employeeConfirmation) throws DAOException;

    public EmployeeConfirmation getEmployeeConfirmation() throws DAOException;

    public EmployeeConfirmation getEmployeeConfirmation(Integer confId) throws DAOException;

    public EmployeeConfirmation getEmployeeConfirmationByCode(String confCode) throws DAOException;

    public List<EmployeeConfirmation> getAllEmployeeConfirmation() throws DAOException;

    public EmployeeConfirmation getEmployeeConfirmationByEmpId(String employeeMasterId) throws DAOException;

    public BigDecimal getLastRequestId() throws DAOException;

}
