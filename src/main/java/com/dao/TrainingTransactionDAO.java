/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.EmployeeMaster;
import com.pojo.TrainingEmpInfo;
import com.pojo.TrainingTransation;
import com.util.EmployeeBean;
import java.util.List;
import java.util.Map;
import com.util.TrainingTransactionDetail;
import java.math.BigDecimal;

/**
 *
 * @author ranjans
 */
public interface TrainingTransactionDAO {


    public BigDecimal getLastRequestId() throws DAOException ;

    /***
     * 
     * @param trainingTransation
     * @return
     * @throws DAOException
     */
    public TrainingTransation getTrainingTransation(TrainingTransation trainingTransation)throws DAOException;
    /***
     * 
     * @return
     * @throws DAOException
     */
    public List<TrainingTransation>getTrainingTransations()throws DAOException;
    /***
     * 
     * @return
     * @throws DAOException
     */
    public List<TrainingTransation>getAllTrainingTransations()throws DAOException;
    /***
     * 
     * @param employee
     * @return
     * @throws DAOException
     */
    public List<TrainingTransation>getTrainingTransationsAgainstEmployee(EmployeeMaster employee)throws DAOException;
    /***
     * 
     * @param trainingTransation
     * @return
     * @throws DAOException
     */
    public boolean insertTrainingTransation(TrainingTransation trainingTransation)throws DAOException;
    /***
     * 
     * @param trainingTransation
     * @return
     * @throws DAOException
     */
    public boolean updateTrainingTransation(TrainingTransation trainingTransation)throws DAOException;

    /***
     * 
     * @param trainingTransation
     * @return
     */
    public List<TrainingTransactionDetail>getTrainingTransactionAgainstFlg(TrainingTransation trainingTransation)throws DAOException;

    /***
     * Return a single TrainingTransactionDetail Bean
     * @param trainingTransation
     * @return
     * @throws DAOException
     */
    public TrainingTransactionDetail getTrainingTransactionAgainst(TrainingTransation trainingTransation,String applyId) throws DAOException;

    /***
     * EmployeeList againsDepartent
     * @param departmentId
     * @return
     * @throws DAOException
     */
    public List<EmployeeBean> getEmployeesAgainstDept(int departmentId) throws DAOException;

    /***
     * Employee Details against
     * employee Id and training Id
     * @param empId
     * @param trainingId
     * @return
     * @throws DAOException
     */
    public List<TrainingEmpInfo>getEmployeesDtlInTraining(String empId)throws DAOException;

     /***
     * Use for generate
     * transaction Report
     * For HOD
     * Where HOD can see only departmental apply value
     * @param trainingTransation
     * @return
     * @throws DAOException
     */
    public List<TrainingTransactionDetail> getTrainingTransactionAgainstFlgForHOD(TrainingTransation trainingTransation,int deptID) throws DAOException;

    /***
     * 
     * @param trainingTransation
     * @return
     * @throws DAOException
     */
    public List<TrainingTransation> getTransactionAgainstFlg(TrainingTransation trainingTransation)throws DAOException;

    /***
     * Populate Employees
     * Who has not yet done
     * Induction training
     * @return
     * @throws DAOException
     */
    public List<TrainingEmpInfo>getInEmployees()throws DAOException;

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
    public TrainingEmpInfo getEmployee(int empId)throws DAOException;
}
