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
import javax.persistence.Temporal;

/**
 *
 * @author richardlateu
 */
@Entity
public class Observation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
      @ManyToOne(fetch= FetchType.LAZY)
   //@JoinColumn(name="personnelID",nullable=false)
   private Eleve eleve;
      @Column(length =400,nullable = false)
   private String motif;
    @Temporal(javax.persistence.TemporalType.DATE)
   private Date dateconv;
    @Temporal(javax.persistence.TemporalType.DATE)
   private Date delais;

    public Observation() {
    }

    public Observation(Eleve eleve, String motif, Date dateconv, Date delais) {
        this.eleve = eleve;
        this.motif = motif;
        this.dateconv = dateconv;
        this.delais = delais;
    }
    
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Eleve getEleve() {
        return eleve;
    }

    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Date getDateconv() {
        return dateconv;
    }

    public void setDateconv(Date dateconv) {
        this.dateconv = dateconv;
    }

    public Date getDelais() {
        return delais;
    }

    public void setDelais(Date delais) {
        this.delais = delais;
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
        if (!(object instanceof Observation)) {
            return false;
        }
        Observation other = (Observation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lateu.projet.lycee.entities.Convocation[ id=" + id + " ]";
    }
    
}
