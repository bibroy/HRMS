package com.ImplClass;

/**
 *
 * @author Swarnendu Mukherjee
 */
import com.dao.AppraisalSelfDAO;
import com.dao.BaseDAO;
import com.dao.DAOException;
import com.pojo.AppraisalSelf;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author Swarnendu Mukherjee
 */
public class AppraisalSelfDAOImpl extends BaseDAO implements AppraisalSelfDAO {

    protected static final Log log = LogFactory.getLog(AppraisalSelfDAOImpl.class);

    public AppraisalSelfDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<AppraisalSelf> getAppraisalSelfResult() throws DAOException {

        List<AppraisalSelf> appraisalSelfList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Categories");
            appraisalSelfList = session.createQuery("from AppraisalSelf a").list();
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

        return appraisalSelfList;
    }
   public boolean save(AppraisalSelf appraisalself) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving appraisal Result details into database");
            session.saveOrUpdate(appraisalself);
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
}