package com.ImplClass;

/**
 *
 * @author Swarnendu Mukherjee
 */
import com.dao.AppraisalQuestionsDAO;
import com.dao.BaseDAO;
import com.dao.DAOException;
import com.pojo.AppraisalQuestions;
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
public class AppraisalQuestionsDAOImpl extends BaseDAO implements AppraisalQuestionsDAO {

    protected static final Log log = LogFactory.getLog(AppraisalQuestionsDAO.class);

    public AppraisalQuestionsDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<AppraisalQuestions> getAllAppraisalQuestions() throws DAOException {

        List<AppraisalQuestions> appraisalQuestionsList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Categories");
            appraisalQuestionsList = session.createQuery("from AppraisalQuestions a where a.status='Y'").list();
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

        return appraisalQuestionsList;
    }

    public AppraisalQuestions getAppraisalQuestions() throws DAOException {

        return new AppraisalQuestions();
    }

    public AppraisalQuestions getAppraisalQuestions(String question_code) throws DAOException {

        try {
            Integer aId = new Integer(question_code);
            return getAppraisalQuestions(aId);

        } catch (NumberFormatException ne) {
            log.warn("Category Code is not valid");

        }

        return null;
    }

    public AppraisalQuestions getAppraisalQuestions(Integer question_code) throws DAOException {
        AppraisalQuestions appraisalQuestions = null;
        Session session = null;

        if (question_code == null) {
            throw new DAOException("failed to fetch data for \"null\" Question code");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Question Details");
            appraisalQuestions = (AppraisalQuestions) session.load(AppraisalQuestions.class, question_code);
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

        return appraisalQuestions;
    }

    public AppraisalQuestions getAppraisalQuestionsByCode(String question_code) throws DAOException {

        return null;
    }

    public boolean save(AppraisalQuestions appraisalQuestions) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving appraisal Questions details into database");
            session.saveOrUpdate(appraisalQuestions);
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

    public List<AppraisalQuestions> getQuestionsbyCategory(int category_code) throws DAOException {

        List<AppraisalQuestions> appraisalQuestionsList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Categories");
            appraisalQuestionsList = session.createQuery("from AppraisalQuestions a where a.category_code='"+category_code+"' and a.status='Y'").list();
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

        return appraisalQuestionsList;
    }

}
