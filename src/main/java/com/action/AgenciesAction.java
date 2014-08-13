/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 * pranav kumar
 */
package com.action;

import com.ImplClass.AgenciesDAOImpl;

import com.dao.AgenciesDAO;
import com.pojo.Agencies;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.forms.AgenciesForm;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.dao.BaseDAO;

/**
 *
 * @author computer1
 */
public class AgenciesAction extends DispatchAction {

    String target = null;

    public ActionForward addAgencies(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AgenciesDAO aDao = factory.createAgenciesManager();


        //Add for dept
        //DepartmentDAO daoDepartment = factory.createDepartmentManager();
        BaseDAO b = new BaseDAO();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        //List<Department> departmentList = null;

        HttpSession session = request.getSession(true);
        AgenciesForm aa = (AgenciesForm) form;
        String employeeId = (String) session.getAttribute("id");

        try {
            ////Add for dept
            //departmentList=daoDepartment.getAllDepartment();
            // request.setAttribute("deptList", departmentList);

            //For Leave Report

            //End leave Report

//For Leave apply
            Agencies a = new Agencies();
            System.out.println("Form data========>" + a.getId());

            a.setId(aDao.getLastRequestId() + 1);

            a.setName(aa.getName());
            a.setAddress(aa.getAddress());
            a.setEmail(aa.getEmail());
            a.setPhnno(aa.getPhnno());
            a.setAmount(aa.getAmount());
            boolean result = aDao.save(a);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }

            //int count=(int)(leaveForm.getToDt()-leaveForm.getFromDt());
            target = "success";


        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);

        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }

        return mapping.findForward(target);
    }

    public ActionForward getAgencies(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AgenciesDAO aDao = factory.createAgenciesManager();
        List<Agencies> AgenciesList = null;
        AgenciesForm aa = (AgenciesForm) form;
        try {
            AgenciesList = aDao.getAgencies();
            request.setAttribute("Agencies", AgenciesList);

            target = "success";
        } catch (Exception e) {
            log.error("error displaying recruitment data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getAgencyInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();

        AgenciesDAO aDao = factory.createAgenciesManager();
        AgenciesForm aa = (AgenciesForm) form;

        try {

            Agencies a = aDao.getAgencyByAgencyname(aa.getName());



            aa.setId(a.getId());
            aa.setAddress(a.getAddress());
            aa.setAmount(a.getAmount());
            aa.setEmail(a.getEmail());
            aa.setPhnno(a.getPhnno());


            target = "edit";

        } catch (Exception e) {
            log.error("error displaying recruitment data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward update(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ActionMessages messages = new ActionMessages();
        AgenciesDAO aDao = factory.createAgenciesManager();
        AgenciesForm aa = (AgenciesForm) form;
        try {
            Agencies b = new Agencies();
            b.setId(aa.getId());
            b.setAddress(aa.getAddress());
            b.setName(aa.getName());
            b.setAmount(aa.getAmount());
            b.setEmail(aa.getEmail());
            b.setPhnno(aa.getPhnno());

            boolean result = aDao.update(b);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "edit";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "edit";
            }



            //int count=(int)(leaveForm.getToDt()-leaveForm.getFromDt());
            target = "edit";


        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
            saveErrors(request, messages);
            target = "edit";
            
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
            saveErrors(request, messages);
            target = "edit";
        }

        return mapping.findForward(target);
    }
}
