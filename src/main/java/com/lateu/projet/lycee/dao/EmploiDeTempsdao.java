/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.entities.EmploiDeTemps;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface EmploiDeTempsdao extends IDao<EmploiDeTemps, Long> {
    List<EmploiDeTemps> ValiderEmplo(Long idClasse, Long idMatiere, String jour)throws DataAccessException; 
}
