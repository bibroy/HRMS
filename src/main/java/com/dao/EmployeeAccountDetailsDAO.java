/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.EmployeeAccountDetails;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface EmployeeAccountDetailsDAO {


        public boolean save(EmployeeAccountDetails employeeAccountDetails)throws DAOException;

		public EmployeeAccountDetails getEmployeeAccountDetails() throws DAOException;

		

		public EmployeeAccountDetails getEmployeeAccountDetails(Integer employeeAccountDetailsId) throws DAOException;

		public EmployeeAccountDetails getEmployeeAccountDetailsByCode(String employeeAccountDetailsCode) throws DAOException;

		public List<EmployeeAccountDetails> getAllEmployeeAccountDetails() throws DAOException;
                 public EmployeeAccountDetails getEmployeeAccountDetailsByEmpId(String employeeMasterId) throws DAOException;
                 public BigDecimal getLastRequestId() throws DAOException;

}
