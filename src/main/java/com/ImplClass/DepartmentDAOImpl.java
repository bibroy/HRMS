/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import java.util.List;
import com.dao.DAOException;
import com.dao.DepartmentDAO;
import com.pojo.Department;
import java.math.BigDecimal;
import java.util.Iterator;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;
import java.math.BigDecimal;

/**
 *
 * @author Shrayanti Bhattacharyya
 */
public class DepartmentDAOImpl extends BaseDAO implements DepartmentDAO {

    protected static final Log log = LogFactory.getLog(DepartmentDAO.class);

    public DepartmentDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<Department> getAllDepartment() throws DAOException {
        Session session = null;
        List<Department> departmentList = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Department");
            departmentList = session.createQuery("from Department d where d.status='Y'").list();
            session.getTransaction().commit();
            log.info("All data is retreive sucessfully");

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

    public BigDecimal getLastRequestId() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(departmentId) from Department").list();
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

    public Department getDepartment() throws DAOException {

        return new Department();
    }

    public Department getDepartment(String departmentId) throws DAOException {

        try {
            Integer deptId = new Integer(departmentId);
            return getDepartment(deptId);

        } catch (NumberFormatException ne) {
            log.warn("Department ID is not valid");

        }

        return null;
    }

    public Department getDepartment(Integer departmentId) throws DAOException {
        Department department = null;
        Session session = null;
        BigDecimal b= new BigDecimal(departmentId);
        if (departmentId == null) {
            throw new DAOException("failed to fetch data for \"null\" Department id");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Department Detail");
            department = (Department) session.get(Department.class, b);
            if(department!= null){
                String name=department.getDepartmentName();
                name=null;
            }
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Department data from database", e);
            throw new DAOException("wrong department code");
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

        return department;
    }

    public Department getDepartmentByCode(String departmentCode) throws DAOException {

        return null;
    }

    public boolean save(Department department) throws DAOException {
        Session session = null;

        try {
            System.out.print("*************************Action addDepartment save try *****************************");
            session = getSession();
            System.out.print("*************************Action addDepartment save getSession *****************************");
            session.beginTransaction();
            log.info("saving Department details into database");
            session.saveOrUpdate(department);
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
            log.error("failed to save Department data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }

    public List<Department> getDepartmentByCompanyCode(Integer CompCode) throws DAOException {
        Session session=null;
        List<Department> deptlist=null;
        try {
            session=getSession();
            session.beginTransaction();
            deptlist=session.createQuery("from Department d where d.companyCode="+CompCode.toString()).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching list of department by company code "+e);
        }
        return deptlist;
    }
    

}
