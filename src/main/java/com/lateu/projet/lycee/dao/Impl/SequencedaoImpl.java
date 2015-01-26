/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.Sequencedao;
import com.lateu.projet.lycee.entities.Sequence;

/**
 *
 * @author richardlateu
 */
public class SequencedaoImpl extends GenericDao<Sequence, Long>implements Sequencedao{

    public Sequence findSequencebyintitule(String intitule) throws DataAccessException {
        return  (Sequence) getManager().createNamedQuery("findSequencebyintitule")
                .setParameter("intitule", intitule)
                .getSingleResult();
    }
    
}
