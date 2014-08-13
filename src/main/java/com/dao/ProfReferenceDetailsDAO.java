/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.ProfReferenceDetails;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface ProfReferenceDetailsDAO {


    public boolean save(ProfReferenceDetails profReferenceDetails)throws DAOException;

		public ProfReferenceDetails getProfReferenceDetails() throws DAOException;

		

		public ProfReferenceDetails getProfReferenceDetails(Integer profReferenceDetailsId) throws DAOException;

		public ProfReferenceDetails getProfReferenceDetailsByCode(String profReferenceDetailsCode) throws DAOException;

		public List<ProfReferenceDetails> getAllProfReferenceDetails() throws DAOException;
                 public ProfReferenceDetails getProfReferenceDetailsByEmpId(String employeeMasterId) throws DAOException;
                 public BigDecimal getLastRequestId() throws DAOException;
}
