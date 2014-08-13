/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.VisaRequestDetailsDAO;
import com.pojo.VisaRequestDetails;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/**
 *
 * @author Sumit Kumar
 */
public class VisaRequestDetailsDAOImpl extends BaseDAO implements VisaRequestDetailsDAO {


    protected static final Log log = LogFactory.getLog(VisaRequestDetailsDAO.class);
    
    public List<VisaRequestDetails> getAllRequests() throws DAOException {
        Session session=null;
        List<VisaRequestDetails> vrlist=null;
        try {
            session=getSession();
            session.beginTransaction();
            vrlist=session.createQuery("from VisaRequestDetails v").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching visa request data "+ e.getMessage());
        }
        return vrlist;
    }

    public Integer getLastId() throws DAOException {
        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from VisaRequestDetails").list();
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

    public VisaRequestDetails getRequestById(Integer id) throws DAOException {
        Session session=null;
        List list=null;
        VisaRequestDetails vrd=null;
        try {
            session=getSession();
            session.beginTransaction();
            list=session.createQuery("from VisaRequestDetails v where v.id="+id.toString()).list();
            if(list!=null)
            {
                vrd=(VisaRequestDetails)list.get(0);
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            log.error("error fetching visa request details for id "+ e.getMessage());
        }
        return vrd;
    }

    public boolean save(VisaRequestDetails vrd) throws DAOException {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(vrd);
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

    public List<VisaRequestDetails> getAllRequestByEmpId(String empid) throws DAOException {
        Session session=null;
        List<VisaRequestDetails> visalist=null;
        try {
            session=getSession();
            session.beginTransaction();
            visalist=session.createQuery("from VisaRequestDetails v where v.employeeId='"+empid+"'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the visa request details "+e);
        }
        finally{
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return visalist;
    }
}
