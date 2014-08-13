/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.EmployeeMasterDAO;
import com.dao.DAOException;
import com.pojo.EmployeeMaster;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author sudipb
 */
public class EmployeeMasterDAOImpl extends BaseDAO implements EmployeeMasterDAO {

    protected static final Log log = LogFactory.getLog(EmployeeMasterDAO.class);

    public EmployeeMasterDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<EmployeeMaster> getAllEmployeeMaster() throws DAOException {

        List<EmployeeMaster> employeeMasterList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active EmployeeMaster");
            employeeMasterList = (List<EmployeeMaster>)session.createQuery("from EmployeeMaster e where e.status='Y'").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeMaster list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeMasterList;
    }

    public List<EmployeeMaster> getEmployeeInformationByDepartmentID(Integer departmentid) throws DAOException {
        /*Method created by  pradipto */


        List<EmployeeMaster> list = null;

        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            list = session.createQuery("select e from EmployeeMaster e where e.departmentId=" + departmentid.toString()).list();
            session.getTransaction().commit();
            log.info("Commited over");






        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Job list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return list;



    }

    public BigDecimal getLastRequestId() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from EmployeeMaster").list();
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

    public EmployeeMaster getEmployeeMaster() throws DAOException {

        return new EmployeeMaster();
    }

    public EmployeeMaster getEmployeeMasterByEmpId(String employeeMasterId) throws DAOException {
        EmployeeMaster employeeMaster = null;
        Session session = null;


        try {

            session = getSession();
            session.beginTransaction();
           // String sql="select * from EMPLOYEE_MASTER where EMPLOYEE_ID='"+employeeMasterId+"' and STATUS='y'";
            String HQL = "from EmployeeMaster e where e.status='Y' AND e.employeeId='" + employeeMasterId + "'";
            System.out.print("********HQL*************" + HQL + "***************************");
            log.info("Fetching all Active Job");
            employeeMaster = (EmployeeMaster) session.createQuery(HQL).uniqueResult();
           // employeeMaster=(EmployeeMaster)session.createSQLQuery(sql).uniqueResult();

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Job list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeMaster;
    }

    public EmployeeMaster getEmployeeMaster(Integer employeeMasterId) throws DAOException {
        EmployeeMaster employeeMaster = null;
        Session session = null;

        if (employeeMasterId == null) {
            throw new DAOException("failed to fetch data for \"null\" EmployeeMaster id");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching EmployeeMaster Detail");
            employeeMaster = (EmployeeMaster) session.load(EmployeeMaster.class, new BigDecimal(employeeMasterId));
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeMaster data from database", e);
            throw new DAOException("wrong EmployeeMaster code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeMaster data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeMaster;
    }

    public List<EmployeeMaster> getEmployeeByBranchID(String branchid) throws DAOException {

        List<EmployeeMaster> list = null;

        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching Employee by Branch ID");
            list = session.createQuery("from EmployeeMaster e where e.branchId='" + branchid + "'").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Job list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return list;

    }

    public EmployeeMaster getEmployeeMasterByCode(String EmployeeMasterCode) throws DAOException {

        return null;
    }

    public boolean save(EmployeeMaster employeeMaster) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving EmployeeMaster details into database");
            session.saveOrUpdate(employeeMaster);
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
            log.error("failed to save EmployeeMaster data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }

        }

        return true;
    }

    public List<EmployeeMaster> getEmployeeInformationByGrades(String grades) throws DAOException {
        List<EmployeeMaster> list = null;
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("from EmployeeMaster e where e.grade='" + grades + "'").list();
            session.getTransaction().commit();
            log.info("Transaction Commited data is retreived in list");

            log.info("Codding by Pradipto over");



        } catch (Exception e) {

            log.error("An exception occur.Exception type is :" + e);

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return list;



    }

    public List<EmployeeMaster> getOrganizationStructure() throws DAOException {

        List list = null;
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            list = session.createSQLQuery("SELECT EMPLOYEE_ID,FIRST_NAME,LAST_NAME,SUPERVISOR_ID,LEVEL-1 , SYS_CONNECT_BY_PATH(LAST_NAME,'/' from EMPLOYEE_MASTER START WITH EMPLOYEE_ID='111' CONNECT BY PRIOR employee_id=supervisor_id;").list();

            session.getTransaction().commit();
            log.info("Organization Data Commited Successfully");


        } catch (Exception e) {

            log.error("An exception generated exception type is :" + e);

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }


        return list;

    }

    public EmployeeMaster getDepartmentId(String employeeMasterId) throws DAOException {
               EmployeeMaster employeeMaster = null;
        Session session = null;


        try {

            session = getSession();
            session.beginTransaction();
            String HQL = "from EmployeeMaster e where e.status='Y' AND e.employeeId='" + employeeMasterId + "'    ";
            System.out.print("********HQL*************" + HQL + "***************************");
            log.info("Fetching all Active Job");
            employeeMaster = (EmployeeMaster) session.createQuery(HQL).uniqueResult();

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Job list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return employeeMaster;
    }

}
