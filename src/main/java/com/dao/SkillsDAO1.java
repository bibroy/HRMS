/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.Department;
import com.pojo.Skills;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface SkillsDAO1 {

    /***
     *
     * @return
     * @throws DAOException
     */
    public List<Skills>getSkills()throws DAOException;
    /***
     *
     * @return
     * @throws DAOException
     */
    public List<Skills>getAllSkils()throws DAOException;

    /***
     *
     * @return
     * @throws DAOException 
     */
    public List<Skills>getAllSkilsAgainstDesig()throws DAOException;

    /***
     *
     * @param skills
     * @return
     * @throws DAOException
     */
    public Skills getSkills(Skills skills)throws DAOException;
    /***
     *
     * @param status
     * @return
     * @throws DAOException
     */
    public boolean changeStatus(Skills skills)throws DAOException;
    /***
     *
     * @param skills
     * @return
     * @throws DAOException
     */
    public boolean addSkill(Skills skills)throws DAOException;
    /***
     *
     * @param skills
     * @return
     * @throws DAOException
     */
    public boolean updateSkill(Skills skills)throws DAOException;
    /***
     *
     * @param skills
     * @return
     * @throws DAOException
     */
    public boolean deleteSkill(Skills skills)throws DAOException;
    /***
     * select Department By companyCode
     * @param companyCode
     * @return
     * @throws DAOException
     */
    public List<Department>getDepartmentByCompanyCode(int companyCode)throws DAOException;
    /***
     * Pick up only that values whoes status is active 'A'
     * @param departmentId
     * @return
     * @throws DAOException
     */
    public List<Skills>getSkillsByDepartment(int departmentId)throws DAOException;

     /***
     * Pick skills
     * against JobType
     * @param typeId
     * @return
     * @throws DAOException
     */
    public List<Skills> getSkillsByJobType(int typeId) throws DAOException ;
}
