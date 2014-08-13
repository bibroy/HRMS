/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;
/**
 *
 * @author Swarnendu Mukherjee
 */

import com.dao.AppraisalGradeDAO;
import com.dao.BaseDAO;
import com.dao.DAOException;
import com.pojo.AppraisalGrade;
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

    public class AppraisalGradeDAOImpl extends BaseDAO implements AppraisalGradeDAO {

        protected static final Log log = LogFactory.getLog( AppraisalGradeDAO.class );
        public AppraisalGradeDAOImpl() {
	}
        @SuppressWarnings("unchecked")
	public List<AppraisalGrade> getAllAppraisalGrades() throws DAOException {

		List<AppraisalGrade> appraisalGradeList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Categories");
			appraisalGradeList = session.createQuery("from AppraisalGrade a ").list();
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

		return appraisalGradeList;
	}


	public AppraisalGrade getAppraisalGrades() throws DAOException {

		return new AppraisalGrade();
	}


	public AppraisalGrade getAppraisalGrades(String grade_code) throws DAOException {

		try{
			Integer gId = new Integer(grade_code);
			return getAppraisalGrades(gId);

		}catch(NumberFormatException ne){
			log.warn("Category Code is not valid");

		}

		return null;
	}


	public AppraisalGrade getAppraisalGrades(Integer gradeCode) throws DAOException {
		AppraisalGrade appraisalGrade = null;
		Session session = null;

		if(gradeCode==null) {
			throw new DAOException("failed to fetch data for \"null\" Category code");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Company Detail");
			appraisalGrade = (AppraisalGrade)session.load(AppraisalGrade.class,gradeCode);
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

		return appraisalGrade;
	}


	public AppraisalGrade getAppraisalGradesByCode(String gradeCode) throws DAOException {

		return null;
	}


	public boolean save(AppraisalGrade appraisalGrade) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving appraisal Category details into database");
			session.saveOrUpdate(appraisalGrade);
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

public List<AppraisalGrade> getGradeDetails(int grade_code) throws DAOException {

		List<AppraisalGrade> gradeDetails = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Categories");
			gradeDetails = session.createQuery("from AppraisalGrade a where  a.grade_code='"+grade_code+"'").list();
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

		return gradeDetails;
	}


}
