/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.BaseDAO;
import com.dao.DAOFactory;
import com.dao.DepartmentDAO;
import com.dao.EmpProjRelocationHistoryDAO;
import com.dao.EmployeeMasterDAO;
import com.dao.ProjectDAO;
import com.dao.ProjectEmpDAO;
import com.dao.ProjectJobsDAO;
import com.dao.VacanciesDAO;
import com.forms.ProjectEmpForm;
import com.forms.ProjectJobsForm;
import com.forms.VacanciesForm;
import com.pojo.Department;
import com.pojo.EmpProjRelocationHistory;
import com.pojo.Project;
import com.pojo.ProjectEmp;
import com.pojo.ProjectJobs;
import com.pojo.vacancies;
import com.util.EmpProjRelcHistUtil;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Sumit Kumar
 */
public class ManpowerAction extends DispatchAction {

    /* forward name="success" path=""   */
    private String target = "";

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward saveProjectJob(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ProjectJobsDAO pjdao = factory.createProjectJobsManager();
        ProjectJobsForm pjform = (ProjectJobsForm) form;
        ProjectJobs pj = new ProjectJobs();
        ProjectDAO pdao = factory.createProjectManager();
        Project p = new Project();
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        try {
            if (session.getAttribute("user_id") != null) {
                pj.setId(pjdao.getLastId().add(BigDecimal.ONE));
                pj.setJobName(pjform.getJobName());
                pj.setJobDesc(pjform.getJobDesc());

                p = pdao.getProject(Integer.parseInt(pjform.getProject()));
                pj.setProject(p);

                pj.setManpowerReq(pjform.getManpowerReq());
                pj.setSkillsReq(pjform.getSkillsReq());
                pj.setStatus("Y");

                boolean result = pjdao.save(pj);
                if (result) {

                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";
                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error during loading the project list " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.page", e));
            saveErrors(request, messages);
            target = "errorpage";
        }
        return mapping.findForward(target);
    }

