/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.MaClaCoef;
import com.lateu.projet.lycee.entities.Matiere;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public interface Matieredao extends IDao<Matiere, Long>{
  Matiere findMatierebyIntitule(String intitule)throws DataAccessException; 
  MaClaCoef findCoef(String Matiere,String classe)throws DataAccessException; 
   List<Matiere> findMatiereByClasseCode(String idClasse)throws DataAccessException; 
}
