/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.playlistmanager;

import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * The programs's GUI
 * @author Sean Johnson
 */
public class PlaylistJFrame extends javax.swing.JFrame {


    private static String[] playlistTblHeads = {"#", "Title", "Artist", "Album", "Track Number", "Length"};
    private DefaultTableModel tblMdlPlaylist = new DefaultTableModel(playlistTblHeads, 0);
    private Playlist currentPlaylist;
    private File currentPlaylistFile;
    private FileNameExtensionFilter fileFilter = new FileNameExtensionFilter("CSV file", "csv");


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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

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
        menuDeleteSong = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Playlist Converter");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        tblPlaylist.setModel(this.tblMdlPlaylist);
        tblPlaylist.setColumnSelectionAllowed(true);
        tblPlaylist.setShowGrid(false);
        tblPlaylist.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblPlaylist);
        tblPlaylist.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

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

        menuINew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        menuINew.setText("New Playlist");
        menuINew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuINewActionPerformed(evt);
            }
        });
        fileMenu.add(menuINew);

        menuIOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        menuIOpen.setText("Open");
        menuIOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIOpenActionPerformed(evt);
            }
        });
        fileMenu.add(menuIOpen);

        menuISave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        menuISave.setText("Save");
        menuISave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuISaveActionPerformed(evt);
            }
        });
        fileMenu.add(menuISave);

        menuISaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        menuISaveAs.setText("Save As");
        menuISaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuISaveAsActionPerformed(evt);
            }
        });
        fileMenu.add(menuISaveAs);

        menuBar.add(fileMenu);

        editMenu.setText("Edit");

        menuIAddSong.setText("Add Song");
        menuIAddSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuIAddSongActionPerformed(evt);
            }
        });
        editMenu.add(menuIAddSong);

        menuDeleteSong.setText("Delete Song");
        menuDeleteSong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDeleteSongActionPerformed(evt);
            }
        });
        editMenu.add(menuDeleteSong);

        menuBar.add(editMenu);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuINewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuINewActionPerformed
        
        String nameIn = JOptionPane.showInputDialog(null, "Enter playlist name: ");

        this.setNewPlaylist(new Playlist(nameIn));
        
        
    }//GEN-LAST:event_menuINewActionPerformed

    private void menuIAddSongActionPerformed(java.awt.event.ActionEvent evt) {                                             

        this.addSong();
    }                                            
    
    private void menuISaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuISaveActionPerformed
        this.savePlaylist(currentPlaylistFile);
    }//GEN-LAST:event_menuISaveActionPerformed

    private void menuISaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuISaveAsActionPerformed
        this.savePlaylist();
    }//GEN-LAST:event_menuISaveAsActionPerformed

    private void menuIOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuIOpenActionPerformed
        this.openPlaylist();
    }//GEN-LAST:event_menuIOpenActionPerformed

    private void menuDeleteSongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDeleteSongActionPerformed
        this.deleteSong();
    }//GEN-LAST:event_menuDeleteSongActionPerformed


    /**
     * Called when a new playlist is opened
     * replaces 
     */
    private void setNewPlaylist(Playlist nPlaylist){

        this.currentPlaylist = nPlaylist;
        lblPlaylistName.setText(nPlaylist.getName());

        this.updateTable();

    }

    /**
     * called to append a song to the playlist
     */
    private void addSong(){

        if (this.currentPlaylist != null){
            String nTitle = null;
            String nArtist = null;
            String nAlbum = null;
            int nTrack = -1;
            int nLength = -1;
            boolean success = true;
            boolean cancel = false;

            /* Create the fields for a user to input song details */
            JTextField textTitle = new JTextField();
            JTextField textArtist = new JTextField();
            JTextField textAlbum = new JTextField();
            JTextField textTrack = new JTextField();
            JTextField textLengthMin = new JTextField();
            JTextField textLengthSec = new JTextField();

            Object[] fields = {
                "Title", textTitle,
                "Artist", textArtist,
                "Album", textAlbum,
                "Track", textTrack,
                "Length", new Object[] {
                    "Minutes", textLengthMin,
                    "Seconds", textLengthSec
                }
            };

            do{
                /*Display the new song input dialog */
                int n = JOptionPane.showConfirmDialog(null, fields, "New Song", JOptionPane.OK_CANCEL_OPTION);

                if (n == JOptionPane.OK_OPTION) {
                    if (textTitle.getText().equals("") || textArtist.getText().equals("")) {

                        JOptionPane.showMessageDialog(null, "Please input a Title and Artist", "error", JOptionPane.WARNING_MESSAGE);
                        success = false;

                    }  
                    else{
                        nTitle = textTitle.getText();
                        nArtist = textArtist.getText();
                        
                        if (!textAlbum.getText().equals("")){
                            nAlbum = textAlbum.getText();
                        }


                        if (!textTrack.getText().equals("")){
                            try{
                                nTrack = Integer.parseInt(textTrack.getText());
                            }
                            catch(Exception e){
                                success = false;
                                JOptionPane.showMessageDialog(null, "Please enter a valid input for 'Track Number'", "error", JOptionPane.WARNING_MESSAGE);
                            }
                        }

                        if (!textLengthSec.getText().equals("") || !textLengthMin.getText().equals("")) {

                            nLength = 0;

                            if (!textLengthMin.getText().equals("")){
                                try{
                                    nLength += 60*Integer.parseInt(textLengthMin.getText());
                                }
                                catch(Exception e){
                                    success = false;
                                    JOptionPane.showMessageDialog(null, "Please enter a valid input for 'Minutes'", "error", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                            if (!textLengthSec.getText().equals("")){
                                try{
                                    nLength += Integer.parseInt(textLengthSec.getText());
                                }
                                catch(Exception e){
                                    success = false;
                                    JOptionPane.showMessageDialog(null, "Please enter a valid input for 'Seconds'", "error", JOptionPane.WARNING_MESSAGE);
                                }
                            }

                        }
                    }
                }
                else {
                    cancel = true;
                }
            /*If the user didn't input valid data, or the user didn't cancel the operation, repeat */
            }while (success == false && cancel == false);

            if (this.currentPlaylist.addSong(new Song(nTitle,nArtist,nAlbum,nTrack,nLength))) {
                JOptionPane.showMessageDialog(null, "A new song has been added to the playlist", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                /*Update the table with the new song */
                this.updateTable();
            }
            else {
                JOptionPane.showMessageDialog(null, "Unable to add song to the playlist", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"No currently open playlist.");
        }
    }                                            

    /**
     * called to delete a song from the playlist
     */
    private void deleteSong(){

        if (this.currentPlaylist != null){
            Vector<String> choicesVector = new Vector<>(0);
            Song currentSong;
            int selectedIndex;

            /*Get a list of every song on the playlist */
            for (int i = 0; i < this.currentPlaylist.getSongList().size(); i++){

                /*A vector is used for dynamic resizing */
                currentSong = this.currentPlaylist.getSongList().get(i);

                choicesVector.add( (i+1) + " - " + currentSong.getTitle() + " - " + currentSong.getArtist());

            }

            /*The  Vector must be converted to an array for use later*/
            String[] choices =  choicesVector.toArray(new String[choicesVector.size()]);

            /*Display the dialog box with drop down menu */
            String n = (String) JOptionPane.showInputDialog(this, "Choose a song to delete:", "Delete Song", JOptionPane.QUESTION_MESSAGE, null, choices, choices[0]);

            /*Extract the index from the users choice*/
            String input = n.split(" - ")[0];
            selectedIndex = Integer.parseInt(input) - 1;

            /*remove the song at the selected index */
            if (this.currentPlaylist.removeSong(selectedIndex)){
                JOptionPane.showMessageDialog(null, "Song removed from the playlist", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                /*update the table to reflect the removed song */
                this.updateTable();
            }
            else{
                JOptionPane.showMessageDialog(null, "Unable to remove song from the playlist", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"No currently open playlist.");
        }

    }

    /**
     * Called to update the jTable with new songs
     */
    public void updateTable(){

        Vector<Song> nSongData = this.currentPlaylist.getSongList();
        Song currentSong;
        String currentLength;

        DefaultTableModel nPlaylistData = new DefaultTableModel(playlistTblHeads, 0);

        /*for each Song in the Playlist */
        for (int i = 0; i < nSongData.size(); i++){
            
            currentSong = nSongData.get(i);
            /*format the length value into m:ss */
            currentLength = Integer.toString(currentSong.getLength()/60) + ":" + String.format("%02d", currentSong.getLength()%60);
            /*append the tablemodel with the next song data */
            nPlaylistData.addRow(new String[] {Integer.toString(i+1), currentSong.getTitle(), currentSong.getArtist(), currentSong.getAlbum(), Integer.toString(currentSong.getTrackNum()), currentLength});
        }

        this.tblPlaylist.setModel(nPlaylistData);

    }
    
    /**
     * Called to save the current playlist, by choosing a filename and directory
     */
    public void savePlaylist(){
        
        if (this.currentPlaylist != null){
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(this.fileFilter);
            fc.addChoosableFileFilter(this.fileFilter);
            fc.setSelectedFile(new File(currentPlaylist.getName()+".csv"));

            /* Use the JFileChooser to pick the name and directory of the new file */
            int n = fc.showSaveDialog(null);

            if (n == JFileChooser.APPROVE_OPTION) {
                
                File savedPlaylist = fc.getSelectedFile();

                try{
                    
                    /*if the file doesn't already exist in that directory */
                    if (savedPlaylist.createNewFile()) {
                        
                        savePlaylist(savedPlaylist);

                    } 
                    else {
                        JOptionPane.showMessageDialog(null,"File already exists.");
                    }
                } 
                catch (IOException e) {
                    JOptionPane.showMessageDialog(null,"Error creating new playlist file.");
                    e.printStackTrace();
        
                }

            }
        }
        else{
            JOptionPane.showMessageDialog(null,"No currently open playlist.");
        } 


    }

    /**
     * Called to save the current playlist, to an existing file
     * Overloads savePlaylist()
     * @param playlistFile The existing file the playlist will be saved to
     */
    public void savePlaylist(File playlistFile){

        if (playlistFile != null) {
            try{
                FileWriter playlistWriter = new FileWriter(playlistFile);
                /*First line is always the playlist's name */
                playlistWriter.write(currentPlaylist.getName()+",\n");

                StringBuilder songData = new StringBuilder();

                /*For each song in the playlist */
                for (int i = 0; i < currentPlaylist.getSongList().size(); i++){

                    /*write the song data, separated by commas */
                    songData.append(currentPlaylist.getSongList().get(i).getTitle());
                    songData.append(',');
                    songData.append(currentPlaylist.getSongList().get(i).getArtist());
                    songData.append(',');
                    songData.append(currentPlaylist.getSongList().get(i).getAlbum());
                    songData.append(',');
                    songData.append(currentPlaylist.getSongList().get(i).getTrackNum());
                    songData.append(',');
                    songData.append(currentPlaylist.getSongList().get(i).getLength());
                    songData.append(',');
                    songData.append("\n");

                }

                playlistWriter.write(songData.toString());
            
                playlistWriter.close();
            }
            catch (IOException e) {
                JOptionPane.showMessageDialog(null,"Error when writing file.");
                e.printStackTrace();
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"No currently open file.");
        }
    }

    /**
     * Called to open a playlist file using JFileChooser
     */
    public void openPlaylist(){

        String nName = "";
        Vector<Song> nSongList;
        String line;
        ArrayList<String> lineList = new ArrayList<>();
        
        final JFileChooser fc = new JFileChooser();
        /*filter the files to only .CSV*/
        fc.setFileFilter(this.fileFilter);
        fc.addChoosableFileFilter(this.fileFilter);

        int n = fc.showOpenDialog(this);

        if (n == JFileChooser.APPROVE_OPTION) {
            
            File playlistFile =  fc.getSelectedFile();

            try{

                BufferedReader playlistReader = new BufferedReader(new FileReader(playlistFile));

                /*read the first line, storing it as the playlist name */
                line = playlistReader.readLine().replaceAll(",", "");
                nName = line;
                
                /* while there are lines left to read */
                while (line != null) {

                    /*read the lines into an arraylist */
                    line = playlistReader.readLine();
                    lineList.add(line);

                }

                playlistReader.close();
    
            }
            catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }

            /*Update the currently open file */
            this.currentPlaylistFile = playlistFile;

            nSongList = this.threadedPlaylistMaker(lineList);

            /*Replace the old playlist with the new one */
            this.setNewPlaylist(new Playlist(nName, nSongList));

        }

    }

    /**
     * Called to read a arraylist, containing strings of song data to be formatted
     * uses multithreaded, batch processing to compute 5 songs at a time
     * @param songDataArrayList the arraylist containing songdata, each formatted as "title,artist,album,tracknum,length"
     */
    private Vector<Song> threadedPlaylistMaker(ArrayList<String> songDataArrayList){

        Vector<Song> buildingSongList = new Vector<>(0);

        Thread songThread1;
        Thread songThread2;
        Thread songThread3;
        Thread songThread4;
        Thread songThread5;

        SongReadTask songTask1;
        SongReadTask songTask2;
        SongReadTask songTask3;
        SongReadTask songTask4;
        SongReadTask songTask5;

        /*Add each string to a queue */
        BlockingQueue<String> lineQueue = new LinkedBlockingQueue<>(Integer.MAX_VALUE); //unbound queue
        for (int i = 0; i <= songDataArrayList.size()-2; ++i){
            lineQueue.add(songDataArrayList.get(i));
        }

        /*while there a re strings left in the queue */
        while (lineQueue.size() > 0) {

            
            if (lineQueue.size() >= 5){
                /*take the next 5 strings and assign each their own thread */
                songTask1 =new SongReadTask(lineQueue.poll()); songThread1 = new Thread(songTask1); 
                songThread1.start();
                songTask2 =new SongReadTask(lineQueue.poll()); songThread2 = new Thread(songTask2); 
                songThread2.start();
                songTask3 =new SongReadTask(lineQueue.poll()); songThread3 = new Thread(songTask3); 
                songThread3.start();
                songTask4 =new SongReadTask(lineQueue.poll()); songThread4 = new Thread(songTask4); 
                songThread4.start();
                songTask5 =new SongReadTask(lineQueue.poll()); songThread5 = new Thread(songTask5); 
                songThread5.start();
                
                try {
                    
                    /*get the completed songs back from each thread */
                    /*processing takes as long as the slowest thread */
                    songThread1.join(); buildingSongList.addElement(songTask1.getSong());
                    songThread2.join(); buildingSongList.addElement(songTask2.getSong());
                    songThread3.join(); buildingSongList.addElement(songTask3.getSong());
                    songThread4.join(); buildingSongList.addElement(songTask4.getSong());
                    songThread5.join(); buildingSongList.addElement(songTask5.getSong());

                }
                catch (InterruptedException e){

                    e.printStackTrace();

                }
                
            }
            /*if there are less than 5 strings left, process them sequentially */
            else{
                    
                songTask1 =new SongReadTask(lineQueue.poll()); songThread1 = new Thread(songTask1); 
                songThread1.start();

                try {

                        songThread1.join(); buildingSongList.add(songTask1.getSong());

                    }
                catch (InterruptedException e){

                        e.printStackTrace();

                }

            }

        }

        return buildingSongList;

    }



    /**
     * @param args the command songData arguments
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblPlaylistName;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuDeleteSong;
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
