package classe;

public class Utilisateur {
    int idu,idp;
    String login, password, profil;

    public Utilisateur() {
    }

    public Utilisateur(String login, String password, String profil,int idp) {
        this.idp = idp;
        this.login = login;
        this.password = password;
        this.profil = profil;
    }

    public int getIdu() {
        return idu;
    }

    public void setIdu(int idu) {
        this.idu = idu;
    }

    public int getIdp() {
        return idp;
    }

    public void setIdp(int idp) {
        this.idp = idp;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public Utilisateur(int idu, String login, String password, String profil, int idp) {
        this.idu = idu;
        this.idp = idp;
        this.login = login;
        this.password = password;
        this.profil = profil;
    }

}
