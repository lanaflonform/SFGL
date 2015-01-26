/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.dao.FraisCumuledao;
import com.lateu.projet.lycee.entities.FraisCumule;
import com.lateu.projet.lycee.entities.FraisDiver;
import com.lateu.projet.lycee.service.ServiceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author lateu
 */
@Transactional
public class ServiceFraisCumuleImpl implements com.lateu.projet.lycee.service.ServiceFraisCumule{
private FraisCumuledao fraisCumuledao;
    @Override
    public List<FraisCumule>findFraisCumule(Long iden) throws ServiceException {
  
        //return fraisCumuledao.findCumule(iden);
        return null;
    
    }

    public FraisCumuledao getFraisCumuledao() {
        return fraisCumuledao;
    }

    public void setFraisCumuledao(FraisCumuledao fraisCumuledao) {
        this.fraisCumuledao = fraisCumuledao;
    }

    @Override
    public void create(FraisCumule fc, FraisDiver fd) throws ServiceException {
//        FraisCumule old=(FraisCumule)fraisCumuledao.findCumule(fd.getId());
//        if(old!=null){
//    try {
//        fc.setFrais(fd);
//        
//        Long t=0L;
//        t=old.getTotal();
//       fc.setTotal(t+fd.getMontant());
//        fraisCumuledao.create(fc);
//    } catch (DataAccessException ex) {
//        Logger.getLogger(ServiceFraisCumuleImpl.class.getName()).log(Level.SEVERE, null, ex);
//    }
//        }else{
//        
//         try {
//        fc.setFrais(fd);
//        fraisCumuledao.create(fc);
//    } catch (DataAccessException ex) {
//        Logger.getLogger(ServiceFraisCumuleImpl.class.getName()).log(Level.SEVERE, null, ex);
//    }
//        
//        }
    }

  
}
