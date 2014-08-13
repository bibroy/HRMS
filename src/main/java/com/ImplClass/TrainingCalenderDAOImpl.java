/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.DAOException;
import com.dao.BaseDAO;
import com.dao.TrainingCalenderDao;

import com.pojo.TraingCalender;
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
 * @author pradipto roy
 * created on 17/2/12011
 */
public class TrainingCalenderDAOImpl extends BaseDAO implements TrainingCalenderDao {

    protected static final Log log = LogFactory.getLog(TrainingCalenderDao.class);

    public boolean save(TraingCalender obj) throws DAOException {

        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(obj);
            session.flush();
            session.getTransaction().commit();
            log.info("Data Seved Successfully");



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

    public Integer getLastRequestId() throws DAOException {

        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last id");
            l = session.createQuery("select max(id) from TraingCalender").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
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
        } catch (NullPointerException npe) {
            //session.getTransaction().rollback();
            log.error("null value");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read Leave  Id from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return i;


    }

    public List<TraingCalender> getTrainingNamesDetails() throws DAOException {
        List<TraingCalender> list = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String query = "from TraingCalender t ";
            list = session.createQuery((query)).list();
            session.getTransaction().commit();
            log.info("Commited successfuly");


        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed retreivedata", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }

        }



        return list;

    }

    public List<TraingCalender> getTrainingDetailsCheck(String trainingname, String startdate, String enddate) throws DAOException {

       List list=null;
        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();

            String query = "Select * from training_calender where id='"+trainingname+"' and fromdate>=to_date('"+startdate+"','dd-MM-yyyy') and todate<=to_date('"+enddate+"','dd-MM-yyyy')";
            list = session.createSQLQuery(query).list();
            session.getTransaction().commit();
            log.info("Retreave successfully");



        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed retreivedata", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }

        }

        return list;

    }
}
