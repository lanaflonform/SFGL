/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
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
    @NamedQuery(name = "findNationalitebyCodepays", query = "select p from Nationalite p where p.code=:pays")
})
public class Nationalite implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "nationalite")
    private List<Eleve> eleve = new ArrayList<Eleve>();
    // private Personne personne;
    @Column(unique = true, nullable = false)
    private String pays;
    @Column(unique = true, nullable = false)
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Nationalite() {
    }

    public Nationalite(String pays, String code) {
        this.pays = pays;
        this.code = code;
    }

    public List<Eleve> getEleve() {
        return eleve;
    }

    public void setEleve(List<Eleve> eleve) {
        this.eleve = eleve;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
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
        if (!(object instanceof Nationalite)) {
            return false;
        }
        Nationalite other = (Nationalite) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Nationalite{" + "id=" + id + ", pays=" + pays + ", code=" + code + '}';
    }
}
