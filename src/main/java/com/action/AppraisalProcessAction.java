package com.action;

import com.dao.AppraisalEmpInfoDAO;
import com.dao.AppraisalQuestionsDAO;
import com.dao.AppraisalResultDAO;
import com.dao.AppraisalSelfDAO;
import com.dao.AppraisalSetupDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.forms.AppraisalResultForm;
import com.forms.AppraisalResultSumForm;
import com.pojo.AppraisalEmpInfo;
import com.pojo.AppraisalQuestions;
import com.pojo.AppraisalResult;
import com.pojo.AppraisalResultSum;
import com.pojo.AppraisalSelf;
import com.pojo.AppraisalSetup;
import com.pojo.selfAppraisalResult;
import com.pojo.Attendence;
import com.util.AppraisalReportUtil;
import java.util.Date;
import java.util.Calendar;
import java.util.List;
import java.util.ListIterator;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionMessage;
import com.dao.AttendanceDAO;
import com.dao.BaseDAO;
import com.util.Attendanceutil;
import com.pojo.Attendence;
import com.util.appraisalresultutil;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import com.util.Appraisalutil;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import java.util.*;
import java.io.*;
import javax.servlet.ServletOutputStream;
import net.sf.jasperreports.engine.query.JRHibernateQueryExecuterFactory;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalProcessAction extends DispatchAction {

    public ActionForward getSetupInfo(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalEmpInfo emppojo = new AppraisalEmpInfo();
        com.util.AppraisalReportUtil report = new com.util.AppraisalReportUtil();
        HttpSession session = request.getSession();
        AppraisalSetupDAO setupdao = factory.createAppraisalSetupManager();
        AppraisalEmpInfoDAO empdao = factory.createAppraisalEmpInfoManager();
        AppraisalQuestionsDAO questiondao = factory.createAppraisalQuestionsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        int designation_id = 0;
        int department_id = 0;
        String uid = (String) session.getAttribute("user_id");
        String appraisee_id = (String) request.getParameter("appraisee_id");
        session.setAttribute("appraisee_id", appraisee_id);
        List<AppraisalEmpInfo> empinfo = null;
        List<AppraisalEmpInfo> appraiseeInfo = null;
        List<AppraisalSetup> setup = null;
        List<AppraisalQuestions> QuestionsList = null;
        List<AppraisalResultSum> appraisalReport = null;
        AppraisalSetup appraisalSetup = new AppraisalSetup();
        try {
            empinfo = empdao.getEmployeeDetails(uid);
            appraiseeInfo = empdao.getEmployeeDetails(appraisee_id);
            session.setAttribute("appraiseeInfo", appraiseeInfo);
            ListIterator itr = empinfo.listIterator();
            while (itr.hasNext()) {
                emppojo = (AppraisalEmpInfo) itr.next();
                designation_id = emppojo.getDesignation_id();
                department_id = emppojo.getDepartment_id();
            }
            setup = setupdao.getAllAppraisalSetup(designation_id, department_id);
            request.setAttribute("setup", setup);
            ListIterator litr = setup.listIterator();
            int i = 0;
            String questions = null;
            while (litr.hasNext()) {
                appraisalSetup = (AppraisalSetup) litr.next();
                QuestionsList = questiondao.getQuestionsbyCategory(appraisalSetup.getCategory_id());
                questions = "questions" + i;
                request.setAttribute(questions, QuestionsList);
                i++;
            }
            appraisalReport = report.getAppraisalReport(appraisee_id);
            session.setAttribute("appraisalReport", appraisalReport);
            target = "success";
        } catch (DAOException doe) {            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        return mapping.findForward(target);
    }

    public ActionForward submitForm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalResultDAO dao = factory.createAppraisalResultManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        String target = null;
        String appraisee_id = (String) request.getAttribute("appraisee_id");
        AppraisalResultForm appraisalform = (AppraisalResultForm) form;
        int category_code[] = appraisalform.getCategory_code();
        int question_code[] = appraisalform.getQuestion_code();
        String answer[] = appraisalform.getAnswer();
        try {
            for (int i = 0; i < answer.length; i++) {
                AppraisalResult appraisalResult = new AppraisalResult();
                appraisalResult.setCategory_code(category_code[i]);
                appraisalResult.setQuestion_code(question_code[i]);
                appraisalResult.setEmployee_code(appraisee_id);
                appraisalResult.setAnswer(answer[i]);
                dao.save(appraisalResult);
            }
            // session.removeAttribute(appraisee_id);
            target = "success";
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        return mapping.findForward(target);
    }

    /*
    public ActionForward getDetailrRport(ActionMapping mapping, ActionForm form,
    HttpServletRequest request, HttpServletResponse response)
    throws Exception {
    DAOFactory factory = new DAOFactory();
    // AppraisalResultDAO resultdao = factory.createAppraisalResultManager();
    ActionErrors errors = new ActionErrors();
    ActionMessages messages = new ActionMessages();
    String target = null;
    List<AppraisalResult> result = null;
    AppraisalResultForm appraisalform = (AppraisalResultForm) form;
    try {
    result = resultdao.getAppraisalResultbyEmployee(appraisalform.getEmployee_code());
    request.setAttribute("result", result);
    target = "success";
    } catch (DAOException doe) {            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
    log.error("critical error" + doe);
    } catch (Exception e) {
    e.printStackTrace();            // Report the error using the appropriate name and ID.
    //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
    log.error("error From ExceptionClass " + e);

    }
    return mapping.findForward(target);
    }
     */
    public ActionForward getReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();

        AppraisalReportUtil aru = new AppraisalReportUtil();
        HttpSession session = request.getSession();
        AppraisalEmpInfo emppojo = new AppraisalEmpInfo();
        String target = null;
        List<AppraisalEmpInfo> appraiseinfo = (List<AppraisalEmpInfo>) session.getAttribute("appraiseeInfo");
        List<AppraisalResultSum> appsum = null;
        String appraisee_id = null;
        ListIterator itr = appraiseinfo.listIterator();
        while (itr.hasNext()) {
            emppojo = (AppraisalEmpInfo) itr.next();
            appraisee_id = emppojo.getEmployee_id();
        }
        try {
            appsum = aru.getAppraisalReport(appraisee_id);
            request.setAttribute("appraisalReport", appsum);
            target = "success";
        } catch (DAOException doe) {
            log.error("critical error " + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }

        return mapping.findForward(target);
    }

    public ActionForward getAttendance(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AttendanceDAO adao = factory.createAttendanceManager();
        AppraisalEmpInfoDAO empdao = factory.createAppraisalEmpInfoManager();
        AppraisalSetupDAO setupdao = factory.createAppraisalSetupManager();

        AppraisalEmpInfoDAO aei = null;
        HttpSession session = request.getSession();
        AppraisalEmpInfo emppojo = new AppraisalEmpInfo();


        String target = null;
        String appid = null;
        int designation_id = 0;
        int department_id = 0;
        String duration;
        int m = 0;
        appid = session.getAttribute("appraisee_id").toString();
        AppraisalResultSum appsum = null;
        List<Attendence> att = null;

        List<AppraisalEmpInfo> appraiseeInfo = null;
        List<AppraisalSetup> setup = null;
        List<AppraisalQuestions> QuestionsList = null;
        List<AppraisalResultSum> appraisalReport = null;
        AppraisalSetup appraisalSetup = new AppraisalSetup();
        Attendence attendence = new Attendence();


        try {

            appraiseeInfo = empdao.getEmployeeDetails(appid);
            session.setAttribute("appraiseeInfo", appraiseeInfo);
            ListIterator itr = appraiseeInfo.listIterator();
            while (itr.hasNext()) {
                emppojo = (AppraisalEmpInfo) itr.next();
                designation_id = emppojo.getDesignation_id();
                department_id = emppojo.getDepartment_id();
            }
            setup = setupdao.getAllAppraisalSetup(designation_id, department_id);
            ListIterator it = setup.listIterator();

            while (it.hasNext()) {
                appraisalSetup = (AppraisalSetup) it.next();

                duration = appraisalSetup.getDuration().trim();

                if (duration.equals("H")) {
                    int q = 6;
                    m = q > m ? q : m;
                } else if (duration.equals("Y")) {
                    int q = 12;
                    m = q > m ? q : m;
                } else if (duration.equals("Q")) {
                    int q = 3;
                    m = q > m ? q : m;
                }

//                  if (duration.equals("Q")){
//
//                      if(duration.equals("H")){
//                          if(duration.equals("Y")){
//                              m=12;
//
//                      }
//
//                      }
//                  }else if(duration.equals("Q")){
//                       if(duration.equals("H")){
//
//                      m=6;
//                  }else if(duration.equals("Q")){
//                      m=3;
//                  }
//                 else if(duration.equals("H")){
//                      m=6;
//                  }
//                       else if(duration.equals("Y")){
//                      m=12;
//                  }



                //             }
            }
            int totalHour = 240 * m;
            att = adao.getAttendance(appid, m);
            request.setAttribute("attendance", att);

            ListIterator itutil = att.listIterator();

            int absent = 0;
            List<Attendanceutil> attli = new ArrayList<Attendanceutil>();

            while (itutil.hasNext()) {
                Attendanceutil a = new Attendanceutil();
                attendence = (Attendence) itutil.next();
                a.setEmpCode(attendence.getEmpCode());
                a.setEmpName(attendence.getEmpName());
                a.setId(attendence.getId().intValue());
                a.setOvertimeHrs(attendence.getOvertimeHrs().intValue());
                a.setTotalHrs(attendence.getTotalHrs().intValue());
                a.setRegularHrs(attendence.getRegularHrs().intValue());
                a.setAttendanceDate(attendence.getAttendanceDate());

                DateFormat d = new SimpleDateFormat("dd/MMM/yyyy");
                String month = d.format(attendence.getAttendanceDate()).split("/")[1];
                a.setMonth(month);
                absent = (240 - (attendence.getRegularHrs().intValue()));
                a.setAbsent(absent);
                a.setTotalregularhrs(totalHour);

                attli.add(a);

            }
            request.setAttribute("attendanceutil", attli);
            /*AppraisalEmpInfo aeipojo=null;

            try {
            AttendanceDAOImpl a=new AttendanceDAOImpl();
            aeipojo=a.getAppraisalInfo(appid);
            int designationid= aeipojo.getDesignation_id();*/


            target = "success";
        } catch (DAOException doe) {
            log.error("critical error " + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }

        return mapping.findForward(target);
    }

    public ActionForward getEmpDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalEmpInfoDAO empdao = factory.createAppraisalEmpInfoManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        String eid = request.getParameter("ec");
        List<AppraisalEmpInfo> empinfo = null;
        AppraisalSetup appraisalSetup = new AppraisalSetup();
        try {
            empinfo = empdao.getEmployeeDetails(eid);
            request.setAttribute("empinfo", empinfo);
            target = "success";
        } catch (DAOException doe) {            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        return mapping.findForward(target);
    }

    public ActionForward getSelfAppraisalSetup(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalEmpInfo emppojo = new AppraisalEmpInfo();
        HttpSession session = request.getSession();
        AppraisalSetupDAO setupdao = factory.createAppraisalSetupManager();
        AppraisalEmpInfoDAO empdao = factory.createAppraisalEmpInfoManager();
        AppraisalQuestionsDAO questiondao = factory.createAppraisalQuestionsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        int department_id = 0;
        String uid = (String) session.getAttribute("user_id");
        List<AppraisalEmpInfo> empinfo = null;
        List<AppraisalSetup> setup = null;
        List<AppraisalQuestions> QuestionsList = null;
        AppraisalSetup appraisalSetup = new AppraisalSetup();
        try {
            empinfo = empdao.getEmployeeDetails(uid);
            session.setAttribute("empinfo", empinfo);
            ListIterator itr = empinfo.listIterator();
            while (itr.hasNext()) {
                emppojo = (AppraisalEmpInfo) itr.next();
                department_id = emppojo.getDepartment_id();
            }
            setup = setupdao.getAllSelfAppraisalSetup(department_id);
            request.setAttribute("setup", setup);
            ListIterator litr = setup.listIterator();
            int i = 0;
            String questions = null;
            while (litr.hasNext()) {
                appraisalSetup = (AppraisalSetup) litr.next();
                QuestionsList = questiondao.getQuestionsbyCategory(appraisalSetup.getCategory_id());
                questions = "questions" + i;
                request.setAttribute(questions, QuestionsList);
                i++;
            }
            target = "success";
        } catch (DAOException doe) {            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        return mapping.findForward(target);
    }

    public ActionForward loadSelfAppraisalSetup(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalEmpInfo emppojo = new AppraisalEmpInfo();
        HttpSession session = request.getSession();
        AppraisalSetupDAO setupdao = factory.createAppraisalSetupManager();
        AppraisalEmpInfoDAO empdao = factory.createAppraisalEmpInfoManager();
        AppraisalQuestionsDAO questiondao = factory.createAppraisalQuestionsManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        String target = null;
        int designation_id = 0;
        int department_id = 0;
        String uid = (String) session.getAttribute("user_id");
        List<AppraisalEmpInfo> empinfo = null;
        List<AppraisalSetup> setup = null;
        List<AppraisalQuestions> QuestionsList = null;
        AppraisalSetup appraisalSetup = new AppraisalSetup();
        try {
            empinfo = empdao.getEmployeeDetails(uid);
            session.setAttribute("empinfo", empinfo);
            ListIterator itr = empinfo.listIterator();
            while (itr.hasNext()) {
                emppojo = (AppraisalEmpInfo) itr.next();
                department_id = emppojo.getDepartment_id();
                designation_id = emppojo.getDesignation_id();
            }
            setup = setupdao.getSelfAppraisalSetup(designation_id, department_id);
            request.setAttribute("setup", setup);
            ListIterator litr = setup.listIterator();
            int i = 0;
            String questions = null;
            while (litr.hasNext()) {
                appraisalSetup = (AppraisalSetup) litr.next();
                QuestionsList = questiondao.getQuestionsbyCategory(appraisalSetup.getCategory_id());
                questions = "questions" + i;
                request.setAttribute(questions, QuestionsList);
                i++;
            }
            target = "success";
        } catch (DAOException doe) {            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error",doe.getMessage()));
            log.error("critical error" + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        return mapping.findForward(target);
    }

    public ActionForward submitSelfAppraisalForm(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalSelfDAO dao = factory.createAppraisalSelftManager();
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        HttpSession session = request.getSession();
        String target = null;
        String appraisee_id = (String) session.getAttribute("user_id");
        AppraisalResultForm appraisalform = (AppraisalResultForm) form;
        int category_code[] = appraisalform.getCategory_code();
        int question_code[] = appraisalform.getQuestion_code();
        String answer[] = appraisalform.getAnswer();
        try {
            for (int i = 0; i < answer.length; i++) {
                AppraisalSelf appraisalSelf = new AppraisalSelf();
                appraisalSelf.setCategory_code(category_code[i]);
                appraisalSelf.setQuestion_code(question_code[i]);
                appraisalSelf.setEmployee_code(appraisee_id);
                appraisalSelf.setAnswer(answer[i]);
                dao.save(appraisalSelf);
            }
            target = "success";
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);

        }
        return mapping.findForward(target);
    }

    public ActionForward getAppraisalSummary(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalResultDAO appdao = factory.createAppraisalResultManager();
        String target = null;
        AppraisalResultSumForm af = (AppraisalResultSumForm) form;
        HttpSession session = request.getSession();

        try {
            List<AppraisalResultSum> applist = null;
            applist = appdao.getAllAppraisalResultSum();
            af.setAppsumList(applist);
            session.setAttribute("appList", applist);
            target = "success";
        } catch (DAOException doe) {
            log.error("critical error" + doe);
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward saveAppraisalMarks(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalResultDAO appdao = factory.createAppraisalResultManager();
        String target = null;
        AppraisalResultForm af = (AppraisalResultForm) form;
        AppraisalResultSum asumpojo = null;
        AppraisalResult appraisalResult = new AppraisalResult();
        boolean result = true;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        HttpSession session = request.getSession();
        try {
            int length = af.getAnswer().length;
            int sum = 0;
            for (int i = 0; i < length; i++) {
                String p = af.answer[i];
                int q = Integer.parseInt(p);
                appraisalResult.setId(appdao.getLastId() + 1);
                appraisalResult.setCategory_code(af.getCategory_code()[i]);
                appraisalResult.setQuestion_code(af.getQuestion_code()[i]);
                appraisalResult.setAnswer(af.getAnswer()[i]);
                appraisalResult.setEmployee_code(session.getAttribute("appraisee_id").toString());
                appraisalResult.setAppraisedate(new Date());
                appdao.save(appraisalResult);
                if (result == false) {
                    break;
                }
            }

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "save";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "save";
            }
            target = "save";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward saveSelfAppraisalMarks(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalResultDAO appdao = factory.createAppraisalResultManager();
        String target = null;
        AppraisalResultForm af = (AppraisalResultForm) form;
        AppraisalResultSum asumpojo = null;
        selfAppraisalResult selfappraisalResult = new selfAppraisalResult();
        boolean result = true;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        HttpSession session = request.getSession();
        try {
            int length = af.getAnswer().length;
            int sum = 0;
            for (int i = 0; i < length; i++) {
                String p = af.answer[i];
                int q = Integer.parseInt(p);
                selfappraisalResult.setId(appdao.getselfLastId() + 1);
                selfappraisalResult.setCategory_code(af.getCategory_code()[i]);
                selfappraisalResult.setQuestion_code(af.getQuestion_code()[i]);
                selfappraisalResult.setAnswer(af.getAnswer()[i]);
                selfappraisalResult.setEmployee_code(session.getAttribute("user_id").toString());
                selfappraisalResult.setAppraisedate(new Date());
                appdao.selfsave(selfappraisalResult);
                if (result == false) {
                    break;
                }
            }

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "save";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "save";
            }
            target = "save";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward calculateMarks(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalResultDAO appdao = factory.createAppraisalResultManager();
        String target = null;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        AppraisalResultSum asumpojo = new AppraisalResultSum();

        HttpSession session = request.getSession();
        String empid = session.getAttribute("appraisee_id").toString();
        List<appraisalresultutil> appraisalResult = null;
        boolean result = true;

        Date d = new Date();
         DateFormat da=new SimpleDateFormat("dd/MM/yyyy");
       String dt=da.format(d);
      String [] stdt= dt.split("/");

        try {
            appraisalResult = appdao.calculatesum(d, empid);
            int length = appraisalResult.size();
            for (int i = 0; i < length; i++) {

                asumpojo.setId(appdao.getLastIdForSum() + 1);
                 asumpojo.setEmployee_code(empid);
                asumpojo.setScore(appraisalResult.get(i).getPercentage());
                asumpojo.setCategory_code(appraisalResult.get(i).getCategorycode());
                asumpojo.setCategory_name(appraisalResult.get(i).getCategoryname());
                asumpojo.setMonth_of_appraisal(Integer.parseInt(stdt[1]));
                asumpojo.setYear_of_appraisal(Integer.parseInt(stdt[2]));
                asumpojo.setAppraisal_date(d);
                appdao.saveAppraisalResultsum(asumpojo);
                if (result == false) {
                    break;
                }

            }

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "save";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "save";
            }
            target = "save";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getAppraisalReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
       AppraisalResultDAO appdao = factory.createAppraisalResultManager();
      List< Appraisalutil> aru = new ArrayList<Appraisalutil>();
        HttpSession session = request.getSession();
        AppraisalEmpInfo emppojo = new AppraisalEmpInfo();
        String target = null;
        List<AppraisalEmpInfo> appraiseinfo = (List<AppraisalEmpInfo>) session.getAttribute("appraiseeInfo");
        List<AppraisalResultSum> appsum = null;
        String appraisee_id = null;
        ListIterator itr = appraiseinfo.listIterator();
        while (itr.hasNext()) {
            emppojo = (AppraisalEmpInfo) itr.next();
            appraisee_id = emppojo.getEmployee_id();
        }
        try {
            aru = appdao.appraisalgraph( appraisee_id );
            request.setAttribute("appraisalReport", aru);
            target = "success";
        } catch (DAOException doe) {
            log.error("critical error " + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }

        return mapping.findForward(target);
    }
     public ActionForward selfcalculateMarks(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        DAOFactory factory = new DAOFactory();
        AppraisalResultDAO appdao = factory.createAppraisalResultManager();
        String target = null;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        AppraisalResultSum asumpojo = new AppraisalResultSum();

        HttpSession session = request.getSession();
        String empid = session.getAttribute("user_id").toString();
        List<appraisalresultutil> appraisalResult = null;
        boolean result = true;

        Date d = new Date();
         DateFormat da=new SimpleDateFormat("dd/MM/yyyy");
       String dt=da.format(d);
      String [] stdt= dt.split("/");

        try {
            appraisalResult = appdao.calculatesum(d, empid);
            int length = appraisalResult.size();
            for (int i = 0; i < length; i++) {

                asumpojo.setId(appdao.getLastIdForSum() + 1);
                 asumpojo.setEmployee_code(empid);
                asumpojo.setScore(appraisalResult.get(i).getPercentage());
                asumpojo.setCategory_code(appraisalResult.get(i).getCategorycode());
                asumpojo.setCategory_name(appraisalResult.get(i).getCategoryname());
                asumpojo.setMonth_of_appraisal(Integer.parseInt(stdt[1]));
                asumpojo.setYear_of_appraisal(Integer.parseInt(stdt[2]));
                asumpojo.setAppraisal_date(d);
                appdao.saveAppraisalResultsum(asumpojo);
                if (result == false) {
                    break;
                }

            }

            if (result == true) {
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                saveMessages(request, messages);
                target = "selfsave";

            } else {
                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                saveErrors(request, messages);
                target = "selfsave";
            }
            target = "selfsave";

        } catch (Exception e) {
            log.error("error saving timesheet data " + e);
        }
        return mapping.findForward(target);
    }
     public ActionForward getSelfAttendance(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        AttendanceDAO adao = factory.createAttendanceManager();
        AppraisalEmpInfoDAO empdao = factory.createAppraisalEmpInfoManager();
        AppraisalSetupDAO setupdao = factory.createAppraisalSetupManager();

        AppraisalEmpInfoDAO aei = null;
        HttpSession session = request.getSession();
        AppraisalEmpInfo emppojo = new AppraisalEmpInfo();


        String target = null;
        String appid = null;
        int designation_id = 0;
        int department_id = 0;
        String duration;
        int m = 0;
        appid = session.getAttribute("user_id").toString();
        AppraisalResultSum appsum = null;
        List<Attendence> att = null;

        List<AppraisalEmpInfo> appraiseeInfo = null;
        List<AppraisalSetup> setup = null;
        List<AppraisalQuestions> QuestionsList = null;
        List<AppraisalResultSum> appraisalReport = null;
        AppraisalSetup appraisalSetup = new AppraisalSetup();
        Attendence attendence = new Attendence();


        try {

            appraiseeInfo = empdao.getEmployeeDetails(appid);
            session.setAttribute("appraiseeInfo", appraiseeInfo);
            ListIterator itr = appraiseeInfo.listIterator();
            while (itr.hasNext()) {
                emppojo = (AppraisalEmpInfo) itr.next();
                designation_id = emppojo.getDesignation_id();
                department_id = emppojo.getDepartment_id();
            }
            setup = setupdao.getAllAppraisalSetup(designation_id, department_id);
            ListIterator it = setup.listIterator();

            while (it.hasNext()) {
                appraisalSetup = (AppraisalSetup) it.next();

                duration = appraisalSetup.getDuration().trim();

                if (duration.equals("H")) {
                    int q = 6;
                    m = q > m ? q : m;
                } else if (duration.equals("Y")) {
                    int q = 12;
                    m = q > m ? q : m;
                } else if (duration.equals("Q")) {
                    int q = 3;
                    m = q > m ? q : m;
                }

//                  if (duration.equals("Q")){
//
//                      if(duration.equals("H")){
//                          if(duration.equals("Y")){
//                              m=12;
//
//                      }
//
//                      }
//                  }else if(duration.equals("Q")){
//                       if(duration.equals("H")){
//
//                      m=6;
//                  }else if(duration.equals("Q")){
//                      m=3;
//                  }
//                 else if(duration.equals("H")){
//                      m=6;
//                  }
//                       else if(duration.equals("Y")){
//                      m=12;
//                  }



                //             }
            }
            int totalHour = 240 * m;
            att = adao.getAttendance(appid, m);
            request.setAttribute("attendance", att);

            ListIterator itutil = att.listIterator();

            int absent = 0;
            List<Attendanceutil> attli = new ArrayList<Attendanceutil>();

            while (itutil.hasNext()) {
                Attendanceutil a = new Attendanceutil();
                attendence = (Attendence) itutil.next();
                a.setEmpCode(attendence.getEmpCode());
                a.setEmpName(attendence.getEmpName());
                a.setId(attendence.getId().intValue());
                a.setOvertimeHrs(attendence.getOvertimeHrs().intValue());
                a.setTotalHrs(attendence.getTotalHrs().intValue());
                a.setRegularHrs(attendence.getRegularHrs().intValue());
                a.setAttendanceDate(attendence.getAttendanceDate());

                DateFormat d = new SimpleDateFormat("dd/MMM/yyyy");
                String month = d.format(attendence.getAttendanceDate()).split("/")[1];
                a.setMonth(month);
                absent = (240 - (attendence.getRegularHrs().intValue()));
                a.setAbsent(absent);
                a.setTotalregularhrs(totalHour);

                attli.add(a);

            }
            request.setAttribute("attendanceutil", attli);
            /*AppraisalEmpInfo aeipojo=null;

            try {
            AttendanceDAOImpl a=new AttendanceDAOImpl();
            aeipojo=a.getAppraisalInfo(appid);
            int designationid= aeipojo.getDesignation_id();*/


            target = "selfsuccess";
        } catch (DAOException doe) {
            log.error("critical error " + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }

        return mapping.findForward(target);
    }
     public ActionForward getselfAppraisalReport(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
       AppraisalResultDAO appdao = factory.createAppraisalResultManager();
      List< Appraisalutil> aru = new ArrayList<Appraisalutil>();
        HttpSession session = request.getSession();
        AppraisalEmpInfo emppojo = new AppraisalEmpInfo();
        String target = null;
        String empid=session.getAttribute("user_id").toString();


        try {
            aru = appdao.appraisalgraph(empid);
            request.setAttribute("appraisalReport", aru);
            target = "selfsuccess";
        } catch (DAOException doe) {
            log.error("critical error " + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }

        return mapping.findForward(target);
    }
      public ActionForward getAppraisalResultemployee(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
             DAOFactory factory = new DAOFactory();
       AppraisalResultDAO appdao = factory.createAppraisalResultManager();
       List<AppraisalResultSum> arsum= new ArrayList<AppraisalResultSum>();
       String target=null;
            try{
               arsum= appdao.employeeByAppraisalresultsum();
                request.setAttribute("employee",arsum);
                target="appsumemployee";
          } catch (DAOException doe) {
            log.error("critical error " + doe);
        } catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }

        return mapping.findForward(target);
    }

     public ActionForward getAppraisalReportByCategory(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {


       AppraisalResultSumForm af = (AppraisalResultSumForm) form;
       String target=null;
           try{
               org.hibernate.Session session;
              String employeecode=af.getEmployee_code();
             HashMap parametermap=new HashMap();
             session= new BaseDAO().getSession();
              parametermap.put(JRHibernateQueryExecuterFactory.PARAMETER_HIBERNATE_SESSION,session);
                parametermap.put("ec",employeecode );
               ServletOutputStream sos=response.getOutputStream();
                response.setContentType("application/pdf");
            String repfile=getServlet().getServletConfig().getServletContext().getRealPath("/JasRep/jasperpiechart2.jrxml")  ;
            String destfile=getServlet().getServletConfig().getServletContext().getRealPath("/JasRep/jasperpiechart2.jasper");
            JasperCompileManager.compileReportToFile(repfile,destfile);


               InputStream reportstream=getServlet().getServletContext().getResourceAsStream("/JasRep/jasperpiechart2.jasper");
               JasperRunManager.runReportToPdfStream(reportstream, sos,parametermap);

                 sos.flush();
                 sos.close();
                    target="report";

          }
        catch (Exception e) {
            e.printStackTrace();            // Report the error using the appropriate name and ID.
            //errors.add(ActionErrors.GLOBAL_MESSAGE, new org.apache.struts.action.ActionError("process.error.unknown"));
            log.error("error From ExceptionClass " + e);
        }
         return mapping.findForward(target);
      }




}
