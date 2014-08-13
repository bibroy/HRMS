package com.ImplClass;

import com.dao.BaseDAO;

import com.dao.DAOException;
import com.dao.VisaPassortDetailsDAO;


import com.pojo.VisaPassortDetails;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;
import java.util.Date;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

/**
 *
 * @author sudipb
 */
public class VisaPassortDetailsDAOImpl extends BaseDAO implements VisaPassortDetailsDAO {

    protected static final Log log = LogFactory.getLog(VisaPassortDetailsDAO.class);

    public VisaPassortDetailsDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<VisaPassortDetails> getAllVisaPassortDetails() throws DAOException {

        List<VisaPassortDetails> visaPassortDetailsList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Grade");
            visaPassortDetailsList = session.createQuery("from VisaPassortDetails v").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read VisaPassortDetails list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return visaPassortDetailsList;
    }

    public VisaPassortDetails getVisaPassortDetails() throws DAOException {

        return new VisaPassortDetails();
    }

    public List<VisaPassortDetails> getVisaPassportDetailsByValidationDate(String datebymonth) throws DAOException {

        /*  Method created by Pradipto */


        List visadetail = null;
        Session session;
        Date d = new Date();
        Date dobj = mySqlDatebFormat(datebymonth);
        try {

            session = getSession();
            session.beginTransaction();
            log.info("Fetching All Details");
            Criteria cobj = session.createCriteria(VisaPassortDetails.class);
            cobj.add(Expression.and(Expression.ge("visaValidUpto", d), Expression.le("visaValidUpto", dobj)));
            visadetail = cobj.list();
//             String query="select * from VISA_PASSORT_DETAILS where VISA_VALID_UPTO>='"+currentdate+"' and VISA_VALID_UPTO<= '"+datebymonth+"'";
//
//             visadetail=session.createSQLQuery(query).list();

            session.getTransaction().commit();
            log.info("Commit Sucessful");
        } catch (Exception e) {

            log.error("error fething attendance data " + e);


        }
        return visadetail;

    }

    public VisaPassortDetails getVisaPassortDetailsByEmpId(String employeeMasterId) throws DAOException {
        VisaPassortDetails visaPassortDetails = null;
        Session session = null;


        try {

            session = getSession();
            session.beginTransaction();
            String HQL = "from VisaPassortDetails e where  e.employeeId='" + employeeMasterId + "'    ";
            System.out.print("********HQL*************" + HQL + "***************************");
            log.info("Fetching all Active Job");
            visaPassortDetails = (VisaPassortDetails) session.createQuery(HQL).uniqueResult();

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read VisaPassortDetails list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return visaPassortDetails;
    }

    public VisaPassortDetails getVisaPassortDetails(Integer visaPassortDetailsId) throws DAOException {
        VisaPassortDetails visaPassortDetails = null;
        Session session = null;

        if (visaPassortDetailsId == null) {
            throw new DAOException("failed to fetch data for \"null\" VisaPassortDetails id");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching VisaPassortDetails Detail");
            visaPassortDetails = (VisaPassortDetails) session.load(VisaPassortDetails.class, visaPassortDetailsId);
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read VisaPassortDetails data from database", e);
            throw new DAOException("wrong VisaPassortDetails code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read VisaPassortDetails data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return visaPassortDetails;
    }

    public VisaPassortDetails getVisaPassortDetailsByCode(String visaPassortDetailsCode) throws DAOException {

        return null;
    }

    public boolean save(VisaPassortDetails visaPassortDetails) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving VisaPassortDetails details into database");
            System.out.print("*-*-**-*-*-*-*-*-insert Employee Conformation-----------------");
            session.saveOrUpdate(visaPassortDetails);
            System.out.print("*-*-**-*-*-*-*-*-insert end Employee Conformation-----------------");
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
            log.error("failed to save VisaPassortDetails data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }
}
