package com.action;


import com.dao.AppraisalCategoryDAO;
import com.dao.AppraisalGradeDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.forms.AppraisalCategoryForm;
import com.pojo.AppraisalCategory;
import com.pojo.AppraisalGrade;
import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.*;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalCategoryAction extends DispatchAction {

    public ActionForward addCategory(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        AppraisalCategoryDAO dao = factory.createAppraisalCategoryManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        AppraisalCategoryForm appraisalform = (AppraisalCategoryForm) form;
        String target = null;
        String category_name[] = appraisalform.getCategory_name();
        String category_description[] = appraisalform.getCategory_description();
        HttpSession session = request.getSession();
        String uid = (String) session.getAttribute("user_id");
         if(uid!=null)
        {
        try {
            for (int i = 0; i < category_name.length; i++) {
                AppraisalCategory appraisalCategory = new AppraisalCategory();
                appraisalCategory.setCategory_name(category_name[i]);
                appraisalCategory.setCategory_description(category_description[i]);
                // appraisalCategory.setCreated_by(appraisalform.getCreated_by());
                appraisalCategory.setCreated_by(uid);
                // appraisalCategory.setCreation_date(appraisalform.getCreation_date());
                appraisalCategory.setCreation_date(null);
                // appraisalCategory.setModification_date(appraisalform.getModification_date());
                appraisalCategory.setModification_date(null);
                // appraisalCategory.setModified_by(appraisalform.getModified_by());
                appraisalCategory.setModified_by(uid);
                appraisalCategory.setStatus("Y");
                dao.save(appraisalCategory);
            }
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
            saveMessages(request, messages);
            target = "success";


        } /*catch (DAOException doe) {
        //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
        log.error("critical error" + doe);
        }*/ catch (Exception e) {
            e.printStackTrace();
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error", e.getMessage()));
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
         }
        else
        {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            target = "redirect";
            saveMessages(request, messages);
       }
        return mapping.findForward(target);
    }

    public ActionForward editAppraisalCategory(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AppraisalCategoryForm categoryForm = (AppraisalCategoryForm) form;
        String target = null;
        DAOFactory factory = new DAOFactory();
        AppraisalCategoryDAO dao = factory.createAppraisalCategoryManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        int category_code[] = categoryForm.getCategory_code();
        String category_name[] = categoryForm.getCategory_name();
        String category_description[] = categoryForm.getCategory_description();
        boolean ins = false;
        String uid = (String) session.getAttribute("user_id");
         if(uid!=null)
        {
        try {
            for (int i = 0; i < category_code.length; i++) {
                AppraisalCategory categoryPojo = dao.getAppraisalCategories(category_code[i]);
                categoryPojo.setCategory_name(category_name[i]);
                categoryPojo.setCategory_description(category_description[i]);
                categoryPojo.setCreated_by(uid);
                categoryPojo.setCreation_date(new java.util.Date());
                categoryPojo.setModification_date(new java.util.Date());
                categoryPojo.setModified_by(uid);
                categoryPojo.setStatus("Y");
                ins = (boolean) dao.save(categoryPojo);
                String categorydetails = "categorydetails" + i;
                session.removeAttribute(categorydetails);
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




        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
       }
         else
        {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            target = "redirect";
            saveMessages(request, messages);
        }
        return mapping.findForward(target);
    }

    public ActionForward deleteAppraisalCategory(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        AppraisalCategoryForm categoryForm = (AppraisalCategoryForm) form;
        String target = null;
        DAOFactory factory = new DAOFactory();
        AppraisalCategoryDAO dao = factory.createAppraisalCategoryManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        int category_code[] = categoryForm.getCategory_code();
        boolean ins = false;
        try {
            for (int i = 0; i < category_code.length; i++) {
                AppraisalCategory categoryPojo = dao.getAppraisalCategories(category_code[i]);
                categoryPojo.setStatus("N");
                ins = (boolean) dao.save(categoryPojo);                
            }
            target="success";
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

    public ActionForward getAllCategories(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        AppraisalCategoryDAO dao = factory.createAppraisalCategoryManager();
        AppraisalGradeDAO gdao=factory.createAppraisalGradeManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        List<AppraisalCategory> categoryList = null;
        List<AppraisalGrade> gradeList=null;

        try {
            categoryList = dao.getAllAppraisalCategories();
            gradeList=gdao.getAllAppraisalGrades();
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
            target = "success";
            request.setAttribute("categorylist", categoryList);
            request.setAttribute("gradeList", gradeList);

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        return mapping.findForward(target);
    }

    public ActionForward getCategoryDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        AppraisalCategoryDAO dao = factory.createAppraisalCategoryManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        HttpSession session = request.getSession();
        List<AppraisalCategory> categoryDetails = null;
      AppraisalCategoryForm editForm = (AppraisalCategoryForm) form;
        int category_code[] = editForm.getCategory_code();
        ArrayList counter = new ArrayList();

        try {
            for (int i = 0; i < category_code.length; i++) {
                categoryDetails = dao.getCategoryDetails(category_code[i]);
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                String categorydetails = "categorydetails" + i;
                session.setAttribute(categorydetails, categoryDetails);
                counter.add(i);
            }
            session.setAttribute("counter", counter);
            target = "success";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        return mapping.findForward(target);
    }
}

