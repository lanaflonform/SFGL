/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.rapport;

import com.lateu.projet.lycee.Enum.Appreciation;
import com.lateu.projet.lycee.Enum.Cycle;
import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.ClasseLevel;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.MaClaCoef;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.entities.Notes;
import com.lateu.projet.lycee.entities.Sequence;
import com.lateu.projet.lycee.projection.PV;
import com.lateu.projet.lycee.service.ServiceAnneeScolaire;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceClasseLevel;
import com.lateu.projet.lycee.service.ServiceEleve;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceMatiere;
import com.lateu.projet.lycee.service.ServiceSequence;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ing-lateu
 */
@ManagedBean
//@RequestScoped
@ViewScoped
public class Bulletinbean implements Serializable {
    
    @ManagedProperty(value = "#{ServiceEleve}")
    private ServiceEleve serviceEleve;
    @ManagedProperty(value = "#{ServiceClasse}")
    private ServiceClasse serviceClasse;
    @ManagedProperty(value = "#{ServiceAnneeScolaire}")
    private ServiceAnneeScolaire serviceAnneeScolaire;
    @ManagedProperty(value = "#{ServiceMatiere}")
    private ServiceMatiere serviceMatiere;
    @ManagedProperty(value = "#{ServiceClasseLevel}")
    private ServiceClasseLevel serviceClasseLevel;
    @ManagedProperty(value = "#{ServiceSequence}")
    private ServiceSequence serviceSequence;
    private List<ClasseLevel> classeLevels = new ArrayList<ClasseLevel>();
    private ClasseLevel classeLevelSelect = new ClasseLevel();
    private List<Matiere> matieres = new ArrayList<Matiere>();
    private List<Classe> classes = new ArrayList<Classe>();
    private List<Eleve> eleves = new ArrayList<Eleve>();
    private List<Sequence> sequences = new ArrayList<Sequence>();
    private List<AnneeScolaire> anneeScolaires = new ArrayList<AnneeScolaire>();
    private SelectItem[] listeNivSelect;
    private SelectItem[] listeClasseSelect;
    private SelectItem[] listeSequenceSelect;
    List<PV> listeLevel1;
    List<PV> listeLevel2;
    List<PV> listeLevel3;
    private PV pvIntry = new PV();
    private MaClaCoef mcc = new MaClaCoef();
    private ServletOutputStream output;
    private Long idClasse;
    private String codeAnnee;
    private List<Cycle> cycles = new ArrayList<Cycle>();
    private Cycle cycleSelected;
    private String niveau;
    private String sequencecode;
    private String classecode;
    private Color bg = Color.WHITE;
    private static final Font catFont = new Font(Font.TIMES_ROMAN, 8, Font.BOLD);
    private static final Font font = new Font(Font.TIMES_ROMAN, 6, Font.BOLD);
    private static final Font f = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
    private static final Font f1 = new Font(Font.TIMES_ROMAN, 10, Font.BOLD);
    private static final Font f2 = new Font(Font.TIMES_ROMAN, 10, Font.UNDERLINE);

    /**
     * Creates a new instance of Bulletinbean
     */
    public Bulletinbean() {
    }
    
