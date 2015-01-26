/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.projection;

import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.MaClaCoef;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.entities.Professeur;

/**
 *
 * @author richardlateu
 */
public class ReportEntry {
    // private Professeur professeur;
 //  private  double note;
    private Matiere matiere;
    private MaClaCoef matClaCoef;
   // private Long coef; 
   private Classe classe;
     //double moyenne;
    public ReportEntry() {
    }

    public ReportEntry(/*Professeur professeur,*/ Matiere matiere, MaClaCoef matClaCoef, Classe classe) {
       // this.professeur = professeur;
        this.matiere = matiere;
        this.matClaCoef = matClaCoef;
        this.classe = classe;
    }

   

   

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public MaClaCoef getMatClaCoef() {
        return matClaCoef;
    }

    public void setMatClaCoef(MaClaCoef matClaCoef) {
        this.matClaCoef = matClaCoef;
    }

    @Override
    public String toString() {
        return "ReportEntry{" + "matiere=" + matiere + ", matClaCoef=" + matClaCoef + '}';
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

  
 
}
