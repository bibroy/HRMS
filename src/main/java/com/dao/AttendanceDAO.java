/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.DailyAttendance;
import java.util.List;
import com.pojo.AppraisalEmpInfo;
import com.pojo.Attendence;
/**
 *
 * @author Sumit Kumar
 */
public interface AttendanceDAO {
    public List<DailyAttendance> getAllAttendance() throws DAOException;

    public List<DailyAttendance> getAttendanceById(String id)throws DAOException;

    public AppraisalEmpInfo getAppraisalInfo(String id)throws DAOException;

     public List<Attendence> getAttendance(String id,int mon)throws DAOException;

}
