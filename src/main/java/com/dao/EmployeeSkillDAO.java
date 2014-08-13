/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.EmpSkills;
import com.pojo.EmployeeSkill;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface EmployeeSkillDAO {

    /***
     * Save / Update skill for employee
     * against employeeId
     * @param empskill
     * @return
     * @throws DAOException
     */
    public boolean save(EmployeeSkill empskill) throws DAOException;

    /***
     * Get a particular Employee skill
     * against skillId and employeeId
     * @param SkillNameId
     * @param EmpId
     * @return
     * @throws DAOException
     */
    public EmployeeSkill getSkill(Integer SkillNameId, Integer EmpId) throws DAOException;

    /***
     * get all skills
     * against employee Id
     * against
     * @param EmpId
     * @return
     * @throws DAOException
    public List<EmployeeSkill> getSkill(Integer EmpId) throws DAOException;

    public EmployeeSkill getEmployeeSkill() throws DAOException;

    public EmployeeSkill getEmployeeSkill(Integer employeeSkillId) throws DAOException;

    public EmployeeSkill getEmployeeSkillByCode(String employeeSkillCode) throws DAOException;

    public List<EmployeeSkill> getAllEmployeeSkill() throws DAOException;

    public List<EmployeeSkill> getEmployeeSkillByEmpId(String employeeMasterId) throws DAOException;

    public boolean delete(EmployeeSkill employeeSkill) throws DAOException;
    public List<EmployeeSkill>getEmployeeSkillIDAndNameCall(String Skillname,String empid)throws DAOException;

    public List<EmployeeSkill> getCheckEmpSkillByEmpIdAndSkillId(String employeeMasterId, Integer skillId) throws DAOException;     */
    public List<EmployeeSkill> getSkill(Integer EmpId) throws DAOException;

    public EmployeeSkill getEmployeeSkill() throws DAOException;

    public EmployeeSkill getEmployeeSkill(Integer employeeSkillId) throws DAOException;

    public EmployeeSkill getEmployeeSkillByCode(String employeeSkillCode) throws DAOException;

    public List<EmployeeSkill> getAllEmployeeSkill() throws DAOException;

    public List<EmployeeSkill> getEmployeeSkillByEmpId(String employeeMasterId) throws DAOException;

    public List<EmployeeSkill> getEmployeeSkillIDAndNameCall(String Skillname, String empid) throws DAOException;

    public boolean delete(EmployeeSkill employeeSkill) throws DAOException;

    public List<EmployeeSkill> getCheckEmpSkillByEmpIdAndSkillId(String employeeMasterId, Integer skillId) throws DAOException;

    public boolean save(EmpSkills empskillobj) throws DAOException;

    public Integer getLastRequestId() throws DAOException;

    public EmpSkills getEmployeeSkillbyempId(String emp) throws DAOException;
}
