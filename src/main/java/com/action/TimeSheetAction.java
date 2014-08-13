/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.TimeSheetDAO;
import com.pojo.TimesheetMaster;
import com.forms.TimeSheetForm;
import com.forms.TimesheetDetailForm;
import com.forms.TimeSheetHeaderForm;
import com.util.TimesheetMasterUtil;
import com.pojo.Project;
import com.dao.ProjectDAO;
import com.dao.EmployeeMasterDAO;
import com.pojo.Task;
import com.dao.TaskDAO;
import com.dao.DepartmentDAO;
import com.dao.CompanyDAO;
import com.pojo.Department;
import com.pojo.Company;
import com.pojo.TimesheetHeader;
import com.pojo.TimeSlot;
import com.pojo.TimeSheetMapping;
import com.pojo.TimesheetDetail;
import com.pojo.EmployeeMaster;

import com.dao.BaseDAO;
import com.dao.DAOFactory;
import com.forms.TimesheetMappingForm;
import com.util.TimesheetHeaderutil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.util.Timesheetutil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.util.WorkingTimeReportOFEmployees;

/**
 *
 * @author Sumit Kumar
 */
public class TimeSheetAction extends DispatchAction {

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
    public ActionForward loadForm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ProjectDAO porjdao = factory.createProjectManager();
        TaskDAO taskdao = factory.createTaskManager();
        EmployeeMasterDAO empdao = factory.createEmployeeMasterManager();
        List<EmployeeMaster> emplist = null;
        List<Task> tsklist = null;
        List<Project> prjlist = null;
        try {
            prjlist = porjdao.getAllProjectForEdit();
            request.setAttribute("projList", prjlist);
            tsklist = taskdao.getAllTask();
            request.setAttribute("taskList", tsklist);
            emplist = empdao.getAllEmployeeMaster();
            request.setAttribute("empList", emplist);
            target = "success";
        } catch (Exception e) {
            log.error("error fetching project list " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    public ActionForward addTimesheet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        TimeSheetForm tsform = (TimeSheetForm) form;
        TimesheetMaster tsm = new TimesheetMaster();
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        BaseDAO b = new BaseDAO();
        try {
            tsm.setId(tsdao.getLastId() + 1);
            tsm.setProjectId(tsform.getProjectId());
            tsm.setTask(tsform.getTask());
            tsm.setStartTime(b.mySqlDatebFormat(tsform.getStartTime()));
            tsm.setWorkStatus("assigned");
            tsm.setAssignedTo(tsform.getAssignedTo());
            tsm.setRemarks(tsform.getRemarks());

            boolean result = tsdao.save(tsm);

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }
            target = "success";

        } catch (Exception e) {
            log.error("error saving the timesheet " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    public ActionForward loadEmpTimesheet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        TimeSheetForm tsform = (TimeSheetForm) form;
        List<TimesheetMaster> tslist = null;
        HttpSession session = request.getSession();
        try {
            tslist = tsdao.getTaskByEmpId(session.getAttribute("user_id").toString());
            session.setAttribute("taskList", tslist);
            target = "success";
        } catch (Exception e) {
            log.error("error fetching task list " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    public ActionForward loadTaskDesc(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TaskDAO tskdao = factory.createTaskManager();
        Task tsk = null;
        TimeSheetForm tsform = (TimeSheetForm) form;
        try {
            Integer tskid = Integer.parseInt(tsform.getHiddenId());
            tsk = tskdao.getTask(tskid);
            request.setAttribute("tsk", tsk.getTaskDescription());
            target = "success";
        } catch (Exception e) {
            log.error("error fetching task description " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    public ActionForward saveTaskEmp(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        TimeSheetForm tsform = (TimeSheetForm) form;
        TimesheetMaster ts = null;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        try {
            Integer id = tsdao.getIdByTaskId(tsform.getTask().toString());
            ts = tsdao.getTimeSheetById(id);
            ts.setWorkStatus(tsform.getHiddenId());
            ts.setRemarks(tsform.getRemarks());
            if (tsform.getHiddenId().equals("completed")) {
                ts.setEndTime(new Date());
            }

            boolean result = tsdao.save(ts);

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }
            target = "success";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    public ActionForward getTaskReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        List<TimesheetMasterUtil> tmlist = null;
        try {
            tmlist = tsdao.getActiveTimesheet();
            request.setAttribute("timesheetList", tmlist);
            target = "success";
        } catch (Exception e) {
            log.error("error fetching the report " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    public ActionForward getDepartment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        DepartmentDAO ddao = factory.createDepartmentManager();
        TimeSheetHeaderForm timform = (TimeSheetHeaderForm) form;
        List<Department> deptlist = null;
        try {
            deptlist = ddao.getDepartmentByCompanyCode(Integer.parseInt(timform.getCompany()));
            request.setAttribute("departmentlist", deptlist);
            target = "deptlist";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getCompany(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompanyDAO cdao = factory.createCompanyManager();

        List<Company> clist = null;
        try {
            clist = cdao.getAllCompany();
            request.setAttribute("companylist", clist);
            target = "success";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward saveTimesheetHeader(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        TimeSheetHeaderForm tshform = (TimeSheetHeaderForm) form;
        TimesheetHeader tsh = new TimesheetHeader();
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        BaseDAO b = new BaseDAO();
        Date d = new Date();
        HttpSession session = request.getSession(true);
        String creatorId = (String) session.getAttribute("user_id");
        try {
            tsh.setHeaderid(tsdao.getLastIdForTimeSheetHeader().add(BigDecimal.ONE));
            tsh.setCompanyid(new BigDecimal(tshform.getCompany()));
            tsh.setCreationdate(d);
            tsh.setCreatorid(creatorId);
            tsh.setDeptid(new BigDecimal(tshform.getDepartment()));
            tsh.setNormalworkduration(new BigDecimal(tshform.getNormalduration()));
            tsh.setOtdescription(tshform.getOvertimedesc());
            tsh.setOvertimeduration(new BigDecimal(tshform.getOvertimeduration()));
            tsh.setOvertimeslot(tshform.getOvertimelot());
            tsh.setWorkingdate(b.mySqlDatebFormat(tshform.getWorkingdate()));


            boolean result = tsdao.saveHeader(tsh);

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }
            target = "success";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    public ActionForward getTimeSlot(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();

        List<TimeSlot> list = null;
        try {
            list = tsdao.getTimeSlot();
            request.setAttribute("timeslotlist", list);
            target = "success";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getTimeSheetHeader(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimesheetDetailForm tshform = (TimesheetDetailForm) form;
        TimesheetHeader tsh = null;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        List<String> timeslot = null;
        List<String> overtime = null;
        List<TimeSlot> tslist = null;
        TimeSheetMapping tsm = null;
        HttpSession session = request.getSession(true);
        String empId = (String) session.getAttribute("user_id");
        try {
            tsm = tsdao.getTimeSheetMapping(empId);
            tsh = tsm.getHeaderid();
            tslist = tsdao.getTimeSlot();

            int length = tsh.getNormalworkduration().intValue();
            timeslot = new ArrayList();
            overtime = new ArrayList();



            for (int i = 0; i < length; i++) {
                timeslot.add(tslist.get(i).getSlot());
            }
            for (int j = length; j < 24; j++) {
                overtime.add(tslist.get(j).getSlot());
            }
            request.setAttribute("overtime", overtime);
            request.setAttribute("timeslot", timeslot);
            request.setAttribute("timesheetheader", tsh);
            target = "normal";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward saveTimesheetDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        TimesheetDetailForm tsdform = (TimesheetDetailForm) form;

        TimesheetHeader tsh = null;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        BaseDAO b = new BaseDAO();
        Date d = new Date();
        HttpSession session = request.getSession(true);
        String empId = (String) session.getAttribute("user_id");
        boolean result = true;
        try {
            TimeSheetMapping tsm = null;
            tsm = tsdao.getTimeSheetMapping(empId);
            tsh = tsm.getHeaderid();

            int length = tsh.getNormalworkduration().intValue();
            int l2 = tsdform.getSlot().length;
            for (int j = 0; j < l2 - 1; j++) {
                TimesheetDetail tsd = new TimesheetDetail();
                if (j < length) {
                    tsd.setOvertimestatus("N");
                } else {
                    tsd.setOvertimestatus("y");
                }
                tsd.setTimesheetdetailid(tsdao.getLastIdForTimeSheetDetail().add(BigDecimal.ONE));
                tsd.setTimesheetheaderid(tsh.getHeaderid());
                tsd.setProjectid(new BigDecimal(tsdform.getProjectId()));
                tsd.setTimesheetdate(d);
                tsd.setEmpid(empId);
                tsd.setDescription(tsdform.getDesc()[j]);
                tsd.setTimeslot(tsdform.getSlot()[j]);
                result = tsdao.saveTimesheetDeail(tsd);
                tsd.setProjectid(new BigDecimal(tsdform.getProjectId()));
                if (result == false) {
                    break;
                }
            }

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "save";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "save";
            }
            target = "save";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward load(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        TimesheetDetailForm tsdform = (TimesheetDetailForm) form;
        List<EmployeeMaster> emplist = null;
        HttpSession session = request.getSession(true);
        String supid = (String) session.getAttribute("user_id");
        try {
            emplist = tsdao.getAllEmployeeBySupervisorid(supid);
            request.setAttribute("employee", emplist);
            target = "success";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadTimesheetDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        TimesheetDetailForm tsdform = (TimesheetDetailForm) form;
        List<Timesheetutil> tsutil = new ArrayList<Timesheetutil>();


        List<EmployeeMaster> emplist = null;
        List<TimesheetDetail> tslist = null;
        HttpSession session = request.getSession(true);
        try {
            String supid = (String) session.getAttribute("user_id");
            emplist = tsdao.getAllEmployeeBySupervisorid(supid);
            request.setAttribute("employee", emplist);
            String empid = tsdform.getEmployeeId();
            tslist = tsdao.getTimesheetDetailByIdAndDate(empid, tsdform.getTimesheetdate());
            for (TimesheetDetail obj : tslist) {
                Timesheetutil u = new Timesheetutil();
                u.setTimesheetdetailid(obj.getTimesheetdetailid().intValue());
                u.setApprovestatus(obj.getApprovestatus());
                u.setDescription(obj.getDescription());
                u.setEmpid(obj.getEmpid());
                u.setOvertimestatus(obj.getOvertimestatus());
                u.setProjectid(obj.getProjectid().intValue());
                u.setTimesheetdate(obj.getTimesheetdate());
                u.setTimesheetheaderid(obj.getTimesheetheaderid().intValue());
                u.setTimeslot(obj.getTimeslot());

                tsutil.add(u);
            }

            request.setAttribute("detail", tsutil);


            target = "finalize";
        } catch (Exception e) {
            log.error("error from Exception class " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward approveTimesheet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        TimesheetDetailForm tsdform = (TimesheetDetailForm) form;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        List<TimesheetDetail> td;
        TimesheetDetail tsd = new TimesheetDetail();
        List<Timesheetutil> tsutil = new ArrayList<Timesheetutil>();

        boolean result = true;
        try {

            List<Integer> id = new ArrayList<Integer>();
            td = tsdao.getTimesheetDetailByIdAndDate(tsdform.getEmployeeId(), tsdform.getTimesheetdate());
            for (TimesheetDetail t : td) {
                id.add(t.getTimesheetdetailid().intValue());
            }

            Integer[] checked = tsdform.getChecked();
            int l = checked.length;
            Integer[] chi = new Integer[l];

            for (int i = 0; i < l; i++) {
                TimesheetDetail tsdpojo = tsdao.getTimeSheet(checked[i]);
                chi[i] = checked[i];
                tsdpojo.setApprovestatus("approved");
                tsdao.saveTimesheetDeail(tsdpojo);
            }
            int k = 0;
            for (Integer i : id) {
                Boolean flag = false;
                for (int j = 0; j < chi.length; j++) {
                    if (i.equals(chi[j])) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    TimesheetDetail tsdpojo = tsdao.getTimeSheet(i);
                    tsdpojo.setReason(tsdform.getReason()[k]);
                    tsdpojo.setApprovestatus("disapproved");
                    tsdao.saveTimesheetDeail(tsdpojo);
                }
                k++;
            }


            /* td = tsdao.getTimesheetDetailByIdAndDate(tsdform.getEmployeeId(),tsdform.getTimesheetdate());
            int l2 = td.size();
            for (int i = 0; i <l2; i++) {
            td.get(i).setApprovestatus("approved");
            result = tsdao.saveTimesheetDeail(td.get(i));
            if (result == false) {
            break;
            }
            }*/


            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "approve";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "approve";
            }
            target = "approve";
        } catch (Exception e) {
            log.error("error from Exception class " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loaddisapproveTimesheetDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        TimesheetDetailForm tsdform = (TimesheetDetailForm) form;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        List<TimesheetDetail> td = null;
        HttpSession session = request.getSession(true);
        String empid = (String) session.getAttribute("user_id");
        try {

            td = tsdao.getTimesheetByStatus("disapproved", empid);
            request.setAttribute("detail", td);


            target = "disapprove";
        } catch (Exception e) {
            log.error("error from Exception class " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward saveDisapproveTimesheetDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        TimesheetDetailForm tsdform = (TimesheetDetailForm) form;

        TimesheetHeader tsh = null;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        BaseDAO b = new BaseDAO();
        Date d = new Date();
        HttpSession session = request.getSession(true);
        String empId = (String) session.getAttribute("user_id");
        boolean result = true;

        try {

            int l2 = tsdform.getHiddenid().length;
            for (int j = 0; j < l2 - 1; j++) {
                TimesheetDetail tsd = tsdao.getTimeSheet(tsdform.getHiddenid()[j]);



                tsd.setDescription(tsdform.getDesc()[j]);
                tsd.setTimesheetdate(d);

                result = tsdao.saveTimesheetDeail(tsd);

                if (result == false) {
                    break;
                }
            }

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "dsave";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "dsave";
            }
            target = "dsave";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward WorkingTimeOFEmployees(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        TimeSheetForm frm = (TimeSheetForm) form;
        DAOFactory dfact = new DAOFactory();
        TimeSheetDAO tdao = dfact.createTimeSheetManager();
        List<WorkingTimeReportOFEmployees> utilobj = null;

        ProjectDAO prdao = dfact.createProjectManager();
        Project probj = null;
        EmployeeMaster empmaster = null;
        EmployeeMasterDAO empdao = dfact.createEmployeeMasterManager();

        try {

            String date = frm.getTimesheetdate();

            utilobj = tdao.getWorkingTimeReport(date);
            for (WorkingTimeReportOFEmployees w : utilobj) {
                probj = prdao.getProject(w.getProjectid().intValue());
                w.setProjectName(probj.getProjectName());

                empmaster = empdao.getEmployeeMaster(Integer.parseInt(w.getEmployeeId()));
                w.setFirstName(empmaster.getFirstName());


            }
            request.setAttribute("timereport", utilobj);
            target = "success";
        } catch (Exception e) {

            log.error("error saving timesheet data " + e);

        }

        return mapping.findForward(target);

    }

    public ActionForward getTimesheetHeaderForTimesheetMapping(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory dfact = new DAOFactory();
        TimeSheetDAO tdao = dfact.createTimeSheetManager();
        EmployeeMasterDAO edao = dfact.createEmployeeMasterManager();
        List<TimesheetHeader> tshl = null;
        List<EmployeeMaster> em = null;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        BaseDAO b = new BaseDAO();
        try {
            tshl = tdao.getTimesheetheader();
            em = edao.getAllEmployeeMaster();
            request.setAttribute("headerid", tshl);
            request.setAttribute("employee", em);
            target = "mapheader";
        } catch (Exception e) {
            log.error("error from Exception class " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getTimesheetHeaderByHeaderId(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        TimesheetMappingForm tshfrm = (TimesheetMappingForm) form;
        DAOFactory dfact = new DAOFactory();
        TimeSheetDAO tdao = dfact.createTimeSheetManager();
        CompanyDAO cdao = dfact.createCompanyManager();
        EmployeeMasterDAO edao = dfact.createEmployeeMasterManager();
        List<TimesheetHeader> tshl = null;
        List<EmployeeMaster> em = null;
        DepartmentDAO ddao = dfact.createDepartmentManager();
        TimesheetHeaderutil tshu = new TimesheetHeaderutil();


        TimesheetHeader tsh = null;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        BaseDAO b = new BaseDAO();
        Integer headerid = tshfrm.getHeaderid();
        Company company = null;
        String companyname = null;
        Department department = null;
        String departmentname = null;

        try {
            tshl = tdao.getTimesheetheader();
            em = edao.getAllEmployeeMaster();

            tsh = tdao.getTimesheetheader(headerid);
            company = cdao.getCompany(tsh.getCompanyid().intValue());
            tshu.setCompany(company.getCompanyName());
            department = ddao.getDepartment(tsh.getDeptid().intValue());
            departmentname = department.getDepartmentName();
            tshu.setDepartment(departmentname);
            tshu.setWorkingdate(tsh.getWorkingdate().toString());
            tshu.setNormalduration(tsh.getNormalworkduration().intValue());
            tshu.setOvertimeduration(tsh.getOvertimeduration().intValue());
            tshu.setOvertimedesc(tsh.getOtdescription());


            request.setAttribute("headerid", tshl);
            request.setAttribute("employee", em);
            request.setAttribute("header", tshu);
            target = "header";
        } catch (Exception e) {
            log.error("error from Exception class " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward saveTimesheetMapping(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();
        TimesheetMappingForm tshfrm = (TimesheetMappingForm) form;

        TimesheetHeader tsh = null;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        BaseDAO b = new BaseDAO();
        Date d = new Date();

        try {
            TimeSheetMapping tsm = new TimeSheetMapping();

            tsm.setEmpid(tshfrm.getEmpid());
            tsm.setHeaderid(tsdao.getTimesheetheader(tshfrm.getHeaderid()));

            boolean result = tsdao.saveTimesheetmapping(tsm);

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "save";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "save";
            }
            target = "save";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e);
        }
        return mapping.findForward(target);
    }
}
