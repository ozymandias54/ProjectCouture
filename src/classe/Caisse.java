/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import java.util.Date;


public class Caisse {
    int idCaisse,idu;
    String type,libelle;
    float montant;
    Date date_operation;

    public Caisse() {
    }

    public Caisse(int idu, String type, String libelle, float montant) {
        this.idu = idu;
        this.type = type;
        this.libelle = libelle;
        this.montant = montant;
        this.date_operation = date_operation;
    }

    public Caisse(int idCaisse, int idu, String type, String libelle, float montant, Date date_operation) {
        this.idCaisse = idCaisse;
        this.idu = idu;
        this.type = type;
        this.libelle = libelle;
        this.montant = montant;
        this.date_operation = date_operation;
    }

    public int getIdCaisse() {
        return idCaisse;
    }

    public void setIdCaisse(int idc) {
        this.idCaisse = idc;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    public Date getDate_operation() {
        return date_operation;
    }

    public void setDate_operation(Date date_operation) {
        this.date_operation = date_operation;
    }
    
}
