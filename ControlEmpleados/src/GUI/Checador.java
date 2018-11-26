/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import BL.EntradaSalidaBL;
import BL.empleadoBL;
import DAL.EntradaSalidaDAL;
import DAL.empleadoDAL;
import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author danie
 */
public class Checador extends javax.swing.JFrame {
    Date fechaActual;
    /**
     * Creates new form Checador
     */
    public Checador() {
        
        
        
        initComponents();
        
        lblIcono.setVisible(false);
        lblMensaje.setVisible(false);
        
        fechaActual = new Date();
        DateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");
        lblFecha.setText(fechaFormat.format(fechaActual));
        DateFormat horaFormat = new SimpleDateFormat("hh:mm:ss");
        lblHora.setText(horaFormat.format(fechaActual));
        Dimension size = WebcamResolution.QVGA.getSize();
        Webcam webcam = Webcam.getDefault();
        webcam.setViewSize(size);
        webcam.open();
        
        WebcamPanel panel = new WebcamPanel(webcam);
        panel.setPreferredSize(size);
        //panel.setFPSDisplayed(true);
        panel.setBounds(240,140,150,150);
        add(panel);
        
        Timer timer =  new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    fechaActual = new Date();
                    DateFormat fechaFormat = new SimpleDateFormat("dd/MM/yyyy");
                    lblFecha.setText(fechaFormat.format(fechaActual));
                    DateFormat horaFormat = new SimpleDateFormat("hh:mm:ss");
                    lblHora.setText(horaFormat.format(fechaActual));
                    
                    BufferedImage image = webcam.getImage();
                    LuminanceSource source = new BufferedImageLuminanceSource(image);
                    BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                    
                    Result result = new MultiFormatReader().decode(bitmap);
                    if(result.getText() != null){
                        empleadoDAL empleados = new empleadoDAL();
                        empleadoBL empleado = empleados.BuscarEmpleado(Integer.parseInt(result.getText()));
                        
                        lblNombre.setText(empleado.getnombreEmp());
                        //BufferedImage fotoEmp = ImageIO.read(new ByteArrayInputStream());
                        
                        
                        EntradaSalidaDAL entradasSalidas = new EntradaSalidaDAL();
                        EntradaSalidaBL entSal = new EntradaSalidaBL();
                        entSal.setIdEmpleado(empleado.getId());
                        entSal.setFecha(new java.sql.Date(fechaActual.getTime()));
                        entSal.setHora(new java.sql.Time(fechaActual.getTime()));
                        if(!entradasSalidas.EntradaPrevia(empleado.getId())){
                           
                            lblMensaje.setText("Entrada Registrada");
                            entSal.setTipo(false);
                        }else{
                            entSal.setTipo(true);
                             lblMensaje.setText("Salida Registrada");
                        }
                        entradasSalidas.AgregarEntrada(entSal);
                        
                        lblIcono.setVisible(true); 
                        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/002-checked.png")));
                        lblMensaje.setVisible(true);
                        
                        java.util.Timer timerout = new java.util.Timer();
                        
                        java.util.TimerTask task = new TimerTask() {
                            @Override
                            public void run() {
                                lblNombre.setText("Bienvenido");
                                lblIcono.setVisible(false);
                                lblMensaje.setVisible(false);
                                lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/001-man-user.png")));
                                timerout.cancel();
                            }
                        };
                        
                        timerout.schedule(task, 2500,1000);
                        
                        
                        
                        //ByteArrayInputStream b = new ByteArrayInputStream(empleado.getfoto());
                        //ImageIcon icon = new ImageIcon(empleado.getfoto());
                       
                        //BufferedImage bf = ImageIO.read(b);
                        //ImageIcon icon1 = new ImageIcon(bf);
                        //Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblImagen.getWidth(), lblImagen.getHeight(), Image.SCALE_SMOOTH));
                        //lblImagen.setIcon(icon);
                        
                    }
                } catch (NotFoundException ex) {
                    Logger.getLogger(Checador.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Checador.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
        
        timer.start();
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHora = new javax.swing.JLabel();
        lblFecha = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblImagen = new javax.swing.JLabel();
        lblIcono = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblHora.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        lblHora.setText("00:00:00");

        lblFecha.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblFecha.setText("00/00/00");

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("Bienvenido");

        lblImagen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/001-man-user.png"))); // NOI18N

        lblIcono.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/001-man-user.png"))); // NOI18N
        lblIcono.setText(",.");

        lblMensaje.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblMensaje.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMensaje.setText("Mensaje");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblFecha)
                            .addComponent(lblHora)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblMensaje)
                    .addComponent(lblIcono))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblHora, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre)
                .addGap(18, 18, 18)
                .addComponent(lblIcono)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblMensaje)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Checador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Checador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Checador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Checador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Checador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblFecha;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblIcono;
    private javax.swing.JLabel lblImagen;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblNombre;
    // End of variables declaration//GEN-END:variables
}
