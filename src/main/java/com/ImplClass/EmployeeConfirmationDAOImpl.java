/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;

import com.dao.DAOException;
import com.dao.EmployeeConfirmationDAO;


import com.pojo.EmployeeConfirmation;
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
 * @author sudipb
 */
public class EmployeeConfirmationDAOImpl extends BaseDAO implements EmployeeConfirmationDAO {

    protected static final Log log = LogFactory.getLog(EmployeeConfirmationDAO.class);

    public EmployeeConfirmationDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<EmployeeConfirmation> getAllEmployeeConfirmation() throws DAOException {

        List<EmployeeConfirmation> employeeConfirmationList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Grade");
            employeeConfirmationList = session.createQuery("from EmployeeConfirmation e").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeConfirmation list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeConfirmationList;
    }

    public BigDecimal getLastRequestId() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from EmployeeConfirmation").list();
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

    
    public EmployeeConfirmation getEmployeeConfirmation() throws DAOException {

        return new EmployeeConfirmation();
    }

    public EmployeeConfirmation getEmployeeConfirmationByEmpId(String employeeMasterId) throws DAOException {
        EmployeeConfirmation employeeConfirmation = null;
        Session session = null;


        try {

            session = getSession();
            session.beginTransaction();
            String HQL = "from EmployeeConfirmation e where e.employeeId='" + employeeMasterId + "'    ";
            System.out.print("********HQL*************" + HQL + "***************************");
            log.info("Fetching all Active Job");
            employeeConfirmation = (EmployeeConfirmation) session.createQuery(HQL).uniqueResult();

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeConfirmation list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeConfirmation;
    }

    public EmployeeConfirmation getEmployeeConfirmation(Integer employeeConfirmationId) throws DAOException {
        EmployeeConfirmation employeeConfirmation = null;
        Session session = null;

        if (employeeConfirmationId == null) {
            throw new DAOException("failed to fetch data for \"null\" EmployeeConfirmation id");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching EmployeeConfirmation Detail");
            employeeConfirmation = (EmployeeConfirmation) session.load(EmployeeConfirmation.class, employeeConfirmationId);
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeConfirmation data from database", e);
            throw new DAOException("wrong EmployeeConfirmation code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeConfirmation data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeConfirmation;
    }

    public EmployeeConfirmation getEmployeeConfirmationByCode(String employeeConfirmationCode) throws DAOException {

        return null;
    }

    public boolean save(EmployeeConfirmation employeeConfirmation) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving EmployeeConfirmation details into database");
            System.out.print("*-*-**-*-*-*-*-*-insert Employee Conformation-----------------");
            session.saveOrUpdate(employeeConfirmation);
            System.out.print("*-*-**-*-*-*-*-*-insert end Employee Conformation-----------------");
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
            log.error("failed to save EmployeeConfirmation data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }
}
