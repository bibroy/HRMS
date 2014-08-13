package com.dao;

import com.ImplClass.AssessmentEventDAOImpl;
import com.ImplClass.LoginDAOImpl;
import com.ImplClass.MenuDAOImpl;
import com.ImplClass.LeaveDetailsDAOImpl;
import com.ImplClass.LeaveRequestDAOImpl;
import com.ImplClass.EmployeeMasterDAOImpl;
import com.ImplClass.EmployeeConfirmationDAOImpl;
import com.ImplClass.LeavePerRoleDAOImpl;
import com.ImplClass.LoanDAOImpl;
import com.ImplClass.AirTicketRequestDAOImpl;
import com.ImplClass.EmployeeFamilyDetailsDAOImpl;
import com.ImplClass.PassengersDetailsDAOImpl;
import com.ImplClass.PurposeOfTripDAOImpl;
import com.ImplClass.AdvancedSalaryRequestDAOImpl;
import com.ImplClass.ReimbursmentDAOImpl;
import com.ImplClass.RecieptDocumentDAOImpl;
import com.ImplClass.CompanyDAOImpl;
import com.ImplClass.CountryDAOImpl;
import com.ImplClass.CityDAOImpl;
import com.ImplClass.StateDAOImpl;
import com.ImplClass.ProfReferenceDetailsDAOImpl;
import com.ImplClass.VisaPassortDetailsDAOImpl;
import com.ImplClass.EmployeeEducationDetailsDAOImpl;
import com.ImplClass.EmployeeCertificationDAOImpl;
import com.ImplClass.EmployeeSkillDAOImpl;
import com.ImplClass.PreviousEmployerDetailsDAOImpl;
import com.ImplClass.SkillsDAOImpl;
import com.ImplClass.AppraisalCategoryDAOImpl;
import com.ImplClass.AppraisalGradeDAOImpl;
import com.ImplClass.AppraisalSetupDAOImpl;
import com.ImplClass.AppraisalEmpInfoDAOImpl;
import com.ImplClass.DepartmentDAOImpl;
import com.ImplClass.DesignationDAOImpl;
import com.ImplClass.AppraisalQuestionsDAOImpl;
import com.ImplClass.AppraisalResultDAOImpl;
import com.ImplClass.AppraisalSelfDAOImpl;
import com.ImplClass.TrainingDAOImpl;
import com.ImplClass.TrainingTypeDAOImpl;
import com.ImplClass.JobTypeDAOImpl;
import com.ImplClass.DocDumpDAOImpl;
import com.ImplClass.TrainingTransactionDAOImpl;
import com.ImplClass.TrainingEmployeeTransactionDAOImpl;
import com.ImplClass.ConsultancyDAOImpl;
import com.ImplClass.ClientDAOImpl;
import com.ImplClass.ClientGrpDAOImpl;
import com.ImplClass.ProjectDAOImpl;
import com.ImplClass.TaskDAOImpl;
import com.ImplClass.RecruitmentDAOImpl;
import com.ImplClass.RecruitmentMarksDAOImpl;
import com.ImplClass.SalaryDAOImpl;
import com.ImplClass.TimeSheetDAOImpl;
import com.ImplClass.VisaRequestDetailsDAOImpl;
import com.ImplClass.AttendanceDAOImpl;
import com.ImplClass.EmpSkillDAOImpl;
import com.ImplClass.KeyPositionDAOImpl;
import com.ImplClass.VacanciesDAOImpl;
import com.ImplClass.BranchDAOImpl;
import com.ImplClass.EmployeeAccountDetailsDAOImpl;
import com.ImplClass.recruitmentRequestDAOImpl;
import com.ImplClass.DepartmentDAOImpl;
import com.ImplClass.AgenciesDAOImpl;
import com.ImplClass.ComplaintsDAOImpl;
import com.ImplClass.TransportDAOImpl;
import com.ImplClass.ConferenceRoomDAOImpl;
import com.ImplClass.EmployeeJobHistoryDAOImpl;
import com.ImplClass.RelatedDocumentsDAOImpl;
import com.ImplClass.FacilityRequisitionDAOImpl;
import com.ImplClass.GradeMasterDAOImpl;
import com.ImplClass.RoleMasterDAOImpl;
import com.ImplClass.ShiftMasterDAOImpl;
import com.ImplClass.WorkShiftDAOImpl;
import com.ImplClass.TrainingCalenderDAOImpl;
import com.pojo.TrainingMaster;
import com.ImplClass.EmployeeInsuranceDAOImpl;
import com.ImplClass.PhoneReimbursementDAOImpl;
import com.ImplClass.TrainingSheduleDAOImpl;
import com.ImplClass.TrainingFeedbackImpl;
import com.ImplClass.EmployeeFamilyDetailsDAOImpl;
import com.ImplClass.CompensationDAOImpl;
import com.ImplClass.GoalSettingDAOImpl;
import com.ImplClass.ProjectJobsDAOImpl;
import com.ImplClass.ProjectEmpDAOImpl;
import com.ImplClass.EmpProjRelocationHistoryDAOImpl;

