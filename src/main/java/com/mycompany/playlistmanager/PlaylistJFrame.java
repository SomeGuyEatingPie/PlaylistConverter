/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.playlistmanager;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author seand
 */
public class PlaylistJFrame extends javax.swing.JFrame {

    private String[] playlistTblHeads = {"Title", "Arist", "Length"};
    private DefaultTableModel tblMdlPlaylist = new DefaultTableModel(playlistTblHeads, 0);

    /**
     * Creates new form PlaylistJFrame
     */
    public PlaylistJFrame() {
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
        java.awt.GridBagConstraints gridBagConstraints;

        jOptionPane = new javax.swing.JOptionPane();
        panPlaylist = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPlaylist = new javax.swing.JTable();
        lblPlaylistName = new javax.swing.JLabel();
        panConvert = new javax.swing.JPanel();
        cmbConvert = new javax.swing.JComboBox<>();
        btnConvert = new javax.swing.JButton();
        progConvert = new javax.swing.JProgressBar();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        menuINew = new javax.swing.JMenuItem();
        menuIOpen = new javax.swing.JMenuItem();
        menuISave = new javax.swing.JMenuItem();
        menuISaveAs = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        menuIAddSong = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tblPlaylist.setModel(this.tblMdlPlaylist);
        jScrollPane1.setViewportView(tblPlaylist);

        lblPlaylistName.setText(". . .");

        javax.swing.GroupLayout panPlaylistLayout = new javax.swing.GroupLayout(panPlaylist);
        panPlaylist.setLayout(panPlaylistLayout);
        panPlaylistLayout.setHorizontalGroup(
            panPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panPlaylistLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPlaylistLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblPlaylistName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        panPlaylistLayout.setVerticalGroup(
            panPlaylistLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panPlaylistLayout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addComponent(lblPlaylistName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.weighty = 10.0;
        getContentPane().add(panPlaylist, gridBagConstraints);

        panConvert.setLayout(new java.awt.GridBagLayout());

        cmbConvert.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbConvert.setActionCommand("cmbConvert");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        panConvert.add(cmbConvert, gridBagConstraints);

        btnConvert.setText("Convert to");
        btnConvert.setActionCommand("btnConvert");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panConvert.add(btnConvert, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        panConvert.add(progConvert, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_END;
        gridBagConstraints.weighty = 2.0;
        getContentPane().add(panConvert, gridBagConstraints);

        fileMenu.setText("File");

        menuINew.setText("New Playlist");
        menuINew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuINewActionPerformed(evt);
            }
        });
        fileMenu.add(menuINew);

        menuIOpen.setText("Open");
        fileMenu.add(menuIOpen);

        menuISave.setText("Save");
        fileMenu.add(menuISave);

        menuISaveAs.setText("Save As");
        fileMenu.add(menuISaveAs);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        menuIAddSong.setText("Add Song");
        editMenu.add(menuIAddSong);

        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuINewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuINewActionPerformed
        
        String nameIn = jOptionPane.showInputDialog(null, "Enter playlist name: ");
        
        PlaylistManager.currentPlaylist = new Playlist("Name");
        lblPlaylistName.setText(nameIn);
    }//GEN-LAST:event_menuINewActionPerformed

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
            java.util.logging.Logger.getLogger(PlaylistJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlaylistJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlaylistJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlaylistJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PlaylistJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConvert;
    private javax.swing.JComboBox<String> cmbConvert;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JOptionPane jOptionPane;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPlaylistName;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuIAddSong;
    private javax.swing.JMenuItem menuINew;
    private javax.swing.JMenuItem menuIOpen;
    private javax.swing.JMenuItem menuISave;
    private javax.swing.JMenuItem menuISaveAs;
    private javax.swing.JPanel panConvert;
    private javax.swing.JPanel panPlaylist;
    private javax.swing.JProgressBar progConvert;
    private javax.swing.JTable tblPlaylist;
    // End of variables declaration//GEN-END:variables
}
