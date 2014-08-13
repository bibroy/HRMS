/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.TrainingPositionDAO;
import com.pojo.City;
import com.pojo.TrainingPosition;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author ranjans
 */
public class TrainingPositionDAOImpl extends BaseDAO implements TrainingPositionDAO  {

     protected static final Log log = LogFactory.getLog( TrainingPositionDAO.class );
        public TrainingPositionDAOImpl() {
	}
    public boolean save(TrainingPosition trainingPosition) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public boolean delete(TrainingPosition trainingPosition) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public TrainingPosition getPosition(TrainingPosition trainingPosition) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TrainingPosition> getPositions(TrainingPosition trainingPosition) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TrainingPosition> getAllEnablePositions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TrainingPosition> getAllPositions() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
