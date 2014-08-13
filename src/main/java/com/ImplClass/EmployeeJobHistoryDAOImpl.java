/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import java.math.BigDecimal;
import com.dao.EmployeeJobHistoryDAO;
import com.pojo.EmployeeJobHistory;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;
import java.util.Iterator;

/**
 *
 * @author pradipto roy
 */
public class EmployeeJobHistoryDAOImpl extends BaseDAO implements EmployeeJobHistoryDAO
{
    
    
    public EmployeeJobHistoryDAOImpl()
    {
        
    }

    protected static final Log log=LogFactory.getLog(EmployeeJobHistoryDAO.class);
   public boolean save(EmployeeJobHistory empobj)throws DAOException
    {
       Session session;

      try
      {
          session=getSession();
          session.beginTransaction();
          log.info("Saving Job History Detail in Database");
          session.saveOrUpdate(empobj);
         
          session.beginTransaction().commit();
           session.flush();
          log.info("Completed");


      }

      catch(Exception e)
      {
          log.info("An Exception Occur the type of Exception is :"+e);
      }


      return true;

   }

public BigDecimal getLastRequestId() throws DAOException
    {

    BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from EmployeeJobHistory").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                BigDecimal b = (BigDecimal) iter.next();
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
public List<EmployeeJobHistory>getEmployeesByRunaway(String Runaway)
    {
    List<EmployeeJobHistory> list=null;
    Session session=null;

    try
    {
    session=getSession();
    session.beginTransaction();
    list=session.createQuery("from EmployeeJobHistory e where e.runaway='"+Runaway+"'").list();
    log.info("Data retreive sucessfully");
    session.getTransaction().commit();
    log.info("Commited Sucessfully");


    }

    catch(Exception e)
    {
        session.getTransaction().rollback();
        log.error("Exception occured exception type is "+ e);

    }

    finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }


    return list;
}


}
