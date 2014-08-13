/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOFactory;
import com.dao.DAOException;
import com.dao.SalaryDAO;
import com.pojo.SalaryBreakup;
import com.pojo.SalaryHead;
import com.forms.SalaryForm;
import java.math.BigDecimal;
import org.hibernate.Session;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import java.util.Iterator;
import java.util.List;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

/**
 *
 * @author Sumit Kumar
 */
public class SalaryDAOImpl extends BaseDAO implements SalaryDAO {

    protected static final Log log = LogFactory.getLog(SalaryDAO.class);

    public Double getAdvancedSalById(String id, Integer month, Integer year) throws DAOException {
        Double advSal=0.0;
        List list=null;
        Session session=null;
        try {
            session=getSession();
            session.beginTransaction();
            list=session.createQuery("select sum(a.appliedamount) from AdvancedSalaryRequest a where a.employeeId='"+id+"' and to_char(a.deductionstartmonth,'mm')='"+month.toString()+"' and to_char(a.deductionstartmonth,'yyyy')='"+year.toString()+"' and approvalstatus='A'").list();
            if(list!=null)
            {
                advSal=(Double)list.get(0);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error while fetching advanced salary "+e.getMessage());
        }
        return advSal;
    }

    public Double getLeaveDays(String id, Integer month, Integer year) throws DAOException {
        Double days=0.0;
        List list=null;
        Session session=null;
        try {
            session=getSession();
            session.beginTransaction();
            list=session.createQuery("select sum(l.noofdays) from Leave l where l.leavestatus='A' and l.empid='"+id+"' and to_char(l.fromDate,'mm')='"+month.toString()+"' and to_char(l.fromDate,'yyyy')='"+year.toString()+"'").list();
            if(list!=null)
            {
                days=(Double)list.get(0);
            }
            session.getTransaction().commit();
            
        } catch (Exception e) {
            log.error("error fetching leave days "+e.getMessage());
        }
        return days;
    }

    public List<SalaryBreakup> getSalaryList() throws DAOException {
        List<SalaryBreakup> list = null;
        Session session = null;
        try {
            session=getSession();
            session.beginTransaction();
            list=session.createQuery("from SalaryBreakup s").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching salarybreakup "+e.getMessage());
        }
        return list;
    }

    public Double getSalarybyId(String id) throws DAOException {
        Session session = null;
        Double basicSal = 0.0;
        List list = null;
        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("select s.amount from SalaryBreakup s where s.employeeid='" + id + "'").list();

            if (list != null) {
                basicSal = (Double) list.get(0);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching data " + e.getMessage());
        }
        return basicSal;
    }

    public boolean save(SalaryBreakup sb) throws DAOException {
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(sb);
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

    public BigDecimal getId(String empId) throws DAOException {
        List list = null;
        BigDecimal id = BigDecimal.ZERO;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("select s.id from SalaryBreakup s where s.employeeid='" + empId + "'").list();
            if (list != null) {
                id = (BigDecimal) list.get(0);
            }
            session.getTransaction().commit();
            
        } catch (Exception e) {
            log.error("query resulted into exception " + e.getMessage());
        }

        return id;
    }

    public SalaryBreakup getSalaryBreakupById(BigDecimal id) throws DAOException {
        Session session=null;
        SalaryBreakup sb=null;
        List list=null;
        try {
            session=getSession();
            session.beginTransaction();
            list=session.createQuery("from SalaryBreakup s where s.id="+id.toString()).list();
            if(list!=null)
            {
                sb=(SalaryBreakup)list.get(0);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the salary breakup "+e.getMessage());
        }
        
        return sb;

    }


}
