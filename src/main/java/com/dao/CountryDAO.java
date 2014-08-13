/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;


import com.pojo.CountryMaster;
import java.util.List;
/**
 *
 * @author Shrayanti Bhattacharyya
 */
public interface CountryDAO {

    public boolean save(CountryMaster country)throws DAOException;

		public CountryMaster getCountry() throws DAOException;

		public CountryMaster getCountry(String countryId) throws DAOException;

		public CountryMaster getCountry(Integer countryId) throws DAOException;

		

		public List<CountryMaster> getAllCountry() throws DAOException;

}
