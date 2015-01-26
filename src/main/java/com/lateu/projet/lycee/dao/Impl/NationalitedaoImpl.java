/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.Nationalitedao;
import com.lateu.projet.lycee.entities.Nationalite;

/**
 *
 * @author richardlateu
 */
public class NationalitedaoImpl extends GenericDao<Nationalite, Long> implements Nationalitedao{

    public Nationalite findNationalitebypays(String pays) throws DataAccessException {
         return  (Nationalite) getManager().createNamedQuery("findNationalitebypays")
                .setParameter("pays", pays)
                .getSingleResult();
    }
    
}
