/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import classe.Caisse;
import classe.Personnel;
import classe.Utilisateur;
import classe_special.Confirm;
import classe_special.ScrollBar;
import dao.CaisseDAO;
import dao.PersonnelDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import menu.MenuButton;
import menu.MenuTitre;

/**
 *
 * @author fofana
 */
public class Secretaire extends javax.swing.JFrame {

    public Utilisateur user=new Utilisateur();
    /**
     * Creates new form Secretaire
     */
    public Secretaire() {
        initComponents();
        execute();
        caisse();
        bare.initJFram(this);
    }

      public void profil(){
        PersonnelDAO pdao = new PersonnelDAO();
        Personnel personnel = pdao.recherche(user.getIdp());
        lbUser.setText(personnel.getNom()+" "+personnel.getPrenom());
    }
    
   private void accueil(){
            Secretaire admin=new Secretaire();
            admin.user=this.user;
            admin.profil();
            this.dispose();
            admin.setVisible(true);
    }
   
   private void deconnect(){
       this.dispose();
       new Connexion().setVisible(true);
   }
      private void execute() {
        ImageIcon iconAccueil=new ImageIcon(getClass().getResource("/icon/menu/home.png"));
        ImageIcon iconEmployé=new ImageIcon(getClass().getResource("/icon/menu/employé.png"));
        ImageIcon iconModele=new ImageIcon(getClass().getResource("/icon/menu/modele.png"));
        ImageIcon iconDepot=new ImageIcon(getClass().getResource("/icon/menu/depot.png"));
        ImageIcon iconClient=new ImageIcon(getClass().getResource("/icon/menu/client.png"));
        ImageIcon iconCaisse=new ImageIcon(getClass().getResource("/icon/menu/caisse.png"));
        ImageIcon iconDeconnect=new ImageIcon(getClass().getResource("/icon/menu/deconnect.png"));
        
        MenuButton menuAccueil = new MenuButton(iconAccueil, "Accueil", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                accueil();
            }
        });
       
        MenuButton menuEmployé = new MenuButton(iconEmployé, "Employé", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PanelPersonnel p=new PanelPersonnel();
                p.acces();
                body.removeAll();
                body.add(p);
                body.repaint();
                body.revalidate();
            }
        });
         MenuButton menuModele = new MenuButton(iconModele, "Modele", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PanelModele p=new PanelModele();
                body.removeAll();
                body.add(p);
                body.repaint();
                body.revalidate();
            }
        });
        
        MenuButton menuDepot = new MenuButton(iconDepot, "Les depots", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PanelDepot p=new PanelDepot();
                p.accesSecretaire();
                body.removeAll();
                body.add(p);
                body.repaint();
                body.revalidate();
            }
        });
        MenuButton menuClient = new MenuButton(iconClient, "Client", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PanelClient p=new PanelClient();
                body.removeAll();
                body.add(p);
                body.repaint();
                body.revalidate();
            }
        });
        MenuButton menuCaisse = new MenuButton(iconCaisse, "Caisse", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PanelCaisse p=new PanelCaisse(user);
                p.acces();
                body.removeAll();
                body.add(p);
                body.repaint();
                body.revalidate();
            }
        });
        MenuButton menuDeconnect = new MenuButton(iconDeconnect, "Deconnection", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Confirm conf=new Confirm();
                conf.affiche("Deconnection","Etes-vous sur de vouloir deconncter", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                deconnect();
            }
        });
            }
        });
        
        MenuTitre main=new MenuTitre("HOME PRINCIPAL");
         MenuTitre donné=new MenuTitre("DONNÉES EMPLOYÉS");
         MenuTitre commande=new MenuTitre("COMMANDE");
         MenuTitre autre=new MenuTitre("AUTRE MENU");
         
        addMenutitre(main);addMenu(menuAccueil);
        addMenutitre(donné);addMenu(menuEmployé);
        addMenutitre(commande);addMenu(menuModele,menuDepot);
        addMenutitre(autre);addMenu(menuClient,menuCaisse,menuDeconnect);
       //addMenu(menuAccueil,menuUtilisateur,menuEmployé,menuCommande,menuDepot,menuClient,menuCaisse,menuDeconnect);
        
 menuAccueil.select();
menuEmployé.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuModele.deselect();
                menuClient.deselect();
                menuCaisse.deselect();
                menuDepot.deselect();
                menuAccueil.deselect();
                menuDeconnect.deselect();
            }
        });

menuClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEmployé.deselect();
                menuModele.deselect();
                menuCaisse.deselect();
                menuAccueil.deselect();
                menuDepot.deselect();
                menuDeconnect.deselect();
            }
        });
menuCaisse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEmployé.deselect();
                menuModele.deselect();
                menuClient.deselect();
                menuDepot.deselect();
                menuAccueil.deselect();
                menuDeconnect.deselect();
            }
        });
