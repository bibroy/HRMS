/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.TimesheetMaster;
import com.pojo.TimeSheetMapping;
import com.pojo.TimesheetHeader;
import com.pojo.TimesheetDetail;
import com.util.TimesheetMasterUtil;
import com.util.WorkingTimeReportOFEmployees;
import com.pojo.Task;
import java.util.List;
import java.math.BigDecimal;
import com.pojo.TimeSlot;
import com.pojo.EmployeeMaster;

/**
 *
 * @author Sumit Kumar
 */
public interface TimeSheetDAO {

    public TimesheetMaster getTimeSheetById(Integer id) throws DAOException;

    public boolean save(TimesheetMaster tm) throws DAOException;

    public boolean saveHeader(TimesheetHeader th) throws DAOException;

    public Integer getLastId() throws DAOException;

    public List<TimesheetMaster> getAllTimeSheet() throws DAOException;

    public List<TimesheetMaster> getTaskByEmpId(String empId) throws DAOException;

    public Integer getIdByTaskId(String taskid) throws DAOException;

    public List<TimesheetMasterUtil> getActiveTimesheet() throws DAOException;

    public BigDecimal getLastIdForTimeSheetHeader() throws DAOException;

    public List<TimeSlot> getTimeSlot() throws DAOException;

    public TimeSheetMapping getTimeSheetMapping(String empId) throws DAOException;

    public boolean saveTimesheetDeail(TimesheetDetail tsd) throws DAOException;

    public BigDecimal getLastIdForTimeSheetDetail() throws DAOException;

    public List<EmployeeMaster> getAllEmployeeBySupervisorid(String supid) throws DAOException;

    public List<TimesheetDetail> getTimesheetDetailById(String employeeId) throws DAOException;

    public List<TimesheetDetail> getTimesheetDetailByIdAndDate(String employeeId, String timesheetDate) throws DAOException;

    public TimesheetDetail getTimeSheet(Integer id) throws DAOException;

    public List<TimesheetDetail> getTimesheetByStatus(String status, String employeeId) throws DAOException;

    public List<WorkingTimeReportOFEmployees> getWorkingTimeReport(String date) throws DAOException;

    public List<TimesheetHeader> getTimesheetheader() throws DAOException;

    public TimesheetHeader getTimesheetheader(Integer headerid) throws DAOException;

    public boolean saveTimesheetmapping(TimeSheetMapping tm) throws DAOException;
}
