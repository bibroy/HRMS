/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.ImplClass.LeavePerRoleDAOImpl;
import com.ImplClass.LeaveRequestDAOImpl;
import com.dao.DAOException;
import com.dao.DAOFactory;

import com.dao.EmployeeConfirmationDAO;
import com.dao.EmployeeMasterDAO;
import com.dao.LeaveDetailsDAO;
import com.dao.LeavePerRoleDAO;
import com.dao.LeaveRequestDAO;
import com.forms.LeaveForm;

import com.pojo.EmployeeConfirmation;
import com.pojo.EmployeeMaster;
import com.pojo.Leave;

import com.pojo.LeaveDetails;
import com.pojo.LeaveStatusPeremployee;
import com.util.EmployeeDetailUtil;
import com.util.LeaveAdjustUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import com.util.LeaveRequestUtil;
import java.math.BigDecimal;

/**
 *
 * @author Sumit Kumar
 */
public class LeaveAction extends DispatchAction {

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    String target = null;

    public ActionForward applyLeave(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {



        DAOFactory factory = new DAOFactory();
        LeaveRequestDAO leaveDao = factory.createLeaveRequestManager();
        //Add for dept
        //DepartmentDAO daoDepartment = factory.createDepartmentManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        //List<Department> departmentList = null;
        LeaveRequestDAOImpl leaveImpl = new LeaveRequestDAOImpl();
        HttpSession session = request.getSession(true);
        LeaveForm leaveForm = (LeaveForm) form;
        String employeeId = (String) session.getAttribute("user_id");

        try {
            ////Add for dept
            //departmentList=daoDepartment.getAllDepartment();
            // request.setAttribute("deptList", departmentList);

            //For Leave Report

            //End leave Report

//For Leave apply
            Leave leave = new Leave();
            System.out.println("Form data========>" + leaveForm.getEmpId());
            leave.setEmpid(leaveForm.getEmpId());

            System.out.println("======pojo emp Id===>" + leave.getEmpid());
            leave.setDay(leaveForm.getDay());
            leave.setFromDate(leaveImpl.mySqlDatebFormat(leaveForm.getFromDt()));
            leave.setToDate(leaveImpl.mySqlDatebFormat(leaveForm.getToDt()));
            leave.setReason(leaveForm.getReason());

            leave.setLeaveAddress(leaveForm.getLeaveAddress());
            leave.setLeaveType(leaveForm.getLeavetype());
            leave.setLeaveContactno(leaveForm.getLeaveContactNo());
            leave.setEmail(leaveForm.getEmail());
            leave.setRequestdate(new Date());
            BigDecimal b=new BigDecimal(1.0);
            leave.setRequestid((leaveImpl.getLastRequestId().add(b)));

            Double i=leaveForm.getNoOfDays();
            Double j=leaveForm.getDay();
            Double k=i+j;
            leave.setNoofdays(k);
            
            /*
            Integer n = Integer.parseInt(leaveForm.getNoOfDays());
            float i = n.floatValue();
            float j = leaveForm.getDay();
            float k = i + j;
            leave.setNoofdays((double) k);
             *
             */
            leave.setLeavestatus("W");

            boolean result = leaveDao.sendRequest(leave);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }

            //int count=(int)(leaveForm.getToDt()-leaveForm.getFromDt());
            target = "success";


        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);

        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }

