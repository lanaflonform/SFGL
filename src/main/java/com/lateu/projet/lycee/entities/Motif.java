/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.entities;
import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author richardlateu
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findMotifbylibele", query = "select p from Motif p where p.libele=:libele")
})
public class Motif implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   @OneToMany(mappedBy ="motif")
    private List<FraisDiver> frais=new ArrayList<FraisDiver>();

    public Motif() {
    }

    public Motif(String libele, Long montant) {
        this.libele = libele;
        this.montant = montant;
    }
   
    
    private String libele;
    private  Long montant; 

    public List<FraisDiver> getFrais() {
        return frais;
    }

    public void setFrais(List<FraisDiver> frais) {
        this.frais = frais;
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
        if (!(object instanceof Motif)) {
            return false;
        }
        Motif other = (Motif) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.lateu.projet.lycee.entities.Motif[ id=" + id + " ]";
    }
    
}
