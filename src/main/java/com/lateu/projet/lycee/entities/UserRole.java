/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author lateu
 */
@Entity
public class UserRole implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //@Column(unique = true)
    private String statut;

    public UserRole(String Statut, Professeur professeur) {
        this.statut = Statut;
        this.professeur = professeur;
    }
//@Column(unique = true)
     @ManyToOne(fetch = FetchType.EAGER)
    private Professeur professeur;
    public UserRole() {
    }

   
    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String Statut) {
        this.statut = Statut;
    }

    @Override
    public String toString() {
        return "UserRole{" + "id=" + id + ", Statut=" + statut + '}';
    }

    
    
    
    
    
    
}
