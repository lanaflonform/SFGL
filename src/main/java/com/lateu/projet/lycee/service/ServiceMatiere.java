/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.Matiere;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public interface ServiceMatiere {
    void create(Matiere matiere)throws ServiceException;
     public  List<Matiere>  findAll()throws ServiceException;
       public Matiere  findById(Long id)throws ServiceException;
         public  List<Matiere>  findMatiereByClassecode(String id)throws ServiceException;
    
}
