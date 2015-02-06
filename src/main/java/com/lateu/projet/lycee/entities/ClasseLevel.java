/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.entities;

import com.lateu.projet.lycee.Enum.Cycle;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author ing-lateu
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "findbyCycleId", query = "select p from ClasseLevel p where p.cycleEtude=:idCycle")
})
public class ClasseLevel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String niveau;
    @OneToMany(mappedBy = "classeLevel")
    private List<Classe> classes = new ArrayList<Classe>();
    private Cycle cycleEtude;

    public ClasseLevel() {
    }

    public ClasseLevel(String niveau, Cycle cycleEtude) {
        this.niveau = niveau;
        this.cycleEtude = cycleEtude;
    }

    public ClasseLevel(String niveau) {
        this.niveau = niveau;
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
        if (!(object instanceof ClasseLevel)) {
            return false;
        }
        ClasseLevel other = (ClasseLevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

 
    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public List<Classe> getClasses() {
        return classes;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public Cycle getCycleEtude() {
        return cycleEtude;
    }

    public void setCycleEtude(Cycle cycleEtude) {
        this.cycleEtude = cycleEtude;
    }

    @Override
    public String toString() {
        return "ClasseLevel{" + "id=" + id + ", niveau=" + niveau + ", cycleEtude=" + cycleEtude + '}';
    }
    
    
    
}
