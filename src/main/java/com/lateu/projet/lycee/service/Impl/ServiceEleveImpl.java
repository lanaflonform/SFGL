/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.AnneeScolairedao;
import com.lateu.projet.lycee.dao.Classedao;
import com.lateu.projet.lycee.dao.Elevedao;
import com.lateu.projet.lycee.dao.FraisDiverdao;
import com.lateu.projet.lycee.dao.Nationalitedao;
import com.lateu.projet.lycee.dao.Notedao;
import com.lateu.projet.lycee.dao.Observationdao;
import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.MaClaCoef;
import com.lateu.projet.lycee.entities.Nationalite;
import com.lateu.projet.lycee.projection.PV;
import com.lateu.projet.lycee.projection.ReportEntry;
import com.lateu.projet.lycee.service.ServiceEleve;
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
public class ServiceEleveImpl implements ServiceEleve {

    private Elevedao elevedao;
    private Nationalitedao nationalitedao;
    private Notedao notedao;
    private Classedao classedao;
    private FraisDiverdao fraisdao;
    private Observationdao observatiodao;
    private AnneeScolairedao anneeScoaliredao;

    @Override
    public void create(Eleve eleve, String CodeAnnee, String pays, String classe) throws ServiceException {
        Classe cl = new Classe();
        AnneeScolaire anneeScolaire = new AnneeScolaire();
        Nationalite nationalite = new Nationalite();
        try {
            anneeScolaire = anneeScoaliredao.findByCode(CodeAnnee);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceEleveImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            nationalite = nationalitedao.findNationalitebypays(pays);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceEleveImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            cl = classedao.findClassebyCode(classe);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceEleveImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            eleve.setAnnee(anneeScolaire);
            eleve.setNationalite(nationalite);
            eleve.setClasse(cl);
            elevedao.create(eleve);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceEleveImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Eleve FindByMatricune(String s, AnneeScolaire annee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Eleve> FindByNationnalite(Nationalite n, AnneeScolaire annee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Eleve> FindBySexe(String s, AnneeScolaire annee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int EleveNumber(Classe cl, AnneeScolaire annee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Elevedao getElevedao() {
        return elevedao;
    }

    public void setElevedao(Elevedao elevedao) {
        this.elevedao = elevedao;
    }

    public Nationalitedao getNationalitedao() {
        return nationalitedao;
    }

    public void setNationalitedao(Nationalitedao nationalitedao) {
        this.nationalitedao = nationalitedao;
    }

    public Notedao getNotedao() {
        return notedao;
    }

    public void setNotedao(Notedao notedao) {
        this.notedao = notedao;
    }

    public Classedao getClassedao() {
        return classedao;
    }

    public void setClassedao(Classedao classedao) {
        this.classedao = classedao;
    }

    public FraisDiverdao getFraisdao() {
        return fraisdao;
    }

    public void setFraisdao(FraisDiverdao fraisdao) {
        this.fraisdao = fraisdao;
    }

    public AnneeScolairedao getAnneeScoaliredao() {
        return anneeScoaliredao;
    }

    public void setAnneeScoaliredao(AnneeScolairedao anneeScoaliredao) {
        this.anneeScoaliredao = anneeScoaliredao;
    }

    public Observationdao getObservatiodao() {
        return observatiodao;
    }

    public void setObservatiodao(Observationdao observatiodao) {
        this.observatiodao = observatiodao;
    }

    @Override
    public String LastIndex(List<Eleve> eleves) throws ServiceException {
        int i = eleves.size();
        Eleve e = new Eleve();
        String s = "";
        String index = "";
        int n = 0;
        if (i == 0) {
            return "0001";

        } else {
            e = eleves.get(i - 1);
            s = e.getMatricule();
            s = s.substring(3, 7);
            
            n =Integer.parseInt(s);
           // System.out.println("===================================================================="+n);
            n++;

            if (n < 10) {
                index = "000" + n;
            } else if ((n < 100) && (n >= 10)) {
                index = "00" + n;
            }else if((n>100)&&(n < 1000)){
            
             index="0"+n;
            }else{
            index=""+n;}


            return index;
        }
    }

    @Override
    public List<Eleve> FindAll() throws ServiceException {
        try {
            return elevedao.findAll();
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceEleveImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<ReportEntry> maSectionBulletin(String codeClasse, String level) throws ServiceException {
        try {
            return elevedao.maSectionBulletin(codeClasse, level);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceEleveImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<PV> GeneralPV(String matricule, Long idMatiere) throws ServiceException {
        try {
            return elevedao.GeneralPV(matricule, idMatiere);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public void update(Eleve eleve) throws ServiceException {
        try {
            elevedao.update(eleve);
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceEleveImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

  
}
