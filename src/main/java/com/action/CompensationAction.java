/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.dao.BaseDAO;
import com.dao.DAOFactory;
import com.dao.DesignationDAO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.dao.DepartmentDAO;
import com.dao.CompanyDAO;
import com.pojo.Company;
import com.pojo.Department;
import com.forms.compensationForm;
import com.pojo.DesignationMaster;
import com.dao.CompensationDao;
import com.ImplClass.CompensationDAOImpl;
import com.pojo.CompensationIncrementBand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.pojo.CompensationIndicatorMaster;
import com.forms.performanceSetupForm;
import com.pojo.CompensationPerformanceIndicator;
import com.dao.EmployeeMasterDAO;
import com.pojo.EmployeeMaster;
import com.ImplClass.EmployeeMasterDAOImpl;
import com.pojo.BranchMaster;
import com.ImplClass.BranchDAOImpl;
import com.dao.BranchDAO;
import com.dao.DAOException;
import com.forms.CompensationPerformanceSheetForm;
import java.util.ListIterator;
import com.util.compensationutil;
import com.pojo.CompensationPerformancesheet;
import com.util.AppraisalReportUtil;
import com.pojo.AppraisalEmpInfo;
import com.pojo.AppraisalResultSum;
import com.forms.TimesheetDetailForm;
import com.util.Timesheetutil;
import com.pojo.TimesheetDetail;
import com.dao.TimeSheetDAO;
import java.util.Date;
import com.pojo.CompensationCalculatedScore;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import com.dao.CompanyDAO;
import com.dao.DepartmentDAO;
import com.dao.DesignationDAO;
import com.util.IndicatorBandUtil;
import com.forms.AddcompensationIndicatorMasterForm;

import com.lowagie.text.Document;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
//import com.lowagie.text.Watermark;
import com.lowagie.text.pdf.PdfWriter;
import javax.servlet.ServletOutputStream;

/**
 *
 * @author computer1
 */
public class CompensationAction extends DispatchAction {

