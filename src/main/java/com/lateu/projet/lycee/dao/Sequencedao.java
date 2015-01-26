/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.entities.Sequence;

/**
 *
 * @author richardlateu
 */
public interface Sequencedao extends IDao<Sequence, Long>{
    Sequence findSequencebyintitule(String intitule)throws DataAccessException;
    
}
