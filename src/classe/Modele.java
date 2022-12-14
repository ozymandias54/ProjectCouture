/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classe;

/**
 *
 * @author fofana
 */
public class Modele {
    int idModele;
    String nomModele;
    byte[] image;
    String type;
    public Modele() {
    }

    public Modele(int idModele, String nomModele, byte[] image, String type) {
        this.idModele = idModele;
        this.nomModele = nomModele;
        this.image = image;
        this.type = type;
    }

    public Modele(String nomModele, byte[] image, String type) {
        this.nomModele = nomModele;
        this.image = image;
        this.type = type;
    }

    public int getIdModele() {
        return idModele;
    }

    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) {
        this.nomModele = nomModele;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
