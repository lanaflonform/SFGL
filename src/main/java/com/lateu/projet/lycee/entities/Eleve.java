/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @NamedQuery(name = "findElevebyMatricule", query = "select p from Eleve p where p.matricule=:matricule"),
    @NamedQuery(name = "rechercheMaClasse", query = "select c from Classe c,AnneeScolaire a,Eleve e join e.annee e_a join e.classe e_c where (e.matricule=:matricule)and(a.id=e_a.id)and(c.id=e_c.id)"),
    @NamedQuery(name = "findElevebyNom", query = "select p from Eleve p where p.nom=:nom"),
    @NamedQuery(name = "GeneralPV", query = "select new com.lateu.projet.lycee.projection.PV(n,matiere.intitule,matClaCoef,(n.note)*(matClaCoef.coeficient)) from Eleve e,Matiere matiere,Notes n,MaClaCoef matClaCoef join n.eleve nt_el join n.matiere not_mat join matClaCoef.matiere mcc_mat where (e.id=nt_el.id)and(matiere.id=not_mat.id)and(mcc_mat.id=matiere.id)and(matiere.id=:idmat)and(e.matricule=:matricule)"),
    @NamedQuery(name = "SectionBulletin", query = "select new com.lateu.projet.lycee.projection.ReportEntry(mat, mcc, cl) from Matiere mat,MaClaCoef mcc,Classe cl  join mcc.classe mcc_cl join mcc.matiere mcc_mat where(cl.id=mcc_cl.id)and(mcc_mat.id=mat.id)and(cl.code=:codeClasse)and(mcc.levelMatiere=:levelmat)"),})
