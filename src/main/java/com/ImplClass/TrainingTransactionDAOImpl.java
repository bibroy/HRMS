/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.TrainingDAO;
import com.dao.TrainingTransactionDAO;
import com.pojo.EmployeeMaster;
import com.pojo.Training;
import com.pojo.TrainingEmpInfo;
import com.pojo.TrainingMaster;
import com.pojo.TrainingRequestEmployee;
import com.pojo.TrainingRequestMaster;
import com.pojo.TrainingTransation;
import com.util.EmployeeBean;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.util.TrainingTransactionDetail;
import com.util.TrainingUtil;
import java.math.BigDecimal;
import java.math.BigInteger;

/**
 *
 * @author ranjans
 */
public class TrainingTransactionDAOImpl extends BaseDAO implements TrainingTransactionDAO {

    protected static final Log log = LogFactory.getLog(TrainingDAO.class);

    /***
     *
     */
    public TrainingTransactionDAOImpl() {
    }

    /***
     * Get a single Training transaction
     * @param trainingTransation
     * @return
     * @throws DAOException
     */
    public TrainingTransation getTrainingTransation(TrainingTransation trainingTransation) throws DAOException {
        TrainingTransation trainingTransationReturn = null;
        Session session = null;

        if (trainingTransation.getRequestId() == 0) {
            throw new DAOException("failed to fetch data for \"null\" trainingtransaction id");
        }

        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching trainingtransaction Detail");
            trainingTransationReturn = (TrainingTransation) session.get(TrainingTransation.class, trainingTransation.getRequestId());
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return trainingTransationReturn;
    }

