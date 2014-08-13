/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.dao.DAOException;
import com.pojo.City;
import com.pojo.EmployeeMaster;
import com.pojo.State;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author sudipb
 */
public interface EmployeeMasterDAO {

    public boolean save(EmployeeMaster employeeMaster) throws DAOException;

    public EmployeeMaster getEmployeeMaster() throws DAOException;

    public EmployeeMaster getEmployeeMaster(Integer employeeMasterId) throws DAOException;

    public EmployeeMaster getEmployeeMasterByCode(String employeeMasterCode) throws DAOException;


    public List<EmployeeMaster> getAllEmployeeMaster() throws DAOException;

    public EmployeeMaster getEmployeeMasterByEmpId(String employeeMasterId) throws DAOException;

    public BigDecimal getLastRequestId() throws DAOException;

    public List<EmployeeMaster> getEmployeeByBranchID(String branchid)throws DAOException;
    public EmployeeMaster getDepartmentId(String employeeMasterId) throws DAOException ;

    public List<EmployeeMaster>getEmployeeInformationByDepartmentID(Integer departmentid)throws DAOException;
    public List<EmployeeMaster>getEmployeeInformationByGrades(String grades)throws DAOException;
    public List<EmployeeMaster>getOrganizationStructure()throws DAOException;



}
