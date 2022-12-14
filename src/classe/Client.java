/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classe;

public class Client {
    int id_client;
    int nbreArticle=0;
    String nom,contact;

    public Client() {
    }

    public Client(String nom, String contact) {
        this.nom = nom;
        this.contact = contact;
    }

    public Client(int nbreArticle, String nom, String contact) {
        this.nbreArticle = nbreArticle;
        this.nom = nom;
        this.contact = contact;
    }

    public Client(int id_client, int nbreArticle, String nom, String contact) {
        this.id_client = id_client;
        this.nbreArticle = nbreArticle;
        this.nom = nom;
        this.contact = contact;
    }

    public int getNbreArticle() {
        return nbreArticle;
    }

    public void setNbreArticle(int nbreArticle) {
        this.nbreArticle = nbreArticle;
    }

    public int getId_client() {
        return id_client;
    }

    public void setId_client(int id_client) {
        this.id_client = id_client;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
    public void incrementer(){
        this.nbreArticle++;
    }
}
