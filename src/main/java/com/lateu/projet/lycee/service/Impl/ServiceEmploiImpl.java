/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.Classedao;
import com.lateu.projet.lycee.dao.EmploiDeTempsdao;
import com.lateu.projet.lycee.dao.Matieredao;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.EmploiDeTemps;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.service.ServiceEmploi;
import com.lateu.projet.lycee.service.ServiceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ing-lateu
 */
@Transactional
public class ServiceEmploiImpl  implements ServiceEmploi{
    private EmploiDeTempsdao emploiDeTempsdao;
    private Classedao classedao;
    private Matieredao matieredao;

    public EmploiDeTempsdao getEmploiDeTempsdao() {
        return emploiDeTempsdao;
    }

    public void setEmploiDeTempsdao(EmploiDeTempsdao emploiDeTempsdao) {
        this.emploiDeTempsdao = emploiDeTempsdao;
    }

    public Classedao getClassedao() {
        return classedao;
    }

    public void setClassedao(Classedao classedao) {
        this.classedao = classedao;
    }

    public Matieredao getMatieredao() {
        return matieredao;
    }

    public void setMatieredao(Matieredao matieredao) {
        this.matieredao = matieredao;
    }

    @Override
    public void SaveEmploi(EmploiDeTemps e, Classe cl, Matiere m) throws ServiceException {
        try {
            e.setClasse(cl);
            e.setMatiere(m);
            emploiDeTempsdao.create(e);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceEmploiImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }

    @Override
    public List<EmploiDeTemps> findAll() throws ServiceException {
        try {
            return emploiDeTempsdao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceEmploiImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }

    @Override
    public int Valider(EmploiDeTemps e, Classe cl, Matiere mat) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmploiDeTemps> findForClasse(Long idClasse) throws ServiceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<EmploiDeTemps> Valider(Long idClassse, Long idMatiere, String jour) throws ServiceException {
        try {
            return emploiDeTempsdao.ValiderEmplo(idClassse, idMatiere, jour);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceEmploiImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    
    }
    
 
}
