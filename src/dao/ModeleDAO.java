/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classe.Client;
import classe.Modele;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fofana
 */
public class ModeleDAO extends DAO<Modele>{

    @Override
    public Modele recherche(int id) {
        Modele mode=new Modele();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from modele where idModele="+id);
            if(result.next()){
                mode.setIdModele(result.getInt("idModele"));
                mode.setNomModele(result.getString("nomModele"));
                mode.setType(result.getString("type"));
                mode.setImage(result.getBytes("image"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaisseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return mode;
    }

    @Override
    public void inserer(Modele obj) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void inserer(String nom,String image,String type) throws FileNotFoundException{
        File file = new File(image);
        FileInputStream input = new FileInputStream(file);
        
        try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("insert into modele (nomModele,image,type) values(?,?,?)");
           prepare.setString(1, nom);
           prepare.setBinaryStream(2,(InputStream)input,(int)file.length());
           prepare.setString(3, type);
           prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UtilisateurDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    @Override
    public void modifier(Modele obj, int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void supprimer(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public  List<Modele> liste() {
        List<Modele>lu=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("select *from modele where idModele !=1");
            while(result.next()){
                Modele mod=new Modele();
                mod.setIdModele(result.getInt("idModele"));
                mod.setNomModele(result.getString("nomModele"));
                mod.setType(result.getString("type"));
                mod.setImage(result.getBytes("image"));
                lu.add(mod);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ModeleDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return lu;   
    }
    
}
