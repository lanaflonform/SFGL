/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.Test;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.entities.Motif;
import com.lateu.projet.lycee.entities.Nationalite;
import com.lateu.projet.lycee.entities.Notes;
import com.lateu.projet.lycee.entities.Sequence;
import com.lateu.projet.lycee.projection.PV;

import com.lateu.projet.lycee.service.ServiceAnneeScolaire;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceEleve;
import com.lateu.projet.lycee.service.ServiceEmploi;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceFraisCumule;
import com.lateu.projet.lycee.service.ServiceFraisDivers;
import com.lateu.projet.lycee.service.ServiceInitLycee;
import com.lateu.projet.lycee.service.ServiceMaClaCoef;
import com.lateu.projet.lycee.service.ServiceMatiere;
import com.lateu.projet.lycee.service.ServiceNationalite;
import com.lateu.projet.lycee.service.ServiceNote;
import com.lateu.projet.lycee.service.ServiceSequence;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author lateu
 */
public class TestService {

    private static ServiceEleve serveleve;
    private static ServiceNationalite servnat;
    private static ServiceClasse servcla;
    private static ServiceAnneeScolaire servannee;
    private static ServiceNote servnote;
    private static ServiceMatiere servmat;
    private static ServiceSequence servseq;
    private static ServiceMaClaCoef servmcf;
    private static ServiceInitLycee servLycee;
    private static ServiceFraisCumule serviceFraisCum;
    private static ServiceEmploi serviceEmploi;
    private static ServiceFraisDivers serviceFraisD;

    public static void main(String[] args) throws DataAccessException, ServiceException {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-conf.xml");
        serveleve = (ServiceEleve) ctx.getBean("ServiceEleve");
        servnat = (ServiceNationalite) ctx.getBean("ServiceNationalite");
        servcla = (ServiceClasse) ctx.getBean("ServiceClasse");
        servannee = (ServiceAnneeScolaire) ctx.getBean("ServiceAnneeScolaire");
        servnote = (ServiceNote) ctx.getBean("ServiceNote");
        servmat = (ServiceMatiere) ctx.getBean("ServiceMatiere");
        servseq = (ServiceSequence) ctx.getBean("ServiceSequence");
        servmcf = (ServiceMaClaCoef) ctx.getBean("ServiceMaClaCoef");
        servLycee = (ServiceInitLycee) ctx.getBean("ServiceInitLycee");
        serviceFraisCum = (ServiceFraisCumule) ctx.getBean("ServiceFraisCumule");
        serviceFraisD = (ServiceFraisDivers) ctx.getBean("ServiceFraisDivers");
        serviceEmploi = (ServiceEmploi) ctx.getBean("ServiceEmploi");
        Date d = new Date();
        Date dt = new Date();
        AnneeScolaire an = new AnneeScolaire(dt, dt, "2013/2014");
        Calendar c = Calendar.getInstance();
        c.set(2013, 11, 25);
        Nationalite nat = new Nationalite("Cameroun", "CMR");
        Classe cl = new Classe("PC");
        //  FraisDiver fd=serviceFraisD.findByID(1L);

        // FraisCumule fc=new FraisCumule(25000, fd);
        //  serviceFraisCum.create(fc, fd);
        //  System.out.println("====="+serviceFraisCum.findFraisCumule(1L));
        // Eleve el = new Eleve("9999554", "lvkc", "klpio", "bjsdfbn", "07v721", "hgrf54", "juopat", "both", dt, "F", "eleve");
//Eleve el=new Eleve(nat, cl, an, null, null, null, null, null, null, null, null, dt, null, null);
        Motif m = new Motif("APE", 15000L);
        // FraisDiver fr = new FraisDiver(el, an, m, d, "APE", 15000L);
        // Historique h=new Historique(fr.getMontant(),fr);
        //Sequence sq=new Sequence("sequence1");
        Matiere mat = new Matiere("PCT");
        Notes n = new Notes(15);


        //    MaClaCoef coef=new MaClaCoef(2L,"25h");
        //Professeur pf = new Professeur(dt, null, null, "manque", "tantine", null, null, dt, "F", null);
        //Dispense en = new Dispense(pf, mat);


       // List<EmploiDeTemps> tmp = serviceEmploi.Valider(1L, 1L, "LUNDI");
        //  System.out.println(serveleve.LastIndex(tmp));

        //List<Matiere> mt=servmat.findMatiereByClasseID(2L);
       
           // System.out.println("===================="+mt.size()); 
        
       
       // servnote.create(n, "14L2", "seq1", "Chimie",1L);
        
//         List<Eleve> elvs= servcla.FindByClasse("PC", "2014/2015");
//        for (Eleve e : elvs) {
//            System.out.println(e);    
//        }
//        
//        List<PV> liste= serveleve.GeneralPV("14L2");
//        for (PV pv : liste) {
//            System.out.println(pv);    
//        }
       

        //cldao.MatiereValide("MATH", "TleC");
        //eldao.findElevebyNom("mbut");
        // System.out.println(servcla.findBylibele("PC"));

        //  servmcf.create("EPS","TleC", 2L,"40h"); 
        // servtrim.create(tr);
        //    servannee.create(an);
        //servcla.create(cl);
        // servLycee.create(lycee);
        //servnat.create(nat);
        //  serveleve.create(el,"13/14","Cameroun","PC");
        // servmat.create(mat);
         // servseq.create(sq, "1er-trimestre", 1L);
         
    }
}
