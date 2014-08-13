/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.util;


import com.dao.CityDAO;
import com.dao.DAOException;
import com.dao.DAOFactory;
import com.dao.DocDumpDAO;
import com.dao.EmployeeMasterDAO;
import com.dao.JobTypeDAO;
import com.dao.SkillsDAO;
import com.dao.TrainingDAO;
import com.dao.TrainingEmployeeTransactionDAO;
import com.dao.TrainingTransactionDAO;
import com.dao.TrainingTypeDAO;
import com.forms.TrainingForm;
import com.pojo.City;

import com.pojo.DocDump;
import com.pojo.EmployeeMaster;
import com.pojo.JobType;
import com.pojo.Skills;
import com.pojo.Training;
import com.pojo.TrainingEmpInfo;
import com.pojo.TrainingRequestEmployee;
import com.pojo.TrainingTransation;
import com.pojo.TrainningType;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.upload.FormFile;


/**
 *
 * @author ranjans
 */
public class TrainingUtil {

    private static  final  Log log=LogFactory.getLog(TrainingUtil.class);
    private static  DAOFactory factory=new DAOFactory();

    private  TrainingUtil() {
    }

    /***
     * 
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new CloneNotSupportedException("Clone not Supported");
    }

    /***
     * Return particular session val
     * against parameter
     * @param paramName
     * @return
     */
    public static  String getSessionVal(String paramName,HttpServletRequest request) throws Exception{

        if(paramName==null){
            throw new Exception("Param Name should has value");
        }
        else if(paramName.trim().length()==0){
            throw new Exception("Param Name should not be blank");
        }
        if(request==null){
            throw new Exception("Request should not be null");
        }
        HttpSession session=request.getSession();
        String paramVal=null;
        if(session.getAttribute(paramName)!=null && session.getAttribute(paramName).toString().trim().length()>0){
                    paramVal=session.getAttribute(paramName).toString().trim();
                  }
        return paramVal;
    }

    /***
     * Pick up required parameters
     * DepartmentCode as deptCode
     * Employee ID as employeeId
     * CompanyCode as companyCode
     * Job Type as typeId
     * It is not now in system
     * and put it into session
     * @param dao
     * @param empId
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static  Map<String,String> getRequireParam(HttpServletRequest request)throws DAOException,Exception{

        if(request==null){
            throw new Exception("request should has value");
        }
        HttpSession session = request.getSession();
        String empId=null;
        Map<String,String>reqFild=null;
        // ===if(getSessionVal("employee_id",request)!=null){
        if(getSessionVal("user_id",request)!=null){
                    // === empId=getSessionVal("employee_id",request);
                    empId=getSessionVal("user_id",request);
                    log.info("@@@ After Approval training Report @@@"+empId);
                }
        if(getSessionVal("reqFild",request)!=null)
        {
            // -- pick up value from session
            reqFild=(Map<String,String>)session.getAttribute("reqFild");            
        }
        else
        {
            // -- add value to session
            // -- set value to session            
            TrainingDAO dao = factory.createTrainingManager();
            reqFild= dao.getRequireParaetersForTraining(empId);
            session.setAttribute("reqFild", reqFild);
        }
        return reqFild;
    }

    /***
     * populate Employee Details
     * and
     * Employee full name
     * key name of Employee object is employeeDetails
     * key name of Employee full name is name
     * Based on EmployeeID
     * @param empId
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static  Map<String,Object> populateEmpName(int empId)throws DAOException,Exception{
      
        if(empId==0){
            throw new Exception("empId should has value");
        }
        // -- EmployeeDAO employeeDAO=factory.createEmployeeManager();
        EmployeeMasterDAO employeeDAO=factory.createEmployeeMasterManager();
        
        // --- EmpDetails employeeDetails=null;

        EmployeeMaster employeeDetails=null;

        Map<String,Object> empDtl=new HashMap<String, Object>();
        /***
         * manipulate employee name
         */
                 log.info(" @@@ before getEmployee method @@@");
                 log.info("@@@ Employee Id in static util class @@@"+empId);
                 // --- employeeDetails=employeeDAO.getEmployee(empId);
                 employeeDetails=employeeDAO.getEmployeeMaster(empId);
                 log.info(" @@@ after getEmployee method @@@");
                
