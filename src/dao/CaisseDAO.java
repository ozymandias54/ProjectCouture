/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import classe.Caisse;
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
public class CaisseDAO extends DAO<Caisse> {

    @Override
    public Caisse recherche(int id) {
       Caisse css = new Caisse();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from caisse where idCaisse="+id);
            if(result.next()){
                css.setIdCaisse(result.getInt("idCaisse"));
                css.setIdu(result.getInt("idCaisse"));
                css.setLibelle(result.getString("libelle"));
                css.setMontant(result.getFloat("montant"));
                css.setType(result.getString("type"));
                css.setDate_operation(result.getDate("date_operation"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(CaisseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return css;    
    }

    @Override
    public void inserer(Caisse obj) {
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Date actuel=new Date();
        String date=format.format(actuel);
        String date_depot=date;   
       try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement
            ("insert into caisse(type,libelle,montant,idu,date_operation) values(?,?,?,?,'"+date_depot+"')");
            
            prepare.setString(1,obj.getType());
            prepare.setString(2,obj.getLibelle());
            prepare.setFloat(3,obj.getMontant());
            prepare.setInt(4,obj.getIdu());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CaisseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public void modifier(Caisse obj, int id) {
try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("Update caisse set type =?,libelle=?, montant=? ,idu=? where idCaisse="+id  );
             
            prepare.setString(1,obj.getType());
            prepare.setString(2,obj.getLibelle());
            prepare.setFloat(3,obj.getMontant());
            prepare.setInt(4,obj.getIdu());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(CaisseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void supprimer(int id) {
try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("delete from caisse where idCaisse="+id);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public List<Caisse> liste() {
     List<Caisse>lc=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("select *from caisse");
            while(result.next()){
                Caisse css=new Caisse();
                css.setIdCaisse(result.getInt("idCaisse"));
                css.setIdu(result.getInt("idu"));
                css.setLibelle(result.getString("libelle"));
                css.setMontant(result.getFloat("montant"));
                css.setType(result.getString("type"));
                css.setDate_operation(result.getDate("date_operation"));
                lc.add(css);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lc;
    }
    public List<Caisse> listeDate(String type) {
     List<Caisse>lc=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("select SUM(montant) as som,date_operation from caisse where type='"+type+"' group by date_operation");
            while(result.next()){
                
                Caisse css=new Caisse();
                css.setMontant(result.getFloat("som"));
                css.setDate_operation(result.getDate("date_operation"));
                lc.add(css);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CommandeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return lc;
    }
  
}
