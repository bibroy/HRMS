/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.EmployeeSkillDAO;
import com.pojo.EmpSkills;
import com.pojo.EmployeeSkill;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import org.hibernate.ObjectNotFoundException;

/**
 *
 * @author ranjans
 */
public class EmployeeSkillDAOImpl extends BaseDAO implements EmployeeSkillDAO {

    protected static final Log log = LogFactory.getLog(EmployeeSkillDAO.class);

    public boolean save(EmployeeSkill empskill) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving Skill details into database");
            session.saveOrUpdate(empskill);
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to save data due to integrity constratint violation");
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save breakUp data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }

    public EmployeeSkill getSkill(Integer SkillNameId, Integer EmpId) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<EmployeeSkill> getSkill(Integer EmpId) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public EmployeeSkillDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<EmployeeSkill> getAllEmployeeSkill() throws DAOException {

        List<EmployeeSkill> employeeSkillList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Grade");
            employeeSkillList = session.createQuery("from EmployeeSkill e where e.status='Y'").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeSkill list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeSkillList;
    }

    public EmployeeSkill getEmployeeSkill() throws DAOException {

        return new EmployeeSkill();
    }

    public List<EmployeeSkill> getEmployeeSkillByEmpId(String employeeMasterId) throws DAOException {
        List<EmployeeSkill> employeeSkillList = null;
        Session session = null;


        try {

            session = getSession();
            session.beginTransaction();
            String HQL = "from EmployeeSkill e where  e.employeeId='" + employeeMasterId + "'    ";
            System.out.print("********HQL*************" + HQL + "***************************");
            log.info("Fetching all Active Job");
            employeeSkillList = session.createQuery(HQL).list();

            session.getTransaction().commit();
//System.out.print("********employeeSkillList*************"+employeeSkillList+"***************************");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeSkill list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeSkillList;
    }

    public EmployeeSkill getEmployeeSkill(Integer employeeSkillId) throws DAOException {
        EmployeeSkill employeeSkill = null;
        Session session = null;

        if (employeeSkillId == null) {
            throw new DAOException("failed to fetch data for \"null\" EmployeeSkill id");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Grade Detail");
            employeeSkill = (EmployeeSkill) session.load(EmployeeSkill.class, employeeSkillId);
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeSkill data from database", e);
            throw new DAOException("wrong EmployeeSkill code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeSkill data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeSkill;
    }

    public EmployeeSkill getEmployeeSkillByCode(String employeeSkillCode) throws DAOException {

        return null;
    }

    public boolean delete(EmployeeSkill employeeSkill) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving EmployeeSkill details into database");
            session.delete(employeeSkill);
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to save data due to integrity constratint violation");
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save employeeSkill data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }

    public List<EmployeeSkill> getCheckEmpSkillByEmpIdAndSkillId(String employeeMasterId, Integer skillId) throws DAOException {
        List<EmployeeSkill> employeeSkillList = null;
        Session session = null;


        try {

            session = getSession();
            session.beginTransaction();
            String HQL = "from EmployeeSkill e where  e.employeeId='" + employeeMasterId + "' and e.skillId=" + skillId + "    ";
            System.out.print("********HQL*************" + HQL + "***************************");
            log.info("Fetching all Active Job");
            employeeSkillList = session.createQuery(HQL).list();

            session.getTransaction().commit();
//System.out.print("********employeeSkillList*************"+employeeSkillList+"***************************");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeSkill list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeSkillList;
    }

    public List<EmployeeSkill> getEmployeeSkillIDAndNameCall(String SkillID, String empid) throws DAOException {
        List<EmployeeSkill> obj = null;
        Session session = null;
        ;
        try {
            session = getSession();
            session.beginTransaction();

            obj = session.createQuery("from EmployeeSkill e where e.skillId='" + SkillID + "' and e.employeeId='" + empid + "' ").list();

            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeSkill list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return obj;


    }

    public boolean save(EmpSkills empskillobj) throws DAOException {

        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(empskillobj);
            session.getTransaction().commit();
            log.info("Data save successfully in database");


        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save EmployeeMaster data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }

        }
        return true;

    }

    public Integer getLastRequestId() throws DAOException {

        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last id");
            l = session.createQuery("select max(id) from EmpSkills").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
                if (b != null) {
                    i = b;
                }
//                Object[] row = (Object[]) iter.next();
//                if(row[0]!=null)
//                {
//                BigDecimal b=(BigDecimal)row[0];
//                i = b;
//                }
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

    public EmpSkills getEmployeeSkillbyempId(String emp) throws DAOException {

        EmpSkills obj = null;


        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            String HQL = "   from EmpSkills e where e.employeid='" + emp + "'";
            obj = (EmpSkills) session.createQuery(HQL).uniqueResult();
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
}
