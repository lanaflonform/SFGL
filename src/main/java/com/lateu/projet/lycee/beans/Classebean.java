/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.lateu.projet.lycee.Enum.Cycle;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.ClasseLevel;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceClasseLevel;
import com.lateu.projet.lycee.service.ServiceException;
import java.io.Serializable;
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
//@ViewScoped
@RequestScoped
public class Classebean implements Serializable{

    @ManagedProperty(value = "#{ServiceClasse}")
    private ServiceClasse serviceClasse;
    @ManagedProperty(value = "#{ServiceClasseLevel}")
    private ServiceClasseLevel serviceClasseLevel;
    private Classe classeselected = new Classe();
    public List<Classe> classes = new ArrayList<Classe>();
    private Cycle cycleSelected;
    private List<Cycle> cycles = new ArrayList<Cycle>();
    private List<ClasseLevel> classeLevels = new ArrayList<ClasseLevel>();
    private ClasseLevel classeLevelSelect = new ClasseLevel();
    private int idCycle;
    private Long idClasseLevel;

    public Classebean() {
    }

    public void SaveClasse() throws ServiceException {
        classeLevelSelect=serviceClasseLevel.findbyId(idClasseLevel);
        if(classeLevelSelect!=null){
            classeselected.setClasseLevel(classeLevelSelect);
        serviceClasse.create(classeselected);
        classeselected = new Classe();
        
    
    }else{
           System.out.println("----echec car la reference est nulle");
        
        
        }
    }
    
//     public void handleCycleChange() {
//        if (cycleSelected!=null) {
//               System.out.println("-----------"+serviceClasseLevel.findbyCycleId(cycleSelected)+"--------"); 
//             classeLevels = serviceClasseLevel.findbyCycleId(cycleSelected);
//        } else {
//            System.out.println("-----------c est bon--------");
//             classeLevels = new ArrayList<ClasseLevel>();
//        }
//       
//    }

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
        return classes = serviceClasse.findAll();
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

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

    public List<ClasseLevel> getClasseLevels() throws ServiceException {
        return classeLevels= serviceClasseLevel.findAll();
    }

    public void setClasseLevels(List<ClasseLevel> classeLevels) {
        this.classeLevels = classeLevels;
    }

    public int getIdCycle() {
        return idCycle;
    }

    public void setIdCycle(int idCycle) {
        this.idCycle = idCycle;
    }

    public ServiceClasseLevel getServiceClasseLevel() {
        return serviceClasseLevel;
    }

    public void setServiceClasseLevel(ServiceClasseLevel serviceClasseLevel) {
        this.serviceClasseLevel = serviceClasseLevel;
    }

    public ClasseLevel getClasseLevelSelect() {
        return classeLevelSelect;
    }

    public void setClasseLevelSelect(ClasseLevel classeLevelSelect) {
        this.classeLevelSelect = classeLevelSelect;
    }

    public Long getIdClasseLevel() {
        return idClasseLevel;
    }

    public void setIdClasseLevel(Long idClasseLevel) {
        this.idClasseLevel = idClasseLevel;
    }
    
    
}
