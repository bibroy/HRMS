/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.pojo.RoleMaster;
import java.util.List;
import com.dao.RoleMasterDAO;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.exception.DataException;
import org.hibernate.exception.ConstraintViolationException;
import com.dao.DAOException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author pradipto roy
 */
public class RoleMasterDAOImpl extends BaseDAO implements RoleMasterDAO {

    protected static final Log log = LogFactory.getLog(RoleMasterDAO.class);

    public RoleMasterDAOImpl() {
    }

    public List<RoleMaster> getAllRoles() throws DAOException {

        List<RoleMaster> list = null;
        Session session = null;
        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("from RoleMaster r").list();

            session.getTransaction().commit();
            log.info("Transaction commited data retreive successfully");

        } catch (Exception e) {


            session.getTransaction().rollback();
            log.error("failed to read roles list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } 
        finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }



        return list;

    }
}
