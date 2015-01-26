/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.InitLyceedao;
import com.lateu.projet.lycee.entities.InitLycee;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceInitLycee;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lateu
 */
@Transactional
public class ServiceInitLyceeImpl implements ServiceInitLycee{
    
    private InitLyceedao lyceedao;

    public InitLyceedao getLyceedao() {
        return lyceedao;
    }

    public void setLyceedao(InitLyceedao lyceedao) {
        this.lyceedao = lyceedao;
    }

    @Override
    public void create(InitLycee lycee) throws ServiceException {
        try {
            lyceedao.create(lycee);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceInitLyceeImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
}
