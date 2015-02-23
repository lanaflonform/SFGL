/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.AnneeScolaire;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public interface ServiceAnneeScolaire {
    public void create(AnneeScolaire annee)throws ServiceException;
    public AnneeScolaire finAnneeScolairebyID(Long id)throws ServiceException;
      public AnneeScolaire finAnneeScolairebyCode(String s)throws ServiceException;
    public  List<AnneeScolaire> findAll()throws ServiceException;
}
