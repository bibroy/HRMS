/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Loan;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author sujatas
 */
public interface LoanDAO {

    public boolean sendRequest(Loan loanPojo) throws DAOException;

    public List getTotalSalary(Integer empId) throws DAOException;

    public List<Loan> getAllEmployees() throws DAOException;

    public boolean approve(Loan loan) throws DAOException;

    public boolean reject(Loan loan) throws DAOException;

    public Loan viewLoanRequestData(Integer id) throws DAOException;

    public List getSingleEmployeeDetails(String employeeId) throws DAOException;

    public BigDecimal getLastRequestId() throws DAOException;

    public List<Loan> getRequestStatus(String empid)throws DAOException;
}
