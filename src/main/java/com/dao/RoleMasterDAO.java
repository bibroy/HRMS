/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;
import java.util.List;

import com.pojo.RoleMaster;

/**
 *
 * @author pradipto
 */
public interface RoleMasterDAO {

  public List<RoleMaster> getAllRoles() throws DAOException;

}
