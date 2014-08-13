/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.Reimbursment;
import java.util.List;
import java.math.BigDecimal;
/**
 *
 * @author sujatas
 */
public interface ReimbursmentDAO {
    public boolean sendRequest(Reimbursment reimbursment)throws DAOException;
    public Reimbursment viewReimbursmentRequestData(Integer requestCode) throws DAOException;
      public List<Reimbursment> getAllEmployees()throws DAOException;
public boolean approve(Reimbursment reimbursment)throws DAOException;
     public boolean reject(Reimbursment reimbursment)throws DAOException;
      public List getSingleEmployeeDetails(String employeeId)throws DAOException;
public BigDecimal getLastRequestId() throws DAOException;
}
