/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.TrainningType;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface  TrainingTypeDAO {

    /***
     * Select All Training Type
     * @return
     * @throws DAOException
     */
    public List<TrainningType> getAllTrainingType()throws DAOException;

    /***
    * Add a training Type
    * @param trainningType
    * @return
    * @throws DAOException
    */
    public boolean addTrainingType(TrainningType trainningType)throws DAOException;

    /***
     * Update Training Type
     * @param trainningType
     * @return
     * @throws DAOException
     */
    public boolean updateTrainingType(TrainningType trainningType)throws DAOException;
}
