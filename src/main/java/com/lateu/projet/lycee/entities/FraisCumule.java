/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author richardlateu
 */
@Entity
//@NamedQueries({
//    @NamedQuery(name = "findFraisCumule", query = "select fc from FraisCumule fc , FraisDiver fd  join fc.frais fc_fd where fc.id=fc_fd.id AND fd.id=:iden"),
//    
//})
public class FraisCumule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long total;
    @ManyToOne(fetch = FetchType.LAZY)
    private FraisDiver frais;

    public FraisCumule() {
    }

    public FraisCumule(long total, FraisDiver frais) {
        this.total = total;
        this.frais = frais;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public FraisDiver getFrais() {
        return frais;
    }

    public void setFrais(FraisDiver frais) {
        this.frais = frais;
    }
    
    
    public Long getId() {
        return id;
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
        if (!(object instanceof FraisCumule)) {
            return false;
        }
        FraisCumule other = (FraisCumule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lateu.projet.lycee.entities.Historique[ id=" + id + " ]";
    }
    
}
