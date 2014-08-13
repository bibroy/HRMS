/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;


import com.dao.BaseDAO;
import com.dao.CityDAO;
import com.dao.DAOException;
import com.pojo.City;
import java.util.AbstractList;
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
 * @author sudipb
 */

    public class CityDAOImpl extends BaseDAO implements CityDAO {

        protected static final Log log = LogFactory.getLog( CityDAO.class );
        public CityDAOImpl() {
	}
        @SuppressWarnings("unchecked")
	public List<City> getAllCity() throws DAOException {

		List<City> cityList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Countries");
			cityList = session.createQuery("from City c where c.status='Y'").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read City list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return cityList;
	}


	public City getCity() throws DAOException {

		return new City();
	}


	public City getCity(String city_code) throws DAOException {

		try{
			Integer cId = new Integer(city_code);
			return getCity(cId);

		}catch(NumberFormatException ne){
			log.warn("country code is not valid");

		}

		return null;
	}


	public City getCity(Integer city_code) throws DAOException {
		City city = null;
		Session session = null;
BigDecimal b=new BigDecimal(city_code);
		if(city_code==null) {
			throw new DAOException("failed to fetch data for \"null\" company id");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Company Detail");
			city = (City)session.load(City.class,b);
                        
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

		return city;
	}


	public City getCityByCode(String cityCode) throws DAOException {

		return null;
	}


	public boolean save(City city) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving company details into database");
			session.saveOrUpdate(city);
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

     public List<City> getAllCityByStateCode(Integer stateCode) throws DAOException {

        List<City> cityList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active City");
            String qry = "from City c where c.status='Y' and c.state_id='" + stateCode + "'";
            System.out.print("*************QRY*****" + qry + "****************");
            cityList = session.createQuery(qry).list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read City list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }


            return cityList;
        }

    }

    public List<City> getAllCityByCountryCode(Integer countryCode) throws DAOException {
        List<City> list=null;
        Session session=null;
        try {
            session=getSession();
            session.beginTransaction();
            list=session.createQuery("from City c where c.countryMaster="+countryCode ).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("unable to fetch city list "+e);
        }
        return list;
    }


}
