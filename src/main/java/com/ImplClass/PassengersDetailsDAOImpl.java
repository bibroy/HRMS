/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.PassengersDetailsDAO;
import com.pojo.PassengerDetails;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/**
 *
 * @author sujatas
 */
public class PassengersDetailsDAOImpl extends BaseDAO implements PassengersDetailsDAO {

    protected static final Log log = LogFactory.getLog(PassengersDetailsDAO.class);

    public boolean savePassengerDetails(PassengerDetails passengersDetails) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving PassengersDetails request details into database");
            session.saveOrUpdate(passengersDetails);

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
            log.error("failed to save company data into database", e);

            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
                }
        return true;
    }


    public BigDecimal getLastRequestId() throws DAOException {

        BigDecimal i= new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from PassengerDetails").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                BigDecimal b = (BigDecimal) iter.next();
                if (b != null) {
                    i = b;
                }
//                Object[] row = (Object[]) iter.next();
//                if(row[0]!=null)
//                {
//                BigDecimal b=(BigDecimal)row[0];
//                i = b;
//                }
           }
        }catch(NullPointerException npe){
            //session.getTransaction().rollback();
            log.error("null value");
        }
        catch (Exception e) {
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
