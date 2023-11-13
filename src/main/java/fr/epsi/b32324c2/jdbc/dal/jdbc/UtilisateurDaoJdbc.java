package fr.epsi.b32324c2.jdbc.dal.jdbc;

import fr.epsi.b32324c2.jdbc.dal.UtilisateurDAO;
import fr.epsi.b32324c2.jdbc.entites.Utilisateur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class UtilisateurDaoJdbc implements UtilisateurDAO {

    public final static String BDD_URL;
    public final static String USER;
    public final static String PASSWORD;

    public final static String selectQuery = "SELECT * FROM utilisateur WHERE LOGIN = '%s' AND PASSWORD = '%s'";

    static {
        ResourceBundle fichierConf = ResourceBundle.getBundle("databaseLocal");
        BDD_URL = fichierConf.getString("database.url");
        USER = fichierConf.getString("database.user");
        PASSWORD = fichierConf.getString("database.password");
    }

    @Override
    public Utilisateur login(String login, String psw) throws Exception {
        Utilisateur utilisateur = null;
        try (Connection cnx = DriverManager.getConnection(BDD_URL, USER, PASSWORD)) {
            System.out.println(cnx);
            Statement statement = cnx.createStatement();

            ResultSet resultSet = statement.executeQuery(selectQuery);

            if (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String identifiant = resultSet.getString("LOGIN");
                String password = resultSet.getString("PASSWORD");

                utilisateur = new Utilisateur(id, identifiant, password);
            }

        }
        return utilisateur;
    }
}
