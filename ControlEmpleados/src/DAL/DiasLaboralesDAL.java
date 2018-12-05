/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danie
 */
public class DiasLaboralesDAL {
    Conexion con = new Conexion();
    
    public int AgregarDiaLaboral(int emp, int dia)
    {
         int ComandoEjecutado = con.EjecutarComandoSQL("Insert into DiasLaborales (idEmp, dia) "
                + "values ('"+emp+"','"+dia+"')");
        con.Desconectar();
        return ComandoEjecutado;
    }
    
    public int EliminarDiasLaborales(int emp)
    {
         int ComandoEjecutado = con.EjecutarComandoSQL("DELETE FROM DiasLaborales where idEmp="
                +"'"+emp+"'");
        con.Desconectar();
        return ComandoEjecutado;
    }
    
    public ArrayList SeleccionarDias(int idEmp)
    {
        ArrayList lista = new ArrayList();
        ResultSet ComandoEjecutado = con.EjecutarSentenciaSQL("Select * from DiasLaborales where idEmp='"+idEmp+"'");
        try {
            while(ComandoEjecutado.next())
            {
                lista.add(ComandoEjecutado.getInt(2));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DiasLaboralesDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
    
    public boolean IsDiaLaboral(int idEmp, int dia)
    {
        ResultSet ComandoEjecutado = con.EjecutarSentenciaSQL("Select count(*) from DiasLaborales where idEmp='"+idEmp+"' and dia='"+dia+"'");
        con.Desconectar();
        try {
            if(ComandoEjecutado.next())
            {
                return ComandoEjecutado.getInt(1) > 0;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(empleadoDAL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ComandoEjecutado.close();
            } catch (SQLException ex) {
                Logger.getLogger(empleadoDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }
    
}
