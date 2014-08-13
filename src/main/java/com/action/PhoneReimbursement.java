/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.DAOFactory;
import com.dao.DAOException;
import com.dao.PhoneReimbursementDAO;
import com.forms.PhoneReimbursementForm;
import com.pojo.PhoneReimbursment;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
public class PhoneReimbursement extends DispatchAction {

    /* forward name="success" path="" */
    private static String target = "";

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
        PhoneReimbursementForm pform = (PhoneReimbursementForm) form;
        ActionMessages messages = new ActionMessages();
        try {
            if (session.getAttribute("user_id") != null) {
                String user = session.getAttribute("user_id").toString();
                pform.setEmployeeid(user);
                target = "load";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error loading the page " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward sendRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        PhoneReimbursementDAO pdao = factory.createPhoneReimbursementManager();
        PhoneReimbursementForm prform = (PhoneReimbursementForm) form;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        PhoneReimbursment pr = new PhoneReimbursment();
        try {
            String user = session.getAttribute("user_id").toString();
            pr.setEmployeeid(user);
            pr.setPhonebillid(new BigDecimal(prform.getPhonebillid()));
            pr.setPhoneno(new BigDecimal(prform.getPhoneno()));
            pr.setRequestdate(new Date());
            pr.setTotalamount(prform.getTotalamount());
            pr.setRequestid(pdao.getLastRequestId().add(BigDecimal.ONE));
            pr.setApprovalstatus("W");

            boolean result = pdao.save(pr);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }

        } catch (NullPointerException ne) {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveErrors(request, messages);
            target = "sessionout";
        } catch (Exception e) {
            log.error("error saving the phonereimbursement request data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward viewRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        PhoneReimbursementDAO pdao = factory.createPhoneReimbursementManager();
        List<PhoneReimbursment> ph = null;
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        try {
            if (session.getAttribute("user_id") != null) {
                ph = pdao.getAllReimbursementRequest();
                request.setAttribute("phoneList", ph);
                target = "view";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error fetching the requests " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward approveReimbursement(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        PhoneReimbursementDAO pdao = factory.createPhoneReimbursementManager();
        PhoneReimbursementForm prform = (PhoneReimbursementForm) form;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        PhoneReimbursment pr = new PhoneReimbursment();
        List<PhoneReimbursment> ph = null;
        try {
            if (session.getAttribute("user_id") != null) {
                String userid = session.getAttribute("user_id").toString();
                pr = pdao.getRequestById(new BigDecimal(prform.getHiddenId()));
                pr.setApprovaldate(new Date());
                pr.setApprovalstatus("A");
                pr.setApprovedBy(userid);

                pdao.save(pr);
                target = "approve";
                ph = pdao.getAllReimbursementRequest();
                request.setAttribute("phoneList", ph);
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error saving the approval for the phone reimbursement request " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward rejectReimbursement(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        PhoneReimbursementDAO pdao = factory.createPhoneReimbursementManager();
        PhoneReimbursementForm prform = (PhoneReimbursementForm) form;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        PhoneReimbursment pr = new PhoneReimbursment();
        List<PhoneReimbursment> ph = null;
        try {
            if (session.getAttribute("user_id") != null) {
                String userid = session.getAttribute("user_id").toString();
                pr = pdao.getRequestById(new BigDecimal(prform.getHiddenId()));
                pr.setApprovaldate(new Date());
                pr.setApprovalstatus("R");
                pr.setApprovedBy(userid);

                pdao.save(pr);
                target = "approve";
                ph = pdao.getAllReimbursementRequest();
                request.setAttribute("phoneList", ph);
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error saving the approval for the phone reimbursement request " + e);
        }
        return mapping.findForward(target);
    }
}
