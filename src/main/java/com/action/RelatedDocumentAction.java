/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.DAOFactory;
import com.dao.BaseDAO;
import com.dao.RelatedDocumentsDAO;
import com.pojo.RelatedDocuments;
import com.forms.RelatedDocumentForm;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class RelatedDocumentAction extends DispatchAction {

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
        HttpSession session = request.getSession();
        RelatedDocumentForm relform = (RelatedDocumentForm) form;
        try {
            String userid = session.getAttribute("user_id").toString();
            relform.setEmployeeid(userid);
            target = "load";
        } catch (Exception e) {
            log.error("error loading the related document form " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward saveRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RelatedDocumentsDAO reldao = factory.createDocumentManager();
        RelatedDocumentForm relform = (RelatedDocumentForm) form;
        RelatedDocuments reldoc = new RelatedDocuments();
        ActionMessages messages = new ActionMessages();
        try {
            reldoc.setRequestcode(reldao.getLastRequestId() + 1);
            reldoc.setEmployeeid(relform.getEmployeeid());
            reldoc.setDocumentsname(relform.getDocumentsname());
            reldoc.setReason(relform.getReason());
            reldoc.setRequestdate(new Date());
            reldoc.setStatus("W");

            boolean result = reldao.sendRequest(reldoc);
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
            log.error("error saving the request for documents " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
            saveErrors(request, messages);
            target = "success";
        }

        return mapping.findForward(target);
    }

    public ActionForward approveDocument(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RelatedDocuments rd = null;
        RelatedDocumentsDAO docdao = factory.createDocumentManager();
        RelatedDocumentForm docform = (RelatedDocumentForm) form;
        HttpSession session = request.getSession();

        try {
            String userid = session.getAttribute("user_id").toString();
            rd = docdao.viewOfficialDocumentsRequestData(Integer.parseInt(docform.getHiddenId()));
            rd.setApprovalauthoriyEmployeeid(userid);
            rd.setApprovaldate(new Date());
            rd.setStatus("A");

            docdao.sendRequest(rd);

            target = "view";
        } catch (Exception e) {
            log.error("error saving approval for documents " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward rejectDocument(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RelatedDocuments rd = null;
        RelatedDocumentsDAO docdao = factory.createDocumentManager();
        RelatedDocumentForm docform = (RelatedDocumentForm) form;
        HttpSession session = request.getSession();

        try {
            String userid = session.getAttribute("user_id").toString();
            rd = docdao.viewOfficialDocumentsRequestData(Integer.parseInt(docform.getHiddenId()));
            rd.setApprovalauthoriyEmployeeid(userid);
            rd.setApprovaldate(new Date());
            rd.setStatus("R");
            rd.setReason(docform.getWhyReject());

            docdao.sendRequest(rd);

            target = "view";
        } catch (Exception e) {
            log.error("error saving approval for documents " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward viewDocumentRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        List<RelatedDocuments> rd = null;
        RelatedDocumentsDAO docdao = factory.createDocumentManager();
        RelatedDocumentForm docform = (RelatedDocumentForm) form;
        try {
            rd=docdao.getAllEmployees();
            request.setAttribute("docList", rd);
            target = "view";
        } catch (Exception e) {
            log.error("error saving approval for documents " + e);
        }
        return mapping.findForward(target);
    }
}
