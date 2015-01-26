/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.dao.Impl;

import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.EmploiDeTempsdao;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.EmploiDeTemps;
import java.util.List;

/**
 *
 * @author ing-lateu
 */
public class EmploiDeTempsdaoImpl extends GenericDao<EmploiDeTemps, Long> implements EmploiDeTempsdao {

    @Override
    public List<EmploiDeTemps> ValiderEmplo(Long idClasse, Long idMatiere, String jour) throws DataAccessException {

        return getManager().createNamedQuery("ValiderEmploi")
                .setParameter("idClasse", idClasse)
                .setParameter("idMatiere", idMatiere)
                .setParameter("jour", jour)
                .getResultList();

    }
}
