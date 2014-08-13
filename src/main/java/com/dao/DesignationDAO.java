/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.DesignationMaster;
import java.util.List;
/**
 *
 * @author sudipb
 */
public interface DesignationDAO {

    public boolean save(DesignationMaster designationmaster) throws DAOException;

    public DesignationMaster getDesignation() throws DAOException;

    public DesignationMaster getDesignation(String designationId) throws DAOException;

    public DesignationMaster getDesignation(Integer designationId) throws DAOException;

  
    public List<DesignationMaster> getAllDesignation() throws DAOException;
    public List<DesignationMaster > getDesignationByCompanyCode(Integer CompCode) throws DAOException;
}
