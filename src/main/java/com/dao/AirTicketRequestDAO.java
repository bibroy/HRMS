/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.Airticket;
import java.util.List;

/**
 *
 * @author sujatas
 */
public interface AirTicketRequestDAO {

    public boolean sendRequest(Airticket airTcktReq) throws DAOException;

    public Airticket viewAirTicketRequestData(Integer id) throws DAOException;

    public List<Airticket> getAllEmployees() throws DAOException;

    public boolean approve(Airticket airTcktReq) throws DAOException;

    public boolean reject(Airticket airTcktReq) throws DAOException;

    public List getSingleEmployeeDetails(String employeeId) throws DAOException;

    public List<Airticket> getAllRequest(String empid)throws DAOException;
}
