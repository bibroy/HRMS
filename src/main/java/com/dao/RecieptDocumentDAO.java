/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.RecieptDocuments;
import java.math.BigDecimal;

/**
 *
 * @author sujatas
 */
public interface RecieptDocumentDAO {
    public boolean addDocDump(RecieptDocuments docDump) throws DAOException;
 public BigDecimal getLastRequestId() throws DAOException;
}
