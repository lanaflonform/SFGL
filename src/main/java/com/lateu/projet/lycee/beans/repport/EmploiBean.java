/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lateu.projet.lycee.beans.repport;

import com.douwe.generic.dao.DataAccessException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author ing-lateu
 */
@ManagedBean
@RequestScoped
public class EmploiBean {
      JasperPrint jasperPrint, jasperPrint2;

    public void init() throws JRException, DataAccessException {

        List<Object> l = new ArrayList<Object>();
   //     l.add(serviceCreditScolaire.rapport(serviceCreditScolaire.findByAgence(codeAgenece)));
        JRBeanCollectionDataSource beanCollectionDataSource = new JRBeanCollectionDataSource(l);
        String path = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/raport/emploi/attestation.jasper");
        jasperPrint = JasperFillManager.fillReport(path, new HashMap(), beanCollectionDataSource);
    }

    public void emploi_Classe() throws JRException, IOException, DataAccessException {
        init();
        HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("content-disposition", "attachment;filename=emploi-classe.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
    }
}
