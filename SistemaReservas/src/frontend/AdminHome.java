/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package frontend;

import backend.Handler;
import backend.Info;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author robq9
 */
public class AdminHome extends javax.swing.JFrame {
    
    Handler handler = new Handler();
    
    /**
     * Creates new form AdminHome
     */
    public AdminHome() {
        
        initComponents();
        setTitle("Acceso Administrador");
        getContentPane().setBackground(Info.getFrameBackground());
        setResizable(false);
        setLocationRelativeTo(null);
        String usuario = InicioSesion.getUsuario();
        int nivel = handler.obtenerNivel(usuario);
        switch(nivel){
            case 0:
                // Todos los privilegios
                break;
            case 1:
                btnEliminar.setEnabled(false);
                btnEliminarPriv.setEnabled(false);
                break;
            case 2:
                btnEliminar.setEnabled(false);
                btnEliminarPriv.setEnabled(false);
                btnVueloPriv.setEnabled(false);
                btnVueloPub.setEnabled(false);
                break;
            case 3:
                btnEliminar.setEnabled(false);
                btnEliminarPriv.setEnabled(false);
                btnVueloPriv.setEnabled(false);
                btnVueloPub.setEnabled(false);
                btnPrecios.setEnabled(false);
                break;
            case 4:
                btnEliminar.setEnabled(false);
                btnEliminarPriv.setEnabled(false);
                btnVueloPriv.setEnabled(false);
                btnVueloPub.setEnabled(false);
                btnCrear.setEnabled(false);
                btnPrecios.setEnabled(false);
                break;
            default:
                btnEliminar.setEnabled(false);
                btnEliminarPriv.setEnabled(false);
                btnVueloPriv.setEnabled(false);
                btnVueloPub.setEnabled(false);
                btnCrear.setEnabled(false);
                btnPrecios.setEnabled(false);
                btnContrasena.setEnabled(false);
                break;
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnPrecios = new javax.swing.JButton();
        btnVueloPub = new javax.swing.JButton();
        btnVueloPriv = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnContrasena = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        btnEliminarPriv = new javax.swing.JButton();
        btnCrear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        btnPrecios.setBackground(Info.getBtnBackground());
        btnPrecios.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnPrecios.setText("Modificar Precios");
        btnPrecios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPreciosActionPerformed(evt);
            }
        });

        btnVueloPub.setBackground(Info.getBtnBackground());
        btnVueloPub.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVueloPub.setText("Agregar un vuelo");
        btnVueloPub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVueloPubActionPerformed(evt);
            }
        });

        btnVueloPriv.setBackground(Info.getBtnBackground());
        btnVueloPriv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVueloPriv.setText("Agregar vuelo privado");
        btnVueloPriv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVueloPrivActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(Info.getBtnBackground());
        btnEliminar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminar.setText("Eliminar un vuelo");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnContrasena.setBackground(Info.getBtnBackground());
        btnContrasena.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnContrasena.setText("Cambiar contraseña");
        btnContrasena.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnContrasenaActionPerformed(evt);
            }
        });

        btnVolver.setBackground(Info.getBtnBackground());
        btnVolver.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnEliminarPriv.setBackground(Info.getBtnBackground());
        btnEliminarPriv.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEliminarPriv.setText("Eliminar vuelo privado");
        btnEliminarPriv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarPrivActionPerformed(evt);
            }
        });

        btnCrear.setBackground(Info.getBtnBackground());
        btnCrear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCrear.setText("Crear nuevo administrador");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEliminarPriv, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnVueloPriv)
                            .addComponent(btnVueloPub, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnVolver, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCrear, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPrecios, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminarPriv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnVueloPriv, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnVueloPub, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(btnCrear, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        try {
            // TODO add your handling code here:
            Home window = new Home();
            window.setVisible(true);
            dispose();
        } catch (ParseException ex) {
            Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnVolverActionPerformed
    
    private void btnPreciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPreciosActionPerformed
        try {
            // TODO add your handling code here:
            ModificarPrecios window = new ModificarPrecios();
            window.setVisible(true);
            dispose();
        } catch (ParseException ex) {
            Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPreciosActionPerformed
    
    private void btnContrasenaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnContrasenaActionPerformed
        // TODO add your handling code here:
        CambiarContrasena window = new CambiarContrasena();
        window.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnContrasenaActionPerformed
    
    private void btnVueloPrivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVueloPrivActionPerformed
        // TODO add your handling code here:
        NuevoPrivado window = new NuevoPrivado();
        window.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVueloPrivActionPerformed
    
    private void btnVueloPubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVueloPubActionPerformed
        // TODO add your handling code here:
        NuevoVuelo window = new NuevoVuelo();
        window.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnVueloPubActionPerformed
    
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        try {
            // TODO add your handling code here:
            EliminarVuelo window = new EliminarVuelo();
            window.setVisible(true);
            dispose();
        } catch (ParseException ex) {
            Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarActionPerformed
    
    private void btnEliminarPrivActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarPrivActionPerformed
        try {
            // TODO add your handling code here:
            EliminarPrivado window = new EliminarPrivado();
            window.setVisible(true);
            dispose();
        } catch (ParseException ex) {
            Logger.getLogger(AdminHome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnEliminarPrivActionPerformed
    
    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        // TODO add your handling code here:
        NuevoUsuario window = new NuevoUsuario();
        window.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCrearActionPerformed
    
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
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminHome().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnContrasena;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnEliminarPriv;
    private javax.swing.JButton btnPrecios;
    private javax.swing.JButton btnVolver;
    private javax.swing.JButton btnVueloPriv;
    private javax.swing.JButton btnVueloPub;
    // End of variables declaration//GEN-END:variables
}
