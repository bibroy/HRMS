/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.VisaRequestDetails;
import java.util.List;
/**
 *
 * @author Sumit Kumar
 */
public interface VisaRequestDetailsDAO {

    public boolean save(VisaRequestDetails vrd)throws DAOException;

    public List<VisaRequestDetails> getAllRequests()throws DAOException;

    public VisaRequestDetails getRequestById(Integer id) throws DAOException;

    public Integer getLastId()throws DAOException;

    public List<VisaRequestDetails> getAllRequestByEmpId(String empid)throws DAOException;
}
