/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.AnneeScolairedao;
import com.lateu.projet.lycee.entities.AnneeScolaire;

/**
 *
 * @author richardlateu
 */
public class AnneeScolairedaoImpl extends GenericDao<AnneeScolaire, Long>implements AnneeScolairedao{

    @Override
    public AnneeScolaire findByCode(String s) throws DataAccessException {
  
         return  (AnneeScolaire) getManager().createNamedQuery("findAnneeByCode")
                .setParameter("code", s)
                .getSingleResult();
    
    }
    
}
