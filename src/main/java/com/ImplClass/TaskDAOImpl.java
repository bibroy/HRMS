/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.ProjectDAO;
import com.dao.TaskDAO;
import com.pojo.Project;
import com.pojo.Task;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/**
 *
 * @author dolad
 */
public class TaskDAOImpl extends BaseDAO implements TaskDAO {
        protected static final Log log = LogFactory.getLog(TaskDAO.class );
        public TaskDAOImpl() {

	}
        @SuppressWarnings("unchecked")
	public List<Task> getAllTask() throws DAOException {

		List<Task> taskList = null;
		Session session = null;


		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Task ");
			//taskList = session.createQuery("from Task t where t.status='active'").list();
                        taskList = session.createQuery("from Task t").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Task list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return taskList;
	}
        public Task getTask(Integer taskId) throws DAOException {
		Task task = null;
		Session session = null;

		if(taskId==null) {
			throw new DAOException("failed to fetch data for \"null\" task  id");
		}


		try{
			session = getSession();
			session.beginTransaction();
			log.info("fetching Task Detail");
			task = (Task)session.load(Task.class, taskId);
			log.info("done");
			session.getTransaction().commit();

		}catch(ObjectNotFoundException e){
			session.getTransaction().rollback();
			log.error("failed to read Task from database", e);
			throw new DAOException("wrong Client Group code");
		}
		catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Task from database", e);
			throw new DAOException("unknown error");
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return task;
	}





	public boolean save(Task task) throws DAOException {
		Session session = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("saving Task details into database");
			session.saveOrUpdate(task);
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
			log.error("failed to save Task data into database", e);
			throw new DAOException("unknown error",e.getCause());

		}finally{
			if(session!=null)
				session.close();
		}

		return true;
	}
}
