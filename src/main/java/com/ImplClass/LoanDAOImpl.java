/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.LoanDAO;
import com.pojo.Loan;
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
public class LoanDAOImpl extends BaseDAO implements LoanDAO {

    protected static final Log log = LogFactory.getLog(LoanDAO.class);

    public boolean sendRequest(Loan loanPojo) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving AdvancedSalary request details into database");

            session.saveOrUpdate(loanPojo);

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

    public List<Loan> getAllEmployees() throws DAOException {

        List<Loan> list = null;
        Session session = null;


        try {

            //session = HRMSHibernateUtil.getSessionFactory().openSession();
            session = getSession();
            session.beginTransaction();
            log.info("Fetching list of employees");

            list = session.createQuery("select l.employeeid,l.totalsalary,l.loanamount,l.noofinstallment,l.deductionstartmonth,l.requestid,l.reason,l.requestdate from Loan l where l.approvalstatus='W'").list();


            session.getTransaction().commit();



        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read Loan Request data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return list;





    }

//To get Total Salry start
    public List getTotalSalary(Integer empId) throws DAOException {
        Session session = null;
        List totalSalary = null;

        try {

            session = getSession();
            session.beginTransaction();

            totalSalary = session.createQuery("select  s1.amount from SalaryBreakup s1 ,SalaryHead  s2 where s1.headergpid=s2.id and s2.status='Y' and s2.headertype='E' and s1.employeeid='" + empId + "'").list();
            /*
             * salarybreakup and salary table not present. (sumit)
             */
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

//End get Total Salry
    public Loan viewLoanRequestData(Integer id) throws DAOException {

        Loan loan = null;
        Session session = null;
        BigDecimal b = new BigDecimal(id.intValue());

        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Loan Request Details");
            System.out.println("Loan object=====>" + loan);
            loan = (Loan) session.load(Loan.class, b);
            System.out.println("Loan object=====>" + loan);
            // session.createQuery("from Leave l where l.lstatus='Waiting'");


            //System.out.println("In DAO Impl class =====> Pojo data====Fname=="+leave.getEmpFname()+"Lname===>"+leave.getEmpLname());

            log.info("done");
            session.getTransaction().commit();
            System.out.println("********************");

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            System.out.println("Exception===========>" + e.getMessage());
            log.error("failed to read Loan data from database", e);
            throw new DAOException("Wrong object ");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Loan data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }


        System.out.println("In DAOImpl viewLoanRequestData ===Satus====>" + loan.getApprovalstatus());
        return loan;



    }
    //End of viewLeaveRequestData

    public boolean approve(Loan loan) throws DAOException {
        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            System.out.println("in DAO Impl====Inside Approve method");
            session.saveOrUpdate(loan);
            //session.createQuery("");
            System.out.println("in DAO Impl====Inside Approve method===After saving");
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

    public boolean reject(Loan loan) throws DAOException {
        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(loan);
            //session.createQuery("");

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

    public List<Loan> getRequestStatus(String empid) throws DAOException {
        Session session=null;
        List<Loan> loanlist=null;
        try {
            session=getSession();
            session.beginTransaction();
            loanlist=session.createQuery("from Loan l where l.employeeid='"+empid+"'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching loan data "+ e);
        }
        finally{
            if(session!=null){
                session.flush();
                session.close();
            }
        }
        return loanlist;
    }


}
