/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.Department;
import com.pojo.JobType;
import java.util.List;

/**
 *
 * @author ranjans
 */

public interface JobTypeDAO {

    /***
     * Insert JobType
     * @param jobType
     * @return
     * @throws DAOException
     */
    public boolean insertJobType(JobType jobType)throws DAOException;
    /***
     * Update the JobType
     * @param jobType
     * @return
     * @throws DAOException
     */
    public boolean updateJobType(JobType jobType)throws DAOException;
    /***
     * Soft delet the JobType
     * @param jobType
     * @return
     * @throws DAOException
     */
    public boolean deleteJobType(JobType jobType)throws DAOException;
    /***
     * get JobType against depertment
     * @param depertment
     * @return
     * @throws DAOException
     */
    public List<JobType>getJobTypeAgainstDepertment(JobType jobType)throws DAOException;
    /***
     * Get JobType Details
     * Against particlar typeId
     * @param jobType
     * @return
     * @throws DAOException
     */
    public JobType getJobType(JobType jobType)throws DAOException;
    /***
     * gett all
     * JobType wher status is 'Y'
     * @return
     * @throws DAOException
     */
    public List<JobType> getAllJobType() throws DAOException;

    public Integer getLastId()throws DAOException;

   
    public List<JobType> getJobtypeByComanyDepartmentID(String departmentid,String companyid) throws DAOException;

}