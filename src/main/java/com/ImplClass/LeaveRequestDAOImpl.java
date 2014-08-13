/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.LeaveRequestDAO;
import com.pojo.Leave;
import java.math.BigDecimal;
import java.util.Iterator;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
//import com.hbms.HRMSHibernateUtil;
import java.util.List;
import org.hibernate.ObjectNotFoundException;

/**
 *
 * @author sujatas
 */
public class LeaveRequestDAOImpl extends BaseDAO implements LeaveRequestDAO {

    protected static final Log log = LogFactory.getLog(LeaveRequestDAO.class);

    public boolean sendRequest(Leave leave) throws DAOException {
        System.out.println("******** DAOImpl class is being called **************");
        Session session = null;

        try {
            //session = HRMSHibernateUtil.getSessionFactory().openSession();
            session = getSession();
            session.beginTransaction();
            log.info("saving leave request details into database");
            System.out.println("!!!!!!!!!!!!!!!!!!!");
            session.saveOrUpdate(leave);
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

    //End of sendRequest
    public BigDecimal getLastRequestId() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(requestid) from Leave").list();
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

    public List<Leave> getAllEmployees() throws DAOException {

        List<Leave> list = null;
        Session session = null;


        try {

            //session = HRMSHibernateUtil.getSessionFactory().openSession();
            session = getSession();
            session.beginTransaction();
            log.info("Fetching list of employees");

            //list = session.createQuery("from Leave l where l.lstatus='W'").list();
            list = session.createQuery("select l.empid,l.fromDate,l.toDate,l.reason,l.leaveAddress,l.leaveContactno,l.noofdays,ld.leavetype,l.requestid,l.requestdate from Leave l,LeaveDetails ld where l.leaveType=ld.leaveid and l.leavestatus='W'").list();

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read Leave Request data from database", e);
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
    public List getAllLeaveReport(String employeeId) throws DAOException {
        List leaveList = null;
        Session session = null;
        // List list = null;
        Iterator itr = null;
        Integer id = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Leave Request Details");
            //list = (List) session.createQuery("select l.id from Leave l where l.empId="+ employeeId);
            leaveList = session.createQuery("select ld.leavetype,l.totalleave,l.leavetaken from LeaveStatusPeremployee l,LeaveDetails ld where l.leaveid=ld.leaveid and l.empid='" + employeeId + "'").list();


            log.info("done");
            session.getTransaction().commit();
        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            System.out.println("Exception===========>" + e.getMessage());
            log.error("failed to read Leave data from database", e);
            throw new DAOException("Wrong object ");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Leave data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        System.out.println("Leave Object value==========>" + leaveList);
        return leaveList;

    }

    public Leave viewLeaveRequestData(Integer id) throws DAOException {

        Leave leave = null;
        Session session = null;
        BigDecimal b = new BigDecimal(id.intValue());
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Leave Request Details");
            System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            System.out.println("Sujata ====================");
            leave = (Leave) session.load(Leave.class, b);
            // session.createQuery("from Leave l where l.lstatus='Waiting'");


            System.out.println("In DAO Impl class =====> Pojo data====Status==" + leave.getLeavestatus());

            log.info("done");
            session.getTransaction().commit();
            System.out.println("********************");

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            System.out.println("Exception===========>" + e.getMessage());
            log.error("failed to read Leave data from database", e);
            throw new DAOException("Wrong object ");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Leave data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        System.out.println("Leave Object value==========>" + leave);
        return leave;



    }
    //End of viewLeaveRequestData

    public boolean approve(Leave leave) throws DAOException {
        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(leave);
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

    public boolean reject(Leave leave) throws DAOException {
        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(leave);
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

    /*
    public List getLoginDetails(Integer empId)throws DAOException
    {
    List list=null;

    Session session = null;
    try{

    session = getSession();
    session.beginTransaction();
    list=session.createQuery("from EmpDetails e where e.employeeId="+empId).list();
    session.flush();
    session.getTransaction().commit();
    log.info("done");
    }

    catch (ConstraintViolationException je) {
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


    return list;
    }*/
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

    public List<Leave> getAllRequest(String empid) throws DAOException {
        Session session=null;
        List<Leave> leavelist=null;
        try {
            session=getSession();
            session.beginTransaction();
            leavelist=session.createQuery("from Leave l where l.empid='"+empid+"'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the leave request data "+e);
        }
        return leavelist;
    }

}
