/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.List;
import com.pojo.City;

/**
 *
 * @author sudipb
 */
public interface CityDAO {

    public boolean save(City city) throws DAOException;

    public City getCity() throws DAOException;

    public City getCity(String cityId) throws DAOException;

    public City getCity(Integer cityId) throws DAOException;

    public City getCityByCode(String cityCode) throws DAOException;

    public List<City> getAllCity() throws DAOException;

    public List<City> getAllCityByStateCode(Integer stateCode) throws DAOException;


    public List<City> getAllCityByCountryCode(Integer countryCode)throws DAOException;
}
