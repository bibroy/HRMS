/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;
import com.pojo.AssessmentEvent;
import java.math.BigDecimal;

import java.util.List;


/**
 *
 * @author computer1
 */
public interface AssessmentEventDAO {
     public boolean save( AssessmentEvent ae)throws DAOException;
     public Integer getLastRequestId() throws DAOException;

}
