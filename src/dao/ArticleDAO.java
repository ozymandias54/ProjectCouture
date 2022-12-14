/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classe.Article;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class ArticleDAO extends DAO<Article>{

    @Override
    public Article recherche(int id) {
        Article cmd = new Article();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from article where id_article="+id);
            if(result.next()){
                cmd.setId_article(result.getInt("id_article"));
                cmd.setId_commande(result.getInt("id_commande"));
                cmd.setIdModele(result.getInt("idModele"));
                cmd.setTour_de_coup(result.getFloat("tour_de_coup"));
                cmd.setLargeur_epaule(result.getFloat("largeur_epaule"));
                cmd.setLongueur_bras(result.getFloat("longueur_bras"));
                cmd.setTour_de_bras(result.getFloat("tour_de_bras"));
                cmd.setTour_de_poignet(result.getFloat("tour_de_poignet"));
                cmd.setTorse(result.getFloat("torse"));
                cmd.setTour_de_taile(result.getFloat("tour_de_taille"));
                cmd.setLongueur_jambe(result.getFloat("longueur_jambe"));
                cmd.setTour_de_cuisse(result.getFloat("tour_de_cuisse"));
                cmd.setPied(result.getFloat("pied"));
                cmd.setMateriel(result.getString("materiel"));
                cmd.setDescription(result.getString("description"));
                cmd.setType(result.getString("type"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return cmd;
    }

    @Override
    public void inserer(Article obj) {
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement
            ("insert into article(tour_de_coup,largeur_epaule,longueur_bras,tour_de_bras,tour_de_poignet,torse,tour_de_taille,longueur_jambe,tour_de_cuisse,pied,id_commande,materiel,description,type,idModele) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            
            prepare.setFloat(1,obj.getTour_de_coup());
            prepare.setFloat(2,obj.getLargeur_epaule());
            prepare.setFloat(3,obj.getLongueur_bras());
            prepare.setFloat (4,obj.getTour_de_bras());
            prepare.setFloat(5,obj.getTour_de_poignet());
            prepare.setFloat(6,obj.getTorse());
            prepare.setFloat(7,obj.getTour_de_taile());
            prepare.setFloat(8,obj.getLongueur_jambe());
            prepare.setFloat(9,obj.getTour_de_cuisse());
            prepare.setFloat(10,obj.getPied());
            prepare.setInt(11, obj.getId_commande());
            prepare.setString(12, obj.getMateriel());
            prepare.setString(13, obj.getDescription());
            prepare.setString(14, obj.getType());
            prepare.setInt(15, obj.getIdModele());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    public void insererListe(List<Article> obj,int id){
        for(int i=0;i<obj.size();i++){
            try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement
            ("insert into article(tour_de_coup,largeur_epaule,longueur_bras,tour_de_bras,tour_de_poignet,torse,tour_de_taille,longueur_jambe,tour_de_cuisse,pied,id_commande) values(?,?,?,?,?,?,?,?,?,?,?)");
            
            prepare.setFloat(1,obj.get(i).getTour_de_coup());
            prepare.setFloat(2,obj.get(i).getLargeur_epaule());
            prepare.setFloat(3,obj.get(i).getLongueur_bras());
            prepare.setFloat (4,obj.get(i).getTour_de_bras());
            prepare.setFloat(5,obj.get(i).getTour_de_poignet());
            prepare.setFloat(6,obj.get(i).getTorse());
            prepare.setFloat(7,obj.get(i).getTour_de_taile());
            prepare.setFloat(8,obj.get(i).getLongueur_jambe());
            prepare.setFloat(9,obj.get(i).getTour_de_cuisse());
            prepare.setFloat(10,obj.get(i).getPied());
            prepare.setInt(11,id);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
        }
    }
    @Override
    public void modifier(Article obj, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Article> liste() {
    List<Article>la=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("select *from article");
            while(result.next()){
                Article cmd=new Article();
                cmd.setId_article(result.getInt("id_article"));
                cmd.setId_commande(result.getInt("id_commande"));
                cmd.setIdModele(result.getInt("idModele"));
                cmd.setTour_de_coup(result.getFloat("tour_de_coup"));
                cmd.setLargeur_epaule(result.getFloat("largeur_epaule"));
                cmd.setLongueur_bras(result.getFloat("longueur_bras"));
                cmd.setTour_de_bras(result.getFloat("tour_de_bras"));
                cmd.setTour_de_poignet(result.getFloat("tour_de_poignet"));
                cmd.setTorse(result.getFloat("torse"));
                cmd.setTour_de_taile(result.getFloat("tour_de_taille"));
                cmd.setLongueur_jambe(result.getFloat("longueur_jambe"));
                cmd.setTour_de_cuisse(result.getFloat("tour_de_cuisse"));
                cmd.setPied(result.getFloat("pied"));
                cmd.setMateriel(result.getString("materiel"));
                cmd.setDescription(result.getString("description"));
                cmd.setType(result.getString("type"));
                la.add(cmd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return la;     
    }   
    
    public List<Article> listeArticle(int id) {
    List<Article> la=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("select *from article where id_commande="+id);
            while(result.next()){
                Article cmd=new Article();
                cmd.setId_article(result.getInt("id_article"));
                cmd.setId_commande(result.getInt("id_commande"));
                cmd.setIdModele(result.getInt("idModele"));
                cmd.setTour_de_coup(result.getFloat("tour_de_coup"));
                cmd.setLargeur_epaule(result.getFloat("largeur_epaule"));
                cmd.setLongueur_bras(result.getFloat("longueur_bras"));
                cmd.setTour_de_bras(result.getFloat("tour_de_bras"));
                cmd.setTour_de_poignet(result.getFloat("tour_de_poignet"));
                cmd.setTorse(result.getFloat("torse"));
                cmd.setTour_de_taile(result.getFloat("tour_de_taille"));
                cmd.setLongueur_jambe(result.getFloat("longueur_jambe"));
                cmd.setTour_de_cuisse(result.getFloat("tour_de_cuisse"));
                cmd.setPied(result.getFloat("pied"));
                cmd.setMateriel(result.getString("materiel"));
                cmd.setDescription(result.getString("description"));
                cmd.setType(result.getString("type"));
                la.add(cmd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ArticleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return la;     
    }   
}
