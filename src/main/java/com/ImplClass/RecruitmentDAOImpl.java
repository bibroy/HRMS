/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.RecruitmentDAO;
import com.pojo.Recruitment;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.EntityMode;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/**
 *
 * @author Sumit Kumar
 */
public class RecruitmentDAOImpl extends BaseDAO implements RecruitmentDAO {

    protected static final Log log = LogFactory.getLog(RecruitmentDAO.class);

    public List<Recruitment> getAllRecruitmentByStatus(String status) throws DAOException {
        List<Recruitment> recList=null;
        Session session=null;
        try {
            session=getSession();
            session.beginTransaction();
            recList=session.createQuery("from Recruitment r where status='"+status.toLowerCase()+"'").list();
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

        return recList;
    }

    public List<Recruitment> getAllRecruitment() throws DAOException {
        List<Recruitment> recList=null;
        Session session=null;
        try {
            session=getSession();
            session.beginTransaction();
            recList=session.createQuery("from Recruitment r").list();
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

        return recList;
    }

    public List<Recruitment> getRecruitmentBySkill(String skill) throws DAOException{
        List<Recruitment> reclist=null;
        Session session=null;
        try {
            session=getSession();
            session.beginTransaction();
            reclist=session.createQuery("from Recruitment r where lower(r.skills) like '%"+skill+"%'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
             log.warn("error fetching recruitment list"+e.getMessage());
            session.getTransaction().rollback();
            throw new DAOException(e.getMessage(),e.getCause());
        }
         return reclist;
        }

    public Integer getLastId() throws DAOException {
        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from Recruitment").list();
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

    public Recruitment getRecruitment() throws DAOException {
       return new Recruitment();
    }

    public Recruitment getRecruitment(Integer id) throws DAOException {
       Session session=null;
       Recruitment rec=null;
       try {
            session=getSession();
            session.beginTransaction();
            rec=(Recruitment)session.load(Recruitment.class,id);
            session.getTransaction().commit();
        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeMaster data from database", e);
            throw new DAOException("wrong EmployeeMaster code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeMaster data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return rec;
    }

    public boolean save(Recruitment rc) throws DAOException {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(rc);
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
