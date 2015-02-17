/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.Enum.Cycle;
import com.lateu.projet.lycee.entities.ClasseLevel;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public interface ServiceClasseLevel {
    
    public void save(ClasseLevel clevel)throws ServiceException;
    public List<ClasseLevel>findbyCycleId(Cycle c);
    public List<ClasseLevel>findAll()throws ServiceException;
    public ClasseLevel findbyId(Long c);
    
}
