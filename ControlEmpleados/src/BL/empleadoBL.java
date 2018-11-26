/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.InputStream;

/**
 *
 * @author y2jmo
 */
public class empleadoBL {
    
    public int id;
    public String nombreEmp;
    public byte[] foto;
    public boolean sexo;
    public String fechaIng;
    public String fechaRet;
    public boolean turno;
    
    public int getId(){
        return id;        
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getnombreEmp(){
        return nombreEmp;
    }
    
    public void setnombreEmp(String nombreEmp){
        this.nombreEmp = nombreEmp;
    }
    
    public byte[] getfoto(){
        return foto;
    }
    
    public void setfoto(byte[] foto){
        this.foto = foto;
    }
    
    public boolean getsexo(){
        return sexo;
    }
    
    public void setsexo(boolean sexo){
        this.sexo = sexo;
    }
    
    public String getfechaIng(){
        return fechaIng;
    }
    
    public void setfechaIng(String fechaIng){
        this.fechaIng = fechaIng;
    }
    
    public String getfechaRet(){
        return fechaRet;
    }
    
    public void setfechaRet(String fechaRet){
        this.fechaRet = fechaRet;
    }
    
    public boolean getturno(){
        return turno;
    }

    public void setturno(boolean turno){
        this.turno = turno;
    }
}
