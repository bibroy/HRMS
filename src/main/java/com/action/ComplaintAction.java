/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.pojo.ComplainDetails;
import com.forms.ComplaintsForm;
import com.dao.BaseDAO;
import com.dao.DAOFactory;
import com.dao.DAOException;
import com.dao.ComplaintsDAO;
import com.ImplClass.ComplaintsDAOImpl;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionMessage;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Sumit Kumar
 */
public class ComplaintAction extends DispatchAction {

    /* forward name="success" path="" */
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
        DAOFactory factory = new DAOFactory();
        ComplaintsDAO comdao = factory.createComplaintManger();
        ComplaintsForm compform = (ComplaintsForm) form;
        HttpSession session = request.getSession();
        try {
            String userid = session.getAttribute("user_id").toString();
            compform.setEmployeeid(userid);
            target = "load";
        } catch (Exception e) {
            log.error("error loading the complaints page " + e);
        }

        return mapping.findForward(target);
    }

    public ActionForward saveComplaint(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ComplaintsDAO comdao = factory.createComplaintManger();
        ComplaintsForm compform = (ComplaintsForm) form;
        ComplainDetails compdet = new ComplainDetails();
        ActionMessages messages = new ActionMessages();
        try {
            compdet.setComplainid(comdao.getLastComplaintId().add(BigDecimal.ONE));
            compdet.setSubject(compform.getSubject());
            compdet.setComplaintext(compform.getComplaintext());
            compdet.setSuggestion(compform.getSuggestion());
            compdet.setViewstatus("submitted");
            compdet.setRequestdate(new Date());
            compdet.setEmployeeid(compform.getEmployeeid());

            boolean result = comdao.saveComplaint(compdet);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }

        } catch (Exception e) {
            log.error("error during saving the complaint " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
            saveErrors(request, messages);
            target = "success";
        }
        return mapping.findForward(target);
    }

    public ActionForward viewComplaint(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ComplaintsDAO compdao = factory.createComplaintManger();
        List<ComplainDetails> comlist = null;
        ComplaintsForm compform = (ComplaintsForm) form;
        BaseDAO b = new BaseDAO();
        try {
            comlist = compdao.getAllComplaints();
            compform.setTotalcomp(comlist.size());
            compform.setCompno(1);
            compform.setComplainid(comlist.get(0).getComplainid().intValue());
            compform.setEmployeeid(comlist.get(0).getEmployeeid());
            compform.setSubject(comlist.get(0).getSubject());
            compform.setComplaintext(comlist.get(0).getComplaintext());
            compform.setRequestdate(b.mySQLscreenDateFormat(comlist.get(0).getRequestdate()));
            compform.setViewstatus(comlist.get(0).getViewstatus());
            compform.setSuggestion(comlist.get(0).getSuggestion());

            target = "load";

        } catch (Exception e) {
            log.error("error fetching the complaints " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward nextComplaint(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ComplaintsDAO compdao = factory.createComplaintManger();
        List<ComplainDetails> comlist = null;
        ComplaintsForm compform = (ComplaintsForm) form;
        BaseDAO b = new BaseDAO();
        ActionMessages messages = new ActionMessages();
        try {
            Integer cur = compform.getCompno();

            comlist = compdao.getAllComplaints();
            Integer tot = comlist.size();
            if ((cur + 1) <= tot) {
                compform.setCompno(cur + 1);
                compform.setComplainid(comlist.get(cur).getComplainid().intValue());
                compform.setEmployeeid(comlist.get(cur).getEmployeeid());
                compform.setSubject(comlist.get(cur).getSubject());
                compform.setComplaintext(comlist.get(cur).getComplaintext());
                compform.setRequestdate(b.mySQLscreenDateFormat(comlist.get(cur).getRequestdate()));
                compform.setViewstatus(comlist.get(cur).getViewstatus());
                compform.setSuggestion(comlist.get(cur).getSuggestion());
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.next", ""));
                saveErrors(request, messages);
            }
            target = "load";

        } catch (Exception e) {
            log.error("error going to the next record" + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward previousComplaint(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ComplaintsDAO compdao = factory.createComplaintManger();
        List<ComplainDetails> comlist = null;
        ComplaintsForm compform = (ComplaintsForm) form;
        BaseDAO b = new BaseDAO();
        ActionMessages messages = new ActionMessages();
        try {
            Integer cur = compform.getCompno();

            comlist = compdao.getAllComplaints();

            if ((cur - 1) >= 1) {
                compform.setCompno(cur - 1);
                compform.setComplainid(comlist.get(cur - 2).getComplainid().intValue());
                compform.setEmployeeid(comlist.get(cur - 2).getEmployeeid());
                compform.setSubject(comlist.get(cur - 2).getSubject());
                compform.setComplaintext(comlist.get(cur - 2).getComplaintext());
                compform.setRequestdate(b.mySQLscreenDateFormat(comlist.get(cur - 2).getRequestdate()));
                compform.setViewstatus(comlist.get(cur - 2).getViewstatus());
                compform.setSuggestion(comlist.get(cur - 2).getSuggestion());
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.previous", ""));
                saveErrors(request, messages);
            }
            target = "load";

        } catch (Exception e) {
            log.error("error going to the next record" + e);
        }
        return mapping.findForward(target);
    }

    @Override
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ComplaintsDAO compdao = factory.createComplaintManger();
        List<ComplainDetails> comlist = null;
        ComplaintsForm compform = (ComplaintsForm) form;
        BaseDAO b = new BaseDAO();
        ActionMessages messages = new ActionMessages();
        try {
            Integer cur = compform.getCompno();

            comlist = compdao.getAllComplaints();
            Integer tot = comlist.size();
            if (((cur - 1) >= 1) && ((cur + 1) <= tot)) {
                compform.setCompno(cur);
                compform.setComplainid(comlist.get(cur - 1).getComplainid().intValue());
                compform.setEmployeeid(comlist.get(cur - 1).getEmployeeid());
                compform.setSubject(comlist.get(cur - 1).getSubject());
                compform.setComplaintext(comlist.get(cur - 1).getComplaintext());
                compform.setRequestdate(b.mySQLscreenDateFormat(comlist.get(cur - 1).getRequestdate()));
                compform.setViewstatus(comlist.get(cur - 1).getViewstatus());
                compform.setSuggestion(comlist.get(cur - 1).getSuggestion());
            } else if ((cur - 1) >= 1) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.previous", ""));
                saveErrors(request, messages);
            } else if ((cur + 1) <= tot) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.next", ""));
                saveErrors(request, messages);
            }
            target = "load";

        } catch (Exception e) {
            log.error("error going to the next record" + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward submitResponse(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ComplaintsDAO compdao = factory.createComplaintManger();
        ComplaintsForm compform = (ComplaintsForm) form;
        ComplainDetails cd = new ComplainDetails();
        BaseDAO b = new BaseDAO();
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        try {
            String userid = session.getAttribute("user_id").toString();
            cd.setComplainid(new BigDecimal(compform.getComplainid().intValue()));
            cd.setApprovalauthoriyEmployeeid(userid);
            cd.setApprovaldate(new Date());
            cd.setComplaintext(compform.getComplaintext());
            cd.setEmployeeid(compform.getEmployeeid());
            cd.setRemarks(compform.getRemarks());
            cd.setRequestdate(b.mySqlDatebFormat(compform.getRequestdate()));
            cd.setSubject(compform.getSubject());
            cd.setSuggestion(compform.getSuggestion());
            cd.setViewstatus(compform.getViewstatus());

            boolean result = compdao.saveComplaint(cd);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }

        } catch (Exception e) {
            log.error("error updating the response against complaint " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
            saveErrors(request, messages);
        }
        return mapping.findForward(target);
    }
    
}
