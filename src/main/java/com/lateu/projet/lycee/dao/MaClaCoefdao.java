/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.entities.MaClaCoef;

/**
 *
 * @author richardlateu
 */
public interface MaClaCoefdao extends IDao<MaClaCoef, Long>{
     MaClaCoef getLevelMatiere(Long idmat,Long idClasse) throws DataAccessException;
    
}
