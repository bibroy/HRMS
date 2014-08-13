/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.ClientGroup;

import java.util.List;


/**
 * 
 * @author shrayanti
 */
public interface ClientGrpDAO {

                public boolean save(ClientGroup client)throws DAOException;


		public ClientGroup getClientGrp(Integer clientGrpId) throws DAOException;



		public List<ClientGroup> getAllClientGrp() throws DAOException;

}
