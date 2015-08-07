/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.Matieredao;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceMatiere;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author richardlateu
 */
@Transactional
public class ServiceMatiereImpl implements ServiceMatiere{
    private Matieredao matieredao;

    @Override
     public void create(Matiere matiere) throws ServiceException {
        try {
            matieredao.create(matiere);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceMatiereImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Matieredao getMatieredao() {
        return matieredao;
    }

    public void setMatieredao(Matieredao matieredao) {
        this.matieredao = matieredao;
    }

    @Override
    public List<Matiere> findAll() throws ServiceException {
        try {
            return matieredao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceMatiereImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
           }

    @Override
    public Matiere findById(Long id) throws ServiceException{
        try {
            return  matieredao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceMatiereImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Matiere> findMatiereByClasseCode(String id) throws ServiceException {
        try {
            return matieredao.findMatiereByClasseCode(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceMatiereImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
    
    
    
}
