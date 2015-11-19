/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans;

import com.douwe.generic.dao.DataAccessException;
import com.lateu.projet.lycee.entities.AnneeScolaire;
import com.lateu.projet.lycee.entities.Classe;
import com.lateu.projet.lycee.entities.Eleve;
import com.lateu.projet.lycee.entities.Nationalite;
import com.lateu.projet.lycee.service.ServiceAnneeScolaire;
import com.lateu.projet.lycee.service.ServiceClasse;
import com.lateu.projet.lycee.service.ServiceEleve;
import com.lateu.projet.lycee.service.ServiceException;
import com.lateu.projet.lycee.service.ServiceNationalite;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author lateu
 */
@ManagedBean
@RequestScoped
public class Elevebean {

    @ManagedProperty(value = "#{ServiceEleve}")
    private ServiceEleve serviceEleve;
    @ManagedProperty(value = "#{ServiceAnneeScolaire}")
    private ServiceAnneeScolaire serviceAnneeScolaire;
    private AnneeScolaire anneeScolaireSelected;
    @ManagedProperty(value = "#{ServiceNationalite}")
    private ServiceNationalite serviceNationalite;
    @ManagedProperty(value = "#{ServiceClasse}")
    private ServiceClasse serviceClasse;
    private Nationalite nationnaliteSelected = new Nationalite();
    public List<Nationalite> nationalites;
    public List<Eleve> eleves;
    public List<AnneeScolaire> anneeScolaires;
    public List<Classe> classes = new ArrayList<Classe>();
    private Eleve eleveSelected = new Eleve();
    private Classe classeSelect = new Classe();
    private String CodeAnnee;
    private String pays;
    private String classe;

    public Elevebean() {
    }

    public void create() throws ServiceException {
        SimpleDateFormat tmp = new SimpleDateFormat("dd-MM-yyyy");
        String index = serviceEleve.LastIndex(serviceEleve.FindAll());
        String s = buildeMatricule(new Date(), "L"+index);
        eleveSelected.setMatricule(s);
        serviceEleve.create(eleveSelected, CodeAnnee, pays, classe);

        //System.out.println("====="+eleveSelected);
    }

    public String buildeMatricule(Date d, String chaine) {
        String s;
        SimpleDateFormat tmp = new SimpleDateFormat("dd-MM-yyyy");
        Date dt = new Date();
        s = tmp.format(dt);
        s = s.substring(8, 10) + chaine;
        return s;
    }

    public List<Eleve> getEleves() throws ServiceException {
        return eleves = serviceEleve.FindAll();
    }

    public void setEleves(List<Eleve> eleves) {
        this.eleves = eleves;
    }

    public ServiceEleve getServiceEleve() {
        return serviceEleve;
    }

    public void setServiceEleve(ServiceEleve serviceEleve) {
        this.serviceEleve = serviceEleve;
    }

    public ServiceAnneeScolaire getServiceAnneeScolaire() {
        return serviceAnneeScolaire;
    }

    public void setServiceAnneeScolaire(ServiceAnneeScolaire serviceAnneeScolaire) {
        this.serviceAnneeScolaire = serviceAnneeScolaire;
    }

    public AnneeScolaire getAnneeScolaireSelected() {
        return anneeScolaireSelected;
    }

    public void setAnneeScolaireSelected(AnneeScolaire anneeScolaireSelected) {
        this.anneeScolaireSelected = anneeScolaireSelected;
    }

    public ServiceNationalite getServiceNationalite() {
        return serviceNationalite;
    }

    public void setServiceNationalite(ServiceNationalite serviceNationalite) {
        this.serviceNationalite = serviceNationalite;
    }

    public ServiceClasse getServiceClasse() {
        return serviceClasse;
    }

    public void setServiceClasse(ServiceClasse serviceClasse) {
        this.serviceClasse = serviceClasse;
    }

    public Nationalite getNationnaliteSelected() {
        return nationnaliteSelected;
    }

    public void setNationnaliteSelected(Nationalite nationnaliteSelected) {
        this.nationnaliteSelected = nationnaliteSelected;
    }

    public List<Nationalite> getNationalites() throws ServiceException {
        return nationalites = serviceNationalite.FindAll();
    }

    public void setNationalites(List<Nationalite> nationalites) {
        this.nationalites = nationalites;
    }

    public Eleve getEleveSelected() {
        return eleveSelected;
    }

    public void setEleveSelected(Eleve eleveSelected) {
        this.eleveSelected = eleveSelected;
    }

