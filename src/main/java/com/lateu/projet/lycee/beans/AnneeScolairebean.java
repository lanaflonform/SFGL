/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.service.ServiceAnneeScolaire;
import com.lateu.projet.lycee.service.ServiceException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
public class AnneeScolairebean {

    @ManagedProperty(value = "#{ServiceAnneeScolaire}")
    private ServiceAnneeScolaire serviceAnneeScolaire;
    private AnneeScolaire anneeScolaireSelected = new AnneeScolaire();
    public List<AnneeScolaire> listeAnnee = new ArrayList<AnneeScolaire>();

    public AnneeScolairebean() {
    }

    public String buildeMatricule(Date d, Date d2) {
        String s, s2;
        SimpleDateFormat tmp = new SimpleDateFormat("dd-MM-yyyy");
        // Date dt = new Date();
        s = tmp.format(d);
        s2 = tmp.format(d2);
        s = s.substring(6, 10) + "" + "/" + s2.substring(6, 10);
        return s;


    }

    public void creerAnnee() throws ServiceException {
        anneeScolaireSelected.setCode(buildeMatricule(anneeScolaireSelected.getDebut(), anneeScolaireSelected.getFin()));
        //anneeScolaireSelected.setDebut(getDebut());
        //anneeScolaireSelected.setFin(getFin());
       // anneeScolaireSelected.setCode("01524");
       
        serviceAnneeScolaire.create(anneeScolaireSelected);
        anneeScolaireSelected = new AnneeScolaire();

      //System.out.println("===="+anneeScolaireSelected);
    }

    public List<AnneeScolaire> getListeAnnee() throws ServiceException {
        return listeAnnee = serviceAnneeScolaire.findAll();
    }

    public void setListeAnnee(List<AnneeScolaire> listeAnnee) {
        this.listeAnnee = listeAnnee;
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

    
}
