/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.PassengerDetails;
import java.math.BigDecimal;

/**
 *
 * @author sujatas
 */
public interface PassengersDetailsDAO {

     public boolean savePassengerDetails(PassengerDetails passengersDetails)throws DAOException;
     public BigDecimal getLastRequestId() throws DAOException ;

     
}
