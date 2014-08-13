/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.AdvancedSalaryRequestDAO;
import com.dao.BaseDAO;
import com.dao.DAOException;
import com.pojo.AdvancedSalaryRequest;
import java.math.BigDecimal;
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
public class AdvancedSalaryRequestDAOImpl extends BaseDAO implements AdvancedSalaryRequestDAO {

    protected static final Log log = LogFactory.getLog(AdvancedSalaryRequestDAO.class);

    public boolean sendRequest(AdvancedSalaryRequest advancedSalaryReq) throws DAOException {

        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving AdvancedSalary request details into database");

            session.saveOrUpdate(advancedSalaryReq);

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
//End of sendRequest

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

    public List<AdvancedSalaryRequest> getAllEmployees() throws DAOException {

        List<AdvancedSalaryRequest> list = null;
        Session session = null;


        try {

            //session = HRMSHibernateUtil.getSessionFactory().openSession();
            session = getSession();
            session.beginTransaction();
            log.info("Fetching list of employees");

            list = session.createQuery("select l.employeeId,l.totalsalary,l.appliedamount,l.noofinstallment,l.deductionstartmonth,l.reason,l.requestid,l.requestdate from AdvancedSalaryRequest l where l.approvalstatus='W'").list();

            session.getTransaction().commit();



        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read AdvancedSalary Request data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return list;

    }

//Endo of getAllEmployee()
    public AdvancedSalaryRequest viewAdvancedSalaryRequestData(Integer hiddenId) throws DAOException {

        AdvancedSalaryRequest asalaryr = null;
        Session session = null;
        BigDecimal b=new BigDecimal(hiddenId.intValue());

        try {

            //System.out.println("viewAdvancedSalaryRequestData====b4 creation session====empid=="+empId);

            session = getSession();
            System.out.println("viewAdvancedSalaryRequestData====After  creation session====>" + session);
            session.beginTransaction();
            log.info("fetching AdvancedSalaryRequest Details");

            System.out.println("viewAdvancedSalaryRequestData====B4 getting object asalaryr===>" + asalaryr);
            asalaryr = (AdvancedSalaryRequest) session.load(AdvancedSalaryRequest.class, b);

            System.out.println("viewAdvancedSalaryRequestData====After getting object asalaryr===> " + asalaryr.getApprovalstatus());

            log.info("done");
            session.getTransaction().commit();





        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();

            log.error("failed to read AdvancedSalaryRequest data from database", e);
            throw new DAOException("Wrong object ");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read AdvancedSalaryRequest data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        System.out.println("Approval sattus in DAOImpl just b4 returning 2 action============>" + asalaryr.getApprovalstatus());

        return asalaryr;



    }

    //For Approval
    public boolean approve(AdvancedSalaryRequest advancedSalaryReq) throws DAOException {
        Session session = null;
        try {

            System.out.println("3333333333333333333333333333333333333333");
            session = getSession();
            System.out.println("44444444444444444444444444444444");
            session.beginTransaction();
            System.out.println("55555555555555555555555555555555555555555555");
            session.saveOrUpdate(advancedSalaryReq);
            //session.createQuery("");
            System.out.println("66666666666666666666666666666666666");
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
        System.out.println("777777777777777777777777777777777");

        return true;

    }

    public boolean reject(AdvancedSalaryRequest advancedSalaryReq) throws DAOException {
        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(advancedSalaryReq);
            //session.createQuery("");
            System.out.println("");
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

    public List getTotalSalary(Integer empId) throws DAOException {
        Session session = null;
        List totalSalary = null;

        try {

            session = getSession();
            session.beginTransaction();

            totalSalary = session.createQuery("select  s1.amount from SalaryBreakup s1 ,SalaryHead  s2 where s1.headergpid=s2.id and s2.status='Y' and s2.headertype='E' and s1.employeeid='" + empId + "'").list();
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
        return totalSalary;
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

    public List<AdvancedSalaryRequest> getAllRequest(String empid) throws DAOException {
        Session session=null;
        List<AdvancedSalaryRequest> advlist=null;
        try {
            session=getSession();
            session.beginTransaction();
            advlist=session.createQuery("from AdvancedSalaryRequest a where a.employeeId='"+empid+"'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the advanced salary request "+e);
        }
        return advlist;
    }


}
