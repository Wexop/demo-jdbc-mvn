package fr.epsi.b32324c2.test;

import fr.epsi.b32324c2.dal.jdbc.FournisseurDAOJDBC;
import fr.epsi.b32324c2.dal.jdbc.IFournisseurDAO;
import fr.epsi.b32324c2.dal.jdbc.PersistenceManager;

import java.sql.*;
import java.util.ResourceBundle;

public class TestUpdate {
    public static void main(String[] args) {
        IFournisseurDAO dao = new FournisseurDAOJDBC();
        String nouveauNom = "La Maison des peintures";
        int id = 1;
        int nb = 0;
        try {
            nb = dao.update(nouveauNom, id);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        //ResultSet resultSet = statement.executeQuery("UPDATE FOURNISSEUR SET NOM = 'La Maison des peintures' where ID = 4");
        System.out.println("Lignes modifiées : " + nb);

    }
}
