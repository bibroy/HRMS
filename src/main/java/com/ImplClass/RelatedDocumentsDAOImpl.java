/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.RelatedDocumentsDAO;
import com.pojo.RelatedDocuments;
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
 * @author Sumit Kumar
 */
public class RelatedDocumentsDAOImpl extends BaseDAO implements RelatedDocumentsDAO {

    protected static final Log log = LogFactory.getLog(RelatedDocumentsDAO.class);

    public boolean sendRequest(RelatedDocuments documents) throws DAOException {
        System.out.println("******** DAOImpl class is being called **************");
        Session session = null;

        try {
            //session = HRMSHibernateUtil.getSessionFactory().openSession();
            session = getSession();
            session.beginTransaction();
            log.info("saving  details into database");
            System.out.println("!!!!!!!!!!!!!!!!!!!");
            session.saveOrUpdate(documents);
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to save data due to integrity constratint violation");
            System.out.println("Error ======>: " + je.getMessage());
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            System.out.println("Error ======>: " + je.getMessage());
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save company data into database", e);
            System.out.println("Error ======>: " + e.getMessage());
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }
        System.out.println("********** B4 returning from DAOImpl class *********");

        return true;

    }

    public List<RelatedDocuments> getAllEmployees() throws DAOException {

        List<RelatedDocuments> list = null;
        Session session = null;
        try {
            //session = HRMSHibernateUtil.getSessionFactory().openSession();
            session = getSession();
            session.beginTransaction();
            log.info("Fetching list of employees");
            list = session.createQuery("from RelatedDocuments l where l.status='W'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read AirTicket Request data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return list;

    }

    public RelatedDocuments viewOfficialDocumentsRequestData(Integer requestCode) throws DAOException {

        RelatedDocuments documents = null;
        Session session = null;
        long reqcode = requestCode;
        try {
            System.out.println("*********Inside DAOImpl class ***********");
            session = getSession();
            //System.out.println("empId===================>"+id);
            session.beginTransaction();
            log.info("fetching AirTicketRequest Details");
            System.out.println("documents========" + documents);
            documents = (RelatedDocuments) session.load(RelatedDocuments.class, reqcode);
            System.out.println("documents========" + documents);
            //System.out.println("================Data===="+ticket.getAirlineName());
            // System.out.println("================Data===="+ticket.getPurOfTrip());

            log.info("done");
            session.getTransaction().commit();


        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            System.out.println("Exception===========>" + e.getMessage());
            log.error("failed to read documents data from database", e);
            throw new DAOException("Wrong object ");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read documents data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return documents;



    }

    public boolean approve(RelatedDocuments documents) throws DAOException {
        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(documents);
            //session.createQuery("");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to save data due to integrity constratint violation");
            System.out.println("Error ======>: " + je.getMessage());
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            System.out.println("Error ======>: " + je.getMessage());
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save  data into database", e);
            System.out.println("Error ======>: " + e.getMessage());
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }
        System.out.println("********** B4 returning from DAOImpl class *********");

        return true;

    }

    public boolean reject(RelatedDocuments documents) throws DAOException {
        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(documents);
            //session.createQuery("");
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@");
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to save data due to integrity constratint violation");
            System.out.println("Error ======>: " + je.getMessage());
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            System.out.println("Error ======>: " + je.getMessage());
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save data into database", e);
            System.out.println("Error ======>: " + e.getMessage());
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }
        System.out.println("********** B4 returning from DAOImpl class *********");

        return true;

    }

    public List getSingleEmployeeDetails(String employeeId) throws DAOException {

        Session session = null;
        List employeeDetails = null;

        try {

            session = getSession();
            session.beginTransaction();

            employeeDetails = session.createQuery("select em.employeeId,em.firstName,em.middleName,em.lastName,dp.departmentName,bm.branchName,em.domainId,ds.designationName from EmployeeMaster em,Department dp,BranchMaster bm,DesignationMaster ds where  em.departmentId=dp.departmentId and em.designationId=ds.designationId and em.branchId=bm.branchId and em.employeeId='" + employeeId + "'").list();
            System.out.println("SSSSSSSSSSSSSSSSSSSSSSS");
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to get data due to integrity constratint violation");
            System.out.println("Error ======>: " + je.getMessage());
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            System.out.println("Error ======>: " + je.getMessage());
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to get data from database", e);
            System.out.println("Error ======>: " + e.getMessage());
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }
        //Double totalSal=new Double(totalSalary);
        return employeeDetails;

    }

    public long getLastRequestId() throws DAOException {
        Long i =new Long(0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(requestcode) from RelatedDocuments").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Long b = (Long) iter.next();
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
}
