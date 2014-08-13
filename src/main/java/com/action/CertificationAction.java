/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.forms.EmployeeCertificationForm;
import com.pojo.EmployeeCertification;
import com.dao.BaseDAO;
import com.dao.EmployeeCertificationDAO;
import com.ImplClass.EmployeeCertificationDAOImpl;
import com.dao.DAOFactory;
import java.math.BigDecimal;

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
public class CertificationAction extends DispatchAction {

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
        EmployeeCertificationForm empform = (EmployeeCertificationForm) form;
        try {
            String userid = session.getAttribute("user_id").toString();
            empform.setEmployeeId(userid);
            target = "load";

        } catch (Exception e) {
            log.error("error loading the certification page " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward addCertification(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        EmployeeCertificationDAO empdao = factory.createEmployeeCertificationManager();
        EmployeeCertification empcert = new EmployeeCertification();
        EmployeeCertificationForm empform = (EmployeeCertificationForm) form;
        ActionMessages messages = new ActionMessages();
        BaseDAO b = new BaseDAO();
        try {
            empcert.setId(empdao.getLastId());
            empcert.setCertificationName(empform.getCertificationName());
            empcert.setCertifiedOnDate(b.mySqlDatebFormat(empform.getCertifiedOnDate()));
            empcert.setEmployeeId(empform.getEmployeeId());
            empcert.setOrgatizationName(empform.getOrgatizationName());
            empcert.setRenewedOnDate(b.mySqlDatebFormat(empform.getRenewedOnDate()));
            empcert.setSubject(empform.getSubject());

            boolean result = empdao.save(empcert);
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
            log.error("error in adding the Certification information " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
            saveErrors(request, messages);
            target="success";
        }
        return mapping.findForward(target);
    }
}
