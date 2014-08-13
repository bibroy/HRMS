/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Department;
import java.util.List;
import java.math.BigDecimal;

/**
 *
 * @author Shrayanti Bhattacharyya
 */
public interface DepartmentDAO {

    public boolean save(Department department) throws DAOException;

    public Department getDepartment() throws DAOException;

    public Department getDepartment(Integer departmentId) throws DAOException;

    public Department getDepartmentByCode(String departmentCode) throws DAOException;

    public List<Department> getAllDepartment() throws DAOException;

    public BigDecimal getLastRequestId() throws DAOException;

    public List<Department> getDepartmentByCompanyCode(Integer CompCode) throws DAOException;
  public Department getDepartment(String departmentId) throws DAOException ;
}
