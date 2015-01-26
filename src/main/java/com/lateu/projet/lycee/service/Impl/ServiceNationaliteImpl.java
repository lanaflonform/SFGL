/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.Nationalitedao;
import com.lateu.projet.lycee.entities.Nationalite;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceNationalite;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author richardlateu
 */
@Transactional
public class ServiceNationaliteImpl implements ServiceNationalite{
private Nationalitedao nationalitedao;
    public void create(Nationalite nat)  {
    try {
        nationalitedao.create(nat);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceNationaliteImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public Nationalitedao getNationalitedao() {
        return nationalitedao;
    }

    public void setNationalitedao(Nationalitedao nationalitedao) {
        this.nationalitedao = nationalitedao;
    }

    @Override
    public List<Nationalite> FindAll() throws ServiceException {
    try {
        return  nationalitedao.findAll();
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceNationaliteImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }

    @Override
    public void update(Nationalite nat) throws ServiceException {
    try {
        nationalitedao.update(nat);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceNationaliteImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    @Override
    public Nationalite FindBypays(String pays) throws ServiceException {
    try {
        return nationalitedao.findNationalitebypays(pays);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceNationaliteImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }
    
}
