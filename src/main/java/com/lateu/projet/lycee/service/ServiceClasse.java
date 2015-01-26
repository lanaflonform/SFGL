/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public interface ServiceClasse {
     void create(Classe classe) throws ServiceException;
     List<Classe> findAll()throws ServiceException;
     Classe findById(Long id)throws ServiceException;
     Classe findBylibele(String s)throws ServiceException;
     Long TotalCoeficient(String libele)throws ServiceException;
            public  List<Eleve> FindByClasse(String codeClasse,String codeAnnee)throws ServiceException;
    
}
