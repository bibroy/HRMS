package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.LoginDAO;
import com.pojo.Login;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/**
 *
 * @author Swarnendu Mukherjee
 */



public class LoginDAOImpl extends BaseDAO implements LoginDAO {

    protected static final Log log = LogFactory.getLog(LoginDAO.class);

    public LoginDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<Login> checkAuthentication(String user_id, String password) throws DAOException {

        List<Login> authentication = null;
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Appraisal forms");
            authentication = session.createQuery("from Login where user_id='"+user_id+"' and password='"+password+"'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Login list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return authentication;
    }

    public Login getLogin() throws DAOException {
		return new Login();
	}
    
	/* public Login getLogin(String user_id) throws DAOException {

		try{
			String uId = new String(user_id);
			return getLogin(uId);

		}catch(NumberFormatException ne){
			log.warn("Category Code is not valid");

		}

		return null;
	}
  */
	public Login getLogin(String uid) throws DAOException {
		Login login =null;
		Session session = null;

		if(uid==null) {
			throw new DAOException("failed to fetch data for \"null\" Category code");
		}

		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Company Detail");
			login = (Login)session.load(Login.class,uid);
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read Appraisal Category data from database", e);
			throw new DAOException("wrong Category code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Appraisal data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return login;
	}

	public Login getLoginByUserId(String user_id) throws DAOException {

		return null;
	}

        public boolean save(Login login) throws DAOException {
		Session session = null;

		try{
			session = getSession();
                        System.out.println("saving login info");
			session.beginTransaction();
			session.saveOrUpdate(login);
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
			log.error("failed to save  data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}
}