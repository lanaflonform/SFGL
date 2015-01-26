/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.rapport;

import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.projection.ReportEntry;
import com.lateu.projet.lycee.service.ServiceAnneeScolaire;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceEleve;
import com.lateu.projet.lycee.service.ServiceException;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Cell;
import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfContentByte;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import java.awt.Color;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
    private List<Classe> classes = new ArrayList<Classe>();
     private List<Eleve> eleves=new ArrayList<Eleve>();
    private List<AnneeScolaire> anneeScolaires = new ArrayList<AnneeScolaire>();
    private ServletOutputStream output;
    private String codeClasse;
    private String codeAnnee;
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
        PdfPCell cell1 = new PdfPCell(new Phrase("Nom et Prenom: "+e.getNom()+"-"+e.getPrenom(), catFont));
        PdfPCell cell2 = new PdfPCell(new Phrase("Né le "+e.getDateNais()+"à "+"////////////", catFont));
        PdfPCell cell3 = new PdfPCell(new Phrase("Redoublant: "+e.getRedoublant()));
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
    public PdfPTable PremierGroupe(String codeClasse, String level) throws ServiceException, DocumentException {
        PdfPTable table2 = new PdfPTable(4);

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

        List<ReportEntry> l = serviceEleve.maSectionBulletin(codeClasse, level);
        for (ReportEntry reportEntry : l) {
            ajouterLingne(table2, reportEntry);

        }

        return table2;

    }

    /**
     *
     * @param codeClasse
     * @param level
     * @return un tableau contenant les matieres du second groupe d'un bulletin
     * @throws ServiceException
     * @throws DocumentException
     */
    public PdfPTable DeuxiemeGroupe(String codeClasse, String level) throws ServiceException, DocumentException {
        PdfPTable table2 = new PdfPTable(4);

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

        List<ReportEntry> l = serviceEleve.maSectionBulletin(codeClasse, level);
        for (ReportEntry reportEntry : l) {
            ajouterLingne(table2, reportEntry);

        }

        return table2;

    }

    /**
     *
     * @param codeClasse
     * @param level
     * @return tableau des matiere trancversales d'un bulletin
     * @throws ServiceException
     * @throws DocumentException
     */
    public PdfPTable AutreGroupe(String codeClasse, String level) throws ServiceException, DocumentException {
        PdfPTable table2 = new PdfPTable(4);

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

        List<ReportEntry> l = serviceEleve.maSectionBulletin(codeClasse, level);
        for (ReportEntry reportEntry : l) {
            ajouterLingne(table2, reportEntry);

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
        eleves=serviceClasse.FindByClasse(codeClasse, codeAnnee);
       // for (i = 0; i < eleves.size(); i++) {

            for (Eleve eleve : eleves) {
                
           
            document.add(EnteteBuletin());

            document.add(Banniere());
            document.add(Identification(eleve));
            Paragraph p = new Paragraph(new Phrase("MATIERE DU PREMIER GROUPE", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE)));
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            document.add(PremierGroupe("PC", "1"));

            Paragraph p1 = new Paragraph(new Phrase("MATIERE DU DEUXIEME GROUPE", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE)));
            p1.setAlignment(Element.ALIGN_CENTER);
            document.add(p1);

            document.add(PremierGroupe("PC", "2"));

            Paragraph p3 = new Paragraph(new Phrase("MATIERE DU TROISIEME GROUPE", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE)));
            p3.setAlignment(Element.ALIGN_CENTER);
            document.add(p3);


            document.add(PremierGroupe("PC", "3"));
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
    public void ajouterLingne(PdfPTable table2, ReportEntry entree) throws DocumentException {
        PdfPCell cell1 = new PdfPCell(new Phrase("lateu-richard ", catFont));
        //cell1.setBackgroundColor(Color.GRAY);
        table2.addCell(cell1);


        PdfPCell cell2 = new PdfPCell(new Phrase(entree.getMatiere().getIntitule(), catFont));
        //cell2.setBackgroundColor(Color.GRAY);
        table2.addCell(cell2);

        PdfPCell cell3 = new PdfPCell(new Phrase("0.0", catFont));
        // cell3.setBackgroundColor(Color.GRAY);
        table2.addCell(cell3);

        PdfPCell cell4 = new PdfPCell(new Phrase(entree.getMatClaCoef().toString(), catFont));
        // cell4.setBackgroundColor(Color.GRAY);
        table2.addCell(cell4);

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

    public String getCodeClasse() {
        return codeClasse;
    }

    public void setCodeClasse(String codeClasse) {
        this.codeClasse = codeClasse;
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
}