/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.AnneeScolairedao;
import com.lateu.projet.lycee.dao.Sequencedao;
import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Sequence;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceSequence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author richardlateu
 */
@Transactional
public class ServiceSequenceImpl implements ServiceSequence{
private Sequencedao sequencedao;
private AnneeScolairedao anneeScoaliredao;
@Override
    public void create(Sequence s,String codeAnnee) throws ServiceException {

         AnneeScolaire   anneeScolaire=new AnneeScolaire();
    try {
        anneeScolaire=anneeScoaliredao.findByCode(codeAnnee);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceSequenceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    s.setAnnee(anneeScolaire);
    try {
        sequencedao.create(s);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceSequenceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    public Sequencedao getSequencedao() {
        return sequencedao;
    }

    public void setSequencedao(Sequencedao sequencedao) {
        this.sequencedao = sequencedao;
    }

    public AnneeScolairedao getAnneeScoaliredao() {
        return anneeScoaliredao;
    }

    public void setAnneeScoaliredao(AnneeScolairedao anneeScoaliredao) {
        this.anneeScoaliredao = anneeScoaliredao;
    }

    @Override
    public List<Sequence> findAll() throws ServiceException {
    try {
        return sequencedao.findAll();
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceSequenceImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }
    
}
