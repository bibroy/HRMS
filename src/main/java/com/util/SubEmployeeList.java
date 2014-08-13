/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;

/**
 *
 * @author Swarnendu mukherjee
 */
import com.dao.BaseDAO;
import com.dao.DAOException;
import java.util.List;
import com.pojo.EmployeeMaster;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

/**
 *
 * @author Swarnendu Mukherjee
 */

    public class SubEmployeeList extends BaseDAO  {

        protected static final Log log = LogFactory.getLog( SubEmployeeList.class );
        public SubEmployeeList() {
	}
        @SuppressWarnings("unchecked")
	public List getEmpIdList(String mgr_id) throws DAOException {

		List appraisalEmpList = null;
		Session session = null;


		try{
			session =getSession();
			session.beginTransaction();
			log.info("Fetching all Active Categories");
			//appraisalEmpList = session.createSQLQuery("select distinct e.employee_id from employee_master e start with e.supervisor_id='"+mgr_id+"' connect by prior e.employee_id=e.supervisor_id").list();
                        appraisalEmpList=session.createQuery("select distinct e.employeeId from EmployeeMaster e where e.supervisorId='"+mgr_id+"'").list();

			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read employee list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return appraisalEmpList;
	}
        public List getEmpNameList(String mgr_id) throws DAOException {

		List appraisalEmpList = null;
		Session session = null;


		try{
			session =getSession();
			session.beginTransaction();
			log.info("Fetching all Active Categories");
			//appraisalEmpList = session.createSQLQuery("select distinct concat(concat(concat(e.first_name,' '),concat(e.middle_name,' ')),e.last_name) from employee_master e start with e.supervisor_id='"+mgr_id+"' connect by prior e.employee_id=e.supervisor_id ").list();
                         appraisalEmpList=session.createQuery("select distinct concat(concat(concat(e.firstName,' '),concat(e.middleName,' ')),e.lastName) from EmployeeMaster e where e.supervisorId='"+mgr_id+"'").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read employee list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return appraisalEmpList;
	}
    }
