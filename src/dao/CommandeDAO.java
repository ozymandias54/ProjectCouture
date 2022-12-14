/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classe.Commande;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class CommandeDAO extends DAO<Commande>{
DateFormat format=new SimpleDateFormat("yyyy-MM-dd");

    @Override
    public Commande recherche(int id) {
     Commande cmd = new Commande();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from commande where id_commande="+id);
            if(result.next()){
                cmd.setId_commande(result.getInt("id_commande"));
                cmd.setNbreArticle(result.getInt("nbreArticle"));
                cmd.setAvance(result.getFloat("avance"));
                cmd.setReste(result.getFloat("reste"));
                cmd.setPrixTotal(result.getFloat("prixTotal"));
                cmd.setDepot(result.getDate("depot"));
                cmd.setRetrait(result.getDate("retrait"));
                cmd.setEtat(result.getBoolean("etat"));
                cmd.setId_client(result.getInt("id_client"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return cmd; 
    }
   public void insererVide(){
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement
        ("insert into commande(nbreArticle,avance,reste,prixTotal,etat) values(0,0,0,0,"+false+")");
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
    @Override
    public void inserer(Commande obj) {
         Date actuel=new Date();
        String date=format.format(actuel);
        String date_depot=date;
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement
            ("insert into commande(nbreArticle,avance,reste,prixTotal,id_client,etat,depot) values(?,?,?,?,?,?,'"+date_depot+"')");
            
            prepare.setInt(1,obj.getNbreArticle());
            prepare.setFloat(2,obj.getAvance());
            prepare.setFloat(3,obj.getReste());
            prepare.setFloat (4,obj.getPrixTotal());
            prepare.setInt(5,obj.getId_client());
            prepare.setBoolean(6, false);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }      }
 public void insererRetrait(int id){
     Date actuel=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String date=format.format(actuel);
        String date_retrait=date;
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("Update commande set retrait='"+date_retrait+"' where id_commande="+id  );
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 public void commandefini(int id){
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("Update commande set etat="+true+" where id_commande="+id  );
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 public Commande derniereCommande(){
     Commande cmd=new Commande();
        try {
            ResultSet result = this.connect.createStatement().executeQuery
                ("select *from commande where id_commande=(select max(id_commande) from commande)");
            while(result.next()){
            cmd.setId_commande(result.getInt("id_commande"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cmd;
 }
    @Override
    public void modifier(Commande obj, int id) {
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement
        ("Update commande set nbreArticle =?,id_client=?, prixTotal=?,avance=?,reste=?,etat=?,delai=? where id_commande="+id  );
             
            prepare.setInt(1,obj.getNbreArticle());
            prepare.setInt(2,obj.getId_client());
            prepare.setFloat(3,obj.getPrixTotal());
            prepare.setFloat (4,obj.getAvance());
            prepare.setFloat(5,obj.getReste());
            prepare.setBoolean(6,obj.isEtat());
            prepare.setString(7, format.format(obj.getDelai()));
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void supprimer(int id) {
try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("delete from commande where id_commande="+id);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public List<Commande> liste() {
      List<Commande>lc=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("select *from commande");
            while(result.next()){
                Commande cmd=new Commande();
                cmd.setId_commande(result.getInt("id_commande"));
                cmd.setNbreArticle(result.getInt("nbreArticle"));
                cmd.setAvance(result.getFloat("avance"));
                cmd.setReste(result.getFloat("reste"));
                cmd.setPrixTotal(result.getFloat("prixTotal"));
                cmd.setDepot(result.getDate("depot"));
                cmd.setRetrait(result.getDate("retrait"));
                cmd.setDelai(result.getDate("delai"));
                cmd.setEtat(result.getBoolean("etat"));
                cmd.setId_client(result.getInt("id_client"));
                lc.add(cmd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lc;       
    }
    
    public List<Commande> listeDaté() {
      List<Commande>lc=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("select count(*) as nbre,depot from commande group by depot");
            while(result.next()){
                Commande cmd=new Commande();
                cmd.setNbreArticle(result.getInt("nbre"));
                cmd.setDepot(result.getDate("depot"));
                lc.add(cmd);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lc;       
    }
}
