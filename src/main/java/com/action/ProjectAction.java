/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.ImplClass.ProjectDAOImpl;
import com.dao.ClientDAO;
import com.dao.ClientGrpDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.DepartmentDAO;
import com.dao.ProjectDAO;
import com.forms.ProjectForm;
import com.pojo.Client;
import com.pojo.ClientGroup;
import com.ImplClass.LoanDAOImpl;
import com.dao.EmployeeMasterDAO;
import com.pojo.Project;

import com.pojo.Department;
import com.pojo.EmployeeMaster;

import com.pojo.Project;
import com.pojo.ProjectManagementTransaction;
import com.util.ManagerDetail;
import com.util.ProjectDetail;
import com.util.ResourceDetail;
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
public class ProjectAction extends DispatchAction {

    public ActionForward load(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        Project project = null;
        DAOFactory factory = new DAOFactory();
        ClientGrpDAO dao = factory.createClientGrpManager();
        ClientDAO clientdao = factory.createClientManager();
        ProjectDAO projectdao = factory.createProjectManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        List<Project> projectList = null;
        List<Client> clientList = null;
        ProjectManagementTransaction projectManagementTransaction = null;

        List<ClientGroup> clientGrpList = new ArrayList<ClientGroup>();
        ProjectForm projectForm = (ProjectForm) form;
        ProjectDAOImpl projectImpl = new ProjectDAOImpl();


        List<ManagerDetail> managerList = new ArrayList<ManagerDetail>();
        List<ProjectDetail> ProjectDetailList = new ArrayList<ProjectDetail>();
        List<ResourceDetail> resourceList = new ArrayList<ResourceDetail>();

        List<Department> departmentList = null;
        DepartmentDAO daoDepartment = factory.departmentManager();
        try {
            departmentList = daoDepartment.getAllDepartment();
            request.setAttribute("deptList", departmentList);
            ManagerDetail managerpojo = new ManagerDetail();

            projectList = projectdao.getAllProjectForEdit();
            request.setAttribute("projectList", projectList);

            managerList = projectdao.getManagerList();
            request.setAttribute("managerList", managerList);

            ProjectDetailList = projectdao.getAllProject();
            request.setAttribute("ProjectDetailList", ProjectDetailList);

            resourceList = projectdao.getResource();
            request.setAttribute("resourceList", resourceList);


            clientGrpList = dao.getAllClientGrp();
            clientList = clientdao.getAllClient();
            if (clientGrpList != null && clientGrpList.size() > 0) {
                request.setAttribute("clientGrp", clientGrpList);
            }
            if (clientList != null && clientList.size() > 0) {
                request.setAttribute("client", clientList);

            }


            if (projectForm.getId() > 0) {
                project = projectdao.getProject(projectForm.getId());
                projectForm.setClientId(project.getClientId());
                //projectForm.setGr_master_id(project.getClientGrpid());

                projectForm.setDesc(project.getDesc());
                //projectForm.setDueDate(project.getDueDate());

                // projectForm.setEndDate(java.Util.Date());
                projectForm.setMonth(project.getPlannedTime());

                projectForm.setProjectName(project.getProjectName());
                projectForm.setProjectCode(project.getProjectCode());
                projectForm.setProjectStatus(project.getProjectStatus());
                projectForm.setProject_technology(project.getTechnology());
                projectForm.setManager_id(project.getManagerId());
                projectForm.setMaximum_resource(project.getMaximumResource());
                projectForm.setDepartment_id(project.getDepartmentId());



                //projectForm.setStartDate((project.getStartDate()));
                projectForm.setStatus(project.getStatus());
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

    public ActionForward saveOrEdit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        DAOFactory factory = new DAOFactory();
        ClientDAO clientdao = factory.createClientManager();
        ProjectDAO projectdao = factory.createProjectManager();
        ProjectDAOImpl projectImpl = new ProjectDAOImpl();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        Project project = null;
        ProjectForm projectForm = (ProjectForm) form;
        List<Client> clientList = null;
        LoanDAOImpl ldao = new LoanDAOImpl();
        System.out.println("i m in save or edit" + projectForm.getId());
        List<ManagerDetail> managerList = new ArrayList<ManagerDetail>();
        DepartmentDAO daoDepartment = factory.departmentManager();
        List<Department> departmentList = null;
        try {
            ManagerDetail managerPojo = new ManagerDetail();

            managerList = projectdao.getManager();
            request.setAttribute("managerList", managerList);
            departmentList = daoDepartment.getAllDepartment();
            request.setAttribute("deptList", departmentList);
            clientList = clientdao.getAllClient();
            if (clientList != null && clientList.size() > 0) {
                request.setAttribute("client", clientList);
            }
            if (projectForm.getId() == 0) {
                System.out.println("i m in IF" + projectForm.getId());
                project = new Project();
                project.setClientId(projectForm.getClientId());
                project.setCreatedBy(0);
                project.setDesc(projectForm.getDesc());
                //project.setDueDate(projectForm.getDueDate());
                project.setStartDate(ldao.mySqlDatebFormat(projectForm.getStartDate()));
                project.setEndDate(ldao.mySqlDatebFormat(projectForm.getEndDate()));
                project.setDueDate(ldao.mySqlDatebFormat(projectForm.getDueDate()));
                project.setEntryDate(new java.util.Date());
                project.setPlannedTime(projectForm.getMonth());
                project.setProjectCode(projectForm.getProjectCode());
                project.setProjectName(projectForm.getProjectName());
                project.setProjectStatus(projectForm.getProjectStatus());
                project.setManagerId(projectForm.getManager_id());
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$" + projectForm.getManager_id() + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                project.setMaximumResource(projectForm.getMaximum_resource());
                project.setDepartmentId(projectForm.getDepartment_id());
                project.setTechnology(projectForm.getProject_technology());


                //project.setStartDate(projectForm.getStartDate());
                project.setStatus("Y");
                projectdao.save(project);
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
            } else {
                System.out.println("i m in else" + projectForm.getId());
                project = projectdao.getProject(projectForm.getId());
                project.setClientId(projectForm.getClientId());
                project.setCreatedBy(0);
                project.setDesc(projectForm.getDesc());
                //project.setDueDate(projectForm.getDueDate());
                project.setStartDate(ldao.mySqlDatebFormat(projectForm.getStartDate()));
                project.setEndDate(ldao.mySqlDatebFormat(projectForm.getEndDate()));
                project.setDueDate(ldao.mySqlDatebFormat(projectForm.getDueDate()));
                project.setEntryDate(new java.util.Date());
                project.setPlannedTime(projectForm.getMonth());
                project.setProjectCode(projectForm.getProjectCode());
                project.setProjectName(projectForm.getProjectName());
                project.setProjectStatus(projectForm.getProjectStatus());
                project.setManagerId(projectForm.getManager_id());
                System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$" + projectForm.getManager_id() + "$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
                project.setMaximumResource(projectForm.getMaximum_resource());
                project.setDepartmentId(projectForm.getDepartment_id());
                project.setTechnology(projectForm.getProject_technology());
                projectdao.save(project);
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

    public ActionForward projectStatusReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        ProjectForm frm = (ProjectForm) form;
        List<Project> proj = null;
        DAOFactory dfact = new DAOFactory();
        ProjectDAO prdao = dfact.createProjectManager();

        EmployeeMaster empobj = null;
        EmployeeMasterDAO edao = dfact.createEmployeeMasterManager();

        try {
            String status = frm.getProjectStatus();
            proj = prdao.getProjectdetailbyStatus(status);


            for (Project p: proj) {
                p.setManagerName(edao.getEmployeeMasterByEmpId(p.getManagerId()).getFirstName());


            }

            request.setAttribute("projectdetails", proj);

            target = "success";



        } catch (Exception e) {

            log.error("An exception occur:" + e);

        }






        return mapping.findForward(target);
    }
}
