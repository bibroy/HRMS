/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.JobTypeDAO;
import com.pojo.Company;
import com.pojo.Department;
import com.pojo.JobType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ranjans
 */
public class JobTypeDAOImpl extends BaseDAO implements JobTypeDAO {

    protected static final Log log = LogFactory.getLog(JobTypeDAO.class);

    /***
     *
     */
    public JobTypeDAOImpl() {
    }

    /***
     * Insert JobType
     * @param jobType
     * @return
     * @throws DAOException
     */
    public List<JobType> getAllJobType() throws DAOException {
        Session session = null;
        List<JobType> JobList = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Department");
            JobList = session.createQuery("from JobType j where j.enabled='Y'").list();
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

        return JobList;
    }

    public boolean insertJobType(JobType jobType) throws DAOException {
        boolean flg = false;
        Session session = null;
        Transaction transaction = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(jobType);
            transaction.commit();
            log.info("Insert JobType");
            flg = true;
        } catch (Exception e) {
            transaction.rollback();
            log.error("failed to session data from database", e);
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
     * Update the JobType
     * @param jobType
     * @return
     * @throws DAOException
     */
    public boolean updateJobType(JobType jobType) throws DAOException {
        boolean flg = false;
        Session session = null;
        Transaction transaction = null;
        try {
            session = getSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(jobType);
            transaction.commit();
            log.info("Insert JobType");
            flg = true;
        } catch (Exception e) {
            transaction.rollback();
            log.error("failed to session data from database", e);
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
     * Soft delet the JobType
     * @param jobType
     * @return
     * @throws DAOException
     */
    public boolean deleteJobType(JobType jobType) throws DAOException {
        boolean flg = false;
        Session session = null;
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /***
     * get JobType against
     * depertmentId and companycode
     * @param depertment
     * @return
     * @throws DAOException
     */
    public List<JobType> getJobTypeAgainstDepertment(JobType jobType) throws DAOException {
        Session session = null;
        List jobTypes = new ArrayList();
        List<JobType> jobTypesReturn = new ArrayList<JobType>();
        Object obj[] = null;
        if (jobType.getId() == 0) {
            throw new DAOException("failed to fetch data for \"null\" deptCode");
        }
        if (jobType.getCompanyCode() == 0) {
            throw new DAOException("failed to fetch data for \"null\" companyCode");
        }
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching  SyCompany Detail");
            jobTypes = session.createQuery("select j.typeId,j.jobname,j.typeId,j.company from JobType j , Department d where d.status='Y' and j.id=" + jobType.getId() + " and j.company=" + jobType.getCompanyCode() + " and j.enabled='Y'  and d.departmentId=j.typeId and d.departmentId=" + jobType.getId()).list();
            System.out.println("@@@ Length @@@" + jobTypes.size());
            for (Iterator itr = jobTypes.iterator(); itr.hasNext();) {
                System.out.println("@@@ Befor OBJ");
                obj = (Object[]) itr.next();
                System.out.println("@@@ after obj @@@");
                JobType jobTypeTemp = new JobType();
                jobTypeTemp.setTypeId(new BigDecimal(obj[0].toString()));
                jobTypeTemp.setJobName(obj[1].toString());
                Company com=(Company)obj[3];
                jobTypeTemp.setId(Integer.parseInt(obj[2].toString()));
                jobTypeTemp.setCompanyCode(com.getCompanyCode().intValue());
                jobTypeTemp.setCompany(com);
                jobTypesReturn.add(jobTypeTemp);
            }
            session.getTransaction().commit();

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

        return jobTypesReturn;
    }

    /***
     *
     * @param jobType
     * @return
     * @throws DAOException
     */
    public JobType getJobType(JobType jobType) throws DAOException {
        Session session = null;
        List jobTypes = new ArrayList();
        JobType jobTypeTemp = new JobType();
        Object obj[] = null;
        if (jobType.getId() == 0) {
            throw new DAOException("failed to fetch data for \"null\" deptCode");
        }
        if (jobType.getCompanyCode() == 0) {
            throw new DAOException("failed to fetch data for \"null\" companyCode");
        }
        if (jobType.getTypeId() == BigDecimal.ZERO) {
            throw new DAOException("failed to fetch data for \"null\" typeID");
        }
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching  SyCompany Detail");
            jobTypes = session.createQuery("select j.typeId,j.jobname,j.typeId,j.company,j.enabled from JobType j , Department d where d.status='Y' and j.typeId=" + jobType.getId() + " and j.company=" + jobType.getCompanyCode() + " and j.enabled='Y'  and d.departmentId=j.department ").list();
            log.info("@@@ Length @@@" + jobTypes.size());
            for (Iterator itr = jobTypes.iterator(); itr.hasNext();) {
                obj = (Object[]) itr.next();
                jobTypeTemp.setTypeId(new BigDecimal(obj[0].toString()));
                jobTypeTemp.setJobName(obj[1].toString());
                jobTypeTemp.setId(Integer.parseInt(obj[2].toString()));
                Company com=(Company)obj[3];
                jobTypeTemp.setCompanyCode(com.getCompanyCode().intValue());
                jobTypeTemp.setCompany(com);
                jobTypeTemp.setEnabled(obj[4].toString());
            }

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

        return jobTypeTemp;
    }

    public Integer getLastId() throws DAOException {
        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(typeId) from JobType").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                BigDecimal b = (BigDecimal) iter.next();
                if (b != null) {
                    i = b.intValue();
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

    public List<JobType> getJobtypeByComanyDepartmentID(String departmentid, String companyid) throws DAOException {
        List<JobType> list = null;

        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();

            String query = "from JobType j where j.department="+ departmentid +" and j.company=" + companyid + " and j.enabled='Y'";
            list = session.createQuery(query).list();
            session.getTransaction().commit();
            log.info("Data Retreive Successfully");


        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("Failed to retreive all data", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return list;
    }
}
