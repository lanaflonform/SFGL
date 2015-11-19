/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.MaClaCoef;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.entities.Professeur;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceMaClaCoef;
import com.lateu.projet.lycee.service.ServiceMatiere;
import com.lateu.projet.lycee.service.ServiceProfesseur;
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
public class MaclaCoefbean {

    
    @ManagedProperty(value = "#{ServiceMaClaCoef}")
    private ServiceMaClaCoef serviceMaClaCoef;
    @ManagedProperty(value = "#{ServiceClasse}")
    private ServiceClasse serviceClasse;
    @ManagedProperty(value = "#{ServiceMatiere}")
    private ServiceMatiere serviceMatiere;
    
    @ManagedProperty(value = "#{ServiceProfesseur}")
    private ServiceProfesseur serviceProfesseur;
    private List<Matiere> matieres = new ArrayList<Matiere>();
    private MaClaCoef maclaCoefselect=new MaClaCoef();
    public List<Classe> classes = new ArrayList<Classe>();
     public List<MaClaCoef> maClaCoefs = new ArrayList<MaClaCoef>();
     public List<Professeur>professeurs=new ArrayList<Professeur>();
    private SelectItem[] listeClasseSelect;
     private SelectItem[] listeMatiereSelect;
    private String codeClasse;
    private String nomMatiere;
    private Long idEnseignant;

    public MaclaCoefbean() {
    }
    
    
    public void creerMatCla() throws ServiceException{
    
       // System.out.println("================"+codeClasse);
       serviceMaClaCoef.create(maclaCoefselect, nomMatiere, codeClasse,idEnseignant);
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

    public List<Matiere> getMatieres() throws ServiceException {
        return matieres=serviceMatiere.findAll();
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    public List<Classe> getClasses() throws ServiceException {
        return classes = serviceClasse.findAll();
    }

    public MaClaCoef getMaclaCoefselect() {
        return maclaCoefselect;
    }

    public void setMaclaCoefselect(MaClaCoef maclaCoefselect) {
        this.maclaCoefselect = maclaCoefselect;
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public String getCodeClasse() {
        return codeClasse;
    }

    public void setCodeClasse(String codeClasse) {
        this.codeClasse = codeClasse;
    }

    public void setListeClasseSelect(SelectItem[] listeClasseSelect) {
        this.listeClasseSelect = listeClasseSelect;
    }

    public SelectItem[] getListeClasseSelect() throws ServiceException {
        classes = serviceClasse.findAll();
        listeClasseSelect = new SelectItem[classes.size() + 1];
        listeClasseSelect[0] = new SelectItem("choisir");
        for (int i = 1; i < classes.size() + 1; i++) {
            listeClasseSelect[i] = new SelectItem(classes.get(i - 1).getCode());
        }
        return listeClasseSelect;
    }

    public SelectItem[] getListeMatiereSelect() throws ServiceException {
         matieres = serviceMatiere.findAll();
        listeMatiereSelect = new SelectItem[matieres.size() + 1];
        listeMatiereSelect[0] = new SelectItem("choisir");
        for (int i = 1; i < matieres.size() + 1; i++) {
            listeMatiereSelect[i] = new SelectItem(matieres.get(i - 1).getIntitule());
        }
        return listeMatiereSelect;
    }

    public void setListeMatiereSelect(SelectItem[] listeMatiereSelect) {
        this.listeMatiereSelect = listeMatiereSelect;
    }

    public String getNomMatiere() {
        return nomMatiere;
    }

    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public ServiceMaClaCoef getServiceMaClaCoef() {
        return serviceMaClaCoef;
    }

    public void setServiceMaClaCoef(ServiceMaClaCoef serviceMaClaCoef) {
        this.serviceMaClaCoef = serviceMaClaCoef;
    }
    

    public List<MaClaCoef> getMaClaCoefs() throws ServiceException {
        return maClaCoefs=serviceMaClaCoef.findAll();
    }

    public void setMaClaCoefs(List<MaClaCoef> maClaCoefs) {
        this.maClaCoefs = maClaCoefs;
    }

    public ServiceProfesseur getServiceProfesseur() {
        return serviceProfesseur;
    }

    public void setServiceProfesseur(ServiceProfesseur serviceProfesseur) {
        this.serviceProfesseur = serviceProfesseur;
    }

    public List<Professeur> getProfesseurs() throws ServiceException {
        return professeurs=serviceProfesseur.findAll();
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

    public Long getIdEnseignant() {
        return idEnseignant;
    }

    public void setIdEnseignant(Long idEnseignant) {
        this.idEnseignant = idEnseignant;
    }
    
    
    
}
