/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.EmployeeInsuranceDAO;
import com.dao.DAOException;
import com.pojo.EmployeeInsurance;
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
public class EmployeeInsuranceDAOImpl extends BaseDAO implements EmployeeInsuranceDAO {

    protected static final Log log = LogFactory.getLog(EmployeeInsuranceDAO.class);

    public List<EmployeeInsurance> getAllInsurance() throws DAOException {
        Session session = null;
        List<EmployeeInsurance> eilist = null;
        try {
            session = getSession();
            session.beginTransaction();
            eilist = session.createQuery("from EmployeeInsurance e").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the employee insurance information" + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return eilist;
    }

    public List<EmployeeInsurance> getAllInsuranceById(String empid) throws DAOException {
        Session session = null;
        List<EmployeeInsurance> eilist = null;
        try {
            session = getSession();
            session.beginTransaction();
            eilist = session.createQuery("from EmployeeInsurance e where e.employeeId='" + empid + "'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the employee insurance information by empid" + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return eilist;
    }

    public boolean save(EmployeeInsurance ei) throws DAOException {
        Session session = null;
        boolean result = false;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(ei);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            log.error("error saving the employee insurance data " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return result;
    }

    public BigDecimal getLastId() throws DAOException {
        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from EmployeeInsurance").list();
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
}
