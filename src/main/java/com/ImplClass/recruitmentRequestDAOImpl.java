/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.recruitmentRequestDAO;
import com.dao.DAOException;
import com.pojo.recruitmentRequestpojo;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author computer1
 */
public class recruitmentRequestDAOImpl extends BaseDAO implements recruitmentRequestDAO {

    protected static final Log log = LogFactory.getLog(recruitmentRequestDAO.class);

    public recruitmentRequestDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<recruitmentRequestpojo> getAllrecruitmentRequest() throws DAOException {

        List<recruitmentRequestpojo> recruitmentRequestList = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all recruitmentRequest");
            recruitmentRequestList = session.createQuery("from recruitmentRequestpojo rrp").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read recruitmentrequest list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return recruitmentRequestList;
    }

    public recruitmentRequestpojo getrecruitmentRequestpojo() throws DAOException {
        return new recruitmentRequestpojo();
    }

    public recruitmentRequestpojo getrecruitmentRequestpojo(String quali) throws DAOException {

        try {
            String q = new String(quali);
            return getrecruitmentRequestpojo(q);

        } catch (Exception e) {
            log.warn(" qualification  not retrived");
            throw new DAOException("qualification not retrived.");
        }
    }

    public recruitmentRequestpojo getrecruitmentbyskill(String skillreq) throws DAOException {
        try {
            String s = new String(skillreq);
            return getrecruitmentRequestpojo(s);

        } catch (Exception e) {
            log.warn(" skill  not retrived");
            throw new DAOException("skill not retrived.");
        }
    }

    public recruitmentRequestpojo getrecruitmentbyexp(String exp) throws DAOException {
        try {
            String e = new String(exp);
            return getrecruitmentRequestpojo(e);

        } catch (Exception e) {
            log.warn(" experience is  not retrived");
            throw new DAOException("skill not retrived.");
        }
    }

    public recruitmentRequestpojo getrecruitmentbypost(String post) throws DAOException {
        try {
            String p = new String(post);
            return getrecruitmentRequestpojo(p);

        } catch (Exception e) {
            log.warn(" post is  not retrived");
            throw new DAOException("post not retrived.");
        }
    }

    public boolean save(recruitmentRequestpojo rrp) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving company details into database");
            session.saveOrUpdate(rrp);
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
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save company data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }

    public Integer getLastRequestId() throws DAOException {

        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from recruitmentRequestpojo").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
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
}
