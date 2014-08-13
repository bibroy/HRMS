/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.EmpProjRelocationHistoryDAO;
import com.pojo.EmpProjRelocationHistory;
import com.util.EmpProjRelcHistUtil;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

/**
 *
 * @author Sumit Kumar
 */
public class EmpProjRelocationHistoryDAOImpl extends BaseDAO implements EmpProjRelocationHistoryDAO {

    protected static final Log log = LogFactory.getLog(EmpProjRelocationHistoryDAO.class);

    public List<EmpProjRelocationHistory> getRelocationHistoryByEmpId(String empid) throws DAOException {
        Session session = null;
        List<EmpProjRelocationHistory> eplist = null;
        try {
            session = getSession();
            session.beginTransaction();
            eplist = session.createQuery("from EmpProjRelocationHistory e where e.empId='" + empid + "'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching lsit of employee relocation history " + e);
            session.getTransaction().rollback();
            throw new DAOException("unkown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return eplist;
    }

    public EmpProjRelocationHistory getRelocationHistoryById(BigDecimal id) throws DAOException {
        Session session = null;
        EmpProjRelocationHistory epr = null;
        try {
            session = getSession();
            session.beginTransaction();
            epr = (EmpProjRelocationHistory) session.get(EmpProjRelocationHistory.class, id);
            if (epr == null) {
                epr = (EmpProjRelocationHistory) session.load(EmpProjRelocationHistory.class, id);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error during fetching of emp project relocation history " + e);
            session.getTransaction().rollback();
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return epr;
    }

    public boolean save(EmpProjRelocationHistory eprh) throws DAOException {
        Session session = null;
        boolean result = false;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(eprh);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            log.error("error saving the emp project relocation history " + e);
            session.getTransaction().rollback();
            throw new DAOException("unkown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return result;
    }

    public BigDecimal getLastId() throws DAOException {
        BigDecimal i = new BigDecimal(0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from EmpProjRelocationHistory").list();
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

    public List<EmpProjRelcHistUtil> getAllRelocationHistory() throws DAOException {
        Session session = null;
        List<EmpProjRelocationHistory> eprhlist = null;
        List<EmpProjRelcHistUtil> eprlist = new ArrayList<EmpProjRelcHistUtil>();
        BaseDAO b = new BaseDAO();

        try {
            session = getSession();
            session.beginTransaction();
            eprhlist = session.createQuery("from EmpProjRelocationHistory").list();
            if (eprhlist != null) {
                for (EmpProjRelocationHistory ep : eprhlist) {
                    EmpProjRelcHistUtil eu = new EmpProjRelcHistUtil();
                    eu.setEmpId(ep.getEmpId());
                    eu.setFromJob(ep.getFromJob().getJobName());
                    eu.setFromProj(ep.getFromProj().getProjectName());
                    eu.setId(ep.getId().intValue());
                    eu.setRelocationDate(b.mySQLscreenDateFormat(ep.getRelocationDate()));
                    eu.setToJob(ep.getToJob().getJobName());
                    eu.setToProj(ep.getToProj().getProjectName());

                    eprlist.add(eu);
                }
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching list of empproject relocation history data " + e);
            session.getTransaction().rollback();
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return eprlist;
    }
}
