/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.EntradaSalidaBL;
import java.sql.ResultSet;
import java.sql.SQLException;
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
                + "values  ('"+EntSal.getIdEmpleado()+"','"+EntSal.getFecha().toString()+"','"+EntSal.getHora().toString()+"','"+EntSal.isTipo()+"');");
        con.Desconectar();
        return ComandoEjecutado;
    }
    
    public boolean EntradaPrevia(int id){
        try {
            Conexion objConexion= new Conexion();
            ResultSet Resultado=objConexion.EjecutarSentenciaSQL("SELECT * FROM Ent_Sal where idEmp='"+id+"' AND fecha = date(\"now\") AND tipo=false");
            return Resultado.next();
        } catch (SQLException ex) {
            Logger.getLogger(EntradaSalidaDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
}
