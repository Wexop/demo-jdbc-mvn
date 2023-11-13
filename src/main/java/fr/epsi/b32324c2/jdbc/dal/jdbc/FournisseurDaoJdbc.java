package fr.epsi.b32324c2.jdbc.dal.jdbc;

import fr.epsi.b32324c2.jdbc.dal.FournisseurDao;
import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements FournisseurDao {

    public final static String BDD_URL;
    public final static String USER;
    public final static String PASSWORD;
    private static final String insertQuery = "INSERT INTO FOURNISSEUR ( NOM) VALUES ( '%s')";
    private static final String updateQuery = "UPDATE FOURNISSEUR SET NOM = '%s' where NOM = '%s'";
    private static final String deleteQuery = "DELETE FROM FOURNISSEUR WHERE ID = %s";
    private static final String selectQuery = "SELECT * FROM FOURNISSEUR";

    static {
        ResourceBundle fichierConf = ResourceBundle.getBundle("databaseLocal");
        BDD_URL = fichierConf.getString("database.url");
        USER = fichierConf.getString("database.user");
        PASSWORD = fichierConf.getString("database.password");
    }

    @Override
    public List<Fournisseur> extraire() throws Exception {
        try (Connection cnx = DriverManager.getConnection(BDD_URL, USER, PASSWORD)) {
            System.out.println(cnx);
            Statement statement = cnx.createStatement();

            ResultSet resultSet = statement.executeQuery(selectQuery);

            List<Fournisseur> list = new ArrayList<>();

            while (resultSet.next()) {
                list.add(new Fournisseur(resultSet.getInt("ID"), resultSet.getString("NOM")));
            }

            return list;
            
        }
    }

    @Override
    public void insert(Fournisseur fournisseur) throws Exception {
        try (Connection cnx = DriverManager.getConnection(BDD_URL, USER, PASSWORD)) {
            System.out.println(cnx);
            Statement statement = cnx.createStatement();

            statement.executeQuery(String.format(insertQuery, fournisseur.getName()));


        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) throws Exception {
        try (Connection cnx = DriverManager.getConnection(BDD_URL, USER, PASSWORD)) {
            System.out.println(cnx);
            Statement statement = cnx.createStatement();

            ResultSet resultSet = statement.executeQuery(String.format(updateQuery, nouveauNom, ancienNom));

            int indexTab = 0;

            while (resultSet.next()) {
                indexTab++;
            }

            return indexTab;


        }
    }

    @Override
    public boolean delete(Fournisseur fournisseur) throws Exception {

        try (Connection cnx = DriverManager.getConnection(BDD_URL, USER, PASSWORD)) {
            System.out.println(cnx);
            Statement statement = cnx.createStatement();

            ResultSet resultSet = statement.executeQuery(String.format(deleteQuery, fournisseur.getId()));

            return resultSet.next();
        }
    }
}
