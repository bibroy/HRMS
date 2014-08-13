/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.LeaveDetailsDAO;
import com.pojo.LeaveDetails;
// import com.pojo.LeavePerRole;                          //commented by sumit
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import java.util.Iterator;

/**
 *
 * @author sujatas
 */
public class LeaveDetailsDAOImpl extends BaseDAO implements LeaveDetailsDAO {
    protected static final Log log = LogFactory.getLog( LeaveDetailsDAO.class );

        public LeaveDetailsDAOImpl() {
	}
        @SuppressWarnings("unchecked")
    public boolean addLeave(LeaveDetails leaveDetails)throws DAOException
    {

        Session session = null;

		try{

			session = getSession();
                       // session = HRMSHibernateUtil.getSessionFactory().openSession();

			session.beginTransaction();

			log.info("Adding details into database");

			session.saveOrUpdate(leaveDetails);
			session.flush();
			session.getTransaction().commit();
			log.info("done");
		}catch(ConstraintViolationException je){
			log.error("failed to add data due to integrity constratint violation");
			session.getTransaction().rollback();
			throw new DAOException("duplicate value", je.getCause());
		}catch(DataException je){
			log.error("failed to save data due to illegal data");
			session.getTransaction().rollback();
			throw new DAOException("invalid data", je.getCause());
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
			log.error("failed to add Leave data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}


        public LeaveDetails getLeaveDetails() throws DAOException {

		return new LeaveDetails();
	}


public LeaveDetails getLeaveDetails(String id) throws DAOException
{
    try{
    Integer leaveId=new Integer(id);

    return getLeaveDetails(leaveId);

    }
            catch(NumberFormatException ne)
    {
			log.warn("Department ID is not valid");

		}

		return null;
}



    public LeaveDetails getLeaveDetails(Integer leaveid) throws DAOException
    {
        //

                LeaveDetails leaveDetails = null;
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Leave Details");
                         //System.out.println("************In DAOImpl  ======getLeaveDetails()===> Leave type=="+leaveType);
                         System.out.println("LeaveDetails.class==>"+LeaveDetails.class);

			leaveDetails = (LeaveDetails)session.load(LeaveDetails.class,leaveid);
                      System.out.println("Leave Details Object in DAOImpl class 1===="+leaveDetails);
                        log.info("done");
			session.getTransaction().commit();


		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read Leave data from database", e);
			throw new DAOException("wrong leavecode");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Leave data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

  System.out.println("Leave Details Object in DAOImpl class==== 2"+leaveDetails);
		return leaveDetails;



    }







     public List getAllLeaves(String confirmationStatus,Integer designationId)throws DAOException
     {


               List leaveList = null;
		Session session = null;
              //LeaveDetails ld;

		try{

			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Leave");
                        System.out.println("Confirmation status====In DAOImpl=====>"+confirmationStatus+"Designation Id======>"+designationId);
                       
			//leaveList = session.createQuery("select ld.leaveType,ld.leaveid from LeaveDetails ld, LeavePerRole lp where lp.leaveId=ld.leaveid and lp.employeeConfirmationStatus='"+confirmationStatus+"'and lp.flag='E'").list();
                        leaveList=session.createQuery("select ld.leavetype,ld.leaveid from LeaveDetails ld, LeavePerRole lp where lp.leaveId=ld.leaveid and lp.employeeConfirmationStatus='"+confirmationStatus+"'and lp.flag='E'and lp.roleId="+designationId).list();

                        System.out.println("Leave List=======>"+leaveList);

                       /* Iterator itr=leaveList.iterator();
                        while(itr.hasNext())
                        {
                           ld = (LeaveDetails)itr.next();
                           //System.out.println("Leave Details in DAOImpl========>"+ld.getMaxmdays()+"=====>"+ld.getLeaveapplicable()+"Leave type=====>"+ld.getLeaveType()+"Leave id====>"+ld.getLeaveid());

                        }*/
                         session.getTransaction().commit();


		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("===========>failed to read Leave list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return leaveList;
	}


 public List<LeaveDetails> getAllLeaves()throws DAOException
     {


               List<LeaveDetails> leaveList = null;
		Session session = null;
              //LeaveDetails ld;

		try{

			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Leave");
                        //Work on progress
			leaveList = session.createQuery("from LeaveDetails ld").list();

                        System.out.println("Leave List=======>"+leaveList);

                       /* Iterator itr=leaveList.iterator();
                        while(itr.hasNext())
                        {
                           ld = (LeaveDetails)itr.next();
                           //System.out.println("Leave Details in DAOImpl========>"+ld.getMaxmdays()+"=====>"+ld.getLeaveapplicable()+"Leave type=====>"+ld.getLeaveType()+"Leave id====>"+ld.getLeaveid());

                        }*/
                         session.getTransaction().commit();


		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("===========>failed to read Leave list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return leaveList;
	}



     }





