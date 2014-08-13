/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.TrainingRequestEmployee;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface TrainingEmployeeTransactionDAO {



    public BigDecimal getLastRequestId() throws DAOException ;
    /***
     * 
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     */
    public boolean addUpdateValue(TrainingRequestEmployee trainingRequestEmployee)throws DAOException;
    /***
     * 
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     */
    public boolean addUpdateValues(List<TrainingRequestEmployee> trainingRequestEmployee) throws DAOException;

    /***
     * Select value
     * base on trainingRequestId
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     */
    public TrainingRequestEmployee selectValue(TrainingRequestEmployee trainingRequestEmployee)throws DAOException;

    /***
     * Select values
     * based on trainingRequestId
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     */
    public List<TrainingRequestEmployee> selectValues(List<TrainingRequestEmployee> trainingRequestEmployee)throws DAOException;

    /***
     * 
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     */
    public TrainingRequestEmployee selectValueAgainstTraining(TrainingRequestEmployee trainingRequestEmployee)throws DAOException;

    /***
     * 
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     */
    public List<TrainingRequestEmployee> selectValuesAgainstTraining(List<TrainingRequestEmployee> trainingRequestEmployee)throws DAOException;
    
    /***
     * Select a particular employee detail
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     */
    public TrainingRequestEmployee selectValueAgainstEmployee(TrainingRequestEmployee trainingRequestEmployee)throws DAOException;

    /***
     * Select List of employee detail
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     */
    public List<TrainingRequestEmployee> selectValuesAgainstEmployee(List<TrainingRequestEmployee> trainingRequestEmployee)throws DAOException;

    /***
     * Select Induction training value
     * against particular employee
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     */
    public TrainingRequestEmployee selectInValueAgainstEmployee(TrainingRequestEmployee trainingRequestEmployee)throws DAOException;
   
}