    public ServletOutputStream getOutput() throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=PV.pdf");
        output = httpServletResponse.getOutputStream();
        return output;
    }
    
    private PdfPTable Banniere(String picture, Eleve e) throws ServiceException, ServiceException, ServiceException, DocumentException, BadElementException, MalformedURLException, IOException {
        
        PdfPTable table = new PdfPTable(4);
        PdfPCell vide = new PdfPCell(new Phrase("", catFont));
        PdfPCell cell1 = new PdfPCell(new Phrase("republique du cameroun", catFont));
        PdfPCell cell11 = new PdfPCell(new Phrase("MINSEC", catFont));
        PdfPCell cell2 = new PdfPCell(new Phrase("delegation des enseignements secondaires du nord", catFont));
        PdfPCell cell22 = new PdfPCell(new Phrase("lycee de avion me laisse", catFont));
        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        // cell1.setBorderColor(bg);
        table.addCell(cell1);
        table.addCell(vide);
        //table.addCell(vide);
        cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell2.setColspan(2);
        table.addCell(cell2);
        cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
        // cell11.setBorderColor(bg);
        table.addCell(cell11);
        // table.addCell(vide);
        table.addCell(vide);
        cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell22.setColspan(2);
        table.addCell(cell22);
        /**
         * ajout de la photo
         */
        PdfPCell cell3 = new PdfPCell(new Phrase("PREMIER-TRIMESTRE", new Font(Font.COURIER, 12, Font.BOLD, Color.DARK_GRAY)));
        String filename = "/home/ing-lateu/NetBeansProjects/SFGL/src/main/webapp/images/" + picture + ".jpg";
        
        Image image2 = Image.getInstance(filename);
        image2.scaleAbsolute(50, 50);
        PdfPCell cell4 = new PdfPCell(image2, false);
        
        String filename_d = "//home/ing-lateu/NetBeansProjects/SFGL/src/main/webapp/images/d.JPG";
        Image image_d = Image.getInstance(filename_d);
        image_d.scaleAbsolute(50, 50);
        PdfPCell cell5 = new PdfPCell(image_d, false);
        
        table.addCell(cell4);
        cell3.setColspan(2);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(cell3);
        ////cell2.setBorder(0);

        cell5.setPaddingLeft(50);
        table.addCell(cell5);
        
        
        
        PdfPCell cell61 = new PdfPCell(new Phrase("Nom et Prenom: " + e.getNom() + "-" + e.getPrenom(), catFont));
        PdfPCell vide2 = new PdfPCell(new Phrase(" ", catFont));
         vide2.setColspan(2);
         vide2.setBorder(0);
        PdfPCell cell62 = new PdfPCell(new Phrase("Né le " + e.getDateNais() + " à " + e.getLieuxNais(), catFont));
        
        PdfPCell cell63 = new PdfPCell(new Phrase("Redoublant: " + e.getRedoublant()));
        //table.addCell(vide2);
        PdfPCell cell64 = new PdfPCell(new Phrase("", catFont));
        cell64.setHorizontalAlignment(Element.ALIGN_LEFT);
        // cell64.setBorderColor(bg);
        cell61.setHorizontalAlignment(Element.ALIGN_LEFT);
        // cell61.setBorderColor(bg);
        cell61.setColspan(2);
        table.addCell(cell61);
        table.addCell(vide2);
        cell62.setHorizontalAlignment(Element.ALIGN_LEFT);
        //cell62.setBorderColor(bg);
         cell62.setColspan(2);
        table.addCell(cell62);
        table.addCell(vide2);
        cell63.setHorizontalAlignment(Element.ALIGN_LEFT);
        // cell63.setBorderColor(bg);
         cell63.setColspan(2);
        table.addCell(cell63);
        table.addCell(vide2);
        
        
        
        return table;
        
    }

    /**
     *
     * @param codeClasse
     * @param level
     * @return un tableau contenant les matieres du premier groupe d'un bulletin
     * @throws ServiceException
     * @throws DocumentException
     */
    public PdfPTable Groupe(List<PV> l) throws ServiceException, DocumentException {
        PdfPTable table2 = new PdfPTable(6);
        
        PdfPCell cell1 = new PdfPCell(new Phrase("Enseignant", catFont));
        cell1.setBackgroundColor(Color.GRAY);
        table2.addCell(cell1);
        PdfPCell cell2 = new PdfPCell(new Phrase("Matiére", catFont));
        cell2.setBackgroundColor(Color.GRAY);
        table2.addCell(cell2);
        
        PdfPCell cell3 = new PdfPCell(new Phrase("Note", catFont));
        cell3.setBackgroundColor(Color.GRAY);
        table2.addCell(cell3);
        PdfPCell cell4 = new PdfPCell(new Phrase("Coéficient", catFont));
        cell4.setBackgroundColor(Color.GRAY);
        table2.addCell(cell4);
        
        PdfPCell cell5 = new PdfPCell(new Phrase("NotexCoef", catFont));
        cell5.setBackgroundColor(Color.GRAY);
        table2.addCell(cell5);
        
        PdfPCell cell6 = new PdfPCell(new Phrase("Appreciation", catFont));
        cell6.setBackgroundColor(Color.GRAY);
        table2.addCell(cell6);
        // List<ReportEntry> l = serviceEleve.maSectionBulletin(codeClasse, level);
        for (PV pv : l) {
            ajouterLingne(table2, pv);
            
        }
        
        return table2;
        
    }

    /**
     * generation des bulletins d'une classe donnée en parametre
     *
     * @throws FileNotFoundException
     * @throws BadElementException
     * @throws MalformedURLException
     * @throws IOException
     * @throws DocumentException
     * @throws ServiceException
     */
    public void createBulletin() throws FileNotFoundException, BadElementException, MalformedURLException, IOException, DocumentException, ServiceException {
        Document document = new Document(PageSize.A4);
        
        PdfWriter.getInstance(document, getOutput());
        document.open();
        int i;
        String level;
        matieres = serviceMatiere.findMatiereByClasseCode(classecode);
        System.out.println("--------------matiere size" + matieres.size());
        String matricule;
        
        eleves = serviceClasse.FindByClasse(serviceClasse.findByCode(classecode).getId(), codeAnnee);
        
        
        for (Eleve eleve : eleves) {
            listeLevel1 = new ArrayList<PV>();
            listeLevel2 = new ArrayList<PV>();
            listeLevel3 = new ArrayList<PV>();
            matricule = eleve.getMatricule();
            for (Matiere m : matieres) {
                
                List< PV> lstepv = serviceEleve.GeneralPV(eleve.getMatricule(), m.getId());
                if (lstepv.isEmpty()) {
                    System.out.println("++++++++++++++++++++++++++++++++++++++");
                    System.out.println("++++++++++++" + cycleSelected.ordinal() + "++++++++++++");
                    
                    mcc = serviceEleve.getLevelMat(m.getId());
                    level = mcc.getLevelMatiere();
                    Notes n = new Notes(0.0, Appreciation.MEDIOCRE);
                    pvIntry = new PV(n, m.getIntitule(), mcc, 0.0);
                    if (level.equals("1")) {
                        listeLevel1.add(pvIntry);
                    }
                    
                    if (level.equals("2")) {
                        listeLevel2.add(pvIntry);
                    }
                    
                    if (level.equals("3")) {
                        listeLevel3.add(pvIntry);
                    }
                    
                }
                
                for (PV pv : lstepv) {
                    if (pv != null) {
                        
                        
                        if (pv.getMaClaCoef().getLevelMatiere().equals("1")) {
                            listeLevel1.add(pv);
                        }
                        
                        
                        if (pv.getMaClaCoef().getLevelMatiere().equals("2")) {
                            listeLevel2.add(pv);
                        }
                        
                        
                        if (pv.getMaClaCoef().getLevelMatiere().equals("3")) {
                            listeLevel3.add(pv);
                        }
                        
                    } else {
                    }
                }
                
                
                
                
                
                
            }

            //document.add(EnteteBuletin());

            document.add(Banniere(matricule, eleve));
            Paragraph p = new Paragraph(new Phrase("MATIERE DU PREMIER GROUPE", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE)));
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(Groupe(listeLevel1));
            document.add(MoyennePartielle(listeLevel1));
            
            
            Paragraph p1 = new Paragraph(new Phrase("MATIERE DU DEUXIEME GROUPE", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE)));
            p1.setAlignment(Element.ALIGN_CENTER);
            document.add(p1);
            
            document.add(Groupe(listeLevel2));
            document.add(MoyennePartielle(listeLevel2));
            
            Paragraph p3 = new Paragraph(new Phrase("MATIERE DU TROISIEME GROUPE", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE)));
            p3.setAlignment(Element.ALIGN_CENTER);
            document.add(p3);
            
            
            document.add(Groupe(listeLevel3));
            document.add(MoyennePartielle(listeLevel3));
            document.newPage();
            
        }

