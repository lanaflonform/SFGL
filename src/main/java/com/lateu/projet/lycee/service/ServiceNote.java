/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.Notes;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author richardlateu
 */
@Transactional
public interface ServiceNote {
    public void create(Notes note, String matricule, String sequence,String matiere,Long Annee)throws ServiceException;
       public  List<Notes> FindAll()throws ServiceException;
}
