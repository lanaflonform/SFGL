/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.Enum.Appreciation;
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
public class ServiceNoteImpl implements ServiceNote {

    private Notedao notedao;
    private Elevedao elevedao;
    private Sequencedao sequencedao;
    private Matieredao matieredao;
    private AnneeScolairedao anneeScolairedao;

    @Override
    public void create(Notes note, String matricule, Long idsequence, Long idmatiere, Long annee) throws ServiceException {

        try {
          
            note.setAnnee(anneeScolairedao.findById(annee));
            note.setMatiere(matieredao.findById(idmatiere));
            note.setSequence(sequencedao.findById(idsequence));
            note.setEleve(elevedao.findElevebyMatricule(matricule));
            note.setAppreciation(Apprecier(note.getNote()));
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
            return notedao.findAllNotes();
        } catch (DataAccessException ex) {
            Logger.getLogger(ServiceNoteImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Appreciation Apprecier(double note) throws ServiceException {
        Appreciation ap =Appreciation.MEDIOCRE;
     if(note<10.0){
     ap= Appreciation.MEDIOCRE;
     }else if((note<12.0)&&(note>=10.0)){
     ap=Appreciation.PASSABLE;
     
     }else if((note<14.0)&&(note>=12.0)){
     ap=Appreciation.ASSEZ_BIEN;
     
     }else if((note<16.0)&&(note>=14.0)){
     ap=Appreciation.BIEN;
     
     }else if((note<18.0)&&(note>=16.0)){
     ap=Appreciation.TRES_BIEN;
     
     }else{
     ap=Appreciation.EXCELLENT;
     }
    
     return ap;
    
    }
}
