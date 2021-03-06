/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package frontend;

import backend.handler.Handler;
import backend.handler.Info;
import java.awt.HeadlessException;
import javax.swing.JOptionPane;

/**
 *
 * @author bcorrales
 */
public class NuevoVuelo extends javax.swing.JFrame {
    
    Handler handler = new Handler();
    
    /**
     * Creates new form NuevoVuelo
     */
    public NuevoVuelo() {
        initComponents();
        setTitle("Agregar Vuelo Público");                                      //Titulo, fondo, redimensionable y ubicacion de la ventana.
        getContentPane().setBackground(Info.getFrameBackground());
        setResizable(false);
        setLocationRelativeTo(null);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtSalida = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        txtDispEconomica = new javax.swing.JTextField();
        btnVolver = new javax.swing.JButton();
        txtLlegada = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCostoEconomica = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDestino = new javax.swing.JTextField();
        txtOrigen = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtDispPrimera = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtCostoPrimera = new javax.swing.JTextField();
        btnAyuda1 = new javax.swing.JButton();
        btnAyuda2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txtSalida.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Id de vuelo");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Disponibles Economica");

        txtId.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtDispEconomica.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnVolver.setBackground(Info.getBtnBackground());
        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnAgregar.setBackground(Info.getBtnBackground());
        btnAgregar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Costo Económica");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setText("Origen");

        txtCostoEconomica.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCostoEconomica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCostoEconomicaActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Destino");

        txtDestino.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtDestino.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDestinoActionPerformed(evt);
            }
        });

        txtOrigen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Fecha de llegada");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Modelo");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Fecha de Salida");

        txtModelo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Disponibles Primera Clase");

        txtDispPrimera.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Costo Primera Clase");

        txtCostoPrimera.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnAyuda1.setContentAreaFilled(false);
        btnAyuda1.setFocusPainted(false);
        btnAyuda1.setOpaque(false);
        btnAyuda1.setBorder(null);
        btnAyuda1.setToolTipText("<html>Debe introducirlo en el siguiente formato : aaMMddHHmm<br>Ej: 1812170806</html>");
        btnAyuda1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/media/help.png"))); // NOI18N

        btnAyuda2.setContentAreaFilled(false);
        btnAyuda2.setFocusPainted(false);
        btnAyuda2.setOpaque(false);
        btnAyuda2.setBorder(null);
        btnAyuda2.setToolTipText("<html>Debe introducirlo en el siguiente formato : aaMMddHHmm<br>Ej: 1812170806</html>");
        btnAyuda2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/frontend/media/help.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVolver)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(179, 179, 179)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtModelo)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDispEconomica, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(127, 127, 127)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCostoEconomica)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtDispPrimera)
                                .addComponent(txtSalida, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(txtOrigen))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAyuda2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtLlegada, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtCostoPrimera)
                            .addComponent(txtDestino, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtOrigen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDestino, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAyuda1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(btnAyuda2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLlegada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDispPrimera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCostoPrimera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtDispEconomica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCostoEconomica, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVolver)
                    .addComponent(btnAgregar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        AdminHome window = new AdminHome();
        window.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVolverActionPerformed
    
    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        // TODO add your handling code here:
        try{
            String idVuelo = txtId.getText();                                   //Se guardan todos los datos ingresados por el admin en variables.
            String modelo = txtModelo.getText();
            String origen = txtOrigen.getText();
            String destino = txtDestino.getText();
            int fechaSalida = Integer.parseInt(txtSalida.getText());            //Conversion a int para los datos necesarios.
            int fechaLlegada = Integer.parseInt(txtLlegada.getText());
            int dispPrimera = Integer.parseInt(txtDispPrimera.getText());
            int costoPrimera = Integer.parseInt(txtCostoPrimera.getText());
            int dispEconomica = Integer.parseInt(txtDispEconomica.getText());
            int costoEconomica = Integer.parseInt(txtCostoEconomica.getText());
            if(handler.verificarDuplicadosPub(idVuelo)){                        //Se busca en todos los vuelos publicos si ya existe un vuelo con el mismo ID, para notificar y no agregarlo.
                JOptionPane.showMessageDialog(null, "Ya existe otro vuelo con ese id.", "Error", JOptionPane.ERROR_MESSAGE);
            }else{
                if (txtSalida.getText().length() == 10 && txtLlegada.getText().length() == 10){ //Requisito para el ingreso de las fechas.
                    try{                                                        //Se meten los datos guardados en las variables como parametros al metodo que agrega vuelos publicos.
                        handler.addNuevoVueloPublico(origen, destino, modelo, idVuelo, fechaSalida, fechaLlegada, dispPrimera, dispEconomica, costoPrimera, costoEconomica);
                        JOptionPane.showMessageDialog(null, "Vuelo agregado con éxito.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                        txtId.setText("");
                        txtOrigen.setText("");
                        txtModelo.setText("");
                        txtDestino.setText("");
                        txtSalida.setText("");
                        txtLlegada.setText("");
                        txtDispPrimera.setText("");
                        txtDispEconomica.setText("");
                        txtCostoPrimera.setText("");
                        txtCostoEconomica.setText("");
                    }catch(HeadlessException e){
                        
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Debe seguir el formato de fecha establecido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                
            }
        }catch (NumberFormatException e){                                       //Manejo de errores.
            JOptionPane.showMessageDialog(null, "Los campos de fechas, asientos y costo deben ser introducidos en números.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarActionPerformed
    
    private void txtDestinoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDestinoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDestinoActionPerformed
    
    private void txtCostoEconomicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCostoEconomicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCostoEconomicaActionPerformed
    
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
            java.util.logging.Logger.getLogger(NuevoVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoVuelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoVuelo().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnAyuda1;
    private javax.swing.JButton btnAyuda2;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txtCostoEconomica;
    private javax.swing.JTextField txtCostoPrimera;
    private javax.swing.JTextField txtDestino;
    private javax.swing.JTextField txtDispEconomica;
    private javax.swing.JTextField txtDispPrimera;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtLlegada;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtOrigen;
    private javax.swing.JTextField txtSalida;
    // End of variables declaration//GEN-END:variables
}
