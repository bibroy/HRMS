/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.DAOFactory;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.pojo.EmployeeFamilyDetailspojo;
import com.dao.DAOException;
import com.forms.EmployeeFamilyDetailsForm;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionMessage;
import java.math.BigDecimal;
import org.hibernate.Session;
import com.dao.BaseDAO;
import com.dao.EmployeeFamilyDetailsDAO;
import com.pojo.EmployeeMaster;
import javax.servlet.http.HttpSession;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/**
 *
 * @author Administrator
 */
public class EmployeeFamilyDetailsAction extends DispatchAction {

    ActionMessages messages = new ActionMessages();
    ActionErrors errors = new ActionErrors();
    String target = "";
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
    public ActionForward employeefamilydetailsmethod(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        EmployeeFamilyDetailsForm fobj = (EmployeeFamilyDetailsForm) form;
        BaseDAO b = new BaseDAO();

        DAOFactory daofact = new DAOFactory();
        EmployeeFamilyDetailsDAO efobj = daofact.createEmployeeFamilyDetailManager();

        EmployeeFamilyDetailspojo pj = new EmployeeFamilyDetailspojo();
        try {

            pj.setId(efobj.getLastRequestId().add(BigDecimal.ONE));
            pj.setEmployee_id(fobj.getEmployee_id());
            pj.setFamily_member_name(fobj.getFamily_member_name());
            pj.setRelation(fobj.getRelation());
            pj.setDob_of_member(b.mySqlDatebFormat(fobj.getDob_of_member()));

            boolean rs = efobj.save(pj);
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
            log.error("error detected" +e);
        }



        return mapping.findForward(SUCCESS);
    }

    public ActionForward getAllMasters(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        EmployeeFamilyDetailsForm fobj = (EmployeeFamilyDetailsForm) form;

        DAOFactory factory = new DAOFactory();



        EmployeeFamilyDetailsDAO employeeDAO = factory.createEmployeeFamilyDetailManager();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();


        HttpSession session = request.getSession();

        EmployeeFamilyDetailspojo pj = null;

        try {
            if (session.getAttribute("user_id") != null) {


                String id = session.getAttribute("user_id").toString();
                fobj.setEmployee_id(id);
                target = "success";
                System.out.print("*************target=====>" + target);
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE,new ActionMessage("session.out",""));
                saveErrors(request, messages);
                target="sessionout";
            }
        } catch (Exception e) {

            System.out.println("****************** Exception 2 is " + e.getMessage());

            log.error("error From ExceptionClass " + e);

        }


        System.out.println("Value of target===========>" + target);
        return mapping.findForward(target);
    }
}
