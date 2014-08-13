/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;
import com.pojo.WorkShift;
import java.util.List;
/**
 *
 * @author pradipto roy
 */
public interface WorkShiftDAO {

public boolean save(WorkShift work) throws DAOException;

public WorkShift getAllWorkShiftbyEmpId(String empid)throws DAOException;

}
