/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;


import classe.Utilisateur;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Halidou
 */
public class UtilisateurDAO extends DAO<Utilisateur>{

    @Override
    public Utilisateur recherche(int id) {
       Utilisateur utilisateur = new Utilisateur();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from utilisateur where idu="+id);
            if(result.next()){
                utilisateur.setIdu(result.getInt("idu"));
                utilisateur.setLogin(result.getString("login"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setProfil(result.getString("Profil"));                
                utilisateur.setIdp(result.getInt("idp"));

            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return utilisateur;
    }

    @Override
    public void inserer(Utilisateur obj) {
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("insert into utilisateur(login,password,profil,idp) values(?,?,?,?)");
            
            prepare.setString(1,obj.getLogin());
            prepare.setString(2,obj.getPassword());
            prepare.setString(3,obj.getProfil());
            prepare.setInt (4,obj.getIdp());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }



    @Override
    public void modifier(Utilisateur obj, int id) {
       try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("Update utilisateur set login =?,password=?, profil=?,idp=? where idu="+id  );
             
            prepare.setString(1,obj.getLogin());
            prepare.setString(2,obj.getPassword());
            prepare.setString(3,obj.getProfil());
            prepare.setInt (4,obj.getIdp());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void supprimer(int id) {
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("delete from utilisateur where idu="+id);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Utilisateur> liste() {
          Utilisateur utilisateur = new Utilisateur();
         List<Utilisateur>lu=new ArrayList<>();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select *from utilisateur");
            while(result.next()){
                 utilisateur.setIdu(result.getInt("idu"));    
                utilisateur.setLogin(result.getString("login"));
                utilisateur.setPassword(result.getString("password"));
                utilisateur.setProfil(result.getString("Profil"));
                utilisateur.setIdp(result.getInt("idp"));
                lu.add(utilisateur);
                utilisateur = new Utilisateur();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return lu;
    }
    public Utilisateur recherche(String login,String password){
        
        Utilisateur utilisateur = null;
        try {
            ResultSet result = this.connect.createStatement().executeQuery("select *from utilisateur where login='"+login+"' and password='"+password+"'");
            if(result.next())
            {
            utilisateur = new Utilisateur();
            utilisateur.setIdu(result.getInt("idu"));
            utilisateur.setLogin(result.getString("login"));
            utilisateur.setPassword(result.getString("password"));
            utilisateur.setProfil(result.getString("Profil"));
            utilisateur.setIdp(result.getInt("idp"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return utilisateur;
    }
    }

  
    
    
