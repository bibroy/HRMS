/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.ImplClass.EmployeeMasterDAOImpl;
import com.util.Oraganization;
import com.ImplClass.SkillsDAOImpl;
import com.dao.DAOException;
import com.dao.DAOFactory;

import com.dao.EmployeeCertificationDAO;
import com.dao.EmployeeConfirmationDAO;
import com.dao.EmployeeEducationDetailsDAO;
import com.dao.EmployeeFamilyDetailsDAO;
import com.dao.EmployeeMasterDAO;
import com.dao.EmployeeSkillDAO;
import com.pojo.DesignationMaster;
import com.dao.LoginDAO;
import com.dao.PreviousEmployerDetailsDAO;
import com.dao.ProfReferenceDetailsDAO;
import com.dao.SkillsDAO;
import com.dao.VisaPassortDetailsDAO;
import com.forms.EmployeePersonalInfoForm;
import com.pojo.Department;
import com.dao.DepartmentDAO;
import com.forms.DepartmentForm;
import com.pojo.EmployeeCertification;
import com.pojo.EmployeeConfirmation;
import com.pojo.EmployeeEducationDetails;
import com.pojo.EmployeeFamilyDetails;
import com.pojo.EmployeeMaster;
import com.pojo.EmployeeSkill;
import com.pojo.Login;
import com.pojo.PreviousEmployerDetails;
import com.pojo.Skills;
import com.pojo.VisaPassortDetails;
import com.util.UtilityClass;
import java.util.Iterator;
import com.dao.BaseDAO;
import com.dao.BranchDAO;
import com.pojo.BranchMaster;
import com.dao.EmployeeJobHistoryDAO;
import com.pojo.EmployeeJobHistory;
import com.util.EmployeeDesignation;
import com.pojo.CountryMaster;

import com.util.EmployeeRunawayReport;

import com.dao.CountryDAO;
import com.dao.StateDAO;
import com.dao.CityDAO;


import com.pojo.City;
import com.pojo.State;
import com.dao.GradeMasterDAO;
import com.pojo.GradeMaster;

import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.actions.DispatchAction;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.math.BigDecimal;

import com.dao.DesignationDAO;
import com.dao.JobTypeDAO;
import com.util.ImageUtil;
import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.pojo.RoleMaster;
import java.util.List;
import com.dao.RoleMasterDAO;
import com.forms.EmployeeExitDetailsForm;
import com.pojo.JobType;
import java.io.InputStream;
import java.util.HashMap;
import javax.servlet.ServletOutputStream;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Sumit Kumar
 */
public class EmployeePersonalInfoAction extends DispatchAction {

