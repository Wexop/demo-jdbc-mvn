package fr.epsi.b32324c2.metier;

public class Fournisseur {
    private String nom;
    private int id;


    public Fournisseur() {
    }

    public Fournisseur(String nom) {
        this.nom = nom;
    }

    public Fournisseur(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Fournisseur{" +
                "nom='" + nom + '\'' +
                ", id=" + id +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
