/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.BaseDAO;
import com.dao.DAOFactory;
import com.dao.GoalSettingDAO;
import com.forms.GoalSettingForm;
import com.forms.GoalSettingModifyForm;
import com.pojo.GoalSetting;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Sumit Kumar
 */
public class GoalSettingAction extends DispatchAction {

    /* forward name="success" path="" */
    private static String target = "";

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward loadGoalSetting(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        GoalSettingForm gsform = (GoalSettingForm) form;
        try {
            if (session.getAttribute("user_id") != null) {
                String userid = session.getAttribute("user_id").toString();
                gsform.setEmployeeId(userid);
                target = "load";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error loading the page " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward saveGoalSettings(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        GoalSettingDAO gsdao = factory.createGoalsManager();
        GoalSettingForm gsform = (GoalSettingForm) form;
        BaseDAO b = new BaseDAO();
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        try {
            String[] goalTitle = gsform.getGoalTitle();
            String[] goalDesc = gsform.getGoalDesc();
            String[] probableCompDate = gsform.getProbableCompletionDate();
            String[] relatedOrgObj = gsform.getRelatedOrgObjective();
            Integer[] priority = gsform.getPriority();

            if (session.getAttribute("user_id") != null) {
                int len = goalTitle.length;
                for (int i = 0; i < len; i++) {
                    GoalSetting gs = new GoalSetting();
                    gs.setEmployeeId(gsform.getEmployeeId());
                    gs.setGoalId(gsdao.getLastId() + 1);
                    gs.setGoalSetDate(new Date());
                    gs.setCurrentStatus("initiated");
                    gs.setGoalTitle(goalTitle[i]);
                    gs.setGoalDesc(goalDesc[i]);
                    gs.setPriority(priority[i]);
                    gs.setProbableCompletionDate(b.mySqlDatebFormat(probableCompDate[i]));
                    gs.setRelatedOrgObjective(relatedOrgObj[i]);

                    boolean result = gsdao.saveGoal(gs);
                    if (!result) {
                        messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("Goal.notsaved", gs.getGoalTitle()));
                        saveErrors(request, messages);
                    }
                }
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }

        } catch (Exception e) {
            log.error("error saving the goal data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadEmployee(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        GoalSettingDAO gsdao = factory.createGoalsManager();
        List<GoalSetting> goallist = null;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        try {
            if (session.getAttribute("user_id") != null) {
                goallist = gsdao.getAllGoalSetting();
                request.setAttribute("empList", goallist);
                target = "load";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error fetching the list of employees from goals table " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadEmpGoals(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        GoalSettingDAO gsdao = factory.createGoalsManager();
        List<GoalSetting> goallist = null;
        List<GoalSetting> empGoalList = null;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        GoalSettingForm gsform = (GoalSettingForm) form;
        try {
            if (session.getAttribute("user_id") != null) {
                goallist = gsdao.getAllGoalSetting();
                request.setAttribute("empList", goallist);
                empGoalList = gsdao.getInitiatedGoalByEmpId(gsform.getEmployeeId());
                request.setAttribute("empGoalList", empGoalList);
                target = "load";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error fetching the list of employees from goals table " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward approveGoal(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        GoalSettingDAO gsdao = factory.createGoalsManager();
        GoalSettingForm gsform = (GoalSettingForm) form;
        ActionMessages messages = new ActionMessages();
        List<GoalSetting> emplist = null;

        try {
            emplist = gsdao.getInitiatedGoalByEmpId(gsform.getEmployeeId());
            int len = emplist.size();
            Integer[] id = new Integer[len];
            int i = 0;
            for (GoalSetting g : emplist) {
                id[i] = g.getGoalId();
                i++;
            }
            Integer[] gid = gsform.getGoals();
            boolean flag = true;
            for (int j = 0; j < len; j++) {
                GoalSetting gs = new GoalSetting();
                for (int k = 0; k < gid.length; k++) {
                    if (id[j].equals(gid[k])) {
                        gs = gsdao.getGoalById(id[j]);
                        gs.setCurrentStatus("approved");
                        gsdao.saveGoal(gs);
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    gs = gsdao.getGoalById(id[j]);
                    gs.setCurrentStatus("disapproved");
                    gsdao.saveGoal(gs);
                }
                flag = true;
            }
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
            saveMessages(request, messages);
            target = "load";

        } catch (Exception e) {
            log.error("error during saving the current status " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadModifyGoal(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        GoalSettingDAO gsdao = factory.createGoalsManager();
        List<GoalSetting> gslist = null;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        try {
            if (session.getAttribute("user_id") != null) {
                String userid = session.getAttribute("user_id").toString();
                gslist = gsdao.getGoalByEmpId(userid);
                request.setAttribute("goals", gslist);
                target = "load";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }

        } catch (Exception e) {
            log.error("error in loading the form " + e);
            target = "load";
        }
        return mapping.findForward(target);
    }

    public ActionForward loadGoalDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        GoalSettingDAO gsdao = factory.createGoalsManager();
        GoalSettingModifyForm gsform = (GoalSettingModifyForm) form;
        GoalSetting gs = null;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        List<GoalSetting> gslist = null;
        BaseDAO b = new BaseDAO();
        try {
            if (session.getAttribute("user_id") != null) {
                String userid = session.getAttribute("user_id").toString();
                gslist = gsdao.getGoalByEmpId(userid);
                request.setAttribute("goals", gslist);

                gs = gsdao.getGoalById(gsform.getGoalId());
                gsform.setGoalTitle(gs.getGoalTitle());
                gsform.setGoalDesc(gs.getGoalDesc());
                gsform.setCurrentStatus(gs.getCurrentStatus());
                if (gs.getGoalSetDate() != null) {
                    gsform.setGoalSetDate(b.mySQLscreenDateFormat(gs.getGoalSetDate()));
                } else {
                    gsform.setGoalSetDate("");
                }
                gsform.setNewSkillsAcquired(gs.getNewSkillsAcquired());
                gsform.setPriority(gs.getPriority());
                gsform.setProbableCompletionDate(b.mySQLscreenDateFormat(gs.getProbableCompletionDate()));
                gsform.setRelatedOrgObjective(gs.getRelatedOrgObjective());
                gsform.setEmployeeId(gs.getEmployeeId());
                target = "load";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error during loading the form data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward saveModifiedGoals(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        GoalSettingDAO gsdao = factory.createGoalsManager();
        GoalSetting gs = new GoalSetting();
        GoalSettingModifyForm gsform = (GoalSettingModifyForm) form;
        BaseDAO b = new BaseDAO();
        List<GoalSetting> gslist = null;
        HttpSession session = request.getSession();
        ActionMessages messages = new ActionMessages();
        try {
            if (session.getAttribute("user_id") != null) {

                String userid = session.getAttribute("user_id").toString();
                gslist = gsdao.getGoalByEmpId(userid);
                request.setAttribute("goals", gslist);

                gs.setGoalId(gsform.getGoalId());
                gs.setGoalTitle(gsform.getGoalTitle());
                gs.setGoalDesc(gsform.getGoalDesc());
                gs.setCurrentStatus(gsform.getCurrentStatus());
                gs.setEmployeeId(gsform.getEmployeeId());
                gs.setGoalSetDate(b.mySqlDatebFormat(gsform.getGoalSetDate()));
                gs.setNewSkillsAcquired(gsform.getNewSkillsAcquired());
                gs.setPriority(gsform.getPriority());
                gs.setProbableCompletionDate(b.mySqlDatebFormat(gsform.getProbableCompletionDate()));
                gs.setRelatedOrgObjective(gsform.getRelatedOrgObjective());

                boolean result = gsdao.saveGoal(gs);
                if (result) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";
                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }
        } catch (Exception e) {
            log.error("error saving the modified goal " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
            saveErrors(request, messages);
            target = "success";
        }
        return mapping.findForward(target);
    }

    public ActionForward closeGoal(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        GoalSettingDAO gsdao = factory.createGoalsManager();
        GoalSetting gs = new GoalSetting();
        GoalSettingModifyForm gsform = (GoalSettingModifyForm) form;
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        List<GoalSetting> gslist = null;
        try {
            if (session.getAttribute("user_id") != null) {

                String userid = session.getAttribute("user_id").toString();
                gslist = gsdao.getGoalByEmpId(userid);
                request.setAttribute("goals", gslist);

                gs = gsdao.getGoalById(gsform.getGoalId());
                gs.setCurrentStatus("completed");
                gs.setActualCompletionDate(new Date());
                boolean result = gsdao.saveGoal(gs);
                if (result) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";
                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }

        } catch (Exception e) {
            log.error("error  closing the goal " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
            saveErrors(request, messages);
            target = "success";
        }
        return mapping.findForward(target);
    }

    public ActionForward goalStatusReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        GoalSettingDAO gsdao = factory.createGoalsManager();
        List<GoalSetting> gslist = null;
        HttpSession session = request.getSession();
        ActionMessages messages=new ActionMessages();
        try {
            if (session.getAttribute("user_id") != null) {
                String user = session.getAttribute("user_id").toString();
                gslist = gsdao.getGoalByEmpId(user);
                request.setAttribute("goallist", gslist);
                target="report";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveErrors(request, messages);
                target = "sessionout";
            }

        } catch (Exception e) {
            log.error("error during loading the report"+e);
        }
        return mapping.findForward(target);
    }
}
