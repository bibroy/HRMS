/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.Client;
import java.util.List;

/**
 * 
 * @author shrayanti
 */
public interface ClientDAO {
                public boolean save(Client client)throws DAOException;


		public Client getClient(Integer clId) throws DAOException;



		public List<Client> getAllClient() throws DAOException;
                public List<Client> getAllClientByClientgroup(long clientGrpid)  throws DAOException;
                
}
