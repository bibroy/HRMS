/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.ImplClass.LoanDAOImpl;

import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.EmployeeMasterDAO;
import com.dao.LoanDAO;
import com.forms.LoanForm;

import com.pojo.EmployeeMaster;
import com.pojo.Loan;
import com.util.EmployeeDetailUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.actions.DispatchAction;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.util.LoanUtil;
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
public class LoanAction extends DispatchAction {

    String target = null;

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward applyForLoan(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.println("********************");

        DAOFactory factory = new DAOFactory();
        LoanDAO advancedSalaryReqDao = factory.createLoanManager();
        LoanDAOImpl loanDaoImpl = new LoanDAOImpl();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();


        LoanForm loanForm = (LoanForm) form;
        try {


            Loan loanPojo = new Loan();

            loanPojo.setEmployeeid(loanForm.getEmpId());


            loanPojo.setDeductionstartmonth(loanDaoImpl.mySqlDatebFormat(loanForm.getDeductstartmonth()));
            
            loanPojo.setNoofinstallment(new BigDecimal(loanForm.getInstallment()));

            loanPojo.setReason(loanForm.getReason());
            loanPojo.setLoanamount(loanForm.getReqAmt());
            loanPojo.setTotalsalary(loanForm.getTotalSal());
            loanPojo.setRequestdate(new Date());
            BigDecimal b=new BigDecimal(1.0);

            loanPojo.setRequestid(loanDaoImpl.getLastRequestId().add(b));
            
            loanPojo.setApprovalstatus("W");

            boolean result = advancedSalaryReqDao.sendRequest(loanPojo);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }


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

    public ActionForward getAllMasters(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
       

        LoanForm loanForm = (LoanForm) form;
        //DepartmentForm departmentForm = (DepartmentForm) form;
        DAOFactory factory = new DAOFactory();
        // DepartmentDAO daoDepartment = factory.createDepartmentManager();
        //DesignationDAO daoDesignation = factory.createDesignationManager();
        //CompanyDAO daoCompany = factory.createCompanyManager();
        //EmployeeDAO employeedao = (EmployeeDAO) factory.createEmployeeManager();

        //ProjectDAO projectDao=(ProjectDAO) factory.createProjectManager();
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

            loanForm.setEmpId(loginEmployeeDetails.getEmployeeId());

            // departmentList = daoDepartment.getAllDepartment();


            //designationList=daoDesignation.getAllDesignation();
            //companyList=daoCompany.getAllCompany();
            //employeeList=employeedao.getAllEmployee();
            // projectList=projectDao.getAllProject();


            //request.setAttribute("deptList", departmentList);

            //request.setAttribute("projectList", projectList);

            //request.setAttribute("desList", designationList);
            //System.out.println("In Action class ======the value of list" + departmentList+"the value of Project list "+projectList+"the value of Designation list "+designationList);

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
        LoanDAO loanDao = factory.createLoanManager();
        LoanDAOImpl loanImpl = new LoanDAOImpl();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        LoanForm loanForm = (LoanForm) form;
        Loan loanPojo = null;
        try {
            double totalSalary = 0.0;
            List totalSal = null;
            //asalaryr = advancedSalaryReqDao.viewAdvancedSalaryRequestData(advancedSalaryReqForm.getHiddenId());
            totalSal = loanDao.getTotalSalary(loanForm.getHiddenId());
            System.out.println("Employee Id====>" + loanForm.getHiddenId());
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

    public ActionForward getAllEmployees(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("Inside Action class getAllEmployee method");

        DAOFactory factory = new DAOFactory();
        LoanDAO dao = factory.createLoanManager();
        HttpSession session = request.getSession(true);
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        LoanForm loanForm = (LoanForm) form;

        Loan leave = null;
        List<Loan> list = new ArrayList<Loan>();

        try {
            Object[] data = null;
            list = dao.getAllEmployees();
            Iterator itr = list.iterator();
            List l = new ArrayList();
            while (itr.hasNext()) {
                LoanUtil loanUtil = new LoanUtil();
                data = (Object[]) itr.next();

                loanUtil.setEmpId(data[0].toString());

                loanUtil.setTotalSal(data[1].toString());
                loanUtil.setReqAmt(data[2].toString());

                loanUtil.setDeductstartmonth((Date) data[4]);

                loanUtil.setReason(data[6].toString());
                loanUtil.setInstallment(data[3].toString());
                loanUtil.setRequestId(((BigDecimal)data[5]).intValue());
                loanUtil.setRequestDate((Date) data[7]);

                 l.add(loanUtil);
            }

            System.out.println("List values=====>" + l);
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

    public ActionForward approveLoanRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;

        HttpSession session = request.getSession(true);
        DAOFactory factory = new DAOFactory();
        LoanDAO loanDAO = factory.createLoanManager();
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        LoanForm loanForm = (LoanForm) form;
        EmployeeMaster toEmpDetails = null;
        Loan loan = null;
        boolean status = false;
        EmployeeMaster fromEmployeeDetails = null;

        // List<Leave> list = new ArrayList<Leave>();
        try {
            System.out.println("Inside Loan Action");
            System.out.println("Id from JSP:==" + loanForm.getHiddenId());

            loan = loanDAO.viewLoanRequestData(loanForm.getHiddenId());

            System.out.println("In Loan Action loan.getApprovalStatus()======>" + loan.getApprovalstatus());

            loan.setApprovalstatus("A");
            loan.setApprovaldate(new Date());
            loan.setApprovalauthoriyEmployeeid((String) session.getAttribute("user_id"));
            status = loanDAO.approve(loan);

            //For mail firinng

            /*  Integer toId=new Integer(loanForm.getHiddenId());
            toEmpDetails=employeeDAO.getEmployee(toId);

            String str=(String)session.getAttribute("user_id");
            Integer fromId=Integer.parseInt(str);
            fromEmployeeDetails=employeeDAO.getEmployee(fromId);

            String sub="Your Loan Application status";
            String text="Your applied Loan has been approved";
            String reciever=toEmpDetails.getEmail();
            System.out.println("Reciever Email=====>"+reciever);
            String sender=fromEmployeeDetails.getEmail();
            System.out.println("Sender email===>"+sender);

            MailGenerate.mail(sender , reciever, sub, text);*/

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
        LoanDAO leaveDao = factory.createLoanManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        LoanForm loanForm = (LoanForm) form;

        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();

        EmployeeMaster fromEmployeeDetails = null;
        EmployeeMaster toEmpDetails = null;
        Loan loan = null;
        boolean status = false;
        try {
            loan = leaveDao.viewLoanRequestData(loanForm.getHiddenId());

            loan.setApprovalstatus("R");
            loan.setApprovaldate(new Date());
            loan.setApprovalauthoriyEmployeeid((String) session.getAttribute("user_id"));
            status = leaveDao.reject(loan);
            //Mail firiing

            String toId = (String) loanForm.getEmpId();
            toEmpDetails = employeeDAO.getEmployeeMasterByEmpId(toId);

            String fromId = (String) session.getAttribute("user_id");
            //Integer fromId=Integer.parseInt(str);
            fromEmployeeDetails = employeeDAO.getEmployeeMasterByEmpId(fromId);

            String sub = "Your leave Application status";
            String text = "Your applied leave has been rejected";
            String reciever = toEmpDetails.getEmailAddress();
            System.out.println("Reciever Email=====>" + reciever);
            String sender = fromEmployeeDetails.getEmailAddress();
            System.out.println("Sender email===>" + sender);

            //MailGenerate.mail(sender , reciever, sub, text)

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

        LoanForm loanForm = (LoanForm) form;
        //DepartmentForm departmentForm = (DepartmentForm) form;
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        LoanDAO loanDAO = factory.createLoanManager();
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

            list = loanDAO.getSingleEmployeeDetails(loanForm.getEmpId());
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
