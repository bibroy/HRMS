/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.DesignationDAO;

import com.dao.BaseDAO;
import java.math.BigDecimal;
import java.util.List;
import com.dao.DAOException;
import com.pojo.DesignationMaster;
import java.math.BigDecimal;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Shrayanti Bhattacharyya
 */
public class DesignationDAOImpl extends BaseDAO implements DesignationDAO {

    protected static final Log log = LogFactory.getLog(DesignationDAO.class);

    public DesignationDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<DesignationMaster> getAllDesignation() throws DAOException {
        Session session = null;
        List<DesignationMaster> designationList = null;

        try {
            System.out.print("*************************getAllDesignation*****************************");
            session = getSession();
            System.out.print("*************************getAllDesignation getSession*****************************");
            session.beginTransaction();

            log.info("Fetching all Active Designation");
            designationList = session.createQuery("from DesignationMaster d where d.status='Y'").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Designation list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return designationList;
    }

    public DesignationMaster getDesignation() throws DAOException {

        return new DesignationMaster();
    }

    public DesignationMaster getDesignation(String designationId) throws DAOException {

        try {
            Integer dId = new Integer(designationId);
            return getDesignation(dId);

        } catch (NumberFormatException ne) {
            log.warn("Designation ID is not valid");

        }

        return null;
    }

    public DesignationMaster getDesignation(Integer designationId) throws DAOException {
        DesignationMaster designation = null;


        Session session = null;
        BigDecimal b = new BigDecimal(designationId);
        if (designationId == null) {
            throw new DAOException("failed to fetch data for \"null\" Designation id");
        }

        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Designation Detail");
            designation = (DesignationMaster) session.load(DesignationMaster.class, b);
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Designation data from database", e);
            throw new DAOException("wrong designation code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Designation data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
            log.info("done");
           

            return designation;
        }
    }

    public boolean save(DesignationMaster designation) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving Designation details into database");
            session.saveOrUpdate(designation);
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
            log.error("failed to save Designation data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }
     return true;
    }

   

    public List<DesignationMaster> getDesignationByCompanyCode(Integer CompCode) throws DAOException {
        Session session = null;
        List<DesignationMaster> dlist = null;
        try {
            session = getSession();
            session.beginTransaction();
            dlist = session.createQuery("from DesignationMaster d where d.companyCode=" + CompCode.toString()).list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching list of department by company code " + e);
        }
        return dlist;
    }
}
