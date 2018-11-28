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
    public String foto;
    public String sexo;
    public String fechaIng;
    public String fechaRet;
    public String turno;
    public String qr;
    
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
    
    public String getfoto(){
        return foto;
    }
    
    public void setfoto(String foto){
        this.foto = foto;
    }
    
    public String getsexo(){
        return sexo;
    }
    
    public void setsexo(String sexo){
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
    
    public String getturno(){
        return turno;
    }

    public void setturno(String turno){
        this.turno = turno;
    }
    
    public String getqr(){
        return qr;
    }
    
    public void serqr(String qr){
        this.qr = qr;
    }
    
}
