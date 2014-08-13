/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.PurposeOfTrip;
import java.util.List;

/**
 *
 * @author sujatas
 */
public interface PurposeOfTripDAO {
    public boolean save(PurposeOfTrip purpose)throws DAOException;

		public PurposeOfTrip getPurposeOfTrip(String purposeName) throws DAOException;
                public List<PurposeOfTrip> getAllPurposeOfTrip() throws DAOException;


}
