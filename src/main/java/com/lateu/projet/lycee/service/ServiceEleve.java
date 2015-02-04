/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.MaClaCoef;
import com.lateu.projet.lycee.entities.Nationalite;
import com.lateu.projet.lycee.projection.PV;
import com.lateu.projet.lycee.projection.ReportEntry;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public interface ServiceEleve {

    public void create(Eleve eleve, String annee, String pays, String classe) throws ServiceException;

    public Eleve FindByMatricune(String s, AnneeScolaire annee) throws ServiceException;

    public List<Eleve> FindByNationnalite(Nationalite n, AnneeScolaire annee) throws ServiceException;

    public List<Eleve> FindBySexe(String s, AnneeScolaire annee) throws ServiceException;

    public int EleveNumber(Classe cl, AnneeScolaire annee) throws ServiceException;

    public Long LastIndex(List<Eleve> eleves) throws ServiceException;

    public List<Eleve> FindAll() throws ServiceException;

     List<PV> GeneralPV(String matricule,Long idMatiere)  throws ServiceException;

    public List<ReportEntry> maSectionBulletin(String codeClasse, String level) throws ServiceException;
    
     MaClaCoef getLevelMat(Long idMatiere)  throws ServiceException;
}
