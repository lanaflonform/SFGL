/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceMatiere;
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
public class Matierebean {
@ManagedProperty(value = "#{ServiceMatiere}")
private ServiceMatiere serviceMatiere;
    private List<Matiere> matieres = new ArrayList<Matiere>();
    private Matiere matiereSelected=new Matiere();

    public Matierebean() {
    }

    
    public void createMatiere() throws ServiceException{
    serviceMatiere.create(matiereSelected);
    }
    
    public List<Matiere> getMatieres() throws ServiceException {
        return matieres=serviceMatiere.findAll();
    }

    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }

    public Matiere getMatiereSelected() {
        return matiereSelected;
    }

    public void setMatiereSelected(Matiere matiereSelected) {
        this.matiereSelected = matiereSelected;
    }

    public ServiceMatiere getServiceMatiere() {
        return serviceMatiere;
    }

    public void setServiceMatiere(ServiceMatiere serviceMatiere) {
        this.serviceMatiere = serviceMatiere;
    }
    
    
    
    
}
