/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.ComplaintsDAO;
import com.dao.DAOException;
import com.pojo.ComplainDetails;
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
public class ComplaintsDAOImpl extends BaseDAO implements ComplaintsDAO {

    protected static final Log log = LogFactory.getLog(ComplaintsDAO.class);

    public List<ComplainDetails> getAllComplaints() throws DAOException {
        Session session = null;
        List<ComplainDetails> compList = null;
        try {
            session = getSession();
            session.beginTransaction();
            compList = session.createQuery("from ComplainDetails cd ").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the list of complaints " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
            return compList;
        }
    }

    public List<ComplainDetails> getComplaintsbyEmpId(String EmployeeId) throws DAOException {
        Session session = null;
        List<ComplainDetails> compList = null;
        try {
            session = getSession();
            session.beginTransaction();
            compList = session.createQuery("from ComplainDetails cd where cd.employeeid='" + EmployeeId + "'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the list of complaints " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return compList;
    }

    public BigDecimal getLastComplaintId() throws DAOException {
        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(complainid) from ComplainDetails").list();
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

    public boolean saveComplaint(ComplainDetails cd) throws DAOException {
        Session session = null;
        boolean result=false;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(cd);
            session.getTransaction().commit();
            result=true;
        } catch (Exception e) {
            log.error("error in saving the complaint details " + e);
        } finally {
            if(session!=null)
            {
                session.flush();
                session.close();
            }
        }
        return result;
    }
}
