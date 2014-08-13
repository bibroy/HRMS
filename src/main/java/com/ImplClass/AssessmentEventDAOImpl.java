/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;
import com.dao.BaseDAO;
import com.dao.AssessmentEventDAO;
import com.dao.DAOException;
import com.pojo.AssessmentEvent;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;
/**
 *
 * @author computer1
 */
public class AssessmentEventDAOImpl extends BaseDAO implements AssessmentEventDAO{

     protected static final Log log = LogFactory.getLog(AssessmentEventDAO.class );
    public boolean save(AssessmentEvent ae)throws DAOException{

       
              Session session = null;

                       try{
			session = getSession();
			session.beginTransaction();
			log.info("saving assessment event into database");
			session.saveOrUpdate(ae);
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
			log.error("failed to save assessment event data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}
     public Integer getLastRequestId() throws DAOException {

        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last id");
            l = session.createQuery("select max(id) from AssessmentEvent").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
               Integer b = (Integer) iter.next();
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
            log.error("===========>failed to read Leave Id from database", e);
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


