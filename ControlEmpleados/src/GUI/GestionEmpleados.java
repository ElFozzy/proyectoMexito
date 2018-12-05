  package GUI;




import DAL.Conexion;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import BL.empleadoBL;
import DAL.DiasLaboralesDAL;
import DAL.empleadoDAL;
import Reportes.ReporteGafete;
import com.barcodelib.barcode.QRCode;
import com.sun.javafx.scene.layout.region.Margins;
import java.awt.Desktop;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import static java.util.Locale.filter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.filechooser.FileNameExtensionFilter;
/**
 *
 * @author Christian
 * 
 * 
 */
public class GestionEmpleados extends javax.swing.JFrame {
    Conexion conn = new Conexion();

    empleadoBL objempBL = new empleadoBL();
    empleadoDAL objempDAL = new empleadoDAL();
    DiasLaboralesDAL laborales = new DiasLaboralesDAL();
    int udm = 0, resol = 72, rot=0;
    float mi = 5.000f, md = 5.000f, ms = 5.000f, min = 5.000f, tam=50.00f;
    
    private JPanel contentPane;
    File fichero = null;
    
    ArrayList dias = new ArrayList();
    
    /**
     * Creates new form Add_Employed
     */
    public GestionEmpleados() {
        initComponents();
        txtFoto.setVisible(false);
        txtId.setVisible(false);
        txtIDQR.setVisible(false);
        txtRutaQr.setVisible(false);
        this.setLocationRelativeTo(null);
        
        ActualizarEmpleado();    
    }
      
    
    public void CleanData(){
        txtNombre.setText("");
        txtId.setText("0");
        cboSexo.setSelectedIndex(0);
        dtIngreso.setDate(null);
        dtRetiro.setDate(null);
        cboTurno.setSelectedIndex(0);        
        txtFoto.setText("");
        lbLoadImage.setIcon(null);   
       
             chkLunes.setSelected(false);
       
             chkMartes.setSelected(false);
       
             chkMiercoles.setSelected(false);
       
             chkJuves.setSelected(false);
       
             chkViernes.setSelected(false);
       
            chkSabado.setSelected(false);
       
            chkDomingo.setSelected(false);
        
    }
        
    public empleadoBL RecolectarQR(){
        int idqr = Integer.parseInt(txtIDQR.getText());
        objempBL.setIDQR(idqr);
        objempBL.setqr(txtRutaQr.getText());        
        
        return objempBL;
    }
    
    public empleadoBL RecolectarDatos(){            
        dias = new ArrayList();
            int id = Integer.parseInt(txtId.getText());
            String fechaIngreso = dtIngreso.getDate().toString();
            String fechaRetiro = dtRetiro.getDate().toString();
            String sexo;
            String turno;
            if(cboSexo.getSelectedItem().toString().equals("Masculino")){
                sexo = "Masculino";
            }else{
                sexo = "Femenino";
            }
            
            if(cboTurno.getSelectedItem().toString().equals("Matutino")){
                turno = "Matutino";
            }else{
                turno = "Vespertino";
            }
            
            objempBL.setId(id);
            objempBL.setnombreEmp(txtNombre.getText());
            objempBL.setsexo(sexo);
            objempBL.setfechaIng(fechaIngreso);
            objempBL.setfechaRet(fechaRetiro);
            objempBL.setturno(turno);
            objempBL.setfoto(txtFoto.getText());                                                            
            objempBL.setfoto(txtFoto.getText());
            
            objempBL.setHoraEntrada(tpEnt.getText());
            objempBL.setHoraSalida(tpSal.getText());
            
            if(chkLunes.isSelected())
                dias.add(1);
            if(chkMartes.isSelected())
                dias.add(2);
            if(chkMiercoles.isSelected())
                dias.add(3);
            if(chkJuves.isSelected())
                dias.add(4);
            if(chkViernes.isSelected())
                dias.add(5);
            if(chkSabado.isSelected())
                dias.add(6); 
            if(chkDomingo.isSelected())
                dias.add(0);
                            
        return objempBL;
    }
    
