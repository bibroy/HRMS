/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.*;
import com.pojo.GradeMaster;
import com.dao.GradeMasterDAO;
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
public class GradeMasterDAOImpl extends BaseDAO implements GradeMasterDAO {

    protected static final Log log = LogFactory.getLog(GradeMasterDAO.class);

    public List<GradeMaster> getEmployeesbyGrade(String grade) throws DAOException {
        List<GradeMaster> list = null;

        Session session=null;

        try {
            session = getSession();
            session.beginTransaction();
            list = session.createQuery("from GradeMaster g where g.status='" + grade + "'").list();
            session.getTransaction().commit();
            log.info("Grades retreive successfully");


        } catch (Exception e) {

            log.error("Exception occured exception type is: " + e);

        } finally {

            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return list;
    }
}
