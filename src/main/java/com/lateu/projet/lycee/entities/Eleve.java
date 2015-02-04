/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author richardlateu
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findElevebyMatricule", query = "select p from Eleve p where p.matricule=:matricule"),
    @NamedQuery(name = "rechercheMaClasse", query = "select c from Classe c,AnneeScolaire a,Eleve e join e.annee e_a join e.classe e_c where (e.matricule=:matricule)and(a.id=e_a.id)and(c.id=e_c.id)"),
    @NamedQuery(name = "findElevebyNom", query = "select p from Eleve p where p.nom=:nom"),

    @NamedQuery(name = "GeneralPV", query = "select new com.lateu.projet.lycee.projection.PV(n.note,matiere.intitule,matClaCoef,(n.note)*(matClaCoef.coeficient)) from Eleve e,Matiere matiere,Notes n,MaClaCoef matClaCoef join n.eleve nt_el join n.matiere not_mat join matClaCoef.matiere mcc_mat where (e.id=nt_el.id)and(matiere.id=not_mat.id)and(mcc_mat.id=matiere.id)and(matiere.id=:idmat)and(e.matricule=:matricule)"),
    @NamedQuery(name = "SectionBulletin", query = "select new com.lateu.projet.lycee.projection.ReportEntry(mat, mcc, cl) from Matiere mat,MaClaCoef mcc,Classe cl  join mcc.classe mcc_cl join mcc.matiere mcc_mat where(cl.id=mcc_cl.id)and(mcc_mat.id=mat.id)and(cl.code=:codeClasse)and(mcc.levelMatiere=:levelmat)"),
    @NamedQuery(name = "getLevelMatiere", query = "select mcc from Matiere mat,MaClaCoef mcc join mcc.matiere mcc_mat where(mcc_mat.id=mat.id)and(mat.id=:idmat)")
})
public class Eleve extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * rel entre eleve et nationnalite
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Nationalite nationalite;
    /**
     * rel entre eleve et frais
     */
    @OneToMany(mappedBy = "eleve")
    private List<FraisDiver> frais = new ArrayList<FraisDiver>();
    /**
     * rel eleve classe
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Classe classe;
    /**
     *
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private AnneeScolaire annee;
    /**
     *
     */
    @OneToMany(mappedBy = "eleve")
    private List<Notes> note = new ArrayList<Notes>();
    /**
     *
     */
    @OneToMany(mappedBy = "eleve", cascade = {CascadeType.ALL})
    private List<Observation> convocation;
    private String contactPrarent;
    private String nomPere;
    private String nomMere;
    private String quartier;
    private String redoublant;

    public Eleve() {
    }

    public Eleve(Nationalite nationalite, Classe classe, AnneeScolaire annee, List<Observation> convocation, String contactPrarent, String nomPere, String nomMere, String quartier, String redoublant, String nom, String prenom, Date dateNais, String sexe, String matricule, String statut) {
        super(nom, prenom, dateNais, sexe, matricule, statut);
        this.nationalite = nationalite;
        this.classe = classe;
        this.annee = annee;
        this.convocation = convocation;
        this.contactPrarent = contactPrarent;
        this.nomPere = nomPere;
        this.nomMere = nomMere;
        this.quartier = quartier;
        this.redoublant = redoublant;
    }

    public String getRedoublant() {
        return redoublant;
    }

    public void setRedoublant(String redoublant) {
        this.redoublant = redoublant;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Nationalite getNationalite() {
        return nationalite;
    }

    public void setNationalite(Nationalite nationalite) {
        this.nationalite = nationalite;
    }

    public String getContactPrarent() {
        return contactPrarent;
    }

    public void setContactPrarent(String contactPrarent) {
        this.contactPrarent = contactPrarent;
    }

    public List<FraisDiver> getFrais() {
        return frais;
    }

    public void setFrais(List<FraisDiver> frais) {
        this.frais = frais;
    }

    public AnneeScolaire getAnnee() {
        return annee;
    }

    public void setAnnee(AnneeScolaire annee) {
        this.annee = annee;
    }

    public List<Notes> getNote() {
        return note;
    }

    public void setNote(List<Notes> note) {
        this.note = note;
    }

    public String getNomPere() {
        return nomPere;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public String getNomMere() {
        return nomMere;
    }

    public void setNomMere(String nomMere) {
        this.nomMere = nomMere;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public List<Observation> getConvocation() {
        return convocation;
    }

    public void setConvocation(List<Observation> convocation) {
        this.convocation = convocation;
    }

    @Override
    public String toString() {
        return "Eleve{" + "nationalite=" + nationalite +  ", classe=" + classe + ", annee=" + annee +  ", contactPrarent=" + contactPrarent + ", nomPere=" + nomPere + ", nomMere=" + nomMere + ", quartier=" + quartier + ", redoublant=" + redoublant + '}';
    }
    
    
    
    
}
