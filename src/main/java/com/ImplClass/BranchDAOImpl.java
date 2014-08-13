/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.BranchDAO;
import com.dao.DAOException;
import com.pojo.BranchMaster;
import java.math.BigDecimal;
import java.util.ArrayList;
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
 * @author Sumit Kumar
 */
public class BranchDAOImpl extends BaseDAO implements BranchDAO {

    protected static final Log log = LogFactory.getLog(BranchDAO.class);

    public BranchDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public boolean save(BranchMaster branch) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving branch details into database");
            log.info(branch.getBranchCountryid() + " " + branch.getBranchStateid() + " " + branch.getBranchCityid());
            session.saveOrUpdate(branch);
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
            log.error("failed to save branch data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }

    public BigDecimal getLastRequestId() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(branchId) from BranchMaster").list();
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

    public String getCurrency(Integer countryId) throws DAOException {

        String currency = null;
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving currency details into database");
            currency = (String) session.createQuery("select CountryMaster.currencyAbreviation from CountryMaster country where CountryMaster.countryId=" + countryId).uniqueResult();
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
            log.error("failed to save branch data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return currency;
    }

    public List getAllBranchOfCompany(Integer companyId) throws DAOException {
        List branchList = null;
        List returnbranchList = new ArrayList();
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving currency details into database");
            branchList = session.createQuery("from BranchMaster branch where branch.status='Y'and branch.company=" + companyId).list();
            if (branchList != null && branchList.size() > 0) {
                for (int i = 0; i < branchList.size(); i++) {
                    BranchMaster branch = (BranchMaster) branchList.get(i);
                    returnbranchList.add(branch);
                }
            }
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
            log.error("failed to save branch data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }
        return returnbranchList;
    }

     public BranchMaster getBranch(BigDecimal branchid) throws DAOException {
         BranchMaster bMaster = null;
        Session session = null;


        try {

            session = getSession();
            session.beginTransaction();
            String HQL = "from BranchMaster e where e.branchId="+branchid+"";
            System.out.print("********HQL*************" + HQL + "***************************");
            log.info("Fetching all branch");
            bMaster = (BranchMaster) session.createQuery(HQL).uniqueResult();

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read branch data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return bMaster;
    }

    

    // pradipto
    public List<BranchMaster> getAllBranches() throws DAOException {
        List<BranchMaster> branchobj = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching All Branch details");
            branchobj = session.createQuery("from BranchMaster b").list();

            session.getTransaction().commit();


        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read EmployeeCertification list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return branchobj;


    }

    public BranchMaster getBranchNameByBranchID(Integer branchID) throws DAOException {
        BranchMaster br = null;
        Session session = null;
        BigDecimal b = new BigDecimal(branchID);
        try {
            session = getSession();
            session.beginTransaction();
            br = (BranchMaster) session.load(BranchMaster.class, b);

            session.getTransaction().commit();
            log.info("Transaction completed");
        } catch (Exception e) {

            log.error("En aeaception occur exception type is:" + e);

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return br;
    }
}
