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
    @NamedQuery(name = "findMatierebyIntitule", query = "select p from Matiere p where p.intitule=:intitule"),
    @NamedQuery(name = "findMatiereByClasseId", query = "select m from Matiere m,MaClaCoef mcc,Classe c where (c.code=:idClasse)AND(mcc.classe.id=c.id)AND(mcc.matiere.id=m.id) ")
})
public class Matiere implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "matiere")
    private List<Notes> note = new ArrayList<Notes>();
    /**
     *
     */
    @OneToMany(mappedBy = "matiere")
    private List<MaClaCoef> maclacoef = new ArrayList<MaClaCoef>();
    @Column(unique = true, nullable = false)
    private String intitule;
    @OneToMany(mappedBy = "matiere")
    private List<EmploiDeTemps> emploiDeTempses = new ArrayList<EmploiDeTemps>();

    public Matiere() {
    }

    public Matiere(String intitule) {

        this.intitule = intitule;

    }

    public List<Notes> getNote() {
        return note;
    }

    public void setNote(List<Notes> note) {
        this.note = note;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<MaClaCoef> getMaclacoef() {
        return maclacoef;
    }

    public void setMaclacoef(List<MaClaCoef> maclacoef) {
        this.maclacoef = maclacoef;
    }

    @Override
    public String toString() {
        return "" + intitule + "";
    }
}
