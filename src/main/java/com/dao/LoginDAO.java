package com.dao;

import com.pojo.Login;
import java.util.List;

/**
 *
 * @author Swarnendu Mukherjee
 */
public interface LoginDAO {

    public List<Login> checkAuthentication(String user_id,String password) throws DAOException;
    public Login getLogin() throws DAOException;
    public Login getLogin(String uid) throws DAOException;
    public Login getLoginByUserId(String user_id) throws DAOException;
    public boolean save(Login login) throws DAOException;

}