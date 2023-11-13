package fr.epsi.b32324c2.jdbc.dal;

import fr.epsi.b32324c2.jdbc.entites.Fournisseur;

import java.util.List;

public interface FournisseurDao {
    List<Fournisseur> extraire() throws Exception;

    void insert(Fournisseur fournisseur) throws Exception;

    int update(String ancienNom, String nouveauNom) throws Exception;

    boolean delete(Fournisseur fournisseur) throws Exception;
}
