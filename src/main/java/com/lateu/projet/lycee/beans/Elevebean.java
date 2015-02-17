/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.Nationalite;
import com.lateu.projet.lycee.service.ServiceAnneeScolaire;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceEleve;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceNationalite;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class Elevebean {

    @ManagedProperty(value = "#{ServiceEleve}")
    private ServiceEleve serviceEleve;
    @ManagedProperty(value = "#{ServiceAnneeScolaire}")
    private ServiceAnneeScolaire serviceAnneeScolaire;
    private AnneeScolaire anneeScolaireSelected;
    @ManagedProperty(value = "#{ServiceNationalite}")
    private ServiceNationalite serviceNationalite;
    @ManagedProperty(value = "#{ServiceClasse}")
    private ServiceClasse serviceClasse;
    private Nationalite nationnaliteSelected = new Nationalite();
    public List<Nationalite> nationalites;
     public List<Eleve> eleves;
    private SelectItem[] listeNationSelect;
    public List<AnneeScolaire> anneeScolaires;
    public List<Classe> classes = new ArrayList<Classe>();
    private Eleve eleveSelected = new Eleve();
    private String CodeAnnee;
    private String pays;
    private String classe;
    private SelectItem[] listeAnneeSelect;
    private SelectItem[] listeClasseSelect;

    public Elevebean() {
    }

    public void create() throws ServiceException {
        SimpleDateFormat tmp = new SimpleDateFormat("dd-MM-yyyy");
        Long index=serviceEleve.LastIndex(serviceEleve.FindAll());
        //String s1=tmp.format(dt);
        String s = buildeMatricule(new Date(), "L", 1+(index));
        eleveSelected.setMatricule(s);
        eleveSelected.setStatut("eleve");
        serviceEleve.create(eleveSelected, CodeAnnee, pays, classe);

        //System.out.println("====="+eleveSelected);
    }

    public String buildeMatricule(Date d, String chaine, Long chaine1) {
        String s;
        SimpleDateFormat tmp = new SimpleDateFormat("dd-MM-yyyy");
        Date dt = new Date();
        s = tmp.format(dt);
        s = s.substring(8, 10) + chaine + chaine1;
        return s;


    }

    public List<Eleve> getEleves() throws ServiceException {
        return eleves=serviceEleve.FindAll();
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
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

    public ServiceNationalite getServiceNationalite() {
        return serviceNationalite;
    }

    public void setServiceNationalite(ServiceNationalite serviceNationalite) {
        this.serviceNationalite = serviceNationalite;
    }

    public ServiceClasse getServiceClasse() {
        return serviceClasse;
    }

    public void setServiceClasse(ServiceClasse serviceClasse) {
        this.serviceClasse = serviceClasse;
    }

    public Nationalite getNationnaliteSelected() {
        return nationnaliteSelected;
    }

    public void setNationnaliteSelected(Nationalite nationnaliteSelected) {
        this.nationnaliteSelected = nationnaliteSelected;
    }

    public List<Nationalite> getNationalites() throws ServiceException {
        return nationalites = serviceNationalite.FindAll();
    }

    public void setNationalites(List<Nationalite> nationalites) {
        this.nationalites = nationalites;
    }

    public Eleve getEleveSelected() {
        return eleveSelected;
    }

    public void setEleveSelected(Eleve eleveSelected) {
        this.eleveSelected = eleveSelected;
    }

    public List<Classe> getClasses() throws ServiceException {
        return classes = serviceClasse.findAll();
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public SelectItem[] getListeClasseSelect() throws ServiceException {
        classes = serviceClasse.findAll();
        listeClasseSelect = new SelectItem[classes.size() + 1];
        listeClasseSelect[0] = new SelectItem("choisir");
        for (int i = 1; i < classes.size() + 1; i++) {
            listeClasseSelect[i] = new SelectItem(classes.get(i - 1).getLibele());
        }

        return listeClasseSelect;
    }

    public void setListeClasseSelect(SelectItem[] listeClasseSelect) {
        this.listeClasseSelect = listeClasseSelect;
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

    public String getCodeAnnee() {
        return CodeAnnee;
    }

    public void setCodeAnnee(String CodeAnnee) {
        this.CodeAnnee = CodeAnnee;
    }

    public SelectItem[] getListeNationSelect() throws ServiceException {

        nationalites = serviceNationalite.FindAll();
        listeNationSelect = new SelectItem[nationalites.size() + 1];
        listeNationSelect[0] = new SelectItem("choisir");
        for (int i = 1; i < nationalites.size() + 1; i++) {
            listeNationSelect[i] = new SelectItem(nationalites.get(i - 1).getPays());
        }
        return listeNationSelect;
    }

    public void setListeNationSelect(SelectItem[] listeNationSelect) {
        this.listeNationSelect = listeNationSelect;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}