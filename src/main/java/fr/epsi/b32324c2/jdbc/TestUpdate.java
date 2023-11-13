package fr.epsi.b32324c2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class TestUpdate {
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
            System.out.println(cnx);
            Statement statement = cnx.createStatement();

            //ResultSet resultSet = statement.executeQuery("UPDATE FOURNISSEUR SET NOM = 'La Maison des peintures' where ID = 4");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM FOURNISSEUR");
            while (resultSet.next()) {
                System.out.println(resultSet.getInt("ID"));
                System.out.println(resultSet.getString("NOM"));
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