    private String target = "";
    /* forward name="success" path="" */

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward getCompany(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompanyDAO cdao = factory.createCompanyManager();
        CompensationDao compdao = factory.createCompensationManager();
        List<CompensationIndicatorMaster> cimlist = null;

        List<Company> clist = null;
        try {
            clist = cdao.getAllCompany();
            cimlist = compdao.getIndicator();
            request.setAttribute("companylist", clist);
            request.setAttribute("indicatorlist", cimlist);
            target = "company";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getDepartment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();

        DesignationDAO ddao = factory.designationManager();
        DepartmentDAO dedao = factory.createDepartmentManager();
        compensationForm cform = (compensationForm) form;
        List<Department> deptlist = null;
        List<DesignationMaster> dlist = null;
        try {
            deptlist = dedao.getDepartmentByCompanyCode(Integer.parseInt(cform.getCompany()));
            dlist = ddao.getDesignationByCompanyCode(Integer.parseInt(cform.getCompany()));
            request.setAttribute("designationlist", dlist);

            request.setAttribute("departmentlist", deptlist);
            target = "deptlist";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward saveBand(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompensationDao cdao = factory.createCompensationManager();
        compensationForm cform = (compensationForm) form;
        CompensationIncrementBand cib = new CompensationIncrementBand();
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        BaseDAO b = new BaseDAO();
        Date d = new Date();

        try {
            cib.setId(cdao.getLastId() + 1);
            cib.setIncrement(Integer.parseInt(cform.getIncrement()));
            cib.setFrom(Integer.parseInt(cform.getFrom()));
            cib.setTo(Integer.parseInt(cform.getTo()));
            cib.setIncrementdatefrom(b.mySqlDatebFormat(cform.getIncrementdatefrom()));
            cib.setIncrementdateto(b.mySqlDatebFormat(cform.getIncrementdateto()));
            cib.setStatus("initialized");

            cib.setDepartment(Integer.parseInt(cform.getDepartment()));
            cib.setDesignation(Integer.parseInt(cform.getDesignation()));
            cib.setCompany(Integer.parseInt(cform.getCompany()));



            boolean result = cdao.save(cib);

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }
            target = "success";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    public ActionForward getIndicator(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompensationDao cdao = factory.createCompensationManager();
        List<CompensationIndicatorMaster> cimlist = null;
        try {
            cimlist = cdao.getIndicator();

            request.setAttribute("indicatorlist", cimlist);


            target = "indicator";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward savePerformanceIndicator(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompensationDao cdao = factory.createCompensationManager();
        performanceSetupForm cform = (performanceSetupForm) form;
        CompensationPerformanceIndicator cib = new CompensationPerformanceIndicator();
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        BaseDAO b = new BaseDAO();
        Date d = new Date();

        try {
            cib.setId(cdao.getLastIdForIndicator() + 1);
            cib.setIndicator(Integer.parseInt(cform.getIndicator()));
            cib.setMeasure(Integer.parseInt(cform.getMeasure()));

            cib.setDepartment(Integer.parseInt(cform.getDepartment()));
            cib.setDesignation(Integer.parseInt(cform.getDesignation()));
            cib.setCompany(Integer.parseInt(cform.getCompany()));
            cib.setIndicatordate(d);




            boolean result = cdao.saveIndicator(cib);

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }
            target = "success";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    public ActionForward getIndicatorForPerformancesheet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        EmployeeMaster emppojo = null;
        BranchMaster bpojo = null;
        EmployeeMasterDAO empdao = factory.createEmployeeMasterManager();
        BranchDAO bdao = factory.createBranchManager();
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        BaseDAO b = new BaseDAO();
        CompensationPerformanceSheetForm cpform = (CompensationPerformanceSheetForm) form;

        Integer companyid = null;
        Integer departmentid = null;
        Integer designationid = null;
        CompensationPerformanceIndicator cp = new CompensationPerformanceIndicator();
        try {
            String empid = cpform.getEmpid();
            CompensationDao cdao = factory.createCompensationManager();
            emppojo = empdao.getEmployeeMasterByEmpId(empid);
            departmentid = (emppojo.getDepartmentId()).intValue();
            designationid = emppojo.getDesignationId();
            bpojo = bdao.getBranch(emppojo.getBranchId());
            companyid = bpojo.getCompany().getCompanyCode().intValue();
            List<CompensationPerformanceIndicator> cpilist = null;
            cpilist = cdao.getperformanceIndicator(companyid, departmentid, designationid);

            List<compensationutil> cutil = new ArrayList<compensationutil>();
            for (CompensationPerformanceIndicator cpi : cpilist) {
                compensationutil c = new compensationutil();
                c.setIndicatorid(cpi.getIndicator());
                Integer indicatorid = cpi.getIndicator();
                CompensationIndicatorMaster cim = cdao.getIndicatorById(indicatorid);
                c.setIndicatorname(cim.getIndicator());

                c.setTotalmeasure(cpi.getMeasure());
                c.setEmpid(empid);
                cutil.add(c);



            }




            request.setAttribute("indicator", cutil);

            target = "cpi";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward savecompensationperformancesheet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompensationDao cdao = factory.createCompensationManager();
        CompensationPerformanceSheetForm cpform = (CompensationPerformanceSheetForm) form;
        CompensationPerformancesheet cp = new CompensationPerformancesheet();
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        BaseDAO b = new BaseDAO();
        Date d = new Date();
        int length = cpform.getIndicatorid().length;
        boolean result = false;
        try {
            for (int i = 0; i < length; i++) {
                String empid = cpform.getEmpid();
                cp.setId(cdao.getLastIdForPerformancesheet() + 1);
                cp.setIndicatorid(cpform.getIndicatorid()[i]);
                cp.setEmpid(empid);
                cp.setObtainmeasure(cpform.getObtainmeasure()[i]);
                cp.setTotalmeasure(cpform.getTotalmeasure()[i]);
                cp.setPerformancedate(d);

                result = cdao.savePerformanceSheet(cp);
                if (result == false) {
                    break;
                }


            }

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }
            target = "success";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    public ActionForward getReportForPerformancesheet(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();

        AppraisalReportUtil aru = new AppraisalReportUtil();
        HttpSession session = request.getSession();
        AppraisalEmpInfo emppojo = new AppraisalEmpInfo();
        String target = null;
        String empid = request.getParameter("empid");
        String indicatorname = request.getParameter("indicatorname");
        List<AppraisalResultSum> appsum = null;
        try {
            if (indicatorname.equals("Appraisal")) {
                appsum = aru.getAppraisalReport(empid);
                request.setAttribute("appraisalReport", appsum);
                target = "app";
            } else if (indicatorname.equals("TimeSheet")) {
                target = "time";

            }


        } catch (DAOException doe) {
            log.error("critical error " + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }

        return mapping.findForward(target);


    }

    public ActionForward loadTimesheetDetail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        TimeSheetDAO tsdao = factory.createTimeSheetManager();

        CompensationPerformanceSheetForm cpform = (CompensationPerformanceSheetForm) form;
        List<Timesheetutil> tsutil = new ArrayList<Timesheetutil>();


        List<EmployeeMaster> emplist = null;
        List<TimesheetDetail> tslist = null;
        HttpSession session = request.getSession(true);
        try {


            String empid = cpform.getEmpid();
            tslist = tsdao.getTimesheetDetailByIdAndDate(empid, cpform.getTimesheetdate());
            for (TimesheetDetail obj : tslist) {
                Timesheetutil u = new Timesheetutil();
                u.setTimesheetdetailid(obj.getTimesheetdetailid().intValue());
                u.setApprovestatus(obj.getApprovestatus());
                u.setDescription(obj.getDescription());
                u.setEmpid(obj.getEmpid());
                u.setOvertimestatus(obj.getOvertimestatus());
                u.setProjectid(obj.getProjectid().intValue());
                u.setTimesheetdate(obj.getTimesheetdate());
                u.setTimesheetheaderid(obj.getTimesheetheaderid().intValue());
                u.setTimeslot(obj.getTimeslot());

                tsutil.add(u);
            }

            request.setAttribute("detail", tsutil);


            target = "finalize";
        } catch (Exception e) {
            log.error("error from Exception class " + e);
        }
        return mapping.findForward(target);
    }

    double roundTwoDecimals(double d) {
        DecimalFormat twoDForm = new DecimalFormat("#.##");
        return Double.valueOf(twoDForm.format(d));
    }

    public ActionForward scoreCalculation(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompensationDao cdao = factory.createCompensationManager();
        CompensationPerformanceSheetForm cpform = (CompensationPerformanceSheetForm) form;
        List<CompensationPerformancesheet> performanceList = null;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();

        Double sum = 0.0;
        boolean result;
        try {
            String empid = cpform.getEmpid();
            performanceList = cdao.scorecalculation(empid);
            int length = performanceList.size();
            Date d = new Date();
            for (int i = 0; i < length; i++) {
                Double obtain = Double.parseDouble(performanceList.get(i).getObtainmeasure().toString());
                Double total = Double.parseDouble(performanceList.get(i).getTotalmeasure().toString());
                Double percentscore = (obtain * 100) / total;
                sum = sum + percentscore;
            }
            Double finalscore = roundTwoDecimals(sum / length);

            CompensationCalculatedScore c = new CompensationCalculatedScore();
            c.setEmpid(empid);
            c.setScore(finalscore.intValue());
            c.setScorecalculationdate(d);
            c.setId(cdao.getLastIdForcalculation() + 1);
            result = cdao.savecalculatedscore(c);
            String message = empid;
            String score = finalscore.toString();
            request.setAttribute("emp", message);
            request.setAttribute("score", score);

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "calculation";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "calculation";
            }
            target = "calculation";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getIncrementBand(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompensationDao cdao = factory.createCompensationManager();
        CompanyDAO comdao = factory.createCompanyManager();
        DepartmentDAO ddao = factory.departmentManager();
        DesignationDAO desigdao = factory.designationManager();
        Company compojo = null;
        Department dpojo = null;
        DesignationMaster desigpojo = null;
        List<IndicatorBandUtil> iutil = new ArrayList<IndicatorBandUtil>();


        compensationForm cform = (compensationForm) form;
        List<CompensationIncrementBand> clist = null;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        try {
            clist = cdao.getIncrementBand();
            for (CompensationIncrementBand obj : clist) {
                IndicatorBandUtil i = new IndicatorBandUtil();
                compojo = comdao.getCompany(obj.getCompany());
                i.setCompanyname(compojo.getCompanyName());
                dpojo = ddao.getDepartment(obj.getDepartment());
                i.setDepartmentname(dpojo.getDepartmentName());
                desigpojo = desigdao.getDesignation(obj.getDesignation());
                i.setDesignationname(desigpojo.getDesignationName());
                i.setFrom(obj.getFrom());
                i.setTo(obj.getTo());
                i.setIncrement(obj.getIncrement());
                i.setIncrementdatefrom(obj.getIncrementdatefrom());
                i.setIncrementdateto(obj.getIncrementdateto());
                i.setId(obj.getId());
                iutil.add(i);


            }

            request.setAttribute("incrementband", iutil);
            target = "indicatorband";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward startincrementcycle(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompensationDao cdao = factory.createCompensationManager();
        compensationForm cform = (compensationForm) form;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        List<CompensationIncrementBand> td;
        CompensationIncrementBand cib = new CompensationIncrementBand();
        List<Timesheetutil> tsutil = new ArrayList<Timesheetutil>();

        boolean result = true;
        try {

            List<Integer> id = new ArrayList<Integer>();
            td = cdao.getIncrementBand();
            for (CompensationIncrementBand t : td) {
                id.add(t.getId());
            }

            Integer[] checked = cform.getChecked();
            int l = checked.length;
            Integer[] chi = new Integer[l];

            for (int i = 0; i < l; i++) {
                CompensationIncrementBand cibpojo = cdao.getIncrementBand(checked[i]);
                chi[i] = checked[i];
                cibpojo.setStatus("approved");
                cdao.save(cibpojo);
            }
            int k = 0;
            for (Integer i : id) {
                Boolean flag = false;
                for (int j = 0; j < chi.length; j++) {
                    if (i.equals(chi[j])) {
                        flag = true;
                        break;
                    }
                }
                if (!flag) {
                    CompensationIncrementBand cibpojo = cdao.getIncrementBand(i);

                    cibpojo.setStatus("disapproved");
                    cdao.save(cibpojo);
                }
                k++;
            }


            /* td = tsdao.getTimesheetDetailByIdAndDate(tsdform.getEmployeeId(),tsdform.getTimesheetdate());
            int l2 = td.size();
            for (int i = 0; i <l2; i++) {
            td.get(i).setApprovestatus("approved");
            result = tsdao.saveTimesheetDeail(td.get(i));
            if (result == false) {
            break;
            }
            }*/


            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "approve";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "approve";
            }
            target = "approve";
        } catch (Exception e) {
            log.error("error from Exception class " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward addindicator(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompensationDao cdao = factory.createCompensationManager();
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        AddcompensationIndicatorMasterForm aform = (AddcompensationIndicatorMasterForm) form;
        String indicatorname[] = aform.getIndicator();
        CompensationIndicatorMaster cimpojo = new CompensationIndicatorMaster();
        boolean result = false;

        try {
            for (int i = 0; i < indicatorname.length; i++) {
                cimpojo.setId(cdao.getLastIdForIndicatormaster() + 1);
                cimpojo.setIndicator(indicatorname[i]);
                result = cdao.saveindicatormaster(cimpojo);
                if (result == false) {
                    break;
                }
            }

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "success";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "success";
            }
            target = "success";


        } catch (Exception e) {
            log.error("error saving timesheet data " + e.getMessage());
        }
        return mapping.findForward(target);
    }

    public ActionForward forward(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            target = "forward";
        } catch (Exception e) {
            log.error("error saving timesheet data " + e.getMessage());

        }
        return mapping.findForward(target);

    }

    public ActionForward viewPerformancetarget(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        CompensationDao cdao = factory.createCompensationManager();

        CompanyDAO comdao = factory.createCompanyManager();
        DepartmentDAO ddao = factory.departmentManager();
        DesignationDAO desigdao = factory.designationManager();
        EmployeeMasterDAO empdao = factory.createEmployeeMasterManager();
        BranchDAO bdao = factory.createBranchManager();
        EmployeeMaster emppojo = null;
        BranchMaster bpojo = null;
        HttpSession session = request.getSession();
        String empid = (String) session.getAttribute("user_id");
        Integer companyid = null;
        Integer departmentid = null;
        Integer designationid = null;
        List<CompensationPerformanceIndicator> cpilist = null;
        List<compensationutil> cutil = new ArrayList<compensationutil>();
        try {
            emppojo = empdao.getEmployeeMasterByEmpId(empid);
            departmentid = (emppojo.getDepartmentId()).intValue();
            designationid = emppojo.getDesignationId();
            bpojo = bdao.getBranch(emppojo.getBranchId());
            companyid = bpojo.getCompany().getCompanyCode().intValue();
            List incrementband = cdao.getIncrementBand(companyid, departmentid, designationid);
            request.setAttribute("targetincrement", incrementband);

            cpilist = cdao.getperformanceIndicator(companyid, departmentid, designationid);
            for (CompensationPerformanceIndicator cpi : cpilist) {
                compensationutil c = new compensationutil();
                Integer indicatorid = cpi.getIndicator();
                CompensationIndicatorMaster cim = cdao.getIndicatorById(indicatorid);
                c.setIndicatorname(cim.getIndicator());
                c.setTotalmeasure(cpi.getMeasure());
                cutil.add(c);
            }

            request.setAttribute("targetperformance", cutil);

            target = "finalize";
        } catch (Exception e) {
            log.error("error from Exception class " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward genAwardLetter(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DAOFactory factory=new DAOFactory();
        EmployeeMasterDAO emdao=factory.createEmployeeMasterManager();
        EmployeeMaster em=null;
        CompensationPerformanceSheetForm cpsf=(CompensationPerformanceSheetForm)form;
        String empid=null;
        Double score=null;
        Document doc=new Document(PageSize.A4, 50, 50, 50, 50);;
        try {
            empid=cpsf.getEmpid();
            score=cpsf.getScore();
            em=emdao.getEmployeeMasterByEmpId(empid);
            String name=em.getFirstName()+" "+em.getLastName();
            ServletOutputStream servletOutputStream =response.getOutputStream();

            response.setContentType("application/pdf");
            
           PdfWriter pw=PdfWriter.getInstance(doc, servletOutputStream);
           
            doc.open();
            doc.add(new Paragraph("Dear"));
           
            doc.add(new Paragraph("     "+name));
            doc.add(new Paragraph("     Employee Id: "+empid));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("The management is pleased to inform you that your salary has been revised w.e.f. the next month. Your increased salary w.e.f. the next month stands as per the break-up given below: "));
            doc.add(new Paragraph("You can mention the break-up as per revised structure. If the bonus/incentive is included in the CTC you can mention it in the break-up otherwise you can write below the break-up."));
            doc.add(new Paragraph("The management looks forward to your continued good performance & support."));
            doc.add(new Paragraph("Wishing you & your family a great year ahead"));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("With Regards"));
            doc.add(new Paragraph(" "));
            doc.add(new Paragraph("Authorised Signatory"));
            pw.flush();
            pw.close();

           servletOutputStream.flush();
           servletOutputStream.close(); 
             doc.close();
        } catch (Exception e) {
            log.error("error creating award letter "+e);
        }
      
        return null;
    }
}
