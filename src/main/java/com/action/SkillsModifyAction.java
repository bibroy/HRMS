/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.DepartmentDAO;
import com.dao.SkillsDAO;
import com.forms.SkillsForm;
import com.pojo.Department;
import com.pojo.Skills;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import com.util.TrainingUtil;

/**
 *
 * @author ranjans
 */
public class SkillsModifyAction extends DispatchAction {

    /***
     *  Call at first time for modify page
     * and when cancel button is pressed
     * when page is load
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward showSkills(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        SkillsDAO skillDAO = factory.createSkillsManager();
        //DepartmentDAO departmentDAO=factory.createDepartmentManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        Skills skills = new Skills();
        SkillsForm skillForm = (SkillsForm) form;
        String target = null;
        List<Department> departments = null;
        Map<String, String> fildsSet = new HashMap<String, String>();

        try {
            //departments=populateDepartmentList(departmentDAO);
            // -- Company code come from session and 1 is put for tes purpose
            // -- 3 set for sales
            fildsSet = TrainingUtil.getRequireParam(request);

            // --departments=populateDepartmentListAgainstComp(skillDAO,1);
            departments = populateDepartmentListAgainstComp(skillDAO, Integer.parseInt(fildsSet.get("companyCode")));
            request.setAttribute("departments", departments);
            //System.out.println("@@@ Outside Update view @@@"+request.getParameter("skillId").toString());
            // -- If the modify page is open in edit mode
            if (request.getParameter("skillId") != null && request.getParameter("skillId").toString().trim().length() > 0) {

                skills.setSkillId(Integer.parseInt(request.getParameter("skillId").toString().trim()));
                skills = skillDAO.getSkills(skills);
                System.out.println("@@@ Inside Update view @@@");
                /***
                 * Populate formBean for edit mode
                 */
                skillForm.setSkillId(skills.getSkillId());
                skillForm.setDdlStatus(skills.getStatus());
                skillForm.setDdlDepartMentName(skills.getDepartmentId());
                skillForm.setSkillName(skills.getSkillName());
                skillForm.setCreatedBy(1); // -- Set created by by employee Id
                log.info("@@@ Name @@@" + skills.getSkillName());
                /***
                 * Populate formBean for edit mode
                 */
            }
            // === target = "success";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        target = "success";
        return mapping.findForward(target);
    }

    /***
     * Insert or update skils based on hiddenSkill Id
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward modifySkillDepartment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        DepartmentDAO departmentDAO = factory.departmentManager();
        SkillsDAO skillDAO = factory.createSkillsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        SkillsForm skillForm = (SkillsForm) form;
        List<Department> departments = null;
        Skills skills = new Skills();
        // -- Add new for list
        List<Skills> skillsList = null;
        Map<String, String> fildsSet = new HashMap<String, String>();
        int deptId = 0;
        try {
            //departments=populateDepartmentList(departmentDAO);
            // -- Company code come from session and 1 is put for tes purpose
            // -- 3 is use for sales
            //-- departments=populateDepartmentListAgainstComp(skillDAO,1);
            fildsSet = TrainingUtil.getRequireParam(request);
            departments = populateDepartmentListAgainstComp(skillDAO, Integer.parseInt(fildsSet.get("companyCode")));
            request.setAttribute("departments", departments);
            //skillForm.setDdlStatus("B");
            /*** add formBean to POJO ***/
            skills.setDepartmentId(skillForm.getDdlDepartMentName());

            skills.setSkillName(skillForm.getSkillName());
            skills.setStatus(skillForm.getDdlStatus());
            /*** add formBean to POJO ***/
            if (skillForm.getSkillId() != 0) {
                // -- Update
                skills.setSkillId(skillForm.getSkillId());
                skillDAO.updateSkill(skills);
            } else {
                // -- Insert
                skillDAO.addSkill(skills);
            }
            /*** populate list ***/
            // -- 3 is usefor sales
            //if(getSessionVal("dept_Id",request)!=null){
            //     deptId=Integer.parseInt(getSessionVal("dept_Id",request));
            //  }
            deptId = Integer.parseInt(fildsSet.get("deptCode"));

            // --skillsList=populateSkills(skillDAO,3);
            //===skillsList=populateSkills(skillDAO,deptId);
            skillsList = populateAllSkills(skillDAO);
            log.info("@@@ Skills Detail @@@" + skillsList.size());
            request.setAttribute("skills", skillsList);
            /*** populate list ***/
            target = "viewreport";
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

    /***
     * Show Report for skills
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward showSkillsReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        SkillsDAO skillDAO = factory.createSkillsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        List<Skills> skills = null;
        String target = null;
        Map<String, String> fildsSet = new HashMap<String, String>();
        int deptId = 0;
        try {
            // -- Pick up Skill details against department Id
            // -- DepartmentIdcome from session
            // -- 3 is usefor testing
            fildsSet = TrainingUtil.getRequireParam(request);
            deptId = Integer.parseInt(fildsSet.get("deptCode"));


            //skills=populateSkills(skillDAO,3);

            //===skills=populateSkills(skillDAO,deptId);
            skills = populateAllSkills(skillDAO);
            log.info("@@@ Skills Detail @@@" + skills.size());
            request.setAttribute("skills", skills);
            target = "viewreport";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward fillSkills(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        SkillsDAO skillDAO = factory.createSkillsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        List<Skills> skills = null;
        String target = null;
        try
        {
            skills = populateAllSkills(skillDAO);
             request.setAttribute("skillsList", skills);
             target="success";
        }
        catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error From ExceptionClass " + e);
        }
         return mapping.findForward(target);
    }


    public ActionForward menuPage(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        log.info("@@@ Inside Training  Request from Employee @@@");
        String target = "menuall";
        return mapping.findForward(target);
    }

    /***
     * Populate skill
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward showSkillsAgainstJobType(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.println("@@@ Popuate Skills by ajax call @@@");
        DAOFactory factory = new DAOFactory();
        SkillsDAO skillDAO = factory.createSkillsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        List<Skills> skills = null;
        String target = null;
        try {
            if (request.getParameter("typeId") != null && request.getParameter("typeId").trim().length() > 0) {
                skills = skillDAO.getSkillsByJobType(Integer.parseInt(request.getParameter("typeId")));
            }
            request.setAttribute("skills", skills);
            target = "success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    /***
     * This is use for populate department details
     * @param departmentDAO
     * @return
     * @throws DAOException
     * @throws Exception
     */
    private List<Department> populateDepartmentList(DepartmentDAO departmentDAO) throws DAOException, Exception {
        return departmentDAO.getAllDepartment();
    }

    /***
     * This is use for populate department details
     * Against company code
     * @param departmentDAO
     * @return
     * @throws DAOException
     * @throws Exception
     */
    private List<Department> populateDepartmentListAgainstComp(SkillsDAO skillsDAO, int companyCode) throws DAOException, Exception {
        return skillsDAO.getDepartmentByCompanyCode(companyCode);
    }

    /***
     * This is use for popuate Skills against departentId
     * @param skillsDAO
     * @param departmentId
     * @return
     * @throws DAOException
     * @throws Exception
     */
    private List<Skills> populateSkills(SkillsDAO skillsDAO, int departmentId) throws DAOException, Exception {
        //=== return   skillsDAO.getSkillsByDepartment(departmentId);
        return skillsDAO.getSkillsByDepartment(departmentId);
    }

    /***
     * This is use for popuate all Skills
     * whoes status is A
     * @param skillsDAO
     * @param departmentId
     * @return
     * @throws DAOException
     * @throws Exception
     */
    private List<Skills> populateAllSkills(SkillsDAO skillsDAO) throws DAOException, Exception {
        //=== return   skillsDAO.getSkillsByDepartment(departmentId);
        return skillsDAO.getSkills();

    }
}
