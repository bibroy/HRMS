/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Agencies;
import java.math.BigDecimal;

import java.util.List;

public interface AgenciesDAO {

    public boolean save(Agencies a) throws DAOException;

    public Integer getLastRequestId() throws DAOException;

    public List<Agencies> getAgencies() throws DAOException;

    public Agencies getAgencyByAgencyname(String name) throws DAOException;

    public boolean update(Agencies a) throws DAOException;
}
