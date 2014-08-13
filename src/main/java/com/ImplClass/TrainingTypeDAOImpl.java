/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.TrainingDAO;
import com.dao.TrainingTypeDAO;
import com.pojo.Department;
import com.pojo.Training;
import com.pojo.TrainningType;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import com.util.TrainingDetail;

/**
 *
 * @author ranjans
 */
public class TrainingTypeDAOImpl extends BaseDAO implements TrainingTypeDAO{

    protected static final Log log = LogFactory.getLog( TrainingDAO.class );

    public TrainingTypeDAOImpl() {
    }

    

    public List<TrainningType> getAllTrainingType() throws DAOException {

        List<TrainningType> trainingTypeList=null;
        Session session =null;

        try{
            session = getSession();
            session.beginTransaction();
            trainingTypeList=session.createQuery("from TrainningType").list();
            session.getTransaction().commit();
             log.info("Fetching all initiated Training Type");
        }catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read Training list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

        return trainingTypeList;
    }

    public boolean addTrainingType(TrainningType trainningType) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean updateTrainingType(TrainningType trainningType) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
