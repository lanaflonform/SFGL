/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.Elevedao;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.MaClaCoef;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.entities.Nationalite;
import com.lateu.projet.lycee.entities.Notes;
import com.lateu.projet.lycee.projection.ReportEntry;
import com.lateu.projet.lycee.projection.PV;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public class ElevedaoImpl extends GenericDao<Eleve, Long> implements Elevedao {

    @Override
    public Eleve findElevebyMatricule(String matricule) throws DataAccessException {
        return (Eleve) getManager().createNamedQuery("findElevebyMatricule")
                .setParameter("matricule", matricule)
                .getSingleResult();
    }

    @Override
    public List<Eleve> findElevebyNom(String nom) throws DataAccessException {
        return getManager().createNamedQuery("findElevebyNom")
                .setParameter("nom", nom)
                .getResultList();
    }

    @Override
    public List<Eleve> findElevebyNationalite(Nationalite nationalite) throws DataAccessException {
        return getManager().createNamedQuery("findElevebyNationalite")
                .setParameter("nationalite", nationalite)
                .getResultList();
    }

    @Override
    public List<Notes> findNotebyMatricule(Matiere m, Classe cl) throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public  List<PV> GeneralPV(String classe, Long idMatiere) throws DataAccessException {
        return getManager().createNamedQuery("GeneralPV")
                .setParameter("matricule", classe)
                .setParameter("idmat", idMatiere)
                .getResultList();
    }

   
    
    
    @Override
    public Eleve findMyMarks() throws DataAccessException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<ReportEntry> maSectionBulletin(/*String classe,*/String codeClasse, String levelmat) throws DataAccessException {
        return getManager().createNamedQuery("SectionBulletin")
                .setParameter("codeClasse", codeClasse)
                .setParameter("levelmat", levelmat)
                //.setParameter("sequence", sequence)
                .getResultList();
    }

    @Override
    public Classe rechercheMaClasse(String matricule/*, AnneeScolaire annee*/) throws DataAccessException {
        return (Classe) getManager().createNamedQuery("rechercheMaClasse")
                .setParameter("matricule", matricule)
                // .setParameter("annee", annee)
                .getSingleResult();//.setParameter("sequence", sequence)
    }

    @Override
    public MaClaCoef getLevelMatiere(Long idmat) throws DataAccessException {
         return (MaClaCoef)getManager().createNamedQuery("getLevelMatiere")
                .setParameter("idmat",idmat)
                .getSingleResult();
    }
}
