/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.FraisDiverdao;
import com.lateu.projet.lycee.entities.FraisCumule;
import com.lateu.projet.lycee.entities.FraisDiver;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public class FraisDiverdaoImpl extends GenericDao<FraisDiver, Long>implements FraisDiverdao{
      @Override
    public List<FraisCumule> findCumule(Long iden) {
        try {
            return  getManager().createNamedQuery("findFraisCumule")
                   .setParameter("iden", iden)
                   .getResultList();
        } catch (DataAccessException ex) {
            return null;
           // Logger.getLogger(FraisCumuledaoImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
