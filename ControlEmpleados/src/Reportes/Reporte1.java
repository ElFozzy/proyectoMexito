/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Reportes;


//import net.sf.jasperreports.util.
import DAL.Conexion;
import Principal.Main;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author shari
 */
public class Reporte1 {
    
    public void ReporteEmpleados(){
    
        try{
            JasperReport reporte =(JasperReport)JRLoader.loadObjectFromFile("C:\\Users\\shari\\Documents\\GitHub\\proyectoMexito\\ControlEmpleados\\src\\Reportes\\Reporte1.jasper");
            //Map parametro= new HashMap();
            Conexion con = new Conexion();
            JasperPrint jasper = JasperFillManager.fillReport(reporte, null, con.Conectar());
            JasperViewer print = new JasperViewer(jasper, false);
            print.setVisible(true);
        }
        catch(Exception e){
        
            System.out.print("Sin reporte");
        }
        
                   
    }
}
