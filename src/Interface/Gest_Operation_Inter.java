/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interface;

import Entite.Compte;
import Entite.Operation;
import Gest_Ent.*;
import Gest_Ent.Gest_Compte;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HS-PC
 */
public class Gest_Operation_Inter extends javax.swing.JFrame {

    private static int nbOperation = 0;
    private Compte compte;

    /**
     * Creates new form Gest_employe
     */
    public Gest_Operation_Inter(Compte compte) {
        initComponents();
        this.setTitle("Gestion des opérations");
        this.setLocationRelativeTo(null);
        this.compte = compte;
        lblTitle.setText("Liste des oprations du compte \" " + compte.getNumCopte() + " \"");
        afficherOperations(compte.getNumCopte());
    }

    public Gest_Operation_Inter() {
        initComponents();

        this.setTitle("Gestion des opérations");
        this.setLocationRelativeTo(null);
        afficherOperations(compte.getNumCopte());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        dateChooserCombo1 = new datechooser.beans.DateChooserCombo();
        lblTitle = new javax.swing.JLabel();
        btnRet = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblOperations = new javax.swing.JTable();
        btnVer = new javax.swing.JButton();
        btnTra = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        lblNbEmploye = new javax.swing.JLabel();
        txtSolde = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNumComte = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N

        btnRet.setText("Retraits");
        btnRet.setEnabled(false);
        btnRet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetActionPerformed(evt);
            }
        });

        tblOperations.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Num Operatio", "Date ", "Type", "Solde", "Effectué par"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblOperations.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOperationsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblOperations);
        if (tblOperations.getColumnModel().getColumnCount() > 0) {
            tblOperations.getColumnModel().getColumn(0).setResizable(false);
        }

        btnVer.setText("Versements");
        btnVer.setEnabled(false);
        btnVer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerActionPerformed(evt);
            }
        });

        btnTra.setText("Transfert");
        btnTra.setEnabled(false);
        btnTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraActionPerformed(evt);
            }
        });

        txtSearch.setToolTipText("");
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        lblNbEmploye.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N

        txtSolde.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoldeKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Solde :");

        txtNumComte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumComteKeyReleased(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Num_compte :");

        jButton1.setText("Annuler");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnTra)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnVer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(btnRet, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel8))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNumComte)
                            .addComponent(txtSolde, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE))))
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblNbEmploye)
                        .addGap(370, 370, 370)
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 647, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNbEmploye, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSolde, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 78, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumComte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTra)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnRet)
                                .addComponent(btnVer))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addGap(7, 7, 7))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraActionPerformed

        Gest_Compte gest_Compte = new Gest_Compte();

        if (this.compte.getSolde() >= Float.parseFloat(txtSolde.getText()) && gest_Compte.AfficheCompte(txtNumComte.getText()) != null && this.compte.getNumCopte() != Float.parseFloat(txtNumComte.getText())) {
            gest_Compte.transfert(compte, Float.parseFloat(txtSolde.getText()), gest_Compte.AfficheCompte(txtNumComte.getText()));
            Gest_Compte_Inter gest_Compte_Inter = new Gest_Compte_Inter();
            gest_Compte_Inter.setVisible(true);
            dispose();

        } else {
            JFrame frame = new JFrame("Message");
            JOptionPane.showMessageDialog(frame, "Probleme de transfert", "Erreur", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btnTraActionPerformed

    private void btnVerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerActionPerformed
        Gest_Compte gest_Compte = new Gest_Compte();
        gest_Compte.Versements(compte, Float.parseFloat(txtSolde.getText()));
        afficherOperations(compte.getNumCopte());
        Gest_Compte_Inter gest_Compte_Inter = new Gest_Compte_Inter();
        gest_Compte_Inter.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnVerActionPerformed

    public void afficherOperations(int numCopte) {
        Gest_Operation gc = new Gest_Operation();
        ArrayList<Operation> c = gc.AfficheOperations(numCopte);

        DefaultTableModel model = (DefaultTableModel) tblOperations.getModel();
        model.setNumRows(0);

        Object[] data = new Object[6];

        model.setRowCount(0);
        for (int i = 0; i < c.size(); i++) {

            data[0] = c.get(i).getNumOperation();
            data[1] = c.get(i).getDateOperation();
            data[2] = c.get(i).getTypeOperation();
            data[3] = c.get(i).getSolde();
            data[4] = c.get(i).getCode();

            model.addRow(data);
        }

    }


    private void tblOperationsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOperationsMouseClicked

    }//GEN-LAST:event_tblOperationsMouseClicked

    private void btnRetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetActionPerformed

        if (this.compte.getSolde() >= Float.parseFloat(txtSolde.getText())) {
            Gest_Compte gest_Compte = new Gest_Compte();
            gest_Compte.Retraits(compte, Float.parseFloat(txtSolde.getText()));
            afficherOperations(compte.getNumCopte());
            Gest_Compte_Inter gest_Compte_Inter = new Gest_Compte_Inter();
            gest_Compte_Inter.setVisible(true);
            dispose();

        } else {

            JFrame frame = new JFrame("Message");
            JOptionPane.showMessageDialog(frame, "Impossible de traiter le retrait : solde du compte trop faible", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnRetActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased


    }//GEN-LAST:event_txtSearchKeyReleased

    private void txtNumComteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumComteKeyReleased

        if (!txtSolde.getText().isEmpty() && !txtNumComte.getText().isEmpty()) {

            btnRet.setEnabled(false);
            btnVer.setEnabled(false);
            btnTra.setEnabled(true);

        } else {

            btnTra.setEnabled(false);
            btnRet.setEnabled(true);
            btnVer.setEnabled(true);

        }

    }//GEN-LAST:event_txtNumComteKeyReleased

    private void txtSoldeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoldeKeyReleased
        if (!txtSolde.getText().isEmpty()) {

            btnRet.setEnabled(true);
            btnVer.setEnabled(true);

        } else {
            btnRet.setEnabled(false);
            btnVer.setEnabled(false);
        }
    }//GEN-LAST:event_txtSoldeKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Gest_Compte_Inter gest_Compte_Inter = new Gest_Compte_Inter();
        gest_Compte_Inter.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Gest_Operation_Inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Gest_Operation_Inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Gest_Operation_Inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Gest_Operation_Inter.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new Gest_Operation_Inter().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRet;
    private javax.swing.JButton btnTra;
    private javax.swing.JButton btnVer;
    private javax.swing.ButtonGroup buttonGroup1;
    private datechooser.beans.DateChooserCombo dateChooserCombo1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblNbEmploye;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable tblOperations;
    private javax.swing.JTextField txtNumComte;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSolde;
    // End of variables declaration//GEN-END:variables
}
