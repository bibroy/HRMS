package com.ImplClass;

/**
 *
 * @author Swarnendu Mukherjee
 */
import com.dao.AppraisalQuestionsDAO;
import com.dao.AppraisalSetupDAO;
import com.dao.BaseDAO;
import com.dao.DAOException;
import com.pojo.AppraisalSetup;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalSetupDAOImpl extends BaseDAO implements AppraisalSetupDAO {

    protected static final Log log = LogFactory.getLog(AppraisalQuestionsDAO.class);

    public AppraisalSetupDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<AppraisalSetup> getAllAppraisalSetup() throws DAOException {

        List<AppraisalSetup> appraisalSetupList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Categories");
            appraisalSetupList = session.createQuery("from AppraisalSetup a").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Category list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return appraisalSetupList;
    }
    public List<AppraisalSetup> getAllAppraisalSetup(int designation,int department) throws DAOException {

        List<AppraisalSetup> appraisalSetupList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Categories");
            String query="from AppraisalSetup a where a.appraiser='"+designation+"' and a.department_id="+department+" and a.status='Active'";
            org.hibernate.Query hq=session.createQuery(query);
            System.out.println(hq.toString());
            appraisalSetupList = hq.list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Category list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return appraisalSetupList;
    }

    public List<AppraisalSetup> getAllSelfAppraisalSetup(int department) throws DAOException {

        List<AppraisalSetup> selfAppraisalSetupList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Categories");
            selfAppraisalSetupList = session.createQuery("from AppraisalSetup a where a.department_id='"+department+"' and a.feedback_status='Y'").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Category list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return selfAppraisalSetupList;
    }

    public AppraisalSetup getAppraisalSetup() throws DAOException {

        return new AppraisalSetup();
    }

    public AppraisalSetup getAppraisalSetup(String id) throws DAOException {

        try {
            Integer aId = new Integer(id);
            return getAppraisalSetup(aId);

        } catch (NumberFormatException ne) {
            log.warn("Category Code is not valid");

        }

        return null;
    }

    public AppraisalSetup getAppraisalSetup(Integer id) throws DAOException {
        AppraisalSetup appraisalSetup = null;
        Session session = null;

        if (id == null) {
            throw new DAOException("failed to fetch data for \"null\" Question code");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Question Details");
            appraisalSetup = (AppraisalSetup) session.load(AppraisalSetup.class, id);
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Questions data from database", e);
            throw new DAOException("wrong Category code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return appraisalSetup;
    }

    public AppraisalSetup getAppraisalSetupByCode(String id) throws DAOException {

        return null;
    }

    public boolean save(AppraisalSetup appraisalSetup) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving appraisal Questions details into database");
            session.saveOrUpdate(appraisalSetup);
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
            log.error("failed to save Appraisal data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }
     public List<AppraisalSetup> getSelfAppraisalSetup(int designation,int department) throws DAOException{
         List<AppraisalSetup> appraisalSetupList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Categories");
            String query="from AppraisalSetup a where a.appraiser='"+designation+"' and a.department_id="+department+" and a.status='Active'";
            org.hibernate.Query hq=session.createQuery(query);
            System.out.println(hq.toString());
            appraisalSetupList = hq.list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Appraisal Category list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return appraisalSetupList;
     }
}
