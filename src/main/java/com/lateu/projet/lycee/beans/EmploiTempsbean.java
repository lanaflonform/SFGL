/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.EmploiDeTemps;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.service.Impl.ServiceAnneeScolaireImpl;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceEmploi;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceMatiere;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author ing-lateu
 */
@ManagedBean
@RequestScoped
public class EmploiTempsbean {

    @ManagedProperty(value = "#{ServiceEmploi}")
    private ServiceEmploi serviceEmploi;
    @ManagedProperty(value = "#{ServiceClasse}")
    private ServiceClasse serviceClasse;
    @ManagedProperty(value = "#{ServiceMatiere}")
    private ServiceMatiere serviceMatiere;
    private EmploiDeTemps emploiSelected = new EmploiDeTemps();
    private Long idClasse;
    private Long idMatiere;
    private Matiere matiereSelect = new Matiere();
    private Classe classeSelect = new Classe();
    private List<EmploiDeTemps> emplois = new ArrayList<EmploiDeTemps>();
    private List<Matiere> matieres = new ArrayList<Matiere>();
    private List<Classe> classes = new ArrayList<Classe>();

    public EmploiTempsbean() {
    }

    public void save() throws ServiceException {
        emplois = serviceEmploi.Valider(idClasse, idMatiere, emploiSelected.getJour());
        int nb = emplois.size();
        if (nb == 0) {
            matiereSelect = serviceMatiere.findById(idMatiere);
            classeSelect = serviceClasse.findById(idClasse);
            serviceEmploi.SaveEmploi(emploiSelected, classeSelect, matiereSelect);
            emploiSelected = new EmploiDeTemps();
            matiereSelect = new Matiere();
            classeSelect = new Classe();
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "succès", ""));


        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Matiere deja Programmer pour cette journée", ""));


        }

    }

    public void opdate() {
    }

    public void delete() {
    }

    public List<EmploiDeTemps> getEmplois() throws ServiceException {
        return emplois = serviceEmploi.findAll();
    }

    public void setEmplois(List<EmploiDeTemps> emplois) {
        this.emplois = emplois;
    }

    public ServiceEmploi getServiceEmploi() {
        return serviceEmploi;
    }

    public void setServiceEmploi(ServiceEmploi serviceEmploi) {
        this.serviceEmploi = serviceEmploi;
    }

    public EmploiDeTemps getEmploiSelected() {
        return emploiSelected;
    }

    public void setEmploiSelected(EmploiDeTemps emploiSelected) {
        this.emploiSelected = emploiSelected;
    }

    public List<Matiere> getMatieres() throws ServiceException {
        return matieres = serviceMatiere.findAll();
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
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

    public ServiceMatiere getServiceMatiere() {
        return serviceMatiere;
    }

    public void setServiceMatiere(ServiceMatiere serviceMatiere) {
        this.serviceMatiere = serviceMatiere;
    }

    public Long getIdMatiere() {
        return idMatiere;
    }

    public void setIdMatiere(Long idMatiere) {
        this.idMatiere = idMatiere;
    }

    public Long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }
}
