package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.MenuDAO;
import com.pojo.Menu;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

/**
 * 
 * @author Swarnendu Mukherjee
 *
 */



public class MenuDAOImpl extends BaseDAO implements MenuDAO {

    protected static final Log log = LogFactory.getLog(MenuDAO.class);

    public MenuDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<Menu> getMenuLinks(String role_id) throws DAOException {

        List<Menu> links= null;
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Appraisal forms");

            //query changed for better mapping (Sumit)
            links = session.createQuery("select distinct m from Menu m , PrivilegeMaster p where m.privilegeId=p.priviledgeId and p.roleId="+ role_id+" order by m.menuText").list();
          
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Menu list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }
        return links;
    }
}