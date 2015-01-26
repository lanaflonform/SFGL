/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.AnneeScolairedao;
import com.lateu.projet.lycee.dao.Elevedao;
import com.lateu.projet.lycee.dao.Matieredao;
import com.lateu.projet.lycee.dao.Notedao;
import com.lateu.projet.lycee.dao.Sequencedao;
import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.entities.Notes;
import com.lateu.projet.lycee.entities.Sequence;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceNote;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author richardlateu
 */
@Transactional
public class ServiceNoteImpl  implements ServiceNote{
 private Notedao notedao;
 private Elevedao elevedao;
 private Sequencedao sequencedao;
 private Matieredao matieredao;
 private AnneeScolairedao anneeScolairedao;
 
      public void create(Notes note, String matricule, String sequence,String matiere,Long annee) throws ServiceException {
    Matiere mat=new Matiere();
         Eleve e = new Eleve();
          AnneeScolaire a=new AnneeScolaire();
     try {
         e = elevedao.findElevebyMatricule(matricule);
     } catch (DataAccessException ex) {
         Logger.getLogger(ServiceNoteImpl.class.getName()).log(Level.SEVERE, null, ex);
     }
         Sequence seq = new Sequence();
     try {
         seq = sequencedao.findSequencebyintitule(sequence);
     } catch (DataAccessException ex) {
         Logger.getLogger(ServiceNoteImpl.class.getName()).log(Level.SEVERE, null, ex);
     }
       //  Matiere mat = new Matiere();
     try {
         mat = matieredao.findMatierebyIntitule(matiere);
     } catch (DataAccessException ex) {
         Logger.getLogger(ServiceNoteImpl.class.getName()).log(Level.SEVERE, null, ex);
     }
     try {
         a=anneeScolairedao.findById(annee);
     } catch (DataAccessException ex) {
         Logger.getLogger(ServiceNoteImpl.class.getName()).log(Level.SEVERE, null, ex);
     }
     note.setAnnee(a);
         note.setMatiere(mat);
         note.setMatiere(mat);
         note.setSequence(seq);
         note.setEleve(e);
     try {
         notedao.create(note);
     } catch (DataAccessException ex) {
         Logger.getLogger(ServiceNoteImpl.class.getName()).log(Level.SEVERE, null, ex);
     }
    }
    
    
    public Notedao getNotedao() {
        return notedao;
    }

    public void setNotedao(Notedao notedao) {
        this.notedao = notedao;
    }

    public Elevedao getElevedao() {
        return elevedao;
    }

    public void setElevedao(Elevedao elevedao) {
        this.elevedao = elevedao;
    }

    public Sequencedao getSequencedao() {
        return sequencedao;
    }

    public void setSequencedao(Sequencedao sequencedao) {
        this.sequencedao = sequencedao;
    }

    public Matieredao getMatieredao() {
        return matieredao;
    }

    public void setMatieredao(Matieredao matieredao) {
        this.matieredao = matieredao;
    }

    public AnneeScolairedao getAnneeScolairedao() {
        return anneeScolairedao;
    }

    public void setAnneeScolairedao(AnneeScolairedao anneeScolairedao) {
        this.anneeScolairedao = anneeScolairedao;
    }

    @Override
    public List<Notes> FindAll() throws ServiceException {
     try {
         return notedao.findAll();
     } catch (DataAccessException ex) {
         Logger.getLogger(ServiceNoteImpl.class.getName()).log(Level.SEVERE, null, ex);
     }
     return null;
    }

  
    
    
}
