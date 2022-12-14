/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

import java.util.Date;


public class Commande {
    int id_commande,nbreArticle,id_client;
   float prixTotal,avance,reste;
    Date depot,retrait,delai;
    boolean etat;
   
    public Commande() {
    }

    public Commande(int nbreArticle, int id_client, float prixTotal, float avance, float reste, boolean etat) {
        this.nbreArticle = nbreArticle;
        this.id_client = id_client;
        this.prixTotal = prixTotal;
        this.avance = avance;
        this.reste = reste;
        this.etat = etat;
    }
public Commande(int nbreArticle, int id_client, float prixTotal, float avance, float reste, boolean etat,Date delai) {
        this.nbreArticle = nbreArticle;
        this.id_client = id_client;
        this.prixTotal = prixTotal;
        this.avance = avance;
        this.reste = reste;
        this.etat = etat;
        this.delai=delai;
    }
    public Commande(int id_commande, int nbreArticle, float prixTotal, float avance, float reste) {
        this.id_commande = id_commande;
        this.nbreArticle = nbreArticle;
        this.prixTotal = prixTotal;
        this.avance = avance;
        this.reste = reste;
    }

    public boolean isEtat() {
        return etat;
    }

    public void setEtat(boolean etat) {
        this.etat = etat;
    }
    
 public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }
    
    public Date getDepot() {
        return depot;
    }

    public void setDepot(Date depot) {
        this.depot = depot;
    }

    public Date getRetrait() {
        return retrait;
    }

    public void setRetrait(Date retrait) {
        this.retrait = retrait;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getNbreArticle() {
        return nbreArticle;
    }

    public void setNbreArticle(int nbreArticle) {
        this.nbreArticle = nbreArticle;
    }

    public float getPrixTotal() {
        return prixTotal;
    }

    public void setPrixTotal(float prixTotal) {
        this.prixTotal = prixTotal;
    }

    public float getAvance() {
        return avance;
    }

    public void setAvance(float avance) {
        this.avance = avance;
    }

    public float getReste() {
        return reste;
    }

    public void setReste(float reste) {
        this.reste = reste;
    }

    public Date getDelai() {
        return delai;
    }

    public void setDelai(Date delai) {
        this.delai = delai;
    }
    
}
