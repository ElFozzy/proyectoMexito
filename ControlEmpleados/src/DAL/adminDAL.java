/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BL.adminBL;
import DAL.Conexion;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author shari
 */
public class adminDAL {
    
    Conexion objConexion = new Conexion();
    
    public int Agregar (adminBL admin){
    
        int ComandoEjecutado = objConexion.EjecutarComandoSQL("INSERT INTO Admins(usuario,password,tipo)\n" + "VALUES ('"+admin.getUsuario()+"','"+admin.getPassword()+"','" + admin.getTipo()+"');");
        objConexion.Desconectar();
        return ComandoEjecutado;
    }
    
    public int Eliminar (adminBL admin){
    
        int ComandoEjecutado = objConexion.EjecutarComandoSQL("DELETE FROM Admins WHERE id='"+ admin.getId()+"'");
        objConexion.Desconectar();
        return ComandoEjecutado;
    }
    
    public int Modificar (adminBL admin){
    
        int ComandoEjecutado = objConexion.EjecutarComandoSQL("UPDATE Admins SET usuario='"+admin.getUsuario()+"', password='"+admin.getPassword()+ "', tipo='"+admin.getTipo()+"' WHERE id="+ admin.getId());
        objConexion.Desconectar();
        return ComandoEjecutado;
    }
    
    public DefaultTableModel Mostrar(){
        DefaultTableModel dtm = new DefaultTableModel(
        new Object [][] {},
        new String [] {
        "id","usuario","password","tipo"
        }
    ){ @Override
    public boolean isCellEditable(int row, int column) {
        // Para no editar en el jTable
        return false;
    }};
        try{
            Conexion objConexion = new Conexion();
            ResultSet Resultado=objConexion.EjecutarSentenciaSQL("SELECT * FROM Admins");
            while(Resultado.next()){
            // Recuperar Datos de la BD
            Object[] Fila = {
            Resultado.getString(1),
            Resultado.getString(2),
            Resultado.getString(3),
            Resultado.getString(4)
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
