/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;


import com.pojo.Task;
import java.util.List;

/**
 * 
 * @author shrayanti
 */
public interface TaskDAO {
                public boolean save(Task task)throws DAOException;

		public Task getTask(Integer taskId) throws DAOException;
                public List<Task> getAllTask() throws DAOException;
}
