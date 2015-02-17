/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Temporal;

/**
 *
 * @author richardlateu
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;
    @Column(nullable = false)
    private String nom;
    private String prenom;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateNais;
    @Column(nullable = false)
    private String lieuxNais;
    private String sexe;
    @Column(unique = true, nullable = false)
    private String matricule;
    @Column(nullable = false)
    private String statut;

    public Personne() {
    }

    public Personne(String nom, String prenom, Date dateNais, String lieuxNais, String sexe, String matricule, String statut) {
        this.nom = nom;
        this.prenom = prenom;
        this.dateNais = dateNais;
        this.lieuxNais = lieuxNais;
        this.sexe = sexe;
        this.matricule = matricule;
        this.statut = statut;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateNais() {
        return dateNais;
    }

    public void setDateNais(Date dateNais) {
        this.dateNais = dateNais;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLieuxNais() {
        return lieuxNais;
    }

    public void setLieuxNais(String lieuxNais) {
        this.lieuxNais = lieuxNais;
    }
}
