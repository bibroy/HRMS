/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;



import com.pojo.BranchMaster;
import com.pojo.Department;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Sumit Kumar
 */
public interface BranchDAO {

     public boolean save(BranchMaster branch) throws DAOException;
     public String getCurrency(Integer branchCountryid)throws DAOException;
     public List getAllBranchOfCompany(Integer companyId)throws DAOException;
     public BigDecimal getLastRequestId() throws DAOException;
     public BranchMaster getBranch(BigDecimal branchid) throws DAOException;
     public BranchMaster getBranchNameByBranchID(Integer branchID)throws DAOException;
      public List<BranchMaster> getAllBranches() throws DAOException;
}
