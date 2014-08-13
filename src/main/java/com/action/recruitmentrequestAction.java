/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;


import com.ImplClass.recruitmentRequestDAOImpl;
import com.dao.recruitmentRequestDAO;
import com.pojo.recruitmentRequestpojo;
import com.pojo.EmployeeMaster;
import com.dao.DAOException;
import com.dao.DAOFactory;

import com.forms.recruitmentRrequest;
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
import com.dao.EmployeeMasterDAO;
import com.dao.DepartmentDAO;
import com.pojo.Department;
/**
 *
 * @author computer1
 */
public class recruitmentrequestAction extends DispatchAction {

    String target = null;

    public ActionForward addrecruitmentRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        recruitmentRequestDAO reqDao = factory.recruitmentRequestManager();


        //Add for dept
        //DepartmentDAO daoDepartment = factory.createDepartmentManager();
        BaseDAO b = new BaseDAO();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        //List<Department> departmentList = null;

        HttpSession session = request.getSession(true);
        recruitmentRrequest rr = (recruitmentRrequest) form;
        String employeeId = (String) session.getAttribute("id");

        try {
            ////Add for dept
            //departmentList=daoDepartment.getAllDepartment();
            // request.setAttribute("deptList", departmentList);

            //For Leave Report

            //End leave Report

//For Leave apply
            recruitmentRequestpojo r = new recruitmentRequestpojo();
            System.out.println("Form data========>" + r.getId());

            r.setId(reqDao.getLastRequestId() + 1);

            r.setNov(rr.getNov());
            r.setQuali(rr.getQuali());
            r.setLastdate(b.mySqlDatebFormat(rr.getLastdate()));


            r.setExp(rr.getExp());
            r.setPost(rr.getPost());
            r.setMethod(rr.getMethod());
             r.setDepartment(rr.getDepartment());

            r.setSkill(rr.getSkill());

            boolean result = reqDao.save(r);
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

    public ActionForward getrecruitmentRequest(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        recruitmentRequestDAO reqDao = factory.recruitmentRequestManager();
        List<recruitmentRequestpojo> recruitmentRequestList = null;
        recruitmentRrequest rr = (recruitmentRrequest) form;
        try {
            recruitmentRequestList = reqDao.getAllrecruitmentRequest();
            request.setAttribute("recruitmentRequest", recruitmentRequestList);

            target = "success";
        } catch (Exception e) {
            log.error("error displaying recruitment data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getDepartment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        try {
            DAOFactory factory = new DAOFactory();

            EmployeeMasterDAO empDao = factory.createEmployeeMasterManager();
            EmployeeMaster e = empDao.getDepartmentId("222");
            DepartmentDAO dptdao=factory.createDepartmentManager();
            
           String dept = e.getDepartmentId().toString();
            Department d=dptdao.getDepartment(dept);

            recruitmentRrequest rr = (recruitmentRrequest) form;

            rr.setDepartment(d.getDepartmentName());
            target = "success";
        
        } catch (Exception e) {
            log.error("error displaying recruitment data " + e);
        }
        return mapping.findForward(target);
    }
}
