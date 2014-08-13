/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.AppraisalEmpInfoDAO;
import com.dao.BaseDAO;
import com.dao.DAOException;
import com.pojo.AppraisalEmpInfo;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

/**
 *
 * @author Swarnendu Mukherjee
 */

    public class AppraisalEmpInfoDAOImpl extends BaseDAO implements AppraisalEmpInfoDAO {

        protected static final Log log = LogFactory.getLog( AppraisalEmpInfoDAO.class );
        public AppraisalEmpInfoDAOImpl() {
	}
        @SuppressWarnings("unchecked")
	public List<AppraisalEmpInfo> getAllAppraisalEmpInfo() throws DAOException {

		List<AppraisalEmpInfo> appraisalEmpList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Categories");
			appraisalEmpList = session.createQuery("from AppraisalEmpInfo a").list();
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

		return appraisalEmpList;
	}

        public List<AppraisalEmpInfo> getEmployeeDetails(String employee_code) throws DAOException {

		List<AppraisalEmpInfo> employeeDetails = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Categories");
			employeeDetails = session.createQuery("from AppraisalEmpInfo a where a.employee_id='"+employee_code+"'").list();
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

		return employeeDetails;
	}


    }