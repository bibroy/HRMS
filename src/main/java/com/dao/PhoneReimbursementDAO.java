/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;
import com.pojo.PhoneReimbursment;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author Sumit Kumar
 */
public interface PhoneReimbursementDAO {
    /**
     *
     * @param pr
     * @return
     * @throws DAOException
     */
    public boolean save(PhoneReimbursment pr)throws DAOException;

    /**
     *
     * @return
     * @throws DAOException
     */
    public List<PhoneReimbursment> getAllReimbursementRequest()throws DAOException;

    /**
     * 
     * @return
     * @throws DAOException
     */
    public BigDecimal getLastRequestId()throws DAOException;

    /**
     *
     * @param id BigDecimal
     * @return
     * @throws DAOException
     */
    public PhoneReimbursment getRequestById(BigDecimal id)throws DAOException;
}