menuDepot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEmployé.deselect();
                menuModele.deselect();
                menuClient.deselect();
                menuAccueil.deselect();
                menuCaisse.deselect();
                menuDeconnect.deselect();
            }
        });
menuModele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEmployé.deselect();
                menuDepot.deselect();
                menuClient.deselect();
                menuCaisse.deselect();
                menuAccueil.deselect();
                menuDeconnect.deselect();
            }
        });

  }
      
    private void addMenu(MenuButton... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
        }
        menus.revalidate();
    }
    private void addMenutitre(MenuTitre... menu) {
        for (int i = 0; i < menu.length; i++) {
            menus.add(menu[i]);
        }
        menus.revalidate();
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
        panelMenu = new classe_special.PanelArrondi();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bare = new classe_special.BareTitre();
        scroll = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();
        entete1 = new javax.swing.JPanel();
        lbUser = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        body = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        carte4 = new classe_special.Carte();
        carte5 = new classe_special.Carte();
        carte6 = new classe_special.Carte();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logo.png"))); // NOI18N

        jLabel6.setFont(new java.awt.Font("Liberation Sans", 1, 22)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(153, 102, 255));
        jLabel6.setText("Sumar Creation");

        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBorder(null);
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.BLUE);
        scroll.getViewport().setBackground(Color.BLUE);
        scroll.setBackground(new java.awt.Color(51, 51, 255));

        menus.setBackground(new java.awt.Color(0, 0, 0, 0));
        menus.setLayout(new javax.swing.BoxLayout(menus, javax.swing.BoxLayout.Y_AXIS));
        scroll.setViewportView(menus);

        javax.swing.GroupLayout panelMenuLayout = new javax.swing.GroupLayout(panelMenu);
        panelMenu.setLayout(panelMenuLayout);
        panelMenuLayout.setHorizontalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelMenuLayout.createSequentialGroup()
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addComponent(bare, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelMenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(6, 6, 6))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(scroll, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        panelMenuLayout.setVerticalGroup(
            panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelMenuLayout.createSequentialGroup()
                .addComponent(bare, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
        );

        entete1.setBackground(new java.awt.Color(255, 255, 255));

        lbUser.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbUser.setForeground(new java.awt.Color(127, 127, 127));
        lbUser.setText("User Name");

        lbRole.setForeground(new java.awt.Color(127, 127, 127));
        lbRole.setText("Receptioniste");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login-user.png"))); // NOI18N

        javax.swing.GroupLayout entete1Layout = new javax.swing.GroupLayout(entete1);
        entete1.setLayout(entete1Layout);
        entete1Layout.setHorizontalGroup(
            entete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entete1Layout.createSequentialGroup()
                .addContainerGap(569, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(entete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbRole)
                    .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addGap(29, 29, 29))
        );
        entete1Layout.setVerticalGroup(
            entete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entete1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(entete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(entete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1)
                        .addGroup(entete1Layout.createSequentialGroup()
                            .addComponent(lbUser)
                            .addGap(18, 18, 18)
                            .addComponent(lbRole)))))
        );

        body.setLayout(new java.awt.GridLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Statistique");
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel7.setText("<html><body><u>Statistique</u></body></html>");
        jLabel7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel7MouseClicked(evt);
            }
        });

        carte4.setBackground(new java.awt.Color(0, 204, 204));

        carte5.setBackground(new java.awt.Color(51, 51, 51));

        carte6.setBackground(new java.awt.Color(204, 204, 0));

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/formations-couture.jpeg"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(carte4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(carte5, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(carte6, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carte5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carte4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carte6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 341, Short.MAX_VALUE))
        );

        body.add(jPanel3);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(entete1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(230, 230, 230)
                    .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(entete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(65, 65, 65)
                    .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel7MouseClicked
         new FrameStat().statistiquaCaisseEntrée();
    }//GEN-LAST:event_jLabel7MouseClicked

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
            java.util.logging.Logger.getLogger(Secretaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Secretaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Secretaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Secretaire.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Secretaire().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private classe_special.BareTitre bare;
    private javax.swing.JPanel body;
    private classe_special.Carte carte4;
    private classe_special.Carte carte5;
    private classe_special.Carte carte6;
    private javax.swing.JPanel entete1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPanel menus;
    private classe_special.PanelArrondi panelMenu;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables
float montant=0;float mEntre=0;float mSortie=0;

  private void caisse(){
    CaisseDAO pdao = new CaisseDAO();
        List<Caisse> css = pdao.liste();
        for (int i = 0; i < css.size(); i++) {
            montant+=css.get(i).getMontant();
            
            if(css.get(i).getType().equals("sortie")){
            mSortie+=css.get(i).getMontant();
            }
            else if(css.get(i).getType().equals("entrée")){
                mEntre+=css.get(i).getMontant();
            }
        }
       carte4.setData("Montant Total", ""+montant); 
       carte5.setData("Montant Entrée", ""+mEntre); 
       carte6.setData("Montant Sortie", ""+mSortie); 
  }
}
