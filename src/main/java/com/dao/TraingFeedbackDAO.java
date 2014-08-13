/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

/**
 *
 * @author pradipto roy
 */
import com.pojo.TrainingSchedule;
import com.pojo.TrainerFeedback;
import java.math.BigDecimal;
import java.util.List;

public interface TraingFeedbackDAO {

    public List<TrainingSchedule>getTrainingScheduleByID(String traingname) throws DAOException;
    public boolean save(TrainerFeedback tr) throws DAOException;
    public Integer getRequestbyID()throws DAOException;
    public List<TrainerFeedback> getTrainingFeedbackbyTrnID(String trainingID) throws DAOException;



}
