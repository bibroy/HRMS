package com.ImplClass;

import com.dao.BaseDAO;

import com.dao.DAOException;
import com.dao.ProfReferenceDetailsDAO;


import com.pojo.ProfReferenceDetails;
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
 * @author sudipb
 */
public class ProfReferenceDetailsDAOImpl extends BaseDAO implements ProfReferenceDetailsDAO {

    protected static final Log log = LogFactory.getLog(ProfReferenceDetailsDAO.class);

    public ProfReferenceDetailsDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<ProfReferenceDetails> getAllProfReferenceDetails() throws DAOException {

        List<ProfReferenceDetails> profReferenceDetailsList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Grade");
            profReferenceDetailsList = session.createQuery("from ProfReferenceDetails v").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read ProfReferenceDetails list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return profReferenceDetailsList;
    }

    public BigDecimal getLastRequestId() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(requestid) from Loan").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                BigDecimal b = (BigDecimal) iter.next();
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

    
    public ProfReferenceDetails getProfReferenceDetails() throws DAOException {

        return new ProfReferenceDetails();
    }

    public ProfReferenceDetails getProfReferenceDetailsByEmpId(String employeeMasterId) throws DAOException {
        ProfReferenceDetails profReferenceDetails = null;
        Session session = null;


        try {

            session = getSession();
            session.beginTransaction();
            String HQL = "from ProfReferenceDetails e where  e.employeeId='" + employeeMasterId + "'    ";
            System.out.print("********HQL*************" + HQL + "***************************");
            log.info("Fetching all Active Job");
            profReferenceDetails = (ProfReferenceDetails) session.createQuery(HQL).uniqueResult();

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read ProfReferenceDetails list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return profReferenceDetails;
    }

    public ProfReferenceDetails getProfReferenceDetails(Integer profReferenceDetailsId) throws DAOException {
        ProfReferenceDetails profReferenceDetails = null;
        Session session = null;

        if (profReferenceDetailsId == null) {
            throw new DAOException("failed to fetch data for \"null\" ProfReferenceDetails id");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching ProfReferenceDetails Detail");
            profReferenceDetails = (ProfReferenceDetails) session.load(ProfReferenceDetails.class, profReferenceDetailsId);
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read ProfReferenceDetails data from database", e);
            throw new DAOException("wrong ProfReferenceDetails code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read ProfReferenceDetails data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return profReferenceDetails;
    }

    public ProfReferenceDetails getProfReferenceDetailsByCode(String profReferenceDetailsCode) throws DAOException {

        return null;
    }

    public boolean save(ProfReferenceDetails profReferenceDetails) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving ProfReferenceDetails details into database");
            System.out.print("*-*-**-*-*-*-*-*-insert Employee Conformation-----------------");
            session.saveOrUpdate(profReferenceDetails);
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
            log.error("failed to save ProfReferenceDetails data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }
}
