/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.ImplClass.ReimbursmentDAOImpl;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.EmployeeMasterDAO;
import com.ImplClass.RecieptDocumentDAOImpl;
import com.dao.ReimbursmentDAO;
import com.forms.ReimbursmentForm;
import com.pojo.EmployeeMaster;
import com.pojo.RecieptDocuments;
import com.pojo.Reimbursment;
import com.util.EmployeeDetailUtil;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import com.util.ReimbursmentUtil;
import com.util.UploadRecieptUtil;
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
public class ReimbursmentAction extends DispatchAction {

    /* forward name="success" path="" */
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
    public ActionForward requestForReimbursment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        ReimbursmentDAO reimbursmentDao = factory.createReimbursmentManager();
        //Add for dept
        //DepartmentDAO daoDepartment = factory.createDepartmentManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        //List<Department> departmentList = null;
        ReimbursmentDAOImpl reimbursmentImpl = new ReimbursmentDAOImpl();
        ReimbursmentForm reimbursmentForm = (ReimbursmentForm) form;
        RecieptDocumentDAOImpl rddl=new RecieptDocumentDAOImpl();
        try {
            ////Add for dept
            //departmentList=daoDepartment.getAllDepartment();
            // request.setAttribute("deptList", departmentList);

            System.out.println("Form file======>" + reimbursmentForm.getRecieptCopy());

            String fileDetail = null;
            fileDetail = UploadRecieptUtil.uploadReciept(request, reimbursmentForm, "recieptCopy");
            System.out.println("File detail in action class =======>" + fileDetail);
            RecieptDocuments docDump = new RecieptDocuments();
            docDump.setFiletype("T");
            docDump.setStatus("Y");
            docDump.setPathname(fileDetail);
            docDump.setRecieptid(rddl.getLastRequestId().add(BigDecimal.ONE));
            
            //docDump.setTrainingId(Integer.parseInt(trForm.getDdlTrainingName()));
            UploadRecieptUtil.addRecieptDoc(docDump);

            Reimbursment reimbursment = new Reimbursment();
            reimbursment.setEmployeeid(reimbursmentForm.getEmpId());

            reimbursment.setRecieptcopy(fileDetail);
            reimbursment.setReason(reimbursmentForm.getReason());

            reimbursment.setEntertainmentCost(new Double(reimbursmentForm.getEntertainmentCost()));
            reimbursment.setMealCost(new Double(reimbursmentForm.getMealCost()));
            reimbursment.setReciept(reimbursmentForm.getReciept());
            reimbursment.setTotalamount(new Double(reimbursmentForm.getTotalAmount()));
            reimbursment.setTravelBy(reimbursmentForm.getTravelBy());
            reimbursment.setTravelCost(new Double(reimbursmentForm.getTravelCost()));
            reimbursment.setTravelFrom(reimbursmentForm.getTravelFrom());
            reimbursment.setTravelTo(reimbursmentForm.getTravelTo());
            reimbursment.setTravelDate(reimbursmentImpl.mySqlDatebFormat(reimbursmentForm.getTravelDate()));
            reimbursment.setTomail("");
            reimbursment.setRequestdate(new Date());
            reimbursment.setRequeststatus("W");
            reimbursment.setId(reimbursmentImpl.getLastRequestId().add(BigDecimal.ONE));
            //reimbursment.setReciept("reciept/" + myRecieptNewName);

            // reimbursment.setReciept("myRecieptNewName");

            boolean result = reimbursmentDao.sendRequest(reimbursment);
            //int count=(int)(leaveForm.getToDt()-leaveForm.getFromDt());

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
            log.error("critical error" + doe);

        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }

