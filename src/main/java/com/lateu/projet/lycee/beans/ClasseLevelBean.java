/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.Common.IPartage;
import com.lateu.projet.lycee.Common.IPartageImpl;
import com.lateu.projet.lycee.Enum.Cycle;
import com.lateu.projet.lycee.entities.ClasseLevel;
import com.lateu.projet.lycee.service.ServiceClasseLevel;
import com.lateu.projet.lycee.service.ServiceException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author ing-lateu
 */
@ManagedBean
@RequestScoped
public class ClasseLevelBean {

    @ManagedProperty(value = "#{ServiceClasseLevel}")
    private ServiceClasseLevel serviceClasseLevel;
    private ClasseLevel classeLevelSelected = new ClasseLevel();
    private Cycle cycleSelected;
    private String niveau;
    private List<Cycle> cycles = new ArrayList<Cycle>();
    private IPartage iPartage=new IPartageImpl();
     private List<ClasseLevel>classeLevels=new ArrayList<ClasseLevel>();

    /**
     * Creates a new instance of ClasseLevelBean
     */
    public ClasseLevelBean() {
    }

    public void save() throws ServiceException {
        classeLevelSelected.setCycleEtude(cycleSelected);
        
        classeLevelSelected.setNiveau(iPartage.secureChaine(niveau));
        serviceClasseLevel.save(classeLevelSelected);
        classeLevelSelected=new ClasseLevel();
    }

//    public String secure(String s) {
//        s = s.toLowerCase().trim().replace(" ", "_");
//        return s;
//    }

    public Cycle getCycleSelected() {
        return cycleSelected;
    }

    public void setCycleSelected(Cycle cycleSelected) {
        this.cycleSelected = cycleSelected;
    }

    public List<Cycle> getCycles() {
        cycles.add(Cycle.Premiere_Cycle);
        cycles.add(Cycle.Second_Cycle);
        return cycles;
    }

    public void setCycles(List<Cycle> cycles) {
        this.cycles = cycles;
    }

    public ServiceClasseLevel getServiceClasseLevel() {
        return serviceClasseLevel;
    }

    public void setServiceClasseLevel(ServiceClasseLevel serviceClasseLevel) {
        this.serviceClasseLevel = serviceClasseLevel;
    }

    public ClasseLevel getClasseLevelSelected() {
        return classeLevelSelected;
    }

    public void setClasseLevelSelected(ClasseLevel classeLevelSelected) {
        this.classeLevelSelected = classeLevelSelected;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public List<ClasseLevel> getClasseLevels() throws ServiceException {
        return classeLevels=serviceClasseLevel.findAll();
    }

    public void setClasseLevels(List<ClasseLevel> classeLevels) {
        this.classeLevels = classeLevels;
    }

    public IPartage getiPartage() {
        return iPartage;
    }

    public void setiPartage(IPartage iPartage) {
        this.iPartage = iPartage;
    }
}
