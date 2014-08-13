/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.TrainingDAO;
import com.pojo.Department;
// --- import com.pojo.EmpDetails;
import com.pojo.EmployeeMaster;
import com.pojo.Training;
import com.pojo.TrainingMaster;
import com.pojo.TrainingRequestMaster;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.util.TrainingDetail;
import com.util.TrainingNeeds;
import java.math.BigDecimal;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;

/**
 *
 * @author ranjans
 */
public class TrainingDAOImpl extends BaseDAO implements TrainingDAO {

    protected static final Log log = LogFactory.getLog(TrainingDAO.class);

    public TrainingDAOImpl() {
    }

    /***
     * Use for get a particular trainingobject against training Id
     * @param trainingId
     * @return
     * @throws DAOException
     */
    public TrainingDetail getTrainingDtl(int trainingId) throws DAOException {
        TrainingDetail trainingReturn = null;
        List trainingList = new ArrayList();
        Object obj[] = null;
        Session session = null;

        if (trainingId == 0) {
            throw new DAOException("failed to fetch data for \"null\" training id");
        }
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching  SyCompany Detail");
            //System.out.println("the value of id==="+trainingId);
            //trainingReturn = (Training)session.get(Training.class,training.getTrainingId());
            // -- trainingList = session.createQuery("select d.departmentName,t.trainingName,t.consultancyId,t.id,t.skillId,t.status,t.trainer,t.trainingId,s.skillName,t.trainingType  from Training t,Department d,Skills s where t.id=d.id and t.skillId=s.skillId and t.trainingId="+trainingId).list();

            trainingList = session.createQuery("select d.departmentName,t.trainingName,t.consultancyId,t.id,t.skillId,t.status,t.trainer,t.trainingId,s.skillName,t.trainingType,t.typeId  from Training t,Department d,Skills s where t.id=d.id and t.skillId=s.skillId and t.trainingId=" + trainingId).list();

            for (Iterator itr = trainingList.iterator(); itr.hasNext();) {
                obj = (Object[]) itr.next();
                trainingReturn = new TrainingDetail();
                trainingReturn.setDepartment(obj[0].toString());
                /***
                 *
                 */
                trainingReturn.setTrainingName(obj[1].toString());
                trainingReturn.setConsultancy(obj[2].toString());
                trainingReturn.setDepartmentId(Integer.parseInt(obj[3].toString()));
                trainingReturn.setSkillId(Integer.parseInt(obj[4].toString()));
                trainingReturn.setStatus(obj[5].toString());
                trainingReturn.setTrainer(obj[6].toString());
                trainingReturn.setSkillName(obj[8].toString());
                trainingReturn.setTrainingMode(obj[9].toString());
                trainingReturn.setTypeId(Integer.parseInt(obj[10].toString()));
                //trainingReturn.setTrainingId(trainingId);

                //trainingReturn.set
                /***
                 *
                 */
                System.out.println("the value of id===" + obj[0].toString());

            }



            //trainingReturn = (TrainingDetail)trainingList.get(0);
            //trainingList =session.createQuery("from Training t,Department d where t.id=d.id and t.trainingId:=trainingId").setParameter("trainingId",training.getTrainingId(),Hibernate.INTEGER).list();
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Training data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Training data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return trainingReturn;
    }

    /***
     * get the training details for report where Status is not hold
     * @return
     * @throws DAOException
     */
    public List<Training> getTrainingDtls() throws DAOException {

        List<Training> trainingList = null;
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            trainingList = session.createQuery("from Training t where t.status='initiated'").list();
            session.getTransaction().commit();
            log.info("Fetching all initiated States");

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Training list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return trainingList;
    }