        return mapping.findForward(target);
    }

    public ActionForward getAllMasters(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;

        ReimbursmentForm documentsForm = (ReimbursmentForm) form;
        //DepartmentForm departmentForm = (DepartmentForm) form;
        DAOFactory factory = new DAOFactory();
        //DepartmentDAO daoDepartment = factory.createDepartmentManager();
        // DesignationDAO daoDesignation = factory.createDesignationManager();
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

        //List<Project>projectList=null;
        EmployeeMaster loginEmployeeDetails = null;
        HttpSession session = request.getSession(true);

        try {
            String id = (String) session.getAttribute("user_id");
            //System.out.println("employee_id ====>"+str);
            //Integer id=Integer.parseInt(str);
            loginEmployeeDetails = (EmployeeMaster) employeeDAO.getEmployeeMasterByEmpId(id);

            documentsForm.setEmpId(loginEmployeeDetails.getEmployeeId());

            //departmentList = daoDepartment.getAllDepartment();

            //designationList=daoDesignation.getAllDesignation();
            //companyList=daoCompany.getAllCompany();
            //employeeList=employeedao.getAllEmployee();
            //projectList=projectDao.getAllProject();


            //request.setAttribute("deptList", departmentList);

            //request.setAttribute("projectList", projectList);

            //request.setAttribute("desList", designationList);

            //request.setAttribute("companyList",companyList);
            //request.setAttribute("employeeList",employeeList);

            //System.out.println("======Department list======"+departmentList.toString());

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
        String target = null;
        DAOFactory factory = new DAOFactory();
        ReimbursmentDAO reimbursmentDao = factory.createReimbursmentManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        ReimbursmentForm reimbursmentForm = (ReimbursmentForm) form;
        Reimbursment reimbursment = null;
        List<Reimbursment> list = new ArrayList<Reimbursment>();
        try {


            /* ticket = new AirTicketRequest();
            list = ticketDao.getAllEmployees();

            request.setAttribute("empList", list);*/




            Object[] data = null;
            list = reimbursmentDao.getAllEmployees();
            Iterator itr = list.iterator();
            List l = new ArrayList();
            while (itr.hasNext()) {
                ReimbursmentUtil reimbursmentUtil = new ReimbursmentUtil();
                data = (Object[]) itr.next();


                reimbursmentUtil.setEmpId(data[0].toString());




                reimbursmentUtil.setEntertainmentCost((Double) data[9]);
                reimbursmentUtil.setMealCost((Double) data[8]);
                reimbursmentUtil.setTravelCost((Double) data[7]);

                reimbursmentUtil.setTravelDate((Date) data[3]);
                reimbursmentUtil.setTravelBy(data[6].toString());

                reimbursmentUtil.setTravelFrom(data[4].toString());
                reimbursmentUtil.setReason(data[1].toString());
                reimbursmentUtil.setTravelTo(data[5].toString());
                reimbursmentUtil.setRequestCode(((BigDecimal)data[11]).intValue());
                if(data[2]!=null)
                reimbursmentUtil.setReciept(data[2].toString());
                reimbursmentUtil.setTravelFrom(data[6].toString());
                reimbursmentUtil.setTotalAmount((Double) data[10]);
                reimbursmentUtil.setRequestDate((Date) data[12]);

                l.add(reimbursmentUtil);
                System.out.println("End of In action class getEmployee method");

            }

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

    public ActionForward approveReimbursment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;

        DAOFactory factory = new DAOFactory();
        ReimbursmentDAO reimbursmentDao = factory.createReimbursmentManager();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        ReimbursmentForm reimbursmentForm = (ReimbursmentForm) form;
        Reimbursment reimbursment = null;
        boolean status = false;
        HttpSession session = request.getSession(true);
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        EmployeeMaster toEmpDetails = null;
        EmployeeMaster fromEmployeeDetails = null;
        try {

            //System.out.println("ticketForm.getHiddenId()=========>"+ticketForm.getHiddenId());
            reimbursment = reimbursmentDao.viewReimbursmentRequestData(reimbursmentForm.getHiddenId());

            System.out.println("*******************************");
            reimbursment.setApprovaldate(new Date());
            reimbursment.setApprovalauthoriyEmployeeid((String) session.getAttribute("user_id"));

            reimbursment.setRequeststatus("A");
            status = reimbursmentDao.approve(reimbursment);

            //For mail fireing

            String toId = (String) reimbursmentForm.getEmpId();
            toEmpDetails = employeeDAO.getEmployeeMasterByEmpId(toId);


            String fromId = (String) session.getAttribute("user_id");
            //Integer fromId=Integer.parseInt(str);
            fromEmployeeDetails = employeeDAO.getEmployeeMasterByEmpId(fromId);

            String sub = "Your Air ticket Application status";
            String text = "Your applied Airticket has been approved";
            String reciever = toEmpDetails.getEmailAddress();
            System.out.println("Reciever Email=====>" + reciever);
            String sender = fromEmployeeDetails.getEmailAddress();
            System.out.println("Sender email===>" + sender);


            // MailGenerate.mail(sender , reciever, sub, text);



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

    public ActionForward rejectReimbursment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        DAOFactory factory = new DAOFactory();
        ReimbursmentDAO reimbursmentDao = factory.createReimbursmentManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        ReimbursmentForm reimbursmentForm = (ReimbursmentForm) form;
        Reimbursment reimbursment = null;
        boolean status = false;
        HttpSession session = request.getSession(true);
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        EmployeeMaster toEmpDetails = null;
        EmployeeMaster fromEmployeeDetails = null;
        try {

            reimbursment = reimbursmentDao.viewReimbursmentRequestData(reimbursmentForm.getHiddenId());

            System.out.println("*******************************");
            reimbursment.setApprovaldate(new Date());
            reimbursment.setApprovalauthoriyEmployeeid((String) session.getAttribute("user_id"));

            reimbursment.setRequeststatus("R");
            status = reimbursmentDao.reject(reimbursment);

            //For mail generate

            String toId = (String) reimbursmentForm.getEmpId();
            toEmpDetails = employeeDAO.getEmployeeMasterByEmpId(toId);


            String fromId = (String) session.getAttribute("user_id");
            //Integer fromId=Integer.parseInt(str);
            fromEmployeeDetails = employeeDAO.getEmployeeMasterByEmpId(fromId);

            String sub = "Your Air ticket Application status";
            String text = "Your applied Airticket has been rejected";
            String reciever = toEmpDetails.getEmailAddress();
            System.out.println("Reciever Email=====>" + reciever);
            String sender = fromEmployeeDetails.getEmailAddress();
            System.out.println("Sender email===>" + sender);


            // MailGenerate.mail(sender , reciever, sub, text);



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

        ReimbursmentForm reimbursmentForm = (ReimbursmentForm) form;
        //DepartmentForm departmentForm = (DepartmentForm) form;
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        ReimbursmentDAO reimbursmentDao = factory.createReimbursmentManager();
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

            list = reimbursmentDao.getSingleEmployeeDetails(reimbursmentForm.getEmpId());
            itr = list.iterator();
            while (itr.hasNext()) {
                data = (Object[]) itr.next();
                employeeDetailUtil = new EmployeeDetailUtil();
                employeeDetailUtil.setEmployeeId(data[0].toString());
                ;
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
