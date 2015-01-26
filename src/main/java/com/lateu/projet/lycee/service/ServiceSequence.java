/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Sequence;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public interface ServiceSequence {
    public void create(Sequence s,String codeAnnee)throws ServiceException;
    List<Sequence> findAll()throws ServiceException;
}
