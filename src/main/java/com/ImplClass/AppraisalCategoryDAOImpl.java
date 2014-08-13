/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;
/**
 *
 * @author Swarnendu Mukherjee
 */

import com.dao.AppraisalCategoryDAO;
import com.dao.BaseDAO;
import com.dao.DAOException;
import com.pojo.AppraisalCategory;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;
/**
 *
 * @author Swarnendu Mukherjee
 */

    public class AppraisalCategoryDAOImpl extends BaseDAO implements AppraisalCategoryDAO {

        protected static final Log log = LogFactory.getLog( AppraisalCategoryDAO.class );
        public AppraisalCategoryDAOImpl() {
	}
        @SuppressWarnings("unchecked")
	public List<AppraisalCategory> getAllAppraisalCategories() throws DAOException {

		List<AppraisalCategory> appraisalCategoryList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Categories");
			appraisalCategoryList = session.createQuery("select a from AppraisalCategory a where a.status='Y'").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Appraisal Category list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return appraisalCategoryList;
	}


	public AppraisalCategory getAppraisalCategories() throws DAOException {

		return new AppraisalCategory();
	}


	public AppraisalCategory getAppraisalCategories(String category_code) throws DAOException {

		try{
			Integer aId = new Integer(category_code);
			return getAppraisalCategories(aId);

		}catch(NumberFormatException ne){
			log.warn("Category Code is not valid");

		}

		return null;
	}


	public AppraisalCategory getAppraisalCategories(Integer categoryCode) throws DAOException {
		AppraisalCategory appraisalCategory = null;
		Session session = null;

		if(categoryCode==null) {
			throw new DAOException("failed to fetch data for \"null\" Category code");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Company Detail");
			appraisalCategory = (AppraisalCategory)session.load(AppraisalCategory.class,categoryCode);
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read Appraisal Category data from database", e);
			throw new DAOException("wrong Category code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Appraisal data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return appraisalCategory;
	}


	public AppraisalCategory getAppraisalCategoriesByCode(String categoryCode) throws DAOException {

		return null;
	}


	public boolean save(AppraisalCategory appraisalCategory) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving appraisal Category details into database");
			session.saveOrUpdate(appraisalCategory);
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
			log.error("failed to save company data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}

public List<AppraisalCategory> getCategoryDetails(int category_code) throws DAOException {

		List<AppraisalCategory> categoryDetails = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Categories");
			categoryDetails = session.createQuery("from AppraisalCategory a where a.status='Y' and category_code='"+category_code+"'").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Appraisal Category list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return categoryDetails;
	}

   
}
