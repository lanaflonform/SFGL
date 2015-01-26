/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.FraisDiver;
import java.util.List;

/**
 *
 * @author lateu
 */
public interface ServiceFraisDivers {
    
    public void creer(FraisDiver f, String codeAnnee, String matEleve,String nomMotif) throws ServiceException;
    public List<FraisDiver> findAll()throws ServiceException ;
     public FraisDiver findByID(Long id)throws ServiceException ;
    
}
