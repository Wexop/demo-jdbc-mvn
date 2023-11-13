package fr.epsi.b32324c2.jdbc;

import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class TestSelect {

    public final static String BDD_URL;
    public final static String USER;
    public final static String PASSWORD;


    static {
        ResourceBundle fichierConf = ResourceBundle.getBundle("databaseLocal");
        BDD_URL = fichierConf.getString("database.url");
        USER = fichierConf.getString("database.user");
        PASSWORD = fichierConf.getString("database.password");
    }

    public static void main(String[] args) {


        try (Connection cnx = DriverManager.getConnection(BDD_URL, USER, PASSWORD)) {
            ArrayList<Fournisseur> fournisseursTab = new ArrayList<>();
            System.out.println(cnx);
            Statement statement = cnx.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM FOURNISSEUR");
            while (resultSet.next()) {
                int id = resultSet.getInt("ID");
                String name = resultSet.getString("NOM");
                Fournisseur f = new Fournisseur(id, name);
                fournisseursTab.add(f);
            }

            fournisseursTab.forEach(fournisseur -> {
                System.out.println(fournisseur.toString());
            });


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
