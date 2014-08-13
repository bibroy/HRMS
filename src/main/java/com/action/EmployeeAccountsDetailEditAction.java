/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.pojo.EmployeeAccountDetails;
import com.dao.EmployeeAccountDetailsDAO;
import com.ImplClass.EmployeeAccountDetailsDAOImpl;
import com.forms.EmployeeAccountsDetailEditForm;

import java.util.List;
import java.math.BigDecimal;

import com.dao.DAOException;
import com.dao.DAOFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.dao.BaseDAO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class EmployeeAccountsDetailEditAction extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

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
        String target = null;
        ActionMessages messages = new ActionMessages();

        EmployeeAccountsDetailEditForm frmobj = (EmployeeAccountsDetailEditForm) form;
        EmployeeAccountDetails pj = new EmployeeAccountDetails();
        DAOFactory dfact = new DAOFactory();

        EmployeeAccountDetailsDAO dobj = dfact.createEditEmployeeAccountDetailsManager();
        try {
            HttpSession session = request.getSession();
            //String take=   session.getAttribute("user_id").toString();



            if (session.getAttribute("user_id") != null) {
                String id = session.getAttribute("user_id").toString();
                frmobj.setEmployeeId(id);

                pj = dobj.getEmployeeAccountDetailsByEmpId(id);
                if (pj != null) {

                    frmobj.setId(pj.getId());
                    frmobj.setEmployeeId(pj.getEmployeeId());

                    frmobj.setAccountNo(pj.getAccountNo());
                    frmobj.setBankName(pj.getBankName());
                    frmobj.setAccountType(pj.getAccountType());
                    frmobj.setBranchAddress(pj.getBranchAddress());
                    frmobj.setContactNo(pj.getContactNo());

                    target = "success";

                }


                System.out.print("*************target=====>" + target);
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }









        } catch (Exception e) {

            log.error("error displaying acountsdetaildata data" + e);
        }
        return mapping.findForward(target);






    }

    public ActionForward EmployeeAccountsDetailEditOrSave(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();

        String target = null;
        EmployeeAccountsDetailEditForm frmobj = (EmployeeAccountsDetailEditForm) form;
        EmployeeAccountDetails pj = new EmployeeAccountDetails();
        DAOFactory dfact = new DAOFactory();
        EmployeeAccountDetailsDAO daoobj = dfact.createEditEmployeeAccountDetailsManager();
        try {
            pj = daoobj.getEmployeeAccountDetailsByEmpId(frmobj.getEmployeeId());
            
            
            pj.setBankName(frmobj.getBankName());
            pj.setAccountNo(frmobj.getAccountNo());
            pj.setAccountType(frmobj.getAccountType());
            pj.setBranchAddress(frmobj.getBranchAddress());
            pj.setContactNo(frmobj.getContactNo());
            boolean rs = daoobj.save(pj);
            target = "success";


            if (rs == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";

            }
        } catch (DAOException e) {
            log.error("critical error" + e);

        }
        return mapping.findForward(target);
    }
}
