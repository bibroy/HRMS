/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ImplClass;

import com.dao.BaseDAO;
import com.dao.DAOException;
import com.dao.ProjectDAO;
import com.pojo.Project;
import com.util.ManagerDetail;
import com.util.ProjectDetail;
import com.util.ResourceDetail;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Criteria;
import org.hibernate.ObjectNotFoundException;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import com.util.ClientStatusReport;

/**
 * 
 * @author shrayanti
 */
public class ProjectDAOImpl extends BaseDAO implements ProjectDAO {

    protected static final Log log = LogFactory.getLog(ProjectDAO.class);

    public ProjectDAOImpl() {
    }

    @SuppressWarnings("unchecked")
    public List<Project> getAllProjectForEdit() throws DAOException {

        List<Project> projectList = null;
        Session session = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Client ");
            projectList = session.createQuery("from Project p where p.status='Y'").list();
            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Client list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return projectList;
    }

    /**
     *
     * @return
     * @throws DAOException
     */
    public List<ProjectDetail> getAllProject() throws DAOException {

        List projectList = null;
        List<ProjectDetail> projectDetailList = new ArrayList<ProjectDetail>();
        Session session = null;
        ProjectDetail projectPojo = null;


        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active Project ");
            projectList = session.createQuery("select c.clientName,p.projectName,p.desc,p.startDate,p.endDate,p.plannedTime,concat( concat( concat(e.firstName,''),concat(e.middleName,'')),concat(e.lastName,'')),p.maximumResource,p.projectStatus,d.departmentName FROM Client c,Project p,EmployeeMaster e,Department d WHERE c.clId=p.clientId AND e.employeeId=p.managerId AND d.departmentId=p.departmentId AND p.status='Y'").list();

            Iterator i = projectList.iterator();
            while (i.hasNext()) {
                projectPojo = new ProjectDetail();

                Object project[] = (Object[]) i.next();


                projectPojo.setClientName(project[0]!=null?project[0].toString():null);
                
                projectPojo.setProjectName(project[1]!=null?project[1].toString():null);
                projectPojo.setProjectDescription(project[2]!=null?project[2].toString():null);
                projectPojo.setPlannedStartDate(project[3]!=null?project[3].toString():null);
                projectPojo.setPlannedEndDate(project[4]!=null?project[4].toString():null);
                projectPojo.setPlannedTime(project[5]!=null?project[5].toString():null);
                projectPojo.setManagerName(project[6]!=null?project[6].toString():null);
                projectPojo.setMaximumResource(project[7]!=null?project[7].toString():null);
                projectPojo.setProjectStatus(project[8]!=null?project[8].toString():null);
                projectPojo.setDepartmentName(project[9]!=null?project[9].toString():null);


                projectDetailList.add(projectPojo);

            }

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Project list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return projectDetailList;
    }

    /**
     *
     * @param projectId
     * @return
     * @throws DAOException
     */
    public Project getProject(Integer projectId) throws DAOException {
        Project project = null;
        List<Project> listproject = null;
        Session session = null;

        if (projectId == null) {
            throw new DAOException("failed to fetch data for \"null\" project  id");
        }


        try {
            session = getSession();
            session.beginTransaction();
            log.info("fetching Project Detail");
            Criteria cobj = session.createCriteria(Project.class);
            cobj.add(Expression.eq("id", projectId));
            listproject = cobj.list();

            if (listproject != null) {
                project = listproject.get(0);

            }
            log.info("done");
            session.getTransaction().commit();

        } catch (ObjectNotFoundException e) {
            session.getTransaction().rollback();
            log.error("failed to read Client Group data from database", e);
            throw new DAOException("wrong Client Group code");
        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read Client Group data from database", e);
            throw new DAOException("unknown error");
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return project;
    }

    /**
     *
     * @param project
     * @return
     * @throws DAOException
     */
    public boolean save(Project project) throws DAOException {
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("saving project details into database");
            session.saveOrUpdate(project);
            session.flush();
            session.getTransaction().commit();
            log.info("done");
        } catch (ConstraintViolationException je) {
            log.error("failed to save data due to integrity constratint violation");
            session.getTransaction().rollback();
            throw new DAOException("duplicate value", je.getCause());
        } catch (DataException je) {
            log.error("failed to save data due to illegal data");
            session.getTransaction().rollback();
            throw new DAOException("invalid data", je.getCause());
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save project data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.close();
            }
        }

