/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.PhoneReimbursementDAO;
import com.pojo.PhoneReimbursment;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

/**
 *
 * @author Sumit Kumar
 */
public class PhoneReimbursementDAOImpl extends BaseDAO implements PhoneReimbursementDAO {

    protected static final Log log = LogFactory.getLog(PhoneReimbursementDAO.class);

    public List<PhoneReimbursment> getAllReimbursementRequest() throws DAOException {
        Session session = null;
        List<PhoneReimbursment> prlist = null;
        try {
            session = getSession();
            session.beginTransaction();
            prlist = session.createQuery("from PhoneReimbursment pr where approvalstatus='W'").list();
            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("error fetching the phone reimbursement request details " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return prlist;
    }

    public boolean save(PhoneReimbursment pr) throws DAOException {
        Session session = null;
        boolean result = false;
        try {
            session = getSession();
            session.beginTransaction();
            session.saveOrUpdate(pr);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            log.error("error saving the phone reimbursement details " + e);
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return result;
    }

    public BigDecimal getLastRequestId() throws DAOException {
        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(requestid) from PhoneReimbursment").list();
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

    public PhoneReimbursment getRequestById(BigDecimal id) throws DAOException {
        Session session=null;
        PhoneReimbursment pr=null;
        try {
            session=getSession();
            session.beginTransaction();
            pr=(PhoneReimbursment)session.get(PhoneReimbursment.class, id);
            if(pr==null){
                pr=(PhoneReimbursment)session.load(PhoneReimbursment.class, id);
            }
            if(session.isOpen()){
                pr.getRequestid();
            }
            session.getTransaction().commit();

        } catch (Exception e) {
            log.error("error loading the phone reimbursement request "+e);
        }
        finally{
            if(session!=null){
                session.flush();
                session.close();
            }
        }
        return pr;
    }
}
