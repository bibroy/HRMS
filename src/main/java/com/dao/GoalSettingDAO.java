/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.GoalSetting;
import java.util.List;
import com.util.GoalPriority;

/**
 *
 * @author Sumit Kumar
 */
public interface GoalSettingDAO {

    /**
     *
     * @param g
     * @return
     * @throws DAOException
     */
    public boolean saveGoal(GoalSetting g) throws DAOException;

    /**
     * 
     * @return
     * @throws DAOException
     */
    public List<GoalSetting> getAllGoalSetting() throws DAOException;

    /**
     *
     * @param empid
     * @return
     * @throws DAOException
     */
    public List<GoalSetting> getGoalByEmpId(String empid) throws DAOException;

    /**
     *
     * @param gp accepts com.util.GoalPriority type values
     * @return
     * @throws DAOException
     */
    public List<GoalSetting> getGoalByPriority(GoalPriority gp, String empid) throws DAOException;

    public List<GoalSetting> getInitiatedGoalByEmpId(String empid)throws DAOException;
    
    public Integer getLastId()throws DAOException;

    public GoalSetting getGoalById(Integer id)throws DAOException;
}
