package classe;

public class Article {
    int id_article,id_commande,idModele;
    float tour_de_coup,largeur_epaule,longueur_bras,tour_de_bras,tour_de_poignet,torse,
            tour_de_taile,longueur_jambe,tour_de_cuisse,pied;
    String materiel,description,type;
    public Article() {
    }

    public Article(int id_commande, int idModele, float tour_de_coup, float largeur_epaule, float longueur_bras, float tour_de_bras, float tour_de_poignet, float torse, float tour_de_taile, float longueur_jambe, float tour_de_cuisse, float pied, String materiel, String description, String type) {
        this.id_commande = id_commande;
        this.idModele = idModele;
        this.tour_de_coup = tour_de_coup;
        this.largeur_epaule = largeur_epaule;
        this.longueur_bras = longueur_bras;
        this.tour_de_bras = tour_de_bras;
        this.tour_de_poignet = tour_de_poignet;
        this.torse = torse;
        this.tour_de_taile = tour_de_taile;
        this.longueur_jambe = longueur_jambe;
        this.tour_de_cuisse = tour_de_cuisse;
        this.pied = pied;
        this.materiel = materiel;
        this.description = description;
        this.type = type;
    }

    public Article(int id_article, int id_commande, int idModele, float tour_de_coup, float largeur_epaule, float longueur_bras, float tour_de_bras, float tour_de_poignet, float torse, float tour_de_taile, float longueur_jambe, float tour_de_cuisse, float pied, String materiel, String description, String type) {
        this.id_article = id_article;
        this.id_commande = id_commande;
        this.idModele = idModele;
        this.tour_de_coup = tour_de_coup;
        this.largeur_epaule = largeur_epaule;
        this.longueur_bras = longueur_bras;
        this.tour_de_bras = tour_de_bras;
        this.tour_de_poignet = tour_de_poignet;
        this.torse = torse;
        this.tour_de_taile = tour_de_taile;
        this.longueur_jambe = longueur_jambe;
        this.tour_de_cuisse = tour_de_cuisse;
        this.pied = pied;
        this.materiel = materiel;
        this.description = description;
        this.type = type;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public int getId_commande() {
        return id_commande;
    }

    public void setId_commande(int id_commande) {
        this.id_commande = id_commande;
    }

    public int getIdModele() {
        return idModele;
    }

    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }

    public float getPied() {
        return pied;
    }

    public void setPied(float pied) {
        this.pied = pied;
    }

    public float getTour_de_coup() {
        return tour_de_coup;
    }

    public void setTour_de_coup(float tour_de_coup) {
        this.tour_de_coup = tour_de_coup;
    }

    public float getLargeur_epaule() {
        return largeur_epaule;
    }

    public void setLargeur_epaule(float largeur_epaule) {
        this.largeur_epaule = largeur_epaule;
    }

    public float getLongueur_bras() {
        return longueur_bras;
    }

    public void setLongueur_bras(float longueur_bras) {
        this.longueur_bras = longueur_bras;
    }

    public float getTour_de_bras() {
        return tour_de_bras;
    }

    public void setTour_de_bras(float tour_de_bras) {
        this.tour_de_bras = tour_de_bras;
    }

    public float getTour_de_poignet() {
        return tour_de_poignet;
    }

    public void setTour_de_poignet(float tour_de_poignet) {
        this.tour_de_poignet = tour_de_poignet;
    }

    public float getTorse() {
        return torse;
    }

    public void setTorse(float torse) {
        this.torse = torse;
    }

    public float getTour_de_taile() {
        return tour_de_taile;
    }

    public void setTour_de_taile(float tour_de_taile) {
        this.tour_de_taile = tour_de_taile;
    }

    public float getLongueur_jambe() {
        return longueur_jambe;
    }

    public void setLongueur_jambe(float longueur_jambe) {
        this.longueur_jambe = longueur_jambe;
    }

    public float getTour_de_cuisse() {
        return tour_de_cuisse;
    }

    public void setTour_de_cuisse(float tour_de_cuise) {
        this.tour_de_cuisse = tour_de_cuise;
    }

    public String getMateriel() {
        return materiel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
