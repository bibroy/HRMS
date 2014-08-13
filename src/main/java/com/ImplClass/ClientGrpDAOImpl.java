/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.ClientGrpDAO;
import com.dao.DAOException;
import com.pojo.ClientGroup;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/***
 *
 * @author shrayanti
 */
public class ClientGrpDAOImpl extends BaseDAO implements ClientGrpDAO{
    protected static final Log log = LogFactory.getLog( ClientGrpDAO.class );
        public ClientGrpDAOImpl() {
	}
      
	public List<ClientGroup> getAllClientGrp() throws DAOException {

		List<ClientGroup> clientGrpList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Client Group");
			clientGrpList = session.createQuery("from ClientGroup c where c.grStatus='Y'").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read ClientGrp list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return clientGrpList;
	}
        /***
         *
         * @param grId
         * @return
         * @throws DAOException
         */
        public ClientGroup getClientGrp(Integer grId) throws DAOException {
		ClientGroup clientGrp = null;
		Session session = null;

		if(grId==null) {
			throw new DAOException("failed to fetch data for \"null\" client Grp id");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Client Group Detail");
			clientGrp = (ClientGroup)session.load(ClientGroup.class, grId);
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read Client Group data from database", e);
			throw new DAOException("wrong Client Group code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Client Group data from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return clientGrp;
	}


/**
 * 
 * @param clientGrp
 * @return
 * @throws DAOException
 */


	public boolean save(ClientGroup clientGrp) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving clientGrp details into database");
			session.saveOrUpdate(clientGrp);
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
			log.error("failed to save clientGrp data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}

}
