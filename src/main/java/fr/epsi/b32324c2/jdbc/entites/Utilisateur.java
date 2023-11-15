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
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        String sb = "Utilisateur{" + "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
        return sb;
    }
}