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
import com.lateu.projet.lycee.service.ServiceMaClaCoef;
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
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Collections;
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
    @ManagedProperty(value = "#{ServiceMaClaCoef}")
    private ServiceMaClaCoef serviceMaClaCoef;
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
    private List<PV> listeLevel1;
    private List<PV> listeLevel2;
    private List<PV> listeLevel3;
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
    private boolean niveauDisplay = true;
    private boolean classeDisplay = true;
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

    private PdfPTable Banniere(String log_lycee, Eleve e) throws ServiceException, ServiceException, ServiceException, DocumentException, BadElementException, MalformedURLException, IOException {

        PdfPTable table = new PdfPTable(3);
        PdfPCell vide = new PdfPCell(new Phrase("", catFont));
        PdfPCell cell1 = new PdfPCell(new Phrase("republique du cameroun\n MINSEC\n DRES de l'Extreme-Nord \n DDES du Diamaré\nLycee de avion me laisse ", catFont));

        cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell1.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell1);

        /**
         * ajout de la photo
         */
        // PdfPCell cell3 = new PdfPCell(new Phrase("PREMIER-TRIMESTRE", new Font(Font.COURIER, 12, Font.BOLD, Color.DARK_GRAY)));
        String filename = "/home/ing-lateu/NetBeansProjects/SFGL/src/main/webapp/resources/images/" + log_lycee + ".JPG";
        Image image2 = Image.getInstance(filename);
        image2.scaleAbsolute(40, 40);
        PdfPCell cell2 = new PdfPCell(image2, false);
        cell2.setPaddingTop(2);
        cell2.setPaddingLeft(50);
        cell2.setPaddingRight(50);
        cell2.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell2);

        PdfPCell cell3 = new PdfPCell(new Phrase("republique du cameroun\n MINSEC\n DRES de l'Extreme-Nord \n DDES du Diamaré\nLycee de avion me laisse ", catFont));
        cell3.setColspan(2);
        cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell3.setBorder(Rectangle.NO_BORDER);
        table.addCell(cell3);

        return table;

    }

    private PdfPTable IdentificationEleve(Eleve e) throws ServiceException, ServiceException, ServiceException, DocumentException, BadElementException, MalformedURLException, IOException {

        PdfPTable table = new PdfPTable(3);


        PdfPCell cell10 = new PdfPCell(new Phrase("Nom et Prenom: ", catFont));
        cell10.setBackgroundColor(Color.LIGHT_GRAY);
        table.addCell(cell10);
        PdfPCell cell11 = new PdfPCell(new Phrase("" + e.getNom() + "-" + e.getPrenom(), catFont));
        PdfPCell vide = new PdfPCell();
        table.addCell(cell11);
        //table.addCell(vide);

        String filename_d = "/home/ing-lateu/NetBeansProjects/SFGL/src/main/webapp/resources/images/" + e.getMatricule() + ".jpg";
        Image image_d = Image.getInstance(filename_d);
        image_d.scaleAbsolute(60, 60);
        PdfPCell cell_image = new PdfPCell(image_d, false);
        cell_image.setPadding(5);
        cell_image.setRowspan(5);
        cell_image.setHorizontalAlignment(Rectangle.ALIGN_RIGHT);
        table.addCell(cell_image);


        PdfPCell cell20 = new PdfPCell(new Phrase("Date et Lieu de Naissance ", catFont));
        cell20.setBackgroundColor(Color.LIGHT_GRAY);
        table.addCell(cell20);
        PdfPCell cell21 = new PdfPCell(new Phrase("" + e.getDateNais() + " à " + e.getLieuxNais(), catFont));
        table.addCell(cell21);


        PdfPCell cell30 = new PdfPCell(new Phrase("Classe: ", catFont));
        cell30.setBackgroundColor(Color.LIGHT_GRAY);
        table.addCell(cell30);
        PdfPCell cell31 = new PdfPCell(new Phrase("" + e.getClasse().getLibele()));
        table.addCell(cell31);

        PdfPCell cell40 = new PdfPCell(new Phrase("Redoublant: ", catFont));
        cell40.setBackgroundColor(Color.LIGHT_GRAY);
        table.addCell(cell40);
        PdfPCell cell41 = new PdfPCell(new Phrase("" + e.getRedoublant()));
        table.addCell(cell41);

        PdfPCell cell50 = new PdfPCell(new Phrase("Année scolaire: ", catFont));
        cell50.setBackgroundColor(Color.LIGHT_GRAY);
        table.addCell(cell50);
        PdfPCell cell51 = new PdfPCell(new Phrase("" + e.getAnnee().getCode()));
        table.addCell(cell51);

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
        //int i;
        int coef_Cl = 0;
        double nte_coef = 0;
        double moyen = 0;
        String levl;
        matieres = serviceMatiere.findMatiereByClassecode(classecode);
        System.out.println("--------------matiere size" + matieres.size());
        String mat;
        Classe cc = new Classe();
        cc = serviceClasse.findByCode(classecode);
        eleves = serviceClasse.FindByClasse(cc.getId(), codeAnnee);


        for (Eleve e : eleves) {
            listeLevel1 = new ArrayList<PV>();
            listeLevel2 = new ArrayList<PV>();
            listeLevel3 = new ArrayList<PV>();
            mat = e.getMatricule();
            for (Matiere m : matieres) {

                List< PV> lstepv = serviceEleve.GeneralPV(e.getMatricule(), m.getId());
                if (lstepv.isEmpty()) {
                    System.out.println("++++++++++++++++++++++++++++++++++++++");
                    System.out.println("++++++++++++" + cycleSelected.ordinal() + "++++++++++++");

                    mcc = serviceMaClaCoef.getLevelMat(m.getId(), cc.getId());
                    levl = mcc.getLevelMatiere();
                    Notes n = new Notes(0.0, Appreciation.MEDIOCRE);
                    pvIntry = new PV(n, m.getIntitule(), mcc, 0.0);
                    if (levl.equals("1")) {
                        listeLevel1.add(pvIntry);
                    }

                    if (levl.equals("2")) {
                        listeLevel2.add(pvIntry);
                    }

                    if (levl.equals("3")) {
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


            coef_Cl = CoefByClasse(listeLevel1, listeLevel2, listeLevel3);
            nte_coef = Total_NoteXCoef(listeLevel1, listeLevel2, listeLevel3);
            moyen = MoyenneEleve(listeLevel1, listeLevel2, listeLevel3);
             moyen = ArondirDouble(moyen);
            updateMoyenne("S1", moyen, e);


        }


        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, getOutput());
        document.open();
        int i = 0;
        int coef_Classe = 0;
        double note_coef = 0;
        double moyenne = 0;
        double moyenFirst = 0;
        double moyenLast = 0;
        double moyenGen = 0;
        String level;
        matieres = serviceMatiere.findMatiereByClassecode(classecode);
        System.out.println("--------------matiere size" + matieres.size());
        String matricule;
        Classe c = new Classe();
        c = serviceClasse.findByCode(classecode);
        eleves = serviceClasse.FindByClasse(c.getId(), codeAnnee);
        ClasserByMoyenne(eleves, "S1");

        for (Eleve eleve : eleves) {
            i++;
            listeLevel1 = new ArrayList<PV>();
            listeLevel2 = new ArrayList<PV>();
            listeLevel3 = new ArrayList<PV>();
            matricule = eleve.getMatricule();
            for (Matiere m : matieres) {

                List< PV> lstepv = serviceEleve.GeneralPV(eleve.getMatricule(), m.getId());
                if (lstepv.isEmpty()) {
                    System.out.println("++++++++++++++++++++++++++++++++++++++");
                    System.out.println("++++++++++++" + cycleSelected.ordinal() + "++++++++++++");

                    mcc = serviceMaClaCoef.getLevelMat(m.getId(), c.getId());
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

            document.add(Banniere("log_lycee", eleve));
            Paragraph p0 = new Paragraph("\n", catFont);
            document.add(p0);

            Paragraph p01 = new Paragraph(new Phrase("BULLETIN Sequentiel No..............", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE)));
            p01.setAlignment(Element.ALIGN_CENTER);
            document.add(p01);

            Paragraph p02 = new Paragraph("\n", catFont);
            document.add(p02);

            Paragraph p03 = new Paragraph("IDENTIFICATION DE L'ELEVE\n", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE));
            p03.setAlignment(Element.ALIGN_CENTER);
            document.add(p03);
            document.add(IdentificationEleve(eleve));

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



            Paragraph p4 = new Paragraph(new Phrase("RECAPITITULATIF", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE)));
            p4.setAlignment(Element.ALIGN_CENTER);
            document.add(p4);
            coef_Classe = CoefByClasse(listeLevel1, listeLevel2, listeLevel3);
            note_coef = Total_NoteXCoef(listeLevel1, listeLevel2, listeLevel3);
            moyenne = MoyenneEleve(listeLevel1, listeLevel2, listeLevel3);
            // ClasserByMoyenne(eleves, "S1");
            moyenFirst = ArondirDouble(eleves.get(0).getMoyenneS1());
            moyenLast = ArondirDouble(eleves.get(eleves.size() - 1).getMoyenneS1());
            moyenGen = ArondirDouble(MoyenneGenerale(eleves, "S1"));
            document.add(Recapititulatif(coef_Classe, note_coef, moyenne, moyenFirst, moyenLast, moyenGen, i));


            document.newPage();

        }

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

        PdfPCell cell1 = new PdfPCell(new Phrase(pv.getMaClaCoef().getProfesseur().getNom(), catFont));
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

    public PdfPTable Recapititulatif(int coef, double note_coef, double moyenne, double moyenFirst, double moyenLast, double moyenGen, int rang) {

        PdfPTable pTable = new PdfPTable(2);
        PdfPCell vide = new PdfPCell(new Phrase("", catFont));


        PdfPCell c1 = new PdfPCell(new Phrase("Total coefficient", catFont));
        c1.setBackgroundColor(Color.LIGHT_GRAY);
        pTable.addCell(c1);
        pTable.addCell(new Phrase("" + coef, catFont));

        PdfPCell c2 = new PdfPCell(new Phrase("Total notes coefficiés", catFont));
        c2.setBackgroundColor(Color.LIGHT_GRAY);
        pTable.addCell(c2);
        pTable.addCell(new Phrase("" + note_coef, catFont));

        PdfPCell c3 = new PdfPCell(new Phrase("Moyenne de l'élève", catFont));
        c3.setBackgroundColor(Color.LIGHT_GRAY);
        pTable.addCell(c3);
        pTable.addCell(new Phrase("" + moyenne, catFont));


        PdfPCell c4 = new PdfPCell(new Phrase("Moyenne du premier de la classe", catFont));
        c4.setBackgroundColor(Color.LIGHT_GRAY);
        pTable.addCell(c4);
        pTable.addCell(new Phrase("" + moyenFirst, catFont));

        PdfPCell c5 = new PdfPCell(new Phrase("Moyenne du dernier de la classe", catFont));
        c5.setBackgroundColor(Color.LIGHT_GRAY);
        pTable.addCell(c5);
        pTable.addCell(new Phrase("" + moyenLast, catFont));

        PdfPCell c6 = new PdfPCell(new Phrase("Moyenne générale de la classe", catFont));
        c6.setBackgroundColor(Color.LIGHT_GRAY);
        pTable.addCell(c6);
        pTable.addCell(new Phrase("" + moyenGen, catFont));

        PdfPCell c7 = new PdfPCell(new Phrase("Rang de lélève", catFont));
        c7.setBackgroundColor(Color.LIGHT_GRAY);
        pTable.addCell(c7);
        pTable.addCell(new Phrase("" + rang, catFont));

        PdfPCell c8 = new PdfPCell(new Phrase("Mention", catFont));
        c8.setBackgroundColor(Color.LIGHT_GRAY);
        pTable.addCell(c8);
        pTable.addCell(vide);

        PdfPCell c9 = new PdfPCell(new Phrase("Décision du conseil de classe", catFont));
        c9.setBackgroundColor(Color.LIGHT_GRAY);
        pTable.addCell(c9);
        pTable.addCell(vide);

        PdfPCell c10 = new PdfPCell(new Phrase("Nombre d’heure d’absence", catFont));
        c10.setBackgroundColor(Color.LIGHT_GRAY);
        pTable.addCell(c10);
        pTable.addCell(vide);

        PdfPCell c11 = new PdfPCell(new Phrase("Niveau de l’élève", catFont));
        c11.setBackgroundColor(Color.LIGHT_GRAY);
        pTable.addCell(c11);
        pTable.addCell(vide);


        PdfPCell c12 = new PdfPCell(new Phrase("Décision du conseil de classe", catFont));
        c12.setBackgroundColor(Color.LIGHT_GRAY);
        pTable.addCell(c12);
        pTable.addCell(vide);



        return pTable;
    }

    public int CoefByClasse(List<PV> l1, List<PV> l2, List<PV> l3) {

        int coef = 0;

        for (PV pv : l1) {
            coef += pv.getMaClaCoef().getCoeficient();
        }

        for (PV pv : l2) {
            coef += pv.getMaClaCoef().getCoeficient();
        }

        for (PV pv : l3) {
            coef += pv.getMaClaCoef().getCoeficient();
        }


        return coef;

    }

    public double Total_NoteXCoef(List<PV> l1, List<PV> l2, List<PV> l3) {

        double note_coef = 0;

        for (PV pv : l1) {
            note_coef += pv.getNote_coef();
        }

        for (PV pv : l2) {
            note_coef += pv.getNote_coef();
        }

        for (PV pv : l3) {
            note_coef += pv.getNote_coef();
        }


        return note_coef;

    }

    public double MoyenneEleve(List<PV> l1, List<PV> l2, List<PV> l3) {

        double moyenne = 0;
        double totalCoefficier = 0;

        int coef = 0;
        for (PV pv : l1) {
            totalCoefficier = totalCoefficier + pv.getNote_coef();
            coef = coef + pv.getMaClaCoef().getCoeficient();
        }

        for (PV pv : l2) {
            totalCoefficier = totalCoefficier + pv.getNote_coef();
            coef = coef + pv.getMaClaCoef().getCoeficient();
        }
        for (PV pv : l3) {
            totalCoefficier = totalCoefficier + pv.getNote_coef();
            coef = coef + pv.getMaClaCoef().getCoeficient();
        }

        moyenne = totalCoefficier / coef;



        return moyenne;

    }

    public void updateMoyenne(String token, double moy, Eleve e) throws ServiceException {
        if (token.equals("S1")) {
            e.setMoyenneS1(moy);
            serviceEleve.update(e);
        } else if (token.equals("S2")) {
            e.setMoyenneS2(moy);
            serviceEleve.update(e);
        } else if (token.equals("S3")) {
            e.setMoyenneS3(moy);
            serviceEleve.update(e);
        } else if (token.equals("S4")) {
            e.setMoyenneS4(moy);
            serviceEleve.update(e);
        } else if (token.equals("S5")) {
            e.setMoyenneS5(moy);
            serviceEleve.update(e);
        } else if (token.equals("S6")) {
            e.setMoyenneS6(moy);
            serviceEleve.update(e);

        } else if (token.equals("T1")) {
            e.setMoyenneT1(moy);
            serviceEleve.update(e);
        } else if (token.equals("T2")) {
            e.setMoyenneT2(moy);
            serviceEleve.update(e);
        } else if (token.equals("T3")) {
            e.setMoyenneT3(moy);
            serviceEleve.update(e);
        }



    }

    public void ClasserByMoyenne(List<Eleve> eleves, String token) {
        if (token.equals("S1")) {
            Collections.sort(eleves, Eleve.ComparatorMoyS1);
        } else if (token.equals("S2")) {
            Collections.sort(eleves, Eleve.ComparatorMoyS2);
        } else if (token.equals("S3")) {
            Collections.sort(eleves, Eleve.ComparatorMoyS3);
        } else if (token.equals("S4")) {
            Collections.sort(eleves, Eleve.ComparatorMoyS4);
        } else if (token.equals("S5")) {
            Collections.sort(eleves, Eleve.ComparatorMoyS5);
        } else if (token.equals("S6")) {
            Collections.sort(eleves, Eleve.ComparatorMoyS6);
        } else if (token.equals("T1")) {
            Collections.sort(eleves, Eleve.ComparatorMoyT1);
        } else if (token.equals("T2")) {
            Collections.sort(eleves, Eleve.ComparatorMoyT2);
        } else if (token.equals("T3")) {
            Collections.sort(eleves, Eleve.ComparatorMoyT3);
        }




    }

    public double MoyenneGenerale(List<Eleve> eleves, String token) {
        double mg = 0;

        if (token.equals("S1")) {
            for (Eleve eleve : eleves) {
                mg += eleve.getMoyenneS1();
            }
            mg = mg / eleves.size();
        } else if (token.equals("S2")) {
            for (Eleve eleve : eleves) {
                mg += eleve.getMoyenneS2();
            }
            mg = mg / eleves.size();
        } else if (token.equals("S3")) {
            for (Eleve eleve : eleves) {
                mg += eleve.getMoyenneS3();
            }
            mg = mg / eleves.size();
        } else if (token.equals("S4")) {
            for (Eleve eleve : eleves) {
                mg += eleve.getMoyenneS4();
            }
            mg = mg / eleves.size();
        } else if (token.equals("S5")) {
            for (Eleve eleve : eleves) {
                mg += eleve.getMoyenneS5();
            }
            mg = mg / eleves.size();
        } else if (token.equals("S6")) {
            for (Eleve eleve : eleves) {
                mg += eleve.getMoyenneS6();
            }
            mg = mg / eleves.size();
        } else if (token.equals("T1")) {
            for (Eleve eleve : eleves) {
                mg += eleve.getMoyenneT1();
            }
            mg = mg / eleves.size();
        } else if (token.equals("T2")) {
            for (Eleve eleve : eleves) {
                mg += eleve.getMoyenneT2();
            }
            mg = mg / eleves.size();
        } else if (token.equals("T3")) {
            for (Eleve eleve : eleves) {
                mg += eleve.getMoyenneT3();
            }
            mg = mg / eleves.size();
        }


        return mg;

    }

    public double ArondirDouble(double d) {
        String s = String.format("%.2f", d);
        int deb = s.indexOf(",");
         s = s.substring(0, deb) + "." + s.substring(deb + 1, deb + 3);   
        return Double.parseDouble(s);



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
        niveauDisplay = false;
        classeLevels = serviceClasseLevel.findbyCycleId(cycleSelected);

    }

    public void handleNiveauChange() throws ServiceException {
        classeDisplay = false;

        classes = serviceClasse.findByNiveau(niveau);


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

    public boolean isNiveauDisplay() {
        return niveauDisplay;
    }

    public void setNiveauDisplay(boolean niveauDisplay) {
        this.niveauDisplay = niveauDisplay;
    }

    public boolean isClasseDisplay() {
        return classeDisplay;
    }

    public void setClasseDisplay(boolean classeDisplay) {
        this.classeDisplay = classeDisplay;
    }

    public List<PV> getListeLevel1() {
        return listeLevel1;
    }

    public void setListeLevel1(List<PV> listeLevel1) {
        this.listeLevel1 = listeLevel1;
    }

    public List<PV> getListeLevel2() {
        return listeLevel2;
    }

    public void setListeLevel2(List<PV> listeLevel2) {
        this.listeLevel2 = listeLevel2;
    }

    public List<PV> getListeLevel3() {
        return listeLevel3;
    }

    public void setListeLevel3(List<PV> listeLevel3) {
        this.listeLevel3 = listeLevel3;
    }

    public ServiceMaClaCoef getServiceMaClaCoef() {
        return serviceMaClaCoef;
    }

    public void setServiceMaClaCoef(ServiceMaClaCoef serviceMaClaCoef) {
        this.serviceMaClaCoef = serviceMaClaCoef;
    }
}