// }
        document.close();
        
    }

    /**
     * ajoute une ligne au bulletin
     *
     * @param table2
     * @param entree
     * @throws DocumentException
     */
    public void ajouterLingne(PdfPTable table2, Object p) throws DocumentException {
        PV pv = (PV) p;
        PdfPCell cell1 = new PdfPCell(new Phrase("lateu-richard ", catFont));
        //cell1.setBackgroundColor(Color.GRAY);
        table2.addCell(cell1);
        
        
        PdfPCell cell2 = new PdfPCell(new Phrase(pv.getMatiere(), catFont));
        //cell2.setBackgroundColor(Color.GRAY);
        table2.addCell(cell2);
        
        PdfPCell cell3 = new PdfPCell(new Phrase(pv.getNote().getNote() + "", catFont));
        // cell3.setBackgroundColor(Color.GRAY);
        table2.addCell(cell3);
        
        PdfPCell cell4 = new PdfPCell(new Phrase(pv.getMaClaCoef().getCoeficient() + "", catFont));
        table2.addCell(cell4);
        
        PdfPCell cell5 = new PdfPCell(new Phrase(pv.getNote_coef() + "", catFont));
        table2.addCell(cell5);
        
        PdfPCell cell6 = new PdfPCell(new Phrase(pv.getNote().getAppreciation().toString(), catFont));
        table2.addCell(cell6);
        
    }
    
    public PdfPTable MoyennePartielle(List<PV> l) {
        PdfPTable table = new PdfPTable(8);
        // table.setWidthPercentage(50);
        //table.setSpacingBefore(0);
        //table.setHorizontalAlignment(1);
        table.spacingBefore();
        double totalCoefficier = 0;
        double moy = 0.0;
        int coef = 0;
        for (PV pv : l) {
            totalCoefficier = totalCoefficier + pv.getNote_coef();
            coef = coef + pv.getMaClaCoef().getCoeficient();
        }
        
        moy = totalCoefficier / coef;
        
        
        PdfPCell cell1 = new PdfPCell(new Phrase("T-coefficier", catFont));
        cell1.setBackgroundColor(Color.LIGHT_GRAY);
        cell1.setLeft(-2);
        table.addCell(cell1);
        
        PdfPCell cell2 = new PdfPCell(new Phrase("" + totalCoefficier, catFont));
        table.addCell(cell2);
        
        
        PdfPCell vide = new PdfPCell(new Phrase("", catFont));
        vide.setColspan(6);
        vide.setBorder(0);
        table.addCell(vide);
        
        PdfPCell cell3 = new PdfPCell(new Phrase("T-coef", catFont));
        cell3.setBackgroundColor(Color.LIGHT_GRAY);
        table.addCell(cell3);
        
        PdfPCell cell4 = new PdfPCell(new Phrase("" + coef, catFont));
        table.addCell(cell4);
        vide.setColspan(6);
        vide.setBorderColor(Color.WHITE);
        table.addCell(vide);
        
        PdfPCell cell5 = new PdfPCell(new Phrase("moyenne", catFont));
        cell5.setBackgroundColor(Color.LIGHT_GRAY);
        table.addCell(cell5);
        
        PdfPCell cell6 = new PdfPCell(new Phrase("" + moy, catFont));
        
        table.addCell(cell6);
        vide.setColspan(6);
        vide.setBorderColor(Color.WHITE);
        table.addCell(vide);
        
        return table;
    }
    
    public ServiceEleve getServiceEleve() {
        return serviceEleve;
    }
    
    public void setServiceEleve(ServiceEleve serviceEleve) {
        this.serviceEleve = serviceEleve;
    }
    
    public Color getBg() {
        return bg;
    }
    
    public void setBg(Color bg) {
        this.bg = bg;
    }
    
    public ServiceClasse getServiceClasse() {
        return serviceClasse;
    }
    
    public void setServiceClasse(ServiceClasse serviceClasse) {
        this.serviceClasse = serviceClasse;
    }
    
    public List<Classe> getClasses() throws ServiceException {
        return classes;
    }
    
    public void setClasses(List<Classe> classe) {
        this.classes = classe;
    }
    
    public List<AnneeScolaire> getAnneeScolaires() throws ServiceException {
        return anneeScolaires = serviceAnneeScolaire.findAll();
    }
    
    public void setAnneeScolaires(List<AnneeScolaire> anneeScolaires) {
        this.anneeScolaires = anneeScolaires;
    }
    
    public ServiceAnneeScolaire getServiceAnneeScolaire() {
        return serviceAnneeScolaire;
    }
    
    public void setServiceAnneeScolaire(ServiceAnneeScolaire serviceAnneeScolaire) {
        this.serviceAnneeScolaire = serviceAnneeScolaire;
    }
    
    public String getCodeAnnee() {
        return codeAnnee;
    }
    
    public void setCodeAnnee(String codeAnnee) {
        this.codeAnnee = codeAnnee;
    }
    
    public ServiceMatiere getServiceMatiere() {
        return serviceMatiere;
    }
    
    public void setServiceMatiere(ServiceMatiere serviceMatiere) {
        this.serviceMatiere = serviceMatiere;
    }
    
    public List<Matiere> getMatieres() {
        return matieres;
    }
    
    public void setMatieres(List<Matiere> matieres) {
        this.matieres = matieres;
    }
    
    public List<Eleve> getEleves() {
        return eleves;
    }
    
    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }
    
    public PV getPvIntry() {
        return pvIntry;
    }
    
    public void setPvIntry(PV pvIntry) {
        this.pvIntry = pvIntry;
    }
    
    public MaClaCoef getMcc() {
        return mcc;
    }
    
    public void setMcc(MaClaCoef mcc) {
        this.mcc = mcc;
    }
    
    public Long getIdClasse() {
        return idClasse;
    }
    
    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }
    
    public List<Cycle> getCycles() {
        cycles.add(Cycle.Premiere_Cycle);
        cycles.add(Cycle.Second_Cycle);
        return cycles;
    }
    
    public void setCycles(List<Cycle> cycles) {
        this.cycles = cycles;
    }
    
    public Cycle getCycleSelected() {
        return cycleSelected;
    }
    
    public void setCycleSelected(Cycle cycleSelected) {
        this.cycleSelected = cycleSelected;
    }
    
    public void handleCycleChange() {
        if (cycleSelected != null) {
            
            classeLevels = serviceClasseLevel.findbyCycleId(cycleSelected);
            System.out.println("-----------" + classeLevels + "--------");
        } else {
            System.out.println("-----------c est bon--------");
            classeLevels = new ArrayList<ClasseLevel>();
        }
        
    }
    
    public void handleNiveauChange() throws ServiceException {
        if (niveau != null) {
            
            classes = serviceClasse.findByNiveau(niveau);
            System.out.println("-----------" + classes + "--------");
        } else {
            System.out.println("-----------c est bon--------");
            classes = new ArrayList<Classe>();
        }
        
    }
    
    public ServiceClasseLevel getServiceClasseLevel() {
        return serviceClasseLevel;
    }
    
    public void setServiceClasseLevel(ServiceClasseLevel serviceClasseLevel) {
        this.serviceClasseLevel = serviceClasseLevel;
    }
    
    public List<ClasseLevel> getClasseLevels() {
        return classeLevels;
    }
    
    public void setClasseLevels(List<ClasseLevel> classeLevels) {
        this.classeLevels = classeLevels;
    }
    
    public ClasseLevel getClasseLevelSelect() {
        return classeLevelSelect;
    }
    
    public void setClasseLevelSelect(ClasseLevel classeLevelSelect) {
        this.classeLevelSelect = classeLevelSelect;
    }
    
    public SelectItem[] getListeNivSelect() {
        classeLevels = serviceClasseLevel.findbyCycleId(cycleSelected);
        listeNivSelect = new SelectItem[classeLevels.size() + 1];
        listeNivSelect[0] = new SelectItem("choisir");
        
        for (int i = 1; i < classeLevels.size() + 1; i++) {
            listeNivSelect[i] = new SelectItem(classeLevels.get(i - 1).getNiveau());
        }
        return listeNivSelect;
    }
    
    public void setListeNivSelect(SelectItem[] listeNivSelect) {
        this.listeNivSelect = listeNivSelect;
    }
    
    public SelectItem[] getListeClasseSelect() throws ServiceException {
        classes = serviceClasse.findByNiveau(niveau);
        listeClasseSelect = new SelectItem[classes.size() + 1];
        listeClasseSelect[0] = new SelectItem("choisir");
        
        for (int i = 1; i < classes.size() + 1; i++) {
            listeClasseSelect[i] = new SelectItem(classes.get(i - 1).getCode());
        }
        return listeClasseSelect;
    }
    
    public void setListeClasseSelect(SelectItem[] listeClasseSelect) {
        this.listeClasseSelect = listeClasseSelect;
    }
    
    public String getNiveau() {
        return niveau;
    }
    
    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }
    
    public ServiceSequence getServiceSequence() {
        return serviceSequence;
    }
    
    public void setServiceSequence(ServiceSequence serviceSequence) {
        this.serviceSequence = serviceSequence;
    }
    
    public SelectItem[] getListeSequenceSelect() throws ServiceException {
        sequences = serviceSequence.findAll();
        listeSequenceSelect = new SelectItem[sequences.size() + 1];
        listeSequenceSelect[0] = new SelectItem("choisir");
        
        for (int i = 1; i < sequences.size() + 1; i++) {
            listeSequenceSelect[i] = new SelectItem(sequences.get(i - 1).getIntitule());
        }
        
        return listeSequenceSelect;
    }
    
    public void setListeSequenceSelect(SelectItem[] listeSequenceSelect) {
        this.listeSequenceSelect = listeSequenceSelect;
    }
    
    public List<Sequence> getSequences() {
        return sequences;
    }
    
    public String getSequencecode() {
        return sequencecode;
    }
    
    public String getClassecode() {
        return classecode;
    }
    
    public void setClassecode(String classecode) {
        this.classecode = classecode;
    }
    
    public void setSequencecode(String sequencecode) {
        this.sequencecode = sequencecode;
    }
}