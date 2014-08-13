/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.LeaveDetails;
import java.math.BigDecimal;

import java.util.List;

/**
 *
 * @author sujatas
 */
public interface LeaveDetailsDAO {
     public boolean addLeave(LeaveDetails leaveDetails)throws DAOException;

     public LeaveDetails getLeaveDetails(Integer leaveid) throws DAOException;
     public LeaveDetails getLeaveDetails(String id) throws DAOException;

     public List getAllLeaves(String confirmationStatus,Integer designationId)throws DAOException;
      public List<LeaveDetails> getAllLeaves()throws DAOException;

}
