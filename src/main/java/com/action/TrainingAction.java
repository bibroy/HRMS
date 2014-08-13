/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.BaseDAO;
import com.dao.BranchDAO;
import com.dao.ConsultancyDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.DepartmentDAO;
import com.dao.EmployeeMasterDAO;
import com.dao.JobTypeDAO;
import com.dao.SkillsDAO;
import com.dao.TrainingCalenderDao;
import com.dao.TrainingDAO;
import com.forms.TrainingCalenderForm;
import com.forms.TrainingForm;
import com.pojo.City;
import com.pojo.Consultancy;
import com.pojo.Department;
import com.pojo.DocDump;
import com.pojo.JobType;
import com.pojo.Skills;
import com.pojo.Training;
import com.pojo.TrainningType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import com.util.TrainingDetail;
import com.util.TrainingUtil;
import com.pojo.TraingCalender;
import javax.servlet.http.HttpSession;
import com.pojo.TrainingRequestMaster;
import com.forms.TrainingSheduleForm;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.pojo.TrainingSchedule;
import com.dao.TrianingSheduleDAO;
import com.pojo.EmployeeMaster;
import com.util.EmployeeBean;
import com.util.TrainingNeeds;
import com.forms.TrainingNeedsForm;
import com.forms.TrainingTransactionForm;
import java.math.BigDecimal;
import com.forms.TrainingFeedbackForm;
import com.dao.TraingFeedbackDAO;
import com.pojo.TrainerFeedback;

/**
 *
 * @author ranjans
 */
public class TrainingAction extends DispatchAction {

    /***
     * 
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward addTraining(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //--
        DAOFactory factory = new DAOFactory();

        //--
        TrainingDAO dao = factory.createTrainingManager();
        SkillsDAO skillDAO = factory.createSkillsManager();
        ConsultancyDAO consultancyDAO = factory.createConsultancyManager();
        //--
        ActionErrors errors = new ActionErrors();
        //--
        ActionMessages messages = new ActionMessages();
        //--
        TrainingForm trainingForm = (TrainingForm) form;
        Training training = new Training();
        //--
        String target = null;
        List<Skills> skills = null;
        List<Consultancy> consultancyList = null;
        List<Training> trainings = null;
        Map<String, String> fildsSet = new HashMap<String, String>();


        int deptId = 0;
        try {
            // -- populate Skill dropdown against Department
            // -- here department id is 3 i.e. sales & distribution
            /***
             * Pick up skillId form
             *  Session
             */
            fildsSet = TrainingUtil.getRequireParam(request);
            deptId = Integer.parseInt(fildsSet.get("deptCode"));
            /***
             *  Pick up skillId form
             *  Session
             */
            // --- skills=populateSkillsAgainstDepartment(skillDAO, 3);
            skills = populateSkillsAgainstDepartment(skillDAO, deptId);
            request.setAttribute("skills", skills);

            if (!trainingForm.getDdlConsultancy().equalsIgnoreCase("select")) {
                training.setConsultancyId(Integer.parseInt(trainingForm.getDdlConsultancy()));
            }


            /***
             * Add position in database
             */
            training.setStatus(trainingForm.getDdlStatus());
            training.setTrainer(trainingForm.getTrainerName());
            training.setTrainingName(trainingForm.getTrainingName());
            training.setTrainingType(trainingForm.getDdlTrainingMode());
            training.setSkillId(Integer.parseInt(trainingForm.getDdlSkillsName()));
            training.setId(trainingForm.getDepartmentId());
            training.setTypeId(Integer.parseInt(trainingForm.getJobType()));

            if (trainingForm.getTrainingId() != 0) {
                // -- Update
                training.setTrainingId(trainingForm.getTrainingId());
                dao.updateTrainingDtl(training);
            } else {
                // -- Insert
                dao.addTrainingDtl(training);
            }

            consultancyList = populateConsultancyBasedonSkills(consultancyDAO, Integer.parseInt(trainingForm.getDdlSkillsName().trim()));
            System.out.println("@@@ Consultancy Size @@@" + consultancyList.size());
            request.setAttribute("consultancyList", consultancyList);
            //target="success";

