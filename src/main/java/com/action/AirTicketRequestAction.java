/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.ImplClass.AirTicketRequestDAOImpl;
import com.dao.AdvancedSalaryRequestDAO;
import com.dao.AirTicketRequestDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.EmployeeFamilyDetailsDAO;
import com.dao.EmployeeMasterDAO;
import com.ImplClass.PassengersDetailsDAOImpl;
import com.dao.PassengersDetailsDAO;
import com.dao.PurposeOfTripDAO;
import com.forms.AdvancedSalaryRequestForm;
import com.forms.AirTicketRequestForm;
import com.pojo.Airticket;
import com.pojo.EmployeeFamilyDetails;
import com.pojo.EmployeeMaster;

import com.pojo.PassengerDetails;
import java.util.ArrayList;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import com.util.AirTicketRequestUtil;
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
public class AirTicketRequestAction extends DispatchAction {

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
    public ActionForward applyForTicket(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("********************");
        String target = null;
        DAOFactory factory = new DAOFactory();
        AirTicketRequestDAO airTicketReqDao = factory.createAirTicketRequestManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        HttpSession httpSession = request.getSession();
        AirTicketRequestDAOImpl atrdi = new AirTicketRequestDAOImpl();
        AirTicketRequestForm airTicketReqForm = (AirTicketRequestForm) form;
        EmployeeFamilyDetailsDAO employeeFamilyDetailsDAO = factory.createEmployeeFamilyDetailsManager();
        PassengersDetailsDAO passengersDetailsDAO = factory.createPassengersDetailsManager();
        EmployeeFamilyDetails employeeFamilyDetails = null;
        PassengerDetails passengersDetails = null;
        String employeeId = (String) httpSession.getAttribute("user_id");
        boolean result2 = false;
        try {

            Airticket airTicketReq = new Airticket();
            airTicketReq.setEmployeeCode(airTicketReqForm.getEmpId());
            airTicketReq.setAirlineName(airTicketReqForm.getAirlineName());
            airTicketReq.setDestination(airTicketReqForm.getDestination());
            airTicketReq.setDepartureDate(atrdi.mySqlDatebFormat(airTicketReqForm.getDepDate()));
            airTicketReq.setReturndate(atrdi.mySqlDatebFormat(airTicketReqForm.getReturnDate()));
            airTicketReq.setPurposeOdTrip(airTicketReqForm.getPurOfTrip());
            airTicketReq.setRequestdate(new Date());
            airTicketReq.setCarClass(airTicketReqForm.getCarClass());
            airTicketReq.setDepartureTime(airTicketReqForm.getDepartureTime());
            airTicketReq.setTravelFrom(airTicketReqForm.getFrom());
            airTicketReq.setIncludeCar(airTicketReqForm.getIncludeCar());
            airTicketReq.setTripClass(airTicketReqForm.getTripClass());
            airTicketReq.setSeatLocation(airTicketReqForm.getSeatLocation());
            airTicketReq.setReturnTime(airTicketReqForm.getReturnTime());
            airTicketReq.setNonSmokingRoom(airTicketReqForm.getNonSmokingRoom());

            airTicketReq.setRequestid(atrdi.getLastRequestId().add(BigDecimal.ONE));
            
            airTicketReq.setApprovalstatus("W");

            boolean result1 = airTicketReqDao.sendRequest(airTicketReq);

            System.out.println("B4 Member details=====================");
            // for Passengers details
            String memberId[] = request.getParameterValues("status");

            if (memberId != null)
            {
                System.out.println("Member Id======>" + memberId[0]);
                PassengersDetailsDAOImpl pdi=null;

                for (int i = 0; i < memberId.length; i++) {
                    System.out.println("Check box values========>" + memberId[i]);
                    employeeFamilyDetails = employeeFamilyDetailsDAO.getEmployeeFamilyDetails(new Integer(memberId[i]));
                    passengersDetails = new PassengerDetails();
                    pdi=new PassengersDetailsDAOImpl();
                    passengersDetails.setId(pdi.getLastRequestId().add(BigDecimal.ONE));
                    passengersDetails.setFamilyid(employeeFamilyDetails.getId().intValue());
                    passengersDetails.setMemberName(employeeFamilyDetails.getFamilyMemberName());
                    passengersDetails.setMemberDob(employeeFamilyDetails.getDobOfMember());
                    passengersDetails.setMemberRelation(employeeFamilyDetails.getRelation());
                    passengersDetails.setEmployeeid(employeeId);
                    result2 = passengersDetailsDAO.savePassengerDetails(passengersDetails);
                }
            }

            if (result1 == true) {
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
    public ActionForward getAllEmployees(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        String target = null;
        DAOFactory factory = new DAOFactory();
        AirTicketRequestDAO ticketDao = factory.createAirTicketRequestManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        AirTicketRequestForm ticketForm = (AirTicketRequestForm) form;
        Airticket ticket = null;
        List<Airticket> list = new ArrayList<Airticket>();
        try {

            /* ticket = new AirTicketRequest();
            list = ticketDao.getAllEmployees();

            request.setAttribute("empList", list);*/
            Object[] data = null;
            list = ticketDao.getAllEmployees();
            Iterator itr = list.iterator();
            List l = new ArrayList();
            while (itr.hasNext()) {
                AirTicketRequestUtil ticketUtil = new AirTicketRequestUtil();
                data = (Object[]) itr.next();
                ticketUtil.setEmpId(data[0].toString());

                ticketUtil.setRetDate((Date) data[5]);

                ticketUtil.setDepDate((Date) data[4]);
                ticketUtil.setDestination(data[2].toString());

                ticketUtil.setPurOfTrip(data[3].toString());

                ticketUtil.setAirlineName(data[1].toString());
                ticketUtil.setRequestId(((BigDecimal)data[6]).intValue());
                ticketUtil.setRequestDate((Date) data[7]);
                l.add(ticketUtil);
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

    public ActionForward approveAirTicket(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;

        DAOFactory factory = new DAOFactory();
        AirTicketRequestDAO ticketDao = factory.createAirTicketRequestManager();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        AirTicketRequestForm ticketForm = (AirTicketRequestForm) form;
        Airticket ticket = null;
        boolean status = false;
        HttpSession session = request.getSession(true);
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        EmployeeMaster toEmpDetails = null;
        EmployeeMaster fromEmployeeDetails = null;
        try {
            System.out.println("ticketForm.getHiddenId()=========>" + ticketForm.getHiddenId());
            ticket = ticketDao.viewAirTicketRequestData(ticketForm.getHiddenId());

            System.out.println("*******************************");
            ticket.setApprovalstatus("A");
            ticket.setApprovaldate(new Date());
            ticket.setApprovalauthoriyEmployeeid((String) session.getAttribute("user_id"));
            status = ticketDao.approve(ticket);

            //For mail fireing
            String toId = (String) ticketForm.getEmpId();
            toEmpDetails = employeeDAO.getEmployeeMasterByEmpId(toId);

            String fromId = (String) session.getAttribute("user_id");
            //Integer fromId=Integer.parseInt(str);
            fromEmployeeDetails = employeeDAO.getEmployeeMasterByEmpId(fromId);

            String sub = "Your Air ticket Application status";
            String text = "Your applied Airticket has been approved";
            //String reciever = toEmpDetails.getEmailAddress();
            //System.out.println("Reciever Email=====>" + reciever);
            //String sender = fromEmployeeDetails.getEmailAddress();
            //System.out.println("Sender email===>" + sender);
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

    public ActionForward rejectAirTicket(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        DAOFactory factory = new DAOFactory();
        AirTicketRequestDAO ticketDao = factory.createAirTicketRequestManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        AirTicketRequestForm ticketForm = (AirTicketRequestForm) form;
        Airticket ticket = null;
        boolean status = false;
        HttpSession session = request.getSession(true);
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        EmployeeMaster toEmpDetails = null;
        EmployeeMaster fromEmployeeDetails = null;
        try {

            ticket = ticketDao.viewAirTicketRequestData(ticketForm.getHiddenId());
            System.out.println("*******************************");

            ticket.setApprovalstatus("R");
            status = ticketDao.reject(ticket);

            //For mail generate

            String toId = (String) ticketForm.getEmpId();
            toEmpDetails = employeeDAO.getEmployeeMasterByEmpId(toId);

            String fromId = (String) session.getAttribute("user_id");
            //Integer fromId=Integer.parseInt(str);
            fromEmployeeDetails = employeeDAO.getEmployeeMasterByEmpId(fromId);

            //String sub = "Your Air ticket Application status";
            //String text = "Your applied Airticket has been rejected";
           // String reciever = toEmpDetails.getEmailAddress();
            //System.out.println("Reciever Email=====>" + reciever);
            //String sender = fromEmployeeDetails.getEmailAddress();
           // System.out.println("Sender email===>" + sender);

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

    public ActionForward getAllMasters(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;

        AirTicketRequestForm ticketForm = (AirTicketRequestForm) form;
        //DepartmentForm departmentForm = (DepartmentForm) form;
        DAOFactory factory = new DAOFactory();
        //DepartmentDAO daoDepartment = factory.createDepartmentManager();
        // DesignationDAO daoDesignation = factory.createDesignationManager();
        //CompanyDAO daoCompany = factory.createCompanyManager();
        //EmployeeDAO employeedao = (EmployeeDAO) factory.createEmployeeManager();

        //ProjectDAO projectDao=(ProjectDAO) factory.createProjectManager();
        PurposeOfTripDAO purposeDao = (PurposeOfTripDAO) factory.createPurposeOfTripManager();
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        EmployeeFamilyDetailsDAO employeeFamilyDetailsDAO = factory.createEmployeeFamilyDetailsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        EmployeeMaster loginEmployeeDetails = null;
        HttpSession session = request.getSession(true);
        List<EmployeeFamilyDetails> employeeFamilyDetailsList = null;

        try {

            String id = (String) session.getAttribute("user_id");
            //Integer id=Integer.parseInt(str);
            loginEmployeeDetails = (EmployeeMaster) employeeDAO.getEmployeeMasterByEmpId(id);
            ticketForm.setEmpId(loginEmployeeDetails.getEmployeeId());
            employeeFamilyDetailsList = employeeFamilyDetailsDAO.getEmployeeFamilyDetailsByEmpId(id);
            //departmentList = daoDepartment.getAllDepartment();

            //designationList=daoDesignation.getAllDesignation();
            //companyList=daoCompany.getAllCompany();
            //employeeList=employeedao.getAllEmployee();
            //projectList=projectDao.getAllProject();
            //purposeList=purposeDao.getAllPurposeOfTrip();

            //request.setAttribute("deptList", departmentList);

            //request.setAttribute("projectList", projectList);

            request.setAttribute("familyMemberList", employeeFamilyDetailsList);
            //request.setAttribute("purposeList",purposeList);
            //System.out.println("In Action class ======the value of list" +purposeList );

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

    public ActionForward getSingleEmployeeDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String target = null;
       // AdvancedSalaryRequestForm documentsForm = (AdvancedSalaryRequestForm) form;
        AirTicketRequestForm airform=(AirTicketRequestForm)form;

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

            list = advancedSalaryRequestDAO.getSingleEmployeeDetails(airform.getEmpId());
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
