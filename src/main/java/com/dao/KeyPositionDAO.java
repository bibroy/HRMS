/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.KeyPosition;
import java.util.List;
import com.pojo.Successor;
/**
 *
 * @author pradipto
 */
public interface KeyPositionDAO {
    
    public List<KeyPosition> getAllKeyPosition() throws DAOException;

    public boolean save(KeyPosition key) throws DAOException;
    public Integer getLastRequestId() throws DAOException ;
    public boolean save(Successor save) throws DAOException;
    public Integer getLastRequestIdforSuccessor() throws DAOException;
    public KeyPosition getKeyPositionById(Integer positionid) throws DAOException;
    
}
