package fr.epsi.b32324c2.jdbc;

import fr.epsi.b32324c2.jdbc.dal.FournisseurDao;
import fr.epsi.b32324c2.jdbc.dal.jdbc.FournisseurDaoJdbc;
import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.util.List;
import java.util.ResourceBundle;

public class TestDelete {
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

        FournisseurDao fournisseurDao = new FournisseurDaoJdbc();
        try {
            List<Fournisseur> f = fournisseurDao.extraire();
            Fournisseur fournisseur = f.get(f.size() - 1);
            fournisseurDao.delete(fournisseur);
        } catch (Exception e) {

        }
    }
}
