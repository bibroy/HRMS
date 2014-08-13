/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.AppraisalSetup;
import java.util.List;

/**
 *
 * @author Swarnendu Mukherjee
 */
public interface AppraisalSetupDAO {


    public boolean save(AppraisalSetup appraisalSetup) throws DAOException;

    public AppraisalSetup getAppraisalSetup() throws DAOException;

    public AppraisalSetup getAppraisalSetup(String appraisalId) throws DAOException;

    public AppraisalSetup getAppraisalSetup(Integer appraisalId) throws DAOException;

    public AppraisalSetup getAppraisalSetupByCode(String appraisalId) throws DAOException;

    public List<AppraisalSetup> getAllAppraisalSetup() throws DAOException;

    public List<AppraisalSetup> getAllAppraisalSetup(int company,int department) throws DAOException ;

    public List<AppraisalSetup> getAllSelfAppraisalSetup(int department) throws DAOException;
     public List<AppraisalSetup> getSelfAppraisalSetup(int designation,int department) throws DAOException;

    //public List<AppraisalSetup> getSetupDetails(String id) throws DAOException;

}
