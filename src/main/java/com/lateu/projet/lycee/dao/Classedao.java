/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.MaClaCoef;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public interface Classedao extends IDao<Classe, Long>{
     Classe findClassebyCode(String libele)throws DataAccessException; 
    // Classe findClassebycode(String code)throws DataAccessException; 
     Classe MatiereValide(String matiere,String classe)throws DataAccessException;
     List <MaClaCoef> SommeCoef(String classe)throws DataAccessException;
      List<Eleve> findElevebyClasse(Long idClasse,String codeAnnee)throws DataAccessException; 
       List<Classe> findByNiveau(String idNiveau)throws DataAccessException; 
    
}
