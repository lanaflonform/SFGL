/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.Motif;
import java.util.List;

/**
 *
 * @author lateu
 */
public interface ServiceMotif {
    public void create(Motif m) throws ServiceException ;
    public List<Motif> findAll()throws ServiceException ;
    
}
