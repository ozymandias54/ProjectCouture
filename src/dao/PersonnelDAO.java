package dao;

import classe.Personnel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author HP
 */
public class PersonnelDAO extends DAO<Personnel>{
SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
    @Override
    public Personnel recherche(int id) {
Personnel personnel = new Personnel();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from personnel where idp="+id);
            if(result.next()){
                personnel.setIdp(result.getInt("idp"));
                personnel.setCIN(result.getString("CIN"));
                personnel.setNom(result.getString("nom"));
                personnel.setPrenom(result.getString("prenom"));
                personnel.setPoste(result.getString("Poste"));                
                personnel.setTelephone(result.getString("telephone"));
                personnel.setDate_naissance(result.getDate("date_naissance"));
                personnel.setDate_embauche(result.getDate("date_embauche"));
                personnel.setSexe(result.getBoolean("sexe"));
                personnel.setSalaire(result.getFloat("salaire"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return personnel;    }

    @Override
    public void inserer(Personnel obj) {
    try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement
        ("insert into personnel(CIN,nom,prenom,poste,telephone,date_naissance,date_embauche,sexe,salaire) values(?,?,?,?,?,?,?,?,?)");
            
            prepare.setString(1,obj.getCIN());
            prepare.setString(2,obj.getNom());
            prepare.setString(3,obj.getPrenom());
            prepare.setString (4,obj.getPoste());
            prepare.setString (5,obj.getTelephone());
            prepare.setString(6,format.format(obj.getDate_naissance()));
            prepare.setString(7,format.format(obj.getDate_embauche()));
            prepare.setBoolean(8,obj.isSexe());
            prepare.setDouble(9,obj.getSalaire());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void modifier(Personnel obj, int id) {
try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement
        ("Update personnel set CIN =?,nom=?, prenom=?,poste=?, telephone=?,date_naissance=?,date_embauche=?,sexe=?,salaire=? where idp="+id  );
            prepare.setString(1,obj.getCIN());
            prepare.setString(2,obj.getNom());
            prepare.setString(3,obj.getPrenom());
            prepare.setString (4,obj.getPoste());
            prepare.setString (5,obj.getTelephone());
            prepare.setString(6,format.format(obj.getDate_naissance()));
            prepare.setString(7,format.format(obj.getDate_embauche()));
            prepare.setBoolean(8,obj.isSexe());
            prepare.setDouble(9,obj.getSalaire());
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }    }

    @Override
    public void supprimer(int id) {
try {
            PreparedStatement prepare = (PreparedStatement)this.connect.prepareStatement("delete from personnel where idp="+id);
            prepare.execute();
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    @Override
    public List<Personnel> liste() {
         List<Personnel>lu=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("select *from personnel");
            while(result.next()){
                Personnel personnel=new Personnel();
                personnel.setIdp(result.getInt("idp"));
                personnel.setCIN(result.getString("CIN"));
                personnel.setNom(result.getString("nom"));
                personnel.setPrenom(result.getString("prenom"));
                personnel.setPoste(result.getString("poste"));
                personnel.setTelephone(result.getString("telephone"));
                personnel.setDate_naissance(result.getDate("date_naissance"));
                personnel.setDate_embauche(result.getDate("date_embauche"));
                personnel.setSexe(result.getBoolean("sexe"));
                personnel.setSalaire(result.getDouble("salaire"));
                lu.add(personnel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return lu;    
    }
    
    public List<Personnel> listeCroissante() {
         List<Personnel>lu=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("select *from personnel order by nom");
            while(result.next()){
                Personnel personnel=new Personnel();
                personnel.setIdp(result.getInt("idp"));
                personnel.setCIN(result.getString("CIN"));
                personnel.setNom(result.getString("nom"));
                personnel.setPrenom(result.getString("prenom"));
                personnel.setPoste(result.getString("poste"));
                personnel.setTelephone(result.getString("telephone"));
                personnel.setDate_naissance(result.getDate("date_naissance"));
                personnel.setDate_embauche(result.getDate("date_embauche"));
                personnel.setSexe(result.getBoolean("sexe"));
                personnel.setSalaire(result.getDouble("salaire"));
                lu.add(personnel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return lu;    
    }
    
    public List<Personnel> listeDecroissante() {
         List<Personnel>lu=new ArrayList<>();
        try {
            ResultSet result = this.connect.createStatement().executeQuery("select *from personnel order by nom desc");
            while(result.next()){
                Personnel personnel=new Personnel();
                personnel.setIdp(result.getInt("idp"));
                personnel.setCIN(result.getString("CIN"));
                personnel.setNom(result.getString("nom"));
                personnel.setPrenom(result.getString("prenom"));
                personnel.setPoste(result.getString("poste"));
                personnel.setTelephone(result.getString("telephone"));
                personnel.setDate_naissance(result.getDate("date_naissance"));
                personnel.setDate_embauche(result.getDate("date_embauche"));
                personnel.setSexe(result.getBoolean("sexe"));
                personnel.setSalaire(result.getDouble("salaire"));
                lu.add(personnel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     return lu;    
    }
    
    public List<Personnel> recherche(String nom) {
      List<Personnel>lp=new ArrayList<>();
        try {
           
            ResultSet result = this.connect.createStatement().executeQuery("select * from personnel where nom like '%"+nom+"%' OR prenom like '%"+nom+"%'");
            while(result.next()){
                Personnel personnel=new Personnel();
                personnel.setIdp(result.getInt("idp"));
                personnel.setCIN(result.getString("CIN"));
                personnel.setNom(result.getString("nom"));
                personnel.setPrenom(result.getString("prenom"));
                personnel.setPoste(result.getString("Poste"));                
                personnel.setTelephone(result.getString("telephone"));
                personnel.setDate_naissance(result.getDate("date_naissance"));
                personnel.setDate_embauche(result.getDate("date_embauche"));
                personnel.setSexe(result.getBoolean("sexe"));
                personnel.setSalaire(result.getFloat("salaire"));
                lp.add(personnel);
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersonnelDAO.class.getName()).log(Level.SEVERE, null, ex);
        }     
        return lp;    }
 
    
}
