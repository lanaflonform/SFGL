/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.rapport;

import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.EmploiDeTemps;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceEmploi;
import com.lateu.projet.lycee.service.ServiceException;
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
public class EmploiGenerator {
     @ManagedProperty(value = "#{ServiceEmploi}")
    private ServiceEmploi serviceEmploi;
    @ManagedProperty(value = "#{ServiceClasse}")
    private ServiceClasse serviceClasse;
        private Color bg = Color.WHITE;
    private static final Font catFont = new Font(Font.TIMES_ROMAN, 8, Font.BOLD);
    private static final Font font = new Font(Font.TIMES_ROMAN, 6, Font.BOLD);
    private static final Font f = new Font(Font.TIMES_ROMAN, 12, Font.BOLD);
    private static final Font f1 = new Font(Font.TIMES_ROMAN, 10, Font.BOLD);
    private static final Font f2 = new Font(Font.TIMES_ROMAN, 10, Font.UNDERLINE);
       private ServletOutputStream output;
     private List<EmploiDeTemps> emplois = new ArrayList<EmploiDeTemps>();
        private List<Classe> classes = new ArrayList<Classe>();
     public ServletOutputStream getOutput() throws IOException {
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=PV.pdf");
        output = httpServletResponse.getOutputStream();
        return output;
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

     
      public void genererEmploi() throws FileNotFoundException, BadElementException, MalformedURLException, IOException, DocumentException, ServiceException {
        Document document = new Document(PageSize.A4.rotate());

        PdfWriter.getInstance(document, getOutput());
        document.open();
        int i;
        classes=serviceClasse.findAll();

            for (Classe cl : classes) {
                
           
   //         document.add(EnteteBuletin());

            document.add(Banniere());
           // document.add(Identification(eleve));
            Paragraph p = new Paragraph(new Phrase("MATIERE DU PREMIER GROUPE", new Font(Font.COURIER, 10, Font.BOLD, Color.BLUE)));
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);

            PdfPTable table2 = new PdfPTable(6);

        PdfPCell cell1 = new PdfPCell(new Phrase("lundi", catFont));
        cell1.setBackgroundColor(Color.GRAY);
        table2.addCell(cell1);
        PdfPCell cell2 = new PdfPCell(new Phrase("mardi", catFont));
        cell2.setBackgroundColor(Color.GRAY);
        table2.addCell(cell2);

        PdfPCell cell3 = new PdfPCell(new Phrase("mercredi", catFont));
        cell3.setBackgroundColor(Color.GRAY);
        table2.addCell(cell3);
        PdfPCell cell4 = new PdfPCell(new Phrase("jeudi", catFont));
        cell4.setBackgroundColor(Color.GRAY);
        table2.addCell(cell4);
        
        PdfPCell cell5 = new PdfPCell(new Phrase("vendredi", catFont));
        cell5.setBackgroundColor(Color.GRAY);
        table2.addCell(cell5);
        
        
         PdfPCell cell6 = new PdfPCell(new Phrase("samedi", catFont));
        cell6.setBackgroundColor(Color.GRAY);
        table2.addCell(cell6);
            
            document.add(table2);
            
            document.newPage();

        }

// }
        document.close();

    }

    public ServiceEmploi getServiceEmploi() {
        return serviceEmploi;
    }

    public void setServiceEmploi(ServiceEmploi serviceEmploi) {
        this.serviceEmploi = serviceEmploi;
    }

    public ServiceClasse getServiceClasse() {
        return serviceClasse;
    }

    public void setServiceClasse(ServiceClasse serviceClasse) {
        this.serviceClasse = serviceClasse;
    }

    public Color getBg() {
        return bg;
    }

    public void setBg(Color bg) {
        this.bg = bg;
    }

}
