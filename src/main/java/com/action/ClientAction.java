/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.ClientDAO;
import com.dao.ClientGrpDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.ProjectDAO;

import com.forms.ClientForm;
import com.pojo.Client;
import com.pojo.ClientGroup;
import com.pojo.Project;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionErrors;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import com.util.ClientStatusReport;

/**
 * 
 * @author shrayanti
 */
public class ClientAction extends DispatchAction {

    public ActionForward saveOrEdit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        ClientDAO dao = factory.createClientManager();
        ClientGrpDAO clientGrpdao = factory.createClientGrpManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        ClientForm clientForm = (ClientForm) form;
        List<ClientGroup> clientGrpList = new ArrayList<ClientGroup>();
        List<Client> clientList = new ArrayList<Client>();
        Client client = null;

        try {
            if (clientForm.getClid() == 0) {
                client = new Client();
                client.setClId(clientForm.getClid());
                client.setAddress(clientForm.getAddress());
                client.setClientGrpid(clientForm.getGr_master_id());
                client.setContactPerson(clientForm.getContactPerson());
                client.setEmail(clientForm.getEmail());
                client.setFax(clientForm.getFax());
                client.setMobile(clientForm.getMobile());
                client.setPhone(clientForm.getPhone());
                client.setClientName(clientForm.getClientName());
                client.setClientCode(clientForm.getClientCode());


                client.setStatus("Y");

                dao.save(client);
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);

            } else {
                client = dao.getClient(clientForm.getClid());

                client.setAddress(clientForm.getAddress());
                client.setClientGrpid(clientForm.getGr_master_id());
                client.setContactPerson(clientForm.getContactPerson());
                client.setEmail(clientForm.getEmail());
                client.setFax(clientForm.getFax());
                client.setMobile(clientForm.getMobile());

                client.setPhone(clientForm.getPhone());
                client.setClientName(clientForm.getClientName());
                client.setStatus(clientForm.getStatus());
                client.setClientCode(clientForm.getClientCode());

                dao.save(client);
                clientList = dao.getAllClient();
                if (clientList != null && clientList.size() > 0) {
                    request.setAttribute("client", clientList);

                }
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("edit.ok", ""));
                saveMessages(request, messages);

            }
            clientGrpList = clientGrpdao.getAllClientGrp();
            //System.out.println("##################"+clientGrpList+"##############");
            if (clientGrpList != null && clientGrpList.size() > 0) {
                request.setAttribute("clientGrp", clientGrpList);
            }
        } catch (DAOException doe) {

            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error", doe.getMessage()));

            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error.unknown"));

            log.error("error From ExceptionClass " + e);

        }
        if (!errors.isEmpty()) {

            target = "failure";
            saveErrors(request, errors);

        } else {
            target = "success";
            saveMessages(request, messages);

        }

        return mapping.findForward(target);
    }

    public ActionForward load(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ClientGrpDAO dao = factory.createClientGrpManager();
        ClientDAO clientdao = factory.createClientManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        ClientForm clientForm = (ClientForm) form;
        List<ClientGroup> clientGrpList = new ArrayList<ClientGroup>();
        List<Client> clientList = new ArrayList<Client>();
        Client client = null;
        try {
            clientGrpList = dao.getAllClientGrp();

            if (clientGrpList != null && clientGrpList.size() > 0) {
                request.setAttribute("clientGrp", clientGrpList);
            }
            clientList = clientdao.getAllClient();
            if (clientList != null && clientList.size() > 0) {
                request.setAttribute("client", clientList);
            }
            if (clientForm.getClid() > 0) {
                client = clientdao.getClient(clientForm.getClid());

                clientForm.setAddress(client.getAddress());
                clientForm.setGr_master_id(client.getClientGrpid());
                clientForm.setContactPerson(client.getContactPerson());
                clientForm.setEmail(client.getEmail());
                clientForm.setFax(client.getFax());
                clientForm.setMobile(client.getMobile());
                clientForm.setPhone(client.getPhone());
                clientForm.setClientName(client.getClientName());
                clientForm.setStatus(client.getStatus());
                clientForm.setClientCode(client.getClientCode());
            }

        } catch (DAOException doe) {

            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error", doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        if (!errors.isEmpty()) {

            target = "failure";
            saveErrors(request, errors);

        } else {
            target = "success";
            saveMessages(request, messages);

        }

        return mapping.findForward(target);
    }

    public ActionForward loadClient(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String target = null;


        DAOFactory factory = new DAOFactory();
        ClientDAO clientdao = (ClientDAO) factory.createClientManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        ClientForm clientform = (ClientForm) form;
        List<Client> clientList = null;



        try {


            Client clientPojo = new Client();

            clientList = clientdao.getAllClientByClientgroup(clientform.getGr_master_id());
            System.out.println("%%%%%%%%%%%%%%%" + clientList + "%%%%%%%%%%%%%%%%%%");
            request.setAttribute("client", clientList);

            //target = "success";




        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }




        target = "success";

//System.out.print("************************"+target+"****************************");
        return mapping.findForward(target);
    }

    public ActionForward clientReportInformation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        ClientForm clntfrm = (ClientForm) form;
        List<Project> probj=null;
        DAOFactory dfact=new DAOFactory();
        ProjectDAO pdao=dfact.createProjectManager();
        List<Client> clnt=null;
        ClientDAO clntdao=dfact.createClientManager();
        List<ClientStatusReport> cobj=new ArrayList<ClientStatusReport>();


        try
        {

        String id = clntfrm.getClienttype();

        if (id.equals("1"))

        {
      
            cobj=pdao.getClientStatusReport();
            request.setAttribute("current", cobj);

            target="success";


        } else if (id.equals("2")) {

            clnt=clntdao.getAllClient();
            request.setAttribute("All", clnt);
            target="success";

        }

         }
        catch(Exception e)
        {
            log.error("An exception occurexception type is:"+e);

        }

        return mapping.findForward(target);


    }
}
