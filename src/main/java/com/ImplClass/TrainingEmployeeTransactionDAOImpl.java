/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.TrainingEmployeeTransactionDAO;
import com.pojo.TrainingRequestEmployee;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

/**
 *
 * @author ranjans
 */
public class TrainingEmployeeTransactionDAOImpl extends BaseDAO  implements TrainingEmployeeTransactionDAO{

    protected static final Log log = LogFactory.getLog(TrainingEmployeeTransactionDAO.class );

    public TrainingEmployeeTransactionDAOImpl() {
    }

    public boolean addUpdateValue(TrainingRequestEmployee trainingRequestEmployee) throws DAOException {
        boolean flag=false;
        Session session = null;
        try{
            session= getSession();
            session.beginTransaction();
            session.saveOrUpdate(trainingRequestEmployee);
            session.getTransaction().commit();
            log.info("Add Skills");
            flag=true;
        }catch(Exception ex){
            session.getTransaction().rollback();
            log.error("Failed to update", ex);
        }finally{
            if(session!=null) {
				session.flush();
				session.close();
			}
        }
        return flag;
    }

     public BigDecimal getLastRequestId() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(trainingRequestId) from TrainingRequestEmployee").list();
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

    public boolean addUpdateValues(List<TrainingRequestEmployee> trainingRequestEmployee) throws DAOException {
        boolean flag=false;
        
        Iterator<TrainingRequestEmployee> trainingReqIt=trainingRequestEmployee.iterator();
        try{
            while(trainingReqIt.hasNext()){
                addUpdateValue(trainingReqIt.next());
            }
            log.info("Add Skills");
            flag=true;
        }catch(Exception ex){
            
            log.error("Failed to update", ex);
        }finally{
            
        }
        return flag;
    }

    public TrainingRequestEmployee selectValue(TrainingRequestEmployee trainingRequestEmployee) throws DAOException {
                TrainingRequestEmployee trainingRequestEmployeeReturn = null;
		Session session = null;

		if(trainingRequestEmployeeReturn.getTrainingRequestId()==BigDecimal.ZERO) {
			throw new DAOException("failed to fetch data for \"null\" training request id");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Company Detail");
			trainingRequestEmployeeReturn = (TrainingRequestEmployee)session.get(TrainingRequestEmployee.class,trainingRequestEmployeeReturn.getTrainingRequestId());
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read City data from database", e);
			throw new DAOException("wrong country code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read City data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}
                return trainingRequestEmployeeReturn;
    }

    public List<TrainingRequestEmployee> selectValues(List<TrainingRequestEmployee> trainingRequestEmployee) throws DAOException {
        boolean flag=false;
        Iterator<TrainingRequestEmployee> trainingReqIt=trainingRequestEmployee.iterator();
        List<TrainingRequestEmployee> trainingRequestEmployeeReturn=new ArrayList<TrainingRequestEmployee>();
        try{
            while(trainingReqIt.hasNext()){
               trainingRequestEmployeeReturn.add(selectValue(trainingReqIt.next()));
            }
            log.info("Add Skills");
            flag=true;
        }catch(Exception ex){

            log.error("Failed to update", ex);
        }finally{

        }
        return trainingRequestEmployeeReturn;
    }

    public TrainingRequestEmployee selectValueAgainstTraining(TrainingRequestEmployee trainingRequestEmployee) throws DAOException {

                TrainingRequestEmployee trainingRequestEmployeeReturn = null;
		Session session = null;

		if(trainingRequestEmployeeReturn.getTrainingRequestId()==BigDecimal.ZERO) {
			throw new DAOException("failed to fetch data for \"null\" training request id");
		}


		try{
			trainingRequestEmployeeReturn=new TrainingRequestEmployee();
                        session = getSession();
			session.beginTransaction();
			log.info("fetching Company Detail");
			trainingRequestEmployeeReturn = (TrainingRequestEmployee)session.createQuery("from TrainingRequestEmployee where requestId="+trainingRequestEmployee.getRequestId()+" and flag='"+trainingRequestEmployee.getFlag()+"' and employeeId="+trainingRequestEmployee.getEmployeeId());
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read City data from database", e);
			throw new DAOException("wrong country code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read City data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}
                return trainingRequestEmployeeReturn;
    }

    public List<TrainingRequestEmployee> selectValuesAgainstTraining(List<TrainingRequestEmployee> trainingRequestEmployee) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /***
     * Select value against
     * employee Id and request Id
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     */
    public TrainingRequestEmployee selectValueAgainstEmployee(TrainingRequestEmployee trainingRequestEmployee) throws DAOException {

                TrainingRequestEmployee trainingRequestEmployeeReturn = null;
		Session session = null;

		if(trainingRequestEmployeeReturn.getTrainingRequestId()==BigDecimal.ZERO) {
			throw new DAOException("failed to fetch data for \"null\" training request id");
		}
		try{
			trainingRequestEmployeeReturn=new TrainingRequestEmployee();
                        session = getSession();
			session.beginTransaction();
			log.info("fetching Company Detail");
			trainingRequestEmployeeReturn = (TrainingRequestEmployee)session.createQuery("from TrainingRequestEmployee where employeeId="+trainingRequestEmployee.getEmployeeId()+" and requestId="+trainingRequestEmployee.getRequestId());
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read City data from database", e);
			throw new DAOException("wrong country code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read City data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}
                return trainingRequestEmployeeReturn;
    }
    /***
     * 
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     */
    public List<TrainingRequestEmployee> selectValuesAgainstEmployee(List<TrainingRequestEmployee> trainingRequestEmployee) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    /***
     * Select Induction Training value
     * against employeeId and Induction flag
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     */
    public TrainingRequestEmployee selectInValueAgainstEmployee(TrainingRequestEmployee trainingRequestEmployee) throws DAOException {
        List<TrainingRequestEmployee> trainingRequestEmployees = null;
        Iterator<TrainingRequestEmployee> itr=null;
        TrainingRequestEmployee trainingRequestEmployeeReturn=null;
		Session session = null;

		if(trainingRequestEmployee.getEmployeeId()==BigDecimal.ZERO) {
			throw new DAOException("failed to fetch data for \"null\" employee id");
		}
		try{
			trainingRequestEmployeeReturn=new TrainingRequestEmployee();
                        session = getSession();
			session.beginTransaction();
                        Object obj[] = null;
			log.info("fetching Company Detail");
			// === trainingRequestEmployeeReturn = (TrainingRequestEmployee)session.createQuery("from TrainingRequestEmployee where employeeId="+trainingRequestEmployee.getEmployeeId()+" and requestId="+trainingRequestEmployee.getRequestId()+" and flag='INTRINI'");
                        trainingRequestEmployees = session.createQuery("from TrainingRequestEmployee where employeeId="+trainingRequestEmployee.getEmployeeId()+"  and flag='INTRINI'").list();
			itr=trainingRequestEmployees.iterator();
                        while(itr.hasNext()){
                          trainingRequestEmployeeReturn=(TrainingRequestEmployee) itr.next();
                        }
                        log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read City data from database", e);
			throw new DAOException("wrong country code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read City data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}
                return trainingRequestEmployeeReturn;
    }
    
}
