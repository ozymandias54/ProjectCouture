/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package form;

import classe.Client;
import classe_special.Confirm;
import classe_special.ScrollBar;
import dao.ClientDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class PanelClient extends javax.swing.JPanel {
boolean modifier;
    int nbreArticle;
    public PanelClient() {
        initComponents();
        liste_client();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FrameEnregistrer = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        btnEnregistrer = new javax.swing.JButton();
        btnEnAnnuler = new javax.swing.JButton();
        scroll = new javax.swing.JScrollPane();
        tb_client = new classe_special.Tableaux();
        jPanel5 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        btnSupprimer1 = new javax.swing.JLabel();
        btnModifier1 = new javax.swing.JLabel();
        btnAjouter1 = new javax.swing.JLabel();

        FrameEnregistrer.setLocation(new java.awt.Point(444, 211));
        FrameEnregistrer.setUndecorated(true);
        FrameEnregistrer.setSize(new java.awt.Dimension(400, 300));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Nom");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Contact");

        btnEnregistrer.setBackground(new java.awt.Color(51, 102, 255));
        btnEnregistrer.setForeground(new java.awt.Color(255, 255, 255));
        btnEnregistrer.setText("Enregistrer");
        btnEnregistrer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnregistrerActionPerformed(evt);
            }
        });

        btnEnAnnuler.setBackground(new java.awt.Color(255, 51, 51));
        btnEnAnnuler.setForeground(new java.awt.Color(255, 255, 255));
        btnEnAnnuler.setText("Annuler");
        btnEnAnnuler.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnAnnulerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(18, 18, 18)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnEnregistrer, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnEnAnnuler, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnEnregistrer, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                    .addComponent(btnEnAnnuler, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout FrameEnregistrerLayout = new javax.swing.GroupLayout(FrameEnregistrer.getContentPane());
        FrameEnregistrer.getContentPane().setLayout(FrameEnregistrerLayout);
        FrameEnregistrerLayout.setHorizontalGroup(
            FrameEnregistrerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
            .addGroup(FrameEnregistrerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FrameEnregistrerLayout.setVerticalGroup(
            FrameEnregistrerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
            .addGroup(FrameEnregistrerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        scroll.setBorder(null);
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.BLUE);
        scroll.setBackground(new java.awt.Color(255, 255, 255));

        tb_client.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id client", "Nom", "contact", "nbre d'article"
            }
        ));
        tb_client.setSelectionBackground(new java.awt.Color(51, 51, 51));
        tb_client.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_clientMouseClicked(evt);
            }
        });
        scroll.setViewportView(tb_client);

        jPanel5.setBackground(new java.awt.Color(102, 204, 255));

        jLabel27.setFont(new java.awt.Font("Tempus Sans ITC", 1, 24)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Liste des Clients");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(252, 252, 252)
                .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(268, 268, 268))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE)
        );

        btnSupprimer1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnSupprimer1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/supprimer.png"))); // NOI18N
        btnSupprimer1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSupprimer1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSupprimer1MouseClicked(evt);
            }
        });

        btnModifier1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnModifier1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/modifier.png"))); // NOI18N
        btnModifier1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnModifier1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnModifier1MouseClicked(evt);
            }
        });

        btnAjouter1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        btnAjouter1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/ajouter.png"))); // NOI18N
        btnAjouter1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjouter1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAjouter1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAjouter1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModifier1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSupprimer1)
                .addGap(25, 25, 25))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSupprimer1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnAjouter1)
                            .addComponent(btnModifier1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(422, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnEnregistrerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnregistrerActionPerformed
        ClientDAO cldao=new ClientDAO();
        String nom=jTextField1.getText();
        String contact=jTextField2.getText();
        if (nom.equals("") || contact.equals("")) {
            JOptionPane.showMessageDialog(this, "Veuillez renseigner tous les champs ");
        } 
        else if(modifier==false){
        Client clt=new Client(nom, contact);
        cldao.inserer(clt);
        vider();
        liste_client();
        FrameEnregistrer.setVisible(false);
        }
        else if(modifier==true){
            int index = tb_client.getSelectedRow();
             int id = (int)tb_client.getValueAt(index,0);
             Client clt=new Client(nbreArticle,nom,contact);
            cldao.modifier(clt, id);
            vider();
            liste_client();
            FrameEnregistrer.setVisible(false);
        }
    }//GEN-LAST:event_btnEnregistrerActionPerformed

    private void btnEnAnnulerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnAnnulerActionPerformed
        FrameEnregistrer.setVisible(false);
        vider();
        liste_client();
    }//GEN-LAST:event_btnEnAnnulerActionPerformed

    private void tb_clientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_clientMouseClicked
        int index = tb_client.getSelectedRow();
        if (index!=-1){
          int id = (int)tb_client.getValueAt(index,0);
            ClientDAO cdao = new ClientDAO();
            Client clt = cdao.recherche(id);
            jTextField1.setText(clt.getNom());
            jTextField2.setText(clt.getContact());
            nbreArticle=clt.getNbreArticle();
        }
    }//GEN-LAST:event_tb_clientMouseClicked

    private void btnSupprimer1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSupprimer1MouseClicked
        int index = tb_client.getSelectedRow();
        if (index==-1){
            JOptionPane.showMessageDialog(this,"Veuillez selectionnez un client");
        }
        else { 
        new Confirm().affiche("Supprimer","Etes vous sur de vouloir Supprimer!!!", new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent ae) {
            int index = tb_client.getSelectedRow();
            int id = (int)tb_client.getValueAt(index,0);
            ClientDAO cdao = new ClientDAO();
            cdao.supprimer(id);
            vider();
            liste_client();
               }
           });
        }
    }//GEN-LAST:event_btnSupprimer1MouseClicked

    private void btnModifier1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnModifier1MouseClicked
         int index = tb_client.getSelectedRow();
        if (index==-1){
            JOptionPane.showMessageDialog(this,"Veuillez selectionnez un client");
        }
        else {
        FrameEnregistrer.setVisible(true);
        modifier=true;
        }
    }//GEN-LAST:event_btnModifier1MouseClicked

    private void btnAjouter1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjouter1MouseClicked
        FrameEnregistrer.setVisible(true);
       modifier=false;
       jTextField1.setText("");
        jTextField2.setText("");
    }//GEN-LAST:event_btnAjouter1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame FrameEnregistrer;
    private javax.swing.JLabel btnAjouter1;
    private javax.swing.JButton btnEnAnnuler;
    private javax.swing.JButton btnEnregistrer;
    private javax.swing.JLabel btnModifier1;
    private javax.swing.JLabel btnSupprimer1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JScrollPane scroll;
    private classe_special.Tableaux tb_client;
    // End of variables declaration//GEN-END:variables
private void liste_client() {
        ClientDAO pdao = new ClientDAO();
        List<Client> cmd = pdao.liste();
        
        for (int i = 0; i < cmd.size(); i++) {
            pdao.nbreArticle(cmd.get(i).getId_client());
            ((DefaultTableModel) tb_client.getModel()).addRow(new Object[]{
                  cmd.get(i).getId_client(),
                  cmd.get(i).getNom(),
                  cmd.get(i).getContact(),
                  cmd.get(i).getNbreArticle()
            });

    }
}
public void vider() {
        jTextField1.setText("");
        jTextField2.setText("");
        DefaultTableModel model = (DefaultTableModel) tb_client.getModel();
        int n = model.getRowCount();
        for (int i = n - 1; i >= 0; --i) {
            model.removeRow(i);
        }
    }
}
