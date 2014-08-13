/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;
import com.dao.BaseDAO;

import com.dao.DAOException;
import com.dao.EmployeeEducationDetailsDAO;


import com.pojo.EmployeeEducationDetails;

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
public class EmployeeEducationDetailsDAOImpl extends BaseDAO implements EmployeeEducationDetailsDAO {




                     protected static final Log log = LogFactory.getLog( EmployeeEducationDetailsDAO.class );
        public EmployeeEducationDetailsDAOImpl() {
	}
        @SuppressWarnings("unchecked")
	public List<EmployeeEducationDetails> getAllEmployeeEducationDetails() throws DAOException {

		List<EmployeeEducationDetails> employeeEducationDetailsList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Grade");
			employeeEducationDetailsList = session.createQuery("from EmployeeEducationDetails e").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read EmployeeEducationDetails list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return employeeEducationDetailsList;
	}



	public EmployeeEducationDetails getEmployeeEducationDetails() throws DAOException {

		return new EmployeeEducationDetails();
	}


	public List<EmployeeEducationDetails> getEmployeeEducationDetailsByEmpId(String employeeMasterId) throws DAOException {
              List<EmployeeEducationDetails> employeeEducationDetailsList=null;
           Session session = null;


		try{

		    session = getSession();
			session.beginTransaction();
                         String HQL="from EmployeeEducationDetails e where  e.employeeId='"+employeeMasterId+"'    ";
			System.out.print("********HQL*************"+HQL+"***************************");
			log.info("Fetching all Active Job");
			employeeEducationDetailsList = session.createQuery(HQL).list();

			session.getTransaction().commit();
//System.out.print("********employeeEducationDetailsList*************"+employeeEducationDetailsList+"***************************");
		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read EmployeeEducationDetails list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return employeeEducationDetailsList;
	}



	public EmployeeEducationDetails getEmployeeEducationDetails(Integer employeeEducationDetailsId) throws DAOException {
		EmployeeEducationDetails employeeEducationDetails = null;
		Session session = null;

		if(employeeEducationDetailsId==null) {
			throw new DAOException("failed to fetch data for \"null\" EmployeeEducationDetails id");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching EmployeeEducationDetails Detail");
			employeeEducationDetails = (EmployeeEducationDetails)session.load(EmployeeEducationDetails.class, employeeEducationDetailsId);
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read EmployeeEducationDetails data from database", e);
			throw new DAOException("wrong EmployeeEducationDetails code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read EmployeeEducationDetails data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return employeeEducationDetails;
	}


	public EmployeeEducationDetails getEmployeeEducationDetailsByCode(String employeeEducationDetailsCode) throws DAOException {

		return null;
	}


	public boolean save(EmployeeEducationDetails employeeEducationDetails) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving EmployeeEducationDetails details into database");
			session.saveOrUpdate(employeeEducationDetails);
			session.flush();
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
			log.error("failed to save EmployeeEducationDetails data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}


public boolean delete(EmployeeEducationDetails employeeEducationDetails) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving EmployeeEducationDetails details into database");
			session.delete(employeeEducationDetails);
			session.flush();
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
			log.error("failed to save EmployeeEducationDetails data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}





}
