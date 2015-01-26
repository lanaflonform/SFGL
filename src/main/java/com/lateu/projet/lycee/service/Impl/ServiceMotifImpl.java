/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.Motifdao;
import com.lateu.projet.lycee.entities.Motif;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceMotif;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lateu
 */
@Transactional
public class ServiceMotifImpl implements ServiceMotif{
private Motifdao motidao;
    @Override
    public void create(Motif m) throws ServiceException {
    try {
        motidao.create(m);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceMotifImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public Motifdao getMotidao() {
        return motidao;
    }

    public void setMotidao(Motifdao motidao) {
        this.motidao = motidao;
    }

    @Override
    public List<Motif> findAll() throws ServiceException {
    try {  
        return motidao.findAll();
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceMotifImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }
      
}
