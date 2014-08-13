/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.ShiftMasterDAO;
import com.pojo.ShiftMaster;
import com.dao.DAOException;
import java.math.BigDecimal;
import com.dao.BaseDAO;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;

/**
 *
 * @author pradipto roy
 * created on 27/1/2011
 */
public class ShiftMasterDAOImpl extends BaseDAO implements ShiftMasterDAO {

    protected static final Log log = LogFactory.getLog(ShiftMasterDAO.class);

    public List<ShiftMaster> getAllShiftDetails() throws DAOException {

        List<ShiftMaster> list = null;

        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("from ShiftMaster s").list();
            session.getTransaction().commit();
            log.info("Transaction Commited OK");


        } catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read ShiftMaster list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

        return list;

    }
}
