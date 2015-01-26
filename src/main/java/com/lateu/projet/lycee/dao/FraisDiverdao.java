/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;

import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.entities.FraisCumule;
import com.lateu.projet.lycee.entities.FraisDiver;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public interface FraisDiverdao extends IDao<FraisDiver, Long>{
     public List<FraisCumule> findCumule(Long iden);
    
}
