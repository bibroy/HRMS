/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.pojo.Transport;
import com.dao.TransportDAO;
import com.dao.DAOException;
import com.dao.BaseDAO;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

/**
 *
 * @author Sumit Kumar
 */
public class TransportDAOImpl extends BaseDAO implements TransportDAO {

    protected static final Log log = LogFactory.getLog(TransportDAO.class);

    public List<Transport> getAllRequestByEmpId(String Empid) throws DAOException {
        Session session = null;
        List<Transport> trlist = null;
        try {
            session = getSession();
            session.beginTransaction();
            trlist = session.createQuery("from Transport t where t.employeeid='" + Empid + "'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the transport request list " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return trlist;
    }

    public List<Transport> getAllTransportRequest() throws DAOException {
        Session session = null;
        List<Transport> trlist = null;
        try {
            session = getSession();
            session.beginTransaction();
            trlist = session.createQuery("from Transport t where t.requeststatus='W'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the list of transport request " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return trlist;
    }

    public boolean saveTransportRequest(Transport tr) throws DAOException {
        Session session = null;
        boolean result = false;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(tr);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            log.error("error in saving the transport request " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return result;
    }

    public BigDecimal getLastRequestId() throws DAOException {
        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(requestId) from Transport").list();
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

    public Transport getRequestById(BigDecimal id) throws DAOException {
        Session session=null;
        Transport trans=null;
        try {
            session=getSession();
            session.beginTransaction();
            trans=(Transport)session.load(Transport.class, id);
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the transport request "+e);
        }
        return trans;
    }
    
}
