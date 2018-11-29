/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;

import DAL.Conexion;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfExporterConfiguration;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Daniel
 */
public class ReporteGafete {
    Conexion conexion = new Conexion();
    public void GenerarGafete(int id){
        try {
	// se muestra en una ventana aparte para su descarga
            Map<String,Object> parametros = new HashMap<String, Object>();
            parametros.put("id", id);
            JasperPrint jasperPrintWindow;
            jasperPrintWindow = JasperFillManager.fillReport(
                    "C:\\Users\\Daniel\\Documents\\GitHub\\proyectoMexito\\ControlEmpleados\\src\\Reportes\\gafete.jasper",parametros,
                    conexion.Conectar());
            JasperViewer jasperViewer = new JasperViewer(jasperPrintWindow);
	    jasperViewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(ReporteGafete.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        }
}
