/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.DocDumpDAO;
import com.pojo.Department;
import com.pojo.DocDump;
import com.pojo.Skills;
import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;

/**
 *
 * @author ranjans
 */
public class DocDumpDAOImpl extends BaseDAO implements DocDumpDAO  {

    protected static final Log log = LogFactory.getLog( DocDumpDAO.class );

    public DocDumpDAOImpl() {
    }    

    /***
     * Get All DocDump whoes 
     * Status lavel Y
     * @return
     * @throws DAOException
     */
    public List<DocDump> getAllDocDump() throws DAOException {
        Session session = null;
		List<DocDump> docDump = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Department");
			docDump = session.createQuery("from DocDump d where d.status='Y'").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read skills list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return docDump;
    }    

    /***
     * Get all docdump
     * Whoes Training ID
     * ,
     * File Type is given
     * and
     * Experience avel is given
     * @param docDump
     * @return
     * @throws DAOException
     */
    public List<DocDump> getAllDocDumpOnTraining(DocDump docDump) throws DAOException {
        Session session = null;
		List<DocDump> docDumpReturn = null;

		try{
			session = getSession();
			session.beginTransaction();
			log.info("Fetching all Active Department");
			docDumpReturn = session.createQuery("from DocDump d where d.status='Y' and d.trainingId="+docDump.getTrainingId()+"  and d.expLavel="+docDump.getExpLavel()+" and d.fileType="+docDump.getFileType()+" ").list();
			session.getTransaction().commit();

		}catch(Exception e){
			session.getTransaction().rollback();
			log.error("failed to read skills list data from database", e);
			throw new DAOException(e.getMessage(),e.getCause());
		}finally{
			if(session!=null) {
				session.flush();
				session.close();
			}
		}

		return docDumpReturn;
    }

    /***
     * Add docType
     * @param docDump
     * @return
     * @throws DAOException
     */
    public boolean addDocDump(DocDump docDump) throws DAOException {
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

    /***
     * Update docType
     * @param docDump
     * @return
     * @throws DAOException
     */
    public boolean updateDocDump(DocDump docDump) throws DAOException {
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

    public List<DocDump> getAllDocDumpOnDept(Department dept) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public List<DocDump> getAllDocDumpOnSkill(Skills skills) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}