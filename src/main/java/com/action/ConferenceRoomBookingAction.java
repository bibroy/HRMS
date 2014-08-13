/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.action;

import com.pojo.ConferenceRoomBooking;
import com.pojo.ConferenceRoomMaster;
import com.dao.ConferenceRoomDAO;
import com.ImplClass.ConferenceRoomDAOImpl;
import com.forms.ConferenceRoomBookingForm;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.util.TimeStampUtil;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

/**
 *
 * @author Sumit Kumar
 */
public class ConferenceRoomBookingAction extends DispatchAction {

    /* forward name="success" path="" */
    private String target = "";

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward load(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ConferenceRoomDAO condao = factory.createConferenceRoomManager();
        List<ConferenceRoomMaster> conlist = null;
        HttpSession session = request.getSession();
        ConferenceRoomBookingForm conform = (ConferenceRoomBookingForm) form;
        try {
            String userid = session.getAttribute("user_id").toString();
            conform.setEmployeeid(userid);
            conlist = condao.getAllConferenceRooms();
            request.setAttribute("roomlist", conlist);
            target = "load";
        } catch (Exception e) {
            log.error("error getting the list of conference room " + e);
        }
        return mapping.findForward(target);
    }

    public ActionForward bookConferenceRoom(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        DAOFactory factory = new DAOFactory();
        ConferenceRoomDAO condao = factory.createConferenceRoomManager();
        ConferenceRoomBooking con = new ConferenceRoomBooking();
        List<ConferenceRoomBooking> conlist = null;
        ActionMessages messages = new ActionMessages();
        List<ConferenceRoomMaster> conmslist = null;
        ConferenceRoomBookingForm conform = (ConferenceRoomBookingForm) form;
        TimeStampUtil tsu = new TimeStampUtil();
        HttpSession session = request.getSession();
        boolean result = false;
        try {
            String userid = session.getAttribute("user_id").toString();
            String[] date = conform.getBookingdate().split("/");
            Integer day = Integer.parseInt(date[0]);
            Integer month = Integer.parseInt(date[1]);
            Integer year = Integer.parseInt(date[2]);
            Integer fhour = conform.getFromhour();
            Integer fmin = conform.getFrommin();
            Integer thour = conform.getTohour();
            Integer tmin = conform.getTomin();

            Timestamp fbookingtime = tsu.makeTimestamp(year, month, day, fhour, fmin);
            Timestamp tbookingtime = tsu.makeTimestamp(year, month, day, thour, tmin);
            conlist = condao.getAllBookingInBetweenTime(fbookingtime.toString(), tbookingtime.toString(), conform.getRoomno());
            if (conlist.isEmpty()) {
                con.setConferenceroombookingcode(condao.getLastRequestId().add(BigDecimal.ONE));
                con.setEmployeeid(userid);
                con.setFromtime(fbookingtime);
                con.setTotime(tbookingtime);
                con.setRoomno(conform.getRoomno());
                con.setReason(conform.getReason());
                con.setStatus("A");
                con.setRequestdate(new Date());

                result = condao.saveBooking(con);
                if (result == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";

                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }
            } else {
                conmslist = condao.getAllConferenceRooms();
                request.setAttribute("roomlist", conmslist);
                messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("booking.error", "Please select another timeslot"));
                saveErrors(request, messages);
                target = "success";
            }
        } catch (Exception e) {
            log.error("error storing the conference room booking details " + e);
            messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("error.cancel", ""));
            saveErrors(request, messages);
            target = "success";
        }
        return mapping.findForward(target);
    }
}
