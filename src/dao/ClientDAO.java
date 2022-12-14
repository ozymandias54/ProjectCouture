/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classe.Client;
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
public class ClientDAO extends DAO<Client>{

    @Override
    public Client recherche(int id) {
        Client clt = new Client();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from client where id_client="+id);
            if(result.next()){
             clt.setId_client(result.getInt("id_client"));
             clt.setNom(result.getString("nom"));
             clt.setContact(result.getString("contact")); 
             clt.setNbreArticle(result.getInt("nbreArticle"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return clt;    }

    @Override
    public void inserer(Client obj) {
try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("insert into client (nom,contact,nbreArticle) values(?,?,"+0+")");
            prepare.setString(1,obj.getNom());
            prepare.setString(2,obj.getContact());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void modifier(Client obj, int id) {
try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("Update client set nom=? ,contact=?,nbreArticle=? where id_client="+id );
            prepare.setString(1,obj.getNom());
            prepare.setString(2,obj.getContact());
            prepare.setInt (3,obj.getNbreArticle());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void supprimer(int id) {
     try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("delete from client where id_client="+id);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Client> liste() {
List<Client>lu=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("select *from client order by id_client desc");
            while(result.next()){
                Client clt=new Client();
                clt.setId_client(result.getInt("id_client"));
                clt.setNom(result.getString("nom"));
                clt.setContact(result.getString("contact"));
                clt.setNbreArticle(result.getInt("nbreArticle"));
                lu.add(clt);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return lu;       
    }
    public Client derniereClient(){
     Client cmd=new Client();
        try {
            ResultSet result = this.connect.createStatement().executeQuery
                ("select *from client where id_client=(select max(id_client) from client)");
            while(result.next()){
            cmd.setId_client(result.getInt("id_client"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cmd;
 }
 public void nbreArticle(int id){
     
     int nbre=0;
        try {
            ResultSet result = this.connect.createStatement().executeQuery
                        ("select nbreArticle from commande where id_client="+id);
            while(result.next()){
                nbre+=result.getInt("nbreArticle");
            }
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement
                  ("Update client set nbreArticle="+nbre+" where id_client="+id );
        } catch (SQLException ex) {
            Logger.getLogger(ClientDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
 }
 
}
