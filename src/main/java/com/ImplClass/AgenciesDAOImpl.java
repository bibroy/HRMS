/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;
import com.dao.BaseDAO;
import com.dao.AgenciesDAO;
import com.dao.DAOException;
import com.pojo.Agencies;
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
public class AgenciesDAOImpl extends BaseDAO implements AgenciesDAO {
    protected static final Log log = LogFactory.getLog( AgenciesDAO.class );
         public boolean save(Agencies a)throws DAOException{
              Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving Agencies into database");
			session.saveOrUpdate(a);
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
			log.error("failed to save Agencies into database", e);
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
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from Agencies").list();
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
   public List<Agencies>  getAgencies() throws DAOException{

		List<Agencies>AgenciesList = null;
		Session session = null;
                try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Agencies");
			AgenciesList= session.createQuery("from Agencies a").list();
			session.getTransaction().commit();
                        }catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read  list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return AgenciesList;
	
   }
    public Agencies getAgencyByAgencyname(String name) throws DAOException {
        Agencies a = null;
        Session session = null;


        try {

            session = getSession();
            session.beginTransaction();
            String HQL = "from Agencies a  where  a.name='" + name + "'    ";
            System.out.print("********HQL*************" + HQL + "***************************");
            log.info("Fetching all Active Job");
            a = (Agencies) session.createQuery(HQL).uniqueResult();

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Job list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return a;
    }
     public boolean update(Agencies b)throws DAOException{
              Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving Agencies into database");
			session.update(b);
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
			log.error("failed to save Agencies into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}
}
