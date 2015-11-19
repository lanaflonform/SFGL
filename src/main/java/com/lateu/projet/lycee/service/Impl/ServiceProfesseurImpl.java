/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.Professeurdao;
import com.lateu.projet.lycee.dao.roledao;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.Professeur;
import com.lateu.projet.lycee.entities.UserRole;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceProfesseur;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lateu
 */
@Transactional
public class ServiceProfesseurImpl implements ServiceProfesseur{
private Professeurdao professeurdao;
private roledao rldao;
    @Override
    public void create(Professeur p, UserRole role) throws ServiceException {
    try {
        professeurdao.create(p);
        rldao.create(role);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceProfesseurImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public Professeurdao getProfesseurdao() {
        return professeurdao;
    }

    public void setProfesseurdao(Professeurdao professeurdao) {
        this.professeurdao = professeurdao;
    }

    @Override
    public List<Professeur> findAll() throws ServiceException {
    try {
        return professeurdao.findAll();
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceProfesseurImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }

    @Override
    public String LastIndex(List<Professeur> professeurs) throws ServiceException {
 int i = professeurs.size();
        Professeur p = new Professeur();
        String s = "";
        String index = "";
        int n = 0;
        if (i == 0) {
            return "001";

        } else {
            p = professeurs.get(i - 1);
            s = p.getMatricule();
            s = s.substring(3, 7);
            
            n =Integer.parseInt(s);
            n++;

            if (n < 10) {
                index = "00" + n;
            } else if ((n < 100) && (n >= 10)) {
                index = "0" + n;
            }else{
            index=""+n;}


            return index;
        }
    }

    public roledao getRldao() {
        return rldao;
    }

    public void setRldao(roledao rldao) {
        this.rldao = rldao;
    }
    
    
    
    
    
}
