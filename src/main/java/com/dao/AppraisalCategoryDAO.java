
package com.dao;

import com.pojo.AppraisalCategory;


import java.util.List;
 

 
/** 
 *
 * @author Swarnendu Mukherjee
 */

    public interface AppraisalCategoryDAO {

    public boolean save(AppraisalCategory appraisalCategory) throws DAOException;

    public AppraisalCategory getAppraisalCategories() throws DAOException;

    public AppraisalCategory getAppraisalCategories(String appraisalId) throws DAOException;

    public AppraisalCategory getAppraisalCategories(Integer appraisalId) throws DAOException;

    public AppraisalCategory getAppraisalCategoriesByCode(String appraisalId) throws DAOException;

    public List<AppraisalCategory> getAllAppraisalCategories() throws DAOException;

    public List<AppraisalCategory> getCategoryDetails(int category_code) throws DAOException;


}

    

 
