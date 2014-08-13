/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.ClientDAO;
import com.dao.DAOException;
import com.pojo.Client;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/**
 * 
 * @author shrayanti
 */
public class ClientDAOImpl extends BaseDAO implements ClientDAO{
        protected static final Log log = LogFactory.getLog( ClientDAO.class );
        public ClientDAOImpl() {
	}
        @SuppressWarnings("unchecked")
	public List<Client> getAllClient() throws DAOException {

		List<Client> clientList = null;
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Client ");
			clientList = session.createQuery("from Client c where c.status='Y'").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Client list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return clientList;
	}
        public Client getClient(Integer clId) throws DAOException {
		Client client = null;
		Session session = null;

		if(clId==null) {
			throw new DAOException("failed to fetch data for \"null\" client  id");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Client Group Detail");
			client = (Client)session.get(Client.class, clId);
                        if(client==null)
                        {

                            client=(Client)session.load(Client.class,clId);

                        }
                        if(session.isOpen())
                        {
                            client.getClId();
                        }
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

		return client;
	}





	public boolean save(Client client) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving client details into database");
			session.saveOrUpdate(client);
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
			log.error("failed to save client data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}


         public List<Client> getAllClientByClientgroup(long clientGrpid) throws DAOException {

		List<Client> clientList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active States");
                        String qry="from Client c where c.status='Y' and c.clientGrpid='"+clientGrpid+"'";
			System.out.print("*************QRY*****"+qry+"****************");
                        clientList = session.createQuery(qry).list();
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


		return clientList;
	}

        }


}
