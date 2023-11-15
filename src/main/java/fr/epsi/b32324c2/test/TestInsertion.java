package fr.epsi.b32324c2.test;

import fr.epsi.b32324c2.dal.jdbc.IFournisseurDAO;
import fr.epsi.b32324c2.dal.jdbc.FournisseurDAOJDBC;
import fr.epsi.b32324c2.metier.Fournisseur;

import java.util.ResourceBundle;

public class TestInsertion {
    public static void main(String[] args) {
        try {
            IFournisseurDAO dao = new FournisseurDAOJDBC();
            dao.insert(new Fournisseur("EPSI"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}
