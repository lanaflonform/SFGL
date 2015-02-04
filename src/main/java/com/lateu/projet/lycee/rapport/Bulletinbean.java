/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.rapport;

import com.lateu.projet.lycee.Enum.Cycle;
import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.MaClaCoef;
import com.lateu.projet.lycee.entities.Matiere;
import com.lateu.projet.lycee.projection.PV;
import com.lateu.projet.lycee.projection.ReportEntry;
import com.lateu.projet.lycee.service.ServiceAnneeScolaire;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceEleve;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceMatiere;
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
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ing-lateu
 */
@ManagedBean
@RequestScoped
public class Bulletinbean {

    @ManagedProperty(value = "#{ServiceEleve}")
    private ServiceEleve serviceEleve;
    @ManagedProperty(value = "#{ServiceClasse}")
    private ServiceClasse serviceClasse;
    @ManagedProperty(value = "#{ServiceAnneeScolaire}")
    private ServiceAnneeScolaire serviceAnneeScolaire;
    @ManagedProperty(value = "#{ServiceMatiere}")
    private ServiceMatiere serviceMatiere;
    private List<Matiere> matieres = new ArrayList<Matiere>();
    private List<Classe> classes = new ArrayList<Classe>();
    private List<Eleve> eleves = new ArrayList<Eleve>();
    private List<AnneeScolaire> anneeScolaires = new ArrayList<AnneeScolaire>();
    List<PV> listeLevel1;
    List<PV> listeLevel2;
    List<PV> listeLevel3;
    private PV pvIntry = new PV();
    private MaClaCoef mcc = new MaClaCoef();
    private ServletOutputStream output;
    private Long idClasse;
    private String codeAnnee;
    private List<Cycle> cycles=new  ArrayList<Cycle>();
    private Cycle cycleSelected;
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

    /**
     *
     * @return l'entete du bulletin
     * @throws ServiceException
     * @throws ServiceException
     * @throws ServiceException
     * @throws DocumentException
     */
    private PdfPTable EnteteBuletin() throws ServiceException, ServiceException, ServiceException, DocumentException {

        PdfPTable head = new PdfPTable(2);
        PdfPCell cell11 = new PdfPCell(new Phrase("republique du cameroun", catFont));
        PdfPCell cell111 = new PdfPCell(new Phrase("MINSEC", catFont));
        PdfPCell cell22 = new PdfPCell(new Phrase("delegation des enseignements secondaires du nord", catFont));
        PdfPCell cell222 = new PdfPCell(new Phrase("lycee de avion me laisse", catFont));

        cell11.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell11.setBorderColor(bg);
        head.addCell(cell11);
        cell22.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell22.setBorderColor(bg);
        head.addCell(cell22);
        cell111.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell111.setBorderColor(bg);
        head.addCell(cell111);
        cell222.setHorizontalAlignment(Element.ALIGN_CENTER);
        cell222.setBorderColor(bg);
        head.addCell(cell222);
        return head;


    }

    private PdfPTable Banniere() throws ServiceException, ServiceException, ServiceException, DocumentException, BadElementException, MalformedURLException, IOException {

        PdfPTable table = new PdfPTable(3);


        PdfPCell cell2 = new PdfPCell(new Phrase("PREMIER-TRIMESTRE", new Font(Font.COURIER, 12, Font.BOLD, Color.DARK_GRAY)));
        String filename = "/home/ing-lateu/Téléchargements/1.jpg";
        Image image2 = Image.getInstance(filename);
        image2.scaleAbsolute(50, 50);
        PdfPCell cell1 = new PdfPCell(image2, false);

        String filename_d = "/home/ing-lateu/Téléchargements/d.JPG";
        Image image_d = Image.getInstance(filename_d);
        //  image_d.scaleAbsoluteWidth(100);
        image_d.scaleAbsolute(50, 50);
        PdfPCell cell3 = new PdfPCell(image_d, false);
        cell3.setPaddingLeft(80);
        //
        // Add cells to table
        cell1.setPaddingRight(98);
        table.addCell(cell1);

        table.addCell(cell2);
        table.addCell(cell3);

        return table;

    }

