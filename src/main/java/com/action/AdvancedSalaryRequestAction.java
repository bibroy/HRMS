/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.ImplClass.AdvancedSalaryRequestDAOImpl;
import com.dao.AdvancedSalaryRequestDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.EmployeeMasterDAO;
import com.forms.AdvancedSalaryRequestForm;
import com.pojo.AdvancedSalaryRequest;

import com.pojo.EmployeeMaster;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.ImplClass.LoanDAOImpl;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import com.util.AdvancedSalaryRequestUtil;
import com.util.EmployeeDetailUtil;
import java.math.BigDecimal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Sumit Kumar
 */
public class AdvancedSalaryRequestAction extends DispatchAction {

    /* forward name="success" path="" */
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward applyForAdvancedSalary(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.println("********************");

        DAOFactory factory = new DAOFactory();
        AdvancedSalaryRequestDAO advancedSalaryReqDao = factory.createAdvancedSalaryRequestManager();
        AdvancedSalaryRequestDAOImpl asdi = new AdvancedSalaryRequestDAOImpl();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        LoanDAOImpl loanDaoImpl=new LoanDAOImpl();
        AdvancedSalaryRequestForm advancedSalaryReqForm = (AdvancedSalaryRequestForm) form;
        try {

            AdvancedSalaryRequest advancedSalaryReq = new AdvancedSalaryRequest();
            advancedSalaryReq.setEmployeeId(advancedSalaryReqForm.getEmpId());

            advancedSalaryReq.setDeductionstartmonth(loanDaoImpl.mySqlDatebFormat(advancedSalaryReqForm.getDeductmonth()));
            advancedSalaryReq.setDeductionstartmonth(asdi.mySqlDatebFormat(advancedSalaryReqForm.getDeductstartmonth()));
            advancedSalaryReq.setNoofinstallment(new BigDecimal(advancedSalaryReqForm.getInstallment()));

            advancedSalaryReq.setReason(advancedSalaryReqForm.getReason());
            advancedSalaryReq.setAppliedamount(advancedSalaryReqForm.getReqAmt());
            advancedSalaryReq.setTotalsalary(new BigDecimal(advancedSalaryReqForm.getTotalSal()));
            //advancedSalaryReq.setSuperviser(advancedSalaryReqForm.getSuperviser());
            advancedSalaryReq.setApprovalstatus("W");
            advancedSalaryReq.setRequestdate(new Date());
            advancedSalaryReq.setRequestid(asdi.getLastRequestId().add(BigDecimal.ONE));
            boolean result = advancedSalaryReqDao.sendRequest(advancedSalaryReq);

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }
            target = "success";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            System.out.println("critical error" + doe);

        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            System.out.println("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getAllEmployees(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        String target = null;
        DAOFactory factory = new DAOFactory();
        AdvancedSalaryRequestDAO ticketDao = factory.createAdvancedSalaryRequestManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        AdvancedSalaryRequestForm ticketForm = (AdvancedSalaryRequestForm) form;
        AdvancedSalaryRequest ticket = null;
        List<AdvancedSalaryRequest> list = new ArrayList<AdvancedSalaryRequest>();
        try {
            Object[] data = null;
            list = ticketDao.getAllEmployees();
            Iterator itr = list.iterator();
            List l = new ArrayList();
            while (itr.hasNext()) {
                AdvancedSalaryRequestUtil salaryUtil = new AdvancedSalaryRequestUtil();
                data = (Object[]) itr.next();

                salaryUtil.setEmpId(data[0].toString());

                System.out.println("Reason======>" + data[5].toString());
                salaryUtil.setReason(data[5].toString());
                System.out.println("Reason from util======>" + salaryUtil.getReason());
                salaryUtil.setDeductstartmonth((Date) data[4]);
                salaryUtil.setReqAmt(data[2].toString());
                salaryUtil.setInstallment(data[3].toString());

                salaryUtil.setTotalSal(data[1].toString());
                salaryUtil.setId(((BigDecimal)data[6]).intValue());
                salaryUtil.setRequestDate((Date) data[7]);
                l.add(salaryUtil);
            }
            request.setAttribute("empList", l);

        } catch (DAOException doe) {

            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error", doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            // Report the error using the appropriate name and ID.
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }

        target = "success";
        return mapping.findForward(target);
    }

    public ActionForward approveAdvancedSalaryRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        DAOFactory factory = new DAOFactory();
        AdvancedSalaryRequestDAO asalaryrDao = factory.createAdvancedSalaryRequestManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        AdvancedSalaryRequestForm salaryForm = (AdvancedSalaryRequestForm) form;
        AdvancedSalaryRequest asalaryr = null;
        boolean status = false;
        HttpSession session = request.getSession(true);
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        EmployeeMaster toEmpDetails = null;
        EmployeeMaster fromEmployeeDetails = null;
        try {
            asalaryr = asalaryrDao.viewAdvancedSalaryRequestData(salaryForm.getHiddenId());
            asalaryr.setApprovalstatus("A");
            asalaryr.setApprovaldate(new Date());
            asalaryr.setApprovalauthoriyEmployeeid((String) session.getAttribute("user_id"));

            status = asalaryrDao.approve(asalaryr);
            //For mail generate

            String toId = (String) salaryForm.getEmpId();
            toEmpDetails = employeeDAO.getEmployeeMasterByEmpId(toId);

            String fromId = (String) session.getAttribute("user_id");

            fromEmployeeDetails = employeeDAO.getEmployeeMasterByEmpId(fromId);

            String sub = "Your Advanced salary Application status";
            String text = "Your applied Advanced Salary has been approved";
            String reciever = toEmpDetails.getEmailAddress();
            // System.out.println("Reciever Email=====>"+reciever);
            String sender = fromEmployeeDetails.getEmailAddress();
            //String sender="swarnendum@netit.com";
            // String reciever="swarnendum@netit.com";
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

    public ActionForward rejectAdvancedSalaryRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        DAOFactory factory = new DAOFactory();
        AdvancedSalaryRequestDAO asalaryrDao = factory.createAdvancedSalaryRequestManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        AdvancedSalaryRequestForm salaryForm = (AdvancedSalaryRequestForm) form;
        AdvancedSalaryRequest asalaryr = null;
        boolean status = false;
        HttpSession session = request.getSession(true);
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        EmployeeMaster toEmpDetails = null;
        EmployeeMaster fromEmployeeDetails = null;

        try {

            asalaryr = asalaryrDao.viewAdvancedSalaryRequestData(salaryForm.getHiddenId());

            System.out.println("*******************************");
            asalaryr.setApprovalstatus("R");
            asalaryr.setApprovaldate(new Date());
            asalaryr.setApprovalauthoriyEmployeeid((String) session.getAttribute("user_id"));
            status = asalaryrDao.reject(asalaryr);

            //For mail generate

            String toId = (String) salaryForm.getEmpId();
            toEmpDetails = employeeDAO.getEmployeeMasterByEmpId(toId);

            String fromId = (String) session.getAttribute("user_id");
            //Integer fromId=Integer.parseInt(str);
            fromEmployeeDetails = employeeDAO.getEmployeeMasterByEmpId(fromId);

            String sub = "Your Advanced salary Application status";
            String text = "Your applied Advanced Salary  has been rejected";
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

    public ActionForward getAllMasters(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;

        AdvancedSalaryRequestForm salaryForm = (AdvancedSalaryRequestForm) form;
        //DepartmentForm departmentForm = (DepartmentForm) form;
        DAOFactory factory = new DAOFactory();
        // DepartmentDAO daoDepartment = factory.createDepartmentManager();
        //  DesignationDAO daoDesignation = factory.createDesignationManager();
        //CompanyDAO daoCompany = factory.createCompanyManager();
        //EmployeeDAO employeedao = (EmployeeDAO) factory.createEmployeeManager();

        // ProjectDAO projectDao=(ProjectDAO) factory.createProjectManager();
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        //List<Department> departmentList = null;
        //List<Designation> designationList = null;
        // List<Company>  companyList = new ArrayList<Company>();
        // List<EmpDetails>employeeList = new ArrayList<EmpDetails>();

        // List<Project>projectList=null;

        HttpSession session = request.getSession(true);
        EmployeeMaster loginEmployeeDetails = null;
        try {
            String id = (String) session.getAttribute("user_id");
            //Integer id=Integer.parseInt(str);
            loginEmployeeDetails = (EmployeeMaster) employeeDAO.getEmployeeMasterByEmpId(id);

            salaryForm.setEmpId(loginEmployeeDetails.getEmployeeId());

            // departmentList = daoDepartment.getAllDepartment();

            // designationList=daoDesignation.getAllDesignation();
            //companyList=daoCompany.getAllCompany();
            //employeeList=employeedao.getAllEmployee();
            // projectList=projectDao.getAllProject();


            //request.setAttribute("deptList", departmentList);

            //request.setAttribute("projectList", projectList);

            // request.setAttribute("desList", designationList);
            // System.out.println("In Action class ======the value of list" + departmentList+"the value of Project list "+projectList+"the value of Designation list "+designationList);

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

        System.out.println("Value of target===========>" + target);
        return mapping.findForward(target);
    }

    public ActionForward getTotalSalary(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;

        System.out.println("Inside getTotalSalaray() method");
        DAOFactory factory = new DAOFactory();
        AdvancedSalaryRequestDAO advancedSalaryReqDao = factory.createAdvancedSalaryRequestManager();
        AdvancedSalaryRequestDAOImpl asdi = new AdvancedSalaryRequestDAOImpl();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        AdvancedSalaryRequestForm advancedSalaryReqForm = (AdvancedSalaryRequestForm) form;
        AdvancedSalaryRequest asalaryr = null;
        try {
            double totalSalary = 0.0;
            List totalSal = null;
            //asalaryr = advancedSalaryReqDao.viewAdvancedSalaryRequestData(advancedSalaryReqForm.getHiddenId());
            totalSal = advancedSalaryReqDao.getTotalSalary(advancedSalaryReqForm.getHiddenId());
            System.out.println("Employee Id====>" + advancedSalaryReqForm.getHiddenId());
            //totalSal=advancedSalaryReqDao.getTotalSalary(1234);
            Iterator itr = totalSal.iterator();
            while (itr.hasNext()) {
                Double salary = (Double) itr.next();
                System.out.println("Salary===>" + salary);
                totalSalary = totalSalary + salary.doubleValue();
            }
            System.out.println("Total Salary=========>" + totalSalary);
            //advancedSalaryReqForm.setTotalSal(totalSalary);
            request.setAttribute("totalSalary", totalSalary);
            target = "success";
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

    public ActionForward getSingleEmployeeDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String target = null;

        AdvancedSalaryRequestForm documentsForm = (AdvancedSalaryRequestForm) form;
        //DepartmentForm departmentForm = (DepartmentForm) form;
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        AdvancedSalaryRequestDAO advancedSalaryRequestDAO = factory.createAdvancedSalaryRequestManager();
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

            list = advancedSalaryRequestDAO.getSingleEmployeeDetails(documentsForm.getEmpId());
            itr = list.iterator();
            while (itr.hasNext()) {
                data = (Object[]) itr.next();
                employeeDetailUtil = new EmployeeDetailUtil();
                employeeDetailUtil.setEmployeeId(data[0].toString());
                employeeDetailUtil.setBranchName(data[5].toString());
                employeeDetailUtil.setDepartmentName(data[4].toString());
                employeeDetailUtil.setDesignationName(data[7].toString());
                employeeDetailUtil.setDomainId(((BigDecimal)data[6]).intValue());
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
}
