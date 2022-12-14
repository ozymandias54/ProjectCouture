/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import classe.Commande;
import classe.Personnel;
import classe.Utilisateur;
import classe_special.Confirm;
import classe_special.ScrollBar;
import dao.CommandeDAO;
import dao.PersonnelDAO;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.ImageIcon;
import menu.MenuButton;
import menu.MenuTitre;

public class Administrateur extends javax.swing.JFrame {

    public Utilisateur user=new Utilisateur();
   
    public Administrateur() {
        initComponents();
        bare.initJFram(this);
        execute();
        listeCarte();
    }
    
    public void profil(){
        PersonnelDAO pdao = new PersonnelDAO();
        Personnel personnel = pdao.recherche(user.getIdp());
        lbUser.setText(personnel.getNom()+" "+personnel.getPrenom());
    }
    
   private void accueil(){
           Administrateur admin=new Administrateur();
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
        ImageIcon iconUtilisateur=new ImageIcon(getClass().getResource("/icon/menu/user.png"));
        ImageIcon iconEmployé=new ImageIcon(getClass().getResource("/icon/menu/employé.png"));
        ImageIcon iconModele=new ImageIcon(getClass().getResource("/icon/menu/modele.png"));
        ImageIcon iconCommande=new ImageIcon(getClass().getResource("/icon/menu/scissor.png"));
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
        MenuButton menuUtilisateur = new MenuButton(iconUtilisateur, "Utilisateurs", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PanelUtilisateur p=new PanelUtilisateur();
                panelBody.removeAll();
                panelBody.add(p);
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuButton menuEmployé = new MenuButton(iconEmployé, "Employé", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PanelPersonnel p=new PanelPersonnel();
                panelBody.removeAll();
                panelBody.add(p);
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
         MenuButton menuModele = new MenuButton(iconModele, "Modele", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PanelModele p=new PanelModele();
                panelBody.removeAll();
                panelBody.add(p);
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuButton menuCommande = new MenuButton(iconCommande, "Commande", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PanelMesure p=new PanelMesure(user);
                panelBody.removeAll();
                panelBody.add(p);
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuButton menuDepot = new MenuButton(iconDepot, "Les depots", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PanelDepot p=new PanelDepot();
                panelBody.removeAll();
                panelBody.add(p);
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuButton menuClient = new MenuButton(iconClient, "Client", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PanelClient p=new PanelClient();
                panelBody.removeAll();
                panelBody.add(p);
                panelBody.repaint();
                panelBody.revalidate();
            }
        });
        MenuButton menuCaisse = new MenuButton(iconCaisse, "Caisse", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                PanelCaisse p=new PanelCaisse(user);
                panelBody.removeAll();
                panelBody.add(p);
                panelBody.repaint();
                panelBody.revalidate();
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
        addMenutitre(donné);addMenu(menuUtilisateur,menuEmployé);
        addMenutitre(commande);addMenu(menuModele,menuCommande,menuDepot);
        addMenutitre(autre);addMenu(menuClient,menuCaisse,menuDeconnect);
       //addMenu(menuAccueil,menuUtilisateur,menuEmployé,menuCommande,menuDepot,menuClient,menuCaisse,menuDeconnect);
        
menuUtilisateur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuEmployé.deselect();
                menuCommande.deselect();
                menuModele.deselect();
                menuClient.deselect();
                menuCaisse.deselect();
                menuDepot.deselect();
                menuDeconnect.deselect();
            }
        });
menuEmployé.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuUtilisateur.deselect();
                menuCommande.deselect();
                menuModele.deselect();
                menuClient.deselect();
                menuCaisse.deselect();
                menuDepot.deselect();
                menuDeconnect.deselect();
            }
        });
menuCommande.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               menuUtilisateur.deselect();
                menuEmployé.deselect();
                menuClient.deselect();
                menuModele.deselect();
                menuCaisse.deselect();
                menuDepot.deselect();
                menuDeconnect.deselect();
            }
        });
menuClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               menuUtilisateur.deselect();
                menuEmployé.deselect();
                menuCommande.deselect();
                menuModele.deselect();
                menuCaisse.deselect();
                menuDepot.deselect();
                menuDeconnect.deselect();
            }
        });
menuCaisse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               menuUtilisateur.deselect();
                menuEmployé.deselect();
                menuModele.deselect();
                menuCommande.deselect();
                menuClient.deselect();
                menuDepot.deselect();
                menuDeconnect.deselect();
            }
        });
menuDepot.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               menuUtilisateur.deselect();
                menuEmployé.deselect();
                menuModele.deselect();
                menuCommande.deselect();
                menuClient.deselect();
                menuCaisse.deselect();
                menuDeconnect.deselect();
            }
        });
