package fr.epsi.b32324c2.test;

import fr.epsi.b32324c2.dal.jdbc.FournisseurDAOJDBC;
import fr.epsi.b32324c2.dal.jdbc.IFournisseurDAO;
import fr.epsi.b32324c2.dal.jdbc.PersistenceManager;
import fr.epsi.b32324c2.metier.Fournisseur;

public class TestSelect {
    public static void main(String[] args)  {
        try {
            IFournisseurDAO dao = new FournisseurDAOJDBC();
            dao.extraire().forEach(System.out::println);
            PersistenceManager.closeConnection(PersistenceManager.getConnection());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
