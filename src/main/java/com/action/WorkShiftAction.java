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
import org.apache.struts.actions.DispatchAction;
import com.dao.DAOFactory;
import com.dao.ShiftMasterDAO;
import java.util.List;
import com.forms.WorkShiftForm;
import com.pojo.EmployeeMaster;
import com.dao.EmployeeMasterDAO;
import com.pojo.ShiftMaster;
import com.pojo.WorkShift;
import com.dao.WorkShiftDAO;
import com.dao.BaseDAO;
import javax.servlet.http.HttpSession;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

/**
 *
 * @author Pradipto Roy
 */
public class WorkShiftAction extends DispatchAction {

    String target = null;
    /* forward name="success" path="" */
    private static final String SUCCESS = "success";

    /**
     * This is the action called from the Struts framework.
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    public ActionForward SubmitWorkShift(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ActionMessages messages = new ActionMessages();

        WorkShiftForm frm = (WorkShiftForm) form;

        DAOFactory dfact = new DAOFactory();

        WorkShiftDAO workdao = dfact.createWorkShiftManager();
        WorkShift workshiftpojo = new WorkShift();

        EmployeeMasterDAO edao = dfact.createEmployeeMasterManager();
        List<EmployeeMaster> epojo = null;
        HttpSession session = request.getSession();
        List<ShiftMaster> ehojo = null;
        ShiftMasterDAO shift = dfact.createShiftMasterManager();
        BaseDAO b = new BaseDAO();


        try {
            if (session.getAttribute("user_id") != null) {
                String id = session.getAttribute("user_id").toString();

                workshiftpojo = workdao.getAllWorkShiftbyEmpId(id);
                workshiftpojo.setShiftID(Integer.parseInt(frm.getShiftID()));
                workshiftpojo.setDateOfAllocation(b.mySqlDatebFormat(frm.getDateOfAllocation()));
                workshiftpojo.setAllocatedBY(frm.getAllocatedBY());
                workshiftpojo.setWorkStartDate(b.mySqlDatebFormat(frm.getDateOfAllocation()));
                boolean rs = workdao.save(workshiftpojo);

                if (rs == true) {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("save.ok", ""));
                    saveMessages(request, messages);
                    target = "success";
                } else {
                    messages.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.cancel", ""));
                    saveErrors(request, messages);
                    target = "success";
                }
                epojo = edao.getAllEmployeeMaster();
                request.setAttribute("employee", epojo);

                ehojo = shift.getAllShiftDetails();
                request.setAttribute("shifts", ehojo);

                target = "success";

            }

        } catch (Exception e) {
            log.error("An exception occur" + e);

        }

        return mapping.findForward(SUCCESS);
    }

    public ActionForward loadEmployeeID(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        WorkShiftForm frm = (WorkShiftForm) form;
        DAOFactory dfact = new DAOFactory();
        EmployeeMasterDAO edao = dfact.createEmployeeMasterManager();
        List<EmployeeMaster> epojo = null;
        HttpSession session = request.getSession();

        List<ShiftMaster> ehojo = null;
        ShiftMasterDAO shift = dfact.createShiftMasterManager();

        try {
            if (session.getAttribute("user_id") != null) {
                String id = session.getAttribute("user_id").toString();
                frm.setAllocatedBY(id);
                epojo = edao.getAllEmployeeMaster();
                request.setAttribute("employee", epojo);

                ehojo = shift.getAllShiftDetails();
                request.setAttribute("shifts", ehojo);

                target = "success";
            }

        } catch (Exception e) {
            log.error("" + e);
        }
        return mapping.findForward(SUCCESS);
    }
}
