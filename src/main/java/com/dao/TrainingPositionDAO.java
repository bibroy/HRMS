/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.City;
import com.pojo.TrainingPosition;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface TrainingPositionDAO {
    /***
     * save a particular
     * Training position
     * @param trainingPosition
     * @return
     */
    public boolean save(TrainingPosition trainingPosition)throws DAOException;
    /***
     * Soft delete a particular position
     * @param trainingPosition
     * @return
     */
    public boolean delete(TrainingPosition trainingPosition)throws DAOException;
    /***
     * Get a particular Position
     * Against some parameter
     * @param trainingPosition
     * @return
     */
    public TrainingPosition getPosition(TrainingPosition trainingPosition)throws DAOException;
    /***
     * 
     * @param trainingPosition
     * @return
     */
    public List<TrainingPosition> getPositions(TrainingPosition trainingPosition)throws DAOException;

    /***
     * Get all enable
     * position position
     * Whoes status is Y
     * @return
     */
    public List<TrainingPosition> getAllEnablePositions()throws DAOException;

    /***
     * Get all enable
     * position position
     * Whoes status is Y
     * @return
     */
    public List<TrainingPosition> getAllPositions()throws DAOException;
    
}
