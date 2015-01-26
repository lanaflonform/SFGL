/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.Nationalite;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public interface ServiceNationalite {

    public void create(Nationalite nat) throws ServiceException;

    public List<Nationalite> FindAll() throws ServiceException;

    public Nationalite FindBypays(String pays) throws ServiceException;

    public void update(Nationalite nat) throws ServiceException;
}
