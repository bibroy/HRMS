/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.action;
import com.ImplClass.recruitmentRequestDAOImpl;
import com.dao.AssessmentEventDAO;
import com.pojo.AssessmentEvent;

import com.dao.DAOException;
import com.dao.DAOFactory;

import com.forms.AssessmentEventForm;
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

import com.dao.BaseDAO;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author computer1
 */
public class AssessmentEventAction extends DispatchAction {
    
      String target = null;

    public ActionForward addEventSchedule(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
         AssessmentEventDAO aDao = factory.createAssessmentEventManager();


        //Add for dept
        //DepartmentDAO daoDepartment = factory.createDepartmentManager();
        BaseDAO b = new BaseDAO();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        //List<Department> departmentList = null;

        HttpSession session = request.getSession(true);
       AssessmentEventForm aa = (AssessmentEventForm) form;
       

        try {
            ////Add for dept
            //departmentList=daoDepartment.getAllDepartment();
            // request.setAttribute("deptList", departmentList);

            //For Leave Report

            //End leave Report

//For Leave apply
            AssessmentEvent a = new AssessmentEvent();;
            System.out.println("Form data========>" + a.getId());

            a.setId(aDao.getLastRequestId() + 1);

            a.setType(aa.getType());
            a.setCenter(aa.getCenter());
            a.setEventdate(b.mySqlDatebFormat(aa.getDate()));


            a.setTime(aa.getTime());
            a.setInvigilator(aa.getInvigilator());
           
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
    }}