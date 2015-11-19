/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.Matieredao;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.MaClaCoef;
import com.lateu.projet.lycee.entities.Matiere;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public class MatieredaoImpl extends GenericDao<Matiere, Long>implements Matieredao{

    @Override
    public Matiere findMatierebyIntitule(String intitule) throws DataAccessException {
         return  (Matiere) getManager().createNamedQuery("findMatierebyIntitule")
                .setParameter("intitule", intitule)
                .getSingleResult();
    }

    @Override
    public  MaClaCoef findCoef(String matiere,String classe) throws DataAccessException {
    return   (MaClaCoef)getManager().createNamedQuery("findCoef")
                .setParameter("matiere", matiere)
                .setParameter("classe", classe)
                .getSingleResult();
    }

    @Override
    public List<Matiere> findMatiereByClassecode(String idClasse) throws DataAccessException {
         return   getManager().createNamedQuery("findMatiereByClasseCode")
                .setParameter("codeClasse", idClasse)
                .getResultList();
    
    }

   
}
