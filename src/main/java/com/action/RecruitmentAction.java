/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.pojo.Recruitment;
import com.forms.RecruitmentForm;
import com.forms.RecruitmentMarksForm;
import com.ImplClass.RecruitmentDAOImpl;
import com.dao.RecruitmentDAO;
import com.dao.BaseDAO;
import com.dao.DAOFactory;
import com.dao.DAOException;
import com.dao.RecruitmentMarksDAO;
import com.dao.EmployeeMasterDAO;
import com.dao.VacanciesDAO;
import com.pojo.RecruitmentMarks;
import com.pojo.vacancies;
import com.pojo.EmployeeMaster;
import com.util.SendingMail;

import java.util.Date;
import java.util.List;

import java.util.Arrays;
import java.util.Iterator;

import com.util.ImageUtil;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.actions.DispatchAction;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author Sumit Kumar
 */
public class RecruitmentAction extends DispatchAction {

    private String target = "";
    private int candidateid;

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward SaveNewCandidate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RecruitmentDAO recdao = factory.createRecruitmentManager();
        RecruitmentForm recform = (RecruitmentForm) form;
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        BaseDAO b = new BaseDAO();
        byte[] databyte = ImageUtil.UploadImage(request, recform);
        try {
            Recruitment rec = new Recruitment();
            rec.setId(recdao.getLastId() + 1);
            rec.setFirstName(recform.getFirstName());
            rec.setMiddleName(recform.getMiddleName());
            rec.setLastName(recform.getLastName());
            rec.setDob(b.mySqlDatebFormat(recform.getDob()));
            rec.setBloodGroup(recform.getBloodGroup());
            rec.setNationality(recform.getNationality());
            rec.setGender(recform.getGender());
            rec.setStatus("applied");
            rec.setPostApplied(recform.getPostApplied());
            rec.setPhoneNo(recform.getPhoneNo());
            rec.setEmailId(recform.getEmailId());
            rec.setCanImage(databyte);
            rec.setSkills(recform.getSkills());
            rec.setExp(recform.getExp());
            rec.setExpdesc(recform.getExpdesc());
            rec.setQuali(recform.getQuali());
            boolean result = recdao.save(rec);

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
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
            saveErrors(request, messages);
            target = "success";
        }

        return mapping.findForward(target);

    }

