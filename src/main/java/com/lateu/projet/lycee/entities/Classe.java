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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    @NamedQuery(name = "findClasebylibele", query = "select p from Classe p where p.libele=:libele"),
    @NamedQuery(name = "findClasebycode", query = "select p from Classe p where p.code=:code"),
      @NamedQuery(name = "findByNiveau", query = "select cl from Classe cl where(cl.classeLevel.id=:idNiveau)"),
  //  @NamedQuery(name = "MatiereValide", query = "select c  from Classe c,MaClaCoef mcc, Matiere m join c.maclacoef c_mcc join m.maclacoef m_mcc where (m.intitule=:matiere)and(c.libele=:classe)and(c.id=c_mcc.id)and(mcc.classe=mcc.matiere)"),
     @NamedQuery(name = "findByClasseAY", query = "select e  from Classe c,Eleve e, AnneeScolaire an join e.classe e_cc join e.annee e_an where (c.id=e_cc.id)and(an.id=e_an.id)and(c.id=:idClasse)and(an.code=:codeAnnee)"),  

})
public class Classe implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy ="classe")
    private List<MaClaCoef> maclacoef=new ArrayList<MaClaCoef>();
    
    @OneToMany(mappedBy ="classe")
    private List<EmploiDeTemps> emploiDeTempses=new ArrayList<EmploiDeTemps>();
    
   @ManyToOne(fetch = FetchType.EAGER)
    private ClasseLevel classeLevel;
   
   @Column(unique = true,nullable = false)
    private String libele;
    @Column(unique = true,nullable = false)
    private String code;
//    private Professeurs titulaire;
    
    
    public Classe() {
    }
    
    public Classe(String libele) {
        this.libele = libele;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<MaClaCoef> getMaclacoef() {
        return maclacoef;
    }

    public void setMaclacoef(List<MaClaCoef> maclacoef) {
        this.maclacoef = maclacoef;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public Classe(Long id, String libele) {
        this.id = id;
        this.libele = libele;
    }

    public List<EmploiDeTemps> getEmploiDeTempses() {
        return emploiDeTempses;
    }

    public void setEmploiDeTempses(List<EmploiDeTemps> emploiDeTempses) {
        this.emploiDeTempses = emploiDeTempses;
    }

    @Override
    public String toString() {
        return "Classe{" + "id=" + id + ", libele=" + libele + '}';
    }

    public ClasseLevel getClasseLevel() {
        return classeLevel;
    }

    public void setClasseLevel(ClasseLevel classeLevel) {
        this.classeLevel = classeLevel;
    }

    
    
}
