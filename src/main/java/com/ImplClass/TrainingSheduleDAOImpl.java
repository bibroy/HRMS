/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.*;
import com.pojo.GradeMaster;
import com.dao.GradeMasterDAO;
import com.dao.DAOException;
import com.pojo.TrainingSchedule;
import java.math.BigDecimal;
import com.dao.BaseDAO;
import com.dao.TrianingSheduleDAO;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author pradipto roy
 * created on 27/1/2011
 */
public class TrainingSheduleDAOImpl extends BaseDAO implements TrianingSheduleDAO {

    protected static final Log log = LogFactory.getLog(TrianingSheduleDAO.class);

    public boolean save(TrainingSchedule trangshedule) throws DAOException {
        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(trangshedule);
            log.info("Saved Successfully");
            session.flush();
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save EmployeeEducationDetails data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }


        return true;



    }
}
