/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.Motifdao;
import com.lateu.projet.lycee.entities.Motif;


/**
 *
 * @author richardlateu
 */
public class MotifdaoImpl extends GenericDao<Motif, Long>implements Motifdao{

    public Motif findMotifbylibele(String libele) throws DataAccessException {
         return  (Motif) getManager().createNamedQuery("findMotifbylibele")
                .setParameter("libele", libele)
                .getSingleResult();
    }
    
}
