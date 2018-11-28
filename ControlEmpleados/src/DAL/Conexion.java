/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author y2jmo
 */
public class Conexion {

     String conexion = "jdbc:sqlite:C:\\Users\\Christian\\Documents\\GitHub\\proyectoMexito\\ControlEmpleados\\ControlEmpleados.s3db";
     String conexMontalvo = "jdbc:sqlite:C:\\Users\\y2jmo\\Documents\\GitHub\\proyectoMexito\\ControlEmpleados\\ControlEmpleados.s3db";
     String conexPatF = "jdbc:sqlite:C:\\ControlEmpleados.s3db";
     String conexPat = "jdbc:sqlite:C:\\BD\\ControlEmpleados.s3db";
     String conexShari = "jdbc:sqlite:C:\\Users\\shari\\Documents\\GitHub\\proyectoMexito\\ControlEmpleados\\ControlEmpleados.s3db";
    Connection conn = null;
    
    public Conexion(){
    }
    
    public Connection Conectar(){
        try{
            Class.forName("org.sqlite.JDBC");

            this.conn = DriverManager.getConnection(conexShari);

            this.conn = DriverManager.getConnection(conexMontalvo);
            System.out.println("Conectado");
        }catch(Exception ex){
            System.err.println("Problemas al conectarse " + ex);
        }
        return this.conn;
    }
    
    public void Desconectar(){
        this.conn = null;
    }
    
    public int EjecutarComandoSQL(String Sentencia){
        try {
            PreparedStatement pstm=Conectar().prepareStatement(Sentencia);
            pstm.execute();
            Desconectar();
            return 1;
        }catch (SQLException e) {
            System.out.println(e);
        return 0;
        }

    }
              

    public int EjecutarComandoSQL(PreparedStatement Sentencia){
        try {
            PreparedStatement pstm= Sentencia;
   
            pstm.execute();
            return 1;
        }catch (SQLException e) {
            System.out.println(e);
        return 0;
        }

    }
    
    public ResultSet EjecutarSentenciaSQL(String Sentencia){
         try {
                PreparedStatement pstm=Conectar().prepareStatement(Sentencia);
                pstm.execute();
                ResultSet Resultado=pstm.executeQuery();
                Desconectar();
                return Resultado;
            }catch (SQLException e) {
                System.out.println(e);
                return null;   
             }
         }
}
