/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;
import com.pojo.CompensationIncrementBand;
import com.pojo.CompensationIndicatorMaster;
import java.util.List;
import com.pojo.CompensationPerformanceIndicator;
import com.pojo.CompensationPerformancesheet;
import com.pojo.CompensationCalculatedScore;
import com.pojo.CompensationIncrementBand;
import com.pojo.CompensationIndicatorMaster;
/**
 *
 * @author computer1
 */
public interface CompensationDao {
 public boolean save(CompensationIncrementBand cib) throws DAOException;
  public Integer getLastId() throws DAOException;
  public List<CompensationIndicatorMaster> getIndicator() throws DAOException;
   public boolean saveIndicator(CompensationPerformanceIndicator cib) throws DAOException;
   public Integer getLastIdForIndicator() throws DAOException;
   public List<CompensationPerformanceIndicator> getperformanceIndicator(Integer companyid,Integer departmentid,Integer designationid) throws DAOException;
   public CompensationIndicatorMaster getIndicatorById(Integer indicatorid) throws DAOException;
    public boolean savePerformanceSheet(CompensationPerformancesheet cps) throws DAOException;
   public Integer getLastIdForPerformancesheet() throws DAOException;
   public List<CompensationPerformancesheet> scorecalculation(String empid) throws DAOException;
   public Integer getLastIdForcalculation() throws DAOException;
   public boolean savecalculatedscore(CompensationCalculatedScore cps) throws DAOException;
   public List<CompensationIncrementBand> getIncrementBand() throws DAOException;
     public CompensationIncrementBand getIncrementBand(Integer id) throws DAOException;
     public boolean saveindicatormaster(CompensationIndicatorMaster cps) throws DAOException;
       public Integer getLastIdForIndicatormaster() throws DAOException;
       public List<CompensationIncrementBand> getIncrementBand(Integer companyid,Integer departmentid,Integer designationid) throws DAOException;

}
