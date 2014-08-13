/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.PreviousEmployerDetails;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface PreviousEmployerDetailsDAO {

    public boolean save(PreviousEmployerDetails previousEmployerDetails) throws DAOException;

    public PreviousEmployerDetails getPreviousEmployerDetails() throws DAOException;

    public PreviousEmployerDetails getPreviousEmployerDetails(Integer previousEmployerDetailsId) throws DAOException;

    public PreviousEmployerDetails getPreviousEmployerDetailsByCode(String previousEmployerDetailsCode) throws DAOException;

    public List<PreviousEmployerDetails> getAllPreviousEmployerDetails() throws DAOException;

    public List<PreviousEmployerDetails> getPreviousEmployerDetailsByEmpId(String employeeMasterId) throws DAOException;

 public boolean delete(PreviousEmployerDetails ereviousEmployerDetails) throws DAOException;




}
