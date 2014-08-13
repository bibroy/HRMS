/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.SkillsDAO;
import com.pojo.Department;
import com.pojo.Skills;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;

/**
 *
 * @author ranjans
 */
public class SkillsDAOImpl extends BaseDAO implements SkillsDAO {

    protected static final Log log = LogFactory.getLog(SkillsDAO.class);

    public SkillsDAOImpl() {
    }

    /***
     * Get skills whoes status is 'A' active
     * @return
     * @throws DAOException
     */
    public List<Skills> getSkills() throws DAOException {
        Session session = null;
        List<Skills> skills = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Skills");
            skills = session.createQuery("from Skills s where s.status='A'").list();
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

        return skills;
    }

    public BigDecimal getLastRequestId() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from EmployeeSkill").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                BigDecimal b = (BigDecimal) iter.next();
                if (b != null) {
                    i = b;
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

    /***
     * Get
     * All skills
     * @return
     * @throws DAOException
     */
    public List<Skills> getAllSkils() throws DAOException {
        Session session = null;
        List<Skills> skills = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Skills");
            skills = session.createQuery("from Skills s where s.status='A'").list();
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

        return skills;
    }

    /***
     * Get All skills Against D
     * @return
     * @throws DAOException
     */
    public List<Skills> getAllSkilsAgainstDesig() throws DAOException {
        List<Skills> skills = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            // -- generate the query add Designation Name
            skills = session.createQuery("from Skills s where s.status='A'").list();
            session.getTransaction().commit();
            log.info("Fetching all Skills with particular Designation");
        } catch (Exception ex) {
            session.getTransaction().rollback();
            log.error("failed to read Skills list data from database", ex);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return skills;
    }

    /***
     * Get skills whoes status is Y
     * @return
     * @throws DAOException
     */
    public Skills getSkills(Skills skills) throws DAOException {
        Skills skill = null;
        Session session = null;

        if (skills.getSkillId() == 0) {
            throw new DAOException("failed to fetch data for \"null\" company id");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Company Detail");
            skill = (Skills) session.get(Skills.class, skills.getSkillId());
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read City data from database", e);
            throw new DAOException("wrong country code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read City data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return skill;
    }

    /***
     * change status of the particular ID
     * @return
     * @throws DAOException
     */
    public boolean changeStatus(Skills skills) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /***
     * Add a particular Skill
     * @return
     * @throws DAOException
     */
    public boolean addSkill(Skills skills) throws DAOException {
        boolean flag = false;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(skills);
            session.getTransaction().commit();
            log.info("Add Skills");
            flag = true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            log.error("Failed to update", ex);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return flag;
    }

    /***
     * Update a particuar Skill
     * @return
     * @throws DAOException
     */
    public boolean updateSkill(Skills skills) throws DAOException {
        boolean flag = false;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(skills);
            session.getTransaction().commit();
            log.info("Update Skills");
            flag = true;
        } catch (Exception ex) {
            session.getTransaction().rollback();
            log.error("Failed to update", ex);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return flag;
    }

    /***
     * delete a particular skill
     * @return
     * @throws DAOException
     */
    public boolean deleteSkill(Skills skills) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /***
     * select Department By companyCode
     * @param companyCode
     * @return
     * @throws DAOException
     */
    public List<Department> getDepartmentByCompanyCode(int companyCode) throws DAOException {
        Session session = null;
        List<Department> departmentList = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Department @@@" + companyCode);
            departmentList = session.createQuery("from Department c where c.Status='Y' and c.companyCode=:companyCode").setParameter("companyCode", companyCode, Hibernate.INTEGER).list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Department list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return departmentList;
    }

    /***
     * Pick up only that values whoes status is active 'A'
     * @param departmentId
     * @return
     * @throws DAOException
     */
    public List<Skills> getSkillsByDepartment(int departmentId) throws DAOException {
        List<Skills> skills = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Skills" + departmentId);
            skills = session.createQuery("from Skills s where s.status='A' and department_id=:departmentId").setParameter("departmentId", departmentId, Hibernate.INTEGER).list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Skills list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return skills;
    }

    /***
     * Pick skills against JobType
     * @param typeId
     * @return
     * @throws DAOException
     */
    public List<Skills> getSkillsByJobType(int typeId) throws DAOException {
        List<Skills> skills = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Skills");
            skills = session.createQuery("from Skills s where s.status='A' and typeId=:typeId").setParameter("typeId", typeId, Hibernate.INTEGER).list();
            session.getTransaction().commit();
        } catch (DAOException dae) {
            session.getTransaction().rollback();
            log.error("failed to read Skills list data from database", dae);
            throw new DAOException(dae.getMessage(), dae.getCause());

        } catch (Exception e) {
            log.error("failed to read Skills list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        }
        return skills;
    }

    public Skills getSkillbyID(BigDecimal id) throws DAOException {
        Skills skobj = null;
        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            skobj = (Skills) session.get(Skills.class, id);
            if (skobj == null) {
                skobj = (Skills) session.load(Skills.class, id);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Skills list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return skobj;
    }
}
