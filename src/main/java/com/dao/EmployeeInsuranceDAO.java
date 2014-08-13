/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.EmployeeInsurance;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Sumit Kumar
 */
public interface EmployeeInsuranceDAO {
    /**
     *
     * @param ei
     * @return
     * @throws DAOException
     */
    public boolean save(EmployeeInsurance ei)throws DAOException;

    /**
     *
     * @return
     * @throws DAOException
     */
    public List<EmployeeInsurance> getAllInsurance() throws DAOException;

    /**
     *
     * @param empid
     * @return
     * @throws DAOException
     */
    public List<EmployeeInsurance> getAllInsuranceById(String empid)throws DAOException;

    public BigDecimal getLastId() throws DAOException;
}