public final class DAOFactory {

    public ProjectJobsDAO createProjectJobsManager() throws DAOException {
        return new ProjectJobsDAOImpl();
    }

    public ProjectEmpDAO createProjectEmpManager() throws DAOException {
        return new ProjectEmpDAOImpl();
    }

    public EmpProjRelocationHistoryDAO createEmpProjRelocationHistoryManager() throws DAOException {
        return new EmpProjRelocationHistoryDAOImpl();
    }

    public GoalSettingDAO createGoalsManager() throws DAOException {
        return new GoalSettingDAOImpl();
    }

    public PhoneReimbursementDAO createPhoneReimbursementManager() throws DAOException {

        return new PhoneReimbursementDAOImpl();
    }

    public EmployeeInsuranceDAO createEmployeeInsuranceManager() throws DAOException {
        return new EmployeeInsuranceDAOImpl();
    }

    public FacilityRequisitionDAO createFacilityManager() throws DAOException {
        return new FacilityRequisitionDAOImpl();
    }

    public RelatedDocumentsDAO createDocumentManager() throws DAOException {
        return new RelatedDocumentsDAOImpl();
    }

    public ConferenceRoomDAO createConferenceRoomManager() throws DAOException {
        return new ConferenceRoomDAOImpl();
    }

    public TransportDAO createTransportManager() throws DAOException {
        return new TransportDAOImpl();
    }

    public ComplaintsDAO createComplaintManger() throws DAOException {
        return new ComplaintsDAOImpl();
    }

    public BranchDAO createBranchManager() throws DAOException {
        return new BranchDAOImpl();
    }

    public VacanciesDAO createVacancyManager() throws DAOException {
        return new VacanciesDAOImpl();
    }

    public KeyPositionDAO createKeyPositionManager() throws DAOException {
        return new KeyPositionDAOImpl();
    }

    public EmpSkillsDAO createEmpSkillManager() throws DAOException {
        return new EmpSkillDAOImpl();
    }

    public AttendanceDAO createAttendanceManager() throws DAOException {
        return new AttendanceDAOImpl();
    }

    public VisaRequestDetailsDAO createVisaRequestDetailsManager() throws DAOException {
        return new VisaRequestDetailsDAOImpl();
    }

    public TimeSheetDAO createTimeSheetManager() throws DAOException {
        return new TimeSheetDAOImpl();
    }

    public SalaryDAO createSalaryManager() throws DAOException {
        return new SalaryDAOImpl();
    }

    public RecruitmentMarksDAO createRecruitmentMarksManager() throws DAOException {
        return new RecruitmentMarksDAOImpl();
    }

    public RecruitmentDAO createRecruitmentManager() throws DAOException {
        return new RecruitmentDAOImpl();
    }

    public TaskDAO createTaskManager() throws DAOException {
        return new TaskDAOImpl();
    }

