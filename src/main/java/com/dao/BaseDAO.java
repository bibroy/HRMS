/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.util.HRMSHibernateUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.*;
import org.hibernate.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author dolad
 */
public class BaseDAO {

    private static Log log = LogFactory.getLog(BaseDAO.class);
    //private static SessionFactory hibernateSF = null;
    private static SessionFactory hibernateSF;

    /**
     * <p>Utility funtion that returns current system date</p>
     *
     * @return String representation of current date
     */
    public String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }

    /**
     * <p>Returns date format that needs to be stored in database</p>
     *
     * @param screenDate date as entered by user
     * @return date in db date format
     */
    public String dbDateFormat(String screenDate) {
        try {
            if (screenDate != null && !screenDate.trim().equals("")) {
                SimpleDateFormat oldformat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat newformat = new SimpleDateFormat("yyyy/MM/dd");
                Date dt = oldformat.parse(screenDate);
                return newformat.format(dt);
            }
        } catch (Exception e) {
            log.warn("failed to convert screen date to db date");
        }
        return null;
    }

    public Date mySqlDatebFormat(String screenDate) {
        try {
            if (screenDate != null && !screenDate.trim().equals("")) {
                SimpleDateFormat oldformat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat newformat = new SimpleDateFormat("yyyy-MM-dd");
                Date dt = oldformat.parse(screenDate);
                return dt;
            }
        } catch (Exception e) {
            log.warn("failed to convert screen date to db date");
        }
        return null;
    }

    public String mySQLscreenDateFormat(Date dbDate) {
        try {


            if (dbDate != null && !dbDate.toString().trim().equals("")) {
                SimpleDateFormat oldformat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat newformat = new SimpleDateFormat("dd/MM/yyyy");
                Date dt = oldformat.parse(dbDate.toString());

                return newformat.format(dt);
            }
        } catch (Exception e) {
            log.warn("failed to convert db date to screen date");
        }
        return dbDate.toString();
    }

    /**
     * <p>Returns in date in format that needs to displayed to the user</p>
     *
     * @param dbDate date format as recieved from database
     * @return screen date format
     */
    public String screenDateFormat(String dbDate) {
        try {
            if (dbDate != null) {
                SimpleDateFormat oldformat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat newformat = new SimpleDateFormat("dd/MM/yyyy");
                Date dt = oldformat.parse(dbDate);

                return newformat.format(dt);
            }
        } catch (Exception e) {
            log.warn("failed to convert db date to screen date");
        }
        return dbDate;
    }

    public static boolean isValidDateStr(String date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            sdf.setLenient(false);
            sdf.parse(date);
        } catch (ParseException e) {
            log.warn("failed to convert db date to screen date");
            return false;
        } catch (IllegalArgumentException e) {
            log.warn("date Format is not mached");
            return false;

        }
        return true;
    }

    /**
     * <p>Utility funtion that returns hibernate session object</p>
     *
     * @return Returns Hibernate Session Object
     * @throws DAOException if hibernate session is null
     */
    public Session getSession() throws DAOException {
        Session session = null;
        try {
            if (hibernateSF != null) {
                return hibernateSF.openSession();
            }
            // This step will read hibernate.cfg.xml and prepare hibernate for use
            //SessionFactory sessionFactory = HRMSHibernateUtil.getSessionFactory();
            SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
            hibernateSF = sessionFactory;
            if (session == null) {
                throw new Exception("null session found");
            }
        } catch (Exception e) {
            log.error("hiberanate session not found", e);
            throw new DAOException("failed to load hiberanate session", e.getCause());
        }
        return session;
    }

    /**
     *
     * <p>delete a item of given class indentified by a given String id</p>
     *
     * @param clazz	the class whose item needs to be deleted
     * @param id	the String identifier of item to be deleted
     * @throws Exception
     */
    protected void delete(Class clazz, String id) throws Exception {
        Session session = getSession();
        try {
            Object obj = session.load(clazz, id);
            session.delete(obj);
            session.flush();
            session.connection().commit();
        } catch (Exception e) {
            log.error(" Error deleting object", e);
            session.connection().rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     *
     * <p>delete a item of given class indentified by a given Long id</p>
     *
     * @param clazz	the class whose item needs to be deleted
     * @param id	the Long identifier of item to be deleted
     * @throws Exception
     */
    protected void delete(Class clazz, Long id) throws Exception {
        Session session = getSession();
        try {
            Object obj = session.load(clazz, id);
            session.delete(obj);
            session.flush();
            session.connection().commit();
        } catch (Exception e) {
            log.error(" Error deleting object", e);
            session.connection().rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     *
     * retrieves a object of given class indentified by a given String id
     *
     * @param clazz	the class whose item needs to be retireved
     * @param id	the String identifier of item to be deleted
     * @throws Exception
     */
    protected Object retrieve(Class clazz, String id) throws Exception {
        Session session = getSession();
        Object obj = null;
        try {
            obj = session.load(clazz, id);
        } catch (Exception e) {
            log.error(" Error retrieving object", e);
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return obj;
    }

    /**
     *
     * retrieves a item of given class indentified by a given Long id
     *
     * @param clazz	the class whose item needs to be retrived
     * @param id	the Long identifier of item to be retrived
     * @throws Exception
     */
    protected Object retrieve(Class clazz, Long id) throws Exception {
        Session session = getSession();
        Object obj = null;
        try {
            obj = session.load(clazz, id);
        } catch (Exception e) {
            log.error(" Error retrieving object", e);
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return obj;
    }

    /**
     *
     * update a item of given class indentified by a given Long id
     *
     * @param clazz	the class whose item needs to be updated
     * @param id	the Long identifier of item to be updated
     * @throws Exception
     */
    protected void update(Class clazz, Object obj, Long id) throws Exception {
        Session session = getSession();
        try {
            session.saveOrUpdate(obj);
            session.flush();
            session.connection().commit();
        } catch (Exception e) {
            log.error(" Error updating object", e);
            session.connection().rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     *
     * update a exisiting item in the database
     *
     * @param obj	the object reference of item whose state needs to be updated
     * @throws Exception
     */
    protected void update(Object obj) throws Exception {
        Session session = getSession();
        try {
            session.update(obj);
            session.flush();
            session.connection().commit();
        } catch (Exception e) {
            log.error(" Error updating object", e);
            session.connection().rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    /**
     *
     * create a new item in the database
     *
     * @param obj	the object reference of item that needs to be created in database
     * @throws Exception
     */
    protected void create(Object obj) throws Exception {
        Session session = getSession();
        try {
            session.save(obj);
            session.flush();
            session.connection().commit();
        } catch (Exception e) {
            log.error(" Error saving object ", e);
            session.connection().rollback();
            throw e;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public String OraclescreenDateFormat(Date dbDate) {
        try {


            if (dbDate != null && !dbDate.toString().trim().equals("")) {
                SimpleDateFormat oldformat = new SimpleDateFormat("yyyy/MM/dd");
                SimpleDateFormat newformat = new SimpleDateFormat("dd/MM/yyyy");
                Date dt = oldformat.parse(dbDate.toString());

                return newformat.format(dt);
            }
        } catch (Exception e) {
            log.warn("failed to convert db date to screen date");
        }
        return dbDate.toString();
    }

    public Date OracleDatebFormat(String screenDate) {
        try {
            if (screenDate != null && !screenDate.trim().equals("")) {
                SimpleDateFormat oldformat = new SimpleDateFormat("dd/MM/yyyy");
                SimpleDateFormat newformat = new SimpleDateFormat("MM/dd/yyyy");
                Date dt = oldformat.parse(screenDate);


                String dtString = newformat.format(dt.toString());

                Date newDt = oldformat.parse(dtString);

                return newDt;

            }
        } catch (Exception e) {
            log.warn("failed to convert screen date to db date");
        }
        return null;
    }

    public Date NewDateFormat(String screenDate)
    {
        try {
            if (screenDate != null && !screenDate.trim().equals("")) {
                SimpleDateFormat oldformat = new SimpleDateFormat("yyyy-MM-dd");
                SimpleDateFormat newformat = new SimpleDateFormat("dd-MMM-yyyy");
                Date dt = oldformat.parse(screenDate);

                return dt;

            }
        } catch (Exception e) {
            log.warn("failed to convert screen date to db date");
        }
        return null;
    }
}
