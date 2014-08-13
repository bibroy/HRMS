/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.ImplClass.TrainingDAOImpl;
import com.ImplClass.TrainingEmployeeTransactionDAOImpl;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.EmployeeMasterDAO;
import com.dao.SkillsDAO;
import com.dao.TrainingDAO;
import com.dao.TrainingEmployeeTransactionDAO;
import com.dao.TrainingTransactionDAO;
import com.forms.TrainingTransactionForm;
import com.pojo.EmployeeMaster;
import com.pojo.JobType;
import com.pojo.Skills;
import com.pojo.Training;
import com.pojo.TrainingEmpInfo;
import com.pojo.TrainingRequestEmployee;
import com.pojo.TrainingTransation;
import com.pojo.TrainningType;
import com.util.EmployeeBean;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSessionContext;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import com.util.TrainingDetail;
import com.util.TrainingTransactionDetail;
import com.util.TrainingUtil;
import com.util.UserDtls;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ranjans
 */
public class TrainingTransactionAction extends DispatchAction {

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward addTrainingEmployee(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        /***
         *
         */
        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        DAOFactory factory = new DAOFactory();
        TrainingTransactionDAO trainingTransactionDAO = factory.createTrainingTransactionManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        TrainingTransation trainingTransation = new TrainingTransation();
        String target = null;
        TrainingDAOImpl trainingDAOImpl = new TrainingDAOImpl();
        Map<String, String> fildsSet;
        Map<String, Object> jobSkills;
        JobType jobType = new JobType();
        int empId = 0;
        // ---EmpDetails empDetails;
        EmployeeMaster empDetails;
        Map<String, Object> empDtl;
        List<TrainingRequestEmployee> trainingEmployeeList = new ArrayList<TrainingRequestEmployee>();
        TrainingRequestEmployee trainingRequestEmployee = new TrainingRequestEmployee();

        try {
            // -- populate Skill dropdown against Department
            // -- here department id is 3 i.e. sales & distribution        
            fildsSet = TrainingUtil.getRequireParam(request);
            empId = Integer.parseInt(fildsSet.get("employeeId"));
            empDtl = TrainingUtil.populateEmpName(empId);
            // --- empDetails=(EmpDetails)empDtl.get("employeeDetails");
            empDetails = (EmployeeMaster) empDtl.get("employeeDetails");
            jobSkills = populateSkillList(fildsSet);
            jobType = (JobType) jobSkills.get("jobTypeDtl");
            request.setAttribute("skills", (List<Skills>) jobSkills.get("skillList"));
            // --- request.setAttribute("trainings", TrainingUtil.populateTrainingAgainstSkill(empDetails.getSkillId()));
            request.setAttribute("trainings", TrainingUtil.populateTrainingAgainstSkill(trainingTransactionForm.getDdlSkillsName()));
            //   --- trainings
            /**
             * populate formbean
             */
            trainingTransactionForm.setEmployeeName(empDtl.get("name").toString());
            // ---  trainingTransactionForm.setDepartmentName(empDetails.getDepartment().getDepartmentName());
            // ===  trainingTransactionForm.setDepartmentName("Test");
            trainingTransactionForm.setDepartmentName(empDetails.getDepartmentId().toString());
            trainingTransactionForm.setJobType(jobType.getJobName());
            /***
             *  populate form bean
             */
            // --
            /***
             * populate DAO Bean
             */
            trainingTransation.setFromDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableFrom()));
            trainingTransation.setToDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableTo()));
            trainingTransation.setTrainingId(Integer.parseInt(trainingTransactionForm.getDdlTrainingName()));
            trainingTransation.setStatus(trainingTransactionForm.getStatus());
            // -- trainingTransation.setEmployeeApplyId(trainingTransactionForm.getEmployeeId());

            // -- set value as employee request flag as ereq
            trainingTransation.setStatus("ereq");

            // --- add for new relational table in training andemployee
            trainingRequestEmployee.setEmployeeId(new BigDecimal(trainingTransactionForm.getEmployeeId()));
            trainingEmployeeList.add(trainingRequestEmployee);

            trainingTransation.setTrainingRequestEmployee(trainingEmployeeList);

            /***
             * populate DAO Bean
             */
            /***
             * populate DAO Bean
             */
            if (trainingTransactionForm.getRequestId() != 0) {
                // --- Update mode
                trainingTransation.setRequestId(trainingTransactionForm.getRequestId());
                trainingTransactionDAO.updateTrainingTransation(trainingTransation);

            } else {
                // --- Insert mode
                trainingTransactionForm.setRequestId(trainingTransactionDAO.getLastRequestId().intValue() + 1);
                if (trainingTransactionForm.getRequestId() != 0) {
                    trainingTransation.setRequestId(trainingTransactionForm.getRequestId());
                }
                trainingTransactionDAO.insertTrainingTransation(trainingTransation);
            }
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
            saveMessages(request, messages);
            target = "success";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.info("@@@error From DAO@@@" + doe);
            log.error("critical error" + doe);
        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.info("@@@error From ExceptionClass@@@" + e.getMessage());
            log.error("error From ExceptionClass " + e);
        }

        log.info("@@@ Inside training Request By employee @@@");
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
    public ActionForward approveTrainingHOD(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        /***
         *
         */
        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        DAOFactory factory = new DAOFactory();
        TrainingTransactionDAO trainingTransactionDAO = factory.createTrainingTransactionManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        TrainingTransation trainingTransation = new TrainingTransation();
        TrainingDAOImpl trainingDAOImpl = new TrainingDAOImpl();
        // TrainingRequestEmployee trainingRequestEmployee =new TrainingRequestEmployee();
        String target = null;
        List<TrainingRequestEmployee> trainingRequest = new ArrayList<TrainingRequestEmployee>();
        Map<String, String> fildsSet = new HashMap<String, String>();
        List<TrainingTransactionDetail> traingList;
        EmployeeMasterDAO empdao = factory.createEmployeeMasterManager();
        try {
            fildsSet = TrainingUtil.getRequireParam(request);
            /***
             * populate DAO Bean
             */
            trainingTransation.setFromDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableFrom()));
            trainingTransation.setToDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableTo()));
            trainingTransation.setTrainingId(Integer.parseInt(trainingTransactionForm.getDdlTrainingName()));
            trainingTransation.setEmployeeApproveId(Integer.parseInt(fildsSet.get("employeeId")));
            trainingTransation.setStatus("hodapprove");

            String empappid = empdao.getEmployeeMaster(Integer.parseInt(trainingTransactionForm.getEmployeeId())).getEmployeeId();
            trainingTransation.setEmployeeApplyId(empappid);


            if (trainingTransactionForm.getRequestId() != 0) {
                // --- Update mode
                log.info("@@@ Inside Update mode start @@@");
                trainingTransation.setRequestId(trainingTransactionForm.getRequestId());
                trainingTransation.setTrainingRequestEmployee(trainingRequest);
                trainingTransactionDAO.updateTrainingTransation(trainingTransation);
                log.info("@@@ Inside Update mode end @@@");
            } else {
                // --- Insert mode
                log.info("@@@ Inside Insart mode Start @@@");
                trainingTransation.setTrainingRequestEmployee(trainingRequest);
                trainingTransactionDAO.insertTrainingTransation(trainingTransation);
                log.info("@@@ Inside Insert mode End @@@");
            }

            /***
             *  Generate report after approvel
             */
            trainingTransation.setStatus("ereq");
            traingList = trainingTransactionDAO.getTrainingTransactionAgainstFlg(trainingTransation);
            request.setAttribute("trainingTransactions", traingList);
            target = "transactionReport";
            /***
             *  Generate report after approval
             */
            // --- target="success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.info("@@@error From DAO@@@" + doe);
            log.error("critical error" + doe);
        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.info("@@@error From ExceptionClass@@@" + e.getMessage());
            log.error("error From ExceptionClass " + e);
        }

        log.info("@@@ Inside approved By HOD @@@");
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
    public ActionForward disApproveTrainingHOD(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        DAOFactory factory = new DAOFactory();
        TrainingTransactionDAO trainingTransactionDAO = factory.createTrainingTransactionManager();
        SkillsDAO skillDAO = factory.createSkillsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        TrainingTransation trainingTransation = new TrainingTransation();
        String target = null;
        TrainingDAOImpl trainingDAOImpl = new TrainingDAOImpl();
        List<TrainingRequestEmployee> trainingRequest = new ArrayList<TrainingRequestEmployee>();
        Map<String, String> fildsSet = new HashMap<String, String>();
        List<TrainingTransactionDetail> traingList;
        try {
            fildsSet = TrainingUtil.getRequireParam(request);
            /***
             * populate DAO Bean
             */
            trainingTransation.setFromDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableFrom()));
            trainingTransation.setToDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableTo()));
            trainingTransation.setTrainingId(Integer.parseInt(trainingTransactionForm.getDdlTrainingName()));
            trainingTransation.setEmployeeApproveId(Integer.parseInt(fildsSet.get("employeeId")));
            trainingTransation.setStatus("hoddiappr");
            /***
             * populate DAO Bean
             */
            /***
             * populate DAO Bean
             */
            if (trainingTransactionForm.getRequestId() != 0) {
                // --- Update mode
                log.info("@@@ Inside Update mode start @@@");
                trainingTransation.setRequestId(trainingTransactionForm.getRequestId());
                trainingTransation.setTrainingRequestEmployee(trainingRequest);
                trainingTransactionDAO.updateTrainingTransation(trainingTransation);
                log.info("@@@ Inside Update mode end @@@");

            } else {
                // --- Insert mode
                log.info("@@@ Inside Insart mode Start @@@");
                trainingTransation.setTrainingRequestEmployee(trainingRequest);
                trainingTransactionDAO.insertTrainingTransation(trainingTransation);
                log.info("@@@ Inside Insert mode End @@@");
            }

            /***
             *  Generate report after disapprovel
             */
            trainingTransation.setStatus("ereq");
            traingList = trainingTransactionDAO.getTrainingTransactionAgainstFlg(trainingTransation);
            request.setAttribute("trainingTransactions", traingList);
            target = "transactionReport";
            /***
             *  Generate report after disapproval
             */
            // --- target="success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.info("@@@error From DAO@@@" + doe);
            log.error("critical error" + doe);
        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.info("@@@error From ExceptionClass@@@" + e.getMessage());
            log.error("error From ExceptionClass " + e);
        }
        log.info("@@@ Inside disapproved By HOD @@@");
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
    public ActionForward addTrainingHOD(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        DAOFactory factory = new DAOFactory();
        TrainingTransactionDAO trainingTransactionDAO = factory.createTrainingTransactionManager();
        SkillsDAO skillDAO = factory.createSkillsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        TrainingTransation trainingTransation = new TrainingTransation();
        String target = null;
        Map<String, Object> jobSkills;
        List<Skills> skills = null;
        // --- List<EmpDetails>employees=null;
        List<EmployeeBean> employees = null;
        List<UserDtls> users = null;
        Map<String, String> fildsSet = new HashMap<String, String>();
        int deptId = 0;
        int impApprovedId = 0;
        JobType jobType = null;
        List<TrainingRequestEmployee> trainingRequestEmployeeList = new ArrayList<TrainingRequestEmployee>();
        /////
        try {
            // -- populate Skill dropdown against Department            
            fildsSet = TrainingUtil.getRequireParam(request);
            jobSkills = populateSkillList(fildsSet);
            if (jobSkills != null) {
                jobType = (JobType) jobSkills.get("jobTypeDtl");
            }

            request.setAttribute("jobTypes", TrainingUtil.getJobTypeAgainstDeptCompanyCode(jobType));
            request.setAttribute("skills", (List<Skills>) jobSkills.get("skillList"));
            request.setAttribute("trainings", TrainingUtil.populateTrainingAgainstSkill(trainingTransactionForm.getDdlSkillsName()));

            deptId = Integer.parseInt(fildsSet.get("deptCode"));
            impApprovedId = Integer.parseInt(fildsSet.get("employeeId"));
            TrainingDAOImpl trainingDAOImpl = new TrainingDAOImpl();
            /***
             * pick up the employeeId from
             * employee array
             */
            String[] employeesArr = trainingTransactionForm.getDdlEmployees();
            //int arLength=employeesArr.length-1;
            // -- StringBuffer empAll=new StringBuffer();
            log.info("@@@ Length of array @@@" + employeesArr.length);
            for (int count = 0; count < employeesArr.length; count++) {
                TrainingRequestEmployee trainingRequestEmployee = new TrainingRequestEmployee();
                log.info("@@@ Employee Id @@@" + employeesArr[count]);

                trainingRequestEmployee.setEmployeeId(new BigDecimal(employeesArr[count]));

                trainingRequestEmployeeList.add(trainingRequestEmployee);
                /*
                if(arLength>0 && arLength==count){
                empAll.append(","+employeesArr[count]);
                }
                else{
                empAll.append(employeesArr[count]);
                }
                 */

            }
            // log.info("@@@ All employees are "+empAll.toString());
            /***
             * end of pick up the employeeId from
             * employee array
             */
            // --
            /***
             * populate DAO Bean
             */
            trainingTransation.setFromDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableFrom()));
            trainingTransation.setToDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableTo()));
            trainingTransation.setTrainingId(Integer.parseInt(trainingTransactionForm.getDdlTrainingName()));
            trainingTransation.setStatus(trainingTransactionForm.getStatus());

            trainingTransation.setTrainingRequestEmployee(trainingRequestEmployeeList);
            trainingTransation.setEmployeeApproveId(impApprovedId);
            // -- set value as hod request flag as hodreq
            trainingTransation.setStatus("hodreq");
            /***
             * populate DAO Bean
             */
            /***
             * populate DAO Bean
             */
            if (trainingTransactionForm.getRequestId() != 0) {
                // --- Update mode
                trainingTransation.setRequestId(trainingTransactionForm.getRequestId());
                trainingTransactionDAO.updateTrainingTransation(trainingTransation);

            } else {
                // --- Insert mode
                trainingTransactionDAO.insertTrainingTransation(trainingTransation);
            }
            //--- employees=populateEmployeeListAgainstDepartment(trainingTransactionDAO,deptId);
            employees = TrainingUtil.populateEmployeeListAgainstDepartment(deptId);
            // --- users=TrainingUtil.populateFullNames(employees);
            //-- request.setAttribute("skills", skills);
            request.setAttribute("skills", (List<Skills>) jobSkills.get("skillList"));
            // --- request.setAttribute("employees", users);

            request.setAttribute("employees", employees);

            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
            saveMessages(request, messages);

            target = "success";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.info("@@@error From DAO@@@" + doe);
            log.error("critical error" + doe);
        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.info("@@@error From ExceptionClass@@@" + e.getMessage());
            log.error("error From ExceptionClass " + e);
        }
        log.info("@@@ Inside add By HOD @@@");
        return mapping.findForward(target);
    }

    /***
     * Approve from HR
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward approveTrainingHR(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        /***
         *
         */
        log.info("@@@ Inside approved By HR @@@");
        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        DAOFactory factory = new DAOFactory();
        TrainingTransactionDAO trainingTransactionDAO = factory.createTrainingTransactionManager();
        //SkillsDAO skillDAO=factory.createSkillsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        TrainingTransation trainingTransation = new TrainingTransation();
        String target = null;
        TrainingDAOImpl trainingDAOImpl = new TrainingDAOImpl();
        List<TrainingTransactionDetail> traingList;

        try {
            // -- populate Skill dropdown against Department
            // -- here department id is 3 i.e. sales & distribution            
            // --
            /***
             * populate DAO Bean
             */
            trainingTransation.setFromDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableFrom()));
            trainingTransation.setToDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableTo()));
            trainingTransation.setTrainingId(Integer.parseInt(trainingTransactionForm.getDdlTrainingName()));
            //trainingTransation.setStatus(trainingTransactionForm.getStatus());
            // trainingTransation.setEmployeeApplyId(trainingTransactionForm.getEmployeeId());
            trainingTransation.setEmployeeApproveId(trainingTransactionForm.getApprovedBy());
            // -- set value as employee request flag as ereq
            trainingTransation.setStatus("hrapprove");
            /***
             * populate DAO Bean
             */
            /***
             * populate DAO Bean
             */
            if (trainingTransactionForm.getRequestId() != 0) {
                // --- Update mode
                trainingTransation.setRequestId(trainingTransactionForm.getRequestId());
                trainingTransactionDAO.updateTrainingTransation(trainingTransation);

            } else {
                // --- Insert mode
                trainingTransactionDAO.insertTrainingTransation(trainingTransation);
            }
            /***
             *  Generate report after approvel
             */
            //===trainingTransation.setStatus("hodapprove");
            if (request.getParameter("flg") != null) {
                trainingTransation.setStatus(request.getParameter("flg").toString());
            }
            traingList = trainingTransactionDAO.getTrainingTransactionAgainstFlg(trainingTransation);
            log.info("@@@ Size of training request list@@@" + traingList.size());
            request.setAttribute("trainingTransactions", traingList);
            target = "transactionReportHR";
            log.info("@@@ Inside Approve @@@");
            /***
             *  Generate report after approval
             */
            // --- target="success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.info("@@@error From DAO@@@" + doe);
            log.error("critical error" + doe);
        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.info("@@@error From ExceptionClass@@@" + e.getMessage());
            log.error("error From ExceptionClass " + e);
        }

        // === log.info("@@@ Inside approved By HR @@@");
        return mapping.findForward(target);
    }

    /***
     * Disapprove from HR
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward disApproveTrainingHR(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        DAOFactory factory = new DAOFactory();
        TrainingTransactionDAO trainingTransactionDAO = factory.createTrainingTransactionManager();
        //SkillsDAO skillDAO=factory.createSkillsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        TrainingTransation trainingTransation = new TrainingTransation();
        String target = null;
        TrainingDAOImpl trainingDAOImpl = new TrainingDAOImpl();
        List<TrainingTransactionDetail> traingList;

        try {
            /***
             * populate DAO Bean
             */
            trainingTransation.setFromDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableFrom()));
            trainingTransation.setToDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableTo()));
            trainingTransation.setTrainingId(Integer.parseInt(trainingTransactionForm.getDdlTrainingName()));
            //trainingTransation.setStatus(trainingTransactionForm.getStatus());
            // --- trainingTransation.setEmployeeApplyId(trainingTransactionForm.getEmployeeId());
            trainingTransation.setEmployeeApproveId(trainingTransactionForm.getApprovedBy());
            // -- set value as employee request flag as ereq
            trainingTransation.setStatus("hrdiappr");
            /***
             * populate DAO Bean
             */
            /***
             * populate DAO Bean
             */
            if (trainingTransactionForm.getRequestId() != 0) {
                // --- Update mode
                trainingTransation.setRequestId(trainingTransactionForm.getRequestId());
                trainingTransactionDAO.updateTrainingTransation(trainingTransation);

            } else {
                // --- Insert mode
                trainingTransactionDAO.insertTrainingTransation(trainingTransation);
            }

            /***
             *  Generate report after approvel
             */
            // === trainingTransation.setStatus("hodapprove");
            if (request.getParameter("flg") != null) {
                trainingTransation.setStatus(request.getParameter("flg").toString());
            }
            traingList = trainingTransactionDAO.getTrainingTransactionAgainstFlg(trainingTransation);
            request.setAttribute("trainingTransactions", traingList);
            target = "transactionReportHR";
            /***
             *  Generate report after approval
             */
            // --- target="success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.info("@@@error From DAO@@@" + doe);
            log.error("critical error" + doe);
        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.info("@@@error From ExceptionClass@@@" + e.getMessage());
            log.error("error From ExceptionClass " + e);
        }

        log.info("@@@ Inside disapproved By HR @@@");
        return mapping.findForward(target);
    }

    /***
     * Populate form
     * against training
     * request from employee
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward reqFromEmploye(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        DAOFactory factory = new DAOFactory();
        HttpSession session = request.getSession(true);
        TrainingTransactionDAO trainingTransactionDAO = factory.createTrainingTransactionManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        TrainingTransation trainingTransation = new TrainingTransation();
        // --- EmpDetails empDetails;
        EmployeeMaster empDetails;
        String target = null;
        Map<String, String> fildsSet;
        TrainingDAOImpl trainingDAOImpl = new TrainingDAOImpl();
        JobType jobType;
        int empId = 0;
        Map<String, Object> empDtl;
        Map<String, Object> jobSkills;

        try {

            fildsSet = TrainingUtil.getRequireParam(request);
            jobSkills = populateSkillList(fildsSet);
            empId = Integer.parseInt(fildsSet.get("employeeId"));
            //deptId=Integer.parseInt(fildsSet.get("deptCode"));
            //typeId=Integer.parseInt(fildsSet.get("typeId"));
            //companyCode=Integer.parseInt(fildsSet.get("companyCode"));
            log.info("@@@ ``` Before Employee name ``` @@@");
            empDtl = TrainingUtil.populateEmpName(empId);
            log.info("@@@ ``` After Employee name ``` @@@");
            // ---empDetails=(EmpDetails)empDtl.get("employeeDetails");
            empDetails = (EmployeeMaster) empDtl.get("employeeDetails");
            jobType = (JobType) jobSkills.get("jobTypeDtl");
            request.setAttribute("skills", (List<Skills>) jobSkills.get("skillList"));

            trainingTransactionForm.setEmployeeName(empDtl.get("name").toString());
            // --- .setDepartmentName(empDetails.getDepartment().getDepartmentName());
            // --- trainingTransactionForm.setDepartmentName("Test");
            // --- trainingTransactionForm.setDepartmentName(empDetails.getEmployeejobpojo().getDepartmentPojoId().getDepartmentName());

            trainingTransactionForm.setDepartmentName(empDetails.getDepartmentId().toString());

            trainingTransactionForm.setEmployeeId(Integer.toString(empId));
            trainingTransactionForm.setJobType(jobType.getJobName());
            // --            
            if (request.getParameter("requestId") != null && request.getParameter("requestId").trim().length() > 0) {

                trainingTransation.setRequestId(Integer.parseInt(request.getParameter("requestId")));
                trainingTransation = trainingTransactionDAO.getTrainingTransation(trainingTransation);
                trainingTransactionForm.setAvailableFrom(trainingDAOImpl.mySQLscreenDateFormat(trainingTransation.getFromDate()));
                trainingTransactionForm.setAvailableTo(trainingDAOImpl.mySQLscreenDateFormat(trainingTransation.getToDate()));
                trainingTransactionForm.setDdlTrainingName(Integer.toString(trainingTransation.getTrainingId()));
                trainingTransactionForm.setStatus(trainingTransation.getStatus());
                trainingTransactionForm.setEmployeeId(trainingTransation.getEmployeeApplyId());
                trainingTransactionForm.setJobType(jobType.getJobName());

            } else {
                // --- Insert mode                
            }
            // === target="success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("@@@error From DAO@@@" + doe);
            log.error("critical error" + doe);
        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("@@@error From ExceptionClass@@@" + e.getMessage());
            log.error("error From ExceptionClass " + e);
        }
        target = "success";
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
    public ActionForward reqFromHOD(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        DAOFactory factory = new DAOFactory();
        TrainingTransactionDAO trainingTransactionDAO = factory.createTrainingTransactionManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        // --- List<EmpDetails>employees=null;
        List<EmployeeBean> employees = null;
        List<UserDtls> users = null;
        List<Training> trainings = null;
        Map<String, String> fildsSet;
        int deptId = 0;
        ;
        Map<String, Object> empDtl;
        Map<String, Object> jobSkills;
        JobType jobType = new JobType();
        try {
            // -- Populate employee List           
            fildsSet = TrainingUtil.getRequireParam(request);
            jobSkills = populateSkillList(fildsSet);
            deptId = Integer.parseInt(fildsSet.get("deptCode"));
            jobType = (JobType) jobSkills.get("jobTypeDtl");
            // -- employees=populateEmployeeListAgainstDepartment(trainingTransactionDAO,3);
            // --- employees=populateEmployeeListAgainstDepartment(trainingTransactionDAO,deptId);
            employees = TrainingUtil.populateEmployeeListAgainstDepartment(deptId);


            // --- users=TrainingUtil.populateFullNames(employees);
            empDtl = TrainingUtil.populateEmpName(Integer.parseInt(fildsSet.get("employeeId")));
            // -- trainingTransactionForm.setDepartmentName("sales & distribution");
            trainingTransactionForm.setDepartmentName(((EmployeeMaster) empDtl.get("employeeDetails")).getDepartmentId().toString());
            // === trainingTransactionForm.setDepartmentName("Test");            
            request.setAttribute("jobTypes", TrainingUtil.getJobTypeAgainstDeptCompanyCode(jobType));
            // --- request.setAttribute("skills", (List<Skills>)jobSkills.get("skillList"));

            // -- set employee List
            // -- request.setAttribute("employees", employees);
            request.setAttribute("employees", employees);
            // -- // -- set training List
            request.setAttribute("trainings", trainings);
            target = "success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }
        log.info("@@@ Inside reqFromEmploye display first time @@@");
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
    public ActionForward approvedFrmHOD(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        TrainingDAO trainingDAO = factory.createTrainingManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        List<Training> trainings = null;
        try {
            // --- trainings=populateTrainingList(trainingDAO);
            trainings = TrainingUtil.populateTrainingList();
            request.setAttribute("trainings", trainings);
            target = "success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        log.info("@@@ Inside approvedFrmHOD display first time @@@");
        return mapping.findForward(target);
    }

    /***
     * Open and pre populate form
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward viewApprovedFrmHOD(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TrainingDAO trainingDAO = factory.createTrainingManager();
        TrainingTransactionDAO trainingTransactionDAO = factory.createTrainingTransactionManager();
        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        SkillsDAO skillDAO = factory.createSkillsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        TrainingTransactionDetail trainingTransactionDetail = new TrainingTransactionDetail();
        TrainingTransation trainingTransaction = new TrainingTransation();
        String target = null;
        List<Training> trainings = null;
        Map<String, String> fildsSet = new HashMap<String, String>();
        Map<String, Object> jobSkills;
        int empAprovedId = 0;
        JobType jobType = new JobType();
        try {
            fildsSet = TrainingUtil.getRequireParam(request);
            jobSkills = populateSkillList(fildsSet);
            empAprovedId = Integer.parseInt(fildsSet.get("employeeId"));
            // -- Department ID come from session when user is Login
            jobType = (JobType) jobSkills.get("jobTypeDtl");
            request.setAttribute("skills", (List<Skills>) jobSkills.get("skillList"));
            request.setAttribute("jobTypes", TrainingUtil.getJobTypeAgainstDeptCompanyCode(jobType));
            // -- jobTypes
            // -- skills=populateSkillsAgainstDepartment(skillDAO,deptId);
            // -- request.setAttribute("skills", skills);

            if ((request.getParameter("requestId") != null && request.getParameter("requestId").toString().trim().length() > 0) && (request.getParameter("empId") != null && request.getParameter("empId").toString().trim().length() > 0) && (request.getParameter("empName") != null && request.getParameter("empName").toString().trim().length() > 0)) {

                // -- update mode
                trainingTransaction.setRequestId(Integer.parseInt(request.getParameter("requestId").toString().trim()));
                trainingTransactionDetail = trainingTransactionDAO.getTrainingTransactionAgainst(trainingTransaction, request.getParameter("empId").toString().trim());
                // --- trainings=populateTrainingListAgainstDepartment(trainingDAO,Integer.toString(trainingTransactionDetail.getSkillId()));
                trainings = TrainingUtil.populateTrainingListAgainstDepartment(Integer.toString(trainingTransactionDetail.getSkillId()));
                log.info("@@@ Size of training  @@@" + trainings.size());
                request.setAttribute("trainings", trainings);
                trainingTransactionForm.setEmployeeId(request.getParameter("empId").toString());
                trainingTransactionForm.setEmployeeName(trainingTransactionDetail.getEmployeeName());
                trainingTransactionForm.setDepartmentName(trainingTransactionDetail.getDepartmentName()); // -- not stated in query
                trainingTransactionForm.setDdlSkillsName(Integer.toString(trainingTransactionDetail.getSkillId())); // -- target
                trainingTransactionForm.setDdlTrainingName(Integer.toString(trainingTransactionDetail.getTrainingId()));
                trainingTransactionForm.setAvailableFrom(trainingTransactionDetail.getAvailableFrom());
                trainingTransactionForm.setAvailableTo(trainingTransactionDetail.getAvailableTo());
                trainingTransactionForm.setApprovedBy(trainingTransactionDetail.getApprovedBy());
                trainingTransactionForm.setDdlDepartmentName(Integer.toString(trainingTransactionDetail.getDepartmentId())); // -- Notset in query
                log.info("@@@ applyId @@@" + trainingTransactionDetail.getApplyId());
                trainingTransactionForm.setEmployeeId(trainingTransactionDetail.getApplyId());
                trainingTransactionForm.setRequestId(Integer.parseInt(request.getParameter("requestId").toString().trim()));
                trainingTransactionForm.setJobType(jobType.getTypeId().toString());
                trainingTransactionForm.setTrainingEmployeeId(Integer.toString(trainingTransactionDetail.getTrainingEmployeeId()));
                trainingTransactionForm.setApprovedBy(empAprovedId);
                //trainingTransactionForm.setApprovedBy(trainingTransactionDetail.getApprovedBy());

            } else {
                // -- Insert mode
            }
            target = "success";
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        log.info("@@@ Inside approvedFrmHOD display first time @@@");
        return mapping.findForward(target);
    }

    /***
     * Open and pre populate form
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward viewApprovedFromHR(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TrainingDAO trainingDAO = factory.createTrainingManager();
        TrainingTransactionDAO trainingTransactionDAO = factory.createTrainingTransactionManager();
        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        TrainingTransactionDetail trainingTransactionDetail = new TrainingTransactionDetail();
        TrainingTransation trainingTransaction = new TrainingTransation();
        String target = null;
        List<Training> trainings = null;
        Map<String, String> fildsSet = null;
        Map<String, Object> jobSkills;
        JobType jobType = new JobType();
        int approvedBy = 0;

        try {
            fildsSet = TrainingUtil.getRequireParam(request);
            jobSkills = populateSkillList(fildsSet);
            jobType = (JobType) jobSkills.get("jobTypeDtl");
            approvedBy = Integer.parseInt(fildsSet.get("employeeId"));

            if ((request.getParameter("requestId") != null && request.getParameter("requestId").toString().trim().length() > 0) && (request.getParameter("empId") != null && request.getParameter("empId").toString().trim().length() > 0) && (request.getParameter("empName") != null && request.getParameter("empName").toString().trim().length() > 0)) {
                log.info("@@@@ Inside if block @@@");
                trainingTransaction.setRequestId(Integer.parseInt(request.getParameter("requestId").toString().trim()));
                trainingTransactionDetail = trainingTransactionDAO.getTrainingTransactionAgainst(trainingTransaction, request.getParameter("empId").toString().trim());

                // --- trainings=populateTrainingListAgainstDepartment(trainingDAO,Integer.toString(trainingTransactionDetail.getSkillId()));
                trainings = TrainingUtil.populateTrainingListAgainstDepartment(Integer.toString(trainingTransactionDetail.getSkillId()));
                log.info("@@@ Size of training  @@@" + trainings.size());
                request.setAttribute("trainings", trainings);
                // === trainingTransactionForm.setJobType(jobType.getJobName());
                // === The jobtype should be the name of the JOB assign to training request employee
                trainingTransactionForm.setJobType(trainingTransactionDetail.getJobType());
                trainingTransactionForm.setEmployeeName(trainingTransactionDetail.getEmployeeName());
                trainingTransactionForm.setDepartmentName(trainingTransactionDetail.getDepartmentName()); // -- not stated in query
                trainingTransactionForm.setDdlSkillsName(Integer.toString(trainingTransactionDetail.getSkillId())); // -- target
                trainingTransactionForm.setDdlTrainingName(Integer.toString(trainingTransactionDetail.getTrainingId()));
                trainingTransactionForm.setAvailableFrom(trainingTransactionDetail.getAvailableFrom());
                trainingTransactionForm.setAvailableTo(trainingTransactionDetail.getAvailableTo());
                trainingTransactionForm.setApprovedBy(trainingTransactionDetail.getApprovedBy());
                trainingTransactionForm.setDdlDepartmentName(Integer.toString(trainingTransactionDetail.getDepartmentId())); // -- Notset in query
                log.info("### Type of apply ID ###" + trainingTransactionDetail.getApplyId());
                trainingTransactionForm.setEmployeeId(trainingTransactionDetail.getApplyId());
                trainingTransactionForm.setRequestId(Integer.parseInt(request.getParameter("requestId").toString().trim()));
                trainingTransactionForm.setTrainingName(trainingTransactionDetail.getTrainingName());
                trainingTransactionForm.setSkillName(trainingTransactionDetail.getSkillName());
                // --- The value is pick up from session this value is set as login Id
                trainingTransactionForm.setApprovedBy(approvedBy);
            } else {
                // -- Insert mode
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
        log.info("@@@ Inside approvedFrmHOD display first time @@@");
        return mapping.findForward(target);
    }

    /***
     * Populate trainingList
     * against AjaxCall
     * at the time of
     * Ajax population
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward trainingList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TrainingDAO trainingDAO = factory.createTrainingManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        List<Training> traingList = null;

        try {
            if (request.getParameter("skillId") != null && request.getParameter("skillId").trim().length() > 0) {
                // --- traingList=populateTrainingListAgainstDepartment(trainingDAO,request.getParameter("skillId"));
                traingList = TrainingUtil.populateTrainingListAgainstDepartment(request.getParameter("skillId"));
                request.setAttribute("trainingList", traingList);
                log.info("@@@ The size of the training @@@" + traingList.size());
                target = "success";
            }

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
     * populate training transaction list
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward trainingTransactionList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TrainingTransactionDAO trainingTran = factory.createTrainingTransactionManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        TrainingTransation trainingTransaction = new TrainingTransation();
        List<TrainingTransactionDetail> traingList = null;

        // -- check if status is presentor not
        if (request.getParameter("status") != null && request.getParameter("status").toString().trim().length() > 0) {

            log.info("@@@ Status in struts @@@" + request.getParameter("status").toString());
            trainingTransaction.setStatus(request.getParameter("status").toString());

            if (request.getParameter("status").equalsIgnoreCase("ereq")) {
                traingList = trainingTran.getTrainingTransactionAgainstFlg(trainingTransaction);
                request.setAttribute("trainingTransactions", traingList);
                target = "transactionReport";
            } else if (request.getParameter("status").equalsIgnoreCase("hodapprove")) {
                traingList = trainingTran.getTrainingTransactionAgainstFlg(trainingTransaction);
                request.setAttribute("trainingTransactions", traingList);
                target = "transactionReportHR";
            } else if (request.getParameter("status").equalsIgnoreCase("hodreq")) {
                traingList = trainingTran.getTrainingTransactionAgainstFlg(trainingTransaction);
                request.setAttribute("trainingTransactions", traingList);
                target = "transactionReportHOD";
            } else if (request.getParameter("status").equalsIgnoreCase("hrapprove")) {
                traingList = trainingTran.getTrainingTransactionAgainstFlg(trainingTransaction);
                request.setAttribute("trainingTransactions", traingList);
                target = "transactionReportAppHR";
            }
        }
        return mapping.findForward(target);
    }

    /***
     * Add for open popup
     * for show employee details
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward employeePopup(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        // --- EmployeeDAO employeeDAO=factory.createEmployeeManager();
        EmployeeMasterDAO employeeDAO = factory.createEmployeeMasterManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        // --- EmpDetails employeeDetails=null;
        // === EmployeeMaster employeeDetails=null;
        TrainingEmpInfo employeeDetails = null;
        // --- List<EmpDetails> employees=new ArrayList<EmpDetails>();
        // === List<EmployeeMaster> employees=new ArrayList<EmployeeMaster>();
        List<TrainingEmpInfo> employees = new ArrayList<TrainingEmpInfo>();
        String target = null;

        try {
            if (request.getParameter("empId") != null && request.getParameter("empId").toString().trim().length() > 0) {
                // --- Populate training details against employeeId
                log.info("@@@ employee ID @@@" + request.getParameter("empId").toString());
                employeeDetails = TrainingUtil.populateEmployeeDetail(Integer.parseInt(request.getParameter("empId").toString()));
                //// ------------------
                employeeDetails.setExp(TrainingUtil.getExp(employeeDetails));


                employees.add(employeeDetails);
                request.setAttribute("employees", employees);
                target = "success";
            }
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
     * Add for open popup
     * for show training details
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward trtainingPopup(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TrainingDAO trainingDAO = factory.createTrainingManager();
        TrainingTransactionDAO trainingTransactionDAO = factory.createTrainingTransactionManager();
        TrainingDetail trainingDetail = null;
        List<TrainingDetail> trainingList = new ArrayList<TrainingDetail>();
        // --- List<EmpDetails> empDetails=null;
        // === List<EmployeeMaster> empDetails=null;
        List<TrainingEmpInfo> empDetails = null;
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        if ((request.getParameter("empId") != null && request.getParameter("empId").toString().trim().length() > 0) && (request.getParameter("trainingId") != null && request.getParameter("trainingId").toString().trim().length() > 0)) {
            log.info("@@@ Employee Id" + request.getParameter("empId").toString());
            log.info("@@@ Training Id" + request.getParameter("trainingId").toString());
            trainingDetail = trainingDAO.getTrainingDtl(Integer.parseInt(request.getParameter("trainingId").toString()));
            empDetails = trainingTransactionDAO.getEmployeesDtlInTraining(request.getParameter("empId").toString());
            trainingList.add(trainingDetail);
            request.setAttribute("training", trainingList);


            for (Iterator it = empDetails.iterator(); it.hasNext();) {
                TrainingEmpInfo employee = (TrainingEmpInfo) it.next();
                employee.setExp(TrainingUtil.getExp(employee));
            }

            request.setAttribute("employees", empDetails);
            target = "success";
        }
        return mapping.findForward(target);
    }

    /***
     * Approve Induction Training
     * Access by all employee
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward approveInTraining(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        DAOFactory factory = new DAOFactory();
        TrainingEmployeeTransactionDAO trainingTransactionDAO = factory.createTrainingEmployeeTransactionManager();
        TrainingRequestEmployee requestEmployee = new TrainingRequestEmployee();
        requestEmployee.setEmployeeId(new BigDecimal(trainingTransactionForm.getEmployeeId()));
        requestEmployee.setFlag("INTRINIA");
        requestEmployee.setCount(new BigDecimal(0));
        requestEmployee.setRequestId(new BigDecimal(trainingTransactionForm.getRequestId()));
        requestEmployee.setTrainingRequestId(new BigDecimal(trainingTransactionForm.getTrainingEmployeeId()));
        log.info("@@@ Inside approve Induction Training @@@");
        trainingTransactionDAO.addUpdateValue(requestEmployee);
        target = "approve";
        return mapping.findForward(target);
    }

    /***
     * Disapprove Induction Training
     * Access by all employee
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward disApproveInTraining(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        DAOFactory factory = new DAOFactory();
        TrainingEmployeeTransactionDAO trainingTransactionDAO = factory.createTrainingEmployeeTransactionManager();
        TrainingRequestEmployee requestEmployee = new TrainingRequestEmployee();
        requestEmployee.setEmployeeId(new BigDecimal(trainingTransactionForm.getEmployeeId()));
        requestEmployee.setFlag("");
        requestEmployee.setCount(new BigDecimal(trainingTransactionForm.getCount() + 1));// == count the number of rejection
        requestEmployee.setRequestId(new BigDecimal(trainingTransactionForm.getRequestId()));
        requestEmployee.setTrainingRequestId(new BigDecimal(trainingTransactionForm.getTrainingEmployeeId()));
        log.info("@@@ Inside disapprove Induction Training @@@");
        trainingTransactionDAO.addUpdateValue(requestEmployee);
        target = "disapprove";
        return mapping.findForward(target);
    }

    /***
     * Induction Training request
     * Access by HR
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward addInTraining(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = null;
        ActionMessages messages = new ActionMessages();
        TrainingTransactionForm trainingTransactionForm = (TrainingTransactionForm) form;
        DAOFactory factory = new DAOFactory();
        TrainingTransactionDAO trainingTransactionDAO = factory.createTrainingTransactionManager();
        int impApprovedId = 0;
        TrainingTransation trainingTransation = new TrainingTransation();
        List<TrainingRequestEmployee> trainingRequestEmployeeList = new ArrayList<TrainingRequestEmployee>();
        Map<String, String> fildsSet = new HashMap<String, String>();
        try {
            fildsSet = TrainingUtil.getRequireParam(request);
            impApprovedId = Integer.parseInt(fildsSet.get("employeeId"));
            String[] employeesArr = trainingTransactionForm.getDdlEmployees();
            TrainingDAOImpl trainingDAOImpl = new TrainingDAOImpl();
            //int arLength=employeesArr.length-1;
            // -- StringBuffer empAll=new StringBuffer();
            log.info("@@@ Length of array @@@" + employeesArr.length);
            for (int count = 0; count < employeesArr.length; count++) {
                TrainingRequestEmployee trainingRequestEmployee = new TrainingRequestEmployee();
                log.info("@@@ Employee Id @@@" + employeesArr[count]);

                trainingRequestEmployee.setEmployeeId(new BigDecimal(employeesArr[count]));
                // === The flag is add to training request employee
                // === The flag value set to initialize the induction training
                trainingRequestEmployee.setFlag("INTRINI");

                trainingRequestEmployeeList.add(trainingRequestEmployee);

            }
            trainingTransation.setTrainingRequestEmployee(trainingRequestEmployeeList);
            trainingTransation.setEmployeeApproveId(impApprovedId);
            // -- set value as hod request flag as hodreq

            // === The flag is add to training request master
            // === The status value set to initialize the induction training
            trainingTransation.setStatus("hodreqINI");
            trainingTransation.setFromDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableFrom()));
            trainingTransation.setToDate(trainingDAOImpl.mySqlDatebFormat(trainingTransactionForm.getAvailableTo()));

            if (trainingTransactionForm.getRequestId() != 0) {
                // --- Update mode
                trainingTransation.setRequestId(trainingTransactionForm.getRequestId());
                trainingTransactionDAO.updateTrainingTransation(trainingTransation);

            } else {
                // --- Insert mode
                trainingTransactionDAO.insertTrainingTransation(trainingTransation);
            }

            /***
             * Populate employee list
             */
            request.setAttribute("employees", TrainingUtil.populateEmpForInduction());

            /***
             * Populate employee list
             */
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
            saveMessages(request, messages);
            target = "addRequest";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.info("@@@error From DAO@@@" + doe);
            log.error("critical error" + doe);
        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.info("@@@error From ExceptionClass@@@" + e.getMessage());
            log.error("error From ExceptionClass " + e);
        }
        log.info("@@@ Inside Training  Request from HOD @@@");

        return mapping.findForward(target);
    }

    /***
     * Populate employee fields
     * In view mode
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward viewInTraining(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        log.info("@@@ Inside Training  Request from HOD @@@");
        String target = "";
        try {
            request.setAttribute("employees", TrainingUtil.populateEmpForInduction());
            target = "addRequest";
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
     * View Induction
     * Training Employee
     * @param mapping
     * @param form
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    public ActionForward viewInTrainingEmployee(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        log.info("@@@ Inside Training  Request from Employee @@@");
        TrainingTransactionForm tranForm = (TrainingTransactionForm) form;
        Map<String, String> fildsSet = new HashMap<String, String>();
        TrainingRequestEmployee requestEmployee = new TrainingRequestEmployee();

        try {

            fildsSet = TrainingUtil.getRequireParam(request);
            requestEmployee.setEmployeeId(new BigDecimal(fildsSet.get("employeeId")));
            log.info("@@@ Before calling DAO @@@");
            requestEmployee = TrainingUtil.selectEmployeeAgainstInduction(requestEmployee);
            log.info("@@@ Request Id @@@" + requestEmployee.getRequestId());
            if (requestEmployee.getRequestId() == BigDecimal.ZERO) {
                // === View a message "Training not initialized"
                log.info("@@@ Inside Message Shown option @@@");
                // ===tranForm.setMsg("Induction Training is Not initialize or allready done");
                request.setAttribute("msg", "Induction Training is Not initialize or allready done");
            } else {
                tranForm.setEmployeeId(fildsSet.get("employeeId").toString());
                tranForm.setRequestId(requestEmployee.getRequestId().intValue());
                tranForm.setTrainingEmployeeId(Integer.toString(requestEmployee.getTrainingRequestId().intValue()));
                tranForm.setCount(requestEmployee.getCount().intValue());
            }
        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        String target = "addResponse";

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
     * Populate Skills against
     * companycode ,
     * departmentID ,
     * TypeId
     * @param fildsSet
     * @return
     * @throws DAOException
     * @throws Exception
     */
    private Map<String, Object> populateSkillList(Map<String, String> fildsSet) throws DAOException, Exception {
        Map<String, Object> returnVal = new HashMap<String, Object>();
        JobType jobType = new JobType();

        if (fildsSet.get("deptCode") != null && fildsSet.get("deptCode").toString().length() > 0) {
            log.info("@@@ Dept Code @@@" + fildsSet.get("deptCode"));
            jobType.setId(Integer.parseInt(fildsSet.get("deptCode")));
        }
        if (fildsSet.get("companyCode") != null && fildsSet.get("companyCode").toString().length() > 0) {
            log.info("@@@ Company Code @@@" + fildsSet.get("companyCode"));
            jobType.setCompanyCode(Integer.parseInt(fildsSet.get("companyCode")));
        }
        if (fildsSet.get("typeId") != null && fildsSet.get("typeId").toString().length() > 0) {
            log.info("@@@ Type Id @@@" + fildsSet.get("typeId"));
            jobType.setTypeId(new BigDecimal(fildsSet.get("typeId")));
            jobType = TrainingUtil.getOneJobTypeAgainstDeptCompanyCode(jobType);
            returnVal.put("skillList", TrainingUtil.populateSkillsAgainstJobType(jobType.getTypeId().intValue()));
            returnVal.put("jobTypeDtl", jobType);

        } else {
            returnVal.put("skillList", null);
            returnVal.put("jobTypeDtl", jobType);
        }

        return returnVal;
    }
}
