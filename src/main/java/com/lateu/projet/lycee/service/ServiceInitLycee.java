/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.InitLycee;

/**
 *
 * @author lateu
 */
public interface ServiceInitLycee {
    public void create(InitLycee lycee)throws ServiceException;
}