//    public ActionForward selectCandidate(ActionMapping mapping,ActionForm form,
//            HttpServletRequest request, HttpServletResponse response)
//            throws Exception{
//
//    }
    public ActionForward load(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RecruitmentDAO recdao = factory.createRecruitmentManager();
        RecruitmentForm recform = (RecruitmentForm) form;
        List<Recruitment> reclist = null;
        try {
            reclist = recdao.getAllRecruitmentByStatus("applied");
            request.setAttribute("Candidates", reclist);
            target = "success";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward acceptCandidate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RecruitmentDAO recdao = factory.createRecruitmentManager();
        RecruitmentForm recform = (RecruitmentForm) form;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        Recruitment rc = null;
        try {
            recform.setId(candidateid);
            rc = recdao.getRecruitment(recform.getId());
            rc.setStatus("accepted");
            boolean result = recdao.save(rc);

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
            log.error("error from Exception class " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward rejectCandidate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RecruitmentDAO recdao = factory.createRecruitmentManager();
        RecruitmentForm recform = (RecruitmentForm) form;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        Recruitment rc = null;
        try {
            recform.setId(candidateid);
            rc = recdao.getRecruitment(recform.getId());
            rc.setStatus("rejected");
            boolean result = recdao.save(rc);

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
            log.error("error from Exception class " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward enqueueCandidate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RecruitmentDAO recdao = factory.createRecruitmentManager();
        RecruitmentForm recform = (RecruitmentForm) form;
        ActionMessages messages = new ActionMessages();
        ActionErrors errors = new ActionErrors();
        Recruitment rc = null;
        try {
            recform.setId(candidateid);
            rc = recdao.getRecruitment(recform.getId());
            rc.setStatus("enqueued");
            boolean result = recdao.save(rc);

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
            log.error("error from Exception class " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getSelectedCandidates(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RecruitmentDAO recdao = factory.createRecruitmentManager();
        RecruitmentForm recform = (RecruitmentForm) form;
        List<Recruitment> reclist = null;
        try {
            reclist = recdao.getAllRecruitmentByStatus("accepted");
            request.setAttribute("Candidates", reclist);
            target = "success";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getCandidateDetails(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RecruitmentDAO recdao = factory.createRecruitmentManager();
        RecruitmentForm recform = (RecruitmentForm) form;
        Recruitment rec = null;
        try {
            String id=null;
            try {
                id = request.getParameter("canid").toString();
            } catch (Exception e) {
            }
            if (id != null) {
                recform.setId(Integer.parseInt(id));
            }
            rec = recdao.getRecruitment(recform.getId());
            request.setAttribute("candidate", rec);
            target = "getDetails";
        } catch (Exception e) {
            log.error("error from recruitment candidates " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward searchCandidate(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RecruitmentDAO recdao = factory.createRecruitmentManager();
        RecruitmentForm recform = (RecruitmentForm) form;
        List<Recruitment> rec = null;
        String skills = recform.getSkills();
        try {
            rec = recdao.getRecruitmentBySkill(skills);
            request.setAttribute("candidate", rec);
            target = "success";
        } catch (Exception e) {
            log.error("error from recruitment candidates " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward loadCandiateMarks(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RecruitmentMarksDAO recmdao = factory.createRecruitmentMarksManager();
        RecruitmentForm recmform = (RecruitmentForm) form;
        List<RecruitmentMarks> recmlist = null;
        try {
            candidateid=recmform.getId();
            recmlist = recmdao.getRecruitmentMarksById(candidateid);
           int size=recmlist.size();
          int marks;
          int sum=0;
          for(int i=0;i<=size-1;i++){
 marks=recmlist.get(i).getMarksObt();
          sum=sum+marks;
            }
         
        
          int avg=sum/size;
          String flag="SELECTED";
           for(int i=0;i<=size-1;i++){
               marks=recmlist.get(i).getMarksObt();
          if(marks<60){
              flag="REJECTED";
              break;
          }

          
            }
          if(avg<70){
              flag="REJECTED";
          }
          request.setAttribute("candidateMarks", recmlist);
           request.setAttribute("candidatestatus", flag);

            target = "finalize";
        } catch (Exception e) {
            log.error("error from Exception class " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getAllVacancies(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception{
        DAOFactory factory=new DAOFactory();
        VacanciesDAO vcdao=factory.createVacancyManager();
        List<vacancies> vaclist=null;
        try {
            vaclist=vcdao.getAllVacancies();
            request.setAttribute("vacancies", vaclist);
            target="success";
        } catch (Exception e) {
            log.error("error fetching the vacancies "+e);
        }
        return mapping.findForward(target);
    }
     public ActionForward getAlredyEmployee(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();

        EmployeeMasterDAO empDao = factory.createEmployeeMasterManager();
        RecruitmentForm recform = (RecruitmentForm) form;

        try {

            EmployeeMaster e = empDao.getEmployeeMasterByEmpId("222");




            recform.setFirstName(e.getFirstName());
            recform.setMiddleName(e.getMiddleName());
            recform.setLastName(e.getLastName());
            recform.setDob(e.getDateOfBirth().toString());
            recform.setGender(e.getGender());
            recform.setBloodGroup(e.getBloodGroup());
            recform.setNationality(e.getNationality());
            recform.setPhoneNo(e.getPhNoResidencial());
            recform.setEmailId(e.getEmailAddress());


            target = "success";

        } catch (Exception e) {
            log.error("error displaying recruitment data " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward getAllRecruitment(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RecruitmentDAO recdao = factory.createRecruitmentManager();
        RecruitmentForm recform = (RecruitmentForm) form;
        List<Recruitment> reclist = null;
        try {
            reclist = recdao.getAllRecruitmentByStatus(recform.getStatus());

            request.setAttribute("reclist", reclist);
            target = "success";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward toMultipleMail(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        DAOFactory factory = new DAOFactory();
        RecruitmentDAO recdao = factory.createRecruitmentManager();
        RecruitmentForm recform = (RecruitmentForm) form;
        List<Recruitment> reclist = new ArrayList<Recruitment>();

        int[] id = recform.getCandidateId();
        int length = id.length;
        for (int i = 0; i < length; i++) {
            reclist.add(recdao.getRecruitment(id[i]));
        }

        List emaillist = new ArrayList();
        List namelist=new ArrayList();
        for(int j=0; j<reclist.size();j++)
        {
            emaillist.add(reclist.get(j).getEmailId());
            namelist.add(reclist.get(j).getFirstName());
        }
        String subject = "ackknowledgement";
        String messagecontent = "hiiiiiiiiiiiiiii";
        String from = "orbitwebsol@gmail.com";

        
        try {
            SendingMail sm = new SendingMail();
            String ack = recform.getStatus();

            sm.sendSSLMessage(emaillist, subject, messagecontent, from, ack, namelist);

            target = "success";
        } catch (Exception e) {
            log.error("error From ExceptionClass " + e);

        }
        return mapping.findForward(target);
    }
    public ActionForward saveMarks(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        RecruitmentMarksDAO recdao = factory.createRecruitmentMarksManager();
        RecruitmentMarksForm recform = (RecruitmentMarksForm) form;
        ActionErrors errors = new ActionErrors();
        ActionMessages messages = new ActionMessages();
        BaseDAO b=new BaseDAO();


         String[] examname = recform.getExamName();
         int length=examname.length;

        boolean result=false;

        try{
            for (int i = 0; i < length; i++){
             RecruitmentMarks rm=new RecruitmentMarks();
               rm.setId(recdao.getLastId()+ 1);
                rm.setCandidateId(recform.getCandidateId());
          rm.setExamDate(b.mySqlDatebFormat(recform.getExamDate()[i]));
           rm.setExamName(recform.getExamName()[i]);
          rm.setMarksObt(recform.getMarksObt()[i]);
           rm.setMaxMarks(recform.getMaxMarks()[i]);
           result = recdao.save(rm);
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
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
            saveErrors(request, messages);
            target = "success";
        }

        return mapping.findForward(target);

    }



}



