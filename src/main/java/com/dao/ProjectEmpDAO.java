/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.ProjectEmp;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author Sumit Kumar
 */
public interface ProjectEmpDAO {
    /**
     *
     * @param pe
     * @return
     * @throws DAOException
     */
    public boolean save(ProjectEmp pe)throws DAOException;
    /**
     *
     * @param projId
     * @return
     * @throws DAOException
     */
    public List<ProjectEmp> getAllEmpByProj(BigDecimal projId)throws DAOException;
    /**
     *
     * @param jobId
     * @return
     * @throws DAOException
     */
    public List<ProjectEmp> getAllEmpByJob(BigDecimal jobId)throws DAOException;

    /**
     * gets list of employee to whom no task is  assigned
     * @return
     * @throws DAOException
     */
    public List getIdleEmployee()throws DAOException;

    public BigDecimal getLastId()throws DAOException;

    public ProjectEmp getProjByEmpId(String empId)throws DAOException;
}
