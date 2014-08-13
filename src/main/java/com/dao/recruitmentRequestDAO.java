/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;
import com.pojo.recruitmentRequestpojo;
import java.math.BigDecimal;

import java.util.List;

/**
 *
 * @author computer1
 */
public interface recruitmentRequestDAO {
    public boolean save(recruitmentRequestpojo rrp)throws DAOException;

    public recruitmentRequestpojo getrecruitmentRequestpojo() throws DAOException;

    public recruitmentRequestpojo getrecruitmentRequestpojo(String quali) throws DAOException;

    public recruitmentRequestpojo getrecruitmentbyskill(String skillreq) throws DAOException;

    public recruitmentRequestpojo getrecruitmentbyexp(String exp) throws DAOException;

    public recruitmentRequestpojo getrecruitmentbypost(String post) throws DAOException;

    public List<recruitmentRequestpojo> getAllrecruitmentRequest() throws DAOException;
     public Integer getLastRequestId() throws DAOException;

}
