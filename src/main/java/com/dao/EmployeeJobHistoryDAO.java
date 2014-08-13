/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;
import com.pojo.EmployeeJobHistory;
import com.dao.DAOException;
import java.math.BigDecimal;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 *
 * @author pradipto roy
 * created on 27/1/2011
 */
public interface EmployeeJobHistoryDAO {

    public boolean save(EmployeeJobHistory empobj)throws DAOException;
    public BigDecimal getLastRequestId() throws DAOException;
    public List<EmployeeJobHistory>getEmployeesByRunaway(String Runaway);



}
