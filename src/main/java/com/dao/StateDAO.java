/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.List;
import com.pojo.State;

/**
 *
 * @author Swarnendu Mukherjee
 */
public interface StateDAO {

    public boolean save(State state) throws DAOException;

    public State getState() throws DAOException;

    public State getState(String plantId) throws DAOException;

    public State getState(Integer plantId) throws DAOException;

    public State getStateByCode(String plantCode) throws DAOException;

    public List<State> getAllState() throws DAOException;

   public List<State> getAllStateByCountryCode(Integer countryCode) throws DAOException;


}
