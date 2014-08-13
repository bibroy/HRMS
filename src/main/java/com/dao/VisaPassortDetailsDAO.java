/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.VisaPassortDetails;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface VisaPassortDetailsDAO {


    public boolean save(VisaPassortDetails visaPassortDetails)throws DAOException;

		public VisaPassortDetails getVisaPassortDetails() throws DAOException;



		public VisaPassortDetails getVisaPassortDetails(Integer visaPassortDetailsId) throws DAOException;

		public VisaPassortDetails getVisaPassortDetailsByCode(String visaPassortDetailsCode) throws DAOException;

		public List<VisaPassortDetails> getAllVisaPassortDetails() throws DAOException;
                 public VisaPassortDetails getVisaPassortDetailsByEmpId(String employeeMasterId) throws DAOException;
                 public List<VisaPassortDetails>getVisaPassportDetailsByValidationDate(String datebymonth)throws DAOException;
}
