/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.TrainingSchedule;

/**
 *
 * @author pradipto roy
 */
public interface TrianingSheduleDAO {

    public boolean save(TrainingSchedule trangshedule) throws DAOException;

}
