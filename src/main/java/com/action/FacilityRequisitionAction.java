/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.pojo.FacilityRequisition;
import com.dao.FacilityRequisitionDAO;
import com.forms.FacilityRequestForm;
import com.dao.BaseDAO;
import com.ImplClass.FacilityRequisitionDAOImpl;
import com.dao.DAOException;
import com.dao.DAOFactory;
import java.math.BigDecimal;
import java.util.Date;
import com.dao.AdvancedSalaryRequestDAO;
import com.dao.AirTicketRequestDAO;
import com.dao.ConferenceRoomDAO;
import com.dao.LeaveRequestDAO;
import com.dao.LoanDAO;
import com.dao.VisaRequestDetailsDAO;
import com.pojo.AdvancedSalaryRequest;
import com.pojo.Airticket;
import com.pojo.ConferenceRoomBooking;
import com.pojo.Leave;
import com.pojo.LeaveDetails;
import com.pojo.Loan;
import com.pojo.VisaRequestDetails;
import java.math.BigInteger;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
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
public class FacilityRequisitionAction extends DispatchAction {

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
    public ActionForward load(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        FacilityRequestForm facform = (FacilityRequestForm) form;
        try {
            String userid = session.getAttribute("user_id").toString();
            facform.setEmployeeid(userid);
            target="load";
        } catch (Exception e) {
            log.error("error in loading facility requisition form " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward saveRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        FacilityRequisitionDAO facdao = factory.createFacilityManager();
        FacilityRequestForm facform = (FacilityRequestForm) form;
        FacilityRequisition facreq = new FacilityRequisition();
        ActionMessages messages = new ActionMessages();
        try {
            facreq.setId(facdao.getLastRequestId().add(BigDecimal.ONE));
            facreq.setFacilityname(facform.getFacilityname());
            facreq.setReason(facform.getReason());
            facreq.setRequestdate(new Date());
            facreq.setStatus("W");

            boolean result = facdao.sendRequest(facreq);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }
        } catch (Exception e) {
            log.error("error saving the facility request " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
            saveErrors(request, messages);
            target = "success";
        }

        return mapping.findForward(target);
    }

    public ActionForward getAllRequestStatus(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();

        LoanDAO loandao = factory.createLoanManager();
        LeaveRequestDAO leavedao = factory.createLeaveRequestManager();
        AdvancedSalaryRequestDAO advsaldao = factory.createAdvancedSalaryRequestManager();
        AirTicketRequestDAO airdao = factory.createAirTicketRequestManager();
        ConferenceRoomDAO confdao = factory.createConferenceRoomManager();
        VisaRequestDetailsDAO visadao = factory.createVisaRequestDetailsManager();

        List<Loan> loanlist = null;
        List<Leave> leavelist = null;
        List<AdvancedSalaryRequest> advlist = null;
        List<Airticket> airlist = null;
        List<ConferenceRoomBooking> conflist = null;
        List<VisaRequestDetails> visalist = null;
        HttpSession session = request.getSession();
        try {
            String empid = session.getAttribute("user_id").toString();
            loanlist = loandao.getRequestStatus(empid);
            request.setAttribute("loanlist", loanlist);

            leavelist = leavedao.getAllRequest(empid);
            request.setAttribute("leavelist", leavelist);

            advlist = advsaldao.getAllRequest(empid);
            request.setAttribute("advlist", advlist);

            airlist = airdao.getAllRequest(empid);
            request.setAttribute("airlist", airlist);

            conflist = confdao.getAllRequest(empid);
            request.setAttribute("conflist", conflist);

            visalist = visadao.getAllRequestByEmpId(empid);
            request.setAttribute("visalist", visalist);

            target = "requestreport";

        } catch (Exception e) {
            log.error("error fetching the request details " + e);
        }

        return mapping.findForward(target);
    }

    public ActionForward viewRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        FacilityRequisitionDAO facdao = factory.createFacilityManager();
        List<FacilityRequisition> faclist = null;
        try {
            faclist = facdao.getAllEmployees();
            request.setAttribute("empList", faclist);
            target = "view";
        } catch (Exception e) {
            log.error("error fetching the facility request details " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward approveFacility(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        FacilityRequisitionDAO facdao = factory.createFacilityManager();
        FacilityRequisition facreq = new FacilityRequisition();
        FacilityRequestForm facform = (FacilityRequestForm) form;
        HttpSession session = request.getSession();
        try {
            String userid = session.getAttribute("user_id").toString();
            facreq = facdao.viewRequestData(Integer.parseInt(facform.getHiddenId()));
            facreq.setApprovalauthoriyEmployeeid(userid);
            facreq.setApprovaldate(new Date());
            facreq.setStatus("A");

            boolean result = facdao.sendRequest(facreq);
            target = "view";

        } catch (Exception e) {
            log.error("error saving the facility" + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward rejectFacility(ActionMapping mapping , ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DAOFactory factory = new DAOFactory();
        FacilityRequisitionDAO facdao = factory.createFacilityManager();
        FacilityRequisition facreq = new FacilityRequisition();
        FacilityRequestForm facform = (FacilityRequestForm) form;
        HttpSession session = request.getSession();
        try {
            String userid = session.getAttribute("user_id").toString();
            facreq = facdao.viewRequestData(Integer.parseInt(facform.getHiddenId()));
            facreq.setApprovalauthoriyEmployeeid(userid);
            facreq.setApprovaldate(new Date());
            facreq.setStatus("R");
            facreq.setReason(facform.getWhyReject());

            boolean result = facdao.sendRequest(facreq);
            target = "view";

        } catch (Exception e) {
            log.error("error saving the facility" + e);
        }
        return mapping.findForward(target);
    }
}