    public ProjectDAO createProjectManager() throws DAOException {
        return new ProjectDAOImpl();
    }

    public ClientGrpDAO createClientGrpManager() throws DAOException {
        return new ClientGrpDAOImpl();
    }

    public ClientDAO createClientManager() throws DAOException {
        return new ClientDAOImpl();
    }

    public ConsultancyDAO createConsultancyManager() throws DAOException {
        return new ConsultancyDAOImpl();
    }

    public TrainingEmployeeTransactionDAO createTrainingEmployeeTransactionManager() throws DAOException {
        return new TrainingEmployeeTransactionDAOImpl();
    }

    public TrainingTransactionDAO createTrainingTransactionManager() throws DAOException {
        return new TrainingTransactionDAOImpl();
    }

    public DocDumpDAO createDocDumpManager() throws DAOException {
        return new DocDumpDAOImpl();
    }

    public JobTypeDAO createJobTypeManager() throws DAOException {
        return new JobTypeDAOImpl();
    }

    public TrainingTypeDAO createTrainingTypeManager() throws DAOException {
        return new TrainingTypeDAOImpl();
    }

    public TrainingDAO createTrainingManager() throws DAOException {
        return new TrainingDAOImpl();
    }

    public AppraisalSelfDAO createAppraisalSelftManager() throws DAOException {
        return new AppraisalSelfDAOImpl();
    }

    public AppraisalResultDAO createAppraisalResultManager() throws DAOException {
        return new AppraisalResultDAOImpl();
    }

    public AppraisalQuestionsDAO createAppraisalQuestionsManager() throws DAOException {
        return new AppraisalQuestionsDAOImpl();
    }

    public DesignationDAO designationManager() throws DAOException {
        return new DesignationDAOImpl();
    }

    public DepartmentDAO departmentManager() throws DAOException {
        return new DepartmentDAOImpl();
    }

    public AppraisalEmpInfoDAO createAppraisalEmpInfoManager() throws DAOException {
        return new AppraisalEmpInfoDAOImpl();
    }

    public AppraisalSetupDAO createAppraisalSetupManager() throws DAOException {
        return new AppraisalSetupDAOImpl();
    }

    public AppraisalGradeDAO createAppraisalGradeManager() throws DAOException {
        return new AppraisalGradeDAOImpl();
    }

    public AppraisalCategoryDAO createAppraisalCategoryManager() throws DAOException {
        return new AppraisalCategoryDAOImpl();
    }

    public SkillsDAO createSkillsManager() throws DAOException {
        return new SkillsDAOImpl();
    }

    public PreviousEmployerDetailsDAO createPreviousEmployerDetailsManager() throws DAOException {
        return new PreviousEmployerDetailsDAOImpl();
    }

    public EmployeeSkillDAO createEmployeeSkillManager() throws DAOException {
        return new EmployeeSkillDAOImpl();
    }

    public EmployeeCertificationDAO createEmployeeCertificationManager() throws DAOException {
        return new EmployeeCertificationDAOImpl();
    }

    public EmployeeEducationDetailsDAO createEmployeeEducationDetailsManager() throws DAOException {
        return new EmployeeEducationDetailsDAOImpl();
    }

    public VisaPassortDetailsDAO createVisaPassportDetailsManager() throws DAOException {
        return new VisaPassortDetailsDAOImpl();
    }

    public ProfReferenceDetailsDAO createProfReferenceDetailsManager() throws DAOException {
        return new ProfReferenceDetailsDAOImpl();
    }

    public StateDAO createStateManager() throws DAOException {
        return new StateDAOImpl();
    }

    public CountryDAO createCountryManager() throws DAOException {
        return new CountryDAOImpl();
    }

    public CityDAO createCityManager() throws DAOException {
        return new CityDAOImpl();
    }

    public LoginDAO createLoginManager() throws DAOException {
        return new LoginDAOImpl();
    }

    public MenuDAO createMenuManager() throws DAOException {
        return new MenuDAOImpl();
    }

