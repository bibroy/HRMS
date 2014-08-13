/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.Project;
import com.pojo.ProjectManagementTransaction;
import com.util.ManagerDetail;
import com.util.ProjectDetail;
import com.util.ResourceDetail;
import java.util.List;
import com.util.ClientStatusReport;

/**
 * 
 * @author shrayanti
 */
public interface ProjectDAO {
                public boolean save(Project project)throws DAOException;

		public Project getProject(Integer id) throws DAOException;

                public List<ProjectDetail> getAllProject() throws DAOException;
                public List<Project> getAllProjectForEdit() throws DAOException;
                public List<ManagerDetail> getManager() throws DAOException;
                 public List <ResourceDetail> getResource() throws DAOException;
                 public List <ManagerDetail> getManagerList() throws DAOException;
                 public List<Project> getProjectdetailbyStatus(String status) throws DAOException;
                 public List getALLClientByProjectStatus() throws DAOException;

                 public List<ClientStatusReport> getClientStatusReport() throws DAOException;

}
