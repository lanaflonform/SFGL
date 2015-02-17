/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;

/**
 *
 * @author richardlateu
 */
@Entity

@NamedQueries({
   @NamedQuery(name = "findFraisCumule", query = "select fc from FraisCumule fc , FraisDiver fd  join fc.frais fc_fd where fc.id=fc_fd.id AND fd.id=:iden"),
    
})
public class FraisDiver implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    /**
     *
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Eleve eleve;
    
    @ManyToOne(fetch = FetchType.EAGER)
    private AnneeScolaire annee;
    /**
     *
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Motif motif;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateVersement;
    @Column(unique = true, nullable = false)
    private String libele;
    @Column(unique = true, nullable = false)
    private Long montant;

    public FraisDiver(Eleve eleve, AnneeScolaire annee, Motif motif, Date dateVersement, String libele, Long montant) {
        this.eleve = eleve;
        this.annee = annee;
        this.motif = motif;
        this.dateVersement = dateVersement;
        this.libele = libele;
        this.montant = montant;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Date getDateVersement() {
        return dateVersement;
    }

    public void setDateVersement(Date dateVersement) {
        this.dateVersement = dateVersement;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public Long getMontant() {
        return montant;
    }

    public void setMontant(Long montant) {
        this.montant = montant;
    }

    public FraisDiver() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Motif getMotif() {
        return motif;
    }

    public void setMotif(Motif motif) {
        this.motif = motif;
    }

    public AnneeScolaire getAnnee() {
        return annee;
    }

    public void setAnnee(AnneeScolaire annee) {
        this.annee = annee;
    }

 
}
