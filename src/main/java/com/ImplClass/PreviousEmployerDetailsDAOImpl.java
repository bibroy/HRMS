

package com.ImplClass;
import com.dao.BaseDAO;

import com.dao.DAOException;
import com.dao.PreviousEmployerDetailsDAO;


import com.pojo.PreviousEmployerDetails;

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
public class PreviousEmployerDetailsDAOImpl extends BaseDAO implements PreviousEmployerDetailsDAO {




                     protected static final Log log = LogFactory.getLog( PreviousEmployerDetailsDAO.class );
        public PreviousEmployerDetailsDAOImpl() {
	}
        @SuppressWarnings("unchecked")
	public List<PreviousEmployerDetails> getAllPreviousEmployerDetails() throws DAOException {

		List<PreviousEmployerDetails> previousEmployerDetailsList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Grade");
			previousEmployerDetailsList = session.createQuery("from PreviousEmployerDetails v").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read PreviousEmployerDetails list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return previousEmployerDetailsList;
	}



	public PreviousEmployerDetails getPreviousEmployerDetails() throws DAOException {

		return new PreviousEmployerDetails();
	}


	public List<PreviousEmployerDetails> getPreviousEmployerDetailsByEmpId(String employeeMasterId) throws DAOException {
              List<PreviousEmployerDetails> previousEmployerDetailsList=null;
           Session session = null;


		try{

		    session = getSession();
			session.beginTransaction();
                         String HQL="from PreviousEmployerDetails e where  e.employeeId='"+employeeMasterId+"'    ";
			System.out.print("********HQL*************"+HQL+"***************************");
			log.info("Fetching all Active Job");
			previousEmployerDetailsList = session.createQuery(HQL).list();

			session.getTransaction().commit();
//System.out.print("********previousEmployerDetailsList*************"+previousEmployerDetailsList+"***************************");
		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read PreviousEmployerDetails list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return previousEmployerDetailsList;
	}




	public PreviousEmployerDetails getPreviousEmployerDetails(Integer previousEmployerDetailsId) throws DAOException {
		PreviousEmployerDetails previousEmployerDetails = null;
		Session session = null;

		if(previousEmployerDetailsId==null) {
			throw new DAOException("failed to fetch data for \"null\" PreviousEmployerDetails id");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching PreviousEmployerDetails Detail");
			previousEmployerDetails = (PreviousEmployerDetails)session.load(PreviousEmployerDetails.class, previousEmployerDetailsId);
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read PreviousEmployerDetails data from database", e);
			throw new DAOException("wrong PreviousEmployerDetails code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read PreviousEmployerDetails data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return previousEmployerDetails;
	}


	public PreviousEmployerDetails getPreviousEmployerDetailsByCode(String previousEmployerDetailsCode) throws DAOException {

		return null;
	}


	public boolean save(PreviousEmployerDetails previousEmployerDetails) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving PreviousEmployerDetails details into database");
			System.out.print("*-*-**-*-*-*-*-*-insert Employee Conformation-----------------");
                        session.saveOrUpdate(previousEmployerDetails);
                        System.out.print("*-*-**-*-*-*-*-*-insert end Employee Conformation-----------------");
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
			log.error("failed to save PreviousEmployerDetails data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}



public boolean delete(PreviousEmployerDetails previousEmployerDetails) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving PreviousEmployerDetails details into database");
			session.delete(previousEmployerDetails);
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
			log.error("failed to save PreviousEmployerDetails data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}





}
