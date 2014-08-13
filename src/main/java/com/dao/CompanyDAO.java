/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.Company;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author dolad
 */
public interface  CompanyDAO {

                public boolean save(Company company)throws DAOException;

		public Company getCompany() throws DAOException;

		public Company getCompany(String plantId) throws DAOException;

		public Company getCompany(Integer plantId) throws DAOException;

		public Company getCompanyByCode(String plantCode) throws DAOException;

		public List<Company> getAllCompany() throws DAOException;

                public List<Company> getAllGrpCompany() throws DAOException;

                public BigDecimal getLastRequestId() throws DAOException;
}
