/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.Recruitment;
import java.util.List;

/**
 *
 * @author Sumit Kumar
 */
public interface RecruitmentDAO {

    public boolean save(Recruitment rc)throws DAOException;

    public Recruitment getRecruitment() throws DAOException;

    public Recruitment getRecruitment(Integer id) throws DAOException;

    public List<Recruitment> getAllRecruitment() throws DAOException;

    public List<Recruitment> getAllRecruitmentByStatus(String status) throws DAOException;

    public Integer getLastId() throws DAOException;

    public List<Recruitment> getRecruitmentBySkill(String skill) throws DAOException;
}
