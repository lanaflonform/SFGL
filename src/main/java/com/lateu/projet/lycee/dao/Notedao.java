/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.IDao;
import com.lateu.projet.lycee.entities.Notes;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public interface Notedao  extends IDao<Notes, Long>{
     List<Notes> findAllNotes()throws DataAccessException; 
}
