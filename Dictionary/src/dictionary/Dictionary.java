/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package dictionary;

import dictionary.ReadXmlDomParser.Word;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import org.xml.sax.SAXException;

/**
 *
 * @author ASUS
 */
public class Dictionary extends javax.swing.JFrame {
    
    // Read the XML file and get a list of words and meanings
    // Connect ReadXmlDomParser.java to Dictionary.java
    List<ReadXmlDomParser.Word> words = ReadXmlDomParser.readXmlFile();
    
    /**
     * Creates new form Dictionary
     */
    public Dictionary() {
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

        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        TF_Search = new javax.swing.JTextField();
        CBB_Language = new javax.swing.JComboBox<>();
        BT_Search = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TA_Show = new javax.swing.JTextArea();
        BT_Remove = new javax.swing.JButton();
        BT_Favourite = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jButton2.setText("jButton2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CBB_Language.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ENG -> VN", "VN -> ENG", "Favourite" }));
        CBB_Language.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBB_LanguageActionPerformed(evt);
            }
        });

        BT_Search.setText("Search");
        BT_Search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_SearchActionPerformed(evt);
            }
        });

        TA_Show.setEditable(false);
        TA_Show.setColumns(20);
        TA_Show.setRows(5);
        TA_Show.setText("This is LQD's dictionary\n- You can search ENG->VN or VN->ENG\n- You can add a new word if you can't search its meaning\n- You can remove a word\n- You can add your favourite word\n- You can see list of your favourite word");
        jScrollPane1.setViewportView(TA_Show);

        BT_Remove.setText("Remove Word");
        BT_Remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_RemoveActionPerformed(evt);
            }
        });

        BT_Favourite.setText("Add Favourite Word");
        BT_Favourite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BT_FavouriteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(BT_Favourite, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CBB_Language, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TF_Search, javax.swing.GroupLayout.PREFERRED_SIZE, 509, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(BT_Search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BT_Remove, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BT_Remove)
                    .addComponent(BT_Favourite))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TF_Search, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CBB_Language, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BT_Search))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    public void addRecord(String word, String meaning) {
        try {
            ReadXmlDomParser.addRecord(word, meaning);
            System.out.println("New word added successfully.");
        } catch (ParserConfigurationException | TransformerException e) {
            System.out.println("Error adding new word: " + e.getMessage());
        }
    }

    public void removeRecord(String key) {
        try {
            ReadXmlDomParser.removeRecord(key);
            System.out.println("Word '" + key + "' has been removed.");
        } catch (ParserConfigurationException | TransformerException | SAXException | IOException e) {
            System.out.println("Error removing word: " + e.getMessage());
        }
    }

    
    private void BT_SearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_SearchActionPerformed
        TA_Show.setText("");
        for (Word word : words)
        {
            if(TF_Search.getText().equals(word.getWord())){
                TA_Show.setText(word.getMeaning());
            } 
        }
        if(TA_Show.getText().equals("")){
            
            int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to add a new mean of that word?", "Non-Existent word", JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                String newMeaning = JOptionPane.showInputDialog(null, "Enter the new meaning for " + TF_Search.getText() + ":", "Add New Meaning", JOptionPane.INFORMATION_MESSAGE);
                
                // call your addRecord method here with the word and newMeaning parameters
                if(!"".equals(newMeaning)) 
                {
                    Dictionary myDictionary = new Dictionary(); 
                    myDictionary.addRecord(TF_Search.getText(), newMeaning);
                    words = ReadXmlDomParser.readXmlFile();
                }
            }
        }
    }//GEN-LAST:event_BT_SearchActionPerformed

    private void CBB_LanguageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBB_LanguageActionPerformed
        String selectedItem = CBB_Language.getSelectedItem().toString();
        if (selectedItem.equals("ENG -> VN")) {
            ReadXmlDomParser.setFileName("Anh_Viet.xml");
            }
            else if (selectedItem.equals("VN -> ENG")) {
                ReadXmlDomParser.setFileName("Viet_Anh.xml");
            }
            else if(selectedItem.equals("Favourite")){
                ReadXmlDomParser.setFileName("Favourite.xml");
                words = ReadXmlDomParser.readXmlFile();
                
                // Sort A->Z by word in Favourite.xml
                // Sort the list of words
                Collections.sort(words, new WordComparator());

                // Write the sorted list to the XML file
                try {
                    ReadXmlDomParser.clearXmlFile();
                    for (Word word : words) {
                        ReadXmlDomParser.addRecord(word.getWord(), word.getMeaning());
                    }
                    System.out.println("Favourite.xml has been sorted successfully.");
                } catch (ParserConfigurationException | TransformerException ex) {
                    System.out.println("Error sorting Favourite.xml: " + ex.getMessage());
                    }
                words = ReadXmlDomParser.readXmlFile();
                StringBuilder sb = new StringBuilder();
                for (Word word : words) {
                    sb.append(word.getMeaning()).append("\n");
                }
                TA_Show.setText(sb.toString());
            }
        words = ReadXmlDomParser.readXmlFile();
    }//GEN-LAST:event_CBB_LanguageActionPerformed

    private void BT_RemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_RemoveActionPerformed
        Dictionary myDictionary = new Dictionary();
        myDictionary.removeRecord(TF_Search.getText());
        words = ReadXmlDomParser.readXmlFile();
    }//GEN-LAST:event_BT_RemoveActionPerformed

    public class WordComparator implements Comparator<Word> {
        public int compare(Word w1, Word w2) {
            return w1.getWord().compareTo(w2.getWord());
        }
    }
    
    
    
    private void BT_FavouriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BT_FavouriteActionPerformed
        ReadXmlDomParser.setFileName("Favourite.xml");
        words = ReadXmlDomParser.readXmlFile();
        boolean wordExists = false;
        for (Word word : words) {
            if (TF_Search.getText().equals(word.getWord())) {
                wordExists = true;
                break;
            }
        }
        if (!wordExists) {
            Dictionary myDictionary = new Dictionary(); 
            myDictionary.addRecord(TF_Search.getText(), TA_Show.getText());
            JOptionPane.showMessageDialog(rootPane, "Add new word to your favourite");
        } else JOptionPane.showMessageDialog(rootPane, "Word exits in your favourite");
    }//GEN-LAST:event_BT_FavouriteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {        
        // create a new instance of Dictionary
        Dictionary myDictionary = new Dictionary();
        // call addRecord method to add a ne dictionary


        
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
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dictionary.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dictionary().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BT_Favourite;
    private javax.swing.JButton BT_Remove;
    private javax.swing.JButton BT_Search;
    private javax.swing.JComboBox<String> CBB_Language;
    private javax.swing.JTextArea TA_Show;
    private javax.swing.JTextField TF_Search;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
