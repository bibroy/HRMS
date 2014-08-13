/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;
import com.dao.BaseDAO;

import com.dao.DAOException;
import com.dao.EmployeeAccountDetailsDAO;


import com.pojo.EmployeeAccountDetails;
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
public class EmployeeAccountDetailsDAOImpl extends BaseDAO implements EmployeeAccountDetailsDAO {




                     protected static final Log log = LogFactory.getLog( EmployeeAccountDetailsDAO.class );
        public EmployeeAccountDetailsDAOImpl() {
	}
        @SuppressWarnings("unchecked")
	public List<EmployeeAccountDetails> getAllEmployeeAccountDetails() throws DAOException {

		List<EmployeeAccountDetails> employeeAccountDetailsList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Grade");
			employeeAccountDetailsList = session.createQuery("from EmployeeAccountDetails e").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read EmployeeAccountDetails list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return employeeAccountDetailsList;
	}



	public EmployeeAccountDetails getEmployeeAccountDetails() throws DAOException {

		return new EmployeeAccountDetails();
	}


	public EmployeeAccountDetails getEmployeeAccountDetailsByEmpId(String employeeMasterId) throws DAOException {
              EmployeeAccountDetails employeeAccountDetails=null;
           Session session = null;


		try{
                     
		    session = getSession();
			session.beginTransaction();
                         String HQL="from EmployeeAccountDetails e where  e.employeeId='"+employeeMasterId+"'    ";
			System.out.print("********HQL*************"+HQL+"***************************");
			log.info("Fetching all Active Job");
			employeeAccountDetails = (EmployeeAccountDetails)session.createQuery(HQL).uniqueResult();

			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read EmployeeAccountDetails list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return employeeAccountDetails;
	}



	public EmployeeAccountDetails getEmployeeAccountDetails(Integer employeeAccountDetailsId) throws DAOException {
		EmployeeAccountDetails employeeAccountDetails = null;
		Session session = null;

		if(employeeAccountDetailsId==null) {
			throw new DAOException("failed to fetch data for \"null\" EmployeeAccountDetails id");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching EmployeeAccountDetails Detail");
			employeeAccountDetails = (EmployeeAccountDetails)session.load(EmployeeAccountDetails.class, employeeAccountDetailsId);
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read EmployeeAccountDetails data from database", e);
			throw new DAOException("wrong EmployeeAccountDetails code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read EmployeeAccountDetails data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return employeeAccountDetails;
	}


	public EmployeeAccountDetails getEmployeeAccountDetailsByCode(String employeeAccountDetailsCode) throws DAOException {

		return null;
	}


	public boolean save(EmployeeAccountDetails employeeAccountDetails) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving EmployeeAccountDetails details into database");
			session.saveOrUpdate(employeeAccountDetails);
			
			session.getTransaction().commit();
			log.info("done");
		}catch(ConstraintViolationException je){
			log.error("failed to save data due to integrity constratint violation");
			session.getTransaction().rollback();
			throw new DAOException("duplicate value", je.getCause());
		}catch(DataException je){
			log.error("failed to save data due to illegal data");
			session.getTransaction().rollback();
			throw new DAOException("invalid data", je.getCause());
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
			log.error("failed to save EmployeeAccountDetails data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null){
                            session.flush();
				session.close();
                        }
		}

		return true;
	}


public BigDecimal getLastRequestId() throws DAOException
    {


     BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last id");
            l = session.createQuery("select max(id) from EmployeeAccountDetails").list();
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