            // -- get department Id from Session or
            //--  pevious Department Report
            // -- for testing purpose we set it as 3
            request.setAttribute("departmentId", deptId);
            // --- request.setAttribute("departmentId",3);
            // --- generate report list
            trainings = dao.getTrainingDtlsAgainstDepartment(deptId);
            // --- trainings=dao.getTrainingDtlsAgainstDepartment(3);
            request.setAttribute("trainings", trainings);

            target = "viewTrainingReport";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            System.out.println("@@@error From DAO@@@" + doe);
            log.error("critical error" + doe);
        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            System.out.println("@@@error From ExceptionClass@@@" + e.getMessage());
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    /***
     *
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward viewDtl(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        SkillsDAO skillDAO = factory.createSkillsManager();
        TrainingDAO trainingDAO = factory.createTrainingManager();
        ConsultancyDAO consultancyDAO = factory.createConsultancyManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        List<Department> departments = null;
        List<Skills> skills = null;
        List<Consultancy> consultancyList = null;
        String target = null;
        TrainingDetail training = null;
        TrainingForm trainingForm = (TrainingForm) form;
        Map<String, String> fildsSet = new HashMap<String, String>();
        int deptId = 0;
        int companyCode = 0;
        List<TrainningType> trainingTypes = null;
        List<City> positions = null;
        JobType jobType = new JobType();

        try {
            fildsSet = TrainingUtil.getRequireParam(request);
            /***
             * Pick up skillId form
             *  Session
             */
            log.info("@@@deptId@@@" + fildsSet.get("deptCode"));
            deptId = Integer.parseInt(fildsSet.get("deptCode"));
            companyCode = Integer.parseInt(fildsSet.get("companyCode"));
            /***
             *  Pick up skillId form
             *  Session
             */
            // -- populate Skill dropdown against Department
            // -- here department id is 3 i.e. sales & distribution
            skills = populateSkillsAgainstDepartment(skillDAO, deptId);

            departments = trainingDAO.getDeptByCompCode(Integer.toString(companyCode));
            request.setAttribute("departments", departments);

            // -- populate Training Type Session
            trainingTypes = TrainingUtil.getAllTrainingType();
            request.setAttribute("trainingTypes", trainingTypes);

            if ((request.getParameter("trainingId") != null && request.getParameter("trainingId").toString().trim().length() > 0) && (request.getParameter("departmentId") != null && request.getParameter("departmentId").toString().trim().length() > 0)) {
                // -- populate edit mode
                //training.setTrainingId(Integer.parseInt(request.getParameter("trainingId").toString().trim()));

                jobType.setId(deptId);
                jobType.setCompanyCode(companyCode);

                request.setAttribute("jobTypes", TrainingUtil.getJobTypeAgainstDeptCompanyCode(jobType));

                request.setAttribute("skills", skills);

                request.setAttribute("positions", TrainingUtil.getAllCity());

                training = trainingDAO.getTrainingDtl(Integer.parseInt(request.getParameter("trainingId").toString().trim()));
                /***
                 *
                 */
                trainingForm.setDdlSkillsName(Integer.toString(training.getSkillId()));
                trainingForm.setDdlStatus(training.getStatus());
                trainingForm.setTrainerName(training.getTrainer());
                trainingForm.setTrainingName(training.getTrainingName());
                trainingForm.setDepartment(Integer.toString(training.getDepartmentId()));
                trainingForm.setDdlTrainingMode(training.getTrainingMode());

                trainingForm.setJobType(Integer.toString(training.getTypeId()));

                //  -- trainingForm.setDesignation(training);
                /***
                 *
                 */
                log.info("@@@ Department Name @@@" + training.getDepartment());
                // -- Populate Consultancy dropdown
                consultancyList = populateConsultancyBasedonSkills(consultancyDAO, Integer.parseInt(trainingForm.getDdlSkillsName().trim()));
                log.info("@@@ Consultancy Size @@@" + consultancyList.size());
                request.setAttribute("consultancyList", consultancyList);
                // --- It should be multiselect
                log.info("@@@ Consultancy name @@@" + training.getConsultancy());
                trainingForm.setDdlConsultancy(training.getConsultancy());

                /***
                 *
                 */
            } else {
                // -- populate insert mode
            }
            target = "success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
            System.out.println("@@@ Critical error @@@" + doe.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error("error From ExceptionClass " + ex);
            System.out.println("@@@ error From ExceptionClass @@@" + ex.getMessage());
        }

