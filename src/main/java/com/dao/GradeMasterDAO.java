/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.GradeMaster;
import java.util.List;

/**
 *
 * @author pradipto
 * created on 2/2/2011
 */
public interface GradeMasterDAO {

    List<GradeMaster>getEmployeesbyGrade(String grade)throws DAOException;


}




