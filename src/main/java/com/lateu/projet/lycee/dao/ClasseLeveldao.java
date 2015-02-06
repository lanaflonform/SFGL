/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.Enum.Cycle;
import com.lateu.projet.lycee.entities.ClasseLevel;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface ClasseLeveldao  extends IDao<ClasseLevel, Long> {
  
    List<ClasseLevel> findByCycleId(Cycle c)throws DataAccessException;
}
