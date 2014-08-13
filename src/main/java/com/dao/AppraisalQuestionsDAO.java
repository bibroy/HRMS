package com.dao;

import com.pojo.AppraisalQuestions;
import java.util.List;

/**
 *
 * @author Swarnendu Mukherjee
 */
public interface AppraisalQuestionsDAO {


    public boolean save(AppraisalQuestions appraisalQuestions) throws DAOException;

    public AppraisalQuestions getAppraisalQuestions() throws DAOException;

    public AppraisalQuestions getAppraisalQuestions(String question_code) throws DAOException;

    public AppraisalQuestions getAppraisalQuestions(Integer question_code) throws DAOException;

    public AppraisalQuestions getAppraisalQuestionsByCode(String question_code) throws DAOException;

    public List<AppraisalQuestions> getAllAppraisalQuestions() throws DAOException;

    public List<AppraisalQuestions> getQuestionsbyCategory(int category_code) throws DAOException;

}
