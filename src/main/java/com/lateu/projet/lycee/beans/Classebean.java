/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.service.ServiceAnneeScolaire;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author lateu
 */
@ManagedBean
@RequestScoped
public class Classebean {

      @ManagedProperty(value = "#{ServiceClasse}")
    private ServiceClasse serviceClasse;
    private Classe classeselected=new Classe();
    public List<Classe> classes = new ArrayList<Classe>();
    public Classebean() {
    }

    public void SaveClasse() throws ServiceException{
    
    serviceClasse.create(classeselected);
    }
    
    public ServiceClasse getServiceClasse() {
        return serviceClasse;
    }

    public void setServiceClasse(ServiceClasse serviceClasse) {
        this.serviceClasse = serviceClasse;
    }

    public Classe getClasseselected() {
        return classeselected;
    }

    public void setClasseselected(Classe classeselected) {
        this.classeselected = classeselected;
    }

    public List<Classe> getClasses() throws ServiceException {
        return classes=serviceClasse.findAll();
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

  
    
    
    
}
