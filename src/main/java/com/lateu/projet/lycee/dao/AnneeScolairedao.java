/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.entities.AnneeScolaire;

/**
 *
 * @author richardlateu
 */
public interface AnneeScolairedao extends IDao<AnneeScolaire, Long>{
    public AnneeScolaire findByCode(String s)throws DataAccessException;
}
