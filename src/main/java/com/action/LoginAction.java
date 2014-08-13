/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.action;

import com.dao.LoginDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.MenuDAO;
import com.forms.LoginForm;
import com.pojo.Login;
import com.pojo.Menu;

import org.apache.struts.action.ActionErrors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
 * @author Sumit Kumar
 */
public class LoginAction extends DispatchAction {
    
   
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward hrmsLogin(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EncryptImpl enc = EncriptionUtilFactory.getInstance().encryptFactory(Type.Base64);
        DAOFactory factory = new DAOFactory();
        LoginDAO dao = factory.createLoginManager();
        MenuDAO mdao = factory.createMenuManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        Login login = new Login();
        LoginForm loginform = (LoginForm) form;
        String target = "failure";
        String user_id = null;
        String user_role = "";
        Date loginDate;
        List<Menu> menulist = null;
       
        List<Login> authentication;
        try {
  //          authentication = dao.checkAuthentication(loginform.getUser_id(), enc.encodeString(loginform.getPassword()));      // encryption disabled for now (sumit)
             authentication = dao.checkAuthentication(loginform.getUser_id(), loginform.getPassword());
            ListIterator litr = authentication.listIterator();
            while (litr.hasNext()) {
                login = (Login) litr.next();
                user_id = login.getUserId();
                user_role = login.getRole();
                menulist = mdao.getMenuLinks(user_role);
            }
       /*
            Login loginPojo = dao.getLogin(loginform.getUser_id());
            loginPojo.setLastLogin(new java.util.Date().toString());
            dao.save(loginPojo);
        *
        *  commented by sumit
        */
            session.setAttribute("menu", menulist);
            session.setAttribute("user_id", user_id);
            session.setAttribute("role", login.getRoleName());
            session.setMaxInactiveInterval(1800);
           /*
            List<Menu> m=menulist;
            for(int i=0;i<m.size();i++)
            {
                System.out.println(m.get(i).getPageLink());
            }
            *  code for checking the population of menulist
            */
            target = "success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
            target = "failure";
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("login.failure", ""));
            saveMessages(request, messages);
        } catch (Exception e) {
            e.printStackTrace();
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
            target = "failure";
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("login.failure", ""));
            saveMessages(request, messages);
        }
        if (user_id == null) {
            target = "failure";
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("login.failure", ""));
            saveMessages(request, messages);
        }
        return mapping.findForward(target);
    }

     public ActionForward editUserPassword(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        LoginForm loginform = (LoginForm) form;
        EncryptImpl enc = EncriptionUtilFactory.getInstance().encryptFactory(Type.Base64);
        String target = null;
        Login login = new Login();
        DAOFactory factory = new DAOFactory();
        LoginDAO dao = factory.createLoginManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        List<Login> authentication;
        String uid = (String) session.getAttribute("user_id");
        String oldPassword = null;
        boolean ins = false;
        if(uid!=null)
        {
        try {

            authentication = dao.checkAuthentication(uid, enc.encodeString(loginform.getPassword()));
            ListIterator litr = authentication.listIterator();
            while (litr.hasNext()) {
                login = (Login) litr.next();
                oldPassword = login.getPassword();
            }
            if (oldPassword.equals(enc.encodeString(loginform.getPassword()))) {
                Login loginPojo = dao.getLogin(uid);
                loginPojo.setPassword(enc.encodeString(loginform.getNpassword()));
                ins = (boolean) dao.save(loginPojo);
            }

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        if (ins == true) {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("password.edit.ok", ""));
            target = "success";
            saveMessages(request, messages);

        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("password.edit.error", ""));
            target = "success";
            saveMessages(request, messages);
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


    public ActionForward logout(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) {
        ActionMessages messages = new ActionMessages();
        request.getSession().removeAttribute("menu");
        request.getSession().removeAttribute("user_id");
        request.getSession().removeAttribute("role");
        request.getSession().invalidate();
        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("logout.success", ""));
        String target = "success";
        saveMessages(request, messages);
        return mapping.findForward(target);
    }
}