    public ActionForward loadProjects(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ProjectDAO pdao = factory.createProjectManager();
        List<Project> plist = null;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        try {
            if (session.getAttribute("user_id") != null) {
                plist = pdao.getAllProjectForEdit();
                request.setAttribute("projectList", plist);
                target = "load";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error during loading the project list " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.page", e));
            saveErrors(request, messages);
            target = "errorpage";
        }
        return mapping.findForward(target);
    }

    public ActionForward loadJobs(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ProjectJobsDAO pjdao = factory.createProjectJobsManager();
        ProjectEmpForm pef = (ProjectEmpForm) form;
        List<ProjectJobs> pjList = null;
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("user_id") != null) {
                pjList = pjdao.getAllJobsByProj(new BigDecimal(pef.getHiddenId()));
                request.setAttribute("jobList", pjList);
                target = "joblist";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error during loading the project list " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadJobDesc(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ProjectJobsDAO pjdao = factory.createProjectJobsManager();
        ProjectEmpForm pef = (ProjectEmpForm) form;
        ProjectJobs pj = null;
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();

        try {
            if (session.getAttribute("user_id") != null) {
                pj = pjdao.getJobById(new BigDecimal(pef.getJob()));
                request.setAttribute("jobDescription", pj);
                target = "jobdesc";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error during loading the project list " + e);
            target = "";
        }
        return mapping.findForward(target);
    }

    public ActionForward loadProjectForAlloc(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ProjectDAO pdao = factory.createProjectManager();
        List<Project> plist = null;
        ProjectEmpDAO pedao = factory.createProjectEmpManager();
        List list = null;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        try {
            if (session.getAttribute("user_id") != null) {
                plist = pdao.getAllProjectForEdit();
                request.setAttribute("projectList", plist);
                list = pedao.getIdleEmployee();
                request.setAttribute("empList", list);
                target = "load";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error during loading the project list " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.page", e));
            saveErrors(request, messages);
            target = "errorpage";
        }
        return mapping.findForward(target);
    }

    public ActionForward saveProjectEmp(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ProjectEmpDAO pedao = factory.createProjectEmpManager();
        ProjectJobsDAO pjdao = factory.createProjectJobsManager();
        ProjectDAO pdao = factory.createProjectManager();
        ProjectEmpForm pef = (ProjectEmpForm) form;
        ProjectEmp pe = new ProjectEmp();
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("user_id") != null) {
                pe.setId(pedao.getLastId().add(BigDecimal.ONE));
                pe.setEmpId(pef.getEmpId());
                pe.setJob(pjdao.getJobById(new BigDecimal(pef.getJob())));
                pe.setProject(pdao.getProject(Integer.parseInt(pef.getProject())));
                pe.setAllocationDate(new Date());
                pe.setStatus("Y");

                boolean result = pedao.save(pe);
                boolean res = false;
                if (result) {
                    ProjectJobs pj = pjdao.getJobById(new BigDecimal(pef.getJob()));
                    pj.setAllocatedManpower(pj.getAllocatedManpower() + 1);
                    res = pjdao.save(pj);
                }
                if (res) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";
                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error during saving the project employees " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.page", e));
            saveErrors(request, messages);
            target = "errorpage";
        }
        return mapping.findForward(target);
    }

    public ActionForward loadDept(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        DepartmentDAO deptdao = factory.createDepartmentManager();
        List<Department> deptlist = null;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();

        try {
            if (session.getAttribute("user_id") != null) {
                deptlist = deptdao.getAllDepartment();
                request.setAttribute("deptList", deptlist);
                target = "load";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error during saving the project employees " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.page", e));
            saveErrors(request, messages);
            target = "errorpage";
        }
        return mapping.findForward(target);
    }

    public ActionForward saveVacancyInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        VacanciesDAO vdao = factory.createVacancyManager();
        vacancies vac = new vacancies();
        ActionMessages messages = new ActionMessages();
        VacanciesForm vf = (VacanciesForm) form;
        HttpSession session = request.getSession();
        BaseDAO b = new BaseDAO();
        DepartmentDAO deptdao = factory.createDepartmentManager();
        List<Department> deptlist = null;
        try {
            if (session.getAttribute("user_id") != null) {
                vac.setId(vdao.getLastId() + 1);
                vac.setDepartment(vf.getDepartment());
                vac.setExperience(vf.getExperience());
                vac.setNoofvac(vf.getNoofvac());
                vac.setPost(vf.getPost());
                vac.setQuali(vf.getQuali());
                vac.setSkillreq(vf.getSkillreq());
                vac.setStatus("E");
                vac.setLastDate(b.mySqlDatebFormat(vf.getLastDate()));

                boolean result = vdao.save(vac);
                if (result) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";
                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }
                deptlist = deptdao.getAllDepartment();
                request.setAttribute("deptList", deptlist);
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error during saving the project employees " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.page", e));
            saveErrors(request, messages);
            target = "errorpage";
        }
        return mapping.findForward(target);
    }

    public ActionForward loadEmpDesc(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ProjectEmpDAO pedao = factory.createProjectEmpManager();
        ProjectEmp pe = null;
        ProjectEmpForm peform = (ProjectEmpForm) form;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        try {
            if (session.getAttribute("user_id") != null) {
                pe = pedao.getProjByEmpId(peform.getEmpId());
                if (pe != null) {
                    request.setAttribute("empdetail", pe);
                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("Record.notFound", peform.getEmpId()));
                    saveErrors(request, messages);
                }
                target = "empdet";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error fetching the details of employee " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadRelocation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ProjectDAO pdao = factory.createProjectManager();
        List<Project> plist = null;
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("user_id") != null) {
                plist = pdao.getAllProjectForEdit();
                request.setAttribute("projectList", plist);
                target = "load";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error loading the page " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.page", e));
            saveErrors(request, messages);
            target = "errorpage";
        }
        return mapping.findForward(target);
    }

    public ActionForward relocateEmployeeProject(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ProjectEmpDAO pedao = factory.createProjectEmpManager();
        ProjectJobsDAO pjdao = factory.createProjectJobsManager();
        ProjectDAO pdao = factory.createProjectManager();
        ProjectEmp pe = null;
        EmpProjRelocationHistoryDAO eprhdao = factory.createEmpProjRelocationHistoryManager();
        EmpProjRelocationHistory eprh = new EmpProjRelocationHistory();
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        ProjectEmpForm peform = (ProjectEmpForm) form;
        ProjectJobs pj=null;
        try {
            if (session.getAttribute("user_id") != null) {

                pe = pedao.getProjByEmpId(peform.getEmpId());

                String fromProj = pe.getProject().getId().toString();
                String fromJob = pe.getJob().getId().toString();

                pe.setProject(pdao.getProject(Integer.parseInt(peform.getProject())));
                pe.setJob(pjdao.getJobById(new BigDecimal(peform.getJob())));
                pe.setAllocationDate(new Date());

                boolean result = pedao.save(pe);
                if (result) {
                    pj=pjdao.getJobById(new BigDecimal(fromJob));
                    pj.setAllocatedManpower((pj.getAllocatedManpower()==null?0:pj.getAllocatedManpower())-1);
                    pjdao.save(pj);

                    pj=pjdao.getJobById(new BigDecimal(peform.getJob()));
                    pj.setAllocatedManpower((pj.getAllocatedManpower()==null?0:pj.getAllocatedManpower())+1);
                    pjdao.save(pj);
                    
                    eprh.setId(eprhdao.getLastId().add(BigDecimal.ONE));
                    eprh.setEmpId(peform.getEmpId());
                    eprh.setFromProj(pdao.getProject(Integer.parseInt(fromProj)));
                    eprh.setFromJob(pjdao.getJobById(new BigDecimal(fromJob)));
                    eprh.setRelocationDate(new Date());
                    eprh.setToProj(pdao.getProject(Integer.parseInt(peform.getProject())));
                    eprh.setToJob(pjdao.getJobById(new BigDecimal(peform.getJob())));

                    boolean res = eprhdao.save(eprh);
                    if (res) {
                        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                        saveMessages(request, messages);
                        target = "success";
                    } else {
                        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
                        saveErrors(request, messages);
                        target = "success";
                    }
                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error relocating the employee " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.page", e));
            saveErrors(request, messages);
            target = "errorpage";
        }
        return mapping.findForward(target);
    }

    public ActionForward genJobTransferReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DAOFactory factory=new DAOFactory();
        EmpProjRelocationHistoryDAO eprhdao=factory.createEmpProjRelocationHistoryManager();
       
        List<EmpProjRelcHistUtil > eprlist=new ArrayList<EmpProjRelcHistUtil>();
        BaseDAO b=new  BaseDAO();
        ActionMessages messages=new ActionMessages();
        try {
            eprlist=eprhdao.getAllRelocationHistory();

            ServletOutputStream servletOutputStream=response.getOutputStream();
            response.setContentType("application/pdf");
            String repfile=getServlet().getServletConfig().getServletContext().getRealPath("/JasRep/ProjRel.jrxml")  ;
            String destfile=getServlet().getServletConfig().getServletContext().getRealPath("/JasRep/ProjRel.jasper");
            JasperCompileManager.compileReportToFile(repfile,destfile);

            InputStream reportStream=getServlet().getServletConfig().getServletContext().getResourceAsStream("/JasRep/ProjRel.jasper");
           
            JRDataSource jrsour=createReportDataSource(eprlist);
            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, new HashMap(),jrsour);
            
            
            servletOutputStream.flush();
            servletOutputStream.close();
            
            
            target="report";
        } catch (Exception e) {
            log.error("error generating the report"+ e);
        }
        return mapping.findForward(target);
    }

    private JRDataSource createReportDataSource(List<EmpProjRelcHistUtil> eprlist){
        JRBeanCollectionDataSource jbs=new JRBeanCollectionDataSource(eprlist);
        return jbs;
    }
}
