/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.CompanyDAO;
import com.dao.DAOException;
import com.pojo.Company;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author dolad
 */
public class CompanyDAOImpl extends BaseDAO implements CompanyDAO {

        protected static final Log log = LogFactory.getLog( CompanyDAO.class );
        public CompanyDAOImpl() {
	}
        @SuppressWarnings("unchecked")
	public List<Company> getAllCompany() throws DAOException {

		List<Company> companyList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Company");
			companyList = session.createQuery("from Company c").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Company list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return companyList;
	}


        public BigDecimal getLastRequestId() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(companyCode) from Company").list();
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



	public Company getCompany() throws DAOException {

		return new Company();
	}


	public Company getCompany(String companyId) throws DAOException {

		try{
			Integer cId = new Integer(companyId);
			return getCompany(cId);

		}catch(NumberFormatException ne){
			log.warn("Plant ID is not valid");

		}

		return null;
	}


	public Company getCompany(Integer companyId) throws DAOException {
		Company company = null;
		Session session = null;
                BigDecimal b=new BigDecimal(companyId.intValue());
		if(companyId==null) {
			throw new DAOException("failed to fetch data for \"null\" company id");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Company Detail");
			company = (Company)session.load(Company.class, b);
                        if(company !=null){
                            String name=company.getCompanyName();
                            name=null;
                        }
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read Company data from database", e);
			throw new DAOException("wrong compamy code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Company data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return company;
	}


	public Company getCompanyByCode(String companyCode) throws DAOException {

		return null;
	}


	public boolean save(Company company) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving company details into database");
			session.saveOrUpdate(company);
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

    public List<Company> getAllGrpCompany() throws DAOException {
        List<Company> compList=null;
        Session session=null;
        try {
            session=getSession();
            session.beginTransaction();
            compList=session.createQuery("from Company c where c.companyTypeid=2").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching group company list "+ e);
        }
        return compList;
    }

}
