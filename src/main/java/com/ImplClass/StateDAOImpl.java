/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.StateDAO;
import com.dao.DAOException;
import com.pojo.State;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;
/**
 *
 * @author swarnendum
 */

    public class StateDAOImpl extends BaseDAO implements StateDAO {

        protected static final Log log = LogFactory.getLog( StateDAO.class );
        public StateDAOImpl() {
	}
        @SuppressWarnings("unchecked")
	public List<State> getAllState() throws DAOException {

		List<State> stateList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active States");
			stateList = session.createQuery("from State s where s.status='Y'").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read State list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return stateList;
	}


	public State getState() throws DAOException {

		return new State();
	}


	public State getState(String state_code) throws DAOException {

		try{
			Integer sId = new Integer(state_code);
			return getState(sId);

		}catch(NumberFormatException ne){
			log.warn("state code is not valid");

		}

		return null;
	}


	public State getState(Integer state_code) throws DAOException {
		State state = null;
		Session session = null;
                BigDecimal b=new BigDecimal(state_code);

		if(state_code==null) {
			throw new DAOException("failed to fetch data for \"null\" company id");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Company Detail");
			state = (State)session.load(State.class,b);
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read state data from database", e);
			throw new DAOException("wrong country code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Country data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return state;
	}


	public State getStateByCode(String stateCode) throws DAOException {

		return null;
	}


	public boolean save(State state) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving state details into database");
			session.saveOrUpdate(state);
			session.flush();
			session.getTransaction().commit();
			log.info("done");
		}catch(ConstraintViolationException je){
			log.error("failed to save data due to integrity constratint violation");
			session.getTransaction().rollback();
			throw new DAOException("duplicate value", je.getCause());
		}catch(DataException je){
			log.error("failed to save data due to illegal data");
			session.getTransaction().rollback();
			throw new DAOException("invalid data", je.getCause());
		}catch(Exception e){
			e.printStackTrace();
			session.getTransaction().rollback();
			log.error("failed to save company data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}

     public List<State> getAllStateByCountryCode(Integer countryCode) throws DAOException {

        List<State> stateList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active States");
            String qry = "from State s where s.status='Y' and s.country_id='" + countryCode + "'";
            System.out.print("*************QRY*****" + qry + "****************");
            stateList = session.createQuery(qry).list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read State list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }


            return stateList;
        }

    }

}