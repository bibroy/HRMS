/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.RelatedDocuments;
import java.util.List;

/**
 *
 * @author Sumit Kumar
 */
public interface RelatedDocumentsDAO {

    public boolean sendRequest(RelatedDocuments document) throws DAOException;

    public RelatedDocuments viewOfficialDocumentsRequestData(Integer requestCode) throws DAOException;

    public List<RelatedDocuments> getAllEmployees() throws DAOException;

    public boolean approve(RelatedDocuments documents) throws DAOException;

    public boolean reject(RelatedDocuments documents) throws DAOException;

    public List getSingleEmployeeDetails(String employeeId) throws DAOException;

    public long getLastRequestId()throws DAOException;
}
