package com.action;

import com.dao.LoginDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.forms.LoginForm;
import com.pojo.Login;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import java.util.*;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionMessage;
import com.util.encrypt.EncriptionUtilFactory;
import com.util.encrypt.EncryptImpl;
import com.util.encrypt.EncriptionUtilFactory.Type;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalLoginAction extends DispatchAction {

      public ActionForward doAppraisalLogin(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        EncryptImpl enc = EncriptionUtilFactory.getInstance().encryptFactory(Type.Base64);
        LoginDAO dao = factory.createLoginManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        Login login = new Login();
        com.util.SubEmployeeList eList=new com.util.SubEmployeeList();
        LoginForm loginform = (LoginForm) form;
        List<Login> logininfo;
        String uid=null;
        List empIdList=null;
        List empNameList=null;
        String target = "failure";
        try {
            logininfo=dao.checkAuthentication(loginform.getUser_id(), loginform.getPassword());
            ListIterator litr = logininfo.listIterator();
            while (litr.hasNext()) {
                login = (Login) litr.next();
                uid = login.getUserId();
            }
            session.setAttribute("user_id",uid);
            empIdList=eList.getEmpIdList(uid);
            empNameList=eList.getEmpNameList(uid);

            request.setAttribute("empIdList",empIdList);
            request.setAttribute("empNameList",empNameList);
            target = "success";
        } catch (DAOException doe) {            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }
         if (uid== null) {
            target = "failure";
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("login.failure", ""));
            saveMessages(request, messages);
        }
        return mapping.findForward(target);
    }
}