/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.projection;

import com.lateu.projet.lycee.entities.MaClaCoef;

/**
 *
 * @author richardlateu
 */
public class PV {
   // private String eleve;
    private double note;
    private String matiere;
    // private String classe;
     private MaClaCoef maClaCoef;
     private double note_coef;
     
    public PV() {
    }

    public PV(double note, String matiere, MaClaCoef maClaCoef, double note_coef) {
        this.note = note;
        this.matiere = matiere;
        this.maClaCoef = maClaCoef;
        this.note_coef = note_coef;
    }

   

 
    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

   
    public MaClaCoef getMaClaCoef() {
        return maClaCoef;
    }

    public void setMaClaCoef(MaClaCoef maClaCoef) {
        this.maClaCoef = maClaCoef;
    }

    @Override
    public String toString() {
        return "PV{" + "note=" + note + ", matiere=" + matiere + ", maClaCoef=" + maClaCoef + '}';
    }

    public double getNote_coef() {
        return note_coef;
    }

    public void setNote_coef(double note_coef) {
        this.note_coef = note_coef;
    }

    

   
   

   
    
    
}
