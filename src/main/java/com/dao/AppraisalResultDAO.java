/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.AppraisalResult;
import java.util.List;
import com.pojo.AppraisalResultSum;
import com.pojo.selfAppraisalResult;
import java.util.Date;
import com.util.appraisalresultutil;
import com.util.Appraisalutil;
/**
 *
 * @author Swarnendu Mukherjee
 */
public interface AppraisalResultDAO {

    public boolean save(AppraisalResult appraisalResults) throws DAOException;
    public boolean selfsave(selfAppraisalResult selfappraisalResults) throws DAOException;

    public AppraisalResult getAppraisalResult() throws DAOException;

    public AppraisalResult getAppraisalResult(String question_code) throws DAOException;

    public AppraisalResult getAppraisalResult(Integer question_code) throws DAOException;

    public AppraisalResult getAppraisalResultByCode(String question_code) throws DAOException;

    public List<AppraisalResult> getAllAppraisalResult() throws DAOException;

    public List<AppraisalResult> getAppraisalResultbyEmployee(int employee_id) throws DAOException ;

     public List<AppraisalResult> getAppraisalResultbyEmployee(String employee_id) throws DAOException;

    public List<AppraisalResultSum> getAllAppraisalResultSum() throws DAOException;

     public Integer getLastId() throws DAOException;

     public Integer getselfLastId() throws DAOException;

      public boolean saveAppraisalResultsum(AppraisalResultSum appraisalResultsum) throws DAOException ;

      public List<appraisalresultutil> calculatesum(Date appraisedate,String empid) throws DAOException;

       public Integer getLastIdForSum() throws DAOException;

       public Appraisalutil appraisalreport(String empid)throws DAOException;

       public List<Appraisalutil> appraisalgraph(String empid)throws DAOException;
       
       public List<AppraisalResultSum>employeeByAppraisalresultsum()throws DAOException;

}
