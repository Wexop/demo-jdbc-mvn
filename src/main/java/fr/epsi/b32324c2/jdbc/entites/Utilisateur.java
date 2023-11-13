package fr.epsi.b32324c2.jdbc.entites;

public class Utilisateur {
    private int id;
    private String login;
    private String password;

    public Utilisateur() {

    }

    public Utilisateur(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Utilisateur(int id, String login, String password) {
        this.login = login;
        this.password = password;
        this.id = id;
    }

}
