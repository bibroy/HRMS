/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.AppraisalGrade;
import java.util.List;

/**
 *
 * @author Swarnendu Mukherjee
 */
public interface AppraisalGradeDAO {


    public boolean save(AppraisalGrade appraisalGrade) throws DAOException;

    public AppraisalGrade getAppraisalGrades() throws DAOException;

    public AppraisalGrade getAppraisalGrades(String appraisalId) throws DAOException;

    public AppraisalGrade getAppraisalGrades(Integer appraisalId) throws DAOException;

    public AppraisalGrade getAppraisalGradesByCode(String appraisalId) throws DAOException;

    public List<AppraisalGrade> getAllAppraisalGrades() throws DAOException;
    
    public List<AppraisalGrade> getGradeDetails(int category_code) throws DAOException;

}