        return mapping.findForward(target);
    }

    public ActionForward viewLeaveRequestData(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.println("Inside View Leave Request Data()");

        LeaveRequestDAOImpl leaveImpl = new LeaveRequestDAOImpl();
        DAOFactory factory = new DAOFactory();
        LeaveRequestDAO leaveDao = factory.createLeaveRequestManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        LeaveForm leaveForm = (LeaveForm) form;
        Leave leave = null;
        List<Leave> list = new ArrayList<Leave>();
        list = leaveDao.getAllEmployees();

        try {
            //leave=new Leave();
            leave = leaveDao.viewLeaveRequestData(leaveForm.getHiddenId());


            leaveForm.setFromDt(leaveImpl.mySQLscreenDateFormat(leave.getFromDate()));
            leaveForm.setToDt(leaveImpl.mySQLscreenDateFormat(leave.getToDate()));
            leaveForm.setReason(leave.getReason());
            leaveForm.setLeavetype(leave.getLeaveType());

            leaveForm.setDay(leave.getDay());
            leaveForm.setLeaveAddress(leave.getLeaveAddress());
            leaveForm.setLeaveContactNo(leave.getLeaveContactno());

            leaveForm.setEmail(leave.getEmail());

            request.setAttribute("empList", list);
            target = "success";



        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);

        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }

        return mapping.findForward(target);

    }

    public ActionForward getAllEmployees(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("Inside getAllEmployee method");

        DAOFactory factory = new DAOFactory();
        LeaveRequestDAO dao = factory.createLeaveRequestManager();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        LeaveForm leaveForm = (LeaveForm) form;

        Leave leave = null;
        List<Leave> list = new ArrayList<Leave>();

        try {

            Object[] data = null;
            list = dao.getAllEmployees();
            Iterator itr = list.iterator();
            List l = new ArrayList();
            while (itr.hasNext()) {
                LeaveRequestUtil leaveUtil = new LeaveRequestUtil();
                data = (Object[]) itr.next();
                leaveUtil.setEmpId(data[0].toString());

                leaveUtil.setLeavetype(data[7].toString());
                leaveUtil.setFromDt((Date) data[1]);
                leaveUtil.setToDt((Date) data[2]);

                leaveUtil.setNoOfDays((Double)data[6]);
                leaveUtil.setLeaveAddress(data[4].toString());
                leaveUtil.setLeaveContactNo(data[5].toString());
                //leaveUtil.setEmail(data[8].toString());

                leaveUtil.setReason(data[3].toString());
                leaveUtil.setRequestId( ((BigDecimal)data[8]).intValue());
                leaveUtil.setRequestDate((Date) data[9]);
                l.add(leaveUtil);
            }
            System.out.println("List values=====>" + l);
            request.setAttribute("empList", l);
            target = "success";

        } catch (DAOException doe) {

            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error", doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            // Report the error using the appropriate name and ID.
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }

        return mapping.findForward(target);

    }

    public ActionForward getAllMasters(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("Inside getAll Master ");

        String target = null;

        LeaveForm leaveForm = (LeaveForm) form;
        //DepartmentForm departmentForm = (DepartmentForm) form;
        DAOFactory factory = new DAOFactory();
        LeaveRequestDAO leaveDao = factory.createLeaveRequestManager();
        LeaveDetailsDAO leaveDetailsDao = (LeaveDetailsDAO) factory.createLeaveDetailsManager();
        //ProjectDAO projectDao=(ProjectDAO) factory.createProjectManager();
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        EmployeeConfirmationDAO employeeConfirmationDAO = factory.createEmployeeConfirmationManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        List<LeaveDetails> leaveList = null;
        // List<Project>projectList=null;
        EmployeeMaster loginEmployeeDetails = null;
        HttpSession session = request.getSession(true);
        String employeeId = (String) session.getAttribute("user_id");


        try {

            //Integer id=Integer.parseInt(str);
            loginEmployeeDetails = (EmployeeMaster) employeeDAO.getEmployeeMasterByEmpId(employeeId);
            Integer designationId = loginEmployeeDetails.getDesignationId();
            System.out.println("Login Employee Details=====>" + loginEmployeeDetails.getEmployeeId());
            String EmployeeId = (String) loginEmployeeDetails.getEmployeeId();
            EmployeeConfirmation employeeConfirmation = employeeConfirmationDAO.getEmployeeConfirmationByEmpId(EmployeeId);
            String status = employeeConfirmation.getStatus().toString();
            System.out.println("Confirmation Status=====>" + status);
            Object[] data = null;
            List list1 = new ArrayList();
            List list2 = new ArrayList();
            leaveForm.setEmpId(loginEmployeeDetails.getEmployeeId());
            //Start getAllLeaves
            leaveList = leaveDetailsDao.getAllLeaves(status, designationId);
            Iterator itr1 = leaveList.iterator();

            while (itr1.hasNext()) {
                LeaveAdjustUtil leaveAdjustUtil = new LeaveAdjustUtil();

                data = (Object[]) itr1.next();
                BigDecimal  b=(BigDecimal)data[1];
                leaveAdjustUtil.setLeaveId(new Integer(b.intValue()));
                leaveAdjustUtil.setLeaveType(data[0].toString());
                list1.add(leaveAdjustUtil);

            }
            request.setAttribute("leaveList", list1);
            //End het All Leaves

            //Start LeaveReport Per Employee

            List leaveReport = leaveDao.getAllLeaveReport(employeeId);
            Iterator itr2 = leaveReport.iterator();
            while (itr2.hasNext()) {

                data = (Object[]) itr2.next();
                LeaveAdjustUtil leaveUtil = new LeaveAdjustUtil();
                leaveUtil.setLeaveType(data[0].toString());
                leaveUtil.setTotalLeave((Double) data[1]);
                leaveUtil.setLeaveTaken((Double) data[2]);
                list2.add(leaveUtil);
                System.out.println("Data from Utility======>" + leaveUtil.getLeaveType() + "==========>" + leaveUtil.getTotalLeave() + "======>" + leaveUtil.getLeaveTaken());
            }

            request.setAttribute("leaveReportList", list2);
            ///End Leave Report per employee

            target = "success";

            System.out.print("*************target=====>" + target);

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
            System.out.println("****************** Exception 1 is " + doe.getMessage());
        } catch (Exception e) {

            System.out.println("****************** Exception 2 is " + e.getMessage());
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward approveLeaveRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;

        HttpSession session = request.getSession(true);
        DAOFactory factory = new DAOFactory();
        LeaveRequestDAO leaveDao = factory.createLeaveRequestManager();
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        LeaveForm leaveForm = (LeaveForm) form;
        EmployeeMaster toEmpDetails = null;
        Leave leave = null;
        boolean status = false;
        EmployeeMaster fromEmployeeDetails = null;

        // List<Leave> list = new ArrayList<Leave>();
        try {
            System.out.println("Inside try block");
            System.out.println("Form======>" + leaveForm);
            String par=request.getParameter("hiddenId");
            System.out.println("leavehidden id ======> "+request.getParameter("hiddenId"));


            leave = leaveDao.viewLeaveRequestData(Integer.parseInt(par));

            // leave = leaveDao.viewLeaveRequestData(1);
            /* list = leaveDao.getAllEmployees();
            Iterator itr=list.iterator();
            while(itr.hasNext())
            {

            leave=(Leave)itr.next();

            //leaveForm.setEmpId(leave.getEmpId());

            }
            leave.setLstatus("Approved");
            status=leaveDao.approve(leave);*/
            //leave = leaveDao.viewLeaveRequestData(leaveForm.getEmpId());


            System.out.println("===Status==" + leave.getLeavestatus());

            leave.setLeavestatus("A");
            leave.setApprovaldate(new Date());
            System.out.println(session.getAttribute("user_id"));
            leave.setApprovalauthoriyEmployeeid(session.getAttribute("user_id").toString());
            System.out.println("===Pojo Status==" + leave.getLeavestatus());
            status = leaveDao.approve(leave);

            //For Leave Adjustment=======================

            LeavePerRoleDAOImpl leavePerRoleDAOImpl = new LeavePerRoleDAOImpl();
            LeaveStatusPeremployee leaveStatusPeremployee = null;
            Double availableDays = null;
            double totalLeave = 0.0;
            double leaveTaken = 0.0;
            double availableLeave = 0.0;

            System.out.println("Employee id from form===>" + leave.getEmpid());
            System.out.println("Leave Id id from form===>" + leave.getLeaveType());
            System.out.println("Appled Days id from form===>" + leave.getNoofdays());

            String empId = leave.getEmpid();
            Integer leaveId = leave.getLeaveType();
            Double halfDay = leave.getDay();
            Double appliedDays = new Double(leave.getNoofdays());
            double appliedLeave = (appliedDays.doubleValue() + halfDay.doubleValue());

            // Object[] data = null;
            //List list = leavePerRoleDAOImpl.getLeaveStatusFromDB(empId, leaveId);
            //System.out.println("List value=======>"+list);

            //Iterator itr = list.iterator();
            //while (itr.hasNext()) {



            //   data = (Object[]) itr.next();

            leaveStatusPeremployee = leavePerRoleDAOImpl.getLeaveStatusFromDB(empId, leaveId);
            Double tl = leaveStatusPeremployee.getTotalleave();

            Double lt = (Double) leaveStatusPeremployee.getLeavetaken();
            System.out.println("From leaveStatusPeremployee====>" + tl + "======>" + lt);

            totalLeave = tl.doubleValue();
            leaveTaken = lt.doubleValue();
            availableLeave = totalLeave - leaveTaken;

            System.out.println("Available Leave======>" + availableLeave + "Appliead Leave======>" + appliedLeave + "=====Toaqtal Leave=====>" + totalLeave);
            if (appliedLeave <= availableLeave) {
                System.out.println("Inside If block");
                leaveStatusPeremployee.setLeavetaken(appliedLeave + leaveTaken);
                leaveStatusPeremployee.setEmpid(empId);
                leaveStatusPeremployee.setLeaveid(leaveId);
                leaveStatusPeremployee.setTotalleave(tl);
            }

            System.out.println("b4 Saving");

            leavePerRoleDAOImpl.assignLeave(leaveStatusPeremployee);
            //}

            //For mail firinng

            String toId = (String) leaveForm.getEmpId();
            toEmpDetails = employeeDAO.getEmployeeMasterByEmpId(toId);

            String fromId = (String) session.getAttribute("user_id");
            //Integer fromId=Integer.parseInt(str);
            fromEmployeeDetails = employeeDAO.getEmployeeMasterByEmpId(fromId);

            String sub = "Your leave Application status";
            String text = "Your applied leave has been approved";
            String reciever = toEmpDetails.getEmailAddress();
            System.out.println("Reciever Email=====>" + reciever);
            String sender = fromEmployeeDetails.getEmailAddress();
            System.out.println("Sender email===>" + sender);

            //MailGenerate.mail(sender , reciever, sub, text);
            target = "success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        System.out.println("Target=================>" + target);
        return mapping.findForward(target);
    }

    public ActionForward rejectLeaveRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;

        HttpSession session = request.getSession(true);
        DAOFactory factory = new DAOFactory();
        LeaveRequestDAO leaveDao = factory.createLeaveRequestManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        LeaveForm leaveForm = (LeaveForm) form;

        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();

        EmployeeMaster fromEmployeeDetails = null;
        EmployeeMaster toEmpDetails = null;
        Leave leave = null;
        boolean status = false;
        try {
            leave = leaveDao.viewLeaveRequestData(leaveForm.getHiddenId());


            System.out.println("Why reject===> Form value" + leaveForm.getWhyReject());

            leave.setLeavestatus("R");

            leave.setWhyreject(leaveForm.getWhyReject());
            leave.setApprovaldate(new Date());
            leave.setApprovalauthoriyEmployeeid(session.getAttribute("user_id").toString());
            status = leaveDao.reject(leave);
            //Mail firiing

            String toId = leaveForm.getEmpId();
            toEmpDetails = employeeDAO.getEmployeeMasterByEmpId(toId);

            String fromId = (String) session.getAttribute("user_id");
            //String fromId=Integer.parseInt(str);
            fromEmployeeDetails = employeeDAO.getEmployeeMasterByEmpId(fromId);

            String sub = "Your leave Application status";
            String text = "Your applied leave has been rejected";
            String reciever = toEmpDetails.getEmailAddress();
            System.out.println("Reciever Email=====>" + reciever);
            String sender = fromEmployeeDetails.getEmailAddress();
            System.out.println("Sender email===>" + sender);

            //MailGenerate.mail(sender , reciever, sub, text);

            target = "success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }
        System.out.println("Target=================>" + target);

        return mapping.findForward(target);
    }

    public ActionForward getSingleEmployeeDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String target = null;

        LeaveForm leaveForm = (LeaveForm) form;
        //DepartmentForm departmentForm = (DepartmentForm) form;
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        LeaveRequestDAO leaveDao = factory.createLeaveRequestManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        EmployeeMaster singleEmployeeDetails = null;
        List<EmployeeMaster> list = new ArrayList<EmployeeMaster>();
        List employeeList = new ArrayList();
        Object[] data = null;
        Iterator itr = null;
        EmployeeDetailUtil employeeDetailUtil = null;

        try {

            // singleEmployeeDetails=(EmployeeMaster)employeeDAO.getEmployeeMasterByEmpId(documentsForm.getEmpId());

            list = leaveDao.getSingleEmployeeDetails(leaveForm.getEmpId());
            itr = list.iterator();
            while (itr.hasNext()) {
                data = (Object[]) itr.next();
                employeeDetailUtil = new EmployeeDetailUtil();
                employeeDetailUtil.setEmployeeId(data[0].toString());
                
                employeeDetailUtil.setBranchName(data[5].toString());
                employeeDetailUtil.setDepartmentName(data[4].toString());
                employeeDetailUtil.setDesignationName(data[7].toString());
                employeeDetailUtil.setDomainId(((BigDecimal) data[6]).intValue());
                employeeDetailUtil.setFirstName(data[1].toString());
                if(data[2]!=null)
                employeeDetailUtil.setMiddleName(data[2].toString());
                employeeDetailUtil.setLastName(data[3].toString());
                employeeList.add(employeeDetailUtil);
            }

            request.setAttribute("employeeList", employeeList);
            target = "success";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }

        return mapping.findForward(target);

    }

    public ActionForward getLeaveReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("Inside getAllLeaveReport");
        String target = null;

        HttpSession session = request.getSession(true);
        DAOFactory factory = new DAOFactory();
        LeaveRequestDAO leaveDao = factory.createLeaveRequestManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        LeaveForm leaveForm = (LeaveForm) form;
        String employeeId = (String) session.getAttribute("user_id");
        Object[] data = null;
        List list = new ArrayList();
        try {

            List leaveReport = leaveDao.getAllLeaveReport(employeeId);
            Iterator itr = leaveReport.iterator();
            while (itr.hasNext()) {

                data = (Object[]) itr.next();
                LeaveAdjustUtil leaveUtil = new LeaveAdjustUtil();
                leaveUtil.setLeaveType(data[0].toString());
                leaveUtil.setTotalLeave((Double) data[1]);
                leaveUtil.setLeaveTaken((Double) data[2]);
                list.add(leaveUtil);
                System.out.println("Data from Utility======>" + leaveUtil.getLeaveType() + "==========>" + leaveUtil.getTotalLeave() + "======>" + leaveUtil.getLeaveTaken());
            }

            request.setAttribute("leaveList", list);

            target = "success";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }

        return mapping.findForward(target);

    }

    public ActionForward validateAppliedLeave(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String target = null;
        System.out.println("Inside validate Leave Method");

        HttpSession session = request.getSession(true);
        DAOFactory factory = new DAOFactory();
        LeaveRequestDAO leaveDao = factory.createLeaveRequestManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        LeaveForm leaveForm = (LeaveForm) form;
        String employeeId = (String) session.getAttribute("user_id");
        Integer leaveId = (Integer) leaveForm.getLeavetype();

        LeavePerRoleDAO leavePerRoleDAO = factory.createLeavePerRoleManager();
        LeaveStatusPeremployee leaveStatusPeremployee = null;
        try {

            leaveStatusPeremployee = leavePerRoleDAO.getLeaveStatusFromDB(employeeId, leaveId);
            Double totalLeave = leaveStatusPeremployee.getTotalleave();
            Double leaveTaken = leaveStatusPeremployee.getLeavetaken();
            double pendingLeave = totalLeave.doubleValue() - leaveTaken.doubleValue();
            String availableLeave = new Double(pendingLeave).toString();
            Double noOfDays = new Double(leaveForm.getNoOfDays());
            Double halfDay =  leaveForm.getDay();
            double totalAppliedDays = noOfDays.doubleValue() + halfDay.doubleValue();
            if (totalAppliedDays > pendingLeave) {

                availableLeave = "";
                request.setAttribute("noOfDays", availableLeave);
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.validate", ""));
                saveErrors(request, messages);

                target = "success";

            }





            target = "success";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }

        return mapping.findForward(target);

    }
}
