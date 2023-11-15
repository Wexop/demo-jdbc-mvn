package fr.epsi.b32324c2.dal.jdbc;

import fr.epsi.b32324c2.metier.Fournisseur;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static fr.epsi.b32324c2.Main.*;

public class FournisseurDAOJDBC implements IFournisseurDAO {

    private static final String INSERT_QUERY = "INSERT INTO fournisseur (NOM) VALUES (?)";
    private static final String DELETE_QUERY = "DELETE FROM fournisseur WHERE NOM = ?";
    private static final String EXTRACT_QUERY = "SELECT * FROM fournisseur";
    private static final String UPDATE_QUERY = "UPDATE fournisseur SET NOM = ? WHERE ID = ?";
    @Override
    public void insert(Fournisseur fournisseur) throws SQLException {
        try (Connection cnx = DriverManager.getConnection(BDD_URL, USER, PASSWORD);
             PreparedStatement st = cnx.prepareStatement(INSERT_QUERY)) {
            st.setString(1,fournisseur.getNom());
            st.executeUpdate();
        }

    }

    @Override
    public boolean delete(Fournisseur fournisseur) throws Exception {
        Connection cnx = PersistenceManager.getConnection();
        boolean result = false;
        try(PreparedStatement st = cnx.prepareStatement(DELETE_QUERY);){
            st.setString(1,fournisseur.getNom());
            result = st.execute();
        }
        return result;
    }

    @Override
    public List<Fournisseur> extraire() throws Exception{
        List<Fournisseur> fournisseurs = new ArrayList<>();
        Connection cnx = PersistenceManager.getConnection();
        try(PreparedStatement st = cnx.prepareStatement(EXTRACT_QUERY);
            ResultSet rs = st.executeQuery();) {
            while (rs.next()) {
                fournisseurs.add(new Fournisseur(rs.getString("nom"), rs.getInt("id")));
            }
        }
        return fournisseurs;
    }

    @Override
    public int update(String nouveauNom, int id) throws Exception {
        Connection cnx = PersistenceManager.getConnection();
        int nb = 0;
        try(PreparedStatement st = cnx.prepareStatement(UPDATE_QUERY);){
            st.setString(1,nouveauNom);
            st.setInt(2,id);
            nb = st.executeUpdate();
        }
        return nb;
    }
}