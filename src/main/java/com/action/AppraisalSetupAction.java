/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.AppraisalCategoryDAO;
import com.dao.AppraisalEmpInfoDAO;
import com.dao.AppraisalSetupDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.DepartmentDAO;
import com.dao.DesignationDAO;
import com.forms.AppraisalSetupForm;
import com.pojo.AppraisalCategory;
import com.pojo.AppraisalEmpInfo;
import com.pojo.AppraisalSetup;
import com.pojo.Department;
import com.pojo.DesignationMaster;
import java.math.BigDecimal;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalSetupAction extends DispatchAction {

    public ActionForward setAppraisal(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        DAOFactory factory = new DAOFactory();
        AppraisalSetupDAO dao = factory.createAppraisalSetupManager();
        AppraisalEmpInfoDAO empdao = factory.createAppraisalEmpInfoManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        AppraisalSetupForm appraisalsetup = (AppraisalSetupForm) form;
        int category_code[] = appraisalsetup.getCategory_id();
        String target = null;
        String uid = (String) session.getAttribute("user_id");
        int company_id = 0;
        AppraisalEmpInfo apempinfo = new AppraisalEmpInfo();
        List<AppraisalEmpInfo> empInfo = null;
        empInfo = empdao.getEmployeeDetails(uid);
        ListIterator litr = empInfo.listIterator();
        while (litr.hasNext()) {
            apempinfo = (AppraisalEmpInfo) litr.next();
            company_id = apempinfo.getCompany_code();
        }
        try {
            for (int i = 0; i < category_code.length; i++) {
                AppraisalSetup appraisalSetup = new AppraisalSetup();
                appraisalSetup.setAppraiser(appraisalsetup.getAppraiser());
                appraisalSetup.setCategory_id(category_code[i]);
                appraisalSetup.setDepartment_id(appraisalsetup.getDepartment());
                appraisalSetup.setCompany_id(company_id);
                appraisalSetup.setDuration(appraisalsetup.getDuration());
                appraisalSetup.setFeedback_status(appraisalsetup.getFeedback_status());
                appraisalSetup.setResponse_type(appraisalsetup.getResponse_type());
                appraisalSetup.setAppraisal_message(appraisalsetup.getMessage());
                appraisalSetup.setStatus("Initiated");
                dao.save(appraisalSetup);
            }
            appraisalsetup.reset(mapping, request);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
            saveMessages(request, messages);
            target = "success";

        } catch (DAOException doe) {            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        return mapping.findForward(target);
    }

    public ActionForward showSetupPage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalCategoryDAO categoryDao = factory.createAppraisalCategoryManager();
        DepartmentDAO departmentDao = factory.departmentManager();
        DesignationDAO designationDao = factory.designationManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        List<AppraisalCategory> appraisalCategory = null;
        List<Department> department = null;
        List<DesignationMaster> designation = null;
        try {
            appraisalCategory = categoryDao.getAllAppraisalCategories();
            request.setAttribute("appraisalCategory", appraisalCategory);
            department = departmentDao.getAllDepartment();
            request.setAttribute("department", department);
            designation = designationDao.getAllDesignation();
            request.setAttribute("designation", designation);
            target = "success";
        } catch (DAOException doe) {            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getAllsetup(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalSetupDAO setupDao = factory.createAppraisalSetupManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        List<AppraisalSetup> appraisalSetup = null;
        try {
            appraisalSetup = setupDao.getAllAppraisalSetup();
            request.setAttribute("appraisalsetup", appraisalSetup);
            target = "success";
        } catch (DAOException doe) {            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

   
    public ActionForward manageSetup(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AppraisalSetupForm setupForm = (AppraisalSetupForm) form;
        String target = null;
        DAOFactory factory = new DAOFactory();
        AppraisalSetupDAO dao = factory.createAppraisalSetupManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        int setup_id[] = setupForm.getId();
        boolean ins = false;
        try {
            for (int i = 0; i < setup_id.length; i++) {
                AppraisalSetup setupPojo = dao.getAppraisalSetup(setup_id[i]);
                setupPojo.setStatus(setupForm.getStatus());
                ins = (boolean) dao.save(setupPojo);
            }

            if (ins == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("edit.ok", ""));
                target = "success";
                saveMessages(request, messages);

            } else {
                target = "failure";
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("edit.error", ""));
                saveErrors(request, messages);
            }

            setupForm.reset(mapping, request);


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
}
