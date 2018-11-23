/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BL.empleadoBL;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.*;
/**
 *
 * @author Christian
 */
public class empleadoDAL {
    Conexion con = new Conexion();
    
    public int Agregar (empleadoBL objemp){
        int ComandoEjecutado = con.EjecutarComandoSQL("Insert into Empleados (nombreEmp, foto, sexo, fechaIng, fechaRet, turno) "
                + "values  ('"+objemp.getnombreEmp()+"','"+objemp.getfoto()+"','"+objemp.getsexo()+"','"+objemp.getfechaIng()+"','"+objemp.getfechaRet()+"','"+objemp.getturno()+"');");
        con.Desconectar();
        return ComandoEjecutado;
    }
    
    public int Eliminar (empleadoBL objemp){
        int ComandoEjecutado = con.EjecutarComandoSQL("Delete from Empleados where id='"+objemp.getId()+"'");
        con.Desconectar();
        return ComandoEjecutado;
    }
    
    public int Modificar (empleadoBL objemp){
        int ComandoEjecutado = con.EjecutarComandoSQL("Update Empleados set nombreEmp='"+objemp.getnombreEmp()+"', foto='"+objemp.getfoto()+"', sexo='"+objemp.getsexo()+"', fechaIng='"+objemp.getfechaIng()+"', "
                + "fechaRet='"+objemp.getfechaRet()+"', turno='"+objemp.getturno()+"' where id='"+objemp.getId());
        con.Desconectar();
        return ComandoEjecutado;
    }
    
    public DefaultTableModel CargarDatos(){
        
        DefaultTableModel dtm =new DefaultTableModel(
        new Object [][] {},
        new String [] {
         "id","nombreEmp","foto","sexo","fechaIng","fechaRet","turno"
        }
       ){ @Override
        public boolean isCellEditable(int row, int column) {
        // Para no editar en el jTable
         return false;
        }};

        try{
            Conexion objConexion= new Conexion();
            ResultSet Resultado=objConexion.EjecutarSentenciaSQL("SELECT * FROM Empleados"); 
        while(Resultado.next()){
        // Recuperar Datos de la BD
        Object[] Fila={
        Resultado.getString(1),
        Resultado.getString(2),
        Resultado.getString(3),
        Resultado.getString(4),
        Resultado.getString(5),
        Resultado.getString(6),
        Resultado.getString(7)
            
    };
        // Agregar Datos al JTable
        dtm.addRow(Fila);
    }
    return dtm;
    }catch(SQLException e){
    return null;
    }
    }
}
