/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.EmployeeEducationDetails;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface EmployeeEducationDetailsDAO {
             public boolean save(EmployeeEducationDetails employeeEducationDetails)throws DAOException;

		public EmployeeEducationDetails getEmployeeEducationDetails() throws DAOException;

		 public boolean delete(EmployeeEducationDetails employeeEducationDetails) throws DAOException;

		public EmployeeEducationDetails getEmployeeEducationDetails(Integer employeeEducationDetailsId) throws DAOException;

		public EmployeeEducationDetails getEmployeeEducationDetailsByCode(String employeeEducationDetailsCode) throws DAOException;

		public List<EmployeeEducationDetails> getAllEmployeeEducationDetails() throws DAOException;
              public List<EmployeeEducationDetails> getEmployeeEducationDetailsByEmpId(String employeeMasterId) throws DAOException;
}
