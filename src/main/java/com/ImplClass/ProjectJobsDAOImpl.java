/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.ProjectJobsDAO;
import com.pojo.ProjectJobs;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

/**
 *
 * @author Sumit Kumar
 */
public class ProjectJobsDAOImpl extends BaseDAO implements ProjectJobsDAO {

    protected static final Log log = LogFactory.getLog(ProjectJobsDAO.class);

    public List<ProjectJobs> getAllJobs() throws DAOException {
        Session session = null;
        List<ProjectJobs> prjList = null;
        try {
            session = getSession();
            session.beginTransaction();
            prjList = session.createQuery("from ProjectJobs p").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the list of jobs " + e);
            session.getTransaction().rollback();
            throw new DAOException("Unkown Exception");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return prjList;
    }

    public List<ProjectJobs> getAllJobsByProj(BigDecimal projId) throws DAOException {
        Session session = null;
        List<ProjectJobs> prjlist = null;
        try {
            session = getSession();
            session.beginTransaction();
            prjlist = session.createQuery("from ProjectJobs p where p.project=" + projId.toString()).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error during fecthing the project jobs data " + e);
            session.getTransaction().rollback();
            throw new DAOException("Unkown Error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return prjlist;
    }

    public ProjectJobs getJobById(BigDecimal id) throws DAOException {
        Session session = null;
        ProjectJobs pj = null;
        try {
            session = getSession();
            session.beginTransaction();
            pj = (ProjectJobs) session.get(ProjectJobs.class, id);
            if(pj==null){
                pj=(ProjectJobs)session.load(ProjectJobs.class, id);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the project jobs data " + e);
            session.getTransaction().rollback();
            throw new DAOException("Unknown Error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return pj;
    }

    public boolean save(ProjectJobs pj) throws DAOException {
        Session session = null;
        boolean result = false;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(pj);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            log.error("error saving the project jobs data " + e);
            session.getTransaction().rollback();
            throw new DAOException("Unknown Error ");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return result;
    }

    public BigDecimal getLastId() throws DAOException {
        BigDecimal i = new BigDecimal(0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from ProjectJobs").list();
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
