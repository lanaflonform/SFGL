/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.entities.Nationalite;
import com.lateu.projet.lycee.entities.Notes;
import com.lateu.projet.lycee.projection.ReportEntry;
import com.lateu.projet.lycee.projection.PV;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public interface Elevedao extends IDao<Eleve, Long> {
    Eleve findElevebyMatricule(String matricule)throws DataAccessException; 
    List<PV> GeneralPV(String classe)throws DataAccessException; 
    Eleve findMyMarks()throws DataAccessException; 
    List<Eleve> findElevebyNom(String nom)throws DataAccessException; 
   
    Classe rechercheMaClasse(String matricule/*,AnneeScolaire annee*/)throws DataAccessException;
    List<ReportEntry> maSectionBulletin(String codeClasse,String levelmat)throws DataAccessException; 
    List<Notes> findNotebyMatricule(Matiere m, Classe cl)throws DataAccessException; 
    List<Eleve> findElevebyNationalite(Nationalite nationalite) throws DataAccessException;
}
