package com.action;

import com.dao.AppraisalQuestionsDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;

import com.forms.AppraisalQuestionForm;
import com.pojo.AppraisalQuestions;
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
public class AppraisalQuestionAction extends DispatchAction {

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
    public ActionForward addQuestion(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        AppraisalQuestionsDAO dao = factory.createAppraisalQuestionsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        AppraisalQuestionForm questionform = (AppraisalQuestionForm) form;
        int[] category_code = questionform.getCategory_code();
        String[] question = questionform.getQuestion();
        HttpSession session = request.getSession();
        String uid = (String) session.getAttribute("user_id");
        if (uid != null) {
            try {
                for (int i = 0; i < category_code.length; i++) {
                    AppraisalQuestions questionpojo = new AppraisalQuestions();
                    questionpojo.setCategory_code(category_code[i]);
                    questionpojo.setQuestion(question[i]);
                    questionpojo.setCreated_by(uid);
                    questionpojo.setModified_by(uid);
                    questionpojo.setCreation_date(null);
                    questionpojo.setModification_date(null);
                    questionpojo.setStatus("Y");
                    dao.save(questionpojo);

                }
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";
            } catch (Exception e) {
                e.printStackTrace();
                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);

            }
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            target = "redirect";
            saveMessages(request, messages);
        }

        return mapping.findForward(target);
    }

    public ActionForward getAllQuestions(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        AppraisalQuestionsDAO dao = factory.createAppraisalQuestionsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        List<AppraisalQuestions> questionList = null;

        try {
            questionList = dao.getAllAppraisalQuestions();
          

            target = "success";
            request.setAttribute("statelist", questionList);

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
