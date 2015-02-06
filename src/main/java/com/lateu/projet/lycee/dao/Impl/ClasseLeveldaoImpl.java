/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.Enum.Cycle;
import com.lateu.projet.lycee.dao.ClasseLeveldao;
import com.lateu.projet.lycee.entities.ClasseLevel;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public class ClasseLeveldaoImpl extends GenericDao<ClasseLevel, Long> implements ClasseLeveldao{

    @Override
    public List<ClasseLevel> findByCycleId(Cycle c) throws DataAccessException {
  
     return getManager().createNamedQuery("findbyCycleId")
                .setParameter("idCycle", c)
                .getResultList();
    }


   
    
}
