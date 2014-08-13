/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.ConferenceRoomBooking;
import com.pojo.ConferenceRoomMaster;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Sumit Kumar
 */

public interface ConferenceRoomDAO {
    /**
     * function for booking a conference room
     * @param crb pojo of Conference Room Booking
     * @return boolean value, whether data is saved or not
     * @throws DAOException
     */
    public boolean saveBooking(ConferenceRoomBooking crb)throws DAOException;

    /**
     * function for adding a conference room
     * @param crm
     * @return
     * @throws DAOException
     */
    public boolean saveConferenceRoom(ConferenceRoomMaster crm)throws DAOException;

    /**
     * gets list of all booking
     * @return
     * @throws DAOException
     */
    public List<ConferenceRoomBooking> getAllBooking()throws DAOException;

    /**
     *
     * @param dt date whose bookings are needed
     * @return
     * @throws DAOException
     */
    public List<ConferenceRoomBooking> getAllBookingByDate(String dt)throws DAOException;

    /**
     * gets all booking in between the given timestamp values
     * @param startdt starting timestamp value
     * @param enddt end timestamp value
     * @return
     * @throws DAOException
     */
    public List<ConferenceRoomBooking> getAllBookingInBetweenTime(String starttime, String endtime, String roomno)throws DAOException;

    /**
     * gets list of all conference rooms
     * @return
     * @throws DAOException
     */
    public List<ConferenceRoomMaster> getAllConferenceRooms()throws DAOException;

    /**
     * gets last booking id
     * @return
     * @throws DAOException
     */
    public BigDecimal getLastRequestId()throws DAOException;

    /**
     * gets last room id
     * @return
     * @throws DAOException
     */
    public BigDecimal getLastRoomid() throws DAOException;

    /**
     * get all request from a particular employee
     * @param Empid
     * @return
     * @throws DAOException
     */
    public List<ConferenceRoomBooking> getAllRequest(String Empid)throws DAOException;
}
