/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.KeyPositionDAO;
import com.pojo.KeyPosition;
import com.pojo.Successor;
import java.util.Iterator;
import java.util.List;
import org.hibernate.exception.DataException;

/**
 *
 * @author Sumit Kumar
 */
public class KeyPositionDAOImpl extends BaseDAO implements KeyPositionDAO {

    protected static final Log log = LogFactory.getLog(KeyPositionDAO.class);

    public List<KeyPosition> getAllKeyPosition() throws DAOException {
        Session session = null;
        List<KeyPosition> list = null;
        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("from KeyPosition k ").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching key position " + e);
        }
        return list;
    }

    public boolean save(KeyPosition key) throws DAOException {

        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("Saving data into databse");
            session.saveOrUpdate(key);
            session.flush();
            session.getTransaction().commit();
            log.info("Data Save Successfully");

        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }


        return true;


    }

    public Integer getLastRequestId() throws DAOException {

        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last id");
            l = session.createQuery("select max(id) from KeyPosition").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
                if (b != null) {
                    i = b;
                }
//                Object[] row = (Object[]) iter.next();
//                if(row[0]!=null)
//                {
//                BigDecimal b=(BigDecimal)row[0];
//                i = b;
//                }
            }
        } catch (NullPointerException npe) {
            //session.getTransaction().rollback();
            log.error("null value");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read ", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return i;


    }

    public Integer getLastRequestIdforSuccessor() throws DAOException {

        Integer i = 0;
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last id");
            l = session.createQuery("select max(id) from Successor").list();
            session.getTransaction().commit();
            for (Iterator iter = l.iterator(); iter.hasNext();) {
                Integer b = (Integer) iter.next();
                if (b != null) {
                    i = b;
                }
//                Object[] row = (Object[]) iter.next();
//                if(row[0]!=null)
//                {
//                BigDecimal b=(BigDecimal)row[0];
//                i = b;
//                }
            }
        } catch (NullPointerException npe) {
            //session.getTransaction().rollback();
            log.error("null value");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("===========>failed to read ", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return i;


    }

    public boolean save(Successor save) throws DAOException {

        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("Saving data into databse");
            session.saveOrUpdate(save);
            session.flush();
            session.getTransaction().commit();
            log.info("Data Save Successfully");

        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }


        return true;

    }

    public KeyPosition getKeyPositionById(Integer positionid) throws DAOException {
        KeyPosition value = null;
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            String query = "from KeyPosition k where k.id=" + positionid;
            value = (KeyPosition) session.createQuery(query).uniqueResult();
            session.getTransaction().commit();


        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Job list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return value;

    }
}
