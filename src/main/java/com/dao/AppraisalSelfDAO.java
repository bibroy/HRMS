/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.AppraisalSelf;
import java.util.List;

/**
 *
 * @author swarnendum
 */
public interface AppraisalSelfDAO {

    public boolean save(AppraisalSelf appraisalself) throws DAOException;

    public List<AppraisalSelf> getAppraisalSelfResult() throws DAOException;


}
