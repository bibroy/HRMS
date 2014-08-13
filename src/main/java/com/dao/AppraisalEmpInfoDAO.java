/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.AppraisalEmpInfo;
import java.util.List;

/**
 *
 * @author swarnendum
 */
public interface AppraisalEmpInfoDAO {

    public List<AppraisalEmpInfo> getAllAppraisalEmpInfo() throws DAOException;

    public List<AppraisalEmpInfo> getEmployeeDetails(String Employee_code) throws DAOException;
}
