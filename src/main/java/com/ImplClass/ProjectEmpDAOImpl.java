/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.ProjectEmpDAO;
import com.pojo.ProjectEmp;
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
public class ProjectEmpDAOImpl extends BaseDAO implements ProjectEmpDAO {

    protected static final Log log = LogFactory.getLog(ProjectEmpDAO.class);

    public List<ProjectEmp> getAllEmpByJob(BigDecimal jobId) throws DAOException {
        Session session = null;
        List<ProjectEmp> pelist = null;
        try {
            session = getSession();
            session.beginTransaction();
            pelist = session.createQuery("from ProjectEmp p where job=" + jobId.toString()).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the list of employee " + e);
            session.getTransaction().rollback();
            throw new DAOException("Unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return pelist;
    }

    public List<ProjectEmp> getAllEmpByProj(BigDecimal projId) throws DAOException {
        Session session = null;
        List<ProjectEmp> pelist = null;
        try {
            session = getSession();
            session.beginTransaction();
            pelist = session.createQuery("from ProjectEmp pe where pe.project=" + projId.toString()).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the project employee information" + e);
            session.getTransaction().rollback();
            throw new DAOException("Unknown Error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return pelist;
    }

    public boolean save(ProjectEmp pe) throws DAOException {
        Session session = null;
        boolean result = false;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(pe);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            log.error("error saving the Project employee data " + e);
            session.getTransaction().rollback();
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return result;
    }

    public List getIdleEmployee() throws DAOException {
        Session session = null;
        List list = null;

        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("select e.employeeId from EmployeeMaster e where e.employeeId not in (select pm.empId from ProjectEmp pm where pm.status='Y')").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the list of employee id " + e);
            session.getTransaction().rollback();
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return list;
    }

    public BigDecimal getLastId() throws DAOException {
        BigDecimal i = new BigDecimal(0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from ProjectEmp").list();
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

    public ProjectEmp getProjByEmpId(String empId) throws DAOException {
        Session session = null;
        ProjectEmp pe = null;
        try {
            session = getSession();
            session.beginTransaction();
            pe = (ProjectEmp) session.createQuery("from ProjectEmp pe where pe.empId='" + empId + "'").uniqueResult();
            if (pe != null) {
                String name = pe.getProject().getProjectName();
                name = pe.getJob().getJobName();
                name = null;
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the project employee data " + e);
            session.getTransaction().rollback();
            throw new DAOException("unknown errror");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return pe;
    }
}