    private PdfPTable Identification(Eleve e) throws ServiceException, ServiceException, ServiceException, DocumentException {

        PdfPTable head = new PdfPTable(1);
        PdfPCell cell1 = new PdfPCell(new Phrase("Nom et Prenom: " + e.getNom() + "-" + e.getPrenom(), catFont));
        PdfPCell cell2 = new PdfPCell(new Phrase("Né le " + e.getDateNais() + " à " + "------", catFont));
        PdfPCell cell3 = new PdfPCell(new Phrase("Redoublant: " + e.getRedoublant()));
        PdfPCell cell0 = new PdfPCell(new Phrase("", catFont));
        cell0.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell0.setBorderColor(bg);
        cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell1.setBorderColor(bg);
        head.addCell(cell1);
        cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell2.setBorderColor(bg);
        head.addCell(cell2);

        cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell3.setBorderColor(bg);
        head.addCell(cell3);
        return head;


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
        matieres = serviceMatiere.findMatiereByClasseID(idClasse);



        eleves = serviceClasse.FindByClasse(idClasse, codeAnnee);
        

        for (Eleve eleve : eleves) {
            listeLevel1 = new ArrayList<PV>();
            listeLevel2 = new ArrayList<PV>();
            listeLevel3 = new ArrayList<PV>();

            for (Matiere m : matieres) {

                List< PV> lstepv = serviceEleve.GeneralPV(eleve.getMatricule(), m.getId());
                if (lstepv.isEmpty()) {
                    System.out.println("++++++++++++++++++++++++++++++++++++++");
                    System.out.println("++++++++++++" +cycleSelected.ordinal()+ "++++++++++++");

                    mcc = serviceEleve.getLevelMat(m.getId());
                    level = mcc.getLevelMatiere();
                    pvIntry = new PV(0.0, m.getIntitule(), mcc, 0.0);
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

            document.add(EnteteBuletin());

            document.add(Banniere());
            document.add(Identification(eleve));
            Paragraph p = new Paragraph(new Phrase("MATIERE DU PREMIER GROUPE", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE)));
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(Groupe(listeLevel1));

            Paragraph p1 = new Paragraph(new Phrase("MATIERE DU DEUXIEME GROUPE", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE)));
            p1.setAlignment(Element.ALIGN_CENTER);
            document.add(p1);

            document.add(Groupe(listeLevel2));

            Paragraph p3 = new Paragraph(new Phrase("MATIERE DU TROISIEME GROUPE", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE)));
            p3.setAlignment(Element.ALIGN_CENTER);
            document.add(p3);


            document.add(Groupe(listeLevel3));
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
    public void ajouterLingne(PdfPTable table2, PV pv) throws DocumentException {
        PdfPCell cell1 = new PdfPCell(new Phrase("lateu-richard ", catFont));
        //cell1.setBackgroundColor(Color.GRAY);
        table2.addCell(cell1);


        PdfPCell cell2 = new PdfPCell(new Phrase(pv.getMatiere(), catFont));
        //cell2.setBackgroundColor(Color.GRAY);
        table2.addCell(cell2);

        PdfPCell cell3 = new PdfPCell(new Phrase(pv.getNote() + "", catFont));
        // cell3.setBackgroundColor(Color.GRAY);
        table2.addCell(cell3);

        PdfPCell cell4 = new PdfPCell(new Phrase(pv.getMaClaCoef().getCoeficient() + "", catFont));
        table2.addCell(cell4);

        PdfPCell cell5 = new PdfPCell(new Phrase(pv.getNote_coef() + "", catFont));
        table2.addCell(cell5);

        PdfPCell cell6 = new PdfPCell(new Phrase("Not-yet", catFont));
        table2.addCell(cell6);

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
        return serviceClasse.findAll();
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
}