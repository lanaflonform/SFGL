/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.Notedao;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.entities.Notes;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public class NotedaoImpl extends GenericDao<Notes, Long>implements Notedao{
     @Override
    public List <Notes> findAllNotes() throws DataAccessException {
         return   getManager().createNamedQuery("Note.All")
               
                .getResultList();
    }
}
