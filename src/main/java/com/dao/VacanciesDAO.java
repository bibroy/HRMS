/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.pojo.vacancies;
import java.util.List;

/**
 *
 * @author computer4
 */
public interface VacanciesDAO {

    public List<vacancies> getAllVacancies() throws DAOException;

    public boolean save(vacancies vac) throws DAOException;

    public Integer getLastId() throws DAOException;
}
