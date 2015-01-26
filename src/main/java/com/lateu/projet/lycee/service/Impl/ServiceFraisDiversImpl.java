/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.AnneeScolairedao;
import com.lateu.projet.lycee.dao.Elevedao;
import com.lateu.projet.lycee.dao.FraisCumuledao;
import com.lateu.projet.lycee.dao.FraisDiverdao;
import com.lateu.projet.lycee.dao.Motifdao;
import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.FraisCumule;
import com.lateu.projet.lycee.entities.FraisDiver;
import com.lateu.projet.lycee.entities.Motif;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceFraisDivers;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lateu
 */
@Transactional
public class ServiceFraisDiversImpl implements ServiceFraisDivers {

    private FraisDiverdao fraisDiverdao;
    private Elevedao elevedao;
    private AnneeScolairedao anneeScolairedao;
    private Motifdao motifdao;
    private FraisCumuledao fraisCumuledao;

    @Override
    public void creer(FraisDiver f, String codeAnnee, String matEleve, String nomMotif) throws ServiceException {
        AnneeScolaire a = new AnneeScolaire();
        Eleve e = new Eleve();
        Motif m = new Motif();
        try {
            a = anneeScolairedao.findByCode(codeAnnee);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceFraisDiversImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            e = elevedao.findElevebyMatricule(matEleve);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceFraisDiversImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            m = motifdao.findMotifbylibele(nomMotif);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceFraisDiversImpl.class.getName()).log(Level.SEVERE, null, ex);
        }


        List<FraisCumule> old =  fraisDiverdao.findCumule(f.getId());
        int s=old.size();
        if (s!=0) {
            FraisCumule tmp=new FraisCumule();
            for (FraisCumule fraisCumule : old) {
                if(fraisCumule!=null){
                tmp=fraisCumule;
                }
            }
            try {
                Long t = 0L;
                t = tmp.getTotal() + f.getMontant();
                tmp.setTotal(t);
                fraisCumuledao.update(tmp);

                f.setAnnee(a);
                f.setEleve(e);
                f.setMotif(m);
                fraisDiverdao.create(f);
            } catch (DataAccessException ex) {
                Logger.getLogger(ServiceFraisDiversImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println("========================present");
            
        } else {
            try {
                f.setAnnee(a);
                f.setEleve(e);
                f.setMotif(m);
                fraisDiverdao.create(f);
            } catch (DataAccessException ex) {
                Logger.getLogger(ServiceFraisDiversImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             System.out.println("========================absent");
        }

    }

    public Motifdao getMotifdao() {
        return motifdao;
    }

    public void setMotifdao(Motifdao motifdao) {
        this.motifdao = motifdao;
    }

    @Override
    public List<FraisDiver> findAll() throws ServiceException {
        try {
            return fraisDiverdao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceFraisDiversImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public FraisDiverdao getFraisDiverdao() {
        return fraisDiverdao;
    }

    public void setFraisDiverdao(FraisDiverdao fraisDiverdao) {
        this.fraisDiverdao = fraisDiverdao;
    }

    public Elevedao getElevedao() {
        return elevedao;
    }

    public void setElevedao(Elevedao elevedao) {
        this.elevedao = elevedao;
    }

    public FraisCumuledao getFraisCumuledao() {
        return fraisCumuledao;
    }

    public void setFraisCumuledao(FraisCumuledao fraisCumuledao) {
        this.fraisCumuledao = fraisCumuledao;
    }

    public AnneeScolairedao getAnneeScolairedao() {
        return anneeScolairedao;
    }

    public void setAnneeScolairedao(AnneeScolairedao anneeScolairedao) {
        this.anneeScolairedao = anneeScolairedao;
    }

    @Override
    public FraisDiver findByID(Long id) throws ServiceException {
        try {
            return fraisDiverdao.findById(id);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceFraisDiversImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    
    
    
}
