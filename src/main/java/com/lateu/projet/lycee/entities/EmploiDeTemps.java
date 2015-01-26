/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.entities;

import java.io.Serializable;
import java.util.Date;
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
 * @author ing-lateu
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "ValiderEmploi", query = "select em from EmploiDeTemps em where em.classe.id=:idClasse and em.matiere.id=:idMatiere and em.jour=:jour"),
 })
public class EmploiDeTemps implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jour;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date heureDebut;
    @Temporal(javax.persistence.TemporalType.TIME)
    private Date heureFin;
    //@Column(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Matiere matiere;
    /**
     *
     */
    //@Column(nullable = false)
    @ManyToOne(fetch = FetchType.EAGER)
    private Classe classe;

    public EmploiDeTemps() {
    }

    public Long getId() {
        return id;
    }

    public EmploiDeTemps(String jour, Date heureDebut, Date heureFin, Matiere matiere, Classe classe) {
        this.jour = jour;
        this.heureDebut = heureDebut;
        this.heureFin = heureFin;
        this.matiere = matiere;
        this.classe = classe;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmploiDeTemps)) {
            return false;
        }
        EmploiDeTemps other = (EmploiDeTemps) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lateu.projet.lycee.entities.EmploiDeTemps[ id=" + id + " ]";
    }

    public String getJour() {
        return jour;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public Date getHeureDebut() {
        return heureDebut;
    }

    public void setHeureDebut(Date heureDebut) {
        this.heureDebut = heureDebut;
    }

    public Date getHeureFin() {
        return heureFin;
    }

    public void setHeureFin(Date heureFin) {
        this.heureFin = heureFin;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }
}
