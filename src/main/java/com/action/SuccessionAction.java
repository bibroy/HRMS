/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import com.dao.DAOFactory;
import com.dao.KeyPositionDAO;
import java.util.List;
import com.pojo.KeyPosition;
import com.pojo.EmpSkills;
import com.dao.EmpSkillsDAO;
import com.forms.KeyPositionForm;
import com.forms.SuccessorForm;
import com.pojo.Successor;
import java.util.Date;

/**
 *
 * @author Pradipto Roy
 */
public class SuccessionAction extends DispatchAction {

    /* forward name="success" path="" */
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
    public ActionForward getKeyPosition(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        KeyPositionDAO keydao = factory.createKeyPositionManager();
        List<KeyPosition> list = null;
        try {
            list = keydao.getAllKeyPosition();
            request.setAttribute("position", list);
            target = "positionreport";
        } catch (Exception e) {
            log.error("error " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getSuitableEmployee(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        EmpSkillsDAO empdao = factory.createEmpSkillManager();
        List<EmpSkills> list = null;
        try {
            String skill = null;
            try {
                skill = request.getParameter("skills").toString();
            } catch (Exception e) {
            }
            if (skill != null) {
                list = empdao.getEmployeeBySkill(skill);
            }
            request.setAttribute("emplistsuccession", list);
            target = "emplistsuccession";

        } catch (Exception e) {
            log.error("error " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getreport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        EmpSkillsDAO empdao = factory.createEmpSkillManager();
        List<EmpSkills> list = null;
        try {
            String skill = null;
            String id = null;
            try {
                skill = request.getParameter("skills").toString();
                id = request.getParameter("posid");

            } catch (Exception e) {
            }
            if (skill != null) {
                list = empdao.getEmployeeBySkill(skill);
            }
            request.setAttribute("posid", id);
            request.setAttribute("emplistsuccession", list);
            target = "emplistsuccession";

        } catch (Exception e) {
            log.error("error " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward KeyPositionSaveEdit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        ActionMessages messages = new ActionMessages();

        DAOFactory dfact = new DAOFactory();
        KeyPositionDAO keydao = dfact.createKeyPositionManager();
        KeyPosition keypojo = new KeyPosition();
        KeyPositionForm frm = (KeyPositionForm) form;

        try {

            keypojo.setId(keydao.getLastRequestId()+1);
            keypojo.setPositionTitle(frm.getPositionTitle());
            keypojo.setIncumbentName(frm.getIncumbentName());
            keypojo.setRetirementStatus(frm.getRetirementStatus());
            keypojo.setSkills(frm.getSkills());
            keypojo.setStaffReady(frm.getStaffReady());
            keypojo.setStaffReadyNext(frm.getStaffReadyNext());
            keypojo.setCriticality(frm.getCriticality());

            boolean rs = keydao.save(keypojo);


            if (rs == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";

            }

        } catch (Exception e) {
            log.error("An exception occur exception type is :" + e);

        }


        return mapping.findForward(target);


    }

    public ActionForward SuccesorSave(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        ActionMessages messages = new ActionMessages();
        SuccessorForm frm = (SuccessorForm) form;
        DAOFactory dfact = new DAOFactory();
        KeyPositionDAO keydao = dfact.createKeyPositionManager();
        Successor sucpojo = new Successor();

        KeyPosition keypojo = new KeyPosition();
        String id = frm.getPositionID();



        try {
            keypojo = keydao.getKeyPositionById(Integer.parseInt(id));
            int length = frm.getEmployee().length;
            for (int i = 0; i < length; i++) {

                sucpojo.setId(keydao.getLastRequestIdforSuccessor() + 1);
                sucpojo.setPositionID(frm.getPositionID());
                sucpojo.setType(frm.getType());
                sucpojo.setEntryDate(new Date());
                sucpojo.setSuccesorID(frm.getEmployee()[i]);

                boolean rs = keydao.save(sucpojo);
                if (frm.getType().equals("1")) {

                    keypojo.setStaffReady((keypojo.getStaffReady() == null ? 0 : keypojo.getStaffReady()) + 1);


                } else if (frm.getType().equals("2")) {

                    keypojo.setStaffReadyNext((keypojo.getStaffReadyNext() == null ? 0 : keypojo.getStaffReadyNext()) + 1);
                }
                keydao.save(keypojo);


                if (rs == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";
                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";

                }
                target = "success";
            }

        } catch (Exception e) {
            log.error("An exception occur exception type is :" + e);

        }



        return mapping.findForward(target);
    }
}
