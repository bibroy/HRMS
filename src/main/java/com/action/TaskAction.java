/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.ImplClass.TaskDAOImpl;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.DepartmentDAO;

import com.dao.TaskDAO;
import com.forms.ProjectForm;
import com.forms.TaskForm;
import com.pojo.Client;
import com.pojo.ClientGroup;

import com.pojo.Department;

import com.pojo.Project;
import com.pojo.Task;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 * 
 * @author shrayanti
 */
public class TaskAction extends DispatchAction {

    public ActionForward saveOrEdit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        DAOFactory factory = new DAOFactory();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        TaskDAO taskdao = factory.createTaskManager();
        Project project = null;
        TaskForm taskform = (TaskForm) form;
        List<Task> taskList = null;
        Task task = null;
        //System.out.println("i m in save or edit"+projectForm.getId());
        try {
            if (taskform.getTask_id() == 0) {

                task = new Task();
                task.setTaskName(taskform.getTask_name());
                task.setTaskDescription(taskform.getTask_description());
                task.setStatus("active");

                taskdao.save(task);
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));

            } else {
                task = taskdao.getTask(taskform.getTask_id());
                task.setTaskName(taskform.getTask_name());
                task.setTaskDescription(taskform.getTask_description());
                task.setStatus(taskform.getStatus());


                taskdao.save(task);
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("edit.ok", ""));
            }

        } catch (DAOException doe) {

            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error", doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        if (!errors.isEmpty()) {

            target = "failure";
            saveErrors(request, errors);

        } else {
            target = "success";
            saveMessages(request, messages);

        }

        return mapping.findForward(target);
    }

    public ActionForward load(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        Task task = null;
        DAOFactory factory = new DAOFactory();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        TaskDAO taskdao = factory.createTaskManager();

        List<Task> taskList = new ArrayList<Task>();
        TaskForm taskform = (TaskForm) form;
        TaskDAOImpl taskdaoimpl = new TaskDAOImpl();
        try {
            taskList = taskdao.getAllTask();

            request.setAttribute("taskList", taskList);

            if (taskform.getTask_id() != 0) {
                task = taskdao.getTask(taskform.getTask_id());
                taskform.setTask_id(task.getTaskId());
                //projectForm.setGr_master_id(project.getClientGrpid());

                taskform.setTask_name(task.getTaskName());
                taskform.setTask_description(task.getTaskDescription());
                taskform.setStatus(task.getStatus());
            }
        } catch (DAOException doe) {

            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error", doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        if (!errors.isEmpty()) {

            target = "failure";
            saveErrors(request, errors);

        } else {
            target = "success";
            saveMessages(request, messages);

        }

        return mapping.findForward(target);
    }
}
