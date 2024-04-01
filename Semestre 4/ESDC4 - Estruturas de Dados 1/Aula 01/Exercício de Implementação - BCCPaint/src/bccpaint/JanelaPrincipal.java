package bccpaint;

import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.JTextField;

public class JanelaPrincipal extends javax.swing.JFrame {

    
    public JanelaPrincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        btnLinha = new javax.swing.JToggleButton();
        btnRetangulo = new javax.swing.JToggleButton();
        btnElipse = new javax.swing.JToggleButton();
        pCorPreenchimento = new javax.swing.JPanel();
        pCorContorno = new javax.swing.JPanel();
        painelDesenho = new bccpaint.PainelDesenho();
        btnPoligono = new javax.swing.JToggleButton();
        labelAttLadosPoligono = new java.awt.Label();
        ladosTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Paint BCC");

        btnGroup.add(btnLinha);
        btnLinha.setSelected(true);
        btnLinha.setText("Linha");
        btnLinha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLinhaActionPerformed(evt);
            }
        });

        btnGroup.add(btnRetangulo);
        btnRetangulo.setText("Retângulo");
        btnRetangulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRetanguloActionPerformed(evt);
            }
        });

        btnGroup.add(btnElipse);
        btnElipse.setText("Elipse");
        btnElipse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElipseActionPerformed(evt);
            }
        });

        pCorPreenchimento.setBackground(new java.awt.Color(255, 255, 255));
        pCorPreenchimento.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pCorPreenchimento.setPreferredSize(new java.awt.Dimension(20, 20));
        pCorPreenchimento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pCorPreenchimentoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pCorPreenchimentoLayout = new javax.swing.GroupLayout(pCorPreenchimento);
        pCorPreenchimento.setLayout(pCorPreenchimentoLayout);
        pCorPreenchimentoLayout.setHorizontalGroup(
            pCorPreenchimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        pCorPreenchimentoLayout.setVerticalGroup(
            pCorPreenchimentoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        pCorContorno.setBackground(new java.awt.Color(0, 0, 0));
        pCorContorno.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pCorContorno.setPreferredSize(new java.awt.Dimension(20, 20));
        pCorContorno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                pCorContornoMousePressed(evt);
            }
        });

        javax.swing.GroupLayout pCorContornoLayout = new javax.swing.GroupLayout(pCorContorno);
        pCorContorno.setLayout(pCorContornoLayout);
        pCorContornoLayout.setHorizontalGroup(
            pCorContornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );
        pCorContornoLayout.setVerticalGroup(
            pCorContornoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 20, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout painelDesenhoLayout = new javax.swing.GroupLayout(painelDesenho);
        painelDesenho.setLayout(painelDesenhoLayout);
        painelDesenhoLayout.setHorizontalGroup(
            painelDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelDesenhoLayout.setVerticalGroup(
            painelDesenhoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 554, Short.MAX_VALUE)
        );

        btnGroup.add(btnPoligono);
        btnPoligono.setText("Poligono");
        btnPoligono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPoligonoActionPerformed(evt);
            }
        });

        labelAttLadosPoligono.setText("*Ao atualizar o número de lados do Poligono, clique no botão 'Poligono' novamente");

        ladosTextField.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ladosTextField.setText("3");
        ladosTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ladosTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLinha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRetangulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnElipse)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPoligono)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ladosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pCorPreenchimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pCorContorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(labelAttLadosPoligono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(pCorContorno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnElipse)
                    .addComponent(btnRetangulo)
                    .addComponent(btnLinha)
                    .addComponent(pCorPreenchimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPoligono)
                    .addComponent(labelAttLadosPoligono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ladosTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelDesenho, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pCorContornoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pCorContornoMousePressed
        
        Color c = JColorChooser.showDialog( 
                this, 
                "Cor Contorno", 
                pCorContorno.getBackground() );
        
        if ( c != null ) {
            pCorContorno.setBackground(c);
            painelDesenho.setCorContorno(c);
        }
        
    }//GEN-LAST:event_pCorContornoMousePressed

    private void btnLinhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLinhaActionPerformed
        painelDesenho.setFormaAtual( FormaAtual.LINHA );
    }//GEN-LAST:event_btnLinhaActionPerformed

    private void btnRetanguloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRetanguloActionPerformed
        painelDesenho.setFormaAtual( FormaAtual.RETANGULO );
    }//GEN-LAST:event_btnRetanguloActionPerformed

    private void pCorPreenchimentoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pCorPreenchimentoMousePressed
        
        Color c = JColorChooser.showDialog( 
                this, 
                "Cor Preechimento", 
                pCorPreenchimento.getBackground() );
        
        if ( c != null ) {
            pCorPreenchimento.setBackground(c);
            painelDesenho.setCorPreenchimento(c);
        }
        
    }//GEN-LAST:event_pCorPreenchimentoMousePressed

    private void btnElipseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElipseActionPerformed
        painelDesenho.setFormaAtual( FormaAtual.ELIPSE );
    }//GEN-LAST:event_btnElipseActionPerformed

    private void ladosTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ladosTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ladosTextFieldActionPerformed

    private void btnPoligonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPoligonoActionPerformed
        painelDesenho.setFormaAtual( FormaAtual.POLIGONO );
        painelDesenho.setNumLados( Integer.parseInt(ladosTextField.getText()));
    }//GEN-LAST:event_btnPoligonoActionPerformed

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
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaPrincipal().setVisible(true);
            }
        });
    } 
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnElipse;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JToggleButton btnLinha;
    private javax.swing.JToggleButton btnPoligono;
    private javax.swing.JToggleButton btnRetangulo;
    private java.awt.Label labelAttLadosPoligono;
    private javax.swing.JTextField ladosTextField;
    private javax.swing.JPanel pCorContorno;
    private javax.swing.JPanel pCorPreenchimento;
    private bccpaint.PainelDesenho painelDesenho;
    // End of variables declaration//GEN-END:variables
}
