/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.Sequence;
import com.lateu.projet.lycee.service.ServiceAnneeScolaire;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceSequence;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

/**
 *
 * @author lateu
 */
@ManagedBean
@RequestScoped
public class Sequencebean {

    @ManagedProperty(value = "#{ServiceSequence}")
    private ServiceSequence serviceSequence;
    @ManagedProperty(value = "#{ServiceAnneeScolaire}")
    private ServiceAnneeScolaire serviceAnneeScolaire;
        @ManagedProperty(value = "#{ServiceClasse}")
    private ServiceClasse serviceClasse;
         private List<Classe> classes;
    private Sequence sequenceSelected = new Sequence();
    private SelectItem[] listeAnneeSelect;
    public List<AnneeScolaire> anneeScolaires;
    public List<Sequence> sequences;
    private String CodeAnnee;

    public Sequencebean() {
    }

    public void creeSequence() throws ServiceException {
        serviceSequence.create(sequenceSelected, CodeAnnee);

    }

    public ServiceSequence getServiceSequence() {
        return serviceSequence;
    }

    public void setServiceSequence(ServiceSequence serviceSequence) {
        this.serviceSequence = serviceSequence;
    }

    public Sequence getSequenceSelected() {
        return sequenceSelected;
    }

    public void setSequenceSelected(Sequence sequenceSelected) {
        this.sequenceSelected = sequenceSelected;
    }

    public SelectItem[] getListeAnneeSelect() throws ServiceException {
        anneeScolaires = serviceAnneeScolaire.findAll();
        listeAnneeSelect = new SelectItem[anneeScolaires.size() + 1];
        listeAnneeSelect[0] = new SelectItem("choisir");
        for (int i = 1; i < anneeScolaires.size() + 1; i++) {
            listeAnneeSelect[i] = new SelectItem(anneeScolaires.get(i - 1).getCode());
        }
        return listeAnneeSelect;
    }

    public void setListeAnneeSelect(SelectItem[] listeAnneeSelect) {
        this.listeAnneeSelect = listeAnneeSelect;
    }

    public List<AnneeScolaire> getAnneeScolaires() {
        return anneeScolaires;
    }

    public void setAnneeScolaires(List<AnneeScolaire> anneeScolaires) {
        this.anneeScolaires = anneeScolaires;
    }

    public ServiceAnneeScolaire getServiceAnneeScolaire() {
        return serviceAnneeScolaire;
    }

    public void setServiceAnneeScolaire(ServiceAnneeScolaire serviceAnneeScolaire) {
        this.serviceAnneeScolaire = serviceAnneeScolaire;
    }

    public String getCodeAnnee() {
        return CodeAnnee;
    }

    public void setCodeAnnee(String CodeAnnee) {
        this.CodeAnnee = CodeAnnee;
    }

    public List<Sequence> getSequences() throws ServiceException {
        return sequences=serviceSequence.findAll();
    }

    public void setSequences(List<Sequence> sequences) {
        this.sequences = sequences;
    }

    public List<Classe> getClasses() throws ServiceException {
        return classes=serviceClasse.findAll();
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
    
    
    
    
}
