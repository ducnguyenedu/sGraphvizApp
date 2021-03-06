/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Sgraphviz extends javax.swing.JFrame {

    /**
     * Creates new form Sgraphviz
     */
    

    
    

    public Sgraphviz() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        txtInput = new javax.swing.JTextArea();
        btnVisualize = new javax.swing.JButton();
        pnGraph = new javax.swing.JPanel();
        canvasGraph = new java.awt.Canvas();
        txtLabelGraph = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        Menu = new javax.swing.JMenu();
        newOptionInMenu = new javax.swing.JCheckBoxMenuItem();
        openOptionInMenu = new javax.swing.JCheckBoxMenuItem();
        saveOptionInMenu = new javax.swing.JCheckBoxMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowStateListener(new java.awt.event.WindowStateListener() {
            public void windowStateChanged(java.awt.event.WindowEvent evt) {
                formWindowStateChanged(evt);
            }
        });

        txtInput.setColumns(20);
        txtInput.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        txtInput.setRows(5);
        jScrollPane1.setViewportView(txtInput);

        btnVisualize.setText("Visualize");
        btnVisualize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizeActionPerformed(evt);
            }
        });

        pnGraph.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnGraph.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnGraph.setMaximumSize(new java.awt.Dimension(300, 300));
        pnGraph.setMinimumSize(new java.awt.Dimension(300, 300));
        pnGraph.setPreferredSize(new java.awt.Dimension(300, 300));

        canvasGraph.setPreferredSize(new java.awt.Dimension(298, 298));

        javax.swing.GroupLayout pnGraphLayout = new javax.swing.GroupLayout(pnGraph);
        pnGraph.setLayout(pnGraphLayout);
        pnGraphLayout.setHorizontalGroup(
            pnGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(canvasGraph, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnGraphLayout.setVerticalGroup(
            pnGraphLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnGraphLayout.createSequentialGroup()
                .addComponent(canvasGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        txtLabelGraph.setText("Graph");

        btnSave.setText("Save graph as image");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        Menu.setText("File");

        newOptionInMenu.setText("New");
        newOptionInMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newOptionInMenuActionPerformed(evt);
            }
        });
        Menu.add(newOptionInMenu);

        openOptionInMenu.setText("Open");
        openOptionInMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openOptionInMenuActionPerformed(evt);
            }
        });
        Menu.add(openOptionInMenu);

        saveOptionInMenu.setText("Save");
        saveOptionInMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveOptionInMenuActionPerformed(evt);
            }
        });
        Menu.add(saveOptionInMenu);

        jMenuBar1.add(Menu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(btnVisualize, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSave)
                        .addGap(84, 84, 84)
                        .addComponent(btnClose))
                    .addComponent(pnGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLabelGraph))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(btnVisualize))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(txtLabelGraph)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(pnGraph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClose)
                    .addComponent(btnSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void newOptionInMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newOptionInMenuActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_newOptionInMenuActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnCloseActionPerformed

    private void btnVisualizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizeActionPerformed
        // TODO add your handling code here
    }//GEN-LAST:event_btnVisualizeActionPerformed

    public JButton getBtnClose() {
        return btnClose;
    }

    public void setBtnClose(JButton btnClose) {
        this.btnClose = btnClose;
    }

    public Canvas getCanvasGraph() {
        return canvasGraph;
    }

    public void setCanvasGraph(Canvas canvasGraph) {
        this.canvasGraph = canvasGraph;
    }

    public JMenu getMenu() {
        return Menu;
    }

    public void setMenu(JMenu Menu) {
        this.Menu = Menu;
    }

    

    

    

    public JButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }

    public JButton getBtnVisualize() {
        return btnVisualize;
    }

    public void setBtnVisualize(JButton btnVisualize) {
        this.btnVisualize = btnVisualize;
    }

    public JCheckBoxMenuItem getNewOptionInMenu() {
        return newOptionInMenu;
    }

    public void setNewOptionInMenu(JCheckBoxMenuItem newOptionInMenu) {
        this.newOptionInMenu = newOptionInMenu;
    }

    public JCheckBoxMenuItem getOpenOptionInMenu() {
        return openOptionInMenu;
    }

    public void setOpenOptionInMenu(JCheckBoxMenuItem openOptionInMenu) {
        this.openOptionInMenu = openOptionInMenu;
    }

    public JCheckBoxMenuItem getSaveOptionInMenu() {
        return saveOptionInMenu;
    }

    public void setSaveOptionInMenu(JCheckBoxMenuItem saveOptionInMenu) {
        this.saveOptionInMenu = saveOptionInMenu;
    }

    public JPanel getPnGraph() {
        return pnGraph;
    }

    public void setPnGraph(JPanel pnGraph) {
        this.pnGraph = pnGraph;
    }

    public JTextArea getTxtInput() {
        return txtInput;
    }

    public void setTxtInput(JTextArea txtInput) {
        this.txtInput = txtInput;
    }

    public JLabel getTxtLabelGraph() {
        return txtLabelGraph;
    }

    public void setTxtLabelGraph(JLabel txtLabelGraph) {
        this.txtLabelGraph = txtLabelGraph;
    }

    private void saveOptionInMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveOptionInMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_saveOptionInMenuActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnSaveActionPerformed

    private void openOptionInMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openOptionInMenuActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_openOptionInMenuActionPerformed

    private void formWindowStateChanged(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowStateChanged

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
            java.util.logging.Logger.getLogger(Sgraphviz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sgraphviz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sgraphviz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sgraphviz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sgraphviz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu Menu;
    private javax.swing.JButton btnClose;
    private javax.swing.JButton btnSave;
    private javax.swing.JButton btnVisualize;
    private java.awt.Canvas canvasGraph;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JCheckBoxMenuItem newOptionInMenu;
    private javax.swing.JCheckBoxMenuItem openOptionInMenu;
    private javax.swing.JPanel pnGraph;
    private javax.swing.JCheckBoxMenuItem saveOptionInMenu;
    private javax.swing.JTextArea txtInput;
    private javax.swing.JLabel txtLabelGraph;
    // End of variables declaration//GEN-END:variables
}