        return true;
    }

    /**
     *
     * @return
     * @throws DAOException
     */
    public List<ManagerDetail> getManager() throws DAOException {


        Session session = null;
        List managerReturnList = new ArrayList();
        List<ManagerDetail> managerList = new ArrayList<ManagerDetail>();
        ManagerDetail managerPojo = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active ManagerList");
            managerReturnList = session.createQuery("select concat( concat( concat(e.firstName,' '),concat(e.middleName,' ')),e.lastName),t.taskName,e.emailAddress,p.projectStatus,p.projectName from EmployeeMaster e, ProjectManagementTransaction pmt,Task t,Project p where e.employeeId=pmt.resourceId and pmt.taskId=t.taskId and p.projectCode=pmt.projectCode and pmt.designationId='5'").list();
            Iterator i = managerReturnList.iterator();
            while (i.hasNext()) {
                managerPojo = new ManagerDetail();

                Object manager[] = (Object[]) i.next();


                managerPojo.setFirstName(manager[0].toString());
                managerPojo.setEmailAddress(manager[1].toString());
                managerPojo.setProjectName(manager[2].toString());
                managerPojo.setTaskName(manager[3].toString());
                managerPojo.setProjectStatus(manager[4].toString());

                managerList.add(managerPojo);

            }

            //System.out.println("$$$$$$$$$$$$$$$$$$$"+managerReturnList.size()+"$$$$$$$$$$$$$$$$$$$$$");

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read ManagerDetails list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return managerList;
    }

    public List<ManagerDetail> getManagerList() throws DAOException {

        Session session = null;
        List managerReturnList = new ArrayList();
        List<ManagerDetail> managerList = new ArrayList<ManagerDetail>();
        ManagerDetail managerPojo = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active ManagerList");
            managerReturnList = session.createQuery("select e.employeeId,concat( concat( concat(e.firstName,' '),concat(e.middleName,' ')),e.lastName),e.emailAddress, e.departmentId from EmployeeMaster e, ProjectManagementTransaction pmt where e.employeeId=pmt.resourceId and pmt.designationId='5'").list();
            Iterator i = managerReturnList.iterator();
            while (i.hasNext()) {
                managerPojo = new ManagerDetail();

                Object manager[] = (Object[]) i.next();

                managerPojo.setManagerId(manager[0].toString());
                managerPojo.setFirstName(manager[1].toString());
                managerPojo.setEmailAddress(manager[2].toString());
                // managerPojo.setProjectName(manager[2].toString());
                // managerPojo.setTaskName(manager[3].toString());
                // managerPojo.setProjectStatus(manager[4].toString());
                managerPojo.setDepartmentId(manager[3].toString());

                managerList.add(managerPojo);
            }

            //System.out.println("$$$$$$$$$$$$$$$$$$$"+managerReturnList.size()+"$$$$$$$$$$$$$$$$$$$$$");

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read ManagerDetails list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return managerList;
    }

    public List<ResourceDetail> getResource() throws DAOException {


        Session session = null;
        List resourceReturnList = new ArrayList();
        List<ResourceDetail> resourceList = new ArrayList<ResourceDetail>();
        ResourceDetail resourcedetailPojo = null;

        try {
            session = getSession();
            session.beginTransaction();
            log.info("Fetching all Active ResourceList");
            resourceReturnList = session.createQuery("select concat( concat( concat(e.firstName,' '),concat(e.middleName,' ')),e.lastName),p.projectName,s.skillName,es.proficiencyLevel,es.lastUsed  from EmployeeMaster e,ProjectManagementTransaction pmt,Skills s,EmployeeSkill es,Project p where e.employeeId=pmt.resourceId AND p.projectCode=pmt.projectCode AND es.employeeId=pmt.resourceId AND es.skillId=s.skillId AND pmt.designationId!=5 ").list();



            Iterator i = resourceReturnList.iterator();
            while (i.hasNext()) {
                resourcedetailPojo = new ResourceDetail();

                Object manager[] = (Object[]) i.next();


                resourcedetailPojo.setResourceName(manager[0].toString());
                resourcedetailPojo.setSkill(manager[1].toString());
                resourcedetailPojo.setProfiency(manager[2].toString());
                resourcedetailPojo.setLastUsed(manager[3].toString());
                resourcedetailPojo.setAllocatedProject(manager[4].toString());

                resourceList.add(resourcedetailPojo);


            }

            //System.out.println("$$$$$$$$$$$$$$$$$$$"+managerReturnList.size()+"$$$$$$$$$$$$$$$$$$$$$");

            session.getTransaction().commit();

        } catch (Exception e) {
            session.getTransaction().rollback();
            log.error("failed to read ManagerDetails list data from database", e);
            throw new DAOException(e.getMessage(), e.getCause());
        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return resourceList;
    }

    public List<Project> getProjectdetailbyStatus(String status) throws DAOException {
        List<Project> proobj = null;
        Session session = null;
        try {

            session = getSession();
            session.beginTransaction();
            proobj = session.createQuery("from Project p where p.projectStatus='" + status + "'").list();
            session.getTransaction().commit();
            log.info("Commited successfully");

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("failed to save project data into database", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return proobj;
    }

    public List getALLClientByProjectStatus() throws DAOException {
        List clobj = null;
        Session session = null;

        try {
            session = getSession();
            session.beginTransaction();
            String query=" Select c.clId,c.clientCode  from Project p ,Client c where p.clientId=c.clId and p.projectStatus='OPEN'";

            
            clobj = session.createQuery(query).list();
            System.out.println(""+clobj);
            session.getTransaction().commit();

            log.info("Committed Successfully");

        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
            log.error("Failed to retreived", e);
            throw new DAOException("unknown error", e.getCause());

        } finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }

        return clobj;
    }

    public List<ClientStatusReport> getClientStatusReport() throws DAOException
    {

        List clientdetails=null;

        List<ClientStatusReport> cdetail=new ArrayList<ClientStatusReport>();
        Session session=null;

        String query=" Select c.clId,c.clientName,c.address,c.phone,c.fax,c.email from Project p ,Client c where p.clientId=c.clId and p.projectStatus='OPEN'";
        try
        {
            session=getSession();
            session.beginTransaction();
            ClientStatusReport clpojo=null;
           clientdetails=session.createQuery(query).list();
          Iterator i = clientdetails.iterator();

          while (i.hasNext())
          {

             clpojo=new  ClientStatusReport();

             Object details[] = (Object[]) i.next();
             clpojo.setClId(Integer.parseInt(details[0].toString()));
             clpojo.setClientName(details[1].toString());
             
             clpojo.setAddress(details[2].toString());
             clpojo.setPhone(details[3].toString());
             clpojo.setFax(details[4].toString());
             clpojo.setEmail(details[5].toString());


             cdetail.add(clpojo);



          }
          session.getTransaction().commit();
          log.info("Commited successfully");

        }

        catch(Exception e)
        {
            session.getTransaction().rollback();
            log.error("An exception ocur exception type is :"+e);

        }

        finally {
            if (session != null) {
                session.flush();
                session.close();
            }
        }


        return cdetail;

    }



}
