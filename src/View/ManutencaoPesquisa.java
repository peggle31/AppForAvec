/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Avaliacao;
import model.dao.AvaliacaoDAO;

/**
 *
 * @author gcgus
 */
public class ManutencaoPesquisa extends javax.swing.JFrame {

    /**
     * Creates new form ManutencaoPesquisa
     */
    public ManutencaoPesquisa() {
        initComponents();
        DefaultTableModel modelo = (DefaultTableModel) jTAvaliacoes.getModel();
        jTAvaliacoes.setRowSorter(new TableRowSorter(modelo));
    
        

        readManutencaoDeAvaliacoes();
    }
    
    public void readManutencaoDeAvaliacoes() {
    
        DefaultTableModel modelo = (DefaultTableModel) jTAvaliacoes.getModel();
        modelo.setNumRows(0);
        AvaliacaoDAO dao = new AvaliacaoDAO();

        for (Avaliacao a: dao.read()) {

            modelo.addRow(new Object[]{
                a.getId_avaliacao(),
                a.getNome(),
                a.getCpf(),
                a.getDt_nascimento(),
                a.getDesc_cidade(),
                a.getDesc_categoria(),
                a.getNota(),
                a.getCreated_at()
            });

        }

    }
        
        public void readForCpf(String cpf) {
        
        DefaultTableModel modelo = (DefaultTableModel) jTAvaliacoes.getModel();
        modelo.setNumRows(0);
        AvaliacaoDAO dao = new AvaliacaoDAO();

        for (Avaliacao a : dao.readForCpf(cpf)) {

            modelo.addRow(new Object[]{
                a.getId_avaliacao(),
                a.getNome(),
                a.getCpf(),
                a.getDt_nascimento(),
                a.getDesc_cidade(),
                a.getDesc_categoria(),
                a.getNota(),
                a.getCreated_at()
            });

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

        jPanel1 = new javax.swing.JPanel();
        txtId_Avaliacao = new javax.swing.JTextField();
        txtNome = new javax.swing.JTextField();
        txtCpf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();
        txtBusca = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        txtCidade = new javax.swing.JTextField();
        txtDt_Nascimento = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAvaliacoes = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtNota = new javax.swing.JTextField();
        txtCategoria = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        txtId_Avaliacao.setEditable(false);
        txtId_Avaliacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtId_AvaliacaoActionPerformed(evt);
            }
        });

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        txtCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCpfActionPerformed(evt);
            }
        });

        jLabel2.setText("ID:");

        jLabel3.setText("NOME");

        jLabel4.setText("CPF");

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnAtualizar.setText("Atualizar");
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        txtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCidadeActionPerformed(evt);
            }
        });

        txtDt_Nascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDt_NascimentoActionPerformed(evt);
            }
        });

        jLabel5.setText("NASCIMENTO");

        jLabel6.setText("CIDADE");

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel1.setText("LISTAGEM DE AVALIAÇÕES");

        jTAvaliacoes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NOME", "CPF", "DATA DE NASCIMENTO", "CIDADE", "CATEGORIA", "NOTA", "CRIADO EM"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTAvaliacoes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTAvaliacoesMouseClicked(evt);
            }
        });
        jTAvaliacoes.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTAvaliacoesKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(jTAvaliacoes);

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setText("DADOS DA PESQUISA");

        jLabel8.setText("CATEGORIA");

        jLabel9.setText("NOTA");

        txtNota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNotaActionPerformed(evt);
            }
        });

        txtCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCategoriaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtId_Avaliacao)
                                .addComponent(jLabel2)
                                .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 86, Short.MAX_VALUE)
                                .addComponent(txtNota))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel9)))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel8)
                            .addComponent(txtCategoria))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtBusca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnBuscar))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDt_Nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 87, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(327, 327, 327)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(336, 336, 336)
                                .addComponent(jLabel7)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel7)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId_Avaliacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDt_Nascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addGap(0, 33, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar))))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAtualizar)
                    .addComponent(btnExcluir))
                .addGap(3, 3, 3)
                .addComponent(jLabel1)
                .addGap(7, 7, 7)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtId_AvaliacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtId_AvaliacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtId_AvaliacaoActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void txtCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCpfActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:

        //        System.out.println("Linha selecionada: "+jTAvaliacoes.getSelectedRow());
        if (jTAvaliacoes.getSelectedRow() != -1) {

            Avaliacao a = new Avaliacao();
            AvaliacaoDAO dao = new AvaliacaoDAO();

            a.setId_avaliacao((int) jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 0));

            dao.delete(a);

            txtId_Avaliacao.setText("");
            txtNome.setText("");
            txtCpf.setText("");
            txtDt_Nascimento.setText("");
            txtCidade.setText("");
            txtNota.setText("");
            txtCategoria.setText("");

            readManutencaoDeAvaliacoes();

        } else {
            JOptionPane.showMessageDialog(null, "Selecione um avaliacao para excluir.");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        // TODO add your handling code here:

        if (jTAvaliacoes.getSelectedRow() != -1) {

            Avaliacao a = new Avaliacao();
            AvaliacaoDAO dao = new AvaliacaoDAO();
            

            a.setNome(txtNome.getText());
            a.setCpf(Long.parseLong(txtCpf.getText()));
            a.setDesc_cidade(txtCidade.getText());
            a.setDesc_categoria(txtCategoria.getText());
            a.setNota(Integer.parseInt(txtNota.getText()));
            a.setId_avaliacao((int) jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 0));
            try {
                dao.update(a);
            } catch (ParseException ex) {
                Logger.getLogger(ManutencaoPesquisa.class.getName()).log(Level.SEVERE, null, ex);
            }

            txtId_Avaliacao.setText("");
            txtNome.setText("");
            txtCpf.setText("");
            txtDt_Nascimento.setText("");
            txtCidade.setText("");
            txtNota.setText("");
            txtCategoria.setText("");

            readManutencaoDeAvaliacoes();

        }
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        // TODO add your handling code here:
        readForCpf(txtBusca.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void txtDt_NascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDt_NascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDt_NascimentoActionPerformed

    private void jTAvaliacoesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTAvaliacoesMouseClicked
        // TODO add your handling code here:

        if (jTAvaliacoes.getSelectedRow() != -1) {

            txtId_Avaliacao.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 0).toString());
            txtNome.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 1).toString());
            txtCpf.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 2).toString());
            txtDt_Nascimento.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 3).toString());
            txtCidade.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 4).toString());
            txtNota.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 6).toString());
            txtCategoria.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 5).toString());

        }
    }//GEN-LAST:event_jTAvaliacoesMouseClicked

    private void jTAvaliacoesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTAvaliacoesKeyReleased
        // TODO add your handling code here:

        if (jTAvaliacoes.getSelectedRow() != -1) {

            txtId_Avaliacao.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 0).toString());
            txtNome.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 1).toString());
            txtCpf.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 2).toString());
            txtDt_Nascimento.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 3).toString());
            txtCidade.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 4).toString());
            txtNota.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 5).toString());
            txtCategoria.setText(jTAvaliacoes.getValueAt(jTAvaliacoes.getSelectedRow(), 6).toString());

        }
    }//GEN-LAST:event_jTAvaliacoesKeyReleased

    private void txtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCidadeActionPerformed

    private void txtNotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNotaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNotaActionPerformed

    private void txtCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCategoriaActionPerformed

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
            java.util.logging.Logger.getLogger(ManutencaoPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManutencaoPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManutencaoPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManutencaoPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManutencaoPesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTAvaliacoes;
    private javax.swing.JTextField txtBusca;
    private javax.swing.JTextField txtCategoria;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtDt_Nascimento;
    private javax.swing.JTextField txtId_Avaliacao;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNota;
    // End of variables declaration//GEN-END:variables
}
