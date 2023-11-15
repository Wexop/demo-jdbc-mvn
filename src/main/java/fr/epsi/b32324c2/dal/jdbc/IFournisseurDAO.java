package fr.epsi.b32324c2.dal.jdbc;

import fr.epsi.b32324c2.metier.Fournisseur;

import java.sql.SQLException;
import java.util.List;

public interface IFournisseurDAO{
    void insert(Fournisseur fournisseur) throws Exception;
    boolean delete(Fournisseur fournisseur) throws Exception;
    List<Fournisseur> extraire() throws Exception;
    int update(String nouveauNom, int id) throws Exception;
}
