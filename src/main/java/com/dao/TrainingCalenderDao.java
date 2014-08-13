/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.TraingCalender;
import java.util.List;
/**
 *
 * @author Pradipto Roy
 */
public interface TrainingCalenderDao {
    public boolean save(TraingCalender obj)throws DAOException;
public Integer getLastRequestId() throws DAOException;
public List<TraingCalender> getTrainingNamesDetails() throws DAOException;
public List<TraingCalender> getTrainingDetailsCheck(String trainingname,String startdate,String enddate)throws DAOException;


}
