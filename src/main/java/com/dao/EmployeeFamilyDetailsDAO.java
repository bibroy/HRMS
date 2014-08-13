/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.EmployeeFamilyDetails;
import com.pojo.EmployeeFamilyDetailspojo;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface EmployeeFamilyDetailsDAO {

    public boolean save(EmployeeFamilyDetails employeeFamilyDetails) throws DAOException;

    public EmployeeFamilyDetails getEmployeeFamilyDetails() throws DAOException;

    public EmployeeFamilyDetails getEmployeeFamilyDetails(Integer employeeFamilyDetailsId) throws DAOException;

    public boolean delete(EmployeeFamilyDetails employeeFamilyDetails) throws DAOException;

    public EmployeeFamilyDetails getEmployeeFamilyDetailsByCode(String employeeFamilyDetailsCode) throws DAOException;

    public List<EmployeeFamilyDetails> getAllEmployeeFamilyDetails() throws DAOException;

    public List<EmployeeFamilyDetails> getEmployeeFamilyDetailsByEmpId(String employeeMasterId) throws DAOException;

    public boolean save(EmployeeFamilyDetailspojo empdaoobj)throws DAOException;
    public BigDecimal getLastRequestId() throws DAOException;
}
