/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Department;
import com.pojo.Training;
import java.util.List;
import java.util.Map;
import com.util.TrainingDetail;
import com.pojo.TrainingRequestMaster;
import com.util.TrainingNeeds;


/**
 *
 * @author ranjans
 */
public interface TrainingDAO {

    /**
     * Use for get a particular trainingobject against training Id
     * @param trainingId
     * @return
     * @throws DAOException
     */
    public TrainingDetail getTrainingDtl(int trainingId) throws DAOException;

    /***
     * get the training details for report without status state
     * @return
     * @throws DAOException
     */
    public List<Training> getAllTrainingDtls() throws DAOException;

    /**
     * get the training details for report where Status is not hold
     * @return
     * @throws DAOException
     */
    public List<Training> getTrainingDtls() throws DAOException;

    /**
     * Use for change status of a training
     * @param trainingId
     * @param status
     * @return
     * @throws DAOException
     */
    public boolean changeStatus(int trainingId, String status) throws DAOException;

    /**
     * Usefor add training detail
     * @param training
     * @return
     * @throws DAOException
     */
    public boolean addTrainingDtl(Training training) throws DAOException;

    /**
     * Use for update Training Detail
     * @param training
     * @return
     * @throws DAOException
     */
    public boolean updateTrainingDtl(Training training) throws DAOException;

    /**
     * get the training details for report where Status is not hold
     * and have a departmentId
     * @return
     * @throws DAOException
     */
    public List<Training> getTrainingDtlsAgainstDepartment(int departmentId) throws DAOException;

    /**
     * get the training details for report
     * where Status is not hold
     * and have a skillId
     * @return
     * @throws DAOException
     */
    public List<Training> getTrainingDtlsAgainstSkill(String skillId) throws DAOException;

    /**
     * Use for get  trainingobject 
     * @param trainingId
     * @return
     * @throws DAOException
     */
    public List<TrainingDetail> getTrainingDtlsReport() throws DAOException;

    /***
     * Get Training Internal and External Report
     * @return
     * @throws DAOException
     */
    public List<TrainingDetail> getTrainingIEReport(String trainingType) throws DAOException;

    /**
     * Get Department name and Id against
     * CompanyCode and status is 'Y'
     * @param deptCode
     * @return
     * @throws DAOException
     */
    public List<Department> getDeptByCompCode(String deptCode) throws DAOException;

    /***
     * Pick up required parameters
     * DepartmentCode as deptCode
     * Employee ID as employeeId
     * CompanyCode as companyCode
     * Job Type as jobType
     * It is not now in system
     * @param empId
     * @return
     * @throws DAOException
     */
    public Map<String, String> getRequireParaetersForTraining(String empId) throws DAOException;

    public List<TrainingRequestMaster> getTrainingStatusReport() throws DAOException;
    public TrainingRequestMaster getTrainingDetailsByRequestID(String requestID ) throws DAOException;
    public List<TrainingNeeds> getTrainingNeedsReportsForEmployees() throws DAOException;
}