menuModele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
               menuUtilisateur.deselect();
                menuEmployé.deselect();
                menuDepot.deselect();
                menuCommande.deselect();
                menuClient.deselect();
                menuCaisse.deselect();
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        entete1 = new javax.swing.JPanel();
        lbUser = new javax.swing.JLabel();
        lbRole = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        panelBody = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        labelImage3 = new classe_special.LabelImage();
        carte1 = new classe_special.Carte();
        carte2 = new classe_special.Carte();
        carte3 = new classe_special.Carte();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jSeparator2 = new javax.swing.JSeparator();
        panelMenu = new classe_special.PanelArrondi();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        bare = new classe_special.BareTitre();
        scroll = new javax.swing.JScrollPane();
        menus = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Admnistrateur");
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        entete1.setBackground(new java.awt.Color(255, 255, 255));

        lbUser.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        lbUser.setForeground(new java.awt.Color(127, 127, 127));
        lbUser.setText("User Name");

        lbRole.setForeground(new java.awt.Color(127, 127, 127));
        lbRole.setText("Admin");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/login-user.png"))); // NOI18N

        javax.swing.GroupLayout entete1Layout = new javax.swing.GroupLayout(entete1);
        entete1.setLayout(entete1Layout);
        entete1Layout.setHorizontalGroup(
            entete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(entete1Layout.createSequentialGroup()
                .addContainerGap(677, Short.MAX_VALUE)
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
                .addContainerGap()
                .addGroup(entete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(entete1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jSeparator1)
                        .addGroup(entete1Layout.createSequentialGroup()
                            .addComponent(lbUser)
                            .addGap(18, 18, 18)
                            .addComponent(lbRole))))
                .addGap(0, 16, Short.MAX_VALUE))
        );

        panelBody.setLayout(new java.awt.GridLayout(1, 0));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("journal de la caisse");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.setText("<html><body><u>journal de la caisse</u></body></html>");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });

        labelImage3.setImage(new javax.swing.ImageIcon(getClass().getResource("/icon/metier-couturier-2-630x355-1.jpg"))); // NOI18N
        labelImage3.setImageSize(new java.awt.Dimension(574, 318));

        carte1.setBackground(new java.awt.Color(51, 51, 255));

        carte2.setBackground(new java.awt.Color(153, 0, 255));

        carte3.setBackground(new java.awt.Color(204, 204, 0));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Haute horlogerie, joaillerie, vins et alcools, design, \nautomobile, mode bien sûr : les « industries du luxe » \nrecouvrent des secteurs extrêmement divers dont le \npoint commun n’est pas le contenu mais le \npositionnement. Comme l’expliquent J.-N. Kapferer\n et V. Bastien dans leur ouvrage de référence,\n Luxe oblige1, le luxe est un segment de marché, \nà distinguer notamment du « haut de gamme » \nou du « premium » avec lesquels on le confond \nparfois.\n\n2La question de la spécificité du luxe se pose \naussi d’un point de vue linguistique : est-ce qu’il \nexiste une langue propre au luxe ? Je me suis\n penchée très concrètement sur le sujet à\n l’occasion de missions un peu particulières, \nque j’ai menées dans le cadre de défilés de\n Haute Couture pour une célèbre maison italienne. \nQu’en est-il, donc, dans le domaine de la mode : \nexiste-t-il des codes linguistiques propres à la\n Haute Couture ?");
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(labelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, 588, Short.MAX_VALUE)
                                .addGap(11, 11, 11))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(carte1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addComponent(carte2, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(carte3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE))
                        .addGap(19, 19, 19))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(carte2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carte1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(carte3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelImage3, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)))
        );

        panelBody.add(jPanel2);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scroll))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(panelMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jSeparator2)
                        .addContainerGap())))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addGap(0, 227, Short.MAX_VALUE)
                    .addComponent(entete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(panelBody, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addComponent(entete1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 518, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       new FrameStat().statistiquaCaisseEntrée();
    }//GEN-LAST:event_jLabel4MouseClicked

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
            java.util.logging.Logger.getLogger(Administrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Administrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Administrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Administrateur.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Administrateur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private classe_special.BareTitre bare;
    private classe_special.Carte carte1;
    private classe_special.Carte carte2;
    private classe_special.Carte carte3;
    private javax.swing.JPanel entete1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea1;
    private classe_special.LabelImage labelImage3;
    private javax.swing.JLabel lbRole;
    private javax.swing.JLabel lbUser;
    private javax.swing.JPanel menus;
    private javax.swing.JPanel panelBody;
    private classe_special.PanelArrondi panelMenu;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

int encours= 0; int fini=0; int retiré=0;
private void listeCarte(){
    
    CommandeDAO cdao = new CommandeDAO();
    List<Commande> cmd = cdao.liste();
    carte1.setData("Depot total", ""+cmd.size());
    
    for (int i = 0; i < cmd.size(); i++) {
        if(cmd.get(i).isEtat()==false){
            encours++;
        }
        else if(cmd.get(i).getRetrait()==null){
            fini++;
        }
        else{
            retiré++;
        }
        
    }
    int c=fini+retiré;
    carte2.setData("Commande en cours", ""+encours);
    carte3.setData("Commande fini", ""+c);
  }
}
