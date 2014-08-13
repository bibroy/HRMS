/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.action;

import com.dao.BaseDAO;
import com.dao.VisaRequestDetailsDAO;
import com.pojo.VisaRequestDetails;
import com.dao.DAOFactory;
import com.forms.VisaRequestDetailsForm;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Sumit Kumar
 */


public class VisaRequestDetailsAction extends DispatchAction {

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

     public ActionForward save(ActionMapping mapping, ActionForm form,
             HttpServletRequest request, HttpServletResponse response)
             throws Exception{

             DAOFactory factory=new DAOFactory();
             ActionMessages messages=new ActionMessages();
             ActionErrors errors =new ActionErrors();
             VisaRequestDetailsDAO vrdao=factory.createVisaRequestDetailsManager();
             VisaRequestDetails vrdet=new VisaRequestDetails();
             VisaRequestDetailsForm vrform=(VisaRequestDetailsForm)form;
             BaseDAO b=new BaseDAO();
             HttpSession session=request.getSession();
             String empId=(String)session.getAttribute("user_id");
             try {
                vrdet.setId(vrdao.getLastId()+1);
                vrdet.setAccomodations(vrform.getAccomodations());
                vrdet.setCityOfVisit(vrform.getCityOfVisit());
                vrdet.setContactNo(vrform.getContactNo());
                vrdet.setDateOfArrival(b.mySqlDatebFormat(vrform.getDateOfArrival()));
                vrdet.setDaysOfStay(vrform.getDaysOfStay());
                vrdet.setEmailId(vrform.getEmailId());
                vrdet.setEmployeeId(empId);
                vrdet.setEmployeeName(vrform.getEmployeeName());
                vrdet.setNationality(vrform.getNationality());
                vrdet.setNoOfVisa(vrform.getNoOfVisa());
                vrdet.setRemarks(vrform.getRemarks());
                vrdet.setVisa(vrform.getVisa());
                vrdet.setStatus("pending");

                boolean result=vrdao.save(vrdet);
                            
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
             log.error("error saving the visa request details "+ e.getMessage());
         }
         return mapping.findForward(target);
     }

     public ActionForward loadVisaRequestReport(ActionMapping mapping, ActionForm form,
             HttpServletRequest request, HttpServletResponse response)
             throws Exception{
         DAOFactory factory=new DAOFactory();
         VisaRequestDetailsDAO vrdao=factory.createVisaRequestDetailsManager();
         List<VisaRequestDetails> vrlist=null;
         try {
             vrlist=vrdao.getAllRequests();
             request.setAttribute("vrList", vrlist);
             target="report";
         } catch (Exception e) {
             log.error("error fetching the request report "+ e.getMessage());
         }
         return mapping.findForward(target);
     }


}
