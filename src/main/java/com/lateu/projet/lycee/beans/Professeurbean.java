/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.entities.Professeur;
import com.lateu.projet.lycee.entities.UserRole;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceProfesseur;
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
public class Professeurbean {

    @ManagedProperty(value = "#{ServiceProfesseur}")
    private ServiceProfesseur serviceProfesseur;
    private Professeur professeurselected = new Professeur();
    public List<Professeur> professeurs = new ArrayList<Professeur>();
   // private String role;
    private UserRole userRole = new UserRole();

    public Professeurbean() {
    }

    public void create() throws ServiceException {

        SimpleDateFormat tmp = new SimpleDateFormat("dd-MM-yyyy");
        String index = serviceProfesseur.LastIndex(professeurs);
        String s = buildeMatricule(new Date(), "P"+index);
        professeurselected.setMatricule(s);
        professeurselected.setEtatCompte("1");
        userRole.setProfesseur(professeurselected);
        serviceProfesseur.create(professeurselected, userRole);
    }

    public String buildeMatricule(Date d, String chaine) {
        String s;
        SimpleDateFormat tmp = new SimpleDateFormat("dd-MM-yyyy");
        Date dt = new Date();
        s = tmp.format(dt);
        s = s.substring(8, 10) + chaine;
        return s;


    }

    public ServiceProfesseur getServiceProfesseur() {
        return serviceProfesseur;
    }

    public void setServiceProfesseur(ServiceProfesseur serviceProfesseur) {
        this.serviceProfesseur = serviceProfesseur;
    }

    public Professeur getProfesseurselected() {
        return professeurselected;
    }

    public void setProfesseurselected(Professeur professeurselected) {
        this.professeurselected = professeurselected;
    }

    public List<Professeur> getProfesseurs() throws ServiceException {
        return professeurs = serviceProfesseur.findAll();
    }

    public void setProfesseurs(List<Professeur> professeurs) {
        this.professeurs = professeurs;
    }

//    public String getRole() {
//        return role;
//    }
//
//    public void setRole(String role) {
//        this.role = role;
//    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }
}
