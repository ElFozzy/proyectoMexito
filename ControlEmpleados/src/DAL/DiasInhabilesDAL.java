/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.DiasInhabilesBL;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Daniel
 */
public class DiasInhabilesDAL {
    Conexion conexion = new Conexion();
    
    public int Agregar(DiasInhabilesBL dia){
        int ComandoEjecutado = conexion.EjecutarComandoSQL("INSERT INTO DiasInhabiles (dia, mes) values('"+dia.getDia()+"','"+dia.getMes()+"')");
        conexion.Desconectar();
        return ComandoEjecutado;
    }
    
    public boolean IsDiaInhabil(int dia, int mes){
         boolean is = false; 
         ResultSet Resultado=conexion.EjecutarSentenciaSQL("SELECT * FROM DiasInhabiles where Mes='"+dia+"' and Dia='"+mes+"'");
        try {
            if(Resultado.next())
            {
                is = true;
            }
        } catch (SQLException ex) {
            
        }
        conexion.Desconectar();
         return is;
    }
    
    
}