    public void ActualizarEmpleado(){
        tbEmpleados.setModel(objempDAL.CargarDatos());
        tbEmpleados.getColumn(tbEmpleados.getColumnName(2)).setWidth(0);
        tbEmpleados.getColumn(tbEmpleados.getColumnName(2)).setMinWidth(0);
        tbEmpleados.getColumn(tbEmpleados.getColumnName(2)).setMaxWidth(0);
        tbEmpleados.getColumn(tbEmpleados.getColumnName(6)).setWidth(0);
        tbEmpleados.getColumn(tbEmpleados.getColumnName(6)).setMinWidth(0);
        tbEmpleados.getColumn(tbEmpleados.getColumnName(6)).setMaxWidth(0);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jXDatePicker3 = new org.jdesktop.swingx.JXDatePicker();
        txtFoto = new javax.swing.JTextField();
        txtRutaQr = new javax.swing.JTextField();
        txtIDQR = new javax.swing.JTextField();
        btnSelectImage = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        cboSexo = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        dtIngreso = new org.jdesktop.swingx.JXDatePicker();
        jLabel5 = new javax.swing.JLabel();
        dtRetiro = new org.jdesktop.swingx.JXDatePicker();
        jLabel6 = new javax.swing.JLabel();
        cboTurno = new javax.swing.JComboBox<>();
        btnGuardar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbEmpleados = new javax.swing.JTable();
        btnEditar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        txtId = new javax.swing.JTextField();
        lbLoadImage = new javax.swing.JLabel();
        btnGenerarQR = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        tpEnt = new com.github.lgooddatepicker.components.TimePicker();
        tpSal = new com.github.lgooddatepicker.components.TimePicker();
        jPanel1 = new javax.swing.JPanel();
        chkLunes = new javax.swing.JCheckBox();
        chkMartes = new javax.swing.JCheckBox();
        chkMiercoles = new javax.swing.JCheckBox();
        chkJuves = new javax.swing.JCheckBox();
        chkViernes = new javax.swing.JCheckBox();
        chkSabado = new javax.swing.JCheckBox();
        chkDomingo = new javax.swing.JCheckBox();

        txtRutaQr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtRutaQrActionPerformed(evt);
            }
        });

        txtIDQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIDQRActionPerformed(evt);
            }
        });

        setTitle("Generar Empleado");

        btnSelectImage.setText("Seleccionar Foto");
        btnSelectImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelectImageActionPerformed(evt);
            }
        });

        jLabel1.setText("Datos Generales");
        jLabel1.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        jLabel2.setText("Nombre Completo");

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel3.setText("Sexo");

        cboSexo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino", " " }));

        jLabel4.setText("Fecha de Ingreso");

        jLabel5.setText("Fecha de Retiro");

        jLabel6.setText("Turno");

        cboTurno.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Matutino", "Vespertino" }));

        btnGuardar.setText("Guardar Datos");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        tbEmpleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Foto", "Sexo", "Fecha Ingreso", "Fecha Returo", "Turno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbEmpleados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbEmpleadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbEmpleados);
        if (tbEmpleados.getColumnModel().getColumnCount() > 0) {
            tbEmpleados.getColumnModel().getColumn(0).setResizable(false);
            tbEmpleados.getColumnModel().getColumn(1).setResizable(false);
            tbEmpleados.getColumnModel().getColumn(2).setResizable(false);
            tbEmpleados.getColumnModel().getColumn(3).setResizable(false);
            tbEmpleados.getColumnModel().getColumn(4).setResizable(false);
            tbEmpleados.getColumnModel().getColumn(5).setResizable(false);
            tbEmpleados.getColumnModel().getColumn(6).setResizable(false);
        }

        btnEditar.setText("Editar Datos");
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar Empleado");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });

        txtId.setText("0");
        txtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIdActionPerformed(evt);
            }
        });

        lbLoadImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbLoadImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/001-man-user.png"))); // NOI18N

        btnGenerarQR.setText("Generar gafete");
        btnGenerarQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerarQRActionPerformed(evt);
            }
        });

        jLabel7.setText("Hora de entrada:");

        jLabel9.setText("Hora de salida:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Dias a laborar"));

        chkLunes.setText("Lunes");

        chkMartes.setText("Martes");
        chkMartes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMartesActionPerformed(evt);
            }
        });

        chkMiercoles.setText("Miercoles");
        chkMiercoles.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkMiercolesActionPerformed(evt);
            }
        });

        chkJuves.setText("Jueves");

        chkViernes.setText("Viernes");

        chkSabado.setText("Sabado");

        chkDomingo.setText("Domingo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chkLunes)
                .addGap(10, 10, 10)
                .addComponent(chkMartes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkMiercoles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkJuves)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkViernes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(chkSabado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(chkDomingo)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(chkLunes)
                .addComponent(chkMartes)
                .addComponent(chkMiercoles)
                .addComponent(chkJuves)
                .addComponent(chkViernes)
                .addComponent(chkSabado)
                .addComponent(chkDomingo))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(btnLimpiar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btnSelectImage, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnEditar)
                                .addGap(18, 18, 18)
                                .addComponent(btnEliminar)
                                .addGap(18, 18, 18)
                                .addComponent(btnGenerarQR))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 15, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dtRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(207, 207, 207)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cboTurno, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(tpSal, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(lbLoadImage, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(6, 6, 6)
                                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createSequentialGroup()
                                                    .addComponent(jLabel4)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(dtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(27, 27, 27)
                                        .addComponent(jLabel6))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tpEnt, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbLoadImage, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(dtRetiro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cboSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)
                            .addComponent(cboTurno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tpEnt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(tpSal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(btnSelectImage)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLimpiar)
                    .addComponent(btnGuardar)
                    .addComponent(btnEditar)
                    .addComponent(btnEliminar)
                    .addComponent(btnGenerarQR))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbEmpleadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbEmpleadosMouseClicked
        // TODO add your handling code here:
         BufferedImage img = null;
          int row = tbEmpleados.getSelectedRow();
        JTable target = (JTable)evt.getSource();
        txtId.setText(target.getValueAt(row,0).toString());
        txtNombre.setText(target.getValueAt(row,1).toString());    
        cboSexo.setSelectedItem(target.getValueAt(row,3));
        dtIngreso.setDate(new Date(target.getValueAt(row,4).toString()));
        dtRetiro.setDate(new Date(target.getValueAt(row,5).toString()));
        cboTurno.setSelectedItem(target.getValueAt(row,7));  
        String r = target.getValueAt(row, 2).toString();
        txtFoto.setText(r);
        ImageIcon icon = new ImageIcon(r);
        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lbLoadImage.getWidth(), lbLoadImage.getHeight(), Image.SCALE_SMOOTH));
        lbLoadImage.setText(null);
        lbLoadImage.setIcon(icono);
        
        tpEnt.setText(target.getValueAt(row, 8).toString());
        tpSal.setText(target.getValueAt(row, 9).toString());
        
        chkLunes.setSelected(false);
       
             chkMartes.setSelected(false);
       
             chkMiercoles.setSelected(false);
       
             chkJuves.setSelected(false);
       
             chkViernes.setSelected(false);
       
            chkSabado.setSelected(false);
       
            chkDomingo.setSelected(false);
        
        ArrayList diasL = laborales.SeleccionarDias(Integer.parseInt(txtId.getText()));
        
        if(diasL.contains(1))
        {
             chkLunes.setSelected(true);
        }
        if(diasL.contains(2))
        {
             chkMartes.setSelected(true);
        }
        if(diasL.contains(3))
        {
             chkMiercoles.setSelected(true);
        }
        if(diasL.contains(4))
        {
             chkJuves.setSelected(true);
        }
        if(diasL.contains(5))
        {
             chkViernes.setSelected(true);
        }
        if(diasL.contains(6))
        {
            chkSabado.setSelected(true);
        }
        if(diasL.contains(0))
        {
            chkDomingo.setSelected(true);
        }
        
        
        
    }//GEN-LAST:event_tbEmpleadosMouseClicked

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:

        objempDAL.Agregar(RecolectarDatos());         
        int qrid = objempDAL.obtenerIdFinal();
        txtIDQR.setText(Integer.toString(qrid));
        String idUser = txtIDQR.getText();
        generarQR(idUser);        
        objempDAL.AgregarQR(RecolectarQR());
        
        for(int i=0; i<dias.size(); i++){
            laborales.AgregarDiaLaboral(Integer.parseInt(idUser), Integer.parseInt(dias.get(i).toString()));
        }
                
        ActualizarEmpleado();
        CleanData();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void txtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIdActionPerformed
        // TODO add your handling code here:        
    }//GEN-LAST:event_txtIdActionPerformed

    private void btnSelectImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelectImageActionPerformed
        JFileChooser file = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("*.jpg", "jpg");
        file.setFileFilter(filtro);
        
       int seleccion = file.showOpenDialog(contentPane);
        
       if(seleccion == JFileChooser.APPROVE_OPTION){
            fichero = file.getSelectedFile();
            txtFoto.setText(fichero.getAbsolutePath());
            ImageIcon icon = new ImageIcon(fichero.toString());
            System.out.print(fichero.getName());
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lbLoadImage.getWidth(), lbLoadImage.getHeight(), Image.SCALE_DEFAULT));
            lbLoadImage.setText(null);
            lbLoadImage.setIcon(icono);
        }
        
    }//GEN-LAST:event_btnSelectImageActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
        objempDAL.Eliminar(RecolectarDatos());
        ActualizarEmpleado();
        CleanData();
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        // TODO add your handling code here:
        CleanData();
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        // TODO add your handling code here:
        objempDAL.Modificar(RecolectarDatos());
        
        laborales.EliminarDiasLaborales(objempBL.getId());
        
        for(int i=0; i<dias.size(); i++){
            laborales.AgregarDiaLaboral(objempBL.getId(), Integer.parseInt(dias.get(i).toString()));
        }

        
        ActualizarEmpleado();
        CleanData();
    }//GEN-LAST:event_btnEditarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // TODO add your handling code here:       
    }//GEN-LAST:event_txtNombreKeyTyped

    public void generarQR(String data){        
        try{            
            QRCode c = new QRCode();
            c.setData(data);
            c.setDataMode(QRCode.MODE_BYTE);
            c.setUOM(udm);
            c.setLeftMargin(mi);
            c.setRightMargin(md);
            c.setTopMargin(ms);
            c.setBottomMargin(min);
            c.setResolution(resol);
            c.setRotate(rot);
            c.setModuleSize(mi);
            
                                                     
            int qrid = objempDAL.obtenerIdFinal();                    
            String archivo = System.getProperty("user.home")+"/qrEmpleado"+qrid+".gif";
            c.renderBarcode(archivo);
            //Desktop d = Desktop.getDesktop();
            //d.open(new File(archivo));     
            txtRutaQr.setText(archivo);
                                                
               
            
            /*String archivo = System.getProperty("user.home")+"/qrEmpleado.png";
            c.renderBarcode(archivo);
            Desktop d = Desktop.getDesktop();
            d.open(new File(archivo));
            txtRutaQr.setText(archivo);*/
            
        }catch(Exception ex){
            
        }
    }
    
    private void btnGenerarQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerarQRActionPerformed
        // TODO add your handling code here:
        ReporteGafete reporte = new ReporteGafete();
        reporte.GenerarGafete(Integer.parseInt(txtId.getText()));
        
    }//GEN-LAST:event_btnGenerarQRActionPerformed

    private void txtIDQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIDQRActionPerformed
        
    }//GEN-LAST:event_txtIDQRActionPerformed

    private void txtRutaQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtRutaQrActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtRutaQrActionPerformed

    private void chkMartesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMartesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkMartesActionPerformed

    private void chkMiercolesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkMiercolesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chkMiercolesActionPerformed

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
            java.util.logging.Logger.getLogger(GestionEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GestionEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GestionEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GestionEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GestionEmpleados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnGenerarQR;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnSelectImage;
    private javax.swing.JComboBox<String> cboSexo;
    private javax.swing.JComboBox<String> cboTurno;
    private javax.swing.JCheckBox chkDomingo;
    private javax.swing.JCheckBox chkJuves;
    private javax.swing.JCheckBox chkLunes;
    private javax.swing.JCheckBox chkMartes;
    private javax.swing.JCheckBox chkMiercoles;
    private javax.swing.JCheckBox chkSabado;
    private javax.swing.JCheckBox chkViernes;
    private org.jdesktop.swingx.JXDatePicker dtIngreso;
    private org.jdesktop.swingx.JXDatePicker dtRetiro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXDatePicker jXDatePicker3;
    private javax.swing.JLabel lbLoadImage;
    private javax.swing.JTable tbEmpleados;
    private com.github.lgooddatepicker.components.TimePicker tpEnt;
    private com.github.lgooddatepicker.components.TimePicker tpSal;
    private javax.swing.JTextField txtFoto;
    private javax.swing.JTextField txtIDQR;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtRutaQr;
    // End of variables declaration//GEN-END:variables
}
