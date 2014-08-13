/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;

import com.dao.DAOException;
import com.dao.EmployeeFamilyDetailsDAO;


import com.pojo.EmployeeFamilyDetails;
import com.pojo.EmployeeFamilyDetailspojo;
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
public class EmployeeFamilyDetailsDAOImpl extends BaseDAO implements EmployeeFamilyDetailsDAO {

    protected static final Log log = LogFactory.getLog(EmployeeFamilyDetailsDAO.class);

    public EmployeeFamilyDetailsDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<EmployeeFamilyDetails> getAllEmployeeFamilyDetails() throws DAOException {

        List<EmployeeFamilyDetails> employeeFamilyDetailsList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Grade");
            employeeFamilyDetailsList = session.createQuery("from EmployeeFamilyDetails e").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeFamilyDetails list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeFamilyDetailsList;
    }

    public EmployeeFamilyDetails getEmployeeFamilyDetails() throws DAOException {

        return new EmployeeFamilyDetails();
    }

    public List<EmployeeFamilyDetails> getEmployeeFamilyDetailsByEmpId(String employeeMasterId) throws DAOException {
        List<EmployeeFamilyDetails> employeeFamilyDetailsList = null;
        Session session = null;


        try {

            session = getSession();
            session.beginTransaction();
            String HQL = "from EmployeeFamilyDetails e where  e.employeeId='" + employeeMasterId + "'    ";
            System.out.print("********HQL*************" + HQL + "***************************");
            log.info("Fetching all Active Job");
            employeeFamilyDetailsList = session.createQuery(HQL).list();

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeFamilyDetails list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeFamilyDetailsList;
    }

    public EmployeeFamilyDetails getEmployeeFamilyDetails(Integer employeeFamilyDetailsId) throws DAOException {
        EmployeeFamilyDetails employeeFamilyDetails = null;
        Session session = null;
        BigDecimal efid = new BigDecimal(employeeFamilyDetailsId.intValue());

        if (employeeFamilyDetailsId == null) {
            throw new DAOException("failed to fetch data for \"null\" EmployeeFamilyDetails id");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching EmployeeFamilyDetails Detail");
            employeeFamilyDetails = (EmployeeFamilyDetails) session.load(EmployeeFamilyDetails.class, efid);
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeFamilyDetails data from database", e);
            throw new DAOException("wrong EmployeeFamilyDetails code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeFamilyDetails data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeFamilyDetails;
    }

    public EmployeeFamilyDetails getEmployeeFamilyDetailsByCode(String employeeFamilyDetailsCode) throws DAOException {

        return null;
    }

    public boolean save(EmployeeFamilyDetails employeeFamilyDetails) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving EmployeeFamilyDetails details into database");
            session.saveOrUpdate(employeeFamilyDetails);
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
            log.error("failed to save EmployeeFamilyDetails data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }

    public boolean delete(EmployeeFamilyDetails employeeFamilyDetails) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving EmployeeFamilyDetails details into database");
            session.delete(employeeFamilyDetails);
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
            log.error("failed to save EmployeeFamilyDetails data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }

    public boolean save(EmployeeFamilyDetailspojo obj) throws DAOException {
        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            log.info("saving family details details into database");
            session.saveOrUpdate(obj);
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

    public BigDecimal getLastRequestId() throws DAOException {
        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from EmployeeFamilyDetailspojo").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                BigDecimal b = (BigDecimal) iter.next();
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
}
