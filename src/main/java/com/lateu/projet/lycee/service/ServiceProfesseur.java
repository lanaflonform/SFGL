/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.Professeur;
import com.lateu.projet.lycee.entities.UserRole;
import java.util.List;

/**
 *
 * @author lateu
 */
public interface ServiceProfesseur {
    public void create(Professeur p, UserRole role)throws ServiceException;
      public List<Professeur> findAll()throws ServiceException;
        public  int LastIndex(List<Professeur> professeurs)throws ServiceException;
}
