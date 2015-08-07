/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.entities.Notes;
import com.lateu.projet.lycee.entities.Sequence;
import com.lateu.projet.lycee.service.ServiceAnneeScolaire;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceEleve;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceMatiere;
import com.lateu.projet.lycee.service.ServiceNote;
import com.lateu.projet.lycee.service.ServiceSequence;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author lateu
 */
@ManagedBean
//@RequestScoped
@ViewScoped
public class Notebean implements Serializable{

    @ManagedProperty(value = "#{ServiceNote}")
    private ServiceNote serviceNote;
    @ManagedProperty(value = "#{ServiceEleve}")
    private ServiceEleve serviceEleve;
    @ManagedProperty(value = "#{ServiceAnneeScolaire}")
    private ServiceAnneeScolaire serviceAnneeScolaire;
    @ManagedProperty(value = "#{ServiceSequence}")
    private ServiceSequence serviceSequence;
    @ManagedProperty(value = "#{ServiceClasse}")
    private ServiceClasse serviceClasse;
    @ManagedProperty(value = "#{ServiceMatiere}")
    private ServiceMatiere serviceMatiere;
    private List<Matiere> matieres;
    private List<Sequence> sequences;
    private AnneeScolaire anneeScolaireSelected;
    private List<Eleve> eleves;
    private List<Classe> classes;
    private List<Notes> notes;
    private List<AnneeScolaire> anneeScolaires;
    private Long idSecquence;
    private Long idMatiere;
    private Long idClasse;
    private String matricule;
    private Notes noteSelected = new Notes();

    public Notebean() {
    }

    
    public void saveNote(){
    
    
    };
    public List<Eleve> getEleves() throws ServiceException {
        return eleves = serviceEleve.FindAll();
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }

    public List<AnneeScolaire> getAnneeScolaires() throws ServiceException {
        return anneeScolaires = serviceAnneeScolaire.findAll();
    }

    public void setAnneeScolaires(List<AnneeScolaire> anneeScolaires) {
        this.anneeScolaires = anneeScolaires;
    }

    public ServiceNote getServiceNote() {
        return serviceNote;
    }

    public void setServiceNote(ServiceNote serviceNote) {
        this.serviceNote = serviceNote;
    }

    public ServiceEleve getServiceEleve() {
        return serviceEleve;
    }

    public void setServiceEleve(ServiceEleve serviceEleve) {
        this.serviceEleve = serviceEleve;
    }

    public ServiceAnneeScolaire getServiceAnneeScolaire() {
        return serviceAnneeScolaire;
    }

    public void setServiceAnneeScolaire(ServiceAnneeScolaire serviceAnneeScolaire) {
        this.serviceAnneeScolaire = serviceAnneeScolaire;
    }

    public AnneeScolaire getAnneeScolaireSelected() {
        return anneeScolaireSelected;
    }

    public void setAnneeScolaireSelected(AnneeScolaire anneeScolaireSelected) {
        this.anneeScolaireSelected = anneeScolaireSelected;
    }

    public List<Sequence> getSequences() throws ServiceException {
        return sequences = serviceSequence.findAll();
    }

    public void setSequences(List<Sequence> sequences) {
        this.sequences = sequences;
    }

    public ServiceSequence getServiceSequence() {
        return serviceSequence;
    }

    public void setServiceSequence(ServiceSequence serviceSequence) {
        this.serviceSequence = serviceSequence;
    }

    public Long getIdSecquence() {
        return idSecquence;
    }

    public void setIdSecquence(Long idSecquence) {
        this.idSecquence = idSecquence;
    }

    public Long getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Long idMatiere) {
        this.idMatiere = idMatiere;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public Notes getNoteSelected() {
        return noteSelected;
    }

    public void setNoteSelected(Notes noteSelected) {
        this.noteSelected = noteSelected;
    }

    public Long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }

    public List<Classe> getClasses() throws ServiceException {
        return classes = serviceClasse.findAll();
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public ServiceClasse getServiceClasse() {
        return serviceClasse;
    }

    public void setServiceClasse(ServiceClasse serviceClasse) {
        this.serviceClasse = serviceClasse;
    }

    public void filtreMatiere() throws ServiceException {
      /*  if (idClasse != null) {
            System.out.println("-------------id est-------"+idClasse);
            matieres = serviceMatiere.findMatiereByClasseID(idClasse);
        } else {
             System.out.println("-------------rien n'est dispo-------");
            matieres = new ArrayList<Matiere>();
        }*/
    }

    public ServiceMatiere getServiceMatiere() {
        return serviceMatiere;
    }

    public void setServiceMatiere(ServiceMatiere serviceMatiere) {
        this.serviceMatiere = serviceMatiere;
    }

    public List<Matiere> getMatieres() {
        return matieres;
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    public List<Notes> getNotes() throws ServiceException {
        return notes=serviceNote.FindAll();
    }

    public void setNotes(List<Notes> notes) {
        this.notes = notes;
    }
}
