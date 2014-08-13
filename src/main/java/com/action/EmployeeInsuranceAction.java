/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.BaseDAO;
import com.dao.EmployeeInsuranceDAO;
import com.forms.EmployeeInsuranceForm;
import com.pojo.EmployeeInsurance;

import com.dao.DAOFactory;
import java.math.BigDecimal;
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
public class EmployeeInsuranceAction extends DispatchAction {

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
    public ActionForward saveInsuranceDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        EmployeeInsuranceDAO eidao = factory.createEmployeeInsuranceManager();
        EmployeeInsurance ei = new EmployeeInsurance();
        EmployeeInsuranceForm eiform = (EmployeeInsuranceForm) form;
        BaseDAO b = new BaseDAO();
        ActionMessages messages = new ActionMessages();
        try {
            ei.setId(eidao.getLastId().add(BigDecimal.ONE));
            ei.setEmployeeId(eiform.getEmployeeId());
            ei.setInsuranceNo(eiform.getInsuranceNo());
            ei.setInsuranceProvider(eiform.getInsuranceProvider());
            ei.setInsuredAmount(new BigDecimal(eiform.getInsuredAmount().intValue()));
            ei.setMaturityDate(b.mySqlDatebFormat(eiform.getMaturityDate()));
            ei.setPremiumAmount(new BigDecimal(eiform.getPremiumAmount()));
            ei.setPremiumDate(b.mySqlDatebFormat(eiform.getPremiumDate()));

            boolean result = eidao.save(ei);
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
            log.error("error saving the employee insurance details " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
            saveErrors(request, messages);
            target = "success";
        }
        return mapping.findForward(target);
    }

    public ActionForward getInsuranceDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        EmployeeInsuranceDAO eidao = factory.createEmployeeInsuranceManager();
        List<EmployeeInsurance> eilist = null;

        try {
            eilist = eidao.getAllInsurance();
            request.setAttribute("eiList", eilist);
            target = "report";
        } catch (Exception e) {
            log.error("error fetching list of employee insurance details " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getSelfInsuranceDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        EmployeeInsuranceDAO eidao = factory.createEmployeeInsuranceManager();
        List<EmployeeInsurance> eilist = null;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        try {
            String userid = session.getAttribute("user_id").toString();
            if (userid != null) {
                eilist = eidao.getAllInsuranceById(userid);
                request.setAttribute("eiList", eilist);
                target = "selfreport";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "selfreport";
            }
        } catch (NullPointerException ne) {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveErrors(request, messages);
            target = "selfreport";
        } catch (Exception e) {
            log.error("error fetching list of employee insurance details " + e);
        }
        return mapping.findForward(target);
    }
}