    public List<Classe> getClasses() throws ServiceException {
        return classes = serviceClasse.findAll();
    }

    public void setClasses(List<Classe> classes) {
        this.classes = classes;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

  


    public List<AnneeScolaire> getAnneeScolaires() throws ServiceException {
        return anneeScolaires=serviceAnneeScolaire.findAll();
    }

    public void setAnneeScolaires(List<AnneeScolaire> anneeScolaires) {
        this.anneeScolaires = anneeScolaires;
    }

    public String getCodeAnnee() {
        return CodeAnnee;
    }

    public void setCodeAnnee(String CodeAnnee) {
        this.CodeAnnee = CodeAnnee;
    }

    

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    public void importationEleve(FileUploadEvent event) throws DataAccessException, ServiceException {
      System.out.println("je suis au debut de ma liste d'insertion --------------: ");
//        // Agence a=serviceAgence.findAgenceByUsername(name);
        FacesContext facesContext = FacesContext.getCurrentInstance();
        int cpt = 0;
        if (event.getFile() == null) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Le fichier est vide", ""));
        }

        InputStream file;
        HSSFWorkbook workbook = null;
        try {
            file = event.getFile().getInputstream();
            workbook = new HSSFWorkbook(file);
        } catch (IOException e) {
            facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur lors de la lecture du fichier" + e, ""));
        }

        HSSFSheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            System.out.println("Ligne numero: " + row.getRowNum());
            if (row.getRowNum() == 0) {
                continue;
            }

            String codeAnnee = null;
            String codeClasse = null;
            String CodeNationalite = null;
            Iterator<Cell> cellIterator = row.cellIterator();
            eleveSelected = new Eleve();
            nationnaliteSelected = new Nationalite();
            anneeScolaireSelected = new AnneeScolaire();

            while (cellIterator.hasNext()) {
                System.out.println("---------je suis dans la boucle-------");
                Cell cell = cellIterator.next();
                System.out.println("colonne numero: " + cell.getColumnIndex() + "  " + cell);
                switch (cell.getColumnIndex()) {
                    case 0:
                        String nom = cell.getStringCellValue();
                        eleveSelected.setNom(nom);
                        break;
                    case 1:
                        String prenom = cell.getStringCellValue();
                        eleveSelected.setPrenom(prenom);
                        break;
                    case 2:
                        String sexe = cell.getStringCellValue();
                        eleveSelected.setSexe(sexe);
                        break;
                    case 3:
                        String matricule = cell.getStringCellValue();
                        eleveSelected.setMatricule(matricule);
                        break;
                    case 4:
                        String lNais = cell.getStringCellValue();
                        eleveSelected.setLieuxNais(lNais);
                        break;
                    case 5:
                        Date datnais = cell.getDateCellValue();
                        eleveSelected.setDateNais(datnais);
                        break;
                    case 6:
                        String contactP = cell.getStringCellValue();
                        eleveSelected.setContactPrarent(contactP);
                        break;
                    case 7:
                        String nomParent = cell.getStringCellValue();
                        eleveSelected.setNomPere(nomParent);
                        break;
                    case 8:
                        String quartier = cell.getStringCellValue();
                        eleveSelected.setQuartier(quartier);
                        break;
                    case 9:
                        String redouble = cell.getStringCellValue();
                        eleveSelected.setRedoublant(redouble);
                        break;
                    case 10:
                        codeAnnee = cell.getStringCellValue();
//                        anneeScolaireSelected = serviceAnneeScolaire.finAnneeScolairebyCode(CodeAnnee);
//                        eleveSelected.setAnnee(anneeScolaireSelected);
                        break;
                    case 11:
                        codeClasse = cell.getStringCellValue();
//                        classeSelect = serviceClasse.findByCode(codeClasse);
//                        eleveSelected.setClasse(classeSelect);
                        break;
                    case 13:
                        CodeNationalite = cell.getStringCellValue();
//                        nationnaliteSelected = serviceNationalite.FindBypays(CodeNationalite);
//                        eleveSelected.setNationalite(nationnaliteSelected);
                        break;

                    default:
                }

            }
            serviceEleve.create(eleveSelected, codeAnnee, CodeNationalite, codeClasse);
            cpt++;
            // serviceArchivage.create(archivageselect, serviceAgence.findAgenceByUsername(name));

        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, " " + cpt + " lignes enregistrées", ""));

    }

    public Classe getClasseSelect() {
        return classeSelect;
    }

    public void setClasseSelect(Classe classeSelect) {
        this.classeSelect = classeSelect;
    }
}