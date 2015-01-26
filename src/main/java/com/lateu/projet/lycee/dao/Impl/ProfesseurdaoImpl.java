/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.Professeurdao;
import com.lateu.projet.lycee.entities.Professeur;

/**
 *
 * @author richardlateu
 */
public class ProfesseurdaoImpl extends GenericDao<Professeur, Long>implements Professeurdao{

    @Override
    public Professeur findByMat(String mat) throws DataAccessException {
      return (Professeur)getManager().createNamedQuery("findprofbyMat")
                .setParameter("matricule", mat)
                .getSingleResult();
    }
    
    
    
}
