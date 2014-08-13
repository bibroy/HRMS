/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;
import com.dao.CompensationDao;
import com.dao.DAOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;
import com.dao.BaseDAO;
import org.hibernate.Session;
import java.util.List;
import com.pojo.AppraisalEmpInfo;
import com.pojo.Attendence;
import com.pojo.CompensationIncrementBand;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.Query;
import com.pojo.CompensationIndicatorMaster;
import com.pojo.CompensationPerformanceIndicator;
import org.hibernate.ObjectNotFoundException;
import com.pojo.CompensationPerformancesheet;
import com.pojo.CompensationCalculatedScore;
import java.math.BigDecimal;
/**
 *
 * @author computer1
 */
public class CompensationDAOImpl extends BaseDAO implements CompensationDao  {
      protected static final Log log = LogFactory.getLog(CompensationDao.class);
     public Integer getLastId() throws DAOException {
        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last compensation id");
            l = session.createQuery("select max(id) from CompensationIncrementBand").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
                if (b != null) {
                    i = b;
                }
            }
        } catch (NullPointerException npe) {
            //session.getTransaction().rollback();
            log.error("null value");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read Leave last Id from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return i;
    }
      public Integer getLastIdForIndicator() throws DAOException{
          Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last compensationIndicator id");
            l = session.createQuery("select max(id) from CompensationPerformanceIndicator").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
                if (b != null) {
                    i = b;
                }
            }
        } catch (NullPointerException npe) {
            //session.getTransaction().rollback();
            log.error("null value");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read Leave last Id from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return i;

      }
      public boolean saveIndicator(CompensationPerformanceIndicator cpi) throws DAOException{
          Session session = null;
           try {
            session = getSession();
            session.beginTransaction();
            log.info("saving indicator into into database");
            session.saveOrUpdate(cpi);
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
            log.error("failed to save Appraisal Result data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;

      }
public boolean save(CompensationIncrementBand cib) throws DAOException{
    Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving increment bands into database");
            session.saveOrUpdate(cib);
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
            log.error("failed to save Appraisal Result data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }
 public List<CompensationIndicatorMaster> getIndicator() throws DAOException{

        Session session = null;
        List<CompensationIndicatorMaster> indicatorList = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Department");
            indicatorList = session.createQuery("from CompensationIndicatorMaster").list();
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

        return indicatorList;
    }
  public List<CompensationPerformanceIndicator> getperformanceIndicator(Integer companyid,Integer departmentid,Integer designationid) throws DAOException{
      Session session = null;
        List<CompensationPerformanceIndicator> indicatorList = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Department");
//            indicatorList = session.createQuery("from CompensationPerformanceIndicator c where c.company="+companyid+" AND c.department="+departmentid+" AND c.designation="+designationid+" ").list();
            indicatorList=session.createQuery("from CompensationPerformanceIndicator cp where cp.id = (select max(ci.id) from CompensationPerformanceIndicator ci where ci.indicator=cp.indicator and ci.company=cp.company and ci.department=cp.department and ci.designation=cp.designation )and cp.company="+companyid+" and cp.department="+departmentid+" and cp.designation="+designationid+" ").list();
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

        return indicatorList;

  }
   public CompensationIndicatorMaster getIndicatorById(Integer indicatorid) throws DAOException{
        CompensationIndicatorMaster  cim = null;
        Session session = null;
        Integer b=indicatorid;
        if(indicatorid==null) {
			throw new DAOException("failed to fetch data for \"null\" Designation id");
		}


        try {
            session = getSession();
            session.beginTransaction();
       //     log.info("fetching Compensation indicator Detail");
           cim = (CompensationIndicatorMaster) session.get(CompensationIndicatorMaster.class, b);
//            log.info("done");
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

        return cim;
    }
   public boolean savePerformanceSheet(CompensationPerformancesheet cps) throws DAOException{
       Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving increment bands into database");
            session.saveOrUpdate(cps);
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
            log.error("failed to save Appraisal Result data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }
    public Integer getLastIdForPerformancesheet() throws DAOException{
         Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last compensationIndicator id");
            l = session.createQuery("select max(id) from CompensationPerformancesheet").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
                if (b != null) {
                    i = b;
                }
            }
        } catch (NullPointerException npe) {
            //session.getTransaction().rollback();
            log.error("null value");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read Leave last Id from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return i;

    }
     public List<CompensationPerformancesheet> scorecalculation(String emplid) throws DAOException{
          Session session = null;
        List<CompensationPerformancesheet> performanceList = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Department");
           performanceList= session.createQuery("from CompensationPerformancesheet where performancedate = (select max(performancedate) from CompensationPerformancesheet  where empid='"+ emplid+"')").list();


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

        return performanceList;
    }
      public Integer getLastIdForcalculation() throws DAOException{
         Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last compensationIndicator id");
            l = session.createQuery("select max(id) from CompensationCalculatedScore").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
                if (b != null) {
                    i = b;
                }
            }
        } catch (NullPointerException npe) {
            //session.getTransaction().rollback();
            log.error("null value");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read Leave last Id from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return i;

    }
        public boolean savecalculatedscore(CompensationCalculatedScore cps) throws DAOException{
       Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving calculated score into database");
            session.saveOrUpdate(cps);
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
            log.error("failed to save Appraisal Result data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }
         public List<CompensationIncrementBand> getIncrementBand() throws DAOException{
              Session session = null;
        List<CompensationIncrementBand> increment= null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Department");
           increment= session.createQuery("from CompensationIncrementBand where status='initialized')").list();


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

        return increment;
    }
         public CompensationIncrementBand getIncrementBand(Integer id) throws DAOException {
       Session session=null;
      CompensationIncrementBand tsd=null;

       try {
            session=getSession();
            session.beginTransaction();
            tsd=(CompensationIncrementBand)session.load(CompensationIncrementBand.class,id);
            if(tsd!=null){
                Integer i=tsd.getCompany();
                i=null;
            }
            session.getTransaction().commit();
        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read TimesheetDetail from database", e);
            throw new DAOException("wrong EmployeeMaster code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read timesheetDetail data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return tsd;
    }
          public boolean saveindicatormaster(CompensationIndicatorMaster cps) throws DAOException{
                 Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving Compensation indicator master into database");
            session.saveOrUpdate(cps);
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
            log.error("failed to save Appraisal Result data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }
public Integer getLastIdForIndicatormaster() throws DAOException{
     Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last Indicator master id");
            l = session.createQuery("select max(id) from CompensationIndicatorMaster").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
                if (b != null) {
                    i = b;
                }
            }
        } catch (NullPointerException npe) {
            //session.getTransaction().rollback();
            log.error("null value");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read Leave last Id from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return i;

    }
  public List<CompensationIncrementBand> getIncrementBand(Integer companyid,Integer departmentid,Integer designationid) throws DAOException{
        Session session = null;
        List<CompensationIncrementBand> increment= null;
       try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Department");
           increment= session.createQuery("from CompensationIncrementBand where company="+companyid+" and department="+departmentid+" and designation="+designationid+" and status='approved')").list();


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

        return increment;
    }

  }


          

         

     


   







