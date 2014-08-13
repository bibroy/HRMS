/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.RecieptDocumentDAO;
import com.pojo.RecieptDocuments;
import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

/**
 *
 * @author sujatas
 */
public class RecieptDocumentDAOImpl extends BaseDAO implements RecieptDocumentDAO {

protected static final Log log = LogFactory.getLog(RecieptDocumentDAO.class);
    public boolean addDocDump(RecieptDocuments docDump) throws DAOException
    {
        boolean flag=false;
        Session session = null;
        try{
            session= getSession();
            session.beginTransaction();
            session.saveOrUpdate(docDump);
            session.getTransaction().commit();
            log.info("Add docDump");
            flag=true;
        }catch(Exception ex){
            session.getTransaction().rollback();
            log.error("Failed to update", ex);
        }finally{
            if(session!=null) {
				session.flush();
				session.close();
			}
        }
        return flag;
    }


public BigDecimal getLastRequestId() throws DAOException {

        BigDecimal i = new BigDecimal(0.0);
        List l = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching last requestid");
            l = session.createQuery("select max(recieptid) from RecieptDocuments").list();
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


}
