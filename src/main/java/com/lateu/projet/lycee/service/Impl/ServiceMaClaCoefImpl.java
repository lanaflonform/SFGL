/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.Classedao;
import com.lateu.projet.lycee.dao.MaClaCoefdao;
import com.lateu.projet.lycee.dao.Matieredao;
import com.lateu.projet.lycee.dao.Professeurdao;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.MaClaCoef;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.entities.Professeur;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceMaClaCoef;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author richardlateu
 */
@Transactional
public class ServiceMaClaCoefImpl implements ServiceMaClaCoef {

    private Matieredao matieredao;
    private Classedao classedao;
    private MaClaCoefdao maClaCoefdao;
    private Professeurdao professeurdao;

    @Override
    public void create(MaClaCoef mcf, String matiere, String classe, Long idEn) throws ServiceException {
        
        try {
            Matiere m = new Matiere();
            Classe cl = new Classe();
            Professeur p=new Professeur();
       
                cl = classedao.findClassebyCode(classe);
                m = matieredao.findMatierebyIntitule(matiere);
                p=professeurdao.findById(idEn);
           
            
            mcf.setProfesseur(p);
            mcf.setClasse(cl);
            mcf.setMatiere(m);
         
                maClaCoefdao.create(mcf);
           

        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceMaClaCoefImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
      @Override
    public MaClaCoef getLevelMat(Long idMatiere, Long idClasse) throws ServiceException {
        try {
            return maClaCoefdao.getLevelMatiere(idMatiere,idClasse);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceEleveImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;


    }

    public Matieredao getMatieredao() {
        return matieredao;
    }

    public void setMatieredao(Matieredao matieredao) {
        this.matieredao = matieredao;
    }

    public Classedao getClassedao() {
        return classedao;
    }

    public void setClassedao(Classedao classedao) {
        this.classedao = classedao;
    }

    public MaClaCoefdao getMaClaCoefdao() {
        return maClaCoefdao;
    }

    public void setMaClaCoefdao(MaClaCoefdao maClaCoefdao) {
        this.maClaCoefdao = maClaCoefdao;
    }

    @Override
    public List<MaClaCoef> findAll() throws ServiceException {
        try {
            return maClaCoefdao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceMaClaCoefImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Professeurdao getProfesseurdao() {
        return professeurdao;
    }

    public void setProfesseurdao(Professeurdao professeurdao) {
        this.professeurdao = professeurdao;
    }
}
