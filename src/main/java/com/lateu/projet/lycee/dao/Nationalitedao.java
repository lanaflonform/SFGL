/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.entities.Nationalite;

/**
 *
 * @author richardlateu
 */
public interface Nationalitedao extends IDao<Nationalite, Long> {
    Nationalite findNationalitebypays(String libele)throws DataAccessException; 
}
