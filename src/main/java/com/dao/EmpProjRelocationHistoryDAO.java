/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.EmpProjRelocationHistory;
import com.util.EmpProjRelcHistUtil;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Sumit Kumar
 */
public interface EmpProjRelocationHistoryDAO {
    /**
     *
     * @param eprh
     * @return
     * @throws DAOException
     */
    public boolean save(EmpProjRelocationHistory eprh)throws DAOException;
    /**
     *
     * @param empid
     * @return
     * @throws DAOException
     */
    public List<EmpProjRelocationHistory> getRelocationHistoryByEmpId(String empid)throws DAOException;
    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    public EmpProjRelocationHistory getRelocationHistoryById(BigDecimal id)throws DAOException;

    public BigDecimal getLastId()throws DAOException;
    
    public List<EmpProjRelcHistUtil> getAllRelocationHistory()throws DAOException;
}
