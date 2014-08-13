/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.ImplClass.CompanyDAOImpl;
import com.dao.BranchDAO;
import com.pojo.BranchMaster;
import com.forms.BranchForm;
import com.dao.CompanyDAO;
import com.pojo.Company;
import com.dao.CityDAO;
import com.dao.CountryDAO;
import com.pojo.City;
import com.pojo.CountryMaster;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.forms.CompanyForm;
import com.pojo.Department;
import com.dao.DepartmentDAO;
import com.dao.JobTypeDAO;
import com.forms.JobTypeForm;
import com.pojo.JobType;
import com.forms.DepartmentForm;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;

import java.math.BigDecimal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author Sumit Kumar
 */
public class CompanyAction extends DispatchAction {

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
    public ActionForward addCompany(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


        DAOFactory factory = new DAOFactory();
        CompanyDAO compDao = factory.createCompanyManager();
        //Add for dept
        //DepartmentDAO daoDepartment = factory.createDepartmentManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        //List<Department> departmentList = null;
        CompanyDAOImpl compImpl = new CompanyDAOImpl();
        HttpSession session = request.getSession(true);
        CompanyForm compForm = (CompanyForm) form;
        String employeeId = (String) session.getAttribute("user_id");

        try {
            ////Add for dept
            //departmentList=daoDepartment.getAllDepartment();
            // request.setAttribute("deptList", departmentList);

            //For Leave Report

            //End leave Report

//For Leave apply
            Company comp = new Company();
            System.out.println("Form data========>" + compForm.getId());

            BigDecimal b = new BigDecimal(1.0);
            comp.setCompanyCode(compImpl.getLastRequestId().add(b));
            comp.setCompanyName(compForm.getCompanyName());
            comp.setContactno(compForm.getContactNo());
            comp.setRegaddress(compForm.getRegaddress());
            comp.setCorptaddress(compForm.getCorptaddress());
            comp.setNatureOfBusiness(compForm.getBusinessNature());
            comp.setCompanyTypeid(new BigDecimal(compForm.getCompanyTypeId().intValue()));
            comp.setCountryoriginid(new BigDecimal(compForm.getCountryOriginId().intValue()));
            comp.setCityid(new BigDecimal(compForm.getCityId().intValue()));
            comp.setEntrydate(new Date());
            comp.setStatus("Y");
            comp.setFinstartyear(compForm.getFinstartyear());
            comp.setFinendyear(compForm.getFinendyear());

            boolean result = compDao.save(comp);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }

            //int count=(int)(leaveForm.getToDt()-leaveForm.getFromDt());
            target = "success";


        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", doe));
            saveErrors(request, messages);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", e));
            saveErrors(request, messages);
        }

