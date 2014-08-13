/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.ProjectJobs;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author Sumit Kumar
 */
public interface ProjectJobsDAO {
    /**
     * 
     * @param pj
     * @return
     * @throws DAOException
     */
    public boolean save(ProjectJobs pj)throws DAOException;
    /**
     *
     * @return
     * @throws DAOException
     */
    public List<ProjectJobs> getAllJobs()throws DAOException;
    /**
     *
     * @param id
     * @return
     * @throws DAOException
     */
    public ProjectJobs getJobById(BigDecimal id)throws DAOException;
    /**
     *
     * @param projId
     * @return
     * @throws DAOException
     */
    public List<ProjectJobs> getAllJobsByProj(BigDecimal projId)throws DAOException;

    public BigDecimal getLastId()throws DAOException;

}
