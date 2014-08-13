/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.DAOException;
import com.dao.RecruitmentMarksDAO;
import com.pojo.RecruitmentMarks;
import java.util.List;
import org.hibernate.Session;
import com.dao.BaseDAO;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
/**
 *
 * @author Sumit Kumar
 */
public class RecruitmentMarksDAOImpl extends BaseDAO implements RecruitmentMarksDAO {

    protected static final Log log = LogFactory.getLog(RecruitmentMarksDAO.class);

    public Integer getLastId() throws DAOException {
           Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from RecruitmentMarks").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
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

    public List<RecruitmentMarks> getRecruitmentMarksById(Integer id) throws DAOException {
        List<RecruitmentMarks> recMarksList=null;
        Session session=null;
        try {
            session=getSession();
            session.beginTransaction();
            recMarksList=session.createQuery("from RecruitmentMarks rm where candidateId="+id.toString()+"").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            log.warn("error fetching recruitment list"+e.getMessage());
            session.getTransaction().rollback();
            throw new DAOException(e.getMessage(),e.getCause());
        }
        finally{
            if(session!=null)
            {
                session.flush();
                session.close();
            }
        }

        return recMarksList;
    }

    public boolean save(RecruitmentMarks rcm) throws DAOException {
         Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(rcm);
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
            log.error("failed to save EmployeeMaster data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return true;
    }

}
