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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "findAnneeByCode", query = "select p from AnneeScolaire p where p.code=:code"),
    
})
public class AnneeScolaire implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "annee")
    private List<FraisDiver> frais = new ArrayList<FraisDiver>();
// 
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date debut;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fin;
    private String code;

    public AnneeScolaire() {
    }

    public AnneeScolaire(Date debut, Date fin, String code) {
        this.debut = debut;
        this.fin = fin;
        this.code = code;
    }

    public List<FraisDiver> getFrais() {
        return frais;
    }

    public void setFrais(List<FraisDiver> frais) {
        this.frais = frais;
    }

   

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setId(Long id) {
        this.id = id;
    }

  
    @Override
    public String toString() {
        return "AnneeScolaire{" + "id=" + id + ", debut=" + debut + ", fin=" + fin + ", code=" + code + '}';
    }

    
}
