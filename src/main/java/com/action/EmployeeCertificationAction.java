/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.pojo.EmployeeCertification;
import com.forms.EmployeeCertificationForm;
import com.dao.DAOException;
import com.dao.EmployeeCertificationDAO;
import com.dao.DAOFactory;
import java.math.BigDecimal;
import com.dao.BaseDAO;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrator
 */
public class EmployeeCertificationAction extends DispatchAction {

    String target = "success";
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";
    ActionMessages messages = new ActionMessages();

    public ActionForward empcertificationaction(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        EmployeeCertificationForm frmobj = (EmployeeCertificationForm) form;
        EmployeeCertification pj = null;
        DAOFactory dfact = new DAOFactory();
        EmployeeCertificationDAO crtobj = dfact.createEmployeeCertificationManager();
        List<EmployeeCertification> elist = null;
        BaseDAO b = new BaseDAO();


        try {


            elist = crtobj.getEmployeeCertificationName(frmobj.getCertificationName(), frmobj.getEmployeeId());
            pj=(EmployeeCertification) elist.get(0);
            
            

            pj.setCertificationName(frmobj.getCertificationName());
            pj.setOrgatizationName(frmobj.getOrgatizationName());
            pj.setSubject(frmobj.getSubject());
            pj.setCertifiedOnDate(b.mySqlDatebFormat(frmobj.getCertifiedOnDate()));
            pj.setRenewedDate(b.mySqlDatebFormat(frmobj.getRenewedDate()));
            pj.setRenewedOnDate(b.mySqlDatebFormat(frmobj.getRenewedOnDate()));
            boolean rs = crtobj.save(pj);
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


        return mapping.findForward(SUCCESS);
    }

    public ActionForward load(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        DAOFactory dfact = new DAOFactory();
        EmployeeCertificationDAO ecdao = dfact.createEmployeeCertificationManager();
        List<EmployeeCertification> elist = null;
        EmployeeCertificationForm obj = (EmployeeCertificationForm) form;
        try {

            if (session.getAttribute("user_id") != null) {
                String id = session.getAttribute("user_id").toString();
                obj.setEmployeeId(id);

                elist = ecdao.getEmployeeCertificationByEmpId(id);
                request.setAttribute("ecertification", elist);
                target = "success";
                System.out.print("*************target=====>" + target);

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }





        } catch (Exception e) {

            log.error("error displaying attendance data" + e);
        }
        return mapping.findForward(target);

    }

    public ActionForward certificationdetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        DAOFactory dfact = new DAOFactory();
        EmployeeCertificationDAO ecdao = dfact.createEmployeeCertificationManager();
        List<EmployeeCertification> elist = null;
        EmployeeCertificationForm obj = (EmployeeCertificationForm) form;

        BaseDAO b = new BaseDAO();
        try {
            String empid = obj.getEmployeeId();
            elist = ecdao.getEmployeeCertificationByEmpId(empid);
            request.setAttribute("ecertification", elist);

            String crtname = obj.getCertificationName();
            elist = ecdao.getEmployeeCertificationName(crtname, empid);
            if (elist != null) {
                EmployeeCertification e = (EmployeeCertification) elist.get(0);
                obj.setId(e.getId().intValue());
                obj.setCertificationName(e.getCertificationName());
                obj.setOrgatizationName(e.getOrgatizationName());
                obj.setSubject(e.getSubject());
                obj.setCertifiedOnDate(b.mySQLscreenDateFormat(e.getCertifiedOnDate()));
                obj.setRenewedDate(b.mySQLscreenDateFormat(e.getRenewedDate()) == null ? "" : b.mySQLscreenDateFormat(e.getRenewedDate()));
                obj.setRenewedOnDate(b.mySQLscreenDateFormat(e.getRenewedOnDate()));

            }

            target = "success";

        } catch (Exception e) {

            log.error("error displaying attendance data" + e);
        }
        return mapping.findForward(target);

    }
}
