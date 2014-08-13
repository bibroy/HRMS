/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.TimeSheetDAO;
import com.pojo.TimesheetMaster;
import com.pojo.TimesheetHeader;
import com.util.TimesheetMasterUtil;
import com.pojo.TimeSlot;
import com.pojo.TimeSheetMapping;
import com.pojo.TimesheetDetail;
import java.math.BigDecimal;
import com.pojo.EmployeeMaster;
import com.util.WorkingTimeReportOFEmployees;
import java.text.DateFormat;
import java.text.SimpleDateFormat;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Query;
import org.hibernate.criterion.Expression;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/**
 *
 * @author Sumit Kumar
 */
public class TimeSheetDAOImpl extends BaseDAO implements TimeSheetDAO {

    protected static final Log log = LogFactory.getLog(TimeSheetDAO.class);

    public List<TimesheetMaster> getAllTimeSheet() throws DAOException {
        Session session = null;
        List<TimesheetMaster> list = null;
        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("from TimesheetMaster t").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            log.error("error fetching data from Timesheet master " + e.getMessage());
        }
        return list;
    }

    public Integer getLastId() throws DAOException {
        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from TimesheetMaster").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
                if (b != null) {
                    i = b;
                }
            }
        } catch (NullPointerException npe) {
            //session.getTransaction().rollback();
            log.error("null value");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read Leave Request Id from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return i;
    }

    public BigDecimal getLastIdForTimeSheetHeader() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last Headerid");
            l = session.createQuery("select max(headerid) from TimesheetHeader").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                BigDecimal b = (BigDecimal) iter.next();
                if (b != null) {
                    i = b;
                }
                //Object[] row = (Object[]) iter.next();
                /*
                if(row[0]!=null)
                {
                BigDecimal b=(BigDecimal)row[0];
                i = b;
                }
                 *
                 */

            }
        } catch (NullPointerException npe) {
            //session.getTransaction().rollback();
            log.error("null value");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read timesheet detail id from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return i;
    }

    public BigDecimal getLastIdForTimeSheetDetail() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last Timesheet detail id");
            l = session.createQuery("select max(timesheetdetailid) from TimesheetDetail").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                BigDecimal b = (BigDecimal) iter.next();
                if (b != null) {
                    i = b;
                }
                //Object[] row = (Object[]) iter.next();
                /*
                if(row[0]!=null)
                {
                BigDecimal b=(BigDecimal)row[0];
                i = b;
                }
                 *
                 */

            }
        } catch (NullPointerException npe) {
            //session.getTransaction().rollback();
            log.error("null value");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read time sheet detail id from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return i;
    }

    public TimesheetMaster getTimeSheetById(Integer id) throws DAOException {
        Session session = null;
        List list = null;
        TimesheetMaster tm = null;
        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("from TimesheetMaster t where id=" + id.toString()).list();
            if (list != null) {
                tm = (TimesheetMaster) list.get(0);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching time sheet master " + e.getMessage());
        }
        return tm;
    }

    public TimesheetDetail getTimeSheet(Integer id) throws DAOException {
        Session session = null;
        TimesheetDetail tsd = null;
        BigDecimal tsdid = new BigDecimal(id);
        try {
            session = getSession();
            session.beginTransaction();
            tsd = (TimesheetDetail) session.load(TimesheetDetail.class, tsdid);
            session.getTransaction().commit();
        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read TimesheetDetail from database", e);
            throw new DAOException("wrong EmployeeMaster code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read timesheetDetail data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return tsd;
    }

    public boolean save(TimesheetMaster tm) throws DAOException {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(tm);
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to save data due to integrity constratint violation");
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {

            session.getTransaction().rollback();
            log.error("failed to save timesheet master data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    public boolean saveHeader(TimesheetHeader th) throws DAOException {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(th);
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to save data due to integrity constratint violation");
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {

            session.getTransaction().rollback();
            log.error("failed to save timesheet master data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    public List<TimesheetMaster> getTaskByEmpId(String empId) throws DAOException {
        Session session = null;
        List<TimesheetMaster> tsklist = null;
        try {
            session = getSession();
            session.beginTransaction();
            tsklist = session.createQuery("from TimesheetMaster t where t.assignedTo='" + empId + "' and (t.workStatus='assigned' or t.workStatus='started' or t.workStatus='suspended')").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching employees timesheet master " + e.getMessage());
        }
        return tsklist;
    }

    public Integer getIdByTaskId(String taskid) throws DAOException {
        Session session = null;
        List list = null;
        Integer id = 0;
        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("select t.id from TimesheetMaster t where t.task=" + taskid).list();
            if (list != null) {
                id = (Integer) list.get(0);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the id " + e.getMessage());
        }
        return id;
    }

    public List<TimesheetMasterUtil> getActiveTimesheet() throws DAOException {
        Session session = null;
        List<TimesheetMasterUtil> tmlist = new ArrayList<TimesheetMasterUtil>();
        List list = null;
        BaseDAO b = new BaseDAO();
        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("select tm.id,tm.projectId,tm.startTime,tm.endTime,t.taskName,tm.remarks,tm.workStatus,e.firstName from TimesheetMaster tm, Task t, EmployeeMaster e where tm.task=t.taskId and tm.assignedTo=e.employeeId and t.status='active'").list();
            if (!list.isEmpty()) {
                for (Iterator iter = list.iterator(); iter.hasNext();) {
                    Object[] data = (Object[]) iter.next();

                    TimesheetMasterUtil tm = new TimesheetMasterUtil();
                    tm.setId(Integer.parseInt(data[0].toString()));
                    tm.setProjectId(data[1].toString());
                    tm.setStartTime(data[2].toString());
                    if (data[3] != null) {
                        tm.setEndTime(data[3].toString());
                    } else {
                        tm.setEndTime("not completed");
                    }
                    tm.setTaskName(data[4].toString());
                    tm.setRemarks(data[5].toString());
                    tm.setWorkStatus(data[6].toString());
                    tm.setAssignedTo(data[7].toString());
                    tmlist.add(tm);
                }
            }
        } catch (Exception e) {
            log.error("error fetching timesheet report " + e.getMessage());
        }
        return tmlist;
    }

    public List<com.pojo.TimeSlot> getTimeSlot() throws DAOException {
        Session session = null;
        List<TimeSlot> list = null;
        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("from TimeSlot t order by t.slotid").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            log.error("error fetching data from TimeSlot " + e.getMessage());
        }
        return list;


    }

    public TimeSheetMapping getTimeSheetMapping(String empid) throws DAOException {
        TimeSheetMapping tsmapping = null;
        Session session = null;
        String b = empid;
        if (empid == null) {
            throw new DAOException("failed to fetch data for \"null\" empid");
        }
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching timesheet header Detail");
            tsmapping = (TimeSheetMapping) session.load(TimeSheetMapping.class, b);
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Timesheetmapping data from database", e);
            throw new DAOException("wrong department code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Timesheet mapping from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return tsmapping;
    }

    public boolean saveTimesheetDeail(TimesheetDetail tsd) throws DAOException {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(tsd);
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to save data due to integrity constratint violation");
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {

            session.getTransaction().rollback();
            log.error("failed to save timesheet master data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

    public List<EmployeeMaster> getAllEmployeeBySupervisorid(String supid) throws DAOException {
        List<EmployeeMaster> empmaster = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            empmaster = session.createQuery("from EmployeeMaster e where supervisorId='" + supid + "'").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            log.warn("error fetching employeemaster list" + e.getMessage());
            session.getTransaction().rollback();
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return empmaster;
    }

    public List<TimesheetDetail> getTimesheetDetailById(String employeeId) throws DAOException {
        List<TimesheetDetail> detailList = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            detailList = session.createQuery("from TimesheetDetail td where empid='" + employeeId + "'").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            log.warn("error fetching detail list" + e.getMessage());
            session.getTransaction().rollback();
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return detailList;
    }

    public List<TimesheetDetail> getTimesheetDetailByIdAndDate(String employeeId, String timesheetDate) throws DAOException {
        List<TimesheetDetail> detailList = null;
        Session session = null;
        try {
            DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            Date d = df.parse(timesheetDate);
            session = getSession();
            session.beginTransaction();
            Criteria crit = session.createCriteria(TimesheetDetail.class);
            crit.add(Expression.and(Expression.eq("empid", employeeId), Expression.eq("timesheetdate", d)));
            detailList = crit.list();
            session.getTransaction().commit();

        } catch (Exception e) {
            log.warn("error fetching detail list" + e.getMessage());
            session.getTransaction().rollback();
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return detailList;
    }

    public List<TimesheetDetail> getTimesheetByStatus(String status, String employeeId) throws DAOException {
        List<TimesheetDetail> tsdList = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            Criteria crit = session.createCriteria(TimesheetDetail.class);
            crit.add(Expression.and(Expression.eq("approvestatus", status), Expression.eq("empid", employeeId)));
            tsdList = crit.list();
            session.getTransaction().commit();

        } catch (Exception e) {
            log.warn("error fetching Timesheetdetail list" + e.getMessage());
            session.getTransaction().rollback();
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return tsdList;
    }

    public List<WorkingTimeReportOFEmployees> getWorkingTimeReport(String date) throws DAOException {
        List list = null;
        List<WorkingTimeReportOFEmployees> lst = new ArrayList<WorkingTimeReportOFEmployees>();
        Session session = null;
        Calendar c = new GregorianCalendar();
        String[] dt = date.split("/");
        c.set(Integer.parseInt(dt[2]), Integer.parseInt(dt[1]), Integer.parseInt(dt[0]));
        Date d = mySqlDatebFormat(date);
        try {

            session = getSession();
            session.beginTransaction();
            String query = "Select count(*) ,t.empid,t.projectid,t.timesheetdate from TimesheetDetail t where t.timesheetdate=:tdate and t.approvestatus='approved' group by t.empid,t.projectid,t.timesheetdate";
            Query q = session.createQuery(query).setParameter("tdate", d);
            System.out.println(q.getQueryString());
            list = q.list();
            BaseDAO b = new BaseDAO();
            if (list != null) {

                for (Iterator iter = list.iterator(); iter.hasNext();) {
                    Object[] data = (Object[]) iter.next();

                    WorkingTimeReportOFEmployees obj = new WorkingTimeReportOFEmployees();

                    obj.setWorkingHour(Integer.parseInt(data[0].toString()));
                    obj.setEmployeeId(data[1].toString());
                    obj.setProjectid(new BigDecimal(data[2].toString()));
                    obj.setTimesheetdate(b.mySqlDatebFormat(data[3].toString()));
                    lst.add(obj);

                }
                session.getTransaction().commit();
                log.info("Commited successfully");


            }

        } catch (Exception e) {

            log.error("An exception occur" + e);


        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return lst;

    }

    public List<TimesheetHeader> getTimesheetheader() throws DAOException {
        Session session = null;
        List<TimesheetHeader> list = null;
        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("from TimesheetHeader t").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            log.error("error fetching data from Timesheet master " + e.getMessage());
        }
        return list;

    }

    public TimesheetHeader getTimesheetheader(Integer headerid) throws DAOException {
        Session session = null;
        TimesheetHeader tsh = null;
        try {
            session = getSession();
            session.beginTransaction();
            tsh = (TimesheetHeader) session.createQuery("from TimesheetHeader t where headerid='" + headerid + "'").uniqueResult();
            session.getTransaction().commit();

        } catch (Exception e) {
            log.warn("error fetching detail list" + e.getMessage());
            session.getTransaction().rollback();
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return tsh;
    }

    public boolean saveTimesheetmapping(TimeSheetMapping tm) throws DAOException {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(tm);
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to save data due to integrity constratint violation");
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {

            session.getTransaction().rollback();
            log.error("failed to save timesheet master data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

}
