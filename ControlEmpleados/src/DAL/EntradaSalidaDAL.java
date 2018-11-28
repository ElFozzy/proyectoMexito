/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.EntradaSalidaBL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class EntradaSalidaDAL {
    Conexion con = new Conexion();
    
    public int AgregarEntrada (EntradaSalidaBL EntSal){
        int ComandoEjecutado = con.EjecutarComandoSQL("Insert into Ent_Sal (idEmp, fecha, hora, tipo) "
                + "values  ('"+EntSal.getIdEmpleado()+"','"+EntSal.getFecha().toString()+"','"+EntSal.getHora().toString()+"','"+EntSal.getTipo()+"');");
        con.Desconectar();
        return ComandoEjecutado;
    }
    
    public boolean EntradaPrevia(int id){
       
        try {
            
            Date date = new Date();
            DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
            String query = "SELECT * FROM (SELECT * FROM (SELECT * from Ent_Sal where fecha = '"+format.format(date)+"') WHERE idEmp = '"+id+"')";
            ResultSet Resultado=con.EjecutarSentenciaSQL(query);
            return Resultado.next();
        } catch (SQLException ex) {
            Logger.getLogger(EntradaSalidaDAL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{ con.Desconectar();}
        return false;
    }
    
}
