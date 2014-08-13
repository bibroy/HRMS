package com.util;

/**
 *
 * @author Swarnendu mukherjee
 */
import com.dao.BaseDAO;
import com.dao.DAOException;
import com.pojo.AppraisalAttendanceReport;
import com.pojo.AppraisalResultSum;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

/**
 *
 * @author Swarnendu Mukherjee
 */

    public class AppraisalReportUtil extends BaseDAO  {

        protected static final Log log = LogFactory.getLog("Sub employee" );
        public AppraisalReportUtil() {
	}
        @SuppressWarnings("unchecked")

    public List<AppraisalAttendanceReport> getEmpAttendance(String emp_id) throws DAOException {

		List<AppraisalAttendanceReport> appraisalAttendance = null;
		Session session = null;
		try{
			session =getSession();
			session.beginTransaction();
			log.info("Fetching all Active Categories");
			appraisalAttendance = session.createQuery("from AppraisalResultSum a where a.employee_id='"+emp_id+"'").list();
			session.getTransaction().commit();

		}catch(Exception e){
                        session.getTransaction().rollback();
			log.error("failed to read  data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return appraisalAttendance;
	}

        public List<AppraisalResultSum>getAppraisalReport(String emp_id) throws DAOException {

		List<AppraisalResultSum> appraisalResult = null;
		Session session = null;
		try{
			session =getSession();
			session.beginTransaction();
			log.info("Fetching all Active Categories");
			appraisalResult = session.createQuery("from AppraisalResultSum a where a.employee_code='"+emp_id+"'").list();
			session.getTransaction().commit();

		}catch(Exception e){
                        session.getTransaction().rollback();
			log.error("failed to read  data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return appraisalResult;
	}
}



