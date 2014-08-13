/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.Transport;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Sumit Kumar
 */
public interface TransportDAO {

    public boolean saveTransportRequest(Transport tr)throws DAOException;
    public List<Transport> getAllTransportRequest()throws DAOException;
    public List<Transport> getAllRequestByEmpId(String Empid)throws DAOException;
    public BigDecimal getLastRequestId() throws DAOException;
     public Transport getRequestById(BigDecimal id) throws DAOException;
}
