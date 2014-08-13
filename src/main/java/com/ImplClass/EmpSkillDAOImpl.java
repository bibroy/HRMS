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
import com.dao.EmpSkillsDAO;
import com.pojo.EmpSkills;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;

/**
 *
 * @author Sumit Kumar
 */

public class EmpSkillDAOImpl extends BaseDAO implements EmpSkillsDAO{

        protected static final Log log = LogFactory.getLog(EmpSkillsDAO.class );

    public List<EmpSkills> getEmployeeBySkill(String skill) throws DAOException {
            Session session=null;
            List<EmpSkills> list=null;
            List<EmpSkills> l1=new ArrayList<EmpSkills>();
            try {
                session =getSession();
                session.beginTransaction();
                Query query=session.createSQLQuery("select * from Emp_Skills e where contains(e.skills,'"+skill+"',1)>0");
                System.out.println(query.toString());
                list=query.list();
                if(list!=null)
                {
                    Object[] data=null;
                    Iterator itr=list.iterator();
                    while(itr.hasNext())
                    {
                        EmpSkills e=new EmpSkills();
                        data=(Object[]) itr.next();
                        e.setId(Integer.parseInt(data[0].toString()));
                        e.setEmployeid(data[1].toString());
                        e.setSkills(data[2].toString());
                        e.setProficiency(data[3].toString());

                        l1.add(e);
                    }
                }
                session.getTransaction().commit();

        } catch (Exception e) {
            log.error("error fetching the employee skill "+e);
        }
            return l1;
    }
}
