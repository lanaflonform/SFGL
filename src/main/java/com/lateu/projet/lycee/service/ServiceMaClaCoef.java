/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.service;

import com.lateu.projet.lycee.entities.MaClaCoef;
import java.util.List;

/**
 *
 * @author richardlateu
 */
public interface ServiceMaClaCoef {
   
    public void create(MaClaCoef mcf, String matiere, String classe, Long idEns)throws ServiceException;
    public  List<MaClaCoef> findAll()throws ServiceException;
     MaClaCoef getLevelMat(Long idMatiere,Long idClasse)  throws ServiceException;
}
