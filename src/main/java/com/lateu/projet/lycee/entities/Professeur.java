/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author richardlateu
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findprofbyMat", query = "select p from Professeur p where p.matricule=:matricule"),
  })
public class Professeur extends Personne implements Serializable {
    private static final long serialVersionUID = 1L;
    
   @OneToMany(mappedBy ="professeur")
   private List<MaClaCoef> maClaCoefs=new ArrayList<MaClaCoef>();
   /**
    * 
    */
  
   
   @OneToMany(mappedBy ="professeur")
   private List<UserRole> userRoles=new ArrayList<UserRole>();
   
   
   
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date datePriseService;
    private String specialite;
    private String diplome;
    private String username;
    private String password;
    private String contact;
    private String titulaire;
    private String etatCompte;
    public Professeur() {
    }

    public Professeur(Date datePriseService, String specialite, String diplome, String username, String password, String contact, String titulaire, String etatCompte, String nom, String prenom, Date dateNais, String sexe, String matricule, String statut) {
        super(nom, prenom, dateNais, sexe, matricule, statut);
        this.datePriseService = datePriseService;
        this.specialite = specialite;
        this.diplome = diplome;
        this.username = username;
        this.password = password;
        this.contact = contact;
        this.titulaire = titulaire;
        this.etatCompte = etatCompte;
    }

    public List<MaClaCoef> getMaClaCoefs() {
        return maClaCoefs;
    }

    public void setMaClaCoefs(List<MaClaCoef> maClaCoefs) {
        this.maClaCoefs = maClaCoefs;
    }

    public List<UserRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserRole> userRoles) {
        this.userRoles = userRoles;
    }


    public String getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(String titulaire) {
        this.titulaire = titulaire;
    }

   
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

   
   
    
    public Date getDatePriseService() {
        return datePriseService;
    }

    public void setDatePriseService(Date datePriseService) {
        this.datePriseService = datePriseService;
    }

      public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getDiplome() {
        return diplome;
    }

    public void setDiplome(String diplome) {
        this.diplome = diplome;
    }

  
   

    public String getEtatCompte() {
        return etatCompte;
    }

    public void setEtatCompte(String etatCompte) {
        this.etatCompte = etatCompte;
    }

    @Override
    public String toString() {
        return "Professeur{" + "datePriseService=" + datePriseService + ", specialite=" + specialite + ", diplome=" + diplome + ", username=" + username + ", password=" + password + ", contact=" + contact + ", titulaire=" + titulaire + ", etatCompte=" + etatCompte + '}';
    }

    
    
    
    
    
    
    
   
   
}