    public BigDecimal getLastRequestId() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(requestId) from TrainingTransation").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
                if (b != null) {
                    i = new BigDecimal(b.intValue());
                }
                //Object[] row = (Object[]) iter.next();
                /*
                if(row[0]!=null)
                {
                BigDecimal b=(BigDecimal)row[0];
                i = b;
                }
                 *
                 */

            }
        } catch (NullPointerException npe) {
            //session.getTransaction().rollback();
            log.error("null value");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read Leave Request Id from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return i;
    }

    public List<TrainingTransation> getTrainingTransations() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TrainingTransation> getAllTrainingTransations() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    // ===public List<TrainingTransation> getTrainingTransationsAgainstEmployee(EmpDetails employee) throws DAOException {
    public List<TrainingTransation> getTrainingTransationsAgainstEmployee(EmployeeMaster employee) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /***
     * Insert training transaction
     * @param trainingTransation
     * @return
     * @throws DAOException
     */
    public boolean insertTrainingTransation(TrainingTransation trainingTransation) throws DAOException {
        boolean flg = false;
        Session session = null;
        Transaction transaction = null;
        Iterator<TrainingRequestEmployee> it;
        TrainingDAOImpl tdao = new TrainingDAOImpl();
        TrainingRequestEmployee trainingRequestEmployee;
        EmployeeMasterDAOImpl em = new EmployeeMasterDAOImpl();
        TrainingEmployeeTransactionDAOImpl daoimpl = new TrainingEmployeeTransactionDAOImpl();
        int requestId = 0;
        try {
            session = getSession();
            transaction = session.beginTransaction();

            it = trainingTransation.getTrainingRequestEmployee().iterator();

            requestId = trainingTransation.getRequestId();
            log.info("@@@ Request Id 2@@@" + requestId);

            while (it.hasNext()) {
                trainingRequestEmployee = it.next();
                trainingRequestEmployee.setRequestId(new BigDecimal(trainingTransation.getRequestId()));
                trainingRequestEmployee.setTrainingRequestId(daoimpl.getLastRequestId().add(BigDecimal.ONE));
                trainingRequestEmployee.setFlag(trainingTransation.getStatus());
                log.info("@@@ Flg @@@" + trainingRequestEmployee.getFlag());

                TrainingRequestMaster trm = new TrainingRequestMaster();
                trm.setEmployeeApplyId(new BigDecimal(em.getEmployeeMaster(trainingRequestEmployee.getEmployeeId().intValue()).getEmployeeId()));
                trm.setFromDate(trainingTransation.getFromDate());
                trm.setRequestId(new BigDecimal(trainingTransation.getRequestId()));
                trm.setStatus(trainingTransation.getStatus());
                trm.setToDate(trainingTransation.getToDate());
                trm.setTraining(tdao.getTrainingById(new BigDecimal(trainingTransation.getTrainingId())));
                trm.setTrainingId(new BigDecimal(trainingTransation.getTrainingId()));

                trainingTransation.setEmployee(em.getEmployeeMaster(trainingRequestEmployee.getEmployeeId().intValue()));
                session.saveOrUpdate(trainingRequestEmployee);
                session.saveOrUpdate(trm);
            }

            session.saveOrUpdate(trainingTransation);
            log.info("@@@ Request Id 1@@@" + trainingTransation.getRequestId());

            transaction.commit();
            log.info("Insert TrainingTransaction");
            flg = true;
        } catch (Exception e) {
            transaction.rollback();
            log.error("failed to training data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return flg;
    }

    /***
     * Update training transaction
     * @param trainingTransation
     * @return
     * @throws DAOException
     */
    public boolean updateTrainingTransation(TrainingTransation trainingTransation) throws DAOException {
        boolean flg = false;
        Session session = null;
        Transaction transaction = null;
        Iterator<TrainingRequestEmployee> it;
        TrainingRequestEmployee trainingRequestEmployee;
        int requestId = 0;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(trainingTransation);
            log.info("@@@ Request Id 1@@@" + trainingTransation.getRequestId());
            /***
             * In case of HR
             * there are no option
             * for edit the employee
             * assign for training
             */
            if (!trainingTransation.getStatus().equalsIgnoreCase("hrapprove") && !trainingTransation.getStatus().equalsIgnoreCase("hrdiappr")) {
                it = trainingTransation.getTrainingRequestEmployee().iterator();
                requestId = trainingTransation.getRequestId();
                log.info("@@@ Request Id 2@@@" + requestId);
                while (it.hasNext()) {
                    trainingRequestEmployee = it.next();
                    trainingRequestEmployee.setRequestId(new BigDecimal(requestId));
                    session.saveOrUpdate(trainingRequestEmployee);
                }

            }

            transaction.commit();
            log.info("Insert or Update TrainingTransaction");
            flg = true;
        } catch (Exception e) {
            transaction.rollback();
            log.error("failed to training data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return flg;
    }

    /***
     * Use for generate
     * transaction Report
     * @param trainingTransation
     * @return
     * @throws DAOException
     */
    public List<TrainingTransactionDetail> getTrainingTransactionAgainstFlg(TrainingTransation trainingTransation) throws DAOException {

        List trainingTransactionDetails = new ArrayList();
        List<TrainingTransactionDetail> trainingTransactionDetailsReturn = new ArrayList<TrainingTransactionDetail>();
        Session session = null;
        Object obj[] = null;
        StringBuffer name = new StringBuffer();

        TrainingTransactionDetail trainingTransactionDetail = null;
        log.info("@@@ Status @@@" + trainingTransation.getStatus());
        if (trainingTransation.getStatus() == null || trainingTransation.getStatus().trim().length() <= 0) {
            throw new DAOException("failed to fetch data for \"null\" trainingtransaction status");
        }

        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching trainingtransaction Detail");
            log.info("@@@ flag @@@" + trainingTransation.getStatus().trim());
            //trainingTransationReturn = (List<TrainingTransation>)session.get(TrainingTransation.class,trainingTransation.getStatus());

            //trainingTransactionDetails = session.createQuery("select t.trainingName,tr.trainingId,e.employeeId,e.firstName,e.middleName,e.lastName,tr.requestId,tr.employeeApplyId,tr.fromDate,tr.toDate,e.employeeCode from TrainingTransation tr, Training t ,EmpDetails e where t.trainingId=tr.trainingId  and e.employeeId=tr.employeeApplyId and tr.status='"+trainingTransation.getStatus().trim()+"'").list();

            // === trainingTransactionDetails = session.createQuery("select t.trainingName,tr.trainingId,e.employeeId,e.firstName,e.middleName,e.lastName,tr.requestId,tre.employeeId,tr.fromDate,tr.toDate,tr.requestId from TrainingTransation tr, Training t ,EmpDetails e,TrainingRequestEmployee tre where t.trainingId=tr.trainingId and tr.requestId=tre.requestId and e.employeeId=tre.employeeId and tr.status='"+trainingTransation.getStatus().trim()+"' order by tr.requestId ").list();

            trainingTransactionDetails = session.createQuery("select t.trainingName,tr.trainingId,e.employeeId,e.firstName,e.middleName,e.lastName,tr.requestId,tre.employeeId,tr.fromDate,tr.toDate,tr.requestId from TrainingTransation tr, Training t ,EmployeeMaster e,TrainingRequestEmployee tre where t.trainingId=tr.trainingId and tr.requestId=tre.requestId and e.id=tre.employeeId and tr.status='" + trainingTransation.getStatus().trim() + "' order by tr.requestId ").list();

            log.info("@@@ Training  fetch  name @@@");
            for (Iterator itr = trainingTransactionDetails.iterator(); itr.hasNext();) {

                //System.out.println("--- Class type ---"+itr.next().getClass());
                obj = (Object[]) itr.next();
                log.info("@@@ Length of object @@@" + obj.length);
                trainingTransactionDetail = new TrainingTransactionDetail();
                //System.out.println("@@@ Training name @@@"+obj[0].toString());
                trainingTransactionDetail.setTrainingName(obj[0].toString());
                trainingTransactionDetail.setTrainingId(Integer.parseInt(obj[1].toString()));
                trainingTransactionDetail.setEmployeeId(obj[2].toString());

                name.delete(0, name.length());

                if (obj[3] != null && obj[3].toString().trim().length() > 0) {
                    name.append("  " + obj[3].toString().trim());
                }
                if (obj[4] != null && obj[4].toString().trim().length() > 0) {

                    name.append(" " + obj[4].toString().trim());
                }
                if (obj[5] != null && obj[5].toString().trim().length() > 0) {

                    name.append(" " + obj[5].toString().trim());
                }
                /*
                System.out.println("@@@ Name of the employee @@@"+name.toString());
                if(name.toString()!=null && name.toString().trim().length()>0){
                System.out.println("@@@ Name of employee @@@"+name);
                name.append(","+name);
                }
                 */
                trainingTransactionDetail.setEmployeeName("   " + name.toString());
                // -- add new the name buffer
                // -- string should be blank if status is "ereq"
                if (trainingTransation.getStatus().trim().equals("ereq")) {
                    log.info("@@@ ### Inside if ###@@@" + trainingTransation.getStatus().trim());
                    name.delete(0, name.length());
                }
                log.info("@@@ request ID @@@" + obj[6].toString());
                trainingTransactionDetail.setRequestId(Integer.parseInt(obj[6].toString().trim()));
                trainingTransactionDetail.setApplyId(obj[7].toString().trim());
                trainingTransactionDetail.setFromDate(mySQLscreenDateFormat((Date) obj[8]));
                trainingTransactionDetail.setToDate(mySQLscreenDateFormat((Date) obj[9]));
                // --- trainingTransactionDetail.setEmpCode(Integer.parseInt(obj[10].toString().trim()));

                trainingTransactionDetail.setRequestId(Integer.parseInt(obj[10].toString().trim()));

                // ===trainingTransactionDetail.setEmpCode(Integer.parseInt(obj[2].toString().trim()));
                trainingTransactionDetail.setFlg(trainingTransation.getStatus());
                log.info("@@@ Employee name @@@" + name);
                // ---
                trainingTransactionDetailsReturn.add(trainingTransactionDetail);

                // --- TrainingUtil.returnUnique(trainingTransactionDetailsReturn);

                trainingTransactionDetailsReturn = TrainingUtil.uniqueVal(trainingTransactionDetailsReturn);
            }

            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return trainingTransactionDetailsReturn;

    }

    /***
     * Return a single
     * TrainingTransactionDetail
     * @param trainingTransation
     * @return
     * @throws DAOException
     */
    public TrainingTransactionDetail getTrainingTransactionAgainst(TrainingTransation trainingTransation, String applyId) throws DAOException {

        List trainingTransactionDetails = new ArrayList();
        Session session = null;
        Object obj[] = null;
        TrainingTransactionDetail trainingTransactionDetail = null;
        String appId = "";
        if (trainingTransation.getRequestId() == 0) {
            throw new DAOException("failed to fetch data for \"null\" trainingtransaction status");
        }

        try {
            session = getSession();
            session.beginTransaction();
            StringBuffer name = new StringBuffer();

            log.info("fetching trainingtransaction Detail");
            //trainingTransationReturn = (List<TrainingTransation>)session.get(TrainingTransation.class,trainingTransation.getStatus());
            //trainingTransactionDetails = session.createQuery("select t.trainingName,tr.trainingId,e.employeeId,e.firstName,e.middleName,e.lastName,d.id,d.departmentName,tr.fromDate,tr.toDate,tr.employeeApproveId,s.skillId,s.skillName,tr.employeeApplyId from TrainingTransation tr, Training t ,EmpDetails e ,Department d,Skills s where t.trainingId=tr.trainingId  and e.employeeId in("+applyId+") and  t.id=d.id  and t.skillId=s.skillId and tr.requestId="+trainingTransation.getRequestId()+"").list();

            // === trainingTransactionDetails = session.createQuery("select t.trainingName,tr.trainingId,e.employeeId,e.firstName,e.middleName,e.lastName,d.id,d.departmentName,tr.fromDate,tr.toDate,tr.employeeApproveId,s.skillId,s.skillName,tre.employeeId ,tre.trainingRequestId from TrainingTransation tr, Training t ,EmpDetails e ,Department d,Skills s ,TrainingRequestEmployee tre where t.trainingId=tr.trainingId  and tr.requestId=tre.requestId and e.employeeId=tre.employeeId and  t.id=d.id  and t.skillId=s.skillId and tr.requestId="+trainingTransation.getRequestId()+"").list();

            trainingTransactionDetails = session.createQuery("select t.trainingName,tr.trainingId,e.employeeId,e.firstName,e.middleName,e.lastName,d.id,d.departmentName,tr.fromDate,tr.toDate,tr.employeeApproveId,s.skillId,s.skillName,tre.employeeId ,tre.trainingRequestId,j.jobname from TrainingTransation tr, Training t ,EmployeeMaster e ,Department d,Skills s ,TrainingRequestEmployee tre,JobType j where t.trainingId=tr.trainingId  and tr.requestId=tre.requestId and e.id=tre.employeeId and  t.id=d.id  and t.skillId=s.skillId and tr.requestId=" + trainingTransation.getRequestId() + " and t.typeId=j.typeId and tre.employeeId='" + applyId + "'").list();
            log.info("@@@ Training  fetch  name @@@");
            for (Iterator itr = trainingTransactionDetails.iterator(); itr.hasNext();) {

                //System.out.println("--- Class type ---"+itr.next().getClass());
                obj = (Object[]) itr.next();
                //System.out.println("@@@ Length of object @@@"+obj.length);
                trainingTransactionDetail = new TrainingTransactionDetail();
                //System.out.println("@@@ Training name @@@"+obj[0].toString());
                trainingTransactionDetail.setTrainingName(obj[0].toString());
                trainingTransactionDetail.setTrainingId(Integer.parseInt(obj[1].toString()));

                if (obj[3] != null && obj[3].toString().trim().length() > 0) {

                    name.append("   " + obj[3].toString().trim());
                }
                if (obj[4] != null && obj[4].toString().trim().length() > 0) {

                    name.append(" " + obj[4].toString().trim());
                }
                if (obj[5] != null && obj[5].toString().trim().length() > 0) {

                    name.append(" " + obj[5].toString().trim());
                }
                /*
                System.out.println("@@@ Name of the employee @@@"+name.toString());
                if(name.toString()!=null && name.toString().trim().length()>0){
                System.out.println("@@@ Name of employee @@@"+name);
                name.append(","+name);
                }
                 */
                trainingTransactionDetail.setEmployeeName(name.toString());
                // -- add new
                //name.delete(0,name.length());

                trainingTransactionDetail.setDepartmentId(Integer.parseInt(obj[6].toString()));
                trainingTransactionDetail.setDepartmentName(obj[7].toString());
                trainingTransactionDetail.setAvailableFrom(mySQLscreenDateFormat((Date) obj[8]));
                trainingTransactionDetail.setAvailableTo(mySQLscreenDateFormat((Date) obj[9]));
                trainingTransactionDetail.setApprovedBy(Integer.parseInt(obj[10].toString()));
                trainingTransactionDetail.setSkillId(Integer.parseInt(obj[11].toString()));
                trainingTransactionDetail.setSkillName(obj[12].toString());

                if (appId != null && appId.trim().length() > 0) {
                    appId = appId + "," + obj[13].toString().trim();
                    trainingTransactionDetail.setApplyId(appId);
                } else {
                    trainingTransactionDetail.setApplyId(obj[13].toString());
                }
                appId = obj[13].toString().trim();

                trainingTransactionDetail.setTrainingEmployeeId(Integer.parseInt(obj[14].toString()));
                // --- add jobtytpe for view in training in
                // --- HR approvel form
                trainingTransactionDetail.setJobType(obj[15].toString());
            }

            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return trainingTransactionDetail;
    }

    public List<EmployeeBean> getEmployeesAgainstDept(int departmentId) throws DAOException {

        Session session = null;
        List employees = new ArrayList();
        List<EmployeeBean> empBean = new ArrayList<EmployeeBean>();
        Object obj[] = null;
        if (departmentId == 0) {
            throw new DAOException("failed to fetch data for \"null\" departmentId");
        }
        try {
            session = getSession();
            session.beginTransaction();
            // --- employees=(List<EmpDetails>)session.createQuery(" from EmpDetails where (dateOfRetirement is null or dateOfRetirement='') and estatus='Y' and deptId="+departmentId).list();
            // === employees=session.createQuery("select e.employeeId,e.firstName,e.middleName,e.lastName from EmpDetails e ,EmployeeJob ej where (ej.DateOfRetirement is null or ej.DateOfRetirement='') and e.status='Y' and  ej.DepartmentId="+departmentId).list();
            employees = session.createQuery("select e.employeeId,e.firstName,e.middleName,e.lastName,e.id from EmployeeMaster e where e.status='Y' and  e.departmentId=" + departmentId).list();
            for (Iterator itr = employees.iterator(); itr.hasNext();) {
                obj = (Object[]) itr.next();
                StringBuffer name = new StringBuffer();
                EmployeeBean emp = new EmployeeBean();
                // === emp.setEmpId(Integer.parseInt(obj[0].toString()));
                emp.setEmpId(obj[0].toString());
                if (obj[1] != null && obj[1].toString().trim().length() > 0) {
                    name.append(obj[1].toString().trim());
                }
                if (obj[2] != null && obj[2].toString().trim().length() > 0) {
                    name.append(" " + obj[2].toString().trim());
                }
                if (obj[3] != null && obj[3].toString().trim().length() > 0) {
                    name.append(" " + obj[3].toString().trim());
                }

                emp.setEmpName(name.toString());
                empBean.add(emp);
            }

            // --- session.getTransaction().commit();
            log.info("fetching Employee Detail");
        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return empBean;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    /***
     * Employee Details against
     * employee Id and training Id
     * @param empId
     * @param trainingId
     * @return
     * @throws DAOException
     */
    // ===  public List<EmpDetails> getEmployeesDtlInTraining(String empId) throws DAOException {
    // ===  public List<EmployeeMaster> getEmployeesDtlInTraining(String empId) throws DAOException {
    public List<TrainingEmpInfo> getEmployeesDtlInTraining(String empId) throws DAOException {

        List<TrainingEmpInfo> empInfoList = new ArrayList<TrainingEmpInfo>();
        String[] ides = null;

        log.info("@@@ EmpID @@@" + empId);
        if (empId == null || empId.trim().length() <= 0) {
            throw new DAOException("failed to fetch data for \"null\" employee id");
        }
        try {
            log.info("fetching Employee Detail");
            ides = empId.split(",");
            log.info("@@@ Array of  Id @@@" + ides.length);

            for (int count = 0; ides.length > count; count++) {
                TrainingEmpInfo empInfo = new TrainingEmpInfo();
                log.info("@@@ empId in Loop @@@" + ides[count]);
                empInfo = getEmployee(Integer.parseInt(ides[count]));
                log.info("### employee name ###" + empInfo.getEmpName());
                empInfoList.add(empInfo);
            }

            log.info("done");
        } catch (Exception e) {
            log.error("failed to read Employee data from database", e);
            throw new DAOException("unknown error");
        } finally {
        }
        return empInfoList;
    }

    /***
     * Use for generate
     * transaction Report
     * For HOD
     * Where HOD can see only departmental apply value
     * @param trainingTransation
     * @return
     * @throws DAOException
     */
    public List<TrainingTransactionDetail> getTrainingTransactionAgainstFlgForHOD(TrainingTransation trainingTransation, int deptID) throws DAOException {

        List trainingTransactionDetails = new ArrayList();
        List<TrainingTransactionDetail> trainingTransactionDetailsReturn = new ArrayList<TrainingTransactionDetail>();
        Session session = null;
        Object obj[] = null;
        StringBuffer name = new StringBuffer();

        TrainingTransactionDetail trainingTransactionDetail = null;
        System.out.println("@@@ Status @@@" + trainingTransation.getStatus());
        if (trainingTransation.getStatus() == null || trainingTransation.getStatus().trim().length() <= 0) {
            throw new DAOException("failed to fetch data for \"null\" trainingtransaction status");
        }

        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching trainingtransaction Detail");
            System.out.println("@@@ flag @@@" + trainingTransation.getStatus().trim());
            //trainingTransationReturn = (List<TrainingTransation>)session.get(TrainingTransation.class,trainingTransation.getStatus());
            // === trainingTransactionDetails = session.createQuery("select t.trainingName,tr.trainingId,e.employeeId,e.firstName,e.middleName,e.lastName,tr.requestId,tr.employeeApplyId,tr.fromDate,tr.toDate from TrainingTransation tr, Training t ,EmpDetails e where t.trainingId=tr.trainingId  and e.employeeId=tr.employeeApplyId  and t.id="+deptID+"  and tr.status='"+trainingTransation.getStatus().trim()+"'").list();
            trainingTransactionDetails = session.createQuery("select t.trainingName,tr.trainingId,e.employeeId,e.firstName,e.middleName,e.lastName,tr.requestId,tr.employeeApplyId,tr.fromDate,tr.toDate from TrainingTransation tr, Training t ,EmployeeMaster e where t.trainingId=tr.trainingId  and e.id=tr.employeeApplyId  and t.id=" + deptID + "  and tr.status='" + trainingTransation.getStatus().trim() + "'").list();

            System.out.println("@@@ Training  fetch  name @@@");
            for (Iterator itr = trainingTransactionDetails.iterator(); itr.hasNext();) {

                //System.out.println("--- Class type ---"+itr.next().getClass());
                obj = (Object[]) itr.next();
                System.out.println("@@@ Length of object @@@" + obj.length);
                trainingTransactionDetail = new TrainingTransactionDetail();
                //System.out.println("@@@ Training name @@@"+obj[0].toString());
                trainingTransactionDetail.setTrainingName(obj[0].toString());
                trainingTransactionDetail.setTrainingId(Integer.parseInt(obj[1].toString()));


                if (obj[3] != null && obj[3].toString().trim().length() > 0) {
                    name.append("  " + obj[3].toString().trim());
                }
                if (obj[4] != null && obj[4].toString().trim().length() > 0) {

                    name.append(" " + obj[4].toString().trim());
                }
                if (obj[5] != null && obj[5].toString().trim().length() > 0) {

                    name.append(" " + obj[5].toString().trim());
                }
                /*
                System.out.println("@@@ Name of the employee @@@"+name.toString());
                if(name.toString()!=null && name.toString().trim().length()>0){
                System.out.println("@@@ Name of employee @@@"+name);
                name.append(","+name);
                }
                 */
                trainingTransactionDetail.setEmployeeName("   " + name.toString());
                // -- add new the name buffer
                // -- string should be blank if status is "ereq"
                if (trainingTransation.getStatus().trim().equals("ereq")) {
                    System.out.println("@@@ ### Inside if ###@@@" + trainingTransation.getStatus().trim());
                    name.delete(0, name.length());
                }



                trainingTransactionDetail.setRequestId(Integer.parseInt(obj[6].toString().trim()));
                trainingTransactionDetail.setApplyId(obj[7].toString().trim());
                trainingTransactionDetail.setFromDate(mySQLscreenDateFormat((Date) obj[8]));
                trainingTransactionDetail.setToDate(mySQLscreenDateFormat((Date) obj[9]));
                // ---trainingTransactionDetail.setEmpCode(Integer.parseInt(obj[10].toString().trim()));
                log.info("@@@ Employee name @@@" + name);
                // ---
                trainingTransactionDetailsReturn.add(trainingTransactionDetail);
            }

            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return trainingTransactionDetailsReturn;

    }

    public List<TrainingTransation> getTransactionAgainstFlg(TrainingTransation trainingTransation) throws DAOException {

        List<TrainingTransation> trainingTransactionList = new ArrayList<TrainingTransation>();
        Session session = null;
        Object obj[] = null;
        if (trainingTransation.getStatus() == null || trainingTransation.getStatus().trim().length() <= 0) {
            throw new DAOException("failed to fetch data for \"null\" trainingtransaction status");
        }
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching trainingtransaction Detail");
            trainingTransactionList = session.createQuery(" from TrainingTransation where status='" + trainingTransation.getStatus().trim() + "'").list();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return trainingTransactionList;
    }

    /***
     * 
     * @return
     * @throws DAOException
     */
    public List<TrainingEmpInfo> getInEmployees() throws DAOException {
        List<TrainingEmpInfo> trainingEmp = new ArrayList<TrainingEmpInfo>();
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching trainingtransaction Detail");
            trainingEmp = session.createQuery(" from TrainingEmpInfo e where e.id not in (select employeeId from  TrainingRequestEmployee where flag='INTRINI' or flag='INTRINIA')").list();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }


        return trainingEmp;
    }

    /***
     * Get employee 
     * Full name
     * Employee ID
     * Employee Code
     * Company days of Exp
     * Past company exp
     * Total Experience
     * @param empId
     * @return
     * @throws DAOException
     */
    public TrainingEmpInfo getEmployee(int empId) throws DAOException {
        Session session = null;
        TrainingEmpInfo empInfo = new TrainingEmpInfo();
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching trainingtransaction Detail");
            //empInfo=(TrainingEmpInfo)session.createQuery(" from TrainingEmpInfo e where e.id="+empId);

            empInfo = (TrainingEmpInfo) session.get(TrainingEmpInfo.class, empId);

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read trainingtransaction data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return empInfo;
    }
}
