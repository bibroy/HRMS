/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.GoalSettingDAO;
import com.pojo.GoalSetting;
import com.util.GoalPriority;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;

/**
 *
 * @author Sumit Kumar
 */
public class GoalSettingDAOImpl extends BaseDAO implements GoalSettingDAO {

    protected static final Log log = LogFactory.getLog(GoalSetting.class);

    public List<GoalSetting> getAllGoalSetting() throws DAOException {
        Session session = null;
        List<GoalSetting> goallist = null;
        try {
            session = getSession();
            session.beginTransaction();
            goallist = session.createQuery("select distinct g.employeeId from GoalSetting g where g.currentStatus='initiated'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the goal setting information " + e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return goallist;
    }

    public List<GoalSetting> getGoalByEmpId(String empid) throws DAOException {
        Session session = null;
        List<GoalSetting> goallist = null;
        try {
            session = getSession();
            session.beginTransaction();
            Criteria crit = session.createCriteria(GoalSetting.class);
            crit.add(Expression.eq("employeeId", empid));
            goallist = crit.list();

            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the goal settings by employee id " + e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return goallist;
    }

    public List<GoalSetting> getGoalByPriority(GoalPriority gp, String empid) throws DAOException {
        Session session=null;
        List<GoalSetting> goallist=null;
        try {
            session=getSession();
            session.beginTransaction();
            Criteria crit=session.createCriteria(GoalSetting.class);
            crit.add(Expression.and(Expression.eq("priority",gp),Expression.eq("employeeId", empid)));
            goallist=crit.list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the goal priority status "+e);
            session.getTransaction().rollback();
        }
        return goallist;
    }

    public boolean saveGoal(GoalSetting g) throws DAOException {
        Session session=null;
        boolean result=false;
        try {
            session=getSession();
            session.beginTransaction();
            session.saveOrUpdate(g);
            session.getTransaction().commit();
            result=true;
        } catch (Exception e) {
            log.error("error saving the goal setting information "+e);
            session.getTransaction().commit();
        }
        return result;
    }

    public Integer getLastId() throws DAOException {
         Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(goalId) from GoalSetting").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
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

    public List<GoalSetting> getInitiatedGoalByEmpId(String empid) throws DAOException {
         Session session = null;
        List<GoalSetting> goallist = null;
        try {
            session = getSession();
            session.beginTransaction();
            Criteria crit = session.createCriteria(GoalSetting.class);
            crit.add(Expression.and(Expression.eq("employeeId", empid),Expression.eq("currentStatus", "initiated")));
            goallist = crit.list();

            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the goal settings by employee id " + e);
            session.getTransaction().rollback();
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return goallist;
    }

    public GoalSetting getGoalById(Integer id) throws DAOException {
        Session session=null;
        GoalSetting gs=null;
        try {
            session=getSession();
            session.beginTransaction();
            gs=(GoalSetting)session.get(GoalSetting.class, id);
            if(gs==null){
                gs=(GoalSetting)session.load(GoalSetting.class, id);
            }
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the goal setting "+e );
        }
        return gs;
    }


}
