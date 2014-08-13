/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.DAOFactory;
import com.forms.TransportForm;
import com.dao.TransportDAO;
import com.ImplClass.TransportDAOImpl;
import com.dao.DAOException;
import com.pojo.Transport;
import java.math.BigDecimal;
import com.dao.BaseDAO;
import java.math.BigInteger;
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
 *
 */
public class TransportAction extends DispatchAction {

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
        TransportForm trform = (TransportForm) form;

        try {
            String userid = session.getAttribute("user_id").toString();
            trform.setEmployeeid(userid);
            target = "success";
        } catch (Exception e) {
            log.error("error fetching the user id " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward saveTransportRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TransportDAO trdao = factory.createTransportManager();
        Transport tr = new Transport();
        TransportForm trform = (TransportForm) form;
        HttpSession session = request.getSession();
        BaseDAO b = new BaseDAO();
        ActionMessages messages = new ActionMessages();
        try {
            String empid = session.getAttribute("user_id").toString();
            tr.setRequestId(trdao.getLastRequestId());
            tr.setDeparturetime(trform.getDeparturetimehour() + ":" + trform.getDeparturetimemin() + " " + trform.getDepartureampm());
            tr.setEmployeeid(empid);
            tr.setReason(trform.getReason());
            tr.setRequestdate(new Date());
            tr.setRequeststatus("W");
            tr.setTransportDate(b.OracleDatebFormat(trform.getTransportDate()));
            tr.setTransportFrom(trform.getTransportFrom());
            tr.setTransportTo(trform.getTransportTo());
            tr.setTransportname(trform.getTransportname());

            boolean result = trdao.saveTransportRequest(tr);
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
            log.error("error saving the transpor request " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
            saveErrors(request, messages);
        }
        return mapping.findForward(target);
    }

    public ActionForward viewTransportRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws DAOException{
        DAOFactory factory=new DAOFactory();
        TransportDAO transdao=factory.createTransportManager();
        List<Transport> translist=null;
        try {
            translist=transdao.getAllTransportRequest();
            request.setAttribute("transList", translist);
            target="view";
        } catch (Exception e) {
            log.error("error fetching the transport request "+e);
        }
        return mapping.findForward(target);
    }

    public ActionForward approveTransport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws DAOException{
        DAOFactory factory=new DAOFactory();
        TransportDAO transdao=factory.createTransportManager();
        Transport trans=null;
        TransportForm transform=(TransportForm)form;
        HttpSession session =request.getSession();
        try {
            String userid=session.getAttribute("user_id").toString();
            trans=transdao.getRequestById(new BigDecimal(transform.getHiddenId()));
            trans.setApprovalauthoriyEmployeeid(userid);
            trans.setApprovaldate(new Date());
            trans.setRequeststatus("A");

            transdao.saveTransportRequest(trans);
            target="view";
        } catch (Exception e) {
            log.error("error approving the transport request " +e );
        }
        return mapping.findForward(target);
    }

    public ActionForward rejectTransport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request,HttpServletResponse response)
            throws Exception{
        DAOFactory factory=new DAOFactory();
            TransportDAO transdao=factory.createTransportManager();
        Transport trans=null;
        TransportForm transform=(TransportForm)form;
        HttpSession session =request.getSession();
        try {
            String userid=session.getAttribute("user_id").toString();
            trans=transdao.getRequestById(new BigDecimal(transform.getHiddenId()));
            trans.setApprovalauthoriyEmployeeid(userid);
            trans.setApprovaldate(new Date());
            trans.setRequeststatus("R");
            trans.setReason(transform.getWhyReject());

            transdao.saveTransportRequest(trans);
            target="view";
        } catch (Exception e) {
            log.error("error approving the transport request " +e );
        }
        return mapping.findForward(target);
    }
}
