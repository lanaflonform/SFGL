/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.EmploiDeTemps;
import com.lateu.projet.lycee.entities.Matiere;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface ServiceEmploi {

    public void SaveEmploi(EmploiDeTemps e, Classe cl, Matiere m) throws ServiceException;

    public List<EmploiDeTemps> findAll() throws ServiceException;

    public int Valider(EmploiDeTemps e, Classe cl, Matiere mat) throws ServiceException;
    public List<EmploiDeTemps> findForClasse(Long idClasse) throws ServiceException;
     public List<EmploiDeTemps> Valider(Long idClassse,Long idMatiere,String jour) throws ServiceException;
}
