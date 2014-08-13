/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.LeavePerRole;
import com.pojo.LeaveStatusPeremployee;
import java.util.List;

/**
 *
 * @author sujatas
 */
public interface LeavePerRoleDAO {
     public boolean addLeave(LeavePerRole leavePerRole)throws DAOException;

     public boolean assignLeave(LeaveStatusPeremployee leaveStatusPeremployee)throws DAOException;

     public List getLeavePerRole(Integer id)throws DAOException;
     
      public LeaveStatusPeremployee getLeaveStatusFromDB(String empId, Integer leaveId) throws DAOException ;


}
