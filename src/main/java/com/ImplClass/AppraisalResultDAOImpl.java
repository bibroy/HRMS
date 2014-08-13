package com.ImplClass;

/**
 *
 * @author Swarnendu Mukherjee
 */
import com.dao.AppraisalResultDAO;
import com.dao.BaseDAO;
import com.dao.DAOException;
import com.pojo.AppraisalResult;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;
import com.pojo.AppraisalResultSum;
import com.pojo.selfAppraisalResult;
import java.util.ArrayList;
import java.util.Date;
import com.util.appraisalresultutil;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ListIterator;
import org.hibernate.Query;
import com.util.Appraisalutil;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalResultDAOImpl extends BaseDAO implements AppraisalResultDAO {

    protected static final Log log = LogFactory.getLog(AppraisalResultDAO.class);

    public AppraisalResultDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<AppraisalResult> getAllAppraisalResult() throws DAOException {

        List<AppraisalResult> appraisalResultList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Categories");
            appraisalResultList = session.createQuery("from AppraisalResult a").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return appraisalResultList;
    }

    public List<AppraisalResultSum> getAllAppraisalResultSum() throws DAOException {
        List<AppraisalResultSum> appres = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Categories");
            appres = session.createQuery("from AppraisalResultSum a").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return appres;
    }

    public List<AppraisalResult> getAppraisalResultbyEmployee(int employee_id) throws DAOException {

        List<AppraisalResult> appraisalResultList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Result");
            appraisalResultList = session.createQuery("from AppraisalResult a where a.employee_code='" + employee_id + "'").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return appraisalResultList;
    }

    public List<AppraisalResult> getAppraisalResultbyEmployee(String employee_id) throws DAOException {

        List<AppraisalResult> appraisalResultList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Result");
            appraisalResultList = session.createQuery("from AppraisalResult a where a.employee_code='" + employee_id + "'").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return appraisalResultList;
    }

    public AppraisalResult getAppraisalResult() throws DAOException {

        return new AppraisalResult();
    }

    public AppraisalResult getAppraisalResult(String id) throws DAOException {

        try {
            Integer aId = new Integer(id);
            return getAppraisalResult(aId);

        } catch (NumberFormatException ne) {
            log.warn("Result ID is not valid");

        }

        return null;
    }

    public AppraisalResult getAppraisalResult(Integer id) throws DAOException {
        AppraisalResult appraisalResult = null;
        Session session = null;

        if (id == null) {
            throw new DAOException("failed to fetch data for \"null\" Result id");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Question Details");
            appraisalResult = (AppraisalResult) session.load(AppraisalResult.class, id);
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result data from database", e);
            throw new DAOException("wrong Result id");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return appraisalResult;
    }

    public AppraisalResult getAppraisalResultByCode(String id) throws DAOException {

        return null;
    }

    public boolean save(AppraisalResult appraisalResults) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving appraisal Result details into database");
            session.saveOrUpdate(appraisalResults);
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

    public Integer getLastId() throws DAOException {
        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last Appraisal id");
            l = session.createQuery("select max(id) from AppraisalResult").list();
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

    public Integer getselfLastId() throws DAOException {
        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last Appraisal id");
            l = session.createQuery("select max(id) from selfAppraisalResult").list();
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

    public Integer getLastIdForSum() throws DAOException {
        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last Appraisal id");
            l = session.createQuery("select max(id) from AppraisalResultSum").list();
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

    public boolean selfsave(selfAppraisalResult selfappraisalResults) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving appraisal Result details into database");
            session.saveOrUpdate(selfappraisalResults);
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

    public boolean saveAppraisalResultsum(AppraisalResultSum appraisalResultsum) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving appraisal Result details into database");
            session.saveOrUpdate(appraisalResultsum);
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
      

    public List<appraisalresultutil> calculatesum(Date appraisedate, String empid) throws DAOException {
        List<appraisalresultutil> appraisalResult = new ArrayList<appraisalresultutil>();
        List aru = null;
        Session session = null;
        BaseDAO b = new BaseDAO();

      
       DateFormat d=new SimpleDateFormat("dd-MM-yyyy");
       String dt=d.format(appraisedate);

        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Question Details");
             String query="select a.category_code,c.category_name,(round(AVG(answer),2)*100)/5 from APPRAISAL_RESULT a,Appraisal_category c where a.category_code in(select r.category_code from appraisal_result r where r.APPRAISE_DATE=to_date('"+dt+"','dd-MM-yyyy') and r.EMPLOYEE_CODE='" + empid + "' group by r.category_code)and a.APPRAISE_DATE=to_date('"+dt+"','dd-MM-yyyy')and a.category_code=c.category_code and a.EMPLOYEE_CODE='" + empid + "' group by a.category_code, c.category_name";
           // String query = "select c.CATEGORY_CODE,c.CATEGORY_NAME,(round(AVG(a.ANSWER),2)*100)/5 from APPRAISAL_RESULT a,APPRAISAL_CATEGORY c  where APPRAISE_DATE=to_date('"+dt+"','dd-MM-yyyy') and EMPLOYEE_CODE='" + empid + "' group by c.CATEGORY_CODE, c.CATEGORY_NAME";
            Query q = session.createSQLQuery(query);
           
            aru = q.list();
            ListIterator litr = aru.listIterator();
            while (litr.hasNext()) {
                appraisalresultutil ar = new appraisalresultutil();
                Object[] data = (Object[]) litr.next();
                ar.setCategorycode(data[0] != null ? Integer.parseInt(data[0].toString()) : null);
                ar.setCategoryname(data[1] != null ? (data[1].toString()) : null);
                ar.setPercentage(data[2] != null ? Double.parseDouble(data[2].toString()) : null);
                appraisalResult.add(ar);
            }
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result data from database", e);
            throw new DAOException("wrong Result id");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return appraisalResult;
    }
     public Appraisalutil appraisalreport(String empid)throws DAOException{
         Appraisalutil u=new Appraisalutil();



        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Question Details");
            String query = "select avg(score),appraisal_date from appraisal_result_summary where appraisal_date in(select max(appraisal_date) from appraisal_result_summary where employee_code='empid')";

            Query q = session.createSQLQuery(query);

           List aru=q.list();
            ListIterator litr = aru.listIterator();
            while (litr.hasNext()) {

                Object[] data = (Object[]) litr.next();
               u.setAppraisal_date(data[1].toString());
               u.setScore((Integer.parseInt(data[0].toString())));
               

            }


            log.info("done");
            session.getTransaction().commit();




        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result data from database", e);
            throw new DAOException("wrong Result id");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return u;
    }
     public List<Appraisalutil> appraisalgraph(String empid)throws DAOException{
         List<Appraisalutil> u=new ArrayList<Appraisalutil>();
       



        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Question Details");
            String query = "select avg(score),appraisal_date from appraisal_result_summary where employee_code='"+empid+"' group by appraisal_date";

            Query q = session.createSQLQuery(query);

           List aru=q.list();
            ListIterator litr = aru.listIterator();
            while (litr.hasNext()) {
                  Appraisalutil arp=new Appraisalutil();

                Object[] data = (Object[]) litr.next();
                String da=data[1].toString();
                 DateFormat db=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                 Date d=db.parse(da);
                  DateFormat df=new SimpleDateFormat("dd/MM/yyyy");

             String dff=df.format(d);
               arp.setAppraisal_date(dff);
               arp.setScore((Integer.parseInt(data[0].toString())));
               u.add(arp);


            }


            log.info("done");
            session.getTransaction().commit();




        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result data from database", e);
            throw new DAOException("wrong Result id");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return u;
    }
     public List<AppraisalResultSum>employeeByAppraisalresultsum()throws DAOException{
          List<AppraisalResultSum> appraisalResultSum = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Result");
            appraisalResultSum = session.createQuery("select distinct employee_code from AppraisalResultSum" ).list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Result list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return appraisalResultSum ;


     }




     }
     

