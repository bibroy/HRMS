/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.DAOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.pojo.DailyAttendance;
import com.dao.AttendanceDAO;
import com.dao.BaseDAO;
import org.hibernate.Session;
import java.util.List;
import com.pojo.AppraisalEmpInfo;
import com.pojo.Attendence;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
/**
 *
 * @author Sumit Kumar
 */
public class AttendanceDAOImpl extends BaseDAO implements AttendanceDAO{
        protected static final Log log = LogFactory.getLog(AttendanceDAO.class);

    public List<DailyAttendance> getAllAttendance() throws DAOException {
        Session session=null;
        List<DailyAttendance> list=null;
        try {
            session=getSession();
            session.beginTransaction();
            list=session.createQuery("from DailyAttendance d").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching attendance data "+e);
        }
        return list;
    }

    public List<DailyAttendance> getAttendanceById(String id) throws DAOException {
        Session session=null;
        List<DailyAttendance> list=null;
        try {
            session=getSession();
            session.beginTransaction();
            list=session.createQuery("from DailyAttendance d where d.userid='"+id+"'").list();

            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fething attendance data "+ e);
        }
        return list;
    }
    
     public AppraisalEmpInfo getAppraisalInfo(String id)throws DAOException{
         Session session=null;
        AppraisalEmpInfo aei=null;
         try {
           aei=(AppraisalEmpInfo)session.createQuery("from AppraisalEmpInfo a where a.employee_id='"+id+"'").uniqueResult();

        } catch (Exception e) {
            log.warn(" emp info retrieved");
            throw new DAOException("skill not retrived.");
        }
        return aei;
    }
        public List<Attendence> getAttendance(String id,int mon)throws DAOException{
         Session session=null;
        List<Attendence> list=null;
        Date today=new Date();
        Calendar c=new GregorianCalendar();
        c.setTime(today);
        c.add(Calendar.MONTH, -(mon));
        Date d=c.getTime();
        try {
           session=getSession();
           session.beginTransaction();
            Criteria crit=session.createCriteria(Attendence.class);
            crit.add(Expression.and(Expression.ge("attendanceDate", d),Expression.eq("empCode", id)));

           list=crit.list();
           session.getTransaction().commit();

        } catch (Exception e) {
            log.warn(" emp info retrieved");
            throw new DAOException("skill not retrived.");
        }
        finally{
            if(session!=null){
                session.flush();
                session.close();
            }
        }
        return list;
    }
         
     }



