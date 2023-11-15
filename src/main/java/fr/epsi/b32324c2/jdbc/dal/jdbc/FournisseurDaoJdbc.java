package fr.epsi.b32324c2.jdbc.dal.jdbc;

import fr.epsi.b32324c2.jdbc.dal.FournisseurDao;
import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FournisseurDaoJdbc implements FournisseurDao {

    public final static String BDD_URL;
    public final static String USER;
    public final static String PASSWORD;
    private static final String insertQuery = "INSERT INTO FOURNISSEUR ( NOM) VALUES ( ?)";
    private static final String updateQuery = "UPDATE FOURNISSEUR SET NOM = ? where NOM = ?";
    private static final String deleteQuery = "DELETE FROM FOURNISSEUR WHERE ID = ?";
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
            PreparedStatement statement = cnx.prepareStatement(selectQuery);

            ResultSet resultSet = statement.executeQuery();

            List<Fournisseur> list = new ArrayList<>();

            while (resultSet.next()) {

                list.add(new Fournisseur(resultSet.getInt("ID"), resultSet.getString("NOM")));
            }

            resultSet.close();
            cnx.close();

            return list;

        }
    }

    @Override
    public void insert(Fournisseur fournisseur) throws Exception {
        try (Connection cnx = DriverManager.getConnection(BDD_URL, USER, PASSWORD)) {
            System.out.println(cnx);
            PreparedStatement statement = cnx.prepareStatement(insertQuery);
            statement.setString(1, fournisseur.getName());

            statement.executeQuery();

            cnx.close();

        }
    }

    @Override
    public int update(String ancienNom, String nouveauNom) throws Exception {
        try (Connection cnx = DriverManager.getConnection(BDD_URL, USER, PASSWORD)) {
            System.out.println(cnx);
            PreparedStatement statement = cnx.prepareStatement(updateQuery);

            statement.setString(1, nouveauNom);
            statement.setString(2, ancienNom);

            ResultSet resultSet = statement.executeQuery();

            int indexTab = 0;

            while (resultSet.next()) {
                indexTab++;
            }
            cnx.close();


            return indexTab;


        }
    }

    @Override
    public boolean delete(Fournisseur fournisseur) throws Exception {

        try (Connection cnx = DriverManager.getConnection(BDD_URL, USER, PASSWORD)) {
            System.out.println(cnx);
            PreparedStatement statement = cnx.prepareStatement(deleteQuery);

            statement.setInt(1, fournisseur.getId());

            ResultSet resultSet = statement.executeQuery();

            cnx.close();

            return resultSet.next();
        }
    }
}
