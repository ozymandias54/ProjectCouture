/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

import java.util.Date;


public class Personnel {
    int idp;
   String CIN,nom,prenom,poste,telephone;
   Date date_naissance,date_embauche;
   boolean sexe;
   double salaire;

    public Personnel() {
    }

    public Personnel(String CIN, String nom, String prenom, String poste, String telephone, Date date_naissance, Date date_embauche, boolean sexe, double salaire) {
        this.CIN = CIN;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.telephone = telephone;
        this.date_naissance = date_naissance;
        this.date_embauche = date_embauche;
        this.sexe = sexe;
        this.salaire = salaire;
    }

    public Personnel(int idp, String CIN, String nom, String prenom, String poste, String telephone, Date date_naissance, Date date_embauche, boolean sexe, double salaire) {
        this.idp = idp;
        this.CIN = CIN;
        this.nom = nom;
        this.prenom = prenom;
        this.poste = poste;
        this.telephone = telephone;
        this.date_naissance = date_naissance;
        this.date_embauche = date_embauche;
        this.sexe = sexe;
        this.salaire = salaire;
    }
    

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }
    
    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public Date getDate_embauche() {
        return date_embauche;
    }

    public void setDate_embauche(Date date_embauche) {
        this.date_embauche = date_embauche;
    }

    public boolean isSexe() {
        return sexe;
    }

    public void setSexe(boolean sexe) {
        this.sexe = sexe;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }
   
}
