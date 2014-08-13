/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.LeavePerRoleDAO;
import com.pojo.LeavePerRole;
import com.pojo.LeaveStatusPeremployee;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/**
 *
 * @author sujatas
 */
public class LeavePerRoleDAOImpl extends BaseDAO implements LeavePerRoleDAO {

    protected static final Log log = LogFactory.getLog(LeavePerRoleDAO.class);

    public LeavePerRoleDAOImpl() {
    }

    public boolean addLeave(LeavePerRole leavePerRole) throws DAOException {

        Session session = null;

        try {

            session = getSession();
            // session = HRMSHibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();

            log.info("Adding details into database");

            session.saveOrUpdate(leavePerRole);
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to add data due to integrity constratint violation");
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to add Leave data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }

    public boolean assignLeave(LeaveStatusPeremployee leaveStatusPeremployee) throws DAOException {
        Session session = null;


        try {

            session = getSession();
            // session = HRMSHibernateUtil.getSessionFactory().openSession();

            session.beginTransaction();


            log.info("Adding details into database");

            session.saveOrUpdate(leaveStatusPeremployee);
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to add data due to integrity constratint violation");
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to add Leave data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }








        return true;
    }

    public List getLeavePerRole(Integer id) throws DAOException {
        LeavePerRole leavePerRole = null;
        Session session = null;
        List<LeavePerRole> list = null;
      
       
        
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching LeavePerRole Details");
            list = session.createQuery("select l.leaveId,l.maxDays from LeavePerRole l where l.roleId="+ id+"and l.flag='E'").list();
            
            System.out.println("List=====>" + list);



            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to add data due to integrity constratint violation");
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to add Leave data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return list;


    }

    public LeaveStatusPeremployee getLeaveStatusFromDB(String empId, Integer leaveId) throws DAOException {
        LeaveStatusPeremployee noOfDays = null;
        Session session = null;



        try {
            System.out.println("Inside DAOImpl   getLeaveStatusFromDB method======  ");
            System.out.println("Employee Id======  "+empId);
            System.out.println("Leave  Id======  "+leaveId);

            session = getSession();
            session.beginTransaction();
            noOfDays = (LeaveStatusPeremployee)session.createQuery(" from LeaveStatusPeremployee l where l.empid=" + empId + "and l.leaveid=" + leaveId).uniqueResult();
            System.out.println("NoOfDays========>"+noOfDays);
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to load data due to integrity constratint violation");
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

        return noOfDays;
    }
}
