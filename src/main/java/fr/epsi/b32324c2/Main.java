package fr.epsi.b32324c2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class Main {


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


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

}