                // -- employeeDetails.setFirstName(name.toString());
                 empDtl.put("name", getFullName(employeeDetails));
                 empDtl.put("employeeDetails", employeeDetails);
          return empDtl;
        //return employeeDetails;
    }

    /***
     * Get full name
     * from Employee
     * first name
     * middle name
     * last name
     * @param employeeDetails
     * @return
     * @throws DAOException
     * @throws Exception
     */
    // --public static StringBuffer getFullName(EmpDetails employeeDetails)throws DAOException,Exception{
    public static StringBuffer getFullName(EmployeeMaster employeeDetails)throws DAOException,Exception{
                 if(employeeDetails==null){
                     throw new Exception("employeeDetails object should has value");
                 }
                 log.info("@@@ start getFullName @@@");
                 StringBuffer name=new StringBuffer();
                 try {

                 log.info("@@@ First Name @@@"+employeeDetails.getFirstName());
                 log.info("@@@ Middle Name @@@"+employeeDetails.getMiddleName());
                 log.info("@@@ Last Name @@@"+employeeDetails.getLastName());
                  // --- StringBuffer name=new StringBuffer();
                 if(employeeDetails.getFirstName()!=null && employeeDetails.getFirstName().trim().length()>0){
                    name.append(employeeDetails.getFirstName());
                 }
                 if(employeeDetails.getMiddleName()!=null && employeeDetails.getMiddleName().trim().length()>0){
                    name.append(" "+employeeDetails.getMiddleName());
                 }
                 if(employeeDetails.getLastName()!=null && employeeDetails.getLastName().trim().length()>0){
                    name.append(" "+employeeDetails.getLastName());
                 }
                 } catch (Exception e) {
                     log.info("@@@ Exception in static block @@@");
                     e.printStackTrace();
        }
                 log.info("@@@ last getFullName @@@");
                 return name;
    }

    /***
     * 
     * @param employees
     * @return User name
     * and
     * userId
     * @throws DAOException
     * @throws Exception
     */
   // -- public static List<UserDtls>populateFullNames(List<EmpDetails>employees)throws DAOException,Exception{
     public static List<UserDtls>populateFullNames(List<EmployeeMaster>employees)throws DAOException,Exception{
        if(employees==null){
          throw new Exception("There should be a employees list");
        }
        else if(employees.isEmpty()){
            throw new Exception("employees list is empty");
        }
        List<UserDtls> employeeNames=new ArrayList<UserDtls>();
        // --Iterator<EmpDetails> it=employees.iterator();
        Iterator<EmployeeMaster> it=employees.iterator();
        StringBuffer name=new StringBuffer();
        // --- EmpDetails empDtls;
        EmployeeMaster empDtls;
        while(it.hasNext()){
            empDtls=it.next();
            UserDtls userDetl=new UserDtls();
            userDetl.setUserName(getFullName(empDtls).toString());
            // --  userDetl.setEmployeeId(empDtls.getEmployeeId());
             userDetl.setEmployeeId(empDtls.getId().intValue());
            employeeNames.add(userDetl);
        }
        return employeeNames;
    }

    /***
     * This method 
     * is use for upload file
     * html method should be use post
     * @param request
     * @param trainingForm
     * @param uploadType
     * @return
     * @throws Exception
     */
    public static String uploadFile(HttpServletRequest request,TrainingForm trainingForm,String uploadType)throws Exception{
        
        if(request==null){
            throw new Exception("There should be a request value");
        }
        if(trainingForm==null){
            throw new Exception("There should be a trainingForm value");
        }
        if(uploadType==null){
            throw new Exception("There should be a Upload Type");
        }
        else if(uploadType.trim().length()==0){
            throw new Exception("Upload Type shouldnot be blank");
        }
        FormFile fileDtl=null;
        int fileSize=0;        
        String physicalPath = request.getRealPath("").replace("\\", "/");
        
        log.info("@@@ Print physical path @@@"+physicalPath);
        physicalPath = physicalPath.replace("build/", "");
        String rootDir ="";
        String vartualPath="";
        DataInputStream inpStream=null;
        int byteRead = 0;
        int totalbyteRead = 0;
        FileOutputStream outputStream=null;
        File changeFile=null;


        if(uploadType.equalsIgnoreCase("materials")){
            fileDtl=trainingForm.getTrainingMaterial();
            rootDir = physicalPath + "/Training/data/trainingmaterials/";
            vartualPath="data/trainingmaterials/";
        }
        else if(uploadType.equalsIgnoreCase("feedbackform")){
            fileDtl=trainingForm.getFeedbackMaterial();
            rootDir = physicalPath + "/Training/data/feedbackforms/";
            vartualPath="data/feedbackforms/";
        }
        
        String[]filePart= fileDtl.getFileName().split("\\."); 
        fileSize=fileDtl.getFileSize();
        String prefixFileName=trainingForm.getDdlTrainingName()+"_"+trainingForm.getDdlExpLavel()+"_"+Math.random()+"."+filePart[filePart.length-1];
        byte dataByte[]=new byte[fileSize];
        inpStream=new DataInputStream(fileDtl.getInputStream());
        
        while (totalbyteRead<fileSize) {
           byteRead=inpStream.read(dataByte,totalbyteRead,fileSize);
           totalbyteRead +=byteRead;
        }
        
        outputStream=new FileOutputStream(rootDir+fileDtl.getFileName());
        outputStream.write(dataByte);

        outputStream.flush();
        outputStream.close();

        changeFile=new File(rootDir+fileDtl.getFileName());
        changeFile.renameTo(new File(rootDir+prefixFileName));
       
        return (vartualPath+prefixFileName);
    }   

    /***
     * Get All training Type from Training Type Table
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static List<TrainningType> getAllTrainingType()throws DAOException,Exception{

        List<TrainningType> trainingType=null;
        TrainingTypeDAO trainningTypeDAO =factory.createTrainingTypeManager();
        trainingType=trainningTypeDAO.getAllTrainingType();
        return trainingType;
    }

    /***
     * Populate JobTypes
     * Against Department
     * and
     * Company Code
     * @param joType
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static  List<JobType> getJobTypeAgainstDeptCompanyCode(JobType joType)throws DAOException,Exception{

        if(joType==null){
            throw new Exception("Set JobType object");
        }
        List<JobType> jobTypes=null;
        JobTypeDAO jobTypeDAO=factory.createJobTypeManager();
        jobTypes=jobTypeDAO.getJobTypeAgainstDepertment(joType);
        return jobTypes;
    }

    /***
     * Populate JobType
     * Against Department
     * and
     * Company Code
     * @param joType
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static JobType getOneJobTypeAgainstDeptCompanyCode(JobType joType)throws DAOException,Exception{
        if(joType==null){
            throw new Exception("Set JobType object");
        }
        JobTypeDAO jobTypeDAO=factory.createJobTypeManager();
        return jobTypeDAO.getJobType(joType);
     }

    public static List<Training> getAllTraining()throws DAOException,Exception{

        List<Training>trainings=null;        
        TrainingDAO trainingDAO=factory.createTrainingManager();
        trainings=trainingDAO.getAllTrainingDtls();
        return trainings;
    }

    public static boolean addDocDump(DocDump docDump)throws DAOException,Exception{
        if(docDump==null){
            throw new Exception("docDump should has value");
        }
        boolean flg=false;
        DocDumpDAO docDumpDao=factory.createDocDumpManager();
        docDumpDao.addDocDump(docDump);
        flg=true;
        return flg;
    }

    /***
     *
     * @param skillsDAO
     * @param departmentId
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static  List<Skills>populateSkillsAgainstDepartment(int departmentId)throws DAOException,Exception{
        if(departmentId==0){
          throw new Exception("departmentId should has value");
        }
        SkillsDAO skillsDAO=factory.createSkillsManager();
        return skillsDAO.getSkillsByDepartment(departmentId);
            }
    /***
     * populate skills
     * against jobType
     * @param TypeId
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static  List<Skills>populateSkillsAgainstJobType(int typeId)throws DAOException,Exception{
         if(typeId==0){
          throw new Exception("typeId should has value");
        }
         SkillsDAO skillsDAO=factory.createSkillsManager();
         return skillsDAO.getSkillsByJobType(typeId);
    }

    /***
     * populate training
     * against skill
     * @param skillId
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static List<Training>populateTrainingAgainstSkill(String skillId)throws DAOException,Exception{
         if(skillId==null){
          throw new Exception("skillId should not be null");
        }
         else if(skillId.trim().length()==0){
           throw new Exception("skillId should has value");
         }
        TrainingDAO trainingDao=factory.createTrainingManager();
        return trainingDao.getTrainingDtlsAgainstSkill(skillId);
    }

    /***
     * Generate Training Transaction
     * Against requestId
     * @param requestId
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static TrainingTransation getTrainingTransaction(int requestId) throws DAOException,Exception{

           if(requestId==0){
            throw new Exception("RequestId Id should have value");
        }
           TrainingTransactionDAO trainingDao=factory.createTrainingTransactionManager();
           TrainingTransation training= new TrainingTransation();
           training.setRequestId(requestId);
           return trainingDao.getTrainingTransation(training);
    }

    /***
     * get Employee object
     * against requested employee Id
     * @param request
     * @return
     * @throws DAOException
     * @throws Exception
     */
    // --public static  EmpDetails getEmployeeById(HttpServletRequest request)throws DAOException,Exception{
    public static  EmployeeMaster getEmployeeById(HttpServletRequest request)throws DAOException,Exception{
        if(request.getParameter("empId")==null){
            throw new Exception("request empId is null");
        }
        if(request.getParameter("empId").toString().trim().length()==0){
            throw new Exception("request empId should not blank");
        }
        // --- EmployeeDAO employeeDAO=factory.createEmployeeManager();
        EmployeeMasterDAO employeeDAO=factory.createEmployeeMasterManager();
        // --- return employeeDAO.getEmployee(Integer.parseInt(request.getParameter("empId").toString()));
        return employeeDAO.getEmployeeMaster(Integer.parseInt(request.getParameter("empId").toString()));
    }

     /***
     * Populate List of training objects
     * with status initiated
     * and department Id is given
     * @param trainingDAO
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static  List<Training>populateTrainingListAgainstDepartment(String skillId)throws DAOException,Exception
    {
        if(skillId==null){
            throw new Exception("request skillId is null");
        }
        if(skillId.toString().trim().length()==0){
            throw new Exception("request skillId should not blank");
        }
        TrainingDAO trainingDAO=factory.createTrainingManager();
        return trainingDAO.getTrainingDtlsAgainstSkill(skillId);       
    }


   /***
     * Populate List of
     * training objects
     * with status initiated
     * @param trainingDAO
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static List<Training>populateTrainingList()throws DAOException,Exception
    {
        TrainingDAO trainingDAO=factory.createTrainingManager();
        return trainingDAO.getTrainingDtls();
    }

    /***
     * Populate EmployeeList
     * Against Department
     * @param employeeDAO
     * @return
     * @throws DAOException
     * @throws Exception
     */   
    public static List<EmployeeBean>populateEmployeeListAgainstDepartment(int deptId)throws DAOException,Exception
    {
        if(deptId==0){
            throw new Exception("Department Id should have value");
        }
        TrainingTransactionDAO trainingTransactionDAO=factory.createTrainingTransactionManager();
        return trainingTransactionDAO.getEmployeesAgainstDept(deptId);
        //-- return trainingTransactionDAO.getEmployeesAgainstDept(deptId);
    }

    /***
     * Populate employee
     * full name
     * Experience in Days
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static List<TrainingEmpInfo> populateEmpForInduction()throws DAOException,Exception
    {
        TrainingTransactionDAO trainingTransactionDAO=factory.createTrainingTransactionManager();
        return trainingTransactionDAO.getInEmployees();
    }
    
    /***
     * Get employee
     * Full name
     * Employee ID
     * Employee Code
     * Company days of Exp
     * Past company exp
     * Total Experience
     * @param empId
     * @return
     * @throws DAOException
     */
    public static TrainingEmpInfo populateEmployeeDetail(int empId)throws DAOException,Exception {
        TrainingTransactionDAO trainingTransactionDAO=factory.createTrainingTransactionManager();
        return trainingTransactionDAO.getEmployee(empId);
    }


    /***
     * Select Employee against
     * employeeId , requestId and Flag
     * @param trainingRequestEmployee
     * @return
     * @throws DAOException
     * @throws Exception
     */
    public static TrainingRequestEmployee selectEmployeeAgainstInduction(TrainingRequestEmployee trainingRequestEmployee)throws DAOException,Exception
    {
        TrainingEmployeeTransactionDAO trainingTransactionDAO=factory.createTrainingEmployeeTransactionManager();
        return trainingTransactionDAO.selectInValueAgainstEmployee(trainingRequestEmployee);
        // ===return null;
    }


    /***
     * Return one row against
     * a request Id where
     * database fetching value is
     * group by request Id
     * @param testList
     * @return
     * @throws Exception
     */
    public static List<TrainingTransactionDetail>uniqueVal(List<TrainingTransactionDetail> testList) throws Exception {

			if(testList.size()==0){
				throw new Exception("The pass parameter should have value");
			}

			List<TrainingTransactionDetail> testVals=new ArrayList<TrainingTransactionDetail>();
			List<TrainingTransactionDetail> testBuffer=new ArrayList<TrainingTransactionDetail>();
			TrainingTransactionDetail testBean=null;
			int requestVal=0;
			Iterator<TrainingTransactionDetail>it=testList.iterator();

			 while(it.hasNext()){
				testBean=it.next();
				if(requestVal != testBean.getRequestId()){
					requestVal=testBean.getRequestId();
					if(testBuffer.size()>0){
					testVals.add(testBuffer.get(testBuffer.size()-1));
					testBuffer.clear();
					}
					else if (testList.size()==1) {
						testVals.addAll(testList);
					}
					else {
						testVals.add(testList.get(testList.size()-1));
					}
				}
				testBuffer.add(testBean);
			}
			testVals.add(testVals.get(0));
			testVals.remove(0);
			return testVals;
		}

    /***
     * Send training related mail
     * mailbody is changed based on type
     * @param type
     * @param from
     * @param to
     * @return
     * @throws Exception
     */
    public  static boolean sendMail(String type,String from,String to)throws Exception{
        boolean flag=false;
        
        return flag;
    }

    /***
     * Find the Year of experience
     * In the format of
     * Day Month Year
     * It takes input TrainingEmpInfo object
     * @param employeeDetails
     * @return
     */
    public static  String getExp(TrainingEmpInfo employeeDetails){
        
        int pastExp=0;
        int presentExp=0;
        int day=0;
        int month=0;
        int year=0;
        String exp="";

        if(employeeDetails.getPastExp()!=null){
        pastExp=(((86400*(Math.abs(employeeDetails.getPastExp()))/60)/60)/24);
        }
        if(employeeDetails.getDaysOfExp()!=null){
        presentExp=(((86400*(Math.abs(employeeDetails.getDaysOfExp()))/60)/60)/24);
        }

        presentExp=presentExp+pastExp;
        log.info("@@@ presentExp @@@"+presentExp);
        if(presentExp>30){
         month=presentExp/30;
         day=presentExp%30;

         if(month>12){
             month=month/12;
             year=month%12;
         }
        }else{
         day=presentExp;
        }

        exp=((year!=0)?year+"Year":"") + ((month!=0)?month+"Month":"") + ((day!=0)?day+"Days":"");


        log.info("@@@ Present Info @@@"+exp);
        return exp;
    }

    /***
     * Return all city
     * @return
     * @throws DAOException
     */
    public static List<City>getAllCity() throws DAOException{
        CityDAO cityDAO=factory.createCityManager();
        return cityDAO.getAllCity();
    }
}