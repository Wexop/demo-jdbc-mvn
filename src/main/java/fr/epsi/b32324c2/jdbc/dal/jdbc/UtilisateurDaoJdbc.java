package fr.epsi.b32324c2.jdbc.dal.jdbc;

import fr.epsi.b32324c2.jdbc.dal.UtilisateurDAO;
import fr.epsi.b32324c2.jdbc.entites.Utilisateur;

import java.sql.*;
import java.util.ResourceBundle;

public class UtilisateurDaoJdbc implements UtilisateurDAO {

    public final static String BDD_URL;
    public final static String USER;
    public final static String PASSWORD;

    private static final String LOGIN_QUERY = "SELECT * FROM utilisateur WHERE LOGIN = '%s' AND PASSWORD = '%s'";
    private static final String SECURED_LOGIN_QUERY = "SELECT * FROM utilisateur WHERE LOGIN = ? AND PASSWORD = ?";

    static {
        ResourceBundle fichierConf = ResourceBundle.getBundle("databaseLocal");
        BDD_URL = fichierConf.getString("database.url");
        USER = fichierConf.getString("database.user");
        PASSWORD = fichierConf.getString("database.password");
    }

    @Override
    public Utilisateur login(String login, String pwd) throws SQLException {
        Utilisateur utilisateur = null;
        try (Connection cnx = DriverManager.getConnection(BDD_URL, USER, PASSWORD);
             Statement st = cnx.createStatement();
             ResultSet rs = st.executeQuery(String.format(LOGIN_QUERY, login, pwd))) {
            System.out.printf((LOGIN_QUERY) + "%n", login, pwd);
            if (rs.next()) {
                int id = rs.getInt("ID");
                String identifiant = rs.getString("LOGIN");
                String password = rs.getString("PASSWORD");
                utilisateur = new Utilisateur(id, identifiant, password);
            }
        }
        return utilisateur;
    }

    @Override
    public Utilisateur securedLogin(String login, String pwd) throws SQLException {
        Utilisateur utilisateur = null;
        try (Connection cnx = DriverManager.getConnection(BDD_URL, USER, PASSWORD);
             PreparedStatement pst = cnx.prepareStatement(SECURED_LOGIN_QUERY)) {
            pst.setString(1, login);
            pst.setString(2, pwd);
            System.out.println(pst);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    int id = rs.getInt("ID");
                    String identifiant = rs.getString("LOGIN");
                    String password = rs.getString("PASSWORD");
                    utilisateur = new Utilisateur(id, identifiant, password);
                }
            }
        }
        return utilisateur;
    }
}