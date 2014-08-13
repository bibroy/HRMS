/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.ConferenceRoomDAO;
import com.dao.DAOException;
import com.pojo.ConferenceRoomBooking;
import com.pojo.ConferenceRoomMaster;
import java.math.BigDecimal;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.criterion.*;
import org.hibernate.cfg.*;
import org.hibernate.Criteria;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import org.hibernate.Query;

/**
 *
 * @author Sumit Kumar
 */
public class ConferenceRoomDAOImpl extends BaseDAO implements ConferenceRoomDAO {

    protected static final Log log = LogFactory.getLog(ConferenceRoomDAO.class);

    public List<ConferenceRoomBooking> getAllBooking() throws DAOException {
        Session session = null;
        List<ConferenceRoomBooking> crblist = null;
        try {
            session = getSession();
            session.beginTransaction();
            crblist = session.createQuery("from ConferenceRoomBooking cr").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the list of conference room bookings " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return crblist;
    }

    public List<ConferenceRoomBooking> getAllBookingByDate(String dt) throws DAOException {
        Session session = null;
        List<ConferenceRoomBooking> crblist = null;
        try {
            session = getSession();
            session.beginTransaction();
            Query query = session.createQuery("from ConferenceRoomBooking crb where to_date(fromtime,'dd/MM/yyyy')=:datefrom");
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

            query.setTimestamp("datefrom", formatter.parse(dt));
            crblist = (List<ConferenceRoomBooking>) query.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the list of conference room booking " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return crblist;
    }

    public List<ConferenceRoomBooking> getAllBookingInBetweenTime(String starttime, String endtime, String roomno) throws DAOException {
        Session session = null;
        List<ConferenceRoomBooking> crblist = null;
        try {
            session = getSession();
            session.beginTransaction();
            Criteria crit = session.createCriteria(ConferenceRoomBooking.class);
            DateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            Timestamp sttime = new Timestamp(format.parse(starttime).getTime());
            Timestamp edtime = new Timestamp(format.parse(endtime).getTime());
            crit.add(Expression.and(Expression.or(Expression.between("fromtime", sttime, edtime), Expression.between("totime", sttime, edtime)),Expression.eq("roomno", roomno)));
            crblist = crit.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error comparing the value of date and time" + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return crblist;
    }

    public List<ConferenceRoomMaster> getAllConferenceRooms() throws DAOException {
        Session session = null;
        List<ConferenceRoomMaster> crmlist = null;
        try {
            session = getSession();
            session.beginTransaction();
            crmlist = session.createQuery("from ConferenceRoomMaster crm").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the list of conference room master " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return crmlist;
    }

    public BigDecimal getLastRequestId() throws DAOException {
        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(conferenceroombookingcode) from ConferenceRoomBooking").list();
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

    public BigDecimal getLastRoomid() throws DAOException {
        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from ConferenceRoomMaster").list();
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

    public boolean saveBooking(ConferenceRoomBooking crb) throws DAOException {
        Session session = null;
        boolean result = false;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(crb);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            log.error("error in saving the conference room booking record " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return result;
    }

    public boolean saveConferenceRoom(ConferenceRoomMaster crm) throws DAOException {
        Session session = null;
        boolean result = false;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(crm);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            log.error("error saving the conference room master " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return result;
    }

     public List<ConferenceRoomBooking> getAllRequest(String Empid) throws DAOException {
        Session session=null;
        List<ConferenceRoomBooking> list=null;
        try {
            session=getSession();
            session.beginTransaction();
            list=session.createQuery("from ConferenceRoomBooking c where c.employeeid='"+Empid+"'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the conference room booking details "+e);
        }
        finally{
            if(session!=null)
            {
                session.flush();
                session.close();
            }
        }
        return list;
    }

}
