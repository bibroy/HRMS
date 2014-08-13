/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.EmpSkills;
import java.util.List;

/**
 *
 * @author Sumit Kumar
 */

public interface EmpSkillsDAO {
    
    public List<EmpSkills> getEmployeeBySkill(String skill) throws DAOException;

    
}
