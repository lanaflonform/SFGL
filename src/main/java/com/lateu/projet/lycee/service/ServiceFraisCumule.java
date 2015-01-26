/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.FraisCumule;
import com.lateu.projet.lycee.entities.FraisDiver;
import java.util.List;

/**
 *
 * @author lateu
 */
public interface ServiceFraisCumule {
  // pu FraisCumule
    public List<FraisCumule> findFraisCumule(Long iden) throws ServiceException;
    public void create(FraisCumule fc, FraisDiver fd)throws ServiceException;
    
}
