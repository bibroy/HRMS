/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.SalaryBreakup;
import com.pojo.SalaryHead;
import java.util.List;
import java.math.BigDecimal;
/**
 *
 * @author Sumit Kumar
 */

public interface SalaryDAO {

    public boolean save(SalaryBreakup sb) throws DAOException;

    public Double getSalarybyId(String id) throws DAOException;

    public List<SalaryBreakup> getSalaryList() throws DAOException;

    public Double getAdvancedSalById(String id, Integer month, Integer year ) throws DAOException;

    public Double getLeaveDays(String id, Integer month, Integer year ) throws DAOException;

    public BigDecimal getId(String empId) throws DAOException;

    public SalaryBreakup getSalaryBreakupById(BigDecimal id)throws DAOException;
}
