/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.projection;

import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.entities.Notes;

/**
 *
 * @author richardlateu
 */
public class PV {
    private Eleve eleve;
    private Notes note;
    private Matiere matiere;
     private Classe classe;
    public PV() {
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public PV(Eleve eleve, Notes note, Matiere matiere, Classe classe) {
        this.eleve = eleve;
        this.note = note;
        this.matiere = matiere;
        this.classe = classe;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

  
    public Eleve getEleve() {
        return eleve;
    }

  
    public void setEleve(Eleve eleve) {
        this.eleve = eleve;
    }

    public Notes getNote() {
        return note;
    }

    public void setNote(Notes note) {
        this.note = note;
    }

    public Classe getClasse() {
        return classe;
    }

    public void setClasse(Classe classe) {
        this.classe = classe;
    }

    @Override
    public String toString() {
        return "EleveNotes{"+"matricule= " +eleve.getMatricule()+ ", nom=" + eleve.getNom() +", prenom= "+eleve.getPrenom()+ ", matiere="+matiere.getIntitule()+", note=" + note.getNote() +'}';
    }

   
    
    
}
