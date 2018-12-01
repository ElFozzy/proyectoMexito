/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BL;

import java.io.InputStream;
import java.sql.Time;

/**
 *
 * @author y2jmo
 */
public class empleadoBL {
    
    private int id;
    private String nombreEmp;
    private String foto;
    private String sexo;
    private String fechaIng;
    private String fechaRet;
    private String turno;
    private String qr;
    private int IDQR;
    private Time horaEntrada;
    private Time horaSalida;
    
    public int getId(){
        return id;        
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public int getIDQR(){
        return IDQR;
    }
    
    public void setIDQR(int IDQR){
        this.IDQR = IDQR;
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
    
    public void setqr(String qr){
        this.qr = qr;
    }
    
    public Time getHoraEntrada()
    {
        return this.horaEntrada;
    }
    
    public void setHoraEntrada(Time horaEntrada)
    {
        this.horaEntrada = horaEntrada;
    }
    
    public Time getHoraSalida()
    {
        return this.horaSalida;
    }
    
    public void setHoraSalida(Time horaSalida)
    {
        this.horaSalida = horaSalida;
    }
    
    
    
}
