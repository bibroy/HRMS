/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.PurposeOfTripDAO;
import com.pojo.PurposeOfTrip;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/**
 *
 * @author sujatas
 */
public class PurposeOfTripDAOImpl extends BaseDAO implements PurposeOfTripDAO {

    protected static final Log log = LogFactory.getLog(PurposeOfTripDAO.class);

    public PurposeOfTripDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public boolean save(PurposeOfTrip purpose) throws DAOException {
        Session session = null;

        try {

            session = getSession();
            // session = HRMSHibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            log.info("Adding details into database");

            session.saveOrUpdate(purpose);
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to add data due to integrity constratint violation");
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to add Leave data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;


    }

    /*public PurposeOfTrip getPurposeOfTrip(Integer purposeId) throws DAOException
    {

    }*/
    public List<PurposeOfTrip> getAllPurposeOfTrip() throws DAOException {
        List<PurposeOfTrip> purposeList = null;
        Session session = null;
        PurposeOfTrip ld;

        try {

            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Leave");

            purposeList = session.createQuery("from PurposeOfTrip p").list();

            Iterator itr = purposeList.iterator();
            while (itr.hasNext()) {
                ld = (PurposeOfTrip) itr.next();
                // System.out.println("Leave Details in DAOImpl========>"+ld.getMaxmdays()+"=====>"+ld.getLeaveapplicable());

            }
            session.getTransaction().commit();


        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read Leave list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return purposeList;
    }

     public PurposeOfTrip getPurposeOfTrip(String purposeName) throws DAOException
    {
                PurposeOfTrip purpose = null;
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching PurposeOfTrip Details");
                         //System.out.println("************In DAOImpl  ======getLeaveDetails()===> Leave type=="+leaveType);
                         //System.out.println("LeaveDetails.class==>"+LeaveDetails.class);

			purpose = (PurposeOfTrip)session.load(PurposeOfTrip.class,purposeName);
                        log.info("done");
			session.getTransaction().commit();


		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read purpose data from database", e);
			throw new DAOException("wrong purpose code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read purpose data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

 System.out.println("<++++++++++++++++++++++++===============>");
		return purpose;



    }


}





