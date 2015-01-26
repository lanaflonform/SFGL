/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.entities.Nationalite;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceNationalite;
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
public class Nationnalitebean {

    @ManagedProperty(value = "#{ServiceNationalite}")
    private ServiceNationalite serviceNationalite;
    private Nationalite nationnaliteSelected=new Nationalite();
    public List<Nationalite> nationalites;
    public Nationnalitebean() {
    }
    public void SaveNationnalite() throws ServiceException{
    serviceNationalite.create(nationnaliteSelected);
    
    }
   
    public void updateNat() throws ServiceException{
    serviceNationalite.update(nationnaliteSelected);
   
    }
    public ServiceNationalite getServiceNationalite() {
        return serviceNationalite;
    }

    public void setServiceNationalite(ServiceNationalite serviceNationalite) {
        this.serviceNationalite = serviceNationalite;
    }

    public Nationalite getNationnaliteSelected() {
        return nationnaliteSelected;
    }

    public void setNationnaliteSelected(Nationalite nationnaliteSelected) {
        this.nationnaliteSelected = nationnaliteSelected;
    }

    public List<Nationalite> getNationalites() throws ServiceException {
        return nationalites=serviceNationalite.FindAll();
    }

    public void setNationalites(List<Nationalite> nationalites) {
        this.nationalites = nationalites;
    }
    
      
    
    
    
    
}
