/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.dao;

import com.pojo.Consultancy;
import com.pojo.Skills;
import java.util.List;

/**
 *
 * @author ranjans
 */
public interface ConsultancyDAO {

     /***
      * 
      * @param consultancy
      * @return
      * @throws DAOException
      */
     public boolean addConsultancy(Consultancy consultancy)throws DAOException;
     /***
      * 
      * @param consultancy
      * @return
      * @throws DAOException
      */
     public boolean updateConsultancy(Consultancy consultancy)throws DAOException;
     /***
      * 
      * @param consultancy
      * @return
      * @throws DAOException
      */
     public boolean deleteConsultancy(Consultancy consultancy)throws DAOException;
     /***
      * 
      * @param consultancy
      * @return
      * @throws DAOException
      */
     public Consultancy searchConsultancy(Consultancy consultancy)throws DAOException;
     /***
      * This method is use for search
      * consultancy based on
      * Training provide on === skills
      * @param skills
      * @return
      * @throws DAOException
      */
     public List<Consultancy> searchConsultancybySkill(Skills skills)throws DAOException;
     /***
      * 
      * @return
      * @throws DAOException
      */
     public List<Consultancy> searchConsultancies()throws DAOException;
     /***
      * 
      * @return
      * @throws DAOException
      */
     public List<Consultancy> searchAllConsultancies()throws DAOException;
}
