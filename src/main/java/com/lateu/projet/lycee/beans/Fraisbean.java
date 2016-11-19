/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.FraisDiver;
import com.lateu.projet.lycee.entities.Motif;
import com.lateu.projet.lycee.service.ServiceAnneeScolaire;
import com.lateu.projet.lycee.service.ServiceEleve;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceFraisDivers;
import com.lateu.projet.lycee.service.ServiceMotif;
import java.util.ArrayList;
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
public class Fraisbean {

    @ManagedProperty(value = "#{ServiceEleve}")
    private ServiceEleve serviceEleve;
    @ManagedProperty(value = "#{ServiceMotif}")
    private ServiceMotif serviceMotif;
    @ManagedProperty(value = "#{ServiceAnneeScolaire}")
    private ServiceAnneeScolaire serviceAnneeScolaire;
    @ManagedProperty(value = "#{ServiceFraisDivers}")
    private ServiceFraisDivers serviceFraisDivers;
    private String nomMotif;
    private String matEleve;
    private String codeAnnee;
    private FraisDiver fraisDiverselected=new FraisDiver();
    public List<AnneeScolaire> Annees = new ArrayList<AnneeScolaire>();
    public List<Motif> motifs = new ArrayList<Motif>();
     public List<FraisDiver>fraisDivers=new ArrayList<FraisDiver>();
    private SelectItem[] listeAnneeSelect;
    
    private SelectItem[] listeMotifSelect;

    public Fraisbean() {
    }

    
    public void creer() throws ServiceException{
    serviceFraisDivers.creer(fraisDiverselected, codeAnnee, matEleve, nomMotif);
    fraisDiverselected=new FraisDiver();
    
    }
    
    public ServiceEleve getServiceEleve() {
        return serviceEleve;
    }

    public void setServiceEleve(ServiceEleve serviceEleve) {
        this.serviceEleve = serviceEleve;
    }

    public ServiceMotif getServiceMotif() {
        return serviceMotif;
    }

    public void setServiceMotif(ServiceMotif serviceMotif) {
        this.serviceMotif = serviceMotif;
    }

    public ServiceAnneeScolaire getServiceAnneeScolaire() {
        return serviceAnneeScolaire;
    }

    public void setServiceAnneeScolaire(ServiceAnneeScolaire serviceAnneeScolaire) {
        this.serviceAnneeScolaire = serviceAnneeScolaire;
    }

    public ServiceFraisDivers getServiceFraisDivers() {
        return serviceFraisDivers;
    }

    public void setServiceFraisDivers(ServiceFraisDivers serviceFraisDivers) {
        this.serviceFraisDivers = serviceFraisDivers;
    }


    public String getNomMotif() {
        return nomMotif;
    }

    public void setNomMotif(String nomMotif) {
        this.nomMotif = nomMotif;
    }

    public String getMatEleve() {
        return matEleve;
    }

    public void setMatEleve(String matEleve) {
        this.matEleve = matEleve;
    }

    public String getCodeAnnee() {
        return codeAnnee;
    }

    public void setCodeAnnee(String codeAnnee) {
        this.codeAnnee = codeAnnee;
    }

    public FraisDiver getFraisDiverselected() {
        return fraisDiverselected;
    }

    public void setFraisDiverselected(FraisDiver fraisDiverselected) {
        this.fraisDiverselected = fraisDiverselected;
    }

    
    
    public List<AnneeScolaire> getAnnees() throws ServiceException {
        return Annees=serviceAnneeScolaire.findAll();
    }

    public void setAnnees(List<AnneeScolaire> Annees) {
        this.Annees = Annees;
    }

    public List<Motif> getMotifs() throws ServiceException {
        return motifs=serviceMotif.findAll();
    }

    public void setMotifs(List<Motif> motifs) {
        this.motifs = motifs;
    }

    public SelectItem[] getListeAnneeSelect() throws ServiceException {
         Annees = serviceAnneeScolaire.findAll();
        listeAnneeSelect = new SelectItem[ Annees.size() + 1];
        listeAnneeSelect[0] = new SelectItem("choisir");
        for (int i = 1; i <  Annees.size() + 1; i++) {
            listeAnneeSelect[i] = new SelectItem( Annees.get(i - 1).getCode());
        }
        return listeAnneeSelect;
    }

    public void setListeAnneeSelect(SelectItem[] listeAnneeSelect) {
        this.listeAnneeSelect = listeAnneeSelect;
    }

    public SelectItem[] getListeMotifSelect() throws ServiceException {
           motifs = serviceMotif.findAll();
        listeMotifSelect = new SelectItem[ motifs.size() + 1];
        listeMotifSelect[0] = new SelectItem("choisir");
        for (int i = 1; i <  motifs.size() + 1; i++) {
            listeMotifSelect[i] = new SelectItem( motifs.get(i - 1).getLibele());
        }
        
        return listeMotifSelect;
    }

    public void setListeMotifSelect(SelectItem[] listeMotifSelect) {
        this.listeMotifSelect = listeMotifSelect;
    }

    public List<FraisDiver> getFraisDivers() throws ServiceException {
        return fraisDivers=serviceFraisDivers.findAll();
    }

    public void setFraisDivers(List<FraisDiver> fraisDivers) {
        this.fraisDivers = fraisDivers;
    }

   
    
    
    
}
