/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.RecruitmentMarks;
import com.pojo.Recruitment;
import java.util.List;

/**
 *
 * @author Sumit Kumar
 */
public interface RecruitmentMarksDAO {

        public boolean save(RecruitmentMarks rcm)throws DAOException;
        
        public List<RecruitmentMarks> getRecruitmentMarksById(Integer id) throws DAOException;

        public Integer getLastId()throws DAOException;
        
}
