/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.ShiftMasterDAO;
import com.pojo.ShiftMaster;
import com.pojo.WorkShift;
import com.dao.WorkShiftDAO;
import com.dao.DAOException;
import java.math.BigDecimal;
import com.dao.BaseDAO;

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
public class WorkShiftDAOImpl extends BaseDAO implements WorkShiftDAO {

    protected static final Log log = LogFactory.getLog(WorkShiftDAO.class);

    @SuppressWarnings("unchecked")
    public boolean save(WorkShift work) throws DAOException {

        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving company details into database");
            session.saveOrUpdate(work);
            session.flush();
            session.getTransaction().commit();
            work = null;
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

    public WorkShift getAllWorkShiftbyEmpId(String empid) throws DAOException {
        WorkShift wrk = null;
        Session session = null;
        session = getSession();
        try {
            session.beginTransaction();
            String query = "from WorkShift w where w.employeeID='" + empid + "'  ";
            wrk = (WorkShift) session.createQuery(query).uniqueResult();
            session.getTransaction().commit();
            log.info("transaction commited successfully");


        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save company data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.flush();
            }
            session.close();
        }
        return wrk;

    }
}
