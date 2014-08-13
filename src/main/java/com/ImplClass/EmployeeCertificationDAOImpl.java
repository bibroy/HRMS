/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;

import com.dao.DAOException;
import com.dao.EmployeeCertificationDAO;


import com.pojo.EmployeeCertification;
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
public class EmployeeCertificationDAOImpl extends BaseDAO implements EmployeeCertificationDAO {

    protected static final Log log = LogFactory.getLog(EmployeeCertificationDAO.class);

    public EmployeeCertificationDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<EmployeeCertification> getAllEmployeeCertification() throws DAOException {

        List<EmployeeCertification> employeeCertificationList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Grade");
            employeeCertificationList = session.createQuery("from EmployeeCertification e").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeCertification list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeCertificationList;
    }

    public EmployeeCertification getEmployeeCertification() throws DAOException {

        return new EmployeeCertification();
    }

    public List<EmployeeCertification> getEmployeeCertificationByEmpId(String employeeMasterId) throws DAOException {
        List<EmployeeCertification> employeeCertificationList = null;
        Session session = null;


        try {

            session = getSession();
            session.beginTransaction();
            String HQL = "from EmployeeCertification e where  e.employeeId='" + employeeMasterId + "'    ";
            System.out.print("********HQL*************" + HQL + "***************************");
            log.info("Fetching all Active Job");
            employeeCertificationList = session.createQuery(HQL).list();

            session.getTransaction().commit();
//System.out.print("********employeeCertificationList*************"+employeeCertificationList+"***************************");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeCertification list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeCertificationList;
    }

    public EmployeeCertification getEmployeeCertification(Integer employeeCertificationId) throws DAOException {
        EmployeeCertification employeeCertification = null;
        Session session = null;

        if (employeeCertificationId == null) {
            throw new DAOException("failed to fetch data for \"null\" EmployeeCertification id");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching EmployeeCertification Detail");
            employeeCertification = (EmployeeCertification) session.load(EmployeeCertification.class, employeeCertificationId);
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeCertification data from database", e);
            throw new DAOException("wrong EmployeeCertification code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeCertification data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeCertification;
    }

    public EmployeeCertification getEmployeeCertificationByCode(String employeeCertificationCode) throws DAOException {

        return null;
    }

    public boolean save(EmployeeCertification employeeCertification) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving EmployeeCertification details into database");
            session.saveOrUpdate(employeeCertification);
           
            session.getTransaction().commit();
             session.flush();
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
            log.error("failed to save EmployeeCertification data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }

    public boolean delete(EmployeeCertification employeeCertification) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving EmployeeCertification details into database");
            session.delete(employeeCertification);
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
            log.error("failed to save EmployeeCertification data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }

    public BigDecimal getLastId() throws DAOException {
        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from EmployeeCertification").list();
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
    public List<EmployeeCertification> getEmployeeCertificationName(String certificationName, String empid) throws DAOException
    {
    List<EmployeeCertification> employeeCertificationList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			
			employeeCertificationList = session.createQuery("from EmployeeCertification e where e.certificationName='"+certificationName +"' and e.employeeId='"+empid+"'").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read EmployeeCertification list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return employeeCertificationList;
}





}
