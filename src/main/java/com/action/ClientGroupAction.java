/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.action;

import com.dao.ClientGrpDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.forms.ClientGroupForm;
import com.pojo.ClientGroup;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author shrayanti
 */
public class ClientGroupAction extends DispatchAction {
    
    /* forward name="success" path="" */
    public ActionForward saveOrEdit(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
	ClientGrpDAO dao = factory.createClientGrpManager();
        ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
        String target = null;
        ClientGroupForm clientGrpForm = (ClientGroupForm) form;
        List<ClientGroup>  clientGrpList = new ArrayList<ClientGroup>();
        ClientGroup client = null;

        try{
            
          
                client = new ClientGroup();
                client.setGrCode(clientGrpForm.getGr_code());
                client.setGrDescription(clientGrpForm.getGr_description());
                client.setGrName(clientGrpForm.getGr_name());
               
                client.setGrStatus("Y");
                System.out.println("$$$$$$$$$$$$$$$$$$$$ActionMethod");
                dao.save(client);
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok",""));
                saveMessages(request, messages);
            }


        catch (DAOException doe) {

		errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error",doe.getMessage()));
                saveErrors(request, errors);
		log.error("critical error" + doe);
	}catch (Exception e) {

	    // Report the error using the appropriate name and ID.
		errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error.unknown"));
                saveErrors(request, errors);
		log.error("error From ExceptionClass "+e);

	}
                target="success";
        return mapping.findForward(target);
    }


    public ActionForward load(ActionMapping mapping, ActionForm  form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
	ClientGrpDAO dao = factory.createClientGrpManager();
        ActionErrors errors = new ActionErrors();
	ActionMessages messages = new ActionMessages();
        String target = null;
        ClientGroupForm clientGrpForm = (ClientGroupForm) form;
        List<ClientGroup>  clientGrpList = new ArrayList<ClientGroup>();
        ClientGroup client = null;

        try{
            clientGrpList = dao.getAllClientGrp();
            if(clientGrpList!=null && clientGrpList.size()>0){
                request.setAttribute("clientGrp",clientGrpList);
            }
            if(clientGrpForm.getGr_master_id()>0){
                client = dao.getClientGrp(clientGrpForm.getGr_master_id());
                clientGrpForm.setGr_code(client.getGrCode());
                clientGrpForm.setGr_description(client.getGrDescription());
                clientGrpForm.setGr_name(client.getGrName());
                clientGrpForm.setGr_status(client.getGrStatus());
            }
        }catch (DAOException doe) {

		errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error",doe.getMessage()));
		log.error("critical error" + doe);
	}catch (Exception e) {

	    // Report the error using the appropriate name and ID.
		errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error.unknown"));
		log.error("error From ExceptionClass "+e);

	}
        if (!errors.isEmpty()) {

		target="failure";
	    	saveErrors(request, errors);

	} else {
                target="success";
		saveMessages(request, messages);

	}

        return mapping.findForward(target);
    }
}
