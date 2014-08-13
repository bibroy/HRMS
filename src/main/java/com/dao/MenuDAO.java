/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.Menu;
import java.util.List;

/**
 *
 * @author swarnendum
 */
public interface MenuDAO {    

  public List<Menu> getMenuLinks(String role_id) throws DAOException;

}