        return mapping.findForward(target);
    }

    /***
     * Pick up trainingagainst Department Id
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward trainingReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        //--
        DAOFactory factory = new DAOFactory();
        //--
        TrainingDAO dao = factory.createTrainingManager();
        //--
        ActionErrors errors = new ActionErrors();
        //--
        ActionMessages messages = new ActionMessages();

        String target = null;
        List<Training> trainings = null;
        Map<String, String> fildsSet = new HashMap<String, String>();
        int deptId = 0;
        // -- get department Id from Session or
        //--  pevious Department Report
        // -- for testing purpose we set it as 3

        fildsSet = TrainingUtil.getRequireParam(request);
        /***
         * Pick up skillId form
         *  Session
         */
        deptId = Integer.parseInt(fildsSet.get("deptCode"));
        /***
         *  Pick up skillId form
         *  Session
         */
        // --- request.setAttribute("departmentId",3);
        request.setAttribute("departmentId", deptId);
        // --- trainings=dao.getTrainingDtlsAgainstDepartment(3);
        trainings = dao.getTrainingDtlsAgainstDepartment(deptId);
        request.setAttribute("trainings", trainings);
        target = "viewTrainingReport";
        return mapping.findForward(target);
    }

    /***
     * Pick up trainingagainst Department Id
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward trainingShowReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        //--
        DAOFactory factory = new DAOFactory();
        //--
        TrainingDAO dao = factory.createTrainingManager();
        //--
        ActionErrors errors = new ActionErrors();
        //--
        ActionMessages messages = new ActionMessages();

        List<TrainingDetail> trainingDetails = new ArrayList<TrainingDetail>();

        String target = null;

        if (request.getParameter("status") != null && request.getParameter("status").trim().length() > 0) {

            if (request.getParameter("status").equalsIgnoreCase("master")) {
                // -- Generate Master Report
                trainingDetails = dao.getTrainingDtlsReport();
                request.setAttribute("trainingDetails", trainingDetails);
                target = "master";
            } else if (request.getParameter("status").equalsIgnoreCase("internal")) {
                // -- Generate Internal Report
                trainingDetails = dao.getTrainingIEReport("internal");
                request.setAttribute("trainingDetails", trainingDetails);
                target = "internal";
            } else if (request.getParameter("status").equalsIgnoreCase("external")) {
                // --  Generate External Report
                trainingDetails = dao.getTrainingIEReport("external");
                request.setAttribute("trainingDetails", trainingDetails);
                target = "external";
            }
        }
        return mapping.findForward(target);
    }

    /***
     * View
     * training material form
     * With populated Training name
     * and Experience Lavel
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward trainingMaterialView(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        String target = null;
        TrainingForm trForm = (TrainingForm) form;
        List<Training> trainings = null;
        // -- Get All training
        trainings = TrainingUtil.getAllTraining();
        request.setAttribute("trainings", trainings);

        target = "addTrainingMaterial";

        return mapping.findForward(target);
    }

    /***
     * Upload file in
     * file system
     * and
     * path in database
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward trainingMaterialUpload(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        TrainingForm trForm = (TrainingForm) form;
        DocDump docDump = new DocDump();
        String fileDtl = null;

        try {
            fileDtl = TrainingUtil.uploadFile(request, trForm, "materials");
            docDump.setExpLavel(trForm.getDdlExpLavel());
            docDump.setFileType("T");
            docDump.setStatus("Y");
            docDump.setPathName(fileDtl);
            docDump.setTrainingId(Integer.parseInt(trForm.getDdlTrainingName()));
            TrainingUtil.addDocDump(docDump);
            target = "addTrainingMaterial";
        } catch (Exception exception) {
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
     *
     * @param skillsDAO
     * @param departmentId
     * @return
     * @throws DAOException
     * @throws Exception
     */
    private List<Skills> populateSkillsAgainstDepartment(SkillsDAO skillsDAO, int departmentId) throws DAOException, Exception {
        return skillsDAO.getSkillsByDepartment(departmentId);
    }

    /***
     *
     * @param consultancyDAO
     * @param skilId
     * @return
     * @throws DAOException
     * @throws Exception
     */
    private List<Consultancy> populateConsultancyBasedonSkills(ConsultancyDAO consultancyDAO, int skilId) throws DAOException, Exception {

        Skills skills = new Skills();
        skills.setSkillId(skilId);
        return consultancyDAO.searchConsultancybySkill(skills);
    }

    /***
     * Populate List of
     * training objects
     * with status initiated
     * @param trainingDAO
     * @return
     * @throws DAOException
     * @throws Exception
     */
    private List<Training> populateTrainingList(TrainingDAO trainingDAO) throws DAOException, Exception {
        // --- It is populate based on User JobType
        // -- List<Training> trainings=trainingDAO.getTrainingDtlsAgainstDepartment(departmentId);
        //return trainings;
        return null;

    }

    public ActionForward TraingCalenderDetailSaveOrEdit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        String target = null;
        DAOFactory dfact = new DAOFactory();
        TrainingCalenderForm frm = (TrainingCalenderForm) form;
        TrainingCalenderDao tado = dfact.createTrainingCalenderManager();
        TraingCalender trobj = new TraingCalender();
        BaseDAO b = new BaseDAO();
        HttpSession session = request.getSession();


        try {
            if (session.getAttribute("user_id") != null) {
                String userid = session.getAttribute("user_id").toString();


                trobj.setId(tado.getLastRequestId().intValue() + 1);
                trobj.setFromDate(b.mySqlDatebFormat(frm.getFromDate()));
                trobj.setToDate(b.mySqlDatebFormat(frm.getToDate()));
                trobj.setCreationDate(b.mySqlDatebFormat(frm.getCreatedDate()));
                trobj.setCreatedBy(userid);
                trobj.setTrainingName(frm.getTrainingName());
                trobj.setCapacityStrenth(frm.getCapacityStrenth());
                boolean rs = tado.save(trobj);
                if (rs == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";
                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";

                }
            } else {

                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveMessages(request, messages);
                target = "sessionout";
            }


        } catch (DAOException e) {
            log.error("Error occured " + e);
        }

        return mapping.findForward(target);




    }

    public ActionForward loadTrainingCalender(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        ActionMessages messages = new ActionMessages();
        TrainingCalenderForm frm = (TrainingCalenderForm) form;
        HttpSession session = request.getSession();
        try {

            if (session.getAttribute("user_id") != null) {

                frm.setCreatedBy(session.getAttribute("user_id").toString());
                target = "success";

            } else {

                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
                saveMessages(request, messages);
                target = "sessionout";
            }

        } catch (Exception e) {
            log.error("Error occured " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadTrainingShedule(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        DAOFactory dfact = new DAOFactory();
        List<TrainingRequestMaster> lstpojo = null;
        TrainingDAO tdao = dfact.createTrainingManager();

        try {
            lstpojo = tdao.getTrainingStatusReport();
            request.setAttribute("DetailsOFTrainingStatus", lstpojo);
            target = "success";

        } catch (Exception e) {
            log.error("An exception occur" + e);

        }


        return mapping.findForward(target);

    }

    public ActionForward loaddetailsofTrainingbyRequestID(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String target = null;
        List<TraingCalender> calenderlist;


        TrainingSheduleForm frm = (TrainingSheduleForm) form;
        DAOFactory dfact = new DAOFactory();
        TrainingDAO tdao = dfact.createTrainingManager();
        TrainingRequestMaster trainingrequest = new TrainingRequestMaster();
        List<TrainingRequestMaster> lstpojo = null;
        TrainingCalenderDao tcalenderdao = dfact.createTrainingCalenderManager();
        BaseDAO b = new BaseDAO();

        try {

            String takerequestid = frm.getRequestId().toString();
            trainingrequest = tdao.getTrainingDetailsByRequestID(takerequestid);
            frm.setEmployeeID(trainingrequest.getEmployeeApplyId().toString());
            frm.setFromDate(b.mySQLscreenDateFormat(trainingrequest.getFromDate()));
            frm.setToDate(b.mySQLscreenDateFormat(trainingrequest.getToDate()));


            calenderlist = tcalenderdao.getTrainingNamesDetails();
            request.setAttribute("trainingnamedetails", calenderlist);



            lstpojo = tdao.getTrainingStatusReport();
            request.setAttribute("DetailsOFTrainingStatus", lstpojo);
            target = "success";



        } catch (Exception e) {
            log.error("Excption occured " + e);

        }

        return mapping.findForward(target);


    }

    public ActionForward traingdetailsSave(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        String target = null;

        TrainingSheduleForm frm = (TrainingSheduleForm) form;
        DAOFactory dfact = new DAOFactory();
        TrainingCalenderDao tcalenderdao = dfact.createTrainingCalenderManager();
        List<TraingCalender> list = null;
        TrainingSchedule trpojo = new TrainingSchedule();
        TrianingSheduleDAO shduledao = dfact.createTrainingSheduleManager();
        List<TrainingRequestMaster> lstpojo = null;
        BaseDAO b = new BaseDAO();
        TrainingDAO tdao = dfact.createTrainingManager();
        try {

            String trname = frm.getTrainingName();
            String stdate = frm.getFromDate();
            String todate = frm.getToDate();


            list = tcalenderdao.getTrainingDetailsCheck(trname, stdate, todate);
            if ((!list.isEmpty())) {

                trpojo.setId(tcalenderdao.getLastRequestId() + 1);
                trpojo.setEmployeeId(frm.getEmployeeID());
                trpojo.setTrainingname(frm.getTrainingName());
                trpojo.setFromDate(b.mySqlDatebFormat(frm.getFromDate()));
                trpojo.setToDate(b.mySqlDatebFormat(frm.getToDate()));

                boolean rs = shduledao.save(trpojo);
                if (rs == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";
                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";

                }



                lstpojo = tdao.getTrainingStatusReport();
                request.setAttribute("DetailsOFTrainingStatus", lstpojo);
                target = "success";

            } else {

                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("Training.notAvailable", ""));
                saveErrors(request, messages);
                lstpojo = tdao.getTrainingStatusReport();
                request.setAttribute("DetailsOFTrainingStatus", lstpojo);
                target = "success";
            }


        } catch (Exception e) {

            log.error("An error is occured eror type is:" + e);
        }

        target = "success";

        return mapping.findForward(target);

    }

    public ActionForward selectedEmployeeDetailsForTraining(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = "";

        DAOFactory dfact = new DAOFactory();
        List<TrainingNeeds> list = new ArrayList<TrainingNeeds>();
        TrainingDAO tdao = dfact.createTrainingManager();

        try {

            list = tdao.getTrainingNeedsReportsForEmployees();
            request.setAttribute("requiredTrainingdetails", list);
            target = "success";
            log.info("Display successfully");
        } catch (Exception e) {
            log.error("An exception occur" + e);

        }



        return mapping.findForward(target);

    }

    public ActionForward retreivingEmployeeDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String target = "";
        TrainingNeedsForm frm = (TrainingNeedsForm) form;

        DAOFactory dfact = new DAOFactory();
        EmployeeMasterDAO edao = dfact.createEmployeeMasterManager();
        List<EmployeeBean> list = new ArrayList<EmployeeBean>();
        EmployeeBean eb = new EmployeeBean();
        DepartmentDAO ddao = dfact.createDepartmentManager();
        EmployeeMaster em = null;
        TrainingTransactionForm tform = new TrainingTransactionForm();
        JobTypeDAO jobDao = dfact.createJobTypeManager();
        List<JobType> joblist = null;
        BranchDAO brdao = dfact.createBranchDAOManager();
        try {

            String empid = frm.getEmployeeId();

            em = edao.getEmployeeMasterByEmpId(empid);
            tform.setDepartmentName(ddao.getDepartment(em.getDepartmentId().intValue()).getDepartmentName());
            eb.setEmpId(em.getEmployeeId());
            eb.setEmpName(em.getFirstName());
            list.add(eb);
            BigDecimal companyid = brdao.getBranchNameByBranchID(em.getBranchId().intValue()).getCompany().getCompanyCode();
            joblist = jobDao.getJobtypeByComanyDepartmentID(em.getDepartmentId().toString(), companyid.toString());
            request.setAttribute("jobTypes", joblist);
            request.setAttribute("employees", list);
            request.setAttribute("TrainingTransactionForm", tform);

            target = "employees";

        } catch (Exception e) {

            log.error("An exception occur exception tpe is :" + e);

        }


        return mapping.findForward(target);
    }

    public ActionForward trainingidretreiving(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        String target = "";
        EmployeeMaster empname;
        DAOFactory dfact = new DAOFactory();
        TraingFeedbackDAO tdao = dfact.createtrainingFeedbackManager();
        List<TrainingSchedule> fdback = null;
        TrainingFeedbackForm frm = (TrainingFeedbackForm) form;
        EmployeeMasterDAO edao = dfact.createEmployeeMasterManager();

        try {
            String fr = frm.getTrainingid();
            fdback = tdao.getTrainingScheduleByID(fr);
            for (TrainingSchedule ts : fdback) {
                ts.setEmployeename(edao.getEmployeeMasterByEmpId(ts.getEmployeeId()).getFirstName());
            }

            request.setAttribute("trainingid", fdback);

            target = "success";
            log.info("Data successfully fetched to combobox first in form");


        } catch (Exception e) {
            log.error("Exception occur exception type is:" + e);
            target = "success";
        }


        return mapping.findForward(target);

    }

    public ActionForward SubmitEmployeeInformation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();
        String target = null;
        DAOFactory dfact = new DAOFactory();
        TraingFeedbackDAO trdao = dfact.createtrainingFeedbackManager();
        TrainerFeedback tfeedback = new TrainerFeedback();
        TrainingFeedbackForm frm = (TrainingFeedbackForm) form;
        BaseDAO b = new BaseDAO();
        try {
            boolean rs=false;
            for (int i = 0; i < frm.getEmployeeID().length; i++) {
                tfeedback.setId(trdao.getRequestbyID() + 1);
                tfeedback.setEmployeeID(frm.getEmployeeID()[i]);
                tfeedback.setMaxmarks(Integer.parseInt(frm.getMaxmarks()));
                tfeedback.setTrainingid(Integer.parseInt(frm.getTrainingid()));
                tfeedback.setStartdate(b.NewDateFormat(frm.getStartdate()[i]));
                tfeedback.setEndDate(b.NewDateFormat(frm.getEndDate()[i]));
                tfeedback.setScore(Integer.parseInt(frm.getScore()[i]));
                rs = trdao.save(tfeedback);
                if(!rs)break;
            }
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
            log.error("An error is occured eror type is:" + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward retreivingFeeedbackInformation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;

        DAOFactory dfact = new DAOFactory();
        TraingFeedbackDAO trdao = dfact.createtrainingFeedbackManager();
        TrainingFeedbackForm frm = (TrainingFeedbackForm) form;
        EmployeeMasterDAO edao = dfact.createEmployeeMasterManager();
        List<TrainerFeedback> lst = null;

        try {
            String id = frm.getTrainingid();
            lst = trdao.getTrainingFeedbackbyTrnID(id);
            for (TrainerFeedback l : lst) {
                l.setEmployeename(edao.getEmployeeMasterByEmpId(l.getEmployeeID()).getFirstName());

            }


            //edao.getEmployeeMasterByEmpId(frm.getEmployeeID());

            request.setAttribute("trainingfeedbackdetails", lst);
            target = "success";
            log.info("Data displayed successfully");

        } catch (Exception e) {

            log.error("An exception occur exception type is " + e);
        }


        return mapping.findForward(target);

    }
}
