/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Motif;

/**
 *
 * @author richardlateu
 */
public interface Motifdao extends IDao<Motif, Long>{
    Motif findMotifbylibele(String libele)throws DataAccessException; 
}
