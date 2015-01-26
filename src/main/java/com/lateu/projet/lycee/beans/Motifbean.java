/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;
import com.lateu.projet.lycee.entities.Motif;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceMotif;
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
public class Motifbean {
 @ManagedProperty(value = "#{ServiceMotif}")
 private ServiceMotif serviceMotif;
 private Motif motifSelected=new Motif();
 public List<Motif> motifs=new ArrayList<Motif>();
    public Motifbean() {
    }
    
    public void creer() throws ServiceException{
    serviceMotif.create(motifSelected);
    }

    public ServiceMotif getServiceMotif() {
        return serviceMotif;
    }

    public void setServiceMotif(ServiceMotif serviceMotif) {
        this.serviceMotif = serviceMotif;
    }

    public Motif getMotifSelected() {
        return motifSelected;
    }

    public void setMotifSelected(Motif motifSelected) {
        this.motifSelected = motifSelected;
    }

    public List<Motif> getMotifs() throws ServiceException {
        return motifs=serviceMotif.findAll();
    }

    public void setMotifs(List<Motif> motifs) {
        this.motifs = motifs;
    }
       
}
