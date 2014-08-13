/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.Department;
import com.pojo.DocDump;
import com.pojo.Skills;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface DocDumpDAO {

    public List<DocDump>getAllDocDump()throws DAOException;

    public List<DocDump>getAllDocDumpOnDept(Department dept)throws DAOException;

    public List<DocDump>getAllDocDumpOnSkill(Skills skills)throws DAOException;

    public List<DocDump>getAllDocDumpOnTraining(DocDump docDump)throws DAOException;

    public boolean addDocDump(DocDump docDump) throws DAOException;

    public boolean updateDocDump(DocDump docDump) throws DAOException;

}
