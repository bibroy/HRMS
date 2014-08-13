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

import com.dao.DAOFactory;
import com.dao.SkillsDAO;



import com.pojo.EmployeeSkill;

import java.util.ArrayList;
import java.util.List;
import com.forms.EmpSkillForm;
import com.util.skillutil;
import com.dao.EmployeeSkillDAO;
import com.pojo.EmpSkills;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Administrator
 */
public class EmployeeSkillAction extends DispatchAction {

    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward editSkillSave(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        return mapping.findForward(SUCCESS);
    }

    public ActionForward load(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {




        DAOFactory dfact = new DAOFactory();
        SkillsDAO sdobj = dfact.createSkillsManager();
        String target = null;
        EmployeeSkillDAO empdao = dfact.createEmployeeSkillManager();
        EmpSkillForm frmobj = (EmpSkillForm) form;
        SkillsDAO skdao = dfact.createSkillsManager();
        List<EmployeeSkill> empsklist = null;
        List<skillutil> sklist = new ArrayList<skillutil>();
        try {
            String empid = "222";
            frmobj.setEmployeid(empid);


            empsklist = empdao.getEmployeeSkillByEmpId(empid);



            for (EmployeeSkill e : empsklist) {
                skillutil sk = new skillutil();
                sk.setSkillId(e.getSkillId().getSkillId());
                sk.setSkillname(e.getSkillId().getSkillName());
                sklist.add(sk);
            }
            request.setAttribute("sklist", sklist);
            target = "success";


        } catch (Exception e) {
        }
        return mapping.findForward(target);
    }

    public ActionForward Skillnamecall(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory dfact = new DAOFactory();

        EmployeeSkillDAO sdobj = dfact.createEmployeeSkillManager();
        List<EmployeeSkill> eskill = null;

        EmpSkillForm frmobj = (EmpSkillForm) form;
        String target = "success";
        try {


            String empid = frmobj.getEmployeid();
            eskill = sdobj.getEmployeeSkillByEmpId(empid);
            request.setAttribute("sklist", eskill);

            String skillname = frmobj.getSkills();
            eskill = sdobj.getEmployeeSkillIDAndNameCall(skillname, empid);
            if (eskill != null) {
                EmployeeSkill e = (EmployeeSkill) eskill.get(0);

                frmobj.setProficiency(e.getProficiencyLevel());
            }
            target = "success";

        } catch (Exception e) {

            log.error("error displaying attendance data" + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward EmployeeSkillretreivepage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();

        String target = null;
        HttpSession session = request.getSession();
        EmpSkillForm frm = (EmpSkillForm) form;
        EmpSkills pojo = null;
        DAOFactory dfact = new DAOFactory();
        EmployeeSkillDAO edao = dfact.createEmployeeSkillManager();

        try {
            if (session.getAttribute("user_id") != null) {
                String id = session.getAttribute("user_id").toString();
                frm.setEmployeid(id);
                pojo = edao.getEmployeeSkillbyempId(id);
                if(pojo!=null)
                frm.setProficiency(pojo.getProficiency());

                target = "success";
                System.out.print("*************target=====>" + target);
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("An Exception occur" + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward EmployeeSkillEditSavepage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        String target = null;
        HttpSession session = request.getSession();
        EmpSkillForm frm = (EmpSkillForm) form;
        EmpSkills e = null;
        DAOFactory dfact = new DAOFactory();
        EmployeeSkillDAO d = dfact.createEmployeeSkillManager();
        try {
            String id = session.getAttribute("user_id").toString();
            e = d.getEmployeeSkillbyempId(id);
            if (e != null) {
                String s = e.getSkills();
                s = s + "," + frm.getSkills();
                e.setSkills(s);

                d.save(e);
                frm.setProficiency(e.getProficiency());
                target = "success";

            } else {
                EmpSkills eobj = new EmpSkills();
                eobj.setId(d.getLastRequestId() + 1);
                eobj.setEmployeid(frm.getEmployeid());
                eobj.setProficiency(frm.getProficiency());
                eobj.setSkills(frm.getSkills());
                boolean rs = d.save(eobj);
                if (rs == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";
                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }
            }
        } catch (Exception fg) {
            log.error("An exception occur exception type is :" + fg);
        }
        return mapping.findForward(target);
    }
}