    /* forward name="success" path="" */
    String target = null;

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward LoadEmployeePersonalInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("LoadEmployeePersonalInfo method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();


        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        if (sessionUID != null) {

            try {

                EmployeeMaster employeeMasterPojo = daoEmpMaster.getEmployeeMasterByEmpId(sessionUID);
                empPersonalInfoForm.setBrId(employeeMasterPojo.getBranchId().intValue());

                target = "success";

                System.out.print("*************************Action  Load LoadEmployeePersonalInfo*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);

            }

        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }

        return mapping.findForward(target);
    }

    public ActionForward LoadEmployeePersonalInfoEdit(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("LoadEmployeePersonalInfoEdit method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;
        UtilityClass utilityClass = new UtilityClass();
        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();
        CountryDAO daoCountry = factory.createCountryManager();

        CityDAO daoCity = factory.createCityManager();
        StateDAO daoState = factory.createStateManager();
        EmployeeFamilyDetailsDAO daoEmpFamDetails = factory.createEmployeeFamilyDetailsManager();


        ProfReferenceDetailsDAO daoEmpProfRefDetails = factory.createProfReferenceDetailsManager();
        VisaPassortDetailsDAO daoEmpVisaPass = factory.createVisaPassportDetailsManager();
        EmployeeEducationDetailsDAO daoEmpEducatinDetails = factory.createEmployeeEducationDetailsManager();
        EmployeeCertificationDAO daoEmployeeCertification = factory.createEmployeeCertificationManager();
        EmployeeSkillDAO daoEmployeeSkill = factory.createEmployeeSkillManager();
        PreviousEmployerDetailsDAO daoPreviousEmployerDetails = factory.createPreviousEmployerDetailsManager();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        List<EmployeeFamilyDetails> empFamDetailsList = null;

        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        if (sessionUID != null) {

            try {

                List<CountryMaster> countryList = null;
                countryList = daoCountry.getAllCountry();
                if (countryList.size() != 0) {
                    request.setAttribute("CountryList", countryList);

                }

                EmployeeMaster employeeMasterPojo = daoEmpMaster.getEmployeeMasterByEmpId(sessionUID);

                empPersonalInfoForm.setEmpMasterid(employeeMasterPojo.getId().intValue());
                empPersonalInfoForm.setFirstName(employeeMasterPojo.getFirstName());
                empPersonalInfoForm.setMiddleName(employeeMasterPojo.getMiddleName());
                empPersonalInfoForm.setLastName(employeeMasterPojo.getLastName());

                if (employeeMasterPojo.getDateOfBirth() != null) {
                    empPersonalInfoForm.setDateOfBirth(utilityClass.OraclescreenDateFormatToScreen(baseDAO.OraclescreenDateFormat(employeeMasterPojo.getDateOfBirth())));
                }
                empPersonalInfoForm.setBrId(employeeMasterPojo.getBranchId().intValue());


                empPersonalInfoForm.setLanguageKnown(employeeMasterPojo.getLanguageKnown());
                empPersonalInfoForm.setLanguageProficiency(employeeMasterPojo.getLanguageProficiency());

                //////Create Family Member List

                empFamDetailsList = daoEmpFamDetails.getEmployeeFamilyDetailsByEmpId(sessionUID);

                if (empFamDetailsList.size() != 0) {
                    request.setAttribute("familyDetailsList", empFamDetailsList);

                }
///   load visa passport details---------------------

                VisaPassortDetails visaPassortDetails = daoEmpVisaPass.getVisaPassortDetailsByEmpId(sessionUID);
                empPersonalInfoForm.setVisaPassportId(visaPassortDetails.getId().intValue());
                empPersonalInfoForm.setVisaNo(visaPassortDetails.getVisaNo());
                empPersonalInfoForm.setVisaType(visaPassortDetails.getVisaType());

                if (visaPassortDetails.getVisaIssueDate() != null) {

                    empPersonalInfoForm.setVisaIssueDate(utilityClass.OraclescreenDateFormatToScreen(baseDAO.OraclescreenDateFormat(visaPassortDetails.getVisaIssueDate())));

                }
                empPersonalInfoForm.setVisaIssuedBy(visaPassortDetails.getVisaIssuedBy());

                if (visaPassortDetails.getVisaValidUpto() != null) {

                    empPersonalInfoForm.setVisaValidUpto(utilityClass.OraclescreenDateFormatToScreen(baseDAO.OraclescreenDateFormat(visaPassortDetails.getVisaValidUpto())));

                }
                empPersonalInfoForm.setPassportNo(visaPassortDetails.getPassportNo());

                empPersonalInfoForm.setPassportIssuedBy(visaPassortDetails.getPassportIssuedBy());

                if (visaPassortDetails.getPassportIssueDate() != null) {

                    empPersonalInfoForm.setPassportIssueDate(utilityClass.OraclescreenDateFormatToScreen(baseDAO.OraclescreenDateFormat(visaPassortDetails.getPassportIssueDate())));

                }

                if (visaPassortDetails.getPassportValidUpto() != null) {

                    empPersonalInfoForm.setPassportValidUpto(utilityClass.OraclescreenDateFormatToScreen(baseDAO.OraclescreenDateFormat(visaPassortDetails.getPassportValidUpto())));

                }

                ///---Load contact Deatils.........................
                empPersonalInfoForm.setPermanentAddress(employeeMasterPojo.getPermanentAddress());
                empPersonalInfoForm.setPermanentCountry(employeeMasterPojo.getPermanentCountry().intValue());
                empPersonalInfoForm.setPermanentCity(employeeMasterPojo.getPermanentCity().intValue());
                empPersonalInfoForm.setPermanentState(employeeMasterPojo.getPermanentState().intValue());
                empPersonalInfoForm.setPermanentAddressPin(employeeMasterPojo.getPermanentAddressPin().intValue());

                empPersonalInfoForm.setPresentAddress(employeeMasterPojo.getPresentAddress());
                empPersonalInfoForm.setPresentCountry(employeeMasterPojo.getPresentCountry().intValue());
                empPersonalInfoForm.setPresentCity(employeeMasterPojo.getPresentCity().intValue());
                empPersonalInfoForm.setPresentState(employeeMasterPojo.getPresentState().intValue());
                empPersonalInfoForm.setPresentAddressPin(employeeMasterPojo.getPresentAddressPin().intValue());

                empPersonalInfoForm.setEmailAddress(employeeMasterPojo.getEmailAddress());
                empPersonalInfoForm.setPhNoResidencial(employeeMasterPojo.getPhNoResidencial());
                empPersonalInfoForm.setPhNoOffice(employeeMasterPojo.getPhNoOffice());
                empPersonalInfoForm.setMobileNo(employeeMasterPojo.getMobileNo());
                ///---Load Emergency contact Deatils.........................
                empPersonalInfoForm.setEmergencyContactPerson(employeeMasterPojo.getEmergencyContactPerson());
                empPersonalInfoForm.setEmergencyContactAddress(employeeMasterPojo.getEmergencyContactAddress());
                empPersonalInfoForm.setEmergencyContactNoPrimary(employeeMasterPojo.getEmergencyContactNoPrimary());
                empPersonalInfoForm.setEmergencyContactNoSecondary(employeeMasterPojo.getEmergencyContactNoSecondary());
                empPersonalInfoForm.setEmergencyContactRelationship(employeeMasterPojo.getEmergencyContactRelationship());


////retrieving state for communication address state////
                List<State> stateListCom = null;

                stateListCom = daoState.getAllStateByCountryCode(empPersonalInfoForm.getPresentCountry());
                request.setAttribute("stateListCom", stateListCom);

///end--------------------------

////retrieving City for communication address state////
                List<City> cityListCom = null;

                cityListCom = daoCity.getAllCityByStateCode(empPersonalInfoForm.getPresentState());
                request.setAttribute("cityListCom", cityListCom);

                ///end--------------------------

                ////retrieving state for communication address state////
                List<State> stateListPer = null;


                stateListPer = daoState.getAllStateByCountryCode(empPersonalInfoForm.getPermanentCountry());
                request.setAttribute("stateListPer", stateListPer);

///end--------------------------

////retrieving City for communication address state////
                List<City> cityListPer = null;

                cityListPer = daoCity.getAllCityByStateCode(empPersonalInfoForm.getPermanentState());
                request.setAttribute("cityListPer", cityListPer);

                ///end--------------------------

                ///---Load Employee Education Deatils.........................
                List<EmployeeEducationDetails> employeeEducationDetailsList = daoEmpEducatinDetails.getEmployeeEducationDetailsByEmpId(sessionUID);
                if (employeeEducationDetailsList.size() != 0) {
                    request.setAttribute("employeeEducationDetailsList", employeeEducationDetailsList);

                }

                ///---Load Employee Certification Deatils.........................

                List<EmployeeCertification> employeeCertificationList = daoEmployeeCertification.getEmployeeCertificationByEmpId(sessionUID);
                if (employeeCertificationList.size() != 0) {
                    request.setAttribute("employeeCertificateDetailsList", employeeCertificationList);

                }


//--Load Employee Skill Deatils.........................

                List<EmployeeSkill> employeeSkillList = daoEmployeeSkill.getEmployeeSkillByEmpId(sessionUID);
                if (employeeSkillList.size() != 0) {
                    request.setAttribute("employeeSkillList", employeeSkillList);

                }

//----Load Previous Employer Details...................
                List<PreviousEmployerDetails> previousEmployerDetailsList = daoPreviousEmployerDetails.getPreviousEmployerDetailsByEmpId(sessionUID);
                if (previousEmployerDetailsList.size() != 0) {
                    request.setAttribute("previousEmployerDetailsList", previousEmployerDetailsList);

                }

                target = "success";
                System.out.print("*************************Action  Load LoadEmployeePersonalInfo*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);

            }

        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }

        return mapping.findForward(target);
    }

    public ActionForward loadState(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("loadState method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        DAOFactory factory = new DAOFactory();
        StateDAO daoState = factory.createStateManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        List<State> stateList = null;

        System.out.print("*************************Action State************" + empPersonalInfoForm.getPermanentCountry() + "*****************");

        try {

            State statePojo = new State();

            stateList = daoState.getAllStateByCountryCode(empPersonalInfoForm.getPermanentCountry());
            request.setAttribute("stateList", stateList);
            request.setAttribute("position", empPersonalInfoForm.getPosition());
            target = "success";

            System.out.print("*************************Action State-----" + stateList + "*****************************");

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }

//System.out.print("************************"+target+"****************************");
        return mapping.findForward(target);
    }

    public ActionForward loadCity(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        System.out.print("loadCity method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        DAOFactory factory = new DAOFactory();
        CityDAO daoCity = factory.createCityManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        List<City> cityList = null;

        System.out.print("*************************Action State************" + empPersonalInfoForm.getPermanentState() + "*****************");

        try {
            City cityPojo = new City();

            cityList = daoCity.getAllCityByStateCode(empPersonalInfoForm.getPermanentState());
            request.setAttribute("cityList", cityList);
            request.setAttribute("position", empPersonalInfoForm.getPosition());
            target = "success";

            System.out.print("*************************Action State-----" + cityList + "*****************************");

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }

//System.out.print("************************"+target+"****************************");
        return mapping.findForward(target);
    }

    public ActionForward addEmployeePersonalInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("addEmployeePersonalInfo method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();
        EmployeeConfirmationDAO daoEmpConf = factory.createEmployeeConfirmationManager();

        ProfReferenceDetailsDAO daoEmpProfRefDetails = factory.createProfReferenceDetailsManager();
        VisaPassortDetailsDAO daoEmpVisaPass = factory.createVisaPassportDetailsManager();
        EmployeeMasterDAOImpl empl = new EmployeeMasterDAOImpl();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        if (sessionUID != null) {

            try {
                EmployeeMaster employeeMasterPojo = new EmployeeMaster();
                employeeMasterPojo.setId(empl.getLastRequestId().add(BigDecimal.ONE));
                employeeMasterPojo.setFirstName(empPersonalInfoForm.getFirstName());
                employeeMasterPojo.setMiddleName(empPersonalInfoForm.getMiddleName());
                employeeMasterPojo.setLastName(empPersonalInfoForm.getLastName());
                employeeMasterPojo.setBloodGroup(empPersonalInfoForm.getBloodGroup());
                employeeMasterPojo.setGender(empPersonalInfoForm.getGender());
                employeeMasterPojo.setDateOfBirth(baseDAO.mySqlDatebFormat(empPersonalInfoForm.getDateOfBirth()));
                employeeMasterPojo.setDesignationId(empPersonalInfoForm.getDesignation_id());
                employeeMasterPojo.setDepartmentId(new BigDecimal(empPersonalInfoForm.getDeptId().intValue()));
                employeeMasterPojo.setDomainId(new BigDecimal(empPersonalInfoForm.getDomainId().intValue()));
                employeeMasterPojo.setBranchId(new BigDecimal(empPersonalInfoForm.getBrId()));
                employeeMasterPojo.setDateOfJoin(baseDAO.mySqlDatebFormat(empPersonalInfoForm.getDateOfJoin()));

                employeeMasterPojo.setEntryDate(new java.util.Date());
                employeeMasterPojo.setModifiedDate(null);
                employeeMasterPojo.setEntryBy(sessionUID);
                employeeMasterPojo.setModifiedBy("");
                employeeMasterPojo.setStatus("Y");

//---------------------Add employee Insert Start----------------------------

                boolean ins;

                //    employeeMasterPojo = daoEmpMaster.getEmployeeMaster(employeeMasterPojo.getId().intValue());
                employeeMasterPojo.setEmployeeId(employeeMasterPojo.getFirstName() + employeeMasterPojo.getId());
                ins = (boolean) daoEmpMaster.save(employeeMasterPojo);

                //Create Login Id and Password
                LoginDAO daoLogin = factory.createLoginManager();
                Login loginPojo = new Login();
                //EncryptImpl enc = EncriptionUtilFactory.getInstance().encryptFactory(Type.Base64);
                loginPojo.setUserId(employeeMasterPojo.getEmployeeId());
                loginPojo.setPassword(employeeMasterPojo.getEmployeeId());
                ins = (boolean) daoLogin.save(loginPojo);

                //---------------------Add employee conformation Insert Start----------------------------

                System.out.print("**********EmployeeId*********" + employeeMasterPojo.getEmployeeId() + "---------------");
                EmployeeConfirmation empConfPojo = new EmployeeConfirmation();
                empConfPojo.setConfDueDate(baseDAO.mySqlDatebFormat(empPersonalInfoForm.getConfDueDate()));
                empConfPojo.setEffectiveFrom(baseDAO.mySqlDatebFormat(empPersonalInfoForm.getDateOfEffective()));

                empConfPojo.setStatus('P');
                empConfPojo.setEmployeeId(employeeMasterPojo.getEmployeeId());
                empConfPojo.setId(new com.ImplClass.EmployeeConfirmationDAOImpl().getLastRequestId().add(BigDecimal.ONE));
                ins = (boolean) daoEmpConf.save(empConfPojo);


                //---------------------Add employee ProfReference    Details Insert Start----------------------------

                /*
                ProfReferenceDetails profReferenceDetailsPojo = new ProfReferenceDetails();
                profReferenceDetailsPojo.setEmployeeId(employeeMasterPojo.getEmployeeId());
                ins = (boolean) daoEmpProfRefDetails.save(profReferenceDetailsPojo);
                 *
                 */
                //---------------------Add employee VisaPassort  Details Insert Start----------------------------
             /*
                VisaPassortDetails visaPassortDetailsPojo = new VisaPassortDetails();
                visaPassortDetailsPojo.setEmployeeId(employeeMasterPojo.getEmployeeId());
                ins = (boolean) daoEmpVisaPass.save(visaPassortDetailsPojo);

                 *
                 */

                if (ins == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }


                System.out.print("*************************Action  addGrade*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);

            }

        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }


        return mapping.findForward(target);
    }

    public ActionForward editEmployeePersonalInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("EditEmployeePersonalInfo method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();
        EmployeeConfirmationDAO daoEmpConf = factory.createEmployeeConfirmationManager();

        ProfReferenceDetailsDAO daoEmpProfRefDetails = factory.createProfReferenceDetailsManager();
        VisaPassortDetailsDAO daoEmpVisaPass = factory.createVisaPassportDetailsManager();


        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");


        if (sessionUID != null) {

            try {
                //---------------------Edit employee  Start----------------------------
                EmployeeMaster employeeMasterPojo = daoEmpMaster.getEmployeeMaster(empPersonalInfoForm.getEmpMasterid());

                employeeMasterPojo.setFirstName(empPersonalInfoForm.getFirstName());
                employeeMasterPojo.setMiddleName(empPersonalInfoForm.getMiddleName());
                employeeMasterPojo.setLastName(empPersonalInfoForm.getLastName());
                employeeMasterPojo.setBloodGroup(empPersonalInfoForm.getBloodGroup());
                employeeMasterPojo.setGender(empPersonalInfoForm.getGender());
                employeeMasterPojo.setDateOfBirth(baseDAO.mySqlDatebFormat(empPersonalInfoForm.getDateOfBirth()));
                // employeeMasterPojo.setDesignationId(empPersonalInfoForm.getDesignation_id());
                //  employeeMasterPojo.setDepartmentId(empPersonalInfoForm.getDeptId());
                // employeeMasterPojo.setDomainId(empPersonalInfoForm.getDomainId());
                // employeeMasterPojo.setBranchId(empPersonalInfoForm.getBrId());
                //employeeMasterPojo.setDateOfJoin(baseDAO.mySqlDatebFormat(empPersonalInfoForm.getDateOfJoin()));


                employeeMasterPojo.setLanguageKnown(empPersonalInfoForm.getLanguageKnown());
                employeeMasterPojo.setLanguageProficiency(empPersonalInfoForm.getLanguageProficiency());


                ///---edit contact Deatils.........................
                employeeMasterPojo.setPermanentAddress(empPersonalInfoForm.getPermanentAddress());
                employeeMasterPojo.setPermanentCountry(new BigDecimal(empPersonalInfoForm.getPermanentCountry().intValue()));
                employeeMasterPojo.setPermanentCity(new BigDecimal(empPersonalInfoForm.getPermanentCity().intValue()));
                employeeMasterPojo.setPermanentState(new BigDecimal(empPersonalInfoForm.getPermanentState().intValue()));
                employeeMasterPojo.setPermanentAddressPin(new BigDecimal(empPersonalInfoForm.getPermanentAddressPin().intValue()));

                employeeMasterPojo.setPresentAddress(empPersonalInfoForm.getPresentAddress());
                employeeMasterPojo.setPresentCountry(new BigDecimal(empPersonalInfoForm.getPresentCountry().intValue()));
                employeeMasterPojo.setPresentCity(new BigDecimal(empPersonalInfoForm.getPresentCity().intValue()));
                employeeMasterPojo.setPresentState(new BigDecimal(empPersonalInfoForm.getPresentState()));
                employeeMasterPojo.setPresentAddressPin(new BigDecimal(empPersonalInfoForm.getPresentAddressPin()));

                employeeMasterPojo.setEmailAddress(empPersonalInfoForm.getEmailAddress());
                employeeMasterPojo.setPhNoResidencial(empPersonalInfoForm.getPhNoResidencial());
                employeeMasterPojo.setPhNoOffice(empPersonalInfoForm.getPhNoOffice());
                employeeMasterPojo.setMobileNo(empPersonalInfoForm.getMobileNo());
                ///---edit Emergency contact Deatils.........................
                employeeMasterPojo.setEmergencyContactPerson(empPersonalInfoForm.getEmergencyContactPerson());
                employeeMasterPojo.setEmergencyContactAddress(empPersonalInfoForm.getEmergencyContactAddress());
                employeeMasterPojo.setEmergencyContactNoPrimary(empPersonalInfoForm.getEmergencyContactNoPrimary());
                employeeMasterPojo.setEmergencyContactNoSecondary(empPersonalInfoForm.getEmergencyContactNoSecondary());
                employeeMasterPojo.setEmergencyContactRelationship(empPersonalInfoForm.getEmergencyContactRelationship());

                employeeMasterPojo.setModifiedDate(new java.util.Date());
                employeeMasterPojo.setModifiedBy(sessionUID);

                boolean ins = (boolean) daoEmpMaster.save(employeeMasterPojo);

                //  -----------  Edit Employee Visa Passport Details.....................
                VisaPassortDetails visaPassortDetailsPojo = daoEmpVisaPass.getVisaPassortDetails(empPersonalInfoForm.getVisaPassportId());
                System.out.print("--------visaPassortDetailsPojo-----------------" + visaPassortDetailsPojo + "******************");
                visaPassortDetailsPojo.setPassportNo(empPersonalInfoForm.getPassportNo());
                visaPassortDetailsPojo.setPassportIssuedBy(empPersonalInfoForm.getPassportIssuedBy());
                visaPassortDetailsPojo.setPassportIssueDate(baseDAO.mySqlDatebFormat(empPersonalInfoForm.getPassportIssueDate()));
                visaPassortDetailsPojo.setPassportValidUpto(baseDAO.mySqlDatebFormat(empPersonalInfoForm.getPassportValidUpto()));
                visaPassortDetailsPojo.setVisaNo(empPersonalInfoForm.getVisaNo());
                visaPassortDetailsPojo.setVisaIssuedBy(empPersonalInfoForm.getVisaIssuedBy());
                visaPassortDetailsPojo.setVisaType(empPersonalInfoForm.getVisaType());
                visaPassortDetailsPojo.setVisaIssueDate(baseDAO.mySqlDatebFormat(empPersonalInfoForm.getVisaIssueDate()));
                visaPassortDetailsPojo.setVisaValidUpto(baseDAO.mySqlDatebFormat(empPersonalInfoForm.getVisaValidUpto()));


                ins = (boolean) daoEmpVisaPass.save(visaPassortDetailsPojo);

                if (ins == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }

                System.out.print("*************************Action  addGrade*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);
            }

        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }

        return mapping.findForward(target);
    }

    public ActionForward addEmployeeFamDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("addEmployeePersonalInfo method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();
        EmployeeFamilyDetailsDAO daoEmpFamDetails = factory.createEmployeeFamilyDetailsManager();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        boolean ins = false;
        if (sessionUID != null) {

            try {

                String famMemberName[] = empPersonalInfoForm.getFamilyMemberName();
                String famMemberRelation[] = empPersonalInfoForm.getRelation();
                String DOBOfMember[] = empPersonalInfoForm.getDobOfMember();

                for (int iLoop = 0; iLoop < famMemberName.length; iLoop++) {

                    EmployeeFamilyDetails employeeFamilyDetailsPojo = new EmployeeFamilyDetails();

                    employeeFamilyDetailsPojo.setEmployeeId(sessionUID);

                    employeeFamilyDetailsPojo.setFamilyMemberName(famMemberName[iLoop]);
                    employeeFamilyDetailsPojo.setRelation(famMemberRelation[iLoop]);

                    employeeFamilyDetailsPojo.setDobOfMember(baseDAO.mySqlDatebFormat(DOBOfMember[iLoop]));
                    ins = (boolean) daoEmpFamDetails.save(employeeFamilyDetailsPojo);

                }

                empPersonalInfoForm.clear();
                if (ins == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }

                System.out.print("*************************Action  addGrade*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);

            }

        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }

        return mapping.findForward(target);
    }

    public ActionForward load_edit_delete_EmployeeFamDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("load_edit_delete_EmployeeFamDetails method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();
        EmployeeFamilyDetailsDAO daoEmpFamDetails = factory.createEmployeeFamilyDetailsManager();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        boolean ins = false;
        if (sessionUID != null) {

            try {

                if (empPersonalInfoForm.getEditDelete().equals("delete")) {

                    Integer famMemberId[] = empPersonalInfoForm.getEmpFamId();

                    for (int iLoop = 0; iLoop < famMemberId.length; iLoop++) {

                        EmployeeFamilyDetails employeeFamilyDetailsPojo = daoEmpFamDetails.getEmployeeFamilyDetails(famMemberId[iLoop]);

                        ins = daoEmpFamDetails.delete(employeeFamilyDetailsPojo);

                    }

                } else if (empPersonalInfoForm.getEditDelete().equals("edit")) {

                    Integer famMemberId[] = empPersonalInfoForm.getEmpFamId();
                    String famMemberName[] = empPersonalInfoForm.getFamilyMemberName();
                    String famMemberRelation[] = empPersonalInfoForm.getRelation();
                    String DOBOfMember[] = empPersonalInfoForm.getDobOfMember();

                    for (int iLoop = 0; iLoop < famMemberName.length; iLoop++) {

                        EmployeeFamilyDetails employeeFamilyDetailsPojo = daoEmpFamDetails.getEmployeeFamilyDetails(famMemberId[iLoop]);

                        //employeeFamilyDetailsPojo.setEmployeeId(sessionUID);

                        employeeFamilyDetailsPojo.setFamilyMemberName(famMemberName[iLoop]);
                        employeeFamilyDetailsPojo.setRelation(famMemberRelation[iLoop]);

                        employeeFamilyDetailsPojo.setDobOfMember(baseDAO.mySqlDatebFormat(DOBOfMember[iLoop]));
                        ins = (boolean) daoEmpFamDetails.save(employeeFamilyDetailsPojo);

                    }

                } else if (empPersonalInfoForm.getEditDelete().equals("load")) {

                    List<EmployeeFamilyDetails> empFamDetailsList = daoEmpFamDetails.getEmployeeFamilyDetailsByEmpId(sessionUID);
                    if (empFamDetailsList.size() != 0) {
                        request.setAttribute("familyDetailsList", empFamDetailsList);

                    }
                    ins = true;
                }

                if (ins == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }

                System.out.print("*************************Load Edit DELETE*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);
            }

        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }

        return mapping.findForward(target);
    }

    public ActionForward addEmployeeEdocationalDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("addEmployeePersonalInfo method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();

        EmployeeEducationDetailsDAO daoEmpEducatinDetails = factory.createEmployeeEducationDetailsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        boolean ins = false;
        if (sessionUID != null) {

            try {

                String examinationName[] = empPersonalInfoForm.getExaminationName();
                String yearOfStart[] = empPersonalInfoForm.getYearOfStart();
                String yearOfEnd[] = empPersonalInfoForm.getYearOfEnd();
                Integer percentage[] = empPersonalInfoForm.getPercentage();
                String boardName[] = empPersonalInfoForm.getBoardName();
                String institutionName[] = empPersonalInfoForm.getInstitutionName();
                String specialisation[] = empPersonalInfoForm.getSpecialisation();

                for (int iLoop = 0; iLoop < examinationName.length; iLoop++) {

                    EmployeeEducationDetails employeeEducationDetailsPojo = new EmployeeEducationDetails();

                    employeeEducationDetailsPojo.setEmployeeId(sessionUID);

                    employeeEducationDetailsPojo.setExaminationName(examinationName[iLoop]);
                    employeeEducationDetailsPojo.setYearOfStart(baseDAO.mySqlDatebFormat(yearOfStart[iLoop]));
                    employeeEducationDetailsPojo.setYearOfEnd(baseDAO.mySqlDatebFormat(yearOfEnd[iLoop]));

                    employeeEducationDetailsPojo.setPercentage(new BigDecimal(percentage[iLoop].intValue()));
                    employeeEducationDetailsPojo.setBoardName(boardName[iLoop]);
                    employeeEducationDetailsPojo.setInstitutionName(institutionName[iLoop]);
                    employeeEducationDetailsPojo.setExaminationName(examinationName[iLoop]);
                    employeeEducationDetailsPojo.setSpecialisation(specialisation[iLoop]);

                    ins = (boolean) daoEmpEducatinDetails.save(employeeEducationDetailsPojo);
                }

                empPersonalInfoForm.clear();
                if (ins == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }

                System.out.print("*************************Action  addGrade*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);

            }

        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }

        return mapping.findForward(target);
    }

    public ActionForward load_edit_delete_EmployeeEdocationalDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("EmployeeEdocationalDetails method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();
        EmployeeEducationDetailsDAO daoEmpEducatinDetails = factory.createEmployeeEducationDetailsManager();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        boolean ins = false;
        if (sessionUID != null) {

            try {

                if (empPersonalInfoForm.getEditDelete().equals("delete")) {

                    Integer empEduDetailsId[] = empPersonalInfoForm.getEmpEduDetailsId();

                    for (int iLoop = 0; iLoop < empEduDetailsId.length; iLoop++) {

                        EmployeeEducationDetails employeeEducationDetailsPojo = daoEmpEducatinDetails.getEmployeeEducationDetails(empEduDetailsId[iLoop]);

                        ins = daoEmpEducatinDetails.delete(employeeEducationDetailsPojo);

                    }

                } else if (empPersonalInfoForm.getEditDelete().equals("edit")) {

                    Integer empEduDetailsId[] = empPersonalInfoForm.getEmpEduDetailsId();
                    String examinationName[] = empPersonalInfoForm.getExaminationName();
                    String yearOfStart[] = empPersonalInfoForm.getYearOfStart();
                    String yearOfEnd[] = empPersonalInfoForm.getYearOfEnd();
                    Integer percentage[] = empPersonalInfoForm.getPercentage();
                    String boardName[] = empPersonalInfoForm.getBoardName();
                    String institutionName[] = empPersonalInfoForm.getInstitutionName();
                    String specialisation[] = empPersonalInfoForm.getSpecialisation();

                    for (int iLoop = 0; iLoop < examinationName.length; iLoop++) {

                        EmployeeEducationDetails employeeEducationDetailsPojo = daoEmpEducatinDetails.getEmployeeEducationDetails(empEduDetailsId[iLoop]);

                        employeeEducationDetailsPojo.setEmployeeId(sessionUID);

                        employeeEducationDetailsPojo.setExaminationName(examinationName[iLoop]);
                        employeeEducationDetailsPojo.setYearOfStart(baseDAO.mySqlDatebFormat(yearOfStart[iLoop]));
                        employeeEducationDetailsPojo.setYearOfEnd(baseDAO.mySqlDatebFormat(yearOfEnd[iLoop]));

                        employeeEducationDetailsPojo.setPercentage(new BigDecimal(percentage[iLoop].intValue()));
                        employeeEducationDetailsPojo.setBoardName(boardName[iLoop]);
                        employeeEducationDetailsPojo.setInstitutionName(institutionName[iLoop]);
                        employeeEducationDetailsPojo.setExaminationName(examinationName[iLoop]);
                        employeeEducationDetailsPojo.setSpecialisation(specialisation[iLoop]);

                        ins = (boolean) daoEmpEducatinDetails.save(employeeEducationDetailsPojo);

                    }

                } else if (empPersonalInfoForm.getEditDelete().equals("load")) {

                    List<EmployeeEducationDetails> employeeEducationDetailsList = daoEmpEducatinDetails.getEmployeeEducationDetailsByEmpId(sessionUID);
                    if (employeeEducationDetailsList.size() != 0) {
                        request.setAttribute("employeeEducationDetailsList", employeeEducationDetailsList);

                    }
                    ins = true;

                }


                if (ins == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }

                System.out.print("*************************Load Edit DELETE*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);
            }

        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }
        return mapping.findForward(target);
    }

    public ActionForward addEmployeeCertificationDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("addEmployeeCertificationDetails method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();

        EmployeeCertificationDAO daoEmployeeCertification = factory.createEmployeeCertificationManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        boolean ins = false;
        if (sessionUID != null) {

            try {

                String certificationName[] = empPersonalInfoForm.getCertificationName();
                String orgatizationName[] = empPersonalInfoForm.getOrgatizationName();
                String subject[] = empPersonalInfoForm.getSubject();
                String certifiedOnDate[] = empPersonalInfoForm.getCertifiedOnDate();
                String renewedDate[] = empPersonalInfoForm.getRenewedDate();
                String renewedOnDate[] = empPersonalInfoForm.getRenewedOnDate();

                for (int iLoop = 0; iLoop < certificationName.length; iLoop++) {

                    EmployeeCertification employeeCertificationPojo = new EmployeeCertification();

                    employeeCertificationPojo.setEmployeeId(sessionUID);

                    employeeCertificationPojo.setCertificationName(certificationName[iLoop]);
                    employeeCertificationPojo.setCertifiedOnDate(baseDAO.mySqlDatebFormat(certifiedOnDate[iLoop]));
                    employeeCertificationPojo.setRenewedDate(baseDAO.mySqlDatebFormat(renewedDate[iLoop]));
                    employeeCertificationPojo.setRenewedOnDate(baseDAO.mySqlDatebFormat(renewedOnDate[iLoop]));
                    employeeCertificationPojo.setOrgatizationName(orgatizationName[iLoop]);
                    employeeCertificationPojo.setSubject(subject[iLoop]);

                    ins = (boolean) daoEmployeeCertification.save(employeeCertificationPojo);
                }

                empPersonalInfoForm.clear();
                if (ins == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }

                System.out.print("*************************Action  addGrade*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);

            }

        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }

        return mapping.findForward(target);
    }

/// edit  Employee Certification Details
    public ActionForward load_edit_delete_EmployeeCertificationDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("load_edit_delete_EmployeeCertificationDetails method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();
        EmployeeCertificationDAO daoEmployeeCertification = factory.createEmployeeCertificationManager();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        boolean ins = false;
        if (sessionUID != null) {

            try {

                if (empPersonalInfoForm.getEditDelete().equals("delete")) {

                    Integer empCertificationId[] = empPersonalInfoForm.getEmpCertificationId();

                    for (int iLoop = 0; iLoop < empCertificationId.length; iLoop++) {

                        EmployeeCertification employeeCertificationPojo = daoEmployeeCertification.getEmployeeCertification(empCertificationId[iLoop]);

                        ins = daoEmployeeCertification.delete(employeeCertificationPojo);
                    }

                } else if (empPersonalInfoForm.getEditDelete().equals("edit")) {
                    System.out.print("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" + empPersonalInfoForm.getEditDelete() + "&&&&&&&&&&&&&&&&&&&&&&&");
                    Integer empCertificationId[] = empPersonalInfoForm.getEmpCertificationId();

                    String certificationName[] = empPersonalInfoForm.getCertificationName();
                    String orgatizationName[] = empPersonalInfoForm.getOrgatizationName();
                    String subject[] = empPersonalInfoForm.getSubject();
                    String certifiedOnDate[] = empPersonalInfoForm.getCertifiedOnDate();
                    String renewedDate[] = empPersonalInfoForm.getRenewedDate();
                    String renewedOnDate[] = empPersonalInfoForm.getRenewedOnDate();

                    for (int iLoop = 0; iLoop < empCertificationId.length; iLoop++) {

                        EmployeeCertification employeeCertificationPojo = daoEmployeeCertification.getEmployeeCertification(empCertificationId[iLoop]);

                        employeeCertificationPojo.setEmployeeId(sessionUID);

                        employeeCertificationPojo.setCertificationName(certificationName[iLoop]);
                        employeeCertificationPojo.setCertifiedOnDate(baseDAO.mySqlDatebFormat(certifiedOnDate[iLoop]));
                        employeeCertificationPojo.setRenewedDate(baseDAO.mySqlDatebFormat(renewedDate[iLoop]));
                        employeeCertificationPojo.setRenewedOnDate(baseDAO.mySqlDatebFormat(renewedOnDate[iLoop]));
                        employeeCertificationPojo.setOrgatizationName(orgatizationName[iLoop]);
                        employeeCertificationPojo.setSubject(subject[iLoop]);

                        ins = (boolean) daoEmployeeCertification.save(employeeCertificationPojo);
                    }
                    empPersonalInfoForm.clear();

                } else if (empPersonalInfoForm.getEditDelete().equals("load")) {

                    List<EmployeeCertification> employeeCertificationList = daoEmployeeCertification.getEmployeeCertificationByEmpId(sessionUID);
                    if (employeeCertificationList.size() != 0) {
                        request.setAttribute("employeeCertificateDetailsList", employeeCertificationList);
                    }
                    ins = true;
                }

                if (ins == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }


                System.out.print("*************************Load Edit DELETE*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);

            }

        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }
        return mapping.findForward(target);
    }

    //add Skill details-------------------
    public ActionForward addEmployeeSkillDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("addEmployeeCertificationDetails method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();

        EmployeeSkillDAO daoEmployeeSkill = factory.createEmployeeSkillManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        SkillsDAO skdao = factory.createSkillsManager();
        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        boolean ins = false;
        if (sessionUID != null) {

            try {

                Integer skillNameId[] = empPersonalInfoForm.getSkillNameId();
                String proficiencyLevel[] = empPersonalInfoForm.getProficiencyLevel();
                String lastUsed[] = empPersonalInfoForm.getLastUsed();

                for (int iLoop = 0; iLoop < skillNameId.length; iLoop++) {

                    EmployeeSkill employeeSkillPojo = new EmployeeSkill();

                    employeeSkillPojo.setEmployeeId(sessionUID);

                    employeeSkillPojo.setSkillId(skdao.getSkillbyID(new BigDecimal(skillNameId[iLoop].intValue())));
                    employeeSkillPojo.setProficiencyLevel(proficiencyLevel[iLoop]);
                    employeeSkillPojo.setLastUsed(baseDAO.mySqlDatebFormat(lastUsed[iLoop]));
                    employeeSkillPojo.setId(new SkillsDAOImpl().getLastRequestId().add(BigDecimal.ONE));
                    // ----- Duplicate skill checking
                    List<EmployeeSkill> employeeSkillList = daoEmployeeSkill.getCheckEmpSkillByEmpIdAndSkillId(sessionUID, skillNameId[iLoop]);

                    if (employeeSkillList.size() == 0) {
                        ins = (boolean) daoEmployeeSkill.save(employeeSkillPojo);

                    } else {

                        session.setAttribute("duplicateSkillMsg", "You Have added Duplicate Skill");
                        break;
                    }

                }

                empPersonalInfoForm.clear();
                if (ins == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }

                System.out.print("*************************Action Add Employee  Skill*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);
            }

        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }

        return mapping.findForward(target);
    }

/// edit  Employee Skill Details
    public ActionForward load_edit_delete_EmployeeSkillDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        System.out.print("load_edit_delete_EmployeeSkillDetails method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();
        EmployeeSkillDAO daoEmployeeSkill = factory.createEmployeeSkillManager();
        SkillsDAO daoSkills = factory.createSkillsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        boolean ins = false;
        if (sessionUID != null) {

            try {

                if (empPersonalInfoForm.getEditDelete().equals("delete")) {

                    Integer empSkillId[] = empPersonalInfoForm.getEmpSkillId();

                    for (int iLoop = 0; iLoop < empSkillId.length; iLoop++) {

                        EmployeeSkill employeeSkillPojo = daoEmployeeSkill.getEmployeeSkill(empSkillId[iLoop]);

                        ins = daoEmployeeSkill.delete(employeeSkillPojo);

                    }

                } else if (empPersonalInfoForm.getEditDelete().equals("edit")) {

                    Integer empSkillId[] = empPersonalInfoForm.getEmpSkillId();

                    Integer skillNameId[] = empPersonalInfoForm.getSkillNameId();
                    String proficiencyLevel[] = empPersonalInfoForm.getProficiencyLevel();
                    String lastUsed[] = empPersonalInfoForm.getLastUsed();

                    for (int iLoop = 0; iLoop < skillNameId.length; iLoop++) {

                        EmployeeSkill employeeSkillPojo = daoEmployeeSkill.getEmployeeSkill(empSkillId[iLoop]);

                        employeeSkillPojo.setEmployeeId(sessionUID);

//----duplicate Skill name checking

                        if (employeeSkillPojo.getSkillId().equals(skillNameId[iLoop])) {
                            employeeSkillPojo.setSkillId(daoSkills.getSkillbyID(new BigDecimal(skillNameId[iLoop].intValue())));
                        } else {

                            List<EmployeeSkill> employeeSkillList = daoEmployeeSkill.getCheckEmpSkillByEmpIdAndSkillId(sessionUID, skillNameId[iLoop]);

                            if (employeeSkillList.size() == 0) {
                                employeeSkillPojo.setSkillId(daoSkills.getSkillbyID(new BigDecimal(skillNameId[iLoop].intValue())));

                            } else {

                                session.setAttribute("duplicateSkillMsg", "You Have added Duplicate Skill");

                            }

                        }

//----End duplicate Skill name checking

                        employeeSkillPojo.setProficiencyLevel(proficiencyLevel[iLoop]);
                        employeeSkillPojo.setLastUsed(baseDAO.mySqlDatebFormat(lastUsed[iLoop]));

                        ins = (boolean) daoEmployeeSkill.save(employeeSkillPojo);

                    }
                    empPersonalInfoForm.clear();

                } else if (empPersonalInfoForm.getEditDelete().equals("load")) {

                    List<EmployeeSkill> employeeSkillList = daoEmployeeSkill.getEmployeeSkillByEmpId(sessionUID);
                    if (employeeSkillList.size() != 0) {
                        request.setAttribute("employeeSkillList", employeeSkillList);

                    }

                    System.out.print("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
                    List<Skills> skillsList = daoSkills.getAllSkils();

                    if (skillsList.size() != 0) {
                        request.setAttribute("skillsList", skillsList);

                    }
                    ins = true;
                }

                if (ins == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }


                System.out.print("*************************Load Edit DELETE*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);

            }
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }

        return mapping.findForward(target);
    }

    //add Previous employer    Details details-------------------
    public ActionForward addEmployeePreEmployerDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("addEmployeePreEmployerDetails method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();

        PreviousEmployerDetailsDAO daoPreviousEmployerDetails = factory.createPreviousEmployerDetailsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        boolean ins = false;
        if (sessionUID != null) {

            try {

                String employerName[] = empPersonalInfoForm.getEmployerName();
                String jobDescription[] = empPersonalInfoForm.getJobDescription();
                String joiningDate[] = empPersonalInfoForm.getJoiningDate();
                String releaseDate[] = empPersonalInfoForm.getReleaseDate();

                for (int iLoop = 0; iLoop < employerName.length; iLoop++) {

                    PreviousEmployerDetails previousEmployerDetailsPojo = new PreviousEmployerDetails();

                    previousEmployerDetailsPojo.setEmployeeId(sessionUID);

                    previousEmployerDetailsPojo.setEmployerName(employerName[iLoop]);
                    previousEmployerDetailsPojo.setJoiningDate(baseDAO.mySqlDatebFormat(joiningDate[iLoop]));
                    previousEmployerDetailsPojo.setReleaseDate(baseDAO.mySqlDatebFormat(releaseDate[iLoop]));

                    previousEmployerDetailsPojo.setJobDescription(jobDescription[iLoop]);

                    ins = (boolean) daoPreviousEmployerDetails.save(previousEmployerDetailsPojo);

                }

                empPersonalInfoForm.clear();
                if (ins == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }
                System.out.print("*************************Action  addGrade*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);

            }
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }
        return mapping.findForward(target);
    }

/// edit Previous employer    Details
    public ActionForward load_edit_delete_EmployeePreEmployerDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        System.out.print("load_edit_delete_EmployeePreEmployerDetails method call");
        EmployeePersonalInfoForm empPersonalInfoForm = (EmployeePersonalInfoForm) form;

        BaseDAO baseDAO = new BaseDAO();
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO daoEmpMaster = factory.createEmployeeMasterManager();
        PreviousEmployerDetailsDAO daoPreviousEmployerDetails = factory.createPreviousEmployerDetailsManager();

        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();

        HttpSession session = request.getSession();
        String sessionUID = (String) session.getAttribute("user_id");

        boolean ins = false;
        if (sessionUID != null) {

            try {

                if (empPersonalInfoForm.getEditDelete().equals("delete")) {

                    Integer empPreEmployerId[] = empPersonalInfoForm.getEmpPreEmployerId();


                    for (int iLoop = 0; iLoop < empPreEmployerId.length; iLoop++) {

                        PreviousEmployerDetails previousEmployerDetailsPojo = daoPreviousEmployerDetails.getPreviousEmployerDetails(empPreEmployerId[iLoop]);

                        ins = daoPreviousEmployerDetails.delete(previousEmployerDetailsPojo);
                    }

                } else if (empPersonalInfoForm.getEditDelete().equals("edit")) {
                    System.out.print("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" + empPersonalInfoForm.getEditDelete() + "&&&&&&&&&&&&&&&&&&&&&&&");
                    Integer empPreEmployerId[] = empPersonalInfoForm.getEmpPreEmployerId();

                    String employerName[] = empPersonalInfoForm.getEmployerName();
                    String jobDescription[] = empPersonalInfoForm.getJobDescription();
                    String joiningDate[] = empPersonalInfoForm.getJoiningDate();
                    String releaseDate[] = empPersonalInfoForm.getReleaseDate();

                    for (int iLoop = 0; iLoop < employerName.length; iLoop++) {

                        PreviousEmployerDetails previousEmployerDetailsPojo = daoPreviousEmployerDetails.getPreviousEmployerDetails(empPreEmployerId[iLoop]);

                        previousEmployerDetailsPojo.setEmployeeId(sessionUID);

                        previousEmployerDetailsPojo.setEmployerName(employerName[iLoop]);
                        previousEmployerDetailsPojo.setJoiningDate(baseDAO.mySqlDatebFormat(joiningDate[iLoop]));
                        previousEmployerDetailsPojo.setReleaseDate(baseDAO.mySqlDatebFormat(releaseDate[iLoop]));

                        previousEmployerDetailsPojo.setJobDescription(jobDescription[iLoop]);

                        ins = (boolean) daoPreviousEmployerDetails.save(previousEmployerDetailsPojo);

                    }

                    empPersonalInfoForm.clear();

                } else if (empPersonalInfoForm.getEditDelete().equals("load")) {

                    List<PreviousEmployerDetails> previousEmployerDetailsList = daoPreviousEmployerDetails.getPreviousEmployerDetailsByEmpId(sessionUID);
                    if (previousEmployerDetailsList.size() != 0) {
                        request.setAttribute("previousEmployerDetailsList", previousEmployerDetailsList);

                    }
                    ins = true;

                }

                if (ins == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }

                System.out.print("*************************Load Edit DELETE*****************************");

            } catch (DAOException doe) {
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
                log.error("critical error" + doe);
            } catch (Exception e) {

                // Report the error using the appropriate name and ID.
                //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
                log.error("error From ExceptionClass " + e);

            }
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("session.out", ""));
            saveMessages(request, messages);
            target = "sessionOut";

        }
        return mapping.findForward(target);
    }

    public ActionForward getEmployeeReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        EmployeePersonalInfoForm empinfo = (EmployeePersonalInfoForm) form;
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO empdao = factory.createEmployeeMasterManager();
        HttpSession session = request.getSession();
        try {

            String sessionUID = (String) session.getAttribute("user_id");
            List<EmployeeMaster> empList = null;
            empList = empdao.getAllEmployeeMaster();
            empinfo.setEmplist(empList);
            session.setAttribute("empList", empList);
            target = "success";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        return mapping.findForward(target);
    }

    public ActionForward generateReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        EmployeePersonalInfoForm empinfo = (EmployeePersonalInfoForm) form;
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO empdao = factory.createEmployeeMasterManager();
        HttpSession session = request.getSession();
        try {

            String sessionUID = (String) session.getAttribute("user_id");
            List<EmployeeMaster> empList = null;
            empList = empdao.getAllEmployeeMaster();
            empinfo.setEmplist(empList);
           
            ServletOutputStream servletOutputStream=response.getOutputStream();
            response.setContentType("application/pdf");
            String repfile=getServlet().getServletConfig().getServletContext().getRealPath("/JasRep/EmpPersonalInfo.jrxml")  ;
            String destfile=getServlet().getServletConfig().getServletContext().getRealPath("/JasRep/EmpPersonalInfo.jasper");
            JasperCompileManager.compileReportToFile(repfile,destfile);

            InputStream reportStream=getServlet().getServletConfig().getServletContext().getResourceAsStream("/JasRep/EmpPersonalInfo.jasper");
           
            JRDataSource jrsour=createReportDataSource(empList);
            JasperRunManager.runReportToPdfStream(reportStream, servletOutputStream, new HashMap(),jrsour);
            
            
            servletOutputStream.flush();
            servletOutputStream.close();
            
            
            target = "success";

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        return mapping.findForward(target);
    }
     private JRDataSource createReportDataSource(List<EmployeeMaster> empList){
        JRBeanCollectionDataSource jbs=new JRBeanCollectionDataSource(empList);
        return jbs;
    }

    public ActionForward loadDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        String target = "";
        EmployeeExitDetailsForm eform = (EmployeeExitDetailsForm) form;
        DAOFactory factory = new DAOFactory();
        EmployeeMasterDAO empdao = factory.createEmployeeMasterManager();

        EmployeeMaster pj = new EmployeeMaster();

        BaseDAO b = new BaseDAO();
        pj = empdao.getEmployeeMasterByEmpId(eform.getEmployeeId());

        try {

            if (pj != null) {
                eform.setId(pj.getId().intValue());
                eform.setEmployeeId(pj.getEmployeeId());
                eform.setFirstName(pj.getFirstName());
                eform.setDepartmentId(pj.getDepartmentId().intValue());
                eform.setBranchId(pj.getBranchId().intValue());
                eform.setDesignationId(pj.getDesignationId());
                eform.setDateOfJoin(b.mySQLscreenDateFormat(pj.getDateOfJoin()));
                eform.setNationality(pj.getNationality());
                eform.setStatus(pj.getStatus());
                eform.setEntryDate(b.mySQLscreenDateFormat(pj.getEntryDate()));
                eform.setEmployeeStatus(pj.getEmployeeStatus());


                target = "success";



            }

        } catch (Exception e) {

            log.error("error displaying  data" + e);
        }



        return mapping.findForward(target);

    }

    public ActionForward EmployeeExitDetailEditORsave(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        /*Method created by Pradipto */

        ActionMessages messages = new ActionMessages();
        EmployeeExitDetailsForm efrm = (EmployeeExitDetailsForm) form;


        DAOFactory dfact = new DAOFactory();
        EmployeeJobHistoryDAO ejhd = dfact.createEmployeeJobHistoryDAOManager();
        EmployeeJobHistory pj = new EmployeeJobHistory();

        BaseDAO b = new BaseDAO();
        try {
            pj.setId(ejhd.getLastRequestId());
            pj.setEmployeeId(efrm.getEmployeeId());
            pj.setName(efrm.getFirstName());
            pj.setDesignationID(efrm.getDesignationId().toString());
            pj.setBranchID(efrm.getBranchId().toString());
            pj.setDepartmentID(efrm.getDepartmentId().toString());
            pj.setNationality(efrm.getNationality());
            pj.setStatus(efrm.getStatus().trim());
            pj.setReasonOfLeavingJob(efrm.getReasonOfLeaving());
            pj.setRunaway(efrm.getRunaway());
            pj.setDateOfJoin(b.mySqlDatebFormat(efrm.getDateOfJoin()));

            boolean rs = ejhd.save(pj);
            if (rs == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";

            }

        } catch (DAOException e) {
            log.error("Error occured " + e);
        }

        return mapping.findForward(target);

    }

    public ActionForward load(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        List<BranchMaster> branchobj = null;
        EmployeeExitDetailsForm frmobj = (EmployeeExitDetailsForm) form;

        DAOFactory dfact = new DAOFactory();
        BranchDAO bdao = dfact.createBranchDAOManager();

        try {

            branchobj = bdao.getAllBranches();
            request.setAttribute("branch", branchobj);
            target = "success";

        } catch (Exception e) {

            log.error("error displaying attendance data" + e);
        }
        return mapping.findForward(target);











    }

    public ActionForward BranchIdRetreive(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<EmployeeMaster> list = null;
        DAOFactory dfact = new DAOFactory();

        EmployeeMasterDAO dobj = dfact.createEmployeeMasterManager();
        EmployeeExitDetailsForm frm = (EmployeeExitDetailsForm) form;


        List<BranchMaster> branchobj = null;
        BranchDAO bdao = dfact.createBranchDAOManager();
        try {

            branchobj = bdao.getAllBranches();
            request.setAttribute("branch", branchobj);


            String branchid = frm.getBranchId().toString();
            list = dobj.getEmployeeByBranchID(branchid);
            request.setAttribute("Employeeinformation", list);
            target = "success";



        } catch (Exception e) {

            log.error("error displaying attendance data" + e);
        }

        return mapping.findForward(target);
    }

    public ActionForward DepartmentsNamesRetreive(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List<Department> list = null;
        DepartmentForm dform = (DepartmentForm) form;
        DAOFactory dfact = new DAOFactory();
        DepartmentDAO depdao = dfact.departmentManager();


        try {


            list = depdao.getAllDepartment();
            request.setAttribute("departments", list);



            target = "success";


        } catch (Exception e) {

            log.error("error displaying Departments data data" + e);
        }

        return mapping.findForward(target);
    }

    public ActionForward ShowDepartmentEmployees(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List<EmployeeMaster> list = null;
        DepartmentForm dform = (DepartmentForm) form;
        DAOFactory dfact = new DAOFactory();
        EmployeeMasterDAO empdao = dfact.createEmployeeMasterManager();
        BaseDAO bd = new BaseDAO();

        List<Department> list2 = null;
        DepartmentDAO depdao = dfact.departmentManager();
        DesignationDAO designationdao = dfact.designationManager();
        CountryDAO cntdao = dfact.createCountryManager();
        StateDAO stdao = dfact.createStateManager();
        CityDAO ctdao = dfact.createCityManager();
        List<EmployeeDesignation> empdesList = new ArrayList<EmployeeDesignation>();



        try {

            list2 = depdao.getAllDepartment();
            request.setAttribute("departments", list2);
            Integer departmentid = dform.getDepartmentId();
            list = empdao.getEmployeeInformationByDepartmentID(departmentid);

            for (EmployeeMaster e : list) {
                EmployeeDesignation ed = new EmployeeDesignation();
                DesignationMaster desg = designationdao.getDesignation(e.getDesignationId());
                CountryMaster cnt = cntdao.getCountry(e.getPresentCountry().intValue());
                State st = stdao.getState(e.getPresentState().intValue());
                City ct = ctdao.getCity(e.getPresentCity().intValue());

                ed.setDesignationName(desg.getDesignationName());
                ed.setDateOfBirth(bd.mySQLscreenDateFormat(e.getDateOfBirth()));

                ed.setEmployeeId(e.getEmployeeId());
                ed.setFirstName(e.getFirstName());
                ed.setDesignationDescription(desg.getDesignationDescription());
                ed.setNationality(e.getNationality());
                ed.setPresentAddress(e.getPresentAddress());
                ed.setCityName(ct.getCityName());
                ed.setCountryName(cnt.getCountryName());
                ed.setStateName(st.getStateName());
                ed.setMobileNo(e.getMobileNo());
                ed.setEmailAddress(e.getEmailAddress());

                empdesList.add(ed);
            }



            request.setAttribute("EmployeeDetails", empdesList);
            target = "success";




        } catch (Exception e) {

            log.error("error displaying Employee details" + e);
        }

        return mapping.findForward(target);
    }

    public ActionForward RunawayInformationRetreive(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<EmployeeJobHistory> list = null;
        DAOFactory dfact = new DAOFactory();
        EmployeeJobHistoryDAO empjobdao = dfact.createEmployeeJobHistoryDAOManager();
        DepartmentDAO dao = dfact.departmentManager();
        DesignationDAO desdao = dfact.designationManager();

        List<EmployeeRunawayReport> runobj = new ArrayList<EmployeeRunawayReport>();

        String runaway = "runaway";



        try {
            list = empjobdao.getEmployeesByRunaway(runaway);

            for (EmployeeJobHistory e : list) {
                EmployeeRunawayReport rp = new EmployeeRunawayReport();

                Department deppojo = dao.getDepartment(Integer.parseInt(e.getDepartmentID()));
                DesignationMaster desg = desdao.getDesignation(Integer.parseInt(e.getDesignationID()));

                rp.setName(e.getName());
                rp.setEmployeeId(e.getEmployeeId());
                rp.setDesignationName(desg.getDesignationName());
                rp.setDepartmentName(deppojo.getDepartmentName());
                rp.setNationality(e.getNationality());
                runobj.add(rp);
            }




            request.setAttribute("runawayemployees", runobj);

            target = "success";
        } catch (Exception e) {

            log.error("An exception occur exception type is  :" + e);

        }
        return mapping.findForward(target);
    }

    public ActionForward GradeRetreive(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List<GradeMaster> list = null;
        DAOFactory dfact = new DAOFactory();
        GradeMasterDAO grddao = dfact.creteGradeManager();
        String status = "Y";
        try {
            list = grddao.getEmployeesbyGrade(status);
            request.setAttribute("gradedetails", list);

            target = "success";


        } catch (Exception e) {
            log.error("Exception occured exception type is : " + e);

        }

        return mapping.findForward(target);

    }

    public ActionForward DetailsOfEmployeeByGrades(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List<EmployeeMaster> emppojo = null;
        DAOFactory dfact = new DAOFactory();
        List<EmployeeDesignation> edg = new ArrayList<EmployeeDesignation>();


        DepartmentDAO depdao = dfact.departmentManager();
        BranchDAO brdao = dfact.createBranchDAOManager();

        DesignationDAO dgdao = dfact.designationManager();
        EmployeePersonalInfoForm frm = (EmployeePersonalInfoForm) form;
        EmployeeMasterDAO edao = dfact.createEmployeeMasterManager();
        String grades = frm.getGrade().toString();
        List<GradeMaster> list = null;
        GradeMasterDAO grddao = dfact.creteGradeManager();
        try {
            emppojo = edao.getEmployeeInformationByGrades(grades);
            for (EmployeeMaster e : emppojo) {
                EmployeeDesignation dg = new EmployeeDesignation();
                Department deppojo = depdao.getDepartment(e.getDepartmentId().intValue());
                BranchMaster br = brdao.getBranchNameByBranchID(e.getBranchId().intValue());
                DesignationMaster dgf = dgdao.getDesignation(e.getDesignationId().intValue());

                dg.setEmployeeId(e.getEmployeeId());
                dg.setFirstName(e.getFirstName());
                dg.setMobileNo(e.getMobileNo());
                dg.setDepartmentName(deppojo.getDepartmentName());
                dg.setBranchName(br.getBranchName());
                dg.setDesignationName(dgf.getDesignationName());
                dg.setEmailAddress(e.getEmailAddress());
                dg.setNationality(e.getNationality());
                dg.setPresentAddress(e.getPresentAddress());
                dg.setDateOfJoin(e.getDateOfBirth());

                edg.add(dg);

            }




            String status = "Y";
            list = grddao.getEmployeesbyGrade(status);
            request.setAttribute("gradedetails", list);




            request.setAttribute("gradedetails2", edg);

            log.info("Now data is successfully retreive and will be shown in table");
            target = "success";
            log.info("Codding by pradipto");


        } catch (Exception e) {

            log.error("An exception occur exception type is  :" + e);

        }

        return mapping.findForward(target);

    }

    public ActionForward OrganizationStructureLoadCall(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        List list = null;
        DAOFactory dfact = new DAOFactory();
        EmployeeMasterDAO edao = dfact.createEmployeeMasterManager();

        list = edao.getOrganizationStructure();
        List<Oraganization> orglist = new ArrayList<Oraganization>();
        Iterator itr = list.iterator();

        while (itr.hasNext()) {
            Object obj = itr.next();


        }

        target = "success";
        return mapping.findForward(target);
    }

    public ActionForward LoadAllMaster(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        EmployeePersonalInfoForm frm = (EmployeePersonalInfoForm) form;
        DAOFactory dfact = new DAOFactory();
        DepartmentDAO depdao = dfact.departmentManager();
        List<Department> deppojo = null;

        BranchDAO brdao = dfact.createBranchDAOManager();
        List<BranchMaster> brpojo = null;


        EmployeeMasterDAO edao = dfact.createEmployeeMasterManager();
        List<EmployeeMaster> epojo = null;

        DesignationDAO degdao = dfact.designationManager();
        List<DesignationMaster> degpojo = null;

        RoleMasterDAO rdao = dfact.createRoleManager();
        List<RoleMaster> rolepojo = null;

        JobTypeDAO jdao=dfact.createJobTypeManager();
        List<JobType> jlist=null;

        try {
            deppojo = depdao.getAllDepartment();
            request.setAttribute("department", deppojo);

            brpojo = brdao.getAllBranches();
            request.setAttribute("Branches", brpojo);

            epojo = edao.getAllEmployeeMaster();
            request.setAttribute("supervisor", epojo);

            degpojo = degdao.getAllDesignation();
            request.setAttribute("designation", degpojo);

            rolepojo = rdao.getAllRoles();
            request.setAttribute("Roles", rolepojo);

            jlist=jdao.getAllJobType();
            request.setAttribute("allJobs", jlist);

            target = "success";

        } catch (Exception e) {

            log.error("An exception occur" + e);
        }




        return mapping.findForward(target);
    }

    public ActionForward SubmitEmployeeInformation(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        EmployeePersonalInfoForm frm = (EmployeePersonalInfoForm) form;

        ActionMessages messages = new ActionMessages();
        DAOFactory dfact = new DAOFactory();
        EmployeeMasterDAO edao = dfact.createEmployeeMasterManager();

        EmployeeMaster epojo = new EmployeeMaster();
        BaseDAO b = new BaseDAO();
        byte[] databyte = ImageUtil.UploadImage(request, frm);

        try {


            epojo.setId(edao.getLastRequestId().add(BigDecimal.ONE));
            epojo.setEmployeeId(frm.getEmployeeId());
            epojo.setFirstName(frm.getFirstName());
            epojo.setLastName(frm.getLastName());
            epojo.setPresentAddress(frm.getPresentAddress());
            epojo.setPermanentAddress(frm.getPermanentAddress());
            epojo.setEmailAddress(frm.getEmailAddress());
            epojo.setMobileNo(frm.getMobileNo());
            epojo.setDateOfBirth(b.mySqlDatebFormat(frm.getDateOfBirth()));
            epojo.setGender(frm.getGender());
            epojo.setNationality(frm.getNationality());
            epojo.setReligion(frm.getReligion());
            epojo.setIdentificationMark(frm.getIdentificationMark());
            epojo.setLanguageKnown(frm.getLanguageKnown());
            epojo.setLanguageKnown(frm.getLanguageKnown());
            epojo.setHobby(frm.getHobby());
            epojo.setDepartmentId(new BigDecimal(frm.getDeptId().intValue()));
            epojo.setBranchId(new BigDecimal(frm.getBrId()));
            epojo.setSupervisorId(frm.getSupervisorId());
            epojo.setDesignationId(frm.getDesignation_id());
            epojo.setStatus(frm.getStatus());
            epojo.setCanImage(databyte);
            epojo.setTypeId(new BigDecimal(frm.getJobtypeId()));
            epojo.setBloodGroup(frm.getBloodGroup());
            
            LoginDAO ldao = dfact.createLoginManager();

            Login lobj = new Login();
            lobj.setUserId(frm.getEmployeeId());
            lobj.setPassword(frm.getFirstName().toLowerCase());
            lobj.setRole(frm.getRoleID());
            ldao.save(lobj);

            boolean rs = edao.save(epojo);


            if (rs == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";
            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";

            }







        } catch (DAOException e) {
            log.error("Error occured " + e);
        }


        return mapping.findForward(target);
    }
}
