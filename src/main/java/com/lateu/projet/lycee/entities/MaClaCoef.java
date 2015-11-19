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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author richardlateu
 */
@Entity
@NamedQueries({
  @NamedQuery(name = "getLevelMatiere", query = "select mcc from Matiere mat,MaClaCoef mcc, Classe c join mcc.matiere mcc_mat where(mcc_mat.id=mat.id)and(mat.id=:idmat)and(mcc.classe.id=:idClasse)")

})
public class MaClaCoef implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     *
     */
    
    @ManyToOne(fetch = FetchType.EAGER)
    private Matiere matiere;
    /**
     *
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Professeur professeur;
    @ManyToOne(fetch = FetchType.EAGER)
    private Classe classe;
    private int coeficient;
    private int quotahoraire;
    @Column(nullable = false)
    private String levelMatiere;

    public String getLevelMatiere() {
        return levelMatiere;
    }

    public MaClaCoef(Matiere matiere, Professeur professeur, Classe classe, int coeficient, int quotahoraire, String levelMatiere) {
        this.matiere = matiere;
        this.professeur = professeur;
        this.classe = classe;
        this.coeficient = coeficient;
        this.quotahoraire = quotahoraire;
        this.levelMatiere = levelMatiere;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

   

    public void setLevelMatiere(String levelMatiere) {
        this.levelMatiere = levelMatiere;
    }

    public int getCoeficient() {
        return coeficient;
    }

    public void setCoeficient(int coeficient) {
        this.coeficient = coeficient;
    }

    public int getQuotahoraire() {
        return quotahoraire;
    }

    public void setQuotahoraire(int quotahoraire) {
        this.quotahoraire = quotahoraire;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public MaClaCoef() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    @Override
    public String toString() {
        return "MaClaCoef{" + "id=" + id + ", matiere=" + matiere + ", professeur=" + professeur + ", classe=" + classe + ", coeficient=" + coeficient + ", quotahoraire=" + quotahoraire + ", levelMatiere=" + levelMatiere + '}';
    }

   
}
