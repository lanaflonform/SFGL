/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.AnneeScolairedao;
import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.service.ServiceAnneeScolaire;
import com.lateu.projet.lycee.service.ServiceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author richardlateu
 */
@Transactional
public class ServiceAnneeScolaireImpl implements ServiceAnneeScolaire{
    private AnneeScolairedao anneeScolairedao;
    @Override
 public void create(AnneeScolaire a) throws ServiceException {
        try {
            anneeScolairedao.create(a);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceAnneeScolaireImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    @Override
  public AnneeScolaire finAnneeScolairebyID(Long id) throws ServiceException {
        try {
         return   anneeScolairedao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceAnneeScolaireImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

 
 
    public AnneeScolairedao getAnneeScolairedao() {
        return anneeScolairedao;
    }

    public void setAnneeScolairedao(AnneeScolairedao anneeScolairedao) {
        this.anneeScolairedao = anneeScolairedao;
    }

    @Override
    public List<AnneeScolaire> findAll() throws ServiceException {
        try {
            return anneeScolairedao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceAnneeScolaireImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

   
   
    
    
    
}
