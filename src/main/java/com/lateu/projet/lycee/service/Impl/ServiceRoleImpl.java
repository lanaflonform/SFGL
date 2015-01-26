/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.lateu.projet.lycee.dao.Professeurdao;
import com.lateu.projet.lycee.dao.roledao;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lateu
 */
@Transactional
public class ServiceRoleImpl {
    private Professeurdao professeurdao;
    private roledao rldao;

    public Professeurdao getProfesseurdao() {
        return professeurdao;
    }

    public void setProfesseurdao(Professeurdao professeurdao) {
        this.professeurdao = professeurdao;
    }

    public roledao getRldao() {
        return rldao;
    }

    public void setRldao(roledao rldao) {
        this.rldao = rldao;
    }
    
    
    
    
}
