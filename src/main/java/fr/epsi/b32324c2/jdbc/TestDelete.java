package fr.epsi.b32324c2.jdbc;

import fr.epsi.b32324c2.jdbc.dal.FournisseurDao;
import fr.epsi.b32324c2.jdbc.dal.jdbc.FournisseurDaoJdbc;
import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

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
            Fournisseur f = fournisseurDao.extraire().get(0);
            fournisseurDao.delete(f);
        } catch (Exception e) {

        }
    }
}
