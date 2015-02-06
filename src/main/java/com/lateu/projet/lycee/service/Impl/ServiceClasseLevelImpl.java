/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.Enum.Cycle;
import com.lateu.projet.lycee.dao.ClasseLeveldao;
import com.lateu.projet.lycee.entities.ClasseLevel;
import com.lateu.projet.lycee.service.ServiceClasseLevel;
import com.lateu.projet.lycee.service.ServiceException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author ing-lateu
 */
@Transactional
public class ServiceClasseLevelImpl  implements ServiceClasseLevel{
private ClasseLeveldao classeLeveldao;
    @Override
    public void save(ClasseLevel clevel)throws ServiceException  {
    try {
        classeLeveldao.create(clevel);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceClasseLevelImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    public ClasseLeveldao getClasseLeveldao() {
        return classeLeveldao;
    }

    public void setClasseLeveldao(ClasseLeveldao classeLeveldao) {
        this.classeLeveldao = classeLeveldao;
    }

    @Override
    public List<ClasseLevel> findbyCycleId(Cycle  c) {
    try {
        return classeLeveldao.findByCycleId(c);
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceClasseLevelImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }

    @Override
    public List<ClasseLevel> findAll() throws ServiceException {
    try {
        return classeLeveldao.findAll();
    } catch (DataAccessException ex) {
        Logger.getLogger(ServiceClasseLevelImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
    }
    
}