public class Eleve extends Personne implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * rel entre eleve et nationnalite
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Nationalite nationalite;
    /**
     * rel entre eleve et frais
     */
    @OneToMany(mappedBy = "eleve")
    private List<FraisDiver> frais = new ArrayList<FraisDiver>();
    /**
     * rel eleve classe
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Classe classe;
    /**
     *
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private AnneeScolaire annee;
    /**
     *
     */
    @OneToMany(mappedBy = "eleve")
    private List<Notes> note = new ArrayList<Notes>();
    /**
     *
     */
    @OneToMany(mappedBy = "eleve", cascade = {CascadeType.ALL})
    private List<Observation> convocation;
    private String contactPrarent;
    private String nomPere;
    private String quartier;
    private String redoublant;
    @Column(nullable = true)
    private double moyenneT1;
    @Column(nullable = true)
    private double moyenneT2;
    @Column(nullable = true)
    private double moyenneT3;
    @Column(nullable = true)
    private double moyenneS1;
    @Column(nullable = true)
    private double moyenneS2;
    @Column(nullable = true)
    private double moyenneS3;
    @Column(nullable = true)
    private double moyenneS4;
    @Column(nullable = true)
    private double moyenneS5;
    @Column(nullable = true)
    private double moyenneS6;

    public Eleve() {
    }

    public Eleve(Nationalite nationalite, Classe classe, AnneeScolaire annee, String contactPrarent, String nomPere, String quartier, String redoublant, double moyenneT1, double moyenneT2, double moyenneT3, double moyenneS1, double moyenneS2, double moyenneS3, double moyenneS4, double moyenneS5, double moyenneS6, String nom, String prenom, Date dateNais, String lieuxNais, String sexe, String matricule) {
        super(nom, prenom, dateNais, lieuxNais, sexe, matricule);
        this.nationalite = nationalite;
        this.classe = classe;
        this.annee = annee;
        this.contactPrarent = contactPrarent;
        this.nomPere = nomPere;
        this.quartier = quartier;
        this.redoublant = redoublant;
        this.moyenneT1 = moyenneT1;
        this.moyenneT2 = moyenneT2;
        this.moyenneT3 = moyenneT3;
        this.moyenneS1 = moyenneS1;
        this.moyenneS2 = moyenneS2;
        this.moyenneS3 = moyenneS3;
        this.moyenneS4 = moyenneS4;
        this.moyenneS5 = moyenneS5;
        this.moyenneS6 = moyenneS6;
    }


    public static Comparator<Eleve> ComparatorMoyS1 = new Comparator<Eleve>() {
      
        @Override
        public int compare(Eleve e1, Eleve e2) {
          double  moy1=e1.getMoyenneS1();
           double  moy2=e2.getMoyenneS1();
            return moy1 > moy2 ? -1
                    : moy1 < moy2 ? 1
                    : 0;
        }
    };
    
     public static Comparator<Eleve> ComparatorMoyS2 = new Comparator<Eleve>() {
      
        @Override
        public int compare(Eleve e1, Eleve e2) {
          double  moy1=e1.getMoyenneS2();
           double  moy2=e2.getMoyenneS2();
            return moy1 > moy2 ? -1
                    : moy1 < moy2 ? 1
                    : 0;
        }
    };
      public static Comparator<Eleve> ComparatorMoyS3 = new Comparator<Eleve>() {
      
        @Override
        public int compare(Eleve e1, Eleve e2) {
          double  moy1=e1.getMoyenneS3();
           double  moy2=e2.getMoyenneS3();
            return moy1 > moy2 ? -1
                    : moy1 < moy2 ? 1
                    : 0;
        }
    };
       public static Comparator<Eleve> ComparatorMoyS4 = new Comparator<Eleve>() {
      
        @Override
        public int compare(Eleve e1, Eleve e2) {
          double  moy1=e1.getMoyenneS4();
           double  moy2=e2.getMoyenneS4();
            return moy1 > moy2 ? -1
                    : moy1 < moy2 ? 1
                    : 0;
        }
    };
    
 public static Comparator<Eleve> ComparatorMoyS5 = new Comparator<Eleve>() {
      
        @Override
        public int compare(Eleve e1, Eleve e2) {
          double  moy1=e1.getMoyenneS5();
           double  moy2=e2.getMoyenneS5();
            return moy1 > moy2 ? -1
                    : moy1 < moy2 ? 1
                    : 0;
        }
    };
 
  public static Comparator<Eleve> ComparatorMoyS6 = new Comparator<Eleve>() {
      
        @Override
        public int compare(Eleve e1, Eleve e2) {
          double  moy1=e1.getMoyenneS6();
           double  moy2=e2.getMoyenneS6();
            return moy1 > moy2 ? -1
                    : moy1 < moy2 ? 1
                    : 0;
        }
    };
  
   public static Comparator<Eleve> ComparatorMoyT1 = new Comparator<Eleve>() {
      
        @Override
        public int compare(Eleve e1, Eleve e2) {
          double  moy1=e1.getMoyenneT1();
           double  moy2=e2.getMoyenneT1();
            return moy1 > moy2 ? -1
                    : moy1 < moy2 ? 1
                    : 0;
        }
    };
  
  
  public static Comparator<Eleve> ComparatorMoyT2 = new Comparator<Eleve>() {
      
        @Override
        public int compare(Eleve e1, Eleve e2) {
          double  moy1=e1.getMoyenneT2();
           double  moy2=e2.getMoyenneT2();
            return moy1 > moy2 ? -1
                    : moy1 < moy2 ? 1
                    : 0;
        }
    };
  
  public static Comparator<Eleve> ComparatorMoyT3 = new Comparator<Eleve>() {
      
        @Override
        public int compare(Eleve e1, Eleve e2) {
          double  moy1=e1.getMoyenneT3();
           double  moy2=e2.getMoyenneT3();
            return moy1 > moy2 ? -1
                    : moy1 < moy2 ? 1
                    : 0;
        }
    };
  
    public String getRedoublant() {
        return redoublant;
    }

    public void setRedoublant(String redoublant) {
        this.redoublant = redoublant;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    public Nationalite getNationalite() {
        return nationalite;
    }

    public void setNationalite(Nationalite nationalite) {
        this.nationalite = nationalite;
    }

    public String getContactPrarent() {
        return contactPrarent;
    }

    public void setContactPrarent(String contactPrarent) {
        this.contactPrarent = contactPrarent;
    }

    public List<FraisDiver> getFrais() {
        return frais;
    }

    public void setFrais(List<FraisDiver> frais) {
        this.frais = frais;
    }

    public AnneeScolaire getAnnee() {
        return annee;
    }

    public void setAnnee(AnneeScolaire annee) {
        this.annee = annee;
    }

    public List<Notes> getNote() {
        return note;
    }

    public void setNote(List<Notes> note) {
        this.note = note;
    }

    public String getNomPere() {
        return nomPere;
    }

    public void setNomPere(String nomPere) {
        this.nomPere = nomPere;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public List<Observation> getConvocation() {
        return convocation;
    }

    public void setConvocation(List<Observation> convocation) {
        this.convocation = convocation;
    }

    public double getMoyenneT1() {
        return moyenneT1;
    }

    public void setMoyenneT1(double moyenneT1) {
        this.moyenneT1 = moyenneT1;
    }

    public double getMoyenneT2() {
        return moyenneT2;
    }

    public void setMoyenneT2(double moyenneT2) {
        this.moyenneT2 = moyenneT2;
    }

    public double getMoyenneT3() {
        return moyenneT3;
    }

    public void setMoyenneT3(double moyenneT3) {
        this.moyenneT3 = moyenneT3;
    }

    public double getMoyenneS1() {
        return moyenneS1;
    }

    public void setMoyenneS1(double moyenneS1) {
        this.moyenneS1 = moyenneS1;
    }

    public double getMoyenneS2() {
        return moyenneS2;
    }

    public void setMoyenneS2(double moyenneS2) {
        this.moyenneS2 = moyenneS2;
    }

    public double getMoyenneS3() {
        return moyenneS3;
    }

    public void setMoyenneS3(double moyenneS3) {
        this.moyenneS3 = moyenneS3;
    }

    public double getMoyenneS4() {
        return moyenneS4;
    }

    public void setMoyenneS4(double moyenneS4) {
        this.moyenneS4 = moyenneS4;
    }

    public double getMoyenneS5() {
        return moyenneS5;
    }

    public void setMoyenneS5(double moyenneS5) {
        this.moyenneS5 = moyenneS5;
    }

    public double getMoyenneS6() {
        return moyenneS6;
    }

    public void setMoyenneS6(double moyenneS6) {
        this.moyenneS6 = moyenneS6;
    }
}