        return mapping.findForward(target);
    }

    public ActionForward addGrCompany(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {



        DAOFactory factory = new DAOFactory();
        CompanyDAO compDao = factory.createCompanyManager();
        //Add for dept
        //DepartmentDAO daoDepartment = factory.createDepartmentManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        //List<Department> departmentList = null;
        CompanyDAOImpl compImpl = new CompanyDAOImpl();
        HttpSession session = request.getSession(true);
        CompanyForm compForm = (CompanyForm) form;
        String employeeId = (String) session.getAttribute("user_id");

        try {
            ////Add for dept
            //departmentList=daoDepartment.getAllDepartment();
            // request.setAttribute("deptList", departmentList);

            //For Leave Report

            //End leave Report

            //For Leave apply
            Company comp = new Company();
            System.out.println("Form data========>" + compForm.getId());

            BigDecimal b = new BigDecimal(1.0);
            comp.setCompanyCode(compImpl.getLastRequestId().add(b));
            comp.setCompanyName(compForm.getCompanyName());
            comp.setContactno(compForm.getContactNo());
            comp.setRegaddress(compForm.getRegaddress());
            comp.setCorptaddress(compForm.getCorptaddress());
            comp.setNatureOfBusiness(compForm.getBusinessNature());
            comp.setCompanyTypeid(new BigDecimal(compForm.getCompanyTypeId().intValue()));
            comp.setCountryoriginid(new BigDecimal(compForm.getCountryOriginId().intValue()));
            comp.setCityid(new BigDecimal(compForm.getCityId().intValue()));
            if (compForm.getGrcompanyId() != null) {
                comp.setGrcompanyid(new BigDecimal(compForm.getGrcompanyId()));
            }
            comp.setEntrydate(new Date());
            comp.setStatus("Y");
            comp.setFinstartyear(compForm.getFinstartyear());
            comp.setFinendyear(compForm.getFinendyear());

            boolean result = compDao.save(comp);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "gpcomp";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "gpcomp";
            }

            //int count=(int)(leaveForm.getToDt()-leaveForm.getFromDt());
            target = "gpcomp";


        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", doe));
            saveErrors(request, messages);
        } catch (Exception e) {

            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", e));
            saveErrors(request, messages);
        }

        return mapping.findForward(target);
    }

    public ActionForward getAllCompanies(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        System.out.println("Inside Action class getAllEmployee method");

        DAOFactory factory = new DAOFactory();
        CompanyDAO dao = factory.createCompanyManager();
        HttpSession session = request.getSession(true);
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        CompanyForm compForm = (CompanyForm) form;

        Company comp = null;
        List<Company> list = new ArrayList<Company>();

        try {
            Object[] data = null;
            list = dao.getAllCompany();

//            Iterator itr = list.iterator();
//            List l = new ArrayList();
//            while (itr.hasNext()) {
//
//                data = (Object[]) itr.next();
//
//                compForm.setId(data[0].toString());
//
//                loanUtil.setTotalSal(data[1].toString());
//                loanUtil.setReqAmt(data[2].toString());
//
//                loanUtil.setDeductstartmonth((Date) data[4]);
//
//                loanUtil.setReason(data[6].toString());
//                loanUtil.setInstallment(data[3].toString());
//                loanUtil.setRequestId(((BigDecimal) data[5]).intValue());
//                loanUtil.setRequestDate((Date) data[7]);
//
//                l.add(loanUtil);
//            }

            System.out.println("List values=====>" + list);
            request.setAttribute("compList", list);


        } catch (DAOException doe) {

            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error", doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();
            // Report the error using the appropriate name and ID.
            errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        target = "success";
        return mapping.findForward(target);
    }

    public ActionForward loadForm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CountryDAO cntdao = factory.createCountryManager();
        List<CountryMaster> countList = null;
        try {
            countList = cntdao.getAllCountry();
            request.setAttribute("country", countList);
            target = "success";
        } catch (Exception e) {
            log.error("Error Fetching the country list" + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadCity(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CityDAO citydao = factory.createCityManager();
        List<City> citylist = null;
        CompanyForm cform = (CompanyForm) form;
        try {
            citylist = citydao.getAllCityByCountryCode(cform.getCountryOriginId());
            String currency = citylist.get(0).getCountryMaster().getCurrencyAbbreviation();
            request.setAttribute("currency", currency);
            request.setAttribute("citylist", citylist);
            target = "success";
        } catch (Exception e) {
            log.error("error fetching the city list " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadBranchCity(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CityDAO citydao = factory.createCityManager();
        List<City> citylist = null;
        BranchForm bform = (BranchForm) form;
        try {
            citylist = citydao.getAllCityByCountryCode(bform.getBranchCountryid());
            String currency = citylist.get(0).getCountryMaster().getCurrencyAbbreviation();
            request.setAttribute("currency", currency);
            request.setAttribute("citylist", citylist);
            target = "success";
        } catch (Exception e) {
            log.error("error fetching the city list " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadGrpCompForm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CountryDAO cntdao = factory.createCountryManager();
        CompanyDAO compdao = factory.createCompanyManager();
        List<CountryMaster> countList = null;
        List<Company> compList = null;
        try {
            countList = cntdao.getAllCountry();
            compList = compdao.getAllGrpCompany();
            request.setAttribute("compList", compList);
            request.setAttribute("country", countList);
            target = "gpcomp";
        } catch (Exception e) {
            log.error("Error Fetching the country list" + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadBranchCreation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CountryDAO cntdao = factory.createCountryManager();
        CompanyDAO compdao = factory.createCompanyManager();
        List<CountryMaster> countList = null;
        List<Company> comList = null;
        try {
            countList = cntdao.getAllCountry();
            comList = compdao.getAllCompany();
            request.setAttribute("compList", comList);
            request.setAttribute("country", countList);
            target = "success";
        } catch (Exception e) {
            log.error("error loading Branch Form " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward addBranch(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        BranchDAO branchdao = factory.createBranchManager();
        BranchMaster b = new BranchMaster();
        BranchForm bform = (BranchForm) form;
        CompanyDAO comdao = factory.createCompanyManager();
        ActionMessages messages = new ActionMessages();
        try {
            b.setBranchId(branchdao.getLastRequestId().add(BigDecimal.ONE));
            b.setBranchAddress(bform.getBranchAddress());
            b.setCompany(comdao.getCompany(bform.getCompanyId()));
            b.setContactNumber(bform.getContactNumber());
            b.setBranchfax(bform.getBranchfax());
            b.setBranchType(bform.getBranchType());
            b.setBranchCountryid(new BigDecimal(bform.getBranchCountryid().intValue()));
            b.setBranchCityid(new BigDecimal(bform.getBranchCityid().intValue()));
            b.setCurrency(bform.getCurrency());
            b.setBranchCreationdate(new Date());
            b.setBranchemail(bform.getBranchemail());
            b.setStatus("Y");
            b.setBranchName(bform.getBranchName());

            boolean result = branchdao.save(b);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }

        } catch (DAOException doe) {
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", doe));
            saveErrors(request, messages);

        } catch (Exception e) {
            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", e));
            saveErrors(request, messages);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadDepartmentCreation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompanyDAO compdao = factory.createCompanyManager();

        List<Company> comList = null;
        try {
            comList = compdao.getAllCompany();
            request.setAttribute("compList", comList);
            target = "success";
        } catch (Exception e) {
            log.error("error loading Branch Form " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward addDepartment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        DepartmentDAO deptdao = factory.departmentManager();
        DepartmentForm deptform = (DepartmentForm) form;
        Department dept = new Department();
        ActionMessages messages = new ActionMessages();
        try {
            dept.setDepartmentId(deptdao.getLastRequestId().add(BigDecimal.ONE));
            dept.setCompanyCode(new BigDecimal(deptform.getCompanyCode()));
            dept.setDepartmentCode(deptform.getDepartmentCode());
            dept.setDepartmentName(deptform.getDepartmentName());
            dept.setDepartmentDescription(deptform.getDepartmentDescription());
            dept.setStatus("Y");
            dept.setEntrydate(new Date());

            boolean result = deptdao.save(dept);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }
        } catch (Exception e) {
            log.error("error saving the department information " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", e));
            saveErrors(request, messages);
            target = "success";
        }
        return mapping.findForward(target);
    }

    public ActionForward loadJobCreation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompanyDAO compdao = factory.createCompanyManager();
        List<Company> complist = null;
        try {
            complist = compdao.getAllCompany();
            request.setAttribute("compList", complist);
            target = "load";
        } catch (Exception e) {
            log.error("error fetching company list " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadDept(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        DepartmentDAO deptdao = factory.departmentManager();
        List<Department> deptlist = null;
        JobTypeForm jobform = (JobTypeForm) form;
        try {
            deptlist = deptdao.getDepartmentByCompanyCode(jobform.getCompanyCode());
            request.setAttribute("deptList", deptlist);
            target = "deptlist";
        } catch (Exception e) {
            log.error("error fetching department list " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward addJobType(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        JobTypeDAO jobdao = factory.createJobTypeManager();
        CompanyDAO compdao = factory.createCompanyManager();
        DepartmentDAO deptdao = factory.departmentManager();
        JobTypeForm jobform = (JobTypeForm) form;
        ActionMessages messages = new ActionMessages();
        try {
            JobType jt = new JobType();
            jt.setTypeId(new BigDecimal(jobdao.getLastId()).add(BigDecimal.ONE));
            jt.setCompany(compdao.getCompany(jobform.getCompanyCode()));
            jt.setDepartment(deptdao.getDepartment(jobform.getDeptId()));
            jt.setEnabled("Y");
            jt.setJobname(jobform.getJobName());

            boolean result = jobdao.insertJobType(jt);
            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }

        } catch (Exception e) {
            log.error("error saving the job " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
            saveErrors(request, messages);
            target = "success";
        }
        return mapping.findForward(target);
    }

    public ActionForward loadCompanyList(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompanyDAO compdao = factory.createCompanyManager();
        List<Company> complist = null;
        try {
            complist = compdao.getAllCompany();
            request.setAttribute("compList", complist);
            target = "load";
        } catch (Exception e) {
            log.error("error fetching company list " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward branchReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        BranchDAO bdao = factory.createBranchManager();
        List<BranchMaster> bm = null;
        BranchForm bform = (BranchForm) form;
        CompanyDAO compdao = factory.createCompanyManager();
        List<Company> complist = null;
        try {
            complist = compdao.getAllCompany();
            request.setAttribute("compList", complist);
            bm = bdao.getAllBranchOfCompany(bform.getCompanyId());
            request.setAttribute("branchList", bm);
            target = "success";
        } catch (Exception e) {
            log.error("error during branch report formation " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward deptReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        DepartmentDAO deptdao = factory.departmentManager();
        DepartmentForm deptform = (DepartmentForm) form;
        List<Department> deptlist = null;
        CompanyDAO compdao = factory.createCompanyManager();
        List<Company> complist = null;
        try {
            complist = compdao.getAllCompany();
            request.setAttribute("compList", complist);
            deptlist = deptdao.getDepartmentByCompanyCode(deptform.getCompanyCode());
            request.setAttribute("deptList", deptlist);
            target = "success";
        } catch (Exception e) {
            log.error("error occured during fetching of department list " + e);

        }
        return mapping.findForward(target);

    }
}
