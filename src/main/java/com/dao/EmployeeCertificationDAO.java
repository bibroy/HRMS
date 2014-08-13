/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.EmployeeCertification;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface EmployeeCertificationDAO {

    public boolean save(EmployeeCertification employeeCertification) throws DAOException;

    public EmployeeCertification getEmployeeCertification() throws DAOException;

    public boolean delete(EmployeeCertification employeeCertification) throws DAOException;

    public EmployeeCertification getEmployeeCertification(Integer certificationId) throws DAOException;

    public EmployeeCertification getEmployeeCertificationByCode(String certificationCode) throws DAOException;

    public List<EmployeeCertification> getAllEmployeeCertification() throws DAOException;

    public List<EmployeeCertification> getEmployeeCertificationByEmpId(String employeeMasterId) throws DAOException;
       
    public List<EmployeeCertification> getEmployeeCertificationName(String certificationName ,String empid) throws DAOException;

    public BigDecimal getLastId() throws DAOException;
}
