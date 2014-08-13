/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.BaseDAO;
import com.dao.DAOException;
import javax.servlet.http.HttpSession;
import com.dao.VisaPassortDetailsDAO;
import com.forms.VisaPassportForm;
import com.dao.DAOFactory;
import java.util.List;
import com.pojo.VisaPassortDetails;
import java.math.BigDecimal;
import org.apache.struts.actions.DispatchAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author Sumit Kumar
 */
public class VisaPassportDetails extends DispatchAction {

    /* forward name="success" path="" */
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward getVisaPassportReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = "";
        VisaPassportForm vpform = (VisaPassportForm) form;
        DAOFactory factory = new DAOFactory();
        VisaPassortDetailsDAO visadao = factory.createVisaPassportDetailsManager();
        HttpSession session = request.getSession();
        try {
            List<VisaPassortDetails> visalist = null;
            visalist = visadao.getAllVisaPassortDetails();
            vpform.setVisalist(visalist);
            session.setAttribute("visaList", visalist);
            target = "success";

        } catch (DAOException doe) {
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }

        return mapping.findForward(target);
    }

    public ActionForward load(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionMessages messages = new ActionMessages();
        String target = "";

        VisaPassportForm vpform = (VisaPassportForm) form;
        DAOFactory factory = new DAOFactory();
        VisaPassortDetailsDAO visadao = factory.createVisaPassportDetailsManager();
        VisaPassortDetails pj = new VisaPassortDetails();

        HttpSession session = request.getSession();



        BaseDAO b = new BaseDAO();
        try {

            if (session.getAttribute("user_id") != null) {
                String id = session.getAttribute("user_id").toString();
                vpform.setEmployeeId(id);
                pj = visadao.getVisaPassortDetailsByEmpId(id);
                target = "success";
                System.out.print("*************target=====>" + target);

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }

            if (pj != null) {

                vpform.setId(pj.getId());
                vpform.setEmployeeId(pj.getEmployeeId());
                vpform.setPassportNo(pj.getPassportNo());


                vpform.setVisaIssueDate(b.mySQLscreenDateFormat(pj.getVisaIssueDate()));


                vpform.setPassportIssueDate(b.mySQLscreenDateFormat(pj.getPassportIssueDate()));

                vpform.setVisaValidUpto(b.mySQLscreenDateFormat(pj.getVisaValidUpto()));
                vpform.setPassportIssuedBy(pj.getPassportIssuedBy());
                vpform.setVisaNo(pj.getVisaNo());
                vpform.setVisaType(pj.getVisaType());
                vpform.setVisaIssuedBy(pj.getVisaIssuedBy());
                vpform.setPassportValidUpto(b.mySQLscreenDateFormat(pj.getPassportValidUpto()));

            }

            target = "success";



        } catch (Exception f) {


            log.error("error displaying acountsdetaildata data" + f);
        }



        return mapping.findForward(target);

    }

    public ActionForward EmployeeVisaDetailEditOrSave(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionMessages messages = new ActionMessages();
        String target = "";
        VisaPassportForm vpform = (VisaPassportForm) form;
        DAOFactory factory = new DAOFactory();
        VisaPassortDetails pj = new VisaPassortDetails();
        BaseDAO b = new BaseDAO();
        VisaPassortDetailsDAO visadao = factory.createVisaPassportDetailsManager();

        try {
            pj=visadao.getVisaPassortDetailsByEmpId(vpform.getEmployeeId());
            pj.setPassportNo(vpform.getPassportNo());
            pj.setVisaIssueDate(b.mySqlDatebFormat(vpform.getVisaIssueDate()));
            pj.setPassportIssueDate(b.mySqlDatebFormat(vpform.getPassportIssueDate()));
            pj.setPassportValidUpto(b.mySqlDatebFormat(vpform.getPassportValidUpto()));
            pj.setVisaIssuedBy(vpform.getVisaIssuedBy());
            pj.setVisaNo(vpform.getVisaNo());
            pj.setVisaType(vpform.getVisaType());
            pj.setVisaValidUpto(b.mySqlDatebFormat(vpform.getVisaValidUpto()));
            pj.setPassportIssuedBy(vpform.getPassportIssuedBy());
            boolean rs = visadao.save(pj);

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

    public ActionForward VisaValidationCheckReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = "";
        List<VisaPassortDetails> vlist = null;
        VisaPassportForm vfrm = (VisaPassportForm) form;
        DAOFactory dfact = new DAOFactory();
        VisaPassortDetailsDAO vdao = dfact.createVisaPassportDetailsManager();

        try {
            String date = vfrm.getVisaValidUpto();

            vlist = vdao.getVisaPassportDetailsByValidationDate(date);
            request.setAttribute("alldetails", vlist);
            target = "success";

        } catch (DAOException doe) {
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }







        return mapping.findForward(target);

    }
}
