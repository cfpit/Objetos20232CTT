package nio.notepad;


import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Notepad extends javax.swing.JFrame {
    public Notepad() {
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txaTexto = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        mnuNuevo = new javax.swing.JMenuItem();
        mnuAbrir = new javax.swing.JMenuItem();
        mnuGuardar = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnuAcerca = new javax.swing.JMenuItem();
        mnuSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bloc de Notas");

        txaTexto.setColumns(20);
        txaTexto.setFont(new java.awt.Font("Ubuntu", 0, 16)); // NOI18N
        txaTexto.setRows(5);
        jScrollPane1.setViewportView(txaTexto);

        jMenu1.setText("Archivo");

        mnuNuevo.setText("Nuevo");
        mnuNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuNuevoActionPerformed(evt);
            }
        });
        jMenu1.add(mnuNuevo);

        mnuAbrir.setText("Abrir");
        mnuAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAbrirActionPerformed(evt);
            }
        });
        jMenu1.add(mnuAbrir);

        mnuGuardar.setText("Guardar");
        mnuGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuGuardarActionPerformed(evt);
            }
        });
        jMenu1.add(mnuGuardar);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opciones");

        mnuAcerca.setText("Acerca de");
        mnuAcerca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuAcercaActionPerformed(evt);
            }
        });
        jMenu2.add(mnuAcerca);

        mnuSalir.setText("Salir");
        mnuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnuSalirActionPerformed(evt);
            }
        });
        jMenu2.add(mnuSalir);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 317, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnuAcercaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAcercaActionPerformed
        // Evento Acerca
        JOptionPane.showMessageDialog(this, "Bloc de notas");
    }//GEN-LAST:event_mnuAcercaActionPerformed

    private void mnuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuSalirActionPerformed
        // Evento Salir
        System.exit(0);
    }//GEN-LAST:event_mnuSalirActionPerformed

    private void mnuNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuNuevoActionPerformed
        // Evento nuevo
        if(txaTexto.getText().isEmpty()) return;
        if(JOptionPane.showConfirmDialog(this, "Desea borrar el texto?")==0)
            txaTexto.setText("");
    }//GEN-LAST:event_mnuNuevoActionPerformed

    private void mnuAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuAbrirActionPerformed
        // Evento Abrir
        JFileChooser fc=new JFileChooser();
        fc.showOpenDialog(this);
        File file=fc.getSelectedFile();
        if(file==null) return;
        txaTexto.setText(new FileText(file).getText());
    }//GEN-LAST:event_mnuAbrirActionPerformed

    private void mnuGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnuGuardarActionPerformed
        // Evento Guardar
        JFileChooser fc=new JFileChooser();
        fc.showSaveDialog(this);
        File file=fc.getSelectedFile();
        if(file==null) return;
        new FileText(file).setText(txaTexto.getText());
    }//GEN-LAST:event_mnuGuardarActionPerformed
    
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
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Notepad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Notepad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem mnuAbrir;
    private javax.swing.JMenuItem mnuAcerca;
    private javax.swing.JMenuItem mnuGuardar;
    private javax.swing.JMenuItem mnuNuevo;
    private javax.swing.JMenuItem mnuSalir;
    private javax.swing.JTextArea txaTexto;
    // End of variables declaration//GEN-END:variables
}
