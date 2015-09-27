package com.lateu.projet.lycee;
import com.douwe.generic.dao.DataAccessException;
import com.douwe.generic.dao.impl.GenericDao;
import com.lateu.projet.lycee.dao.Classedao;
import com.lateu.projet.lycee.dao.Elevedao;
import com.lateu.projet.lycee.dao.Impl.ClassedaoImpl;
import com.lateu.projet.lycee.dao.Impl.ElevedaoImpl;
import com.lateu.projet.lycee.dao.Impl.MatieredaoImpl;
import com.lateu.projet.lycee.dao.Matieredao;
import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.entities.Notes;

import com.lateu.projet.lycee.service.ServiceException;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
//    private static ServiceEleve serveleve;
//    private static ServiceNationalite servnat;
//    private static ServiceClasse servcla;
//    private static ServiceAnneeScolaire servannee;
//    private static ServiceNote servnote;
//    private static ServiceMatiere servmat;
//    private static ServiceTrimestre servtrim;
//    private static ServiceSequence servseq;
//     private static ServiceMaClaCoef servmcf;
    public static void main( String[] args ) throws DataAccessException, ServiceException
    {
//         ApplicationContext ctx = new ClassPathXmlApplicationContext("Spring-conf.xml");
//        serveleve= (ServiceEleve) ctx.getBean("ServiceEleve");
//        servnat= (ServiceNationalite) ctx.getBean("ServiceNationalite");
//        servcla= (ServiceClasse) ctx.getBean("ServiceClasse");
//        servannee= (ServiceAnneeScolaire) ctx.getBean("ServiceAnneeScolaire");
//       servnote= (ServiceNote) ctx.getBean("ServiceNote");
//       servmat= (ServiceMatiere) ctx.getBean("ServiceMatiere");
//       servtrim= (ServiceTrimestre) ctx.getBean("ServiceTrimestre");
//       servseq= (ServiceSequence) ctx.getBean("ServiceSequence");
//       servmcf= (ServiceMaClaCoef) ctx.getBean("ServiceMaClaCoef");
//        
       EntityManagerFactory emf = Persistence.createEntityManagerFactory("LyceePU");
       EntityManager em=emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
      tx.begin();
      Elevedao eldao=new ElevedaoImpl();
       Classedao cldao=new ClassedaoImpl();
        Matieredao mtdao=new MatieredaoImpl();
      ((GenericDao) eldao).setManager(em);
       ((GenericDao) cldao).setManager(em);
       ((GenericDao) mtdao).setManager(em);
       Date d=new Date();
        Date dt=new Date();
        AnneeScolaire an=new AnneeScolaire(dt, dt, "13/14");
       Calendar c=Calendar.getInstance();
       c.set(2013, 11, 25);
//        Nationalite nat=new Nationalite("Cameroun");
        Classe cl=new Classe("PC");

       // Eleve el=new Eleve("9999554","lvkc", "klpio","jnlbtohyt","lhneuo", "bjsdfbn", "07v721","hgrf54", "juopat", "both", dt,"F", "eleve");
//        Eleve e=new Eleve();
//        e.setAnnee(an);
//        e.setClasse(cl);
//        e.setNationalite(nat);
//        e.setContactPrarent("0174d5f");
//        e.setMatricule("07v120");
//        e.setNom("lateu");
    
//        Motif m=new  Motif("APE", 15000L);
//        FraisDiver fr=new FraisDiver(el,an,m,d,"APE", 15000L);
//        Historique h=new Historique(fr.getMontant(),fr);
        
        Matiere mat=new Matiere("PCT");
      

        
    //    MaClaCoef coef=new MaClaCoef(2L,"25h");
        // Professeur pf=new Professeur(dt, null, null, "manque", "tantine", null, null, dt, "F", null);
         //Dispense en=new Dispense(pf, mat);
         
//        em.persist(nat);
//        em.persist(mat);
//        em.persist(pf);
//        em.persist(en);
//        em.persist(coef);
//        em.persist(cl);
//        em.persist(an);
//        em.persist(el);
//        em.persist(tr);
//        em.persist(sq);
//        em.persist(n);
          // em.persist(mat);
//            em.persist(fr);
//            em.persist(h);
           
            
          //em.persist(pf);
      
//         List<Bulletin> tmp= eldao.GenerateBulletin("07v120");
//        for (Iterator<Bulletin> it = tmp.iterator(); it.hasNext();) {
//            Bulletin b = it.next();
//            System.out.println(b);
//        }
       
       //  System.out.println(cldao.SommeCoef("TleC"));
 
         
       //cldao.MatiereValide("MATH", "TleC");
         //eldao.findElevebyNom("mbut");
         //System.out.println();
        tx.commit();
       em.close();
        emf.close();
      
      
    //  servmcf.create("EPS","TleC", 2L,"40h"); 
       // servtrim.create(tr);
         //servannee.create(an);
         // servcla.create(cl);
         // servnat.create(nat);
         //serveleve.create(el,1L,"Cameroun","PC");
        // servmat.create(mat);
       //  servseq.create(sq, "1er-trimestre", 1L);
         //   servnote.create(n, "07v721", "sequence3", "MATH",1L);
    }
}
