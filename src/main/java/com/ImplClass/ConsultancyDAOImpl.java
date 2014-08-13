/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.ConsultancyDAO;
import com.dao.DAOException;
import com.pojo.Consultancy;
import com.pojo.Skills;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

/**
 *
 * @author ranjans
 */
public class ConsultancyDAOImpl extends BaseDAO implements ConsultancyDAO{

    protected static final Log log = LogFactory.getLog( ConsultancyDAO.class );

    /***
     * 
     */
    public ConsultancyDAOImpl() {
    }

    /***
     * 
     * @param consultancy
     * @return
     * @throws DAOException
     */
    public boolean addConsultancy(Consultancy consultancy) throws DAOException {
         boolean flag=false;
        Session session = null;
        try{
            session= getSession();
            session.beginTransaction();
            session.saveOrUpdate(consultancy);
            session.getTransaction().commit();
            log.info("Add Skills");
            flag=true;
        }catch(Exception ex){
            session.getTransaction().rollback();
            log.error("Failed to add", ex);
        }finally{
            if(session!=null) {
				session.flush();
				session.close();
			}
        }
        return flag;
    }

    /***
     * 
     * @param consultancy
     * @return
     * @throws DAOException
     */
    public boolean updateConsultancy(Consultancy consultancy) throws DAOException {
        boolean flag=false;
        Session session = null;
        try{
            session= getSession();
            session.beginTransaction();
            session.saveOrUpdate(consultancy);
            session.getTransaction().commit();
            log.info("Update Skills");
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

    /***
     * 
     * @param consultancy
     * @return
     * @throws DAOException
     */
    public boolean deleteConsultancy(Consultancy consultancy) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /***
     * Search a particular Consultancy detail against ConsultancyId
     * @param consultancy
     * @return
     * @throws DAOException
     */
    public Consultancy searchConsultancy(Consultancy consultancy) throws DAOException {
        Consultancy consultancyReturn = null;
		Session session = null;

		if(consultancy.getConsultancyId()==0) {
			throw new DAOException("failed to fetch data for \"null\" Consultancy id");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Consultancy Detail");
			consultancyReturn = (Consultancy)session.get(Consultancy.class,consultancy.getConsultancyId());
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read Consultancy data from database", e);
			throw new DAOException("wrong country code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Consultancy data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}
                return consultancyReturn;
    }

    /***
     * 
     * @param skills
     * @return
     * @throws DAOException
     */
    public List<Consultancy> searchConsultancybySkill(Skills skills) throws DAOException {
              List<Consultancy> consultancyReturn = null;
		Session session = null;

		if(skills.getSkillId()==0) {
			throw new DAOException("failed to fetch data for \"null\" Skill id");
		}

		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Consultancy Detail");
			//consultancyReturn = (Consultancy)session.get(Consultancy.class,consultancy.getConsultancyId());
			consultancyReturn =session.createQuery("from Consultancy c where status='A' and skillId=:skillId").setParameter("skillId",skills.getSkillId(),Hibernate.INTEGER).list();
                        log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read Consultancy data from database", e);
			throw new DAOException("wrong country code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Consultancy data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}
                return consultancyReturn;
    }

    /***
     * View All consultancy whoes status code is Active 'A'
     * @return
     * @throws DAOException
     */
    public List<Consultancy> searchConsultancies() throws DAOException {
        Session session = null;
		List<Consultancy> consultancy = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Department");
			// consultancy = session.createQuery("from Consultancy c where c.status='A'").list();
                        consultancy = session.createQuery("from Consultancy c where c.status='A' and consultancyName!=''").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read consultancy list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return consultancy;
    }

    /***
     * 
     * @return
     * @throws DAOException
     */
    public List<Consultancy> searchAllConsultancies() throws DAOException {
        Session session = null;
		List<Consultancy> consultancy = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Department");
			consultancy = session.createQuery("from Consultancy c where c.status='A'").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read skills list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return consultancy;
    }

}