    /***
     * Use for change status of a training
     * @param trainingId
     * @param status
     * @return
     * @throws DAOException
     */
    public boolean changeStatus(int trainingId, String status) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /***
     * Usefor add training detail
     * @param training
     * @return
     * @throws DAOException
     */
    public boolean addTrainingDtl(Training training) throws DAOException {
        boolean flg = false;
        Session session = null;
        Transaction transaction = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            System.out.println("%%% Inside DAO %%%" + training.getId());
            session.saveOrUpdate(training);
            transaction.commit();
            log.info("Insert Training");
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
     * Use for update Training Detail
     * @param training
     * @return
     * @throws DAOException
     */
    public boolean updateTrainingDtl(Training training) throws DAOException {
        boolean flg = false;
        Session session = null;
        Transaction transaction = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(training);
            transaction.commit();
            log.info("Insert Training");
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
     * get the training details for report without status state
     * @return
     * @throws DAOException
     */
    public List<Training> getAllTrainingDtls() throws DAOException {
        Session session = null;
        List<Training> trainings = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Department");
            trainings = session.createQuery("from Training t where t.status='initiated'").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read skills list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return trainings;
    }

    /***
     * 
     * @param departmentId
     * @return
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
	public List<Training> getTrainingDtlsAgainstDepartment(int departmentId) throws DAOException {
        List<Training> consultancyReturn = null;
        Session session = null;

        if (departmentId == 0) {
            throw new DAOException("failed to fetch data for \"null\" Skill id");
        }

        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Consultancy Detail");
            log.info("### department ID ###" + departmentId);
            //consultancyReturn = (Consultancy)session.get(Consultancy.class,consultancy.getConsultancyId());
            consultancyReturn = session.createQuery("from Training  where status='initiated' and id=:id").setParameter("id", departmentId, Hibernate.INTEGER).list();
            //consultancyReturn =session.createQuery("from Training  where status='initiated' and id="+departmentId).list();
            //System.out.print("### Size of List ###"+consultancyReturn);
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Consultancy data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Consultancy data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return consultancyReturn;
    }

    /***
     * get the training details for report
     * where Status is not hold
     * and have a skillId
     * @param skillId
     * @return
     * @throws DAOException
     */
    public List<Training> getTrainingDtlsAgainstSkill(String skillId) throws DAOException {
        List<Training> consultancyReturn = null;
        Session session = null;

        if (skillId == null || skillId.trim().length() <= 0) {
            throw new DAOException("failed to fetch data for \"null\" Skill id");
        }

        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Consultancy Detail");
            System.out.println("### Befor fetching query ###");
            //consultancyReturn = (Consultancy)session.get(Consultancy.class,consultancy.getConsultancyId());
            consultancyReturn = session.createQuery("from Training t where status='initiated' and skillId=:skillId").setParameter("skillId", Integer.parseInt(skillId)).list();
            // consultancyReturn =session.createQuery("from Training t where t.status='initiated' and t.skillId in("+skillId+")").list();
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Consultancy data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Consultancy data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return consultancyReturn;
    }

    /***
     * Get Training Master Report
     * @return
     * @throws DAOException
     */
    public List<TrainingDetail> getTrainingDtlsReport() throws DAOException {
        List<TrainingDetail> trainingReturn = new ArrayList<TrainingDetail>();
        List trainingList = new ArrayList();
        StringBuffer sql = new StringBuffer();
        Object obj[] = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching  SyCompany Detail");
            //System.out.println("the value of id==="+trainingId);
            //trainingReturn = (Training)session.get(Training.class,training.getTrainingId());


            sql.append("select distinct(t.trainingName),c.consultancyName,d.departmentName,t.consultancyId,t.id,t.skillId,t.status,t.trainer,s.skillName,t.trainingType,t.trainingId,t.typeId  from Training t,Department d,Skills s,Consultancy c where t.id=d.id and t.skillId=s.skillId and t.consultancyId=c.consultancyId and t.status!='hold'");
            //sql.append(" union ");
            //sql.append("select distinct(t.trainingName),'',d.departmentName,t.consultancyId,t.id,t.skillId,t.status,t.trainer,s.skillName,t.trainingType,t.trainingId  from Training t,Department d,Skills s,Consultancy c where t.id=d.id and t.skillId=s.skillId and t.consultancyId=c.consultancyId and t.status!='hold'");


            trainingList = session.createQuery(sql.toString()).list();


            for (Iterator itr = trainingList.iterator(); itr.hasNext();) {
                obj = (Object[]) itr.next();
                TrainingDetail training = new TrainingDetail();
                training.setConSultencyName(obj[1].toString());
                training.setDepartment(obj[2].toString());
                /***
                 *
                 */
                training.setTrainingName(obj[0].toString());
                training.setConsultancy(obj[3].toString());
                training.setDepartmentId(Integer.parseInt(obj[4].toString()));
                training.setSkillId(Integer.parseInt(obj[5].toString()));
                training.setStatus(obj[6].toString());
                training.setTrainer(obj[7].toString());
                training.setSkillName(obj[8].toString());
                training.setTrainingMode(obj[9].toString());
                // --- add typeId in POJO
                training.setTypeId(Integer.parseInt(obj[10].toString()));
                //trainingReturn.setTrainingId(trainingId);
                trainingReturn.add(training);
                //trainingReturn.set
                /***
                 *
                 */
                System.out.println("the value of id===" + obj[0].toString());

            }



            //trainingReturn = (TrainingDetail)trainingList.get(0);
            //trainingList =session.createQuery("from Training t,Department d where t.id=d.id and t.trainingId:=trainingId").setParameter("trainingId",training.getTrainingId(),Hibernate.INTEGER).list();
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Training data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Training data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return trainingReturn;
    }

    /***
     * Get Training Internal and External Report
     * @return
     * @throws DAOException
     */
    public List<TrainingDetail> getTrainingIEReport(String trainingType) throws DAOException {
        List<TrainingDetail> trainingReturn = new ArrayList<TrainingDetail>();
        List trainingList = new ArrayList();
        Object obj[] = null;
        Session session = null;

        if (trainingType == null || trainingType.trim().length() <= 0) {
            throw new DAOException("failed to fetch data for \"null\" Skill id");
        }
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching  SyCompany Detail");
            //System.out.println("the value of id==="+trainingId);
            //trainingReturn = (Training)session.get(Training.class,training.getTrainingId());
            trainingList = session.createQuery("select d.departmentName,t.trainingName,t.consultancyId,t.id,t.skillId,t.status,t.trainer,t.trainingId,s.skillName,t.trainingType,c.consultancyName,t.typeId from Training t,Department d,Skills s,Consultancy c where t.id=d.id and t.skillId=s.skillId  and t.consultancyId=c.consultancyId  and t.status!='hold' and t.trainingType='" + trainingType.trim() + "'").list();


            for (Iterator itr = trainingList.iterator(); itr.hasNext();) {
                obj = (Object[]) itr.next();
                TrainingDetail training = new TrainingDetail();
                training.setDepartment(obj[0].toString());
                /***
                 *
                 */
                training.setTrainingName(obj[1].toString());
                training.setConsultancy(obj[2].toString());
                training.setDepartmentId(Integer.parseInt(obj[3].toString()));
                training.setSkillId(Integer.parseInt(obj[4].toString()));
                training.setStatus(obj[5].toString());
                training.setTrainer(obj[6].toString());
                training.setSkillName(obj[8].toString());
                training.setTrainingMode(obj[9].toString());
                training.setConSultencyName(obj[10].toString());
                // --- set type Id in POJO
                training.setTypeId(Integer.parseInt(obj[11].toString()));
                //trainingReturn.setTrainingId(trainingId);
                trainingReturn.add(training);
                //trainingReturn.set
                /***
                 *
                 */
                // -- System.out.println("the value of id==="+obj[0].toString());
            }



            //trainingReturn = (TrainingDetail)trainingList.get(0);
            //trainingList =session.createQuery("from Training t,Department d where t.id=d.id and t.trainingId:=trainingId").setParameter("trainingId",training.getTrainingId(),Hibernate.INTEGER).list();
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Training data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Training data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return trainingReturn;
    }

    /**
     * Get Department name and Id against
     * CompanyCode and status is 'Y'
     * @param deptCode
     * @return
     * @throws DAOException
     */
    public List<Department> getDeptByCompCode(String companyCode) throws DAOException {

        Session session = null;
        List<Department> departments = new ArrayList<Department>();
        //Object obj[] = null;
        if (companyCode == null || companyCode.trim().length() <= 0) {
            throw new DAOException("failed to fetch data for \"null\" deptCode");
        }
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching  SyCompany Detail");
            departments = session.createQuery("from Department d where d.status='Y' and d.companyCode=" + companyCode).list();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Department data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Department data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return departments;
    }

    /***
     * Pick up required parameters
     * DepartmentCode as deptCode
     * Employee ID as employeeId
     * CompanyCode as companyCode
     * Job Type as jobType
     * It is not now in system
     * @param empId
     * @return
     * @throws DAOException
     */
    public Map<String, String> getRequireParaetersForTraining(String empId) throws DAOException {

        Map<String, String> reqParam = new HashMap<String, String>();
        Session session = null;
        // --- Object obj[]=null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Require Parameters to run the System");

            //Iterator itr= session.createQuery("select e.deptId,e.employeeId,e.companyId,e.jobtype from EmpDetails e where e.employeeId="+empId).list().iterator();

            // ---  Iterator itr= session.createQuery("select e.employeeId from EmpDetails e where e.employeeId="+empId).list().iterator();

            // --- Iterator<EmpDetails> itrEmp=session.createQuery(" from EmpDetails e where e.employeeId="+empId).iterate();
            // ---=== Iterator<EmployeeMaster> itrEmp=session.createQuery(" from EmpDetails e where e.employeeId="+empId).iterate();
            Iterator<EmployeeMaster> itrEmp = session.createQuery(" from EmployeeMaster e where e.employeeId='" + empId + "'").iterate();
            /*
            for(;itr.hasNext();)
            {
            obj =(Object[]) itr.next();
            // ---reqParam.put("deptCode", obj[0].toString());
            reqParam.put("deptCode", "4"); // -- add for temporarily because of employee table modified
            reqParam.put("employeeId", obj[0].toString());
            // -- reqParam.put("companyCode", obj[2].toString());
            reqParam.put("companyCode", "1");// -- add for temporarily because of employee table modified
            // --- reqParam.put("typeId", obj[3].toString());
            reqParam.put("typeId", "2");// -- add for temporarily because of employee table modified
            // ---  System.out.println("@@@ typeID @@@"+ obj[3].toString());
            }
             */
            for (; itrEmp.hasNext();) {
                // ===EmpDetails empDtl =itrEmp.next();
                EmployeeMaster empDtl = itrEmp.next();

                // ===reqParam.put("deptCode", Integer.toString(empDtl.getEmployeejobpojo().getDepartmentId()));
                reqParam.put("deptCode", Integer.toString(empDtl.getDepartmentId().intValue()));
                if (empDtl.getId() != BigDecimal.ZERO) {
                    reqParam.put("employeeId", Integer.toString(empDtl.getId().intValue()));
                }
                // === reqParam.put("companyCode", Integer.toString(empDtl.getEmployeejobpojo().getCompanyId()));
         /*       if(empDtl.getBranch().getCompanyId()!=0){
                reqParam.put("companyCode", Integer.toString(empDtl.getBranch().getCompanyId()));
                }
                 *
                 */
                reqParam.put("companyCode", Integer.toString(2));

                // === reqParam.put("typeId", Integer.toString(empDtl.getEmployeejobpojo().getJobtypeId()));
                // === reqParam.put("typeId", Integer.toString(empDtl.getJobType().getTypeId()));
                if (empDtl.getTypeId() != BigDecimal.ZERO && empDtl.getTypeId()!=null) {
                    reqParam.put("typeId", Integer.toString(empDtl.getTypeId().intValue()));
                }else{
                    reqParam.put("typeId",Integer.toString(2));
                }

            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Login list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return reqParam;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<TrainingRequestMaster> getTrainingStatusReport() throws DAOException {

        List<TrainingRequestMaster> list = null;

        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            //String query = " from TrainingRequestMaster t where t.status='hrapprove' or t.status='hodapprove'";
            //list = session.createQuery(query).list();
            Criteria crit = session.createCriteria(TrainingRequestMaster.class);
            crit.add(Expression.or(Expression.eq("status", "hrapprove"), Expression.eq("status", "hodapprove")));

            list = crit.list();
            if (session.isOpen()) {
                for (TrainingRequestMaster tr : list) {
                    String s = tr.getTraining().getTrainingName();
                    System.out.println("" + s);
                }
            }

            session.getTransaction().commit();
            log.info("Comitted data successfully");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to commit data", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }

            return list;



        }

    }

    public TrainingRequestMaster getTrainingDetailsByRequestID(String requestID) throws DAOException {
        TrainingRequestMaster obj = null;
        BigDecimal b = new BigDecimal(requestID);

        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            obj = (TrainingRequestMaster) session.get(TrainingRequestMaster.class, b);
            if (obj == null) {
                obj = (TrainingRequestMaster) session.load(TrainingRequestMaster.class, b);
            }
            session.getTransaction().commit();
            log.info("Commited Successfully");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to commit data", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }

            return obj;
        }


    }

    public List<TrainingNeeds> getTrainingNeedsReportsForEmployees() throws DAOException {
        List<TrainingNeeds> lst = new ArrayList<TrainingNeeds>();
        List trainingneeds = new ArrayList();
        Object obj[] = null;
        Session session = null;

        try {

            session = getSession();
            session.beginTransaction();
            trainingneeds = session.createQuery("Select e.employeeId,e.firstName, s.category_name,c.category_code,c.score from EmployeeMaster e , AppraisalResultSum c,AppraisalCategory  s where e.employeeId=c.employee_code and c.category_code=s.category_code  and c.score<60").list();
            for (Iterator itr = trainingneeds.iterator(); itr.hasNext();) {
                obj = (Object[]) itr.next();
                TrainingNeeds nds = new TrainingNeeds();
                nds.setEmployeeId(obj[0].toString());
                nds.setFirstName(obj[1].toString());
                nds.setCategory_name(obj[2].toString());
                nds.setCategory_code(Integer.parseInt(obj[3].toString()));
                nds.setScore((int)Double.parseDouble(obj[4].toString()));
                lst.add(nds);

            }
            log.info("Exception Done");
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Training data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return lst;
    }

    public TrainingMaster getTrainingById(BigDecimal id)throws DAOException{
        Session session=null;
        TrainingMaster tm=null;
        try {
            session=getSession();
            session.beginTransaction();
            tm=(TrainingMaster)session.get(TrainingMaster.class, id);
            if(tm==null){
                tm=(TrainingMaster)session.load(TrainingMaster.class, id);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching trainign"+e);
        }
        finally{
            if(session!=null){
                session.flush();
                session.close();
            }
        }
        return tm;
    }
}
