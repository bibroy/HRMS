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
import com.pojo.DailyAttendance;
import com.forms.AttendanceForm;
import com.dao.AttendanceDAO;
import com.ImplClass.AttendanceDAOImpl;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.actions.DispatchAction;
import com.dao.DAOFactory;
import java.util.List;
/**
 *
 * @author Sumit Kumar
 */
public class AttendanceAction extends DispatchAction {
    
  
   private String target="";
    
    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */


   public ActionForward getAttendanceReport(ActionMapping mapping, ActionForm form,
           HttpServletRequest request, HttpServletResponse response)
           throws Exception{
           DAOFactory factory=new DAOFactory();
           AttendanceDAO attdao=factory.createAttendanceManager();
           List<DailyAttendance> attlist=null;
           AttendanceForm attform=(AttendanceForm)form;
           try {
            attlist=attdao.getAttendanceById(attform.getUserid());
            request.setAttribute("attendance", attlist);
            target="success";
       } catch (Exception e) {
           log.error("error displaying attendance data "+e);
       }
         return mapping.findForward(target);
   }
}
