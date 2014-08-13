/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;


import com.dao.BaseDAO;
import com.dao.CountryDAO;
import com.dao.DAOException;

import com.pojo.CountryMaster;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;
import java.math.BigDecimal;
/**
 *
 * @author Shrayanti Bhattacharyya
 */

    public class CountryDAOImpl extends BaseDAO implements CountryDAO {

        protected static final Log log = LogFactory.getLog( CountryDAO.class );
        public CountryDAOImpl() {
	}
        @SuppressWarnings("unchecked")
	public List<CountryMaster> getAllCountry() throws DAOException {

		List<CountryMaster> countryList = null;
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Countries");
			countryList = session.createQuery("from CountryMaster c where c.status='Y'").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Country list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return countryList;
	}


	public CountryMaster getCountry() throws DAOException {

		return new CountryMaster();
	}


	public CountryMaster getCountry(String countryId) throws DAOException {

		try{
			Integer cId = new Integer(countryId);
			return getCountry(cId);

		}catch(NumberFormatException ne){
			log.warn("country code is not valid");

		}

		return null;
	}


	public CountryMaster getCountry(Integer countryId) throws DAOException {
		CountryMaster country = null;
		Session session = null;
BigDecimal b=new BigDecimal(countryId);
		if(countryId==null) {
			throw new DAOException("failed to fetch data for \"null\" company id");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Company Detail");
			country = (CountryMaster)session.load(CountryMaster.class,b);
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read Country data from database", e);
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

		return country;
	}

public boolean save(CountryMaster country) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving COUNTRY details into database");
			session.saveOrUpdate(country);
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



}
