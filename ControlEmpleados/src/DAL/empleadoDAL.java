/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import BL.empleadoBL;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.*;
/**
 *
 * @author Christian
 */
public class empleadoDAL {
    Conexion con = new Conexion();
          
    public int Agregar (empleadoBL objemp){
        int ComandoEjecutado = con.EjecutarComandoSQL("Insert into Empleados (nombreEmp, sexo, foto, fechaIng, fechaRet, turno,horaEntrada,horaSalida) "
                + "values  ('"+objemp.getnombreEmp()+"','"+objemp.getsexo()+"','"+objemp.getfoto()+"','"+objemp.getfechaIng()+"','"+objemp.getfechaRet()+"','"+objemp.getturno()+"','"+objemp.getHoraEntrada()+"','"+objemp.getHoraSalida()+"');");
        con.Desconectar();
        return ComandoEjecutado;
    }
    
    
    
    public int AgregarQR(empleadoBL objemp){
        int ComandoEjecutado = con.EjecutarComandoSQL("Update Empleados set QR='"+objemp.getqr()+"' where id='"+objemp.getIDQR()+"'");
        con.Desconectar();
        return ComandoEjecutado;
    }
    
    public int obtenerIdFinal(){
        ResultSet ComandoEjecutado = con.EjecutarSentenciaSQL("Select MAX(id)from empleados;");
        con.Desconectar();
        try {
            return ComandoEjecutado.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(empleadoDAL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            try {
                ComandoEjecutado.close();
            } catch (SQLException ex) {
                Logger.getLogger(empleadoDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        return 0;
    }
        
    
    public int Eliminar (empleadoBL objemp){
        int ComandoEjecutado = con.EjecutarComandoSQL("Delete from Empleados where id='"+objemp.getId()+"'");
        con.Desconectar();
        return ComandoEjecutado;
    }
    
    public int Modificar (empleadoBL objemp){
        int ComandoEjecutado = con.EjecutarComandoSQL("Update Empleados set nombreEmp='"+objemp.getnombreEmp()+"', sexo='"+objemp.getsexo()+"', foto='"+objemp.getfoto()+"', fechaIng='"+objemp.getfechaIng()+"', "
                +"fechaRet='"+objemp.getfechaRet()+"', turno='"+objemp.getturno()+"', horaEntrada='"+objemp.getHoraEntrada()+"', horaSalida='"+objemp.getHoraSalida()+"' where id='"+objemp.getId()+"'");
        con.Desconectar();
        return ComandoEjecutado;
    }
    
    public empleadoBL BuscarEmpleado(int id) throws IOException, SQLException{
        empleadoBL empleado = new empleadoBL();
        ResultSet Resultado=con.EjecutarSentenciaSQL("SELECT * FROM Empleados where Id="+id);
        try {
            
            
            
            if(Resultado.next()){
                empleado.setId(Resultado.getInt(1));
                empleado.setnombreEmp(Resultado.getString(2));
                empleado.setfoto(Resultado.getString(3));
                empleado.setHoraEntrada(Resultado.getString(9));
                empleado.setHoraSalida(Resultado.getString(10));
                
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(empleadoDAL.class.getName()).log(Level.SEVERE, null, ex);
        }finally{con.Desconectar();
            Resultado.close();
        }
        return empleado;
    }
    
    public DefaultTableModel CargarDatos(){
        
        DefaultTableModel dtm =new DefaultTableModel(
        new Object [][] {},
        new String [] {
         "id","Nombre Empleado","Foto","Sexo","FechaIngreso","FechaRetiro","QR","Turno","Hora Entrada","Hora Salida"
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
        Resultado.getString(7),
        Resultado.getString(8),
        Resultado.getString(9),
        Resultado.getString(10)
            
    };
        // Agregar Datos al JTable
        dtm.addRow(Fila);
    }
        objConexion.Desconectar();
    return dtm;
    }catch(SQLException e){
    return null;
    }
    }
    
    
    
}
