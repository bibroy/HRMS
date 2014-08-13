/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.pojo.vacancies;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Hibernate;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import com.dao.VacanciesDAO;
/**
 *
 * @author Sumit Kumar
 */
public class VacanciesDAOImpl extends BaseDAO implements VacanciesDAO{

    protected static final Log log = LogFactory.getLog( VacanciesDAO.class );

    public List<vacancies> getAllVacancies() throws DAOException {
        Session session=null;
        List<vacancies> list=null;
        try {
            session=getSession();
            session.beginTransaction();
            list=session.createQuery("from vacancies v where v.status='E'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching vacancies "+e);
        }
        return list;
    }

    public Integer getLastId() throws DAOException {
         Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(id) from vacancies").list();
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

    public boolean save(vacancies vac) throws DAOException {
        Session session=null;
        boolean result=false;
        try {
            session=getSession();
            session.beginTransaction();
            session.saveOrUpdate(vac);
            session.getTransaction().commit();
            result=true;
        } catch (Exception e) {
            log.error("error during saving the vacancies data "+e);
            session.getTransaction().rollback();
            throw new DAOException("unkown error");
        }finally{
            if(session!=null){
                session.flush();
                session.close();
            }
        }
        return result;
    }
}