    public LeaveDetailsDAO createLeaveDetailsManager() throws DAOException {
        return new LeaveDetailsDAOImpl();
    }

    public LeaveRequestDAO createLeaveRequestManager() throws DAOException {
        return new LeaveRequestDAOImpl();
    }

    public EmployeeMasterDAO createEmployeeMasterManager() throws DAOException {
        return new EmployeeMasterDAOImpl();
    }

    public EmployeeConfirmationDAO createEmployeeConfirmationManager() throws DAOException {
        return new EmployeeConfirmationDAOImpl();
    }

    public LeavePerRoleDAO createLeavePerRoleManager() throws DAOException {
        return new LeavePerRoleDAOImpl();
    }

    public LoanDAO createLoanManager() throws DAOException {
        return new LoanDAOImpl();
    }

    public AirTicketRequestDAO createAirTicketRequestManager() throws DAOException {
        return new AirTicketRequestDAOImpl();
    }

    public EmployeeFamilyDetailsDAO createEmployeeFamilyDetailsManager() throws DAOException {
        return new EmployeeFamilyDetailsDAOImpl();
    }

    public PassengersDetailsDAO createPassengersDetailsManager() throws DAOException {
        return new PassengersDetailsDAOImpl();
    }

    public PurposeOfTripDAO createPurposeOfTripManager() throws DAOException {
        return new PurposeOfTripDAOImpl();
    }

    public AdvancedSalaryRequestDAO createAdvancedSalaryRequestManager() throws DAOException {
        return new AdvancedSalaryRequestDAOImpl();
    }

    public ReimbursmentDAO createReimbursmentManager() throws DAOException {
        return new ReimbursmentDAOImpl();
    }

    public RecieptDocumentDAO createRecieptDocumentManager() throws DAOException {
        return new RecieptDocumentDAOImpl();
    }

    public CompanyDAO createCompanyManager() throws DAOException {
        return new CompanyDAOImpl();
    }

    public recruitmentRequestDAO recruitmentRequestManager() throws DAOException {
        return new recruitmentRequestDAOImpl();

    }

    public AgenciesDAO createAgenciesManager() throws DAOException {
        return new AgenciesDAOImpl();

    }

    public EmployeeAccountDetailsDAO createEditEmployeeAccountDetailsManager() throws DAOException {
        return new EmployeeAccountDetailsDAOImpl();
    }

    public AssessmentEventDAO createAssessmentEventManager() throws DAOException {
        return new AssessmentEventDAOImpl();
    }

    public CompensationDao createCompensationManager() throws DAOException {
        return new CompensationDAOImpl();
    }

    public DepartmentDAO createDepartmentManager() throws DAOException {
        return new DepartmentDAOImpl();

    }

 

    public WorkShiftDAO createWorkShiftManager() throws DAOException {
        return new WorkShiftDAOImpl();
    }

    public EmployeeJobHistoryDAO createEmployeeJobHistoryDAOManager() throws DAOException {

        return new EmployeeJobHistoryDAOImpl();
    }

    public BranchDAO createBranchDAOManager() throws DAOException {

        return new BranchDAOImpl();
    }

    public ShiftMasterDAO createShiftMasterManager() throws DAOException {

        return new ShiftMasterDAOImpl();

    }

    public GradeMasterDAO creteGradeManager() throws DAOException {

        return new GradeMasterDAOImpl();
    }

    public RoleMasterDAO createRoleManager() {
        return new RoleMasterDAOImpl();

    }

    public TrainingCalenderDao createTrainingCalenderManager() throws DAOException {

        return new TrainingCalenderDAOImpl();
    }

    public TrianingSheduleDAO createTrainingSheduleManager() throws DAOException {

        return new TrainingSheduleDAOImpl();
    }

    public TraingFeedbackDAO createtrainingFeedbackManager() throws DAOException {

        return new TrainingFeedbackImpl();

    }

    public EmployeeFamilyDetailsDAO createEmployeeFamilyDetailManager() throws DAOException {

        return new EmployeeFamilyDetailsDAOImpl();
    }
}
