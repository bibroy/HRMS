/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.DAOException;
import com.dao.BaseDAO;
import com.dao.TraingFeedbackDAO;
import com.pojo.TrainerFeedback;
import com.pojo.TrainingSchedule;
import java.math.BigDecimal;
import java.util.Iterator;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

/**
 *
 * @author pradipto roy
 * created on 27/1/2011
 */
public class TrainingFeedbackImpl extends BaseDAO implements TraingFeedbackDAO {

    protected static final Log log = LogFactory.getLog(TraingFeedbackDAO.class);

    public List<TrainingSchedule> getTrainingScheduleByID(String traingname) throws DAOException {
        List<TrainingSchedule> list = null;
        Session session = null;

        try {


            session = getSession();
            session.beginTransaction();
            String query = "from TrainingSchedule t where t.trainingname='" + traingname + "'";
            list = session.createQuery(query).list();
            session.getTransaction().commit();
            log.info("Data retreived Successfully");
            log.info("Data fetch and displayed in form");


        } catch (Exception e) {
            log.error("error fetching the list of complaints " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
            return list;
        }
    }

    public boolean save(TrainerFeedback tr) throws DAOException {
        Session session = null;
        session = getSession();

        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(tr);
            session.flush();
            session.getTransaction().commit();
            log.info("Successfully Saved");


        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save TrainingFeedback data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }

        }

        return true;

    }


    public Integer getRequestbyID() throws DAOException
            {
        
       Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last id");
            l = session.createQuery("select max(id) from TrainerFeedback").list();
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


    public List<TrainerFeedback> getTrainingFeedbackbyTrnID(String trainingID) throws DAOException
    {

        List<TrainerFeedback> fdbklist=null;
        Session session=null;

        try
        {

            session=getSession();
            session.beginTransaction();
            String query="from TrainerFeedback t where t.trainingid='"+trainingID+"' ";
            fdbklist=session.createQuery(query).list();
            session.getTransaction().commit();

            log.info("Data Retreive Successfully");


        }
       catch (Exception e) {
            log.error("error fetching the list of training feedback " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }

        }
        return fdbklist;

    }


}
