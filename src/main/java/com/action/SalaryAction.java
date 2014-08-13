/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.pojo.SalaryBreakup;
import com.pojo.SalaryHead;
import com.pojo.AdvancedSalaryRequest;
import com.pojo.Leave;
import com.dao.DAOFactory;
import com.dao.DAOException;
import com.ImplClass.SalaryDAOImpl;
import com.forms.SalaryForm;
import com.dao.SalaryDAO;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author Sumit Kumar
 */
public class SalaryAction extends DispatchAction {

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
    public ActionForward loadEmp(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        SalaryDAO saldao = factory.createSalaryManager();
        List<SalaryBreakup> listsb = null;
        try {
            listsb = saldao.getSalaryList();
            request.setAttribute("Employees", listsb);
            target = "success";
        } catch (Exception e) {
            log.error("error filling list of employees " + e.getMessage());
        }

        return mapping.findForward(target);
    }

    public ActionForward getAdvancedSalary(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        SalaryDAO saldao = factory.createSalaryManager();
        SalaryForm salform = (SalaryForm) form;
        try {
            Double advsal = 0.0;
            advsal = saldao.getAdvancedSalById(salform.getHiddenId(), Integer.parseInt(salform.getMonth()), Integer.parseInt(salform.getYear()));
            if (advsal == null) {
                advsal = 0.0;
            }
            request.setAttribute("advSal", advsal);
            target = "success";
        } catch (Exception e) {
            log.error("error fetching the advsal " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }

    public ActionForward getLeaveDeduction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        SalaryDAO saldao = factory.createSalaryManager();
        SalaryForm salform = (SalaryForm) form;
        try {
            Double basicsal = saldao.getSalarybyId(salform.getHiddenId());
            Double onedaysal = 0.0;
            if (basicsal != null) {
                onedaysal = basicsal / 30;
                onedaysal = roundTwoDecimals(onedaysal);
            }

            Double noofleave = saldao.getLeaveDays(salform.getHiddenId(), Integer.parseInt(salform.getMonth()), Integer.parseInt(salform.getYear()));
            Double totalded = 0.0;
            if (noofleave != null) {
                totalded = noofleave * onedaysal;
                totalded= roundTwoDecimals(totalded);
            }

            request.setAttribute("leaveDed", totalded);
            target = "success";

        } catch (Exception e) {
            log.error("error calculating leave deduction " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    public ActionForward saveNetPayable(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DAOFactory factory=new DAOFactory();
        SalaryDAO saldao=factory.createSalaryManager();
        SalaryForm salform=(SalaryForm)form;
        ActionMessages messages=new ActionMessages();
        ActionErrors errors=new ActionErrors();
        SalaryBreakup sb=null;
        try {
            BigDecimal id=saldao.getId(salform.getHiddenId());
            sb=saldao.getSalaryBreakupById(id);
            sb.setNetpayable(salform.getNetPayable());
            boolean result=saldao.save(sb);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }
            target = "success";
        } catch (Exception e) {
            log.error("error saving net payable "+e.getMessage());
        }
        return mapping.findForward(target);
    }
}
