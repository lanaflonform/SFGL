/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.entities.Professeur;

/**
 *
 * @author richardlateu
 */
public interface Professeurdao extends IDao<Professeur, Long> {
   public Professeur findByMat(String mat)throws DataAccessException;
}
