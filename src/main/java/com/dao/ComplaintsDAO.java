/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;
import com.pojo.ComplainDetails;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Sumit Kumar
 */
public interface ComplaintsDAO {

    public boolean saveComplaint(ComplainDetails cd) throws DAOException;

    public List<ComplainDetails> getAllComplaints() throws DAOException;

    public List<ComplainDetails> getComplaintsbyEmpId(String EmployeeId) throws DAOException;

    public BigDecimal getLastComplaintId() throws DAOException;